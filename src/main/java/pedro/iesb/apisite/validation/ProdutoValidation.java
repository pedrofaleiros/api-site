package pedro.iesb.apisite.validation;

import pedro.iesb.apisite.dto.ProdutoDto;

public class ProdutoValidation {

    public String verify(ProdutoDto prod){

        if(prod.getName().equals("") || prod.getName().split(" ").length > 1){
            return "Nome invalido";
        }

        if(prod.getPrice() <= 0){
            return "Preco invalido";
        }

        if(prod.getDescription().equals("")){
            return "Descricao invalida";
        }

        if(prod.getQtd() <= 0){
            return "Quantidade invalida";
        }

        return null;
    }


}
