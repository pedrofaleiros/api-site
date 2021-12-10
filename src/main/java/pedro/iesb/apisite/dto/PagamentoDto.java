package pedro.iesb.apisite.dto;

import pedro.iesb.apisite.model.Cartao;

public class PagamentoDto {

    private Cartao cartao;
    private String enderecoEntrega;
    private String enderecoCobranca;

    public PagamentoDto(){
    }

    public PagamentoDto(Cartao cartao, String enderecoEntrega, String enderecoCobranca) {
        this.cartao = cartao;
        this.enderecoEntrega = enderecoEntrega;
        this.enderecoCobranca = enderecoCobranca;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public String getEnderecoCobranca() {
        return enderecoCobranca;
    }

    public void setEnderecoCobranca(String enderecoCobranca) {
        this.enderecoCobranca = enderecoCobranca;
    }
}
