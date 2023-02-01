package com.springsimplespasos.conceptosbasicos.usoproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:foo.properties")
public class ReadFooProperties {
    @Value("${app.foo.client}")
    private String clientURL;
    @Value("${app.foo.customer:/app-foo/customer/home}")
    private String customerUrl;

    public String getClientURL() {
        return clientURL;
    }

    public String getCustomerUrl() {
        return customerUrl;
    }
}
