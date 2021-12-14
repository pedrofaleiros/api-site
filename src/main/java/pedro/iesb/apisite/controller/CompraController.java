package pedro.iesb.apisite.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pedro.iesb.apisite.dto.PagamentoDto;
import pedro.iesb.apisite.response.CompraResponse;
import pedro.iesb.apisite.service.CompraServiceInterface;

@RestController
public class CompraController {

    private final CompraServiceInterface service;

    public CompraController(CompraServiceInterface service) {
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

        String retorno = service.finalizar();

        if(retorno == null){
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().body(retorno);
    }
}
