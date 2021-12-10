package pedro.iesb.apisite.model;

public class Cartao {

    private String numero;
    private String dataValidade;
    private String name;
    private String cvv;

    public Cartao() {
    }

    public Cartao(String numero, String dataValidade, String name, String cvv) {
        this.numero = numero;
        this.dataValidade = dataValidade;
        this.name = name;
        this.cvv = cvv;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
