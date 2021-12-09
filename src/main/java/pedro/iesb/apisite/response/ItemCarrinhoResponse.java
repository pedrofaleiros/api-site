package pedro.iesb.apisite.response;

import pedro.iesb.apisite.dto.ItemCarrinho;

public class ItemCarrinhoResponse extends ItemCarrinho {

    private float precoUnitario;

    public ItemCarrinhoResponse() {
    }

    public ItemCarrinhoResponse(String nomeProduto, int qtd, float precoUnitario) {
        super(nomeProduto, qtd);
        this.precoUnitario = precoUnitario;
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}
