package pedro.iesb.apisite.builder;

import pedro.iesb.apisite.model.entities.ProdutoEntity;

public class ProdutoEntityBuilder {

    private String name;
    private String description;
    private float price;
    private int qtd;
    private String section;

    public ProdutoEntityBuilder withName(String name){
        this.name = name;
        return this;
    }

    public ProdutoEntityBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    public ProdutoEntityBuilder withPrice(float price){
        this.price = price;
        return this;
    }

    public ProdutoEntityBuilder withQtd(int qtd){
        this.qtd = qtd;
        return this;
    }

    public ProdutoEntityBuilder withSection(String section){
        this.section = section;
        return this;
    }

    public ProdutoEntity build(){
        return new ProdutoEntity( null, name, description, price, qtd, 0, section);
    }

}
