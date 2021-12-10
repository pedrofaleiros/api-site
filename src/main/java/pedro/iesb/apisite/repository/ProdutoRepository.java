package pedro.iesb.apisite.repository;

import org.springframework.stereotype.Repository;
import pedro.iesb.apisite.model.entities.ProdutoEntity;
import pedro.iesb.apisite.response.ItemCarrinhoResponse;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutoRepository {

    private final List<ProdutoEntity> produtos = new ArrayList<>();

    public void save(ProdutoEntity prod){
        produtos.add(prod);
    }

    public List<ProdutoEntity> get(){
        return produtos;
    }

    public boolean update(ProdutoEntity prod, String name){

        int i = 0;
        boolean flag = false;
        for(ProdutoEntity p: produtos){
            if(p.getName().equals(name)){
                flag = true;
                prod.setId(p.getId());
                break;
            }
            i++;
        }

        if(flag){
            produtos.set(i, prod);
            return true;
        }
        return false;
    }

    public boolean delete(ProdutoEntity prod){

        for(ProdutoEntity p: produtos){
            if(p.getName().equals(prod.getName())){
                if(p.getSold() == 0){
                    produtos.remove(p);
                    return true;
                }
            }
        }
        return false;
    }

    public float priceOf(String name){

        for(ProdutoEntity p: produtos){
            if(p.getName().equals(name)){
                return p.getPrice();
            }
        }

        return 0;
    }

    public boolean validQtd(String name, int qtd){
        for(ProdutoEntity p: produtos){
            if(p.getName().equals(name)){
                return p.getQtd() >= qtd;
            }
        }
        return false;
    }

    public boolean findByName(String name){
        for(ProdutoEntity p: produtos){
            if(p.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public void compra(List<ItemCarrinhoResponse> vendidos){

        for(ItemCarrinhoResponse i: vendidos){
            for(ProdutoEntity p: produtos){
                if (p.getName().equals(i.getNomeProduto())){
                    p.setQtd(p.getQtd()-i.getQtd());
                    p.setSold(i.getQtd());
                }
            }
        }
    }
}
