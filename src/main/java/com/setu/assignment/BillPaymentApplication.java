package com.setu.assignment;

import ch.qos.logback.classic.Level;
import com.setu.assignment.filter.AuthenticatorFilter;
import com.setu.assignment.conf.BillPaymentConfiguration;
import com.setu.assignment.exception.BillPaymentExceptionMapper;
import com.setu.assignment.exception.JsonExceptionMapper;
import com.setu.assignment.filter.NotFoundResponseFilter;
import com.setu.assignment.resources.BillPaymentResource;
import com.setu.assignment.service.BillPaymentService;
import com.setu.assignment.util.Constants;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

import javax.sql.DataSource;

public class BillPaymentApplication extends Application<BillPaymentConfiguration> {
    public static void main(String[] args) throws Exception {
        new BillPaymentApplication().run(args);
    }

    public void run(BillPaymentConfiguration configuration, Environment environment) {
        // Datasource Configuration
        DataSource dataSource = configuration.getDataSourceFactory().build(environment.metrics(), Constants.SQL);
        DBI dbi = new DBI(dataSource);

        environment.jersey().register(new BillPaymentResource(dbi.onDemand(BillPaymentService.class)));

        // Authentication Registration
        environment.jersey().register(AuthenticatorFilter.class);

        // Exception Mapper Registration
        environment.jersey().register(new JsonExceptionMapper());
        environment.jersey().register(new BillPaymentExceptionMapper());
        environment.jersey().register(new NotFoundResponseFilter());
    }

    @Override
    protected Level bootstrapLogLevel() {
        return Level.ALL;
    }

    @Override
    public String getName() {
        return Constants.BILL_PAYMENT_SERVICE;
    }
}
