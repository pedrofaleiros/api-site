package pedro.iesb.apisite.convert;

import pedro.iesb.apisite.builder.ClienteDTOBuilder;
import pedro.iesb.apisite.builder.ClienteEntityBuilder;
import pedro.iesb.apisite.dto.ClienteDto;
import pedro.iesb.apisite.model.entities.ClienteEntity;

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

    public ClienteDto getDTO(ClienteEntity cliente){

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

    public List<ClienteDto> listDTO(List<ClienteEntity> clientes){

        List<ClienteDto> clienteDTOs = new ArrayList<>();

        for(ClienteEntity c:clientes){
            c.setPassword(null);
            clienteDTOs.add(getDTO(c));
        }

        return clienteDTOs;
    }
}
