package pedro.iesb.apisite.service.imp;

import org.springframework.stereotype.Service;
import pedro.iesb.apisite.builder.CompraResponseBuilder;
import pedro.iesb.apisite.convert.ClienteConvert;
import pedro.iesb.apisite.dto.PagamentoDto;
import pedro.iesb.apisite.model.entities.CompraEntity;
import pedro.iesb.apisite.repository.CompraRepository;
import pedro.iesb.apisite.repository.LoginRepository;
import pedro.iesb.apisite.response.CompraResponse;
import pedro.iesb.apisite.service.CompraServiceInterface;
import pedro.iesb.apisite.validation.CartaoValidation;

@Service
public class CompraService implements CompraServiceInterface {

    private final CompraRepository repository;
    private final CartaoValidation validation;
    private final ClienteConvert convert;

    public CompraService(CompraRepository repository) {
        this.repository = repository;
        this.validation = new CartaoValidation();
        this.convert = new ClienteConvert();
    }

    @Override
    public boolean finalizar(){

        LoginRepository login = LoginRepository.getInstancia();

        if(login.getLogin() != null){
            repository.finalizar();
            return true;
        }

        return false;
    }

    @Override
    public CompraResponse mostra(){
        CompraEntity dados = repository.mostra();

        CompraResponse dadosResponse = new CompraResponseBuilder()
                .withCarrinho(dados.getCarrinho())
                .withCartao(dados.getCartao())
                .withCliente(convert.getResponse(dados.getCliente()))
                .withCodCupom(dados.getCodCupom())
                .withEnderecoCobranca(dados.getEnderecoCobranca())
                .withEnderecoEntrega(dados.getEnderecoEntrega())
                .withValorTotal(dados.getValorTotal())
                .build();

        return dadosResponse;
    }

    @Override
    public String compra(PagamentoDto dados){

        LoginRepository login = LoginRepository.getInstancia();
        if(login.getLogin() == null){
            return "Nenhum usuario logado";
        }

        String retorno = validation.validar(dados.getCartao());

        if(retorno != null){
            return retorno;
        }

        repository.compra(dados);

        return null;
    }
}
