package pedro.iesb.apisite.repository;

import pedro.iesb.apisite.dto.PagamentoDto;
import pedro.iesb.apisite.model.entities.CompraEntity;

public interface CompraRepositoryInterface {

    CompraEntity getDados();

    void compra(PagamentoDto dadosPagamento);

    void finalizar();
}
