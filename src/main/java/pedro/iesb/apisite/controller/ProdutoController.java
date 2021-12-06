package pedro.iesb.apisite.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedro.iesb.apisite.dto.ProdutoDTO;
import pedro.iesb.apisite.service.imp.ProdutoService;

import java.util.List;

@RestController
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service){
        this.service = service;
    }

    @PostMapping("/produto")
    public ResponseEntity<String> cadastraProduto(@RequestBody ProdutoDTO produto){

        String retorno = service.cadastrar(produto);

        if(retorno != null){
            return ResponseEntity.badRequest().body(retorno);
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/produto")
    public ResponseEntity<List<ProdutoDTO>> mostraProdutos(){
        return ResponseEntity.ok(service.getProdutos());
    }

    @PutMapping("/produto")
    public ResponseEntity<String> atualizaProduto(@RequestParam(required = false) String name,
                                                  @RequestBody ProdutoDTO prod){

        if(name == null){
            return ResponseEntity.badRequest().body("Insira o nome");
        }

        String retorno = service.atualizar(prod, name);

        if(retorno != null){
            return ResponseEntity.badRequest().body(retorno);
        }

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/produto")
    public ResponseEntity<String> deletaProduto(@RequestBody ProdutoDTO prod){
        if(service.deleta(prod)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body("Nao foi possivel deletar produto");
    }
}
