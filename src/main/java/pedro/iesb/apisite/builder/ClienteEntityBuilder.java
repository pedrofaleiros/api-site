package pedro.iesb.apisite.builder;

import pedro.iesb.apisite.model.Endereco;
import pedro.iesb.apisite.model.Telefone;
import pedro.iesb.apisite.model.entities.ClienteEntity;

public class ClienteEntityBuilder {

    private String id;
    private String name;
    private String cpf;
    private String email;
    private String password;
    private final Telefone telefone = new Telefone();
    private final Endereco endereco = new Endereco();

    public ClienteEntityBuilder withName(String name){
        this.name = name;
        return this;
    }

    public ClienteEntityBuilder withCpf(String cpf){
        this.cpf = cpf;
        return this;
    }

    public ClienteEntityBuilder withEmail(String email){
        this.email = email;
        return this;
    }

    public ClienteEntityBuilder withPassword(String password){
        this.password = password;
        return this;
    }

    public ClienteEntityBuilder withTelefoneResidencial(String telR){
        this.telefone.setTelefoneResidencial(telR);
        return this;
    }

    public ClienteEntityBuilder withTelefoneComercial(String telCom){
        this.telefone.setTelefoneComercial(telCom);
        return this;
    }

    public ClienteEntityBuilder withTelefoneCelular(String telCel){
        this.telefone.setTelefoneCelular(telCel);
        return this;
    }

    public ClienteEntityBuilder withEnderecoResidencial(String endR){
        this.endereco.setEnderecoResidencial(endR);
        return this;
    }

    public ClienteEntityBuilder withEnderecoComercial(String endC){
        this.endereco.setEnderecoComercial(endC);
        return this;
    }

    public ClienteEntity build(){
        return new ClienteEntity(id, name, cpf, email,
                password,
                new Telefone(telefone.getTelefoneResidencial(),
                        telefone.getTelefoneComercial(),
                        telefone.getTelefoneCelular()),
                new Endereco(endereco.getEnderecoResidencial(),
                        endereco.getEnderecoComercial()));
    }
}
