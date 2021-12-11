package pedro.iesb.apisite.service.imp;

import org.springframework.stereotype.Service;
import pedro.iesb.apisite.model.ItemCarrinho;
import pedro.iesb.apisite.response.ItemCarrinhoResponse;
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
    public String adicionarProduto(ItemCarrinho item) {
        int retorno = repository.adicionaProduto(item);

        switch (retorno){
            case 1: return "Produto nao encontrado";
            case 2: return "Quantidade invalida";
        }

        return null;
    }

    @Override
    public String atualizaProduto(ItemCarrinho item) {
        int retorno = repository.atualizaProduto(item);

        switch (retorno){
            case 1: return "Produto nao encontrado";
            case 2: return "Quantidade invalida";
        }

        return null;
    }

    @Override
    public boolean deleteByName(String name){
        return repository.deleteByName(name);
    }

    @Override
    public String valorTotal(){

        return Float.toString(repository.valorCarrinho());
    }

    @Override
    public String valorDesconto(String cupom){

        float valor = repository.valorCarrinhoCupom(cupom);

        if(valor == -1){
            return null;
        }

        return Float.toString(valor);
    }

    @Override
    public List<ItemCarrinhoResponse> getProdutos(){
        return repository.getCarrinho();
    }

    @Override
    public void limparCarrinho(){
        repository.limparCarrinho();
    }
}
