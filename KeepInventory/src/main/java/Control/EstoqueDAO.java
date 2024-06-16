/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Model.Estoque;
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

    public void inserirEstoque(Estoque estoque) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO Estoque (qtdProdutos) VALUES (?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, estoque.getQtdProdutos());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao inserir estoque: " + e.getMessage());
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
