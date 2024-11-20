package ma.rest.spring.config;

import lombok.AllArgsConstructor;
import ma.rest.spring.ws.CompteSoapService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jws.WebMethod;

@Configuration
@AllArgsConstructor
public class CxfConfig {
    private CompteSoapService compteSoapService;
    private Bus bus;

    @Bean
    public EndpointImpl endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, compteSoapService);
        endpoint.publish("/ws");
        return endpoint;
    }
}
