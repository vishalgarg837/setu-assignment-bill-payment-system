package com.setu.assignment.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.setu.assignment.model.ErrorResponse;
import com.setu.assignment.model.StatusCodes;
import com.setu.assignment.util.Constants;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class JsonExceptionMapper implements ExceptionMapper<JsonProcessingException> {
    @Override
    public Response toResponse(JsonProcessingException exception) {
        return Response.status(Response.Status.BAD_REQUEST.getStatusCode())
                .entity(new ErrorResponse(StatusCodes.ERROR, Constants.INVALID_API_PARAMETERS).toString())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
