package apache.camel.uploaddemo.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;


public class ConfigurationRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        getContext().setUseMDCLogging(true);
        Long maxSize = 2L * 1024 * 1024;
        restConfiguration().component("netty4-http").contextPath("/rest/")
                .host("localhost")
                .port("8080")
                .endpointProperty("chunkedMaxContentLength", maxSize.toString())
                .bindingMode(RestBindingMode.auto);
    }
}
