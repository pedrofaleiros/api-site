package pedro.iesb.apisite.response;

import pedro.iesb.apisite.model.Cartao;

import java.util.List;

public class CompraResponse {

    private ClienteResponse cliente;
    private List<ItemCarrinhoResponse> carrinho;
    private String enderecoEntrega;
    private String enderecoCobranca;
    private String codCupom;
    private float valorTotal;
    private Cartao cartao;

    public CompraResponse(){}

    public CompraResponse(ClienteResponse cliente, List<ItemCarrinhoResponse> carrinho,
                          String enderecoEntrega, String enderecoCobranca,
                          String codCupom, float valorTotal, Cartao cartao) {
        this.cliente = cliente;
        this.carrinho = carrinho;
        this.enderecoEntrega = enderecoEntrega;
        this.enderecoCobranca = enderecoCobranca;
        this.codCupom = codCupom;
        this.valorTotal = valorTotal;
        this.cartao = cartao;
    }

    public ClienteResponse getCliente() {
        return cliente;
    }

    public void setCliente(ClienteResponse cliente) {
        this.cliente = cliente;
    }

    public List<ItemCarrinhoResponse> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<ItemCarrinhoResponse> carrinho) {
        this.carrinho = carrinho;
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

    public String getCodCupom() {
        return codCupom;
    }

    public void setCodCupom(String codCupom) {
        this.codCupom = codCupom;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}
