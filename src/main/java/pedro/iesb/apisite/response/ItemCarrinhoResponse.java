package pedro.iesb.apisite.response;

import pedro.iesb.apisite.dto.ItemCarrinho;

public class ItemCarrinhoResponse extends ItemCarrinho {

    private float precoUnitario;
    private float precoTotalProduto;

    public ItemCarrinhoResponse() {
    }

    public ItemCarrinhoResponse(String nomeProduto, int qtd, float precoUnitario, float precoTotalProduto) {
        super(nomeProduto, qtd);
        this.precoUnitario = precoUnitario;
        this.precoTotalProduto = precoTotalProduto;
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public float getPrecoTotalProduto() {
        return precoTotalProduto;
    }

    public void setPrecoTotalProduto(float precoTotalProduto) {
        this.precoTotalProduto = precoTotalProduto;
    }
}
