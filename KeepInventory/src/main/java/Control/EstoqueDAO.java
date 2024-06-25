/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Model.Estoque;
import Model.Produto;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

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
    
    // Método para inserir estoque
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
    
    // Método para atualizar estoque
    public void atualizarEstoque(Estoque estoque) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            String sql = "UPDATE Estoque SET qtdProdutos = ? WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, estoque.getQtdProdutos());
            ps.setInt(2, estoque.getId());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao atualizar estoque: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    // Método para deletar estoque
    public void deletarEstoque(int id) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            String sql = "DELETE FROM Estoque WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao deletar estoque: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    // Método para buscar estoque por ID
    public Estoque buscarEstoquePorId(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Estoque estoque = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM Estoque WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                estoque = new Estoque();
                estoque.setId(rs.getInt("id"));
                estoque.setQtdProdutos(rs.getInt("qtdProdutos"));
                // Aqui você pode buscar os produtos associados ao estoque se necessário
                // usando um DAO para Estoque_Produto ou algo similar
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao buscar estoque: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }

        return estoque;
    }

    // Método para listar todos os estoques
    public List<Estoque> listarTodosEstoques() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Estoque> estoques = new ArrayList<>();

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM Estoque";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Estoque estoque = new Estoque();
                estoque.setId(rs.getInt("id"));
                estoque.setQtdProdutos(rs.getInt("qtdProdutos"));
                // Aqui você pode buscar os produtos associados ao estoque se necessário
                // usando um DAO para Estoque_Produto ou algo similar
                estoques.add(estoque);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao listar estoques: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }

        return estoques;
    }
}
