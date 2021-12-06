package pedro.iesb.apisite.convert;

import pedro.iesb.apisite.builder.ClienteDTOBuilder;
import pedro.iesb.apisite.builder.ClienteEntityBuilder;
import pedro.iesb.apisite.dto.ClienteDTO;
import pedro.iesb.apisite.model.entities.ClienteEntity;

import java.util.ArrayList;
import java.util.List;

public class ClienteConvert {

    public ClienteEntity getEntity(ClienteDTO cliente){

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

    public ClienteDTO getDTO(ClienteEntity cliente){

        return new ClienteDTOBuilder()
                .withEmail(cliente.getEmail())
                .withName(cliente.getName())
                .withCpf(cliente.getCpf())
                .withPassword(cliente.getPassword())
                .withEnderecoComercial(cliente.getEnderecoComercial())
                .withEnderecoResidencial(cliente.getEnderecoResidencial())
                .withTelefoneCelular(cliente.getTelefoneCelular())
                .withTelefoneComercial(cliente.getTelefoneComercial())
                .withTelefoneResidencial(cliente.getTelefoneResidencial())
                .build();
    }

    public List<ClienteDTO> listDTO(List<ClienteEntity> clientes){

        List<ClienteDTO> clienteDTOs = new ArrayList<>();

        for(ClienteEntity c:clientes){
            clienteDTOs.add(getDTO(c));
        }

        return clienteDTOs;
    }
}
