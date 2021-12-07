package pedro.iesb.apisite.service;

import pedro.iesb.apisite.dto.ItemCarrinhoDTO;
import pedro.iesb.apisite.dto.ProdutoDTO;

import java.util.List;

public interface CarrinhoServiceInterface {

    String adicionarProduto(ItemCarrinhoDTO item);// adiciona e altera

    boolean deleta(String prod);

    float valorTotal();

    float valorDesconto(String desconto);

    List<ItemCarrinhoDTO> getProdutos();

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