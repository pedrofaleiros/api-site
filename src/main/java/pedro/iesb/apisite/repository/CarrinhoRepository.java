package pedro.iesb.apisite.repository;

import org.springframework.stereotype.Repository;
import pedro.iesb.apisite.dto.ItemCarrinhoDTO;
import pedro.iesb.apisite.model.entities.ProdutoEntity;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarrinhoRepository {

    private final ProdutoRepository prodRepo;

    private final List<ItemCarrinhoDTO> carrinho = new ArrayList<>();

    public CarrinhoRepository(ProdutoRepository prodRepo) {
        this.prodRepo = prodRepo;
    }

    public int adicionaProduto(ItemCarrinhoDTO item){

        if (verificaExistencia(item)){
            if(verificaQtd(item)){
                for(ItemCarrinhoDTO i:carrinho){
                    if(i.getNomeProduto().equals(item.getNomeProduto())){
                        carrinho.set(carrinho.indexOf(i), item);
                        return 0;
                    }
                }

                carrinho.add(item);
                return 0;
            }
            return 2;
        }

        return 1;
    }

    public List<ItemCarrinhoDTO> getCarrinho(){
        return carrinho;
    }

    public float valorCarrinho(){
        float valor = 0;

        for(ItemCarrinhoDTO i:carrinho){
            valor = valor + (i.getQtd() * prodRepo.priceOf(i.getNomeProduto()));
        }

        return valor;
    }

    public void limparCarrinho(){
        carrinho.clear();
    }

    public boolean delete(String name){

        for(ItemCarrinhoDTO i: carrinho){
            if(i.getNomeProduto().equals(name)){
                carrinho.remove(i);
                return true;
            }
        }

        return false;
    }

    private boolean verificaExistencia(ItemCarrinhoDTO item){
        for(ProdutoEntity p: prodRepo.get()){
            if(p.getName().equals(item.getNomeProduto())){
                return true;
            }
        }
        return false;
    }

    private boolean verificaQtd(ItemCarrinhoDTO item){
        for(ProdutoEntity p: prodRepo.get()){
            if(p.getName().equals(item.getNomeProduto())){
                return p.getQtd() > item.getQtd();
            }
        }
        return false;
    }
}
