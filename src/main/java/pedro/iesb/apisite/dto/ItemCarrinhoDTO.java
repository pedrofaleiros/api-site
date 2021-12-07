package pedro.iesb.apisite.dto;

public class ItemCarrinhoDTO {

    private String nomeProduto;
    private int qtd;

    public ItemCarrinhoDTO(String nomeProduto, int qtd) {
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
