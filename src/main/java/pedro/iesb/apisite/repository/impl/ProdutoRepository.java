package pedro.iesb.apisite.repository.impl;

import org.springframework.stereotype.Repository;
import pedro.iesb.apisite.model.entities.ProdutoEntity;
import pedro.iesb.apisite.repository.ProdutoRepositoryInterface;
import pedro.iesb.apisite.response.ItemCarrinhoResponse;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutoRepository implements ProdutoRepositoryInterface {

    private final List<ProdutoEntity> produtos = new ArrayList<>();

    @Override
    public void save(ProdutoEntity prod){
        produtos.add(prod);
    }

    @Override
    public List<ProdutoEntity> get(){
        return produtos;
    }

    @Override
    public void update(ProdutoEntity prod, String name){

        ProdutoEntity aux = getByName(name);
        prod.setId(aux.getId());
        int i = produtos.indexOf(aux);
        produtos.set(i, prod);
    }

    @Override
    public void delete(ProdutoEntity prod){
        produtos.remove(prod);
    }

    @Override
    public float priceOf(String name){

        for(ProdutoEntity p: produtos){
            if(p.getName().equals(name)){
                return p.getPrice();
            }
        }

        return 0;
    }

    @Override
    public boolean validQtd(String name, int qtd){
        for(ProdutoEntity p: produtos){
            if(p.getName().equals(name)){
                return p.getQtd() >= qtd;
            }
        }
        return false;
    }

    @Override
    public ProdutoEntity getByName(String name){
        for(ProdutoEntity p: produtos){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean findByName(String name){
        for(ProdutoEntity p: produtos){
            if(p.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    @Override
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
