package pedro.iesb.apisite.service.imp;

import org.springframework.stereotype.Service;
import pedro.iesb.apisite.dto.ItemCarrinhoDTO;
import pedro.iesb.apisite.repository.CarrinhoRepository;
import pedro.iesb.apisite.service.CarrinhoServiceInterface;
import java.util.List;

@Service
public class CarrinhoService implements CarrinhoServiceInterface {

    private final CarrinhoRepository repository;

    public CarrinhoService(CarrinhoRepository repository) {
        this.repository = repository;
    }

    @Override
    public String adicionarProduto(ItemCarrinhoDTO item) {// adiciona e altera
        int retorno = repository.adicionaProduto(item);

        switch (retorno){
            case 1: return "Produto nao encontrado";
            case 2: return "Quantidade invalida";
        }

        return null;
    }

    @Override
    public boolean deleta(String prod){
        return repository.delete(prod);
    }

    @Override
    public float valorTotal(){
        return repository.valorCarrinho();
    }

    @Override
    public float valorDesconto(String str){

        float desconto = 1;
        try{
            desconto = Float.parseFloat(str);
        }catch (IllegalArgumentException NumberFormatException){
            return -1;
        }

        if (desconto > 1 || desconto < 0){
            return -1;
        }

        return repository.valorCarrinho() * desconto;
    }

    @Override
    public List<ItemCarrinhoDTO> getProdutos(){
        return repository.getCarrinho();
    }

    @Override
    public void limparCarrinho(){
        repository.limparCarrinho();
    }
}
