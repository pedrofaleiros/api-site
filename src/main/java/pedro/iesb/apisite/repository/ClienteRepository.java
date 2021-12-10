package pedro.iesb.apisite.repository;

import org.springframework.beans.factory.annotation.Autowired;
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

    public String login(String name, String password){
        for(ClienteEntity c: clientes){
            if(c.getName().equals(name)){
                LoginRepository login = LoginRepository.getInstancia();
                if(c.getPassword().equals(password)){
                    login.setLogin(c.getId());
                    return c.getId();
                }
                login.setLogin(null);
                return null;
            }
        }
        return null;
    }

    public ClienteEntity getById(String id){
        for(ClienteEntity c: clientes){
            if(c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }

    public boolean findByName(String name){
        for(ClienteEntity c: clientes){
            if(c.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
