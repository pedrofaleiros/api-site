package pedro.iesb.apisite.validation;

import pedro.iesb.apisite.dto.ClienteDto;

public class ClienteValidation extends CartaoValidation {

    private final ValidarCPF validarCPF;

    public ClienteValidation(){
        this.validarCPF = new ValidarCPF();
    }

    public String verify(ClienteDto cliente){

        if(!validarCPF.validar(cliente.getCpf())){
            return "CPF invalido";
        }

        if(notValid(cliente.getEmail(), "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            return "Email invalido";
        }

        if(notValid(cliente.getName(), "^[[ ]|\\p{L}*]+$")){
            return "Nome invalido";
        }

        if(notValid(cliente.getPassword(), "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")){
            return "Senha invalida";
        }

        if(notValid(cliente.getTelefone().getTelefoneCelular(), "\\d{4,5}\\-\\d{4}")){
            return "Telefone Celular invalido";
        }

        if(notValid(cliente.getTelefone().getTelefoneResidencial(), "\\d{4,5}\\-\\d{4}")){
            return "Telefone Residencial invalido";
        }

        if(notValid(cliente.getTelefone().getTelefoneComercial(), "\\d{4,5}\\-\\d{4}")){
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
}
