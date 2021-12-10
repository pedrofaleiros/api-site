package pedro.iesb.apisite.service;

import pedro.iesb.apisite.model.ItemCarrinho;
import pedro.iesb.apisite.response.ItemCarrinhoResponse;

import java.util.List;

public interface CarrinhoServiceInterface {

    String adicionarProduto(ItemCarrinho item);// adiciona e altera

    String atualizaProduto(ItemCarrinho item);// adiciona e altera

    boolean deleteByName(String prod);

    float valorTotal();

    float valorDesconto(String desconto);

    List<ItemCarrinhoResponse> getProdutos();

    void limparCarrinho();
}

/*
 Incluir produtos no carrinho;
 Alterar quantidade dos produtos no carrinho sem remover o produto e incluir novamente;
 Excluir produto do carrinho;
 Recuperar o valor total do carrinho de compras;
 Aplicar desconto (cupom) no valor total do carrinho de compras;
 Listar produtos existentes no carrinho de compras;
 Função de limpar o carrinho de compras;
*/
