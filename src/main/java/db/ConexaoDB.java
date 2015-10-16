
package db;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;


public class ConexaoDB {
    public static String status = "Não conectou...";
    
    public ConexaoDB(){
    }
    
    public static java.sql.Connection getConexaoMySQL() { 
        Connection connection = null;
        try { 
            String driverName = "com.mysql.jdbc.Driver"; 
            Class.forName(driverName); 
            String serverName = "127.3.254.2";
            String mydatabase ="estoque";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase; 
            String username = "admincwYbxuU";     
            String password = "kAJJp5L98VEX"; 
            connection = DriverManager.getConnection(url, username, password); 
            if (connection != null) {
                status = ("Conectado com sucesso!");
            } 
            else {
                status = ("Não foi possivel realizar conexão");
            } 
            return connection; 
        } 
        catch (ClassNotFoundException e) {    
            System.out.println("O driver expecificado nao foi encontrado."); 
            return null; 
        } 
        catch (SQLException e) { //Não conseguindo se conectar ao banco 
            System.out.println("Nao foi possivel conectar ao Banco de Dados."); 
            return null; 
        } 
    } 
    
    public static String statusConection() { 
        return status; 
    } 
    
    public static boolean FecharConexao() {
        try {             
        ConexaoDB.getConexaoMySQL().close(); 
        status = ("Conexão finalizada pelo usuário");
        return true;         
        } catch (SQLException e) { 
            return false; 
        } 
    } 
    
    public static java.sql.Connection ReiniciarConexao() { 
        FecharConexao(); 
        return ConexaoDB.getConexaoMySQL(); 
    } 
}


