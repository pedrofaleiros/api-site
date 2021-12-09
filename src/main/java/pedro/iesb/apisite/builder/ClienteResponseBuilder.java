package pedro.iesb.apisite.builder;

import pedro.iesb.apisite.model.Endereco;
import pedro.iesb.apisite.model.Telefone;
import pedro.iesb.apisite.response.ClienteResponse;

public class ClienteResponseBuilder {

    private String name;
    private String cpf;
    private String email;
    private final Telefone telefone = new Telefone();
    private final Endereco endereco = new Endereco();

    public ClienteResponseBuilder withName(String name){
        this.name = name;
        return this;
    }

    public ClienteResponseBuilder withCpf(String cpf){
        this.cpf = cpf;
        return this;
    }

    public ClienteResponseBuilder withEmail(String email){
        this.email = email;
        return this;
    }

    public ClienteResponseBuilder withTelefoneResidencial(String telR){
        this.telefone.setTelefoneResidencial(telR);
        return this;
    }

    public ClienteResponseBuilder withTelefoneComercial(String telCom){
        this.telefone.setTelefoneComercial(telCom);
        return this;
    }

    public ClienteResponseBuilder withTelefoneCelular(String telCel){
        this.telefone.setTelefoneCelular(telCel);
        return this;
    }

    public ClienteResponseBuilder withEnderecoResidencial(String endR){
        this.endereco.setEnderecoResidencial(endR);
        return this;
    }

    public ClienteResponseBuilder withEnderecoComercial(String endC){
        this.endereco.setEnderecoComercial(endC);
        return this;
    }

    public ClienteResponse build(){
        return new ClienteResponse(name, cpf, email,
                new Telefone(telefone.getTelefoneResidencial(),
                        telefone.getTelefoneComercial(),
                        telefone.getTelefoneCelular()),
                new Endereco(endereco.getEnderecoResidencial(),
                        endereco.getEnderecoComercial()));
    }
}
