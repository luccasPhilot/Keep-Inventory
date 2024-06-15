/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.*;

/**
 *
 * @author lucca
 */
public class ConnectBD {
    static Connection conn = null;
    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/keepinventorybd";
    public static String user= "root";
    public static String password = "nybrsh39";
    
    
    public static void connect() {
        try{
            System.out.println("Carregando Driver...");
            Class.forName(driver);
            System.out.println("Driver carregado com sucesso");
        }catch(Exception e){
            System.out.println("Falha no carregamento do Driver.");
        }
        
        try{
            System.out.println("Conectando o BD...");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão feita com sucesso");
        }catch(Exception e){
            System.out.println("Falha na Conexão.");
        }
        
    }
    
}
