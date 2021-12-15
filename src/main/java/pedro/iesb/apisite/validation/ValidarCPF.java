package pedro.iesb.apisite.validation;

public class ValidarCPF {

    public boolean validar(String cpf) {

        cpf = cpf.replace("-", "");
        cpf = cpf.replace(".", "");

        if(cpf.equals("")){
            return false;
        }

        if(cpf.length() != 11 ||
                cpf.equals("00000000000") || cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999")){
            return false;
        }

        // Validar 1o digito
        int add = 0;
        for(int i=0; i < 9; i ++) {
            add += Integer.parseInt(String.valueOf(cpf.charAt(i))) * (10 - i);
        }

        int rev = 11 - (add % 11);
        if(rev == 10 || rev == 11){
            rev = 0;
        }

        if(rev != Integer.parseInt(String.valueOf(cpf.charAt(9)))){
            return false;
        }
        // Validar 2o digito
        add = 0;
        for(int i = 0; i < 10; i ++){
            add += Integer.parseInt(String.valueOf(cpf.charAt(i))) * (11 - i);
        }
        rev = 11 - (add % 11);

        if(rev == 10 || rev == 11) {
            rev = 0;
        }

        if(rev != Integer.parseInt(String.valueOf(cpf.charAt(10)))){
            return false;
        }

        return true;
    }
}
