package pedro.iesb.apisite.validation;

import pedro.iesb.apisite.dto.ClienteDto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClienteValidation {

    private final ValidarCPF validarCPF;

    public ClienteValidation(){
        this.validarCPF = new ValidarCPF();
    }

    public String verify(ClienteDto cliente){

        if(!verifyWithRegex(cliente.getEmail(), "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            return "Email invalido";
        }

        if(!verifyWithRegex(cliente.getName(), "^[[ ]|\\p{L}*]+$")){
            return "Nome invalido";
        }

        if(!verifyWithRegex(cliente.getPassword(), "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")){
            return "Senha invalida";
        }

        if(!validarCPF.validar(cliente.getCpf())){
            return "CPF invalido";
        }

        if(!verifyWithRegex(cliente.getTelefone().getTelefoneCelular(), "\\d{4,5}\\-\\d{4}")){
            return "Telefone Celular invalido";
        }

        if(!verifyWithRegex(cliente.getTelefone().getTelefoneResidencial(), "\\d{4,5}\\-\\d{4}")){
            return "Telefone Residencial invalido";
        }

        if(!verifyWithRegex(cliente.getTelefone().getTelefoneComercial(), "\\d{4,5}\\-\\d{4}")){
            return "Telefone Comercial invalido";
        }

        if(cliente.getEndereco().getEnderecoComercial().equals("")){
            return "Endereco Comercial Invalido";
        }

        if(cliente.getEndereco().getEnderecoResidencial().equals("")){
            return "Endereco Residencial Invalido";
        }

        return null;
    }

    private boolean verifyWithRegex(String str, String regex){
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }
}
