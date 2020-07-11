package com.setu.assignment.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class BillPaymentExceptionMapper implements ExceptionMapper<BillPaymentException> {
    @Override
    public Response toResponse(BillPaymentException exception) {
        return Response.status(exception.getCode())
                .entity(exception.getMessage())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
