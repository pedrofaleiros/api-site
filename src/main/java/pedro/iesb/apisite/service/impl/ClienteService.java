package pedro.iesb.apisite.service.impl;

import org.springframework.stereotype.Service;
import pedro.iesb.apisite.convert.ClienteConvert;
import pedro.iesb.apisite.dto.ClienteDto;
import pedro.iesb.apisite.model.entities.ClienteEntity;
import pedro.iesb.apisite.repository.ClienteRepositoryInterface;
import pedro.iesb.apisite.response.ClienteResponse;
import pedro.iesb.apisite.service.ClienteServiceInterface;
import pedro.iesb.apisite.validation.ClienteValidation;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService implements ClienteServiceInterface{

    private final ClienteRepositoryInterface repository;
    private final ClienteValidation validation;
    private final ClienteConvert convert;

    public ClienteService(ClienteRepositoryInterface repository){
        this.repository = repository;
        this.validation = new ClienteValidation();
        this.convert = new ClienteConvert();
    }

    @Override
    public String cadastrar(ClienteDto cliente){

        if(repository.findByName(cliente.getName())){
            return "Usuario ja existe";
        }

        if(repository.findByEmail(cliente.getEmail())){
            return "Email ja existe";
        }

        String ret = validation.verify(cliente);

        if(ret == null){
            ClienteEntity novoCliente = convert.getEntity(cliente);
            novoCliente.setId(UUID.randomUUID().toString());
            repository.save(novoCliente);
        }

        return ret;
    }

    @Override
    public List<ClienteResponse> getClientes(){
        return convert.listResponse(repository.getClientes());
    }

    @Override
    public String login(ClienteDto cliente){
        return repository.login(cliente.getName(), cliente.getPassword());
    }
}
