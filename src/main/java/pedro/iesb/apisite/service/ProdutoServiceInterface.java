package pedro.iesb.apisite.service;

import pedro.iesb.apisite.dto.ProdutoDTO;
import java.util.List;

public interface ProdutoServiceInterface {

    String cadastrar(ProdutoDTO prod);

    List<ProdutoDTO> getProdutos();

    String atualizar(ProdutoDTO prod, String name);

    boolean deleta(ProdutoDTO prod);
}
