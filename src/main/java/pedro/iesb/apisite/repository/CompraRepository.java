package pedro.iesb.apisite.repository;

import org.springframework.stereotype.Repository;
import pedro.iesb.apisite.builder.CompraEntityBuilder;
import pedro.iesb.apisite.dto.PagamentoDto;
import pedro.iesb.apisite.model.entities.CompraEntity;

@Repository
public class CompraRepository {

    private CompraEntity dadosCompra;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final CarrinhoRepository carrinhoRepository;

    public CompraRepository(ClienteRepository clienteRepository,
                            CarrinhoRepository carrinhoRepository,
                            ProdutoRepository produtoRepository) {
        this.clienteRepository = clienteRepository;
        this.carrinhoRepository = carrinhoRepository;
        this.produtoRepository = produtoRepository;
    }

    public CompraEntity getDados(){
        return dadosCompra;
    }

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

    public void finalizar(){
        produtoRepository.compra(carrinhoRepository.getCarrinho());
        carrinhoRepository.limparCarrinho();
        carrinhoRepository.apagaCupom();
    }
}
