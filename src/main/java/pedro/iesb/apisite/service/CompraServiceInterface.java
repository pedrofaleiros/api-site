package pedro.iesb.apisite.service;

import pedro.iesb.apisite.dto.PagamentoDto;
import pedro.iesb.apisite.response.CompraResponse;

public interface CompraServiceInterface {

    String compra(PagamentoDto dados);

    CompraResponse getDados();

    boolean finalizar();

}
