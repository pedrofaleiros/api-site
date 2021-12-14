package pedro.iesb.apisite.repository;

import pedro.iesb.apisite.model.entities.ClienteEntity;

import java.util.List;

public interface ClienteRepositoryInterface {

    void save(ClienteEntity cliente);

    List<ClienteEntity> getClientes();

    String login(String name, String password);

    ClienteEntity getById(String id);

    boolean findByName(String name);

    boolean findByEmail(String email);
}
