package pedro.iesb.apisite.repository;

import org.springframework.stereotype.Repository;
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

    public CompraEntity mostra(){
        return dadosCompra;
    }

    public void compra(PagamentoDto dadosPagamento){

        LoginRepository login = LoginRepository.getInstancia();

        dadosCompra = new CompraEntity();

        dadosCompra.setCartao(dadosPagamento.getCartao());
        dadosCompra.setCarrinho(carrinhoRepository.getCarrinho());
        dadosCompra.setCliente(clienteRepository.getById(login.getLogin()));
        dadosCompra.setEnderecoCobranca(dadosPagamento.getEnderecoCobranca());
        dadosCompra.setEnderecoEntrega(dadosPagamento.getEnderecoEntrega());
        dadosCompra.setValorTotal(carrinhoRepository.valorCarrinho());
        dadosCompra.setCodCupom(carrinhoRepository.getCupom());

        produtoRepository.compra(carrinhoRepository.getCarrinho());
        carrinhoRepository.limparCarrinho();
    }
}
