package pedro.iesb.apisite.repository;

import pedro.iesb.apisite.model.entities.ProdutoEntity;
import pedro.iesb.apisite.response.ItemCarrinhoResponse;

import java.util.List;

public interface ProdutoRepositoryInterface {

    void save(ProdutoEntity prod);

    List<ProdutoEntity> get();

    boolean update(ProdutoEntity prod, String name);

    void delete(ProdutoEntity prod);

    float priceOf(String name);

    boolean validQtd(String name, int qtd);

    ProdutoEntity getByName(String name);

    boolean findByName(String name);

    void compra(List<ItemCarrinhoResponse> vendidos);
}
