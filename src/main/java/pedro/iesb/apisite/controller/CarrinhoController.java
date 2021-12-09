package pedro.iesb.apisite.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedro.iesb.apisite.dto.ItemCarrinho;
import pedro.iesb.apisite.response.ItemCarrinhoResponse;
import pedro.iesb.apisite.service.imp.CarrinhoService;
import java.util.List;

@RestController
public class CarrinhoController {

    private final CarrinhoService service;

    public CarrinhoController(CarrinhoService service) {
        this.service = service;
    }

    @PostMapping("/carrinho")
    public ResponseEntity<String> incluir(@RequestBody ItemCarrinho item){

        String ret = service.adicionarProduto(item);

        if(ret != null){
            return ResponseEntity.badRequest().body(ret);
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping("/carrinho/update")
    public ResponseEntity<String> alterar(@RequestBody ItemCarrinho item){

        String ret = service.atualizaProduto(item);

        if(ret != null){
            return ResponseEntity.badRequest().body(ret);
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/carrinho")
    public ResponseEntity<List<ItemCarrinhoResponse>> getCarrinho(){
        return ResponseEntity.ok().body(service.getProdutos());
    }

    @GetMapping("/carrinho/preco")
    public ResponseEntity<String> getPrecoTotal(){
        String preco = Float.toString(service.valorTotal());
        return ResponseEntity.ok().body("Preco Total: "+ preco);
    }

    @PostMapping("/carrinho/desconto/{cupom}")
    public ResponseEntity<String> getPrecoTotal(@PathVariable("cupom") String cupom){

        if(cupom == null){
            return ResponseEntity.badRequest().body("Insira o CUPOM de desconto");
        }

        float valor = service.valorDesconto(cupom);

        if(valor == -1){
            return ResponseEntity.badRequest().body("Cupom invalido");
        }

        String preco = Float.toString(valor);
        return ResponseEntity.ok().body("Preco Total: "+ preco);
    }

    @PostMapping("/carrinho/limpar")
    public ResponseEntity<String> limparCarrinho(){
        service.limparCarrinho();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/carrinho/delete/{name}")
    public ResponseEntity<String> deletaProduto(@PathVariable ("name") String name){

        if(name == null){
            return ResponseEntity.badRequest().body("Insira o nome do pruduto");
        }

        if(!service.deleteByName(name)){
            return ResponseEntity.badRequest().body("Produto nao encontrado no carrinho");
        }

        return ResponseEntity.ok().build();
    }

}
