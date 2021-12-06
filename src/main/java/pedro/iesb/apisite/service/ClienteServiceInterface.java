package pedro.iesb.apisite.service;

import pedro.iesb.apisite.dto.ClienteDTO;

import java.util.List;

public interface ClienteServiceInterface {

    String cadastrar(ClienteDTO prod);

    List<ClienteDTO> getClientes();

    String login(ClienteDTO cliente);
}
