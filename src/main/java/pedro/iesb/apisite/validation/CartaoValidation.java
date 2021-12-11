package pedro.iesb.apisite.validation;

import pedro.iesb.apisite.model.Cartao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CartaoValidation {

    public String verify(Cartao cartao){

        return null;
    }

    protected boolean verifyWithRegex(String str, String regex){
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }
}
