package pe.company.converter;

import com.company.webservice.Client;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pe.company.bean.response.ClientResponse;

import java.util.UUID;

@Component
public class ClientConverter implements Converter<Client, ClientResponse> {
    @Override
    public ClientResponse convert(Client source) {
        ClientResponse target = new ClientResponse();
        target.setName(source.getLastname());
        target.setClientId(source.getClientId());
        target.setLastname(source.getName());
        target.setPhone(UUID.randomUUID().toString());
        target.setUuid(source.getPhone());
        return target;
    }
}
