package pedro.iesb.apisite.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedro.iesb.apisite.dto.ProdutoDto;
import pedro.iesb.apisite.service.imp.ProdutoService;
import java.util.List;

@RestController
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service){
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
