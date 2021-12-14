package pedro.iesb.apisite.repository.impl;

import org.springframework.stereotype.Repository;
import pedro.iesb.apisite.builder.CompraEntityBuilder;
import pedro.iesb.apisite.dto.PagamentoDto;
import pedro.iesb.apisite.model.entities.CompraEntity;
import pedro.iesb.apisite.repository.*;

@Repository
public class CompraRepository implements CompraRepositoryInterface {

    private CompraEntity dadosCompra = null;

    private final ClienteRepositoryInterface clienteRepository;
    private final ProdutoRepositoryInterface produtoRepository;
    private final CarrinhoRepositoryInterface carrinhoRepository;

    public CompraRepository(ClienteRepositoryInterface clienteRepository,
                            CarrinhoRepositoryInterface carrinhoRepository,
                            ProdutoRepositoryInterface produtoRepository) {
        this.clienteRepository = clienteRepository;
        this.carrinhoRepository = carrinhoRepository;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public CompraEntity getDados(){
        return dadosCompra;
    }

    @Override
    public void compra(PagamentoDto dadosPagamento){

        LoginRepository login = LoginRepository.getInstancia();

        dadosCompra = new CompraEntityBuilder()
                .withCarrinho(carrinhoRepository.getCarrinho())
                .withCartao(dadosPagamento.getCartao())
                .withCliente(clienteRepository.getById(login.getLogin()))
                .withCodCupom(carrinhoRepository.getCupom())
                .withEnderecoCobranca(dadosPagamento.getEnderecoCobranca())
                .withEnderecoEntrega(dadosPagamento.getEnderecoEntrega())
                .withValorTotal(carrinhoRepository.valorCarrinho())
                .build();
    }

    @Override
    public void finalizar(){
        produtoRepository.compra(carrinhoRepository.getCarrinho());
        carrinhoRepository.limparCarrinho();
        carrinhoRepository.apagaCupom();
    }
}
