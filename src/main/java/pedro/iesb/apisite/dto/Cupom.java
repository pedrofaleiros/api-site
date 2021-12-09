package pedro.iesb.apisite.dto;

import java.util.Locale;

public class Cupom {

    private String cod;
    private float valor;

    public Cupom() {
    }

    public Cupom(String cod, float valor) {
        this.cod = cod;
        this.valor = valor;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
