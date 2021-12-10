package pedro.iesb.apisite.service.imp;

import org.springframework.stereotype.Service;
import pedro.iesb.apisite.dto.PagamentoDto;
import pedro.iesb.apisite.model.entities.CompraEntity;
import pedro.iesb.apisite.repository.CompraRepository;
import pedro.iesb.apisite.service.CompraServiceInterface;
import pedro.iesb.apisite.validation.CartaoValidation;

@Service
public class CompraService implements CompraServiceInterface {

    private final CompraRepository repository;
    private final CartaoValidation validation;

    public CompraService(CompraRepository repository) {
        this.repository = repository;
        this.validation = new CartaoValidation();
    }

    public CompraEntity mostra(){
        return repository.mostra();
    }

    @Override
    public String compra(PagamentoDto dados){

        String retorno = validation.validar(dados.getCartao());

        if(retorno != null){
            return retorno;
        }

        repository.compra(dados);

        return null;
    }
}