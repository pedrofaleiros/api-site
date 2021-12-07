package pedro.iesb.apisite.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pedro.iesb.apisite.dto.ClienteDTO;
import pedro.iesb.apisite.service.imp.ClienteService;

import java.util.List;

@RestController
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping("/cliente")
    public ResponseEntity<String> cadastraCliente(@RequestBody ClienteDTO cliente){

        String retorno = service.cadastrar(cliente);

        if(retorno != null){
            return ResponseEntity.badRequest().body(retorno);
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/cliente")
    public List<ClienteDTO> getClientes(){
        return service.getClientes();
    }

    @PostMapping("cliente/login")
    public ResponseEntity<String> loginCliente(@RequestBody ClienteDTO cliente){

        String id = service.login(cliente);

        if(id == null){
            return ResponseEntity.notFound().build();
        }

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.add("Authorization", id);

        return ResponseEntity.ok().headers(responseHeader).build();
    }

}