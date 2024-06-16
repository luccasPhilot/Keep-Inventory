/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Model.Produto;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author lucca
 */
public class ProdutoDAO {
    static Connection conn = null;
    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/keepinventorybd";
    public static String user= "root";
    public static String password = "";
    
    public void inserirProduto(Produto produto){
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            String sql1 = "INSERT INTO produto (nome, preco) VALUES(?,?)";
            ps = conn.prepareStatement(sql1);
            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getPreco());
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            System.out.println("Falha no carregamento do Driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Falha na inserção de valores em produtos: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}
