package pedro.iesb.apisite.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedro.iesb.apisite.dto.ProdutoDto;
import pedro.iesb.apisite.service.ProdutoServiceInterface;
import java.util.List;

// service nao sabe onde e qual repositorio ele ta chamando, so chama
// chamando a serviceInterface - liskov --> ele nao sabe qual service ta chamando,
// o interesse da controller é se a serviceInterface tem os metodos que ta chamando

@RestController
public class ProdutoController {

    private final ProdutoServiceInterface service;

    public ProdutoController(ProdutoServiceInterface service){
        this.service = service;
    }

    @PostMapping("/produto")
    public ResponseEntity<String> cadastraProduto(@RequestBody ProdutoDto produto){

        String retorno = service.cadastrar(produto);

        if(retorno != null){
            return ResponseEntity.badRequest().body(retorno);
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/produto")
    public ResponseEntity<List<ProdutoDto>> mostraProdutos(){
        return ResponseEntity.ok(service.getProdutos());
    }

    @PutMapping("/produto/{name}")
    public ResponseEntity<String> atualizaProduto(@PathVariable ("name") String name,
                                                  @RequestBody ProdutoDto prod){

        String retorno = service.atualizar(prod, name);

        if(retorno != null){
            return ResponseEntity.badRequest().body(retorno);
        }

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/produto/{name}")
    public ResponseEntity<String> deletaProduto(@PathVariable ("name") String name){
        if(service.deleta(name)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body("Nao foi possivel deletar produto");
    }
}
