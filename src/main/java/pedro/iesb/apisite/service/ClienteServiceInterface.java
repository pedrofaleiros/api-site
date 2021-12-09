package pedro.iesb.apisite.service;

import pedro.iesb.apisite.dto.ClienteDto;
import pedro.iesb.apisite.response.ClienteResponse;

import java.util.List;

public interface ClienteServiceInterface {

    String cadastrar(ClienteDto prod);

    List<ClienteResponse> getClientes();

    String login(ClienteDto cliente);
}
