package pedro.iesb.apisite.service.impl;

import org.springframework.stereotype.Service;
import pedro.iesb.apisite.builder.CompraResponseBuilder;
import pedro.iesb.apisite.convert.ClienteConvert;
import pedro.iesb.apisite.dto.PagamentoDto;
import pedro.iesb.apisite.model.entities.CompraEntity;
import pedro.iesb.apisite.repository.CompraRepositoryInterface;
import pedro.iesb.apisite.repository.impl.LoginRepository;
import pedro.iesb.apisite.response.CompraResponse;
import pedro.iesb.apisite.service.CompraServiceInterface;
import pedro.iesb.apisite.validation.CartaoValidation;

@Service
public class CompraService implements CompraServiceInterface {

    private final CompraRepositoryInterface repository;
    private final CartaoValidation validation;
    private final ClienteConvert convert;

    public CompraService(CompraRepositoryInterface repository) {
        this.repository = repository;
        this.validation = new CartaoValidation();
        this.convert = new ClienteConvert();
    }

    @Override
    public String finalizar(){

        if(repository.getDados() == null){
            return "Preencha os dados do cartao";
        }

        LoginRepository login = LoginRepository.getInstancia();

        if(login.getLogin() == null){
            return "Nenhum usuario logado";
        }

        repository.finalizar();
        return null;
    }

    @Override
    public CompraResponse getDados(){
        CompraEntity dados = repository.getDados();

        return new CompraResponseBuilder()
                .withCarrinho(dados.getCarrinho())
                .withCartao(dados.getCartao())
                .withCliente(convert.getResponse(dados.getCliente()))
                .withCodCupom(dados.getCodCupom())
                .withEnderecoCobranca(dados.getEnderecoCobranca())
                .withEnderecoEntrega(dados.getEnderecoEntrega())
                .withValorTotal(dados.getValorTotal())
                .build();
    }

    @Override
    public String compra(PagamentoDto dados){

        LoginRepository login = LoginRepository.getInstancia();
        if(login.getLogin() == null){
            return "Nenhum usuario logado";
        }

        String retorno = validation.verify(dados.getCartao());

        if(retorno != null){
            return retorno;
        }

        repository.compra(dados);

        return null;
    }
}
