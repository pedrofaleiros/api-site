package pedro.iesb.apisite.repository;

import org.springframework.stereotype.Repository;
import pedro.iesb.apisite.model.entities.ClienteEntity;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository {

    private final List<ClienteEntity> clientes = new ArrayList<>();

    public void save(ClienteEntity cliente){
        clientes.add(cliente);
    }

    public List<ClienteEntity> getClientes(){
        return clientes;
    }
}
