package modelo;

public class LoginValidar {
    
    boolean validacao;
    
    public boolean validaloginsenha(String login, String senha){
        
        if (login.equalsIgnoreCase("") || senha.equalsIgnoreCase("")){
            System.out.println("É necessário digitar Usuário e Senha para validação!!!");
        } else {
            if (login.equalsIgnoreCase("shirlei") && senha.equalsIgnoreCase("8492")){
                System.out.println("Login e Senha corretos!!!");
                validacao = true;
            } else {
                System.out.println("Login ou Senha incorreto(s)!!!");
                validacao = false;
            }
        }
    return validacao;
    }
}
