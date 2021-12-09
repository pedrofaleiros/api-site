package pedro.iesb.apisite.dto;

public class ItemCarrinho {

    private String nomeProduto;
    private int qtd;

    public ItemCarrinho() {
    }

    public ItemCarrinho(String nomeProduto, int qtd) {
        this.nomeProduto = nomeProduto;
        this.qtd = qtd;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
