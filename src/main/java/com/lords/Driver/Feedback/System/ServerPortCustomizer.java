package com.lords.Driver.Feedback.System;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

@Component
public class ServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        String port = System.getenv("PORT");
        if (port != null && !port.isEmpty()) {
            factory.setPort(Integer.parseInt(port));
        } else {
            factory.setPort(8080); // Default port if PORT env variable is not set
        }
    }
}
