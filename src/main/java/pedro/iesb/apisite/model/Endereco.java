package pedro.iesb.apisite.model;

public class Endereco {

    private String enderecoResidencial;
    private String enderecoComercial;

    public Endereco(){}

    public Endereco(String enderecoResidencial, String enderecoComercial) {
        this.enderecoResidencial = enderecoResidencial;
        this.enderecoComercial = enderecoComercial;
    }

    public String getEnderecoResidencial() {
        return enderecoResidencial;
    }

    public void setEnderecoResidencial(String enderecoResidencial) {
        this.enderecoResidencial = enderecoResidencial;
    }

    public String getEnderecoComercial() {
        return enderecoComercial;
    }

    public void setEnderecoComercial(String comercial) {
        this.enderecoComercial = comercial;
    }
}
