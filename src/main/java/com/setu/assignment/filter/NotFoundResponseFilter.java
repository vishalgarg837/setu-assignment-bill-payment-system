package com.setu.assignment.filter;

import com.setu.assignment.model.ErrorResponse;
import com.setu.assignment.model.StatusCodes;
import com.setu.assignment.util.Constants;
import io.dropwizard.jersey.errors.ErrorMessage;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;

public class NotFoundResponseFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        if (responseContext.getStatus() == Response.Status.NOT_FOUND.getStatusCode()
                && responseContext.getEntity() instanceof ErrorMessage) {
            responseContext.setEntity(new ErrorResponse(StatusCodes.ERROR, Constants.PATH_NOT_FOUND).toString());
        }
    }
}