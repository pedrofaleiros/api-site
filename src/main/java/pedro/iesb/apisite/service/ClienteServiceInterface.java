package pedro.iesb.apisite.service;

import pedro.iesb.apisite.dto.ClienteDto;

import java.util.List;

public interface ClienteServiceInterface {

    String cadastrar(ClienteDto prod);

    List<ClienteDto> getClientes();

    String login(ClienteDto cliente);
}
