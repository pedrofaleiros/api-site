package pedro.iesb.apisite.repository;

import pedro.iesb.apisite.model.ItemCarrinho;
import pedro.iesb.apisite.response.ItemCarrinhoResponse;

import java.util.List;

public interface CarrinhoRepositoryInterface {

    List<ItemCarrinhoResponse> getCarrinho();

    float valorCarrinho();

    float valorTotalCarrinho();

    float valorCarrinhoCupom(String cupom);

    int adicionaProduto(ItemCarrinho item);

    int atualizaProduto(ItemCarrinho item);

    boolean deleteByName(String name);

    void limparCarrinho();

    String getCupom();

    void apagaCupom();

    boolean isCupomAplicado();

    int indexByName(String name);

    int qtdItemCarrinho(String name);

    boolean notInCarrinho(ItemCarrinho item);
}
