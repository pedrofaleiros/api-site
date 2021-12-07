package pedro.iesb.apisite.model.entities;

public class ProdutoEntity extends AbstractEntity {

    private String description;
    private float price;
    private int qtd;
    private int sold;
    private String section;

    public ProdutoEntity(){
    }

    public ProdutoEntity(String id, String name, String description,
                         float price, int qtd, int sold, String section) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.qtd = qtd;
        this.sold = sold;
        this.section = section;
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

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
