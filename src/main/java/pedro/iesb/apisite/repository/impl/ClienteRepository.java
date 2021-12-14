package pedro.iesb.apisite.repository.impl;

import org.springframework.stereotype.Repository;
import pedro.iesb.apisite.model.entities.ClienteEntity;
import pedro.iesb.apisite.repository.ClienteRepositoryInterface;
import pedro.iesb.apisite.repository.LoginRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository implements ClienteRepositoryInterface {

    private final List<ClienteEntity> clientes = new ArrayList<>();

    @Override
    public void save(ClienteEntity cliente){
        clientes.add(cliente);
    }

    @Override
    public List<ClienteEntity> getClientes(){
        return clientes;
    }

    @Override
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

    @Override
    public ClienteEntity getById(String id){
        for(ClienteEntity c: clientes){
            if(c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }

    @Override
    public boolean findByName(String name){
        for(ClienteEntity c: clientes){
            if(c.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean findByEmail(String email){
        for(ClienteEntity c: clientes){
            if(c.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
}
