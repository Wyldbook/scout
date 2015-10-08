package com.wyldbook.scout.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class ScoutConfiguration extends Configuration {
    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;

    public SwaggerBundleConfiguration swaggerBundleConfiguration() {
        return swaggerBundleConfiguration;
    }
}
