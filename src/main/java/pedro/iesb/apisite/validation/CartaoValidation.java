package pedro.iesb.apisite.validation;

import pedro.iesb.apisite.model.Cartao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CartaoValidation{

    public String verify(Cartao cartao){

        if(notValid(cartao.getCvv(), "[0-9]{3,4}$")){
            return "CVV invalido";
        }

        if(notValid(cartao.getNumero(), "[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}$")){
            return "Numero do cartao invalido";
        }

        if(notValid(cartao.getName(), "^[[ ]|\\p{L}*]+$") ||
                cartao.getName().split(" ").length < 2){
            return "Nome invalido";
        }

        if(notValid(cartao.getDataValidade(), "[0-1]{1}[0-9]/[2]{1}[0-9]{1}$")){
            return "Data invalida";
        }

        return null;
    }

    public boolean notValid(String str, String regex){
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(str);

        return !matcher.matches();
    }
}
