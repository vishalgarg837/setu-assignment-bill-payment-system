package com.setu.assignment.resources;

import com.codahale.metrics.annotation.Timed;
import com.setu.assignment.exception.AmountMismatchException;
import com.setu.assignment.exception.CustomerNotFoundException;
import com.setu.assignment.exception.InvalidApiParameters;
import com.setu.assignment.exception.InvalidRefIdException;
import com.setu.assignment.model.PaymentAck;
import com.setu.assignment.model.*;
import com.setu.assignment.service.BillPaymentService;
import com.setu.assignment.util.Constants;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1")
@Produces(MediaType.APPLICATION_JSON)
public class BillPaymentResource {
    private BillPaymentService billPaymentService;

    public BillPaymentResource(BillPaymentService billPaymentService) {
        this.billPaymentService = billPaymentService;
    }

    @POST
    @Timed
    @Path("/fetch-bill")
    public Representation<BillData> fetchBill(BillFetchRequest request) {
        if (request == null || StringUtils.isEmpty(request.getMobileNumber())) {
            throw new InvalidApiParameters(
                    Response.Status.BAD_REQUEST.getStatusCode(),
                    new ErrorResponse(StatusCodes.ERROR, Constants.INVALID_API_PARAMETERS).toString());
        }

        BillData billData = billPaymentService.fetchBill(request.getMobileNumber());

        if (billData == null) {
            throw new CustomerNotFoundException(
                    Response.Status.NOT_FOUND.getStatusCode(),
                    new ErrorResponse(StatusCodes.ERROR, Constants.CUSTOMER_NOT_FOUND).toString());
        }

        return new Representation<>(StatusCodes.SUCCESS, billData);
    }

    @POST
    @Timed
    @Path("/payment-update")
    public Representation<PaymentAck> updatePayment(PaymentUpdateRequest request) {
        if (request == null
                || request.getTransaction() == null
                || StringUtils.isEmpty(request.getRefID())
                || StringUtils.isEmpty(request.getTransaction().getId())
                || StringUtils.isEmpty(request.getTransaction().getAmountPaid())
                || request.getTransaction().getDate() == null) {
            throw new InvalidApiParameters(
                    Response.Status.BAD_REQUEST.getStatusCode(),
                    new ErrorResponse(StatusCodes.ERROR, Constants.INVALID_API_PARAMETERS).toString());
        }

        String ackId;
        try {
            ackId = billPaymentService.updatePayment(request);
        } catch (AmountMismatchException e) {
            throw new AmountMismatchException(
                    Response.Status.BAD_REQUEST.getStatusCode(),
                    new ErrorResponse(StatusCodes.ERROR, Constants.AMOUNT_MISMATCH).toString());
        } catch (InvalidRefIdException e) {
            throw new InvalidRefIdException(
                    Response.Status.NOT_FOUND.getStatusCode(),
                    new ErrorResponse(StatusCodes.ERROR, Constants.INVALID_REF_ID).toString());
        }

        return new Representation<>(StatusCodes.SUCCESS, new PaymentAck(ackId));
    }
}
