package pedro.iesb.apisite.builder;

import pedro.iesb.apisite.response.ItemCarrinhoResponse;

public class ItemCarrinhoResponseBuilder {

    private String nomeProduto;
    private int qtd;
    private float precoUnitario;
    private float precoTotalProduto;

    public ItemCarrinhoResponseBuilder withNomeProduto(String nomeProduto){
        this.nomeProduto = nomeProduto;
        return this;
    }

    public ItemCarrinhoResponseBuilder withQtd(int qtd){
        this.qtd = qtd;
        return this;
    }

    public ItemCarrinhoResponseBuilder withPrecoUnitario(float precoUnitario){
        this.precoUnitario = precoUnitario;
        return this;
    }

    public ItemCarrinhoResponseBuilder withPrecoTotalProduto(float precoTotalProduto){
        this.precoTotalProduto = precoTotalProduto;
        return this;
    }

    public ItemCarrinhoResponse build(){
        return new ItemCarrinhoResponse(nomeProduto, qtd, precoUnitario, precoTotalProduto);
    }
}
