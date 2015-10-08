package com.wyldbook.scout.app;

import com.wyldbook.scout.search.web.SearchController;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ScoutApplication extends Application<ScoutConfiguration> {


    public static void main(String[] args) throws Exception {
        InputStream scoutAscii = Thread.currentThread().getContextClassLoader().getResourceAsStream("scout-ascii");
        System.out.println(new String(readFully(scoutAscii)));
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

    public static String readFully(InputStream var1) throws IOException {
        ByteArrayOutputStream var2 = new ByteArrayOutputStream();
        byte[] var3 = new byte[1024];
        boolean var4 = false;

        int var5;
        while((var5 = var1.read(var3)) != -1) {
            var2.write(var3, 0, var5);
        }

        var2.close();
        return new String(var2.toByteArray());
    }
}
