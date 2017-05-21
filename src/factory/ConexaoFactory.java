package factory;

import java.sql.Connection;     //Conexão SQL para java
import java.sql.DriverManager;  //Drive de conexão SQL para java
import java.sql.SQLException;   //Classe para tratamento de exceções

public class ConexaoFactory {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/bdestacionamento","root","8492");
            //return DriverManager.getConnection("jdbc:mysql://192.168.25.125:3306/bdestacionamento","root","8492");
        }
        catch(SQLException excecao){
            throw new RuntimeException(excecao);
        }
    }
    
}