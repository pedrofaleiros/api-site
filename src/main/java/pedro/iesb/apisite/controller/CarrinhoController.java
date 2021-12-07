package pedro.iesb.apisite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedro.iesb.apisite.dto.ItemCarrinhoDTO;
import pedro.iesb.apisite.service.imp.CarrinhoService;
import java.util.List;

@RestController
public class CarrinhoController {

    @Autowired
    private CarrinhoService service;

    @PostMapping("/carrinho")
    public ResponseEntity<String> criaCarrinho(@RequestBody ItemCarrinhoDTO item){

        String ret = service.adicionarProduto(item);

        if(ret != null){
            return ResponseEntity.badRequest().body(ret);
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/carrinho")
    public List<ItemCarrinhoDTO> getCarrinho(){
        return service.getProdutos();
    }

    @GetMapping("/carrinho/preco")
    public ResponseEntity<String> getPrecoTotal(){
        String preco = Float.toString(service.valorTotal());
        return ResponseEntity.ok().body("Preco Total: "+ preco);
    }

    @GetMapping("/carrinho/desconto")
    public ResponseEntity<String> getPrecoTotal(@RequestParam (required = false) String desconto){

        if(desconto == null){
            return ResponseEntity.badRequest().build();
        }

        float valor = service.valorDesconto(desconto);

        if(valor == -1){
            return ResponseEntity.badRequest().body("Desconto invalido");
        }

        String preco = Float.toString(valor);
        return ResponseEntity.ok().body("Preco Total: "+ preco);
    }

    @PostMapping("/carrinho/limpar")
    public ResponseEntity<String> limparCarrinho(){
        service.limparCarrinho();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/carrinho/delete")
    public ResponseEntity<String> deletaProduto(@RequestParam (required = false) String nome){

        if(nome == null){
            return ResponseEntity.badRequest().body("Insira o nome do pruduto");
        }

        if(!service.deleta(nome)){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

}
