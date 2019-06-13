package com.aa;

import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;

@Configuration
public class CorrelationAppConfiguration {

    @Bean
    ClientHttpRequestInterceptor correlationIdPropagationInterceptor() {
        return (request, bytes, execution) -> {
            request.getHeaders().set(Constants.CORRELATION_ID, MDC.get(Constants.CORRELATION_ID));
            return execution.execute(request, bytes);
        };
    }

    @Bean
    public RequestCorrelationIdFilter requestCorrelationIdFilter() {
        return new RequestCorrelationIdFilter();
    }

}
