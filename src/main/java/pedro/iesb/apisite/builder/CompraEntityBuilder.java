package pedro.iesb.apisite.builder;

import pedro.iesb.apisite.model.Cartao;
import pedro.iesb.apisite.model.entities.ClienteEntity;
import pedro.iesb.apisite.model.entities.CompraEntity;
import pedro.iesb.apisite.response.ItemCarrinhoResponse;

import java.util.List;

public class CompraEntityBuilder {

    private ClienteEntity cliente;
    private List<ItemCarrinhoResponse> carrinho;
    private String enderecoEntrega;
    private String enderecoCobranca;
    private String codCupom;
    private float valorTotal;
    private Cartao cartao;

    public CompraEntityBuilder withCliente(ClienteEntity cliente){
        this.cliente = cliente;
        return this;
    }

    public CompraEntityBuilder withCarrinho(List<ItemCarrinhoResponse> carrinho){
        this.carrinho = carrinho;
        return this;
    }

    public CompraEntityBuilder withEnderecoEntrega(String enderecoEntrega){
        this.enderecoEntrega = enderecoEntrega;
        return this;
    }

    public CompraEntityBuilder withEnderecoCobranca(String enderecoCobranca){
        this.enderecoCobranca = enderecoCobranca;
        return this;
    }

    public CompraEntityBuilder withCodCupom(String codCupom){
        this.codCupom = codCupom;
        return this;
    }

    public CompraEntityBuilder withValorTotal(float valorTotal){
        this.valorTotal = valorTotal;
        return this;
    }

    public CompraEntityBuilder withCartao(Cartao cartao){
        this.cartao = cartao;
        return this;
    }

    public CompraEntity build(){
        return new CompraEntity(cliente, carrinho,
                 enderecoEntrega,  enderecoCobranca,
                 codCupom,  valorTotal,  cartao);
    }
}
