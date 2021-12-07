package pedro.iesb.apisite.builder;

import pedro.iesb.apisite.dto.ProdutoDTO;

public class ProdutoDTOBuilder {

    private String name;
    private String description;
    private float price;
    private int qtd;
    private String section;

    public ProdutoDTOBuilder withName(String name){
        this.name = name;
        return this;
    }

    public ProdutoDTOBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    public ProdutoDTOBuilder withPrice(float price){
        this.price = price;
        return this;
    }

    public ProdutoDTOBuilder withQtd(int qtd){
        this.qtd = qtd;
        return this;
    }

    public ProdutoDTOBuilder withSection(String section){
        this.section = section;
        return this;
    }

    public ProdutoDTO build(){
        return new ProdutoDTO( name, description, price, qtd, section);
    }
}
