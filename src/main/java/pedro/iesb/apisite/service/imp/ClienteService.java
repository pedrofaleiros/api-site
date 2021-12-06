package pedro.iesb.apisite.service.imp;

import org.springframework.stereotype.Service;
import pedro.iesb.apisite.convert.ClienteConvert;
import pedro.iesb.apisite.dto.ClienteDTO;
import pedro.iesb.apisite.model.entities.ClienteEntity;
import pedro.iesb.apisite.repository.ClienteRepository;
import pedro.iesb.apisite.service.ClienteServiceInterface;
import pedro.iesb.apisite.validation.ClienteValidation;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService implements ClienteServiceInterface{

    private final ClienteRepository repository;
    private final ClienteValidation validation;
    private final ClienteConvert convert;

    public ClienteService(ClienteRepository repository){
        this.repository = repository;
        this.validation = new ClienteValidation();
        this.convert = new ClienteConvert();
    }

    @Override
    public String cadastrar(ClienteDTO cliente){

        String ret = validation.verify(cliente);

        if(ret == null){
            ClienteEntity novoCliente = convert.getEntity(cliente);
            novoCliente.setId(UUID.randomUUID().toString());
            repository.save(novoCliente);
        }

        return ret;
    }

    @Override
    public List<ClienteDTO> getClientes(){
        return convert.listDTO(repository.getClientes());
    }

    @Override
    public String login(ClienteDTO cliente){
        return null;
    }
}
