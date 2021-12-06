package pedro.iesb.apisite.model.entities;

public class ProdutoEntity extends AbstractEntity {

    private String description;
    private float price;
    private int qtd;
    private int sold;

    public ProdutoEntity(){
    }

    public ProdutoEntity(String id, String name, String description, float price, int qtd, int sold) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.qtd = qtd;
        this.sold = sold;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }
}
