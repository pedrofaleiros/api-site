package pedro.iesb.apisite.dto;

public class ProdutoDTO {

    private String name;
    private String description;
    private float price;
    private int qtd;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String name, String description, float price, int qtd) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.qtd = qtd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
