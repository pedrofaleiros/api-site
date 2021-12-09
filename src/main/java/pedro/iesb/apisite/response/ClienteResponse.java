package pedro.iesb.apisite.response;

import pedro.iesb.apisite.model.Endereco;
import pedro.iesb.apisite.model.Telefone;

public class ClienteResponse {

    private String name;
    private String cpf;
    private String email;
    private Telefone telefone;
    private Endereco endereco;

    public ClienteResponse() {
    }

    public ClienteResponse(String name, String cpf, String email, Telefone telefone, Endereco endereco) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
