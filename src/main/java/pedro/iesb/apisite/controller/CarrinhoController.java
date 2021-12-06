package pedro.iesb.apisite.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pedro.iesb.apisite.dto.ItemCarrinhoDTO;
import pedro.iesb.apisite.dto.ProdutoDTO;

import java.util.List;

@RestController
public class CarrinhoController {

    @PostMapping("/carrinho")
    public ResponseEntity<String> criaCarrinho(@RequestBody List<ItemCarrinhoDTO> carrinho){



        return null;
    }

    @PostMapping("/carrinho/adicionar")
    public ResponseEntity<String> adicionaProduto(@RequestBody ProdutoDTO produto){



        return null;
    }

    @GetMapping("/carrinho")
    public List<ItemCarrinhoDTO> getCarrinho(){
        return null;
    }

}
