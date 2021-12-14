package pedro.iesb.apisite.validation;

import pedro.iesb.apisite.model.Cartao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CartaoValidation {

    public String verify(Cartao cartao){

        if(verifyWithRegex(cartao.getCvv(), "[0-9]{3, 4}$")){
            return "CVV invalido";
        }

        if(verifyWithRegex(cartao.getNumero(), "[0-9]{16}$")){
            return "Numero do cartao invalido";
        }

        if(verifyWithRegex(cartao.getName(), "^[[ ]|\\p{L}*]+$") ||
                cartao.getName().split(" ").length < 2){
            return "Nome invalido";
        }

        if(verifyWithRegex(cartao.getDataValidade(), "[0-1]{1}[0-9]\\/\\[2]{1}[0-9]{1}$")){
            return "Data invalida";
        }

        return null;
    }

    protected boolean verifyWithRegex(String str, String regex){
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }
}
