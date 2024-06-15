/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author lucca
 */
public class EstoqueDAO {
    static Connection conn = null;
    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/keepinventorybd";
    public static String user= "root";
    public static String password = "";
    
    public void testeConnection (){
        try{
            System.out.println("Carregando o driver...");
            Class.forName(driver);
            System.out.println("Driver carregado com sucesso!");
        }catch(Exception e){
            System.out.println("Falha no carregamento!");
        }

        try{
            System.out.println("Tentando conectar o BD...");
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("BD conectado com sucesso!");
        }catch(Exception e){
            System.out.println("Falha no carregamento!");
        }

    }
}
