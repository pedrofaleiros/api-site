package pedro.iesb.apisite.builder;

import pedro.iesb.apisite.model.Cartao;
import pedro.iesb.apisite.response.ClienteResponse;
import pedro.iesb.apisite.response.CompraResponse;
import pedro.iesb.apisite.response.ItemCarrinhoResponse;

import java.util.List;

public class CompraResponseBuilder {

    private ClienteResponse cliente;
    private List<ItemCarrinhoResponse> carrinho;
    private String enderecoEntrega;
    private String enderecoCobranca;
    private String codCupom;
    private float valorTotal;
    private Cartao cartao;

    public CompraResponseBuilder withCliente(ClienteResponse cliente){
        this.cliente = cliente;
        return this;
    }

    public CompraResponseBuilder withCarrinho(List<ItemCarrinhoResponse> carrinho){
        this.carrinho = carrinho;
        return this;
    }

    public CompraResponseBuilder withEnderecoEntrega(String enderecoEntrega){
        this.enderecoEntrega = enderecoEntrega;
        return this;
    }

    public CompraResponseBuilder withEnderecoCobranca(String enderecoCobranca){
        this.enderecoCobranca = enderecoCobranca;
        return this;
    }

    public CompraResponseBuilder withCodCupom(String codCupom){
        this.codCupom = codCupom;
        return this;
    }

    public CompraResponseBuilder withValorTotal(float valorTotal){
        this.valorTotal = valorTotal;
        return this;
    }

    public CompraResponseBuilder withCartao(Cartao cartao){
        this.cartao = cartao;
        return this;
    }

    public CompraResponse build(){
        return new CompraResponse(cliente, carrinho,
                 enderecoEntrega,  enderecoCobranca,
                 codCupom,  valorTotal,  cartao);
    }

}
