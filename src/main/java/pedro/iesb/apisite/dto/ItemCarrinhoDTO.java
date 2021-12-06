package pedro.iesb.apisite.dto;

public class ItemCarrinhoDTO {

    private ProdutoDTO produto;
    private int qtd;

    public ItemCarrinhoDTO(ProdutoDTO produto, int qtd) {
        this.produto = produto;
        this.qtd = qtd;
    }

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
