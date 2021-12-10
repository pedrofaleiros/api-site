package pedro.iesb.apisite.convert;

import pedro.iesb.apisite.builder.ClienteDTOBuilder;
import pedro.iesb.apisite.builder.ClienteEntityBuilder;
import pedro.iesb.apisite.builder.ClienteResponseBuilder;
import pedro.iesb.apisite.dto.ClienteDto;
import pedro.iesb.apisite.model.entities.ClienteEntity;
import pedro.iesb.apisite.response.ClienteResponse;

import java.util.ArrayList;
import java.util.List;

public class ClienteConvert {

    public ClienteEntity getEntity(ClienteDto cliente){

        return new ClienteEntityBuilder()
                .withCpf(cliente.getCpf())
                .withEmail(cliente.getEmail())
                .withName(cliente.getName())
                .withPassword(cliente.getPassword())
                .withEnderecoResidencial(cliente.getEndereco().getEnderecoResidencial())
                .withEnderecoComercial(cliente.getEndereco().getEnderecoComercial())
                .withTelefoneCelular(cliente.getTelefone().getTelefoneCelular())
                .withTelefoneComercial(cliente.getTelefone().getTelefoneComercial())
                .withTelefoneResidencial(cliente.getTelefone().getTelefoneResidencial())
                .build();
    }

    public ClienteResponse getResponse(ClienteEntity cliente){

        return new ClienteResponseBuilder()
                .withEmail(cliente.getEmail())
                .withName(cliente.getName())
                .withCpf(cliente.getCpf())
                .withEnderecoComercial(cliente.getEndereco().getEnderecoComercial())
                .withEnderecoResidencial(cliente.getEndereco().getEnderecoResidencial())
                .withTelefoneCelular(cliente.getTelefone().getTelefoneCelular())
                .withTelefoneComercial(cliente.getTelefone().getTelefoneComercial())
                .withTelefoneResidencial(cliente.getTelefone().getTelefoneResidencial())
                .build();
    }

    public List<ClienteResponse> listResponse(List<ClienteEntity> clientes){

        List<ClienteResponse> clienteResponses = new ArrayList<>();

        for(ClienteEntity c:clientes){
            clienteResponses.add(getResponse(c));
        }

        return clienteResponses;
    }
}
