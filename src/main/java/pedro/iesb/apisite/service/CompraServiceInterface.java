package pedro.iesb.apisite.service;

import pedro.iesb.apisite.dto.PagamentoDto;
import pedro.iesb.apisite.model.entities.CompraEntity;

public interface CompraServiceInterface {

    String compra(PagamentoDto dados);

    CompraEntity mostra();

    void finalizar();

}
