package pedro.iesb.apisite.repository.impl;

import org.springframework.stereotype.Repository;
import pedro.iesb.apisite.builder.ItemCarrinhoResponseBuilder;
import pedro.iesb.apisite.model.Cupom;
import pedro.iesb.apisite.model.ItemCarrinho;
import pedro.iesb.apisite.repository.CarrinhoRepositoryInterface;
import pedro.iesb.apisite.response.ItemCarrinhoResponse;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarrinhoRepository implements CarrinhoRepositoryInterface {

    private final ProdutoRepository prodRepo;
    private final CupomRepository cupRepo;

    private final List<ItemCarrinho> carrinho = new ArrayList<>();
    private final Cupom cupomAplicado = new Cupom(null, 0);

    public CarrinhoRepository(ProdutoRepository prodRepo, CupomRepository cupRepo) {
        this.prodRepo = prodRepo;
        this.cupRepo = cupRepo;
    }

    @Override
    public List<ItemCarrinhoResponse> getCarrinho(){

        List<ItemCarrinhoResponse> ret = new ArrayList<>();

        for (ItemCarrinho i: carrinho){
            ret.add(new ItemCarrinhoResponseBuilder()
                    .withNomeProduto(i.getNomeProduto())
                    .withQtd(i.getQtd())
                    .withPrecoUnitario(prodRepo.priceOf(i.getNomeProduto()))
                    .withPrecoTotalProduto(i.getQtd() * prodRepo.priceOf(i.getNomeProduto()))
                    .build());
        }

        return ret;
    }

    @Override
    public float valorCarrinho(){
        float price = valorTotalCarrinho();

        if(isCupomAplicado()){
            price *=  (1 - cupomAplicado.getValor());
        }

        return price;
    }

    @Override
    public float valorTotalCarrinho(){
        float price = 0;

        for(ItemCarrinho i: carrinho){
            price = price + (i.getQtd() * prodRepo.priceOf(i.getNomeProduto()));
        }

        return price;
    }

    @Override
    public float valorCarrinhoCupom(String cupom){

        float desconto = 0;

        for(Cupom c: cupRepo.get()){
            if(c.getCod().equals(cupom)){
                desconto = 1 - c.getValor();
                cupomAplicado.setCod(c.getCod());
                cupomAplicado.setValor(c.getValor());
                return valorTotalCarrinho() * desconto;
            }
        }

        return -1;
    }

    @Override
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

    @Override
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

    @Override
    public boolean deleteByName(String name){
        for(ItemCarrinho i: carrinho){
            if(i.getNomeProduto().equals(name)){
                carrinho.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void limparCarrinho(){
        carrinho.clear();
    }

    @Override
    public String getCupom(){
        return cupomAplicado.getCod();
    }

    @Override
    public void apagaCupom(){
        this.cupomAplicado.setCod(null);
        this.cupomAplicado.setValor(0);
    }

    @Override
    public boolean isCupomAplicado(){
        return !(cupomAplicado.getCod() == null);
    }

    @Override
    public int indexByName(String name){
        for(ItemCarrinho i: carrinho){
            if(i.getNomeProduto().equals(name)){
                return carrinho.indexOf(i);
            }
        }
        return 0;
    }

    @Override
    public int qtdItemCarrinho(String name){
        for(ItemCarrinho i: carrinho){
            if(i.getNomeProduto().equals(name)){
                return i.getQtd();
            }
        }
        return 0;
    }

    @Override
    public boolean notInCarrinho(ItemCarrinho item){
        for(ItemCarrinho i: carrinho){
            if(i.getNomeProduto().equals(item.getNomeProduto())){
                return false;
            }
        }
        return true;
    }

}
