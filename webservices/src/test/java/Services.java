import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import resources.BookResource;
import resources.LoanResource;
import resources.PersonResource;

import java.io.IOException;

public class Services {
    public static void main(String[] args) throws IOException {
        JAXRSServerFactoryBean serverFactory = new JAXRSServerFactoryBean();
        serverFactory.setResourceClasses(BookResource.class, PersonResource.class, LoanResource.class);
        serverFactory.setAddress("http://localhost:8081");
        serverFactory.setProvider(new JacksonJaxbJsonProvider());

        Server server = serverFactory.create();
        System.in.read();
        server.destroy();
    }
}
