package com.wyldbook.scout.app;

import com.wyldbook.scout.search.web.SearchController;
import com.wyldbook.scout.utils.serialization.IOUtils;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class ScoutApplication extends Application<ScoutConfiguration> {


    public static void main(String[] args) throws Exception {
        System.out.println(IOUtils.readAsString("scout-ascii"));
        new ScoutApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<ScoutConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<ScoutConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(ScoutConfiguration configuration) {
                return configuration.swaggerBundleConfiguration();
            }
        });
    }

    @Override
    public void run(ScoutConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(SearchController.class);
    }
}
