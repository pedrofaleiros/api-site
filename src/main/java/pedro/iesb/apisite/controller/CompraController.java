package pedro.iesb.apisite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pedro.iesb.apisite.dto.PagamentoDto;
import pedro.iesb.apisite.model.entities.CompraEntity;
import pedro.iesb.apisite.response.CompraResponse;
import pedro.iesb.apisite.service.imp.CompraService;

import java.util.List;

@RestController
public class CompraController {

    private final CompraService service;

    public CompraController(CompraService service) {
        this.service = service;
    }

    @GetMapping("/compra")
    public ResponseEntity<CompraResponse> getDados(){
        return ResponseEntity.ok().body(service.getDados());
    }

    @PostMapping("/compra")
    public ResponseEntity<String> compra(@RequestBody PagamentoDto dados){

        String retorno = service.compra(dados);

        if(retorno != null){
            return ResponseEntity.badRequest().body(retorno);
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/compra/finalizar")
    public ResponseEntity<String> compra(){

        if(service.finalizar()){
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().body("nenhum usuario logado");
    }
}
