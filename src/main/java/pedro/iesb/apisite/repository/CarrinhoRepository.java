package pedro.iesb.apisite.repository;

import org.springframework.stereotype.Repository;
import pedro.iesb.apisite.dto.ItemCarrinho;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarrinhoRepository {

    private final ProdutoRepository prodRepo;

    private final List<ItemCarrinho> carrinho = new ArrayList<>();

    public CarrinhoRepository(ProdutoRepository prodRepo) {
        this.prodRepo = prodRepo;
    }

    public List<ItemCarrinho> getCarrinho(){
        return carrinho;
    }

    public float valorCarrinho(){
        float price = 0;

        for(ItemCarrinho i: carrinho){
            price = price + (i.getQtd() * prodRepo.priceOf(i.getNomeProduto()));
        }

        return price;
    }

    public int adicionaProduto(ItemCarrinho item){

        if(prodRepo.findByName(item.getNomeProduto())){
            if(prodRepo.validQtd(item.getNomeProduto(), item.getQtd() + qtdItemCarrinho(item.getNomeProduto()))){

                if(notInCarrinho(item)){
                    carrinho.add(item);
                }else{
                    item.setQtd(item.getQtd() + qtdItemCarrinho(item.getNomeProduto()));
                    carrinho.set(indexByName(item.getNomeProduto()), item);
                }

                return 0;
            }
            return 2;
        }

        return 1;
    }

    public int atualizaProduto(ItemCarrinho item){

        if(prodRepo.findByName(item.getNomeProduto())){
            if(prodRepo.validQtd(item.getNomeProduto(), item.getQtd())){
                carrinho.set(indexByName(item.getNomeProduto()), item);
                return 0;
            }
            return 2;
        }

        return 0;
    }

    public boolean deleteByName(String name){
        for(ItemCarrinho i: carrinho){
            if(i.getNomeProduto().equals(name)){
                carrinho.remove(i);
                return true;
            }
        }
        return false;
    }

    public void limparCarrinho(){
        carrinho.clear();
    }


    private int indexByName(String name){
        for(ItemCarrinho i: carrinho){
            if(i.getNomeProduto().equals(name)){
                return carrinho.indexOf(i);
            }
        }
        return 0;
    }

    private int qtdItemCarrinho(String name){
        for(ItemCarrinho i: carrinho){
            if(i.getNomeProduto().equals(name)){
                return i.getQtd();
            }
        }
        return 0;
    }

    private boolean notInCarrinho(ItemCarrinho item){
        for(ItemCarrinho i: carrinho){
            if(i.getNomeProduto().equals(item.getNomeProduto())){
                return false;
            }
        }
        return true;
    }

}
