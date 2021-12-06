package pedro.iesb.apisite.builder;

import pedro.iesb.apisite.dto.ClienteDTO;
import pedro.iesb.apisite.model.Endereco;
import pedro.iesb.apisite.model.Telefone;

public class ClienteDTOBuilder {

    private String name;
    private String cpf;
    private String email;
    private String password;
    private final Telefone telefone = new Telefone();
    private final Endereco endereco = new Endereco();

    public ClienteDTOBuilder withName(String name){
        this.name = name;
        return this;
    }

    public ClienteDTOBuilder withCpf(String cpf){
        this.cpf = cpf;
        return this;
    }

    public ClienteDTOBuilder withEmail(String email){
        this.email = email;
        return this;
    }

    public ClienteDTOBuilder withPassword(String password){
        this.password = password;
        return this;
    }

    public ClienteDTOBuilder withTelefoneResidencial(String telR){
        this.telefone.setTelefoneResidencial(telR);
        return this;
    }

    public ClienteDTOBuilder withTelefoneComercial(String telCom){
        this.telefone.setTelefoneComercial(telCom);
        return this;
    }

    public ClienteDTOBuilder withTelefoneCelular(String telCel){
        this.telefone.setTelefoneCelular(telCel);
        return this;
    }

    public ClienteDTOBuilder withEnderecoResidencial(String endR){
        this.endereco.setEnderecoResidencial(endR);
        return this;
    }

    public ClienteDTOBuilder withEnderecoComercial(String endC){
        this.endereco.setEnderecoComercial(endC);
        return this;
    }

    public ClienteDTO build(){
        return new ClienteDTO(name, cpf, email,
                password,
                new Telefone(telefone.getTelefoneResidencial(),
                telefone.getTelefoneComercial(),
                telefone.getTelefoneCelular()),
                new Endereco(endereco.getEnderecoResidencial(),
                        endereco.getEnderecoComercial()));
    }
}
