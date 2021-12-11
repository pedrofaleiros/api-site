package pedro.iesb.apisite.service;

import pedro.iesb.apisite.dto.ProdutoDto;
import java.util.List;

public interface ProdutoServiceInterface {

    String cadastrar(ProdutoDto prod);

    List<ProdutoDto> getProdutos();

    String atualizar(ProdutoDto prod, String name);

    boolean deleta(String name);
}
