package pedro.iesb.apisite.repository;

import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository {

    private String login;
    private static final LoginRepository instancia = new LoginRepository();

    private LoginRepository(){
        this.login = null;
    }

    public static LoginRepository getInstancia(){
        return instancia;
    }

    public boolean logged(String id){
        if(login == null){
            return false;
        }
        return login.equals(id);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
