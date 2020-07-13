package com.setu.assignment.filter;


import com.setu.assignment.exception.UnauthorizedException;
import com.setu.assignment.model.ErrorResponse;
import com.setu.assignment.model.StatusCodes;
import com.setu.assignment.util.Constants;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;

public class AuthenticatorFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext context) {
        String apiKey = extractParam(context, Constants.API_KEY_HEADER);

        if (StringUtils.isEmpty(apiKey) || !authenticate(apiKey)) {
            throw new UnauthorizedException(
                    Response.Status.FORBIDDEN.getStatusCode(),
                    new ErrorResponse(StatusCodes.ERROR, Constants.AUTH_ERROR).toString());
        }
    }


    private static String extractParam(ContainerRequestContext context, String apiKeyHeader) {
        return context.getHeaderString(apiKeyHeader);
    }

    private static boolean authenticate(String apiKey) {
        return Constants.API_KEY.equals(apiKey);
    }
}
