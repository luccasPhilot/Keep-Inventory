/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lucca
 */
public class ProdutoDAO {

    private String url = "jdbc:mysql://localhost:3306/keepinventoryBD";
    private String user = "root";
    private String password = "#Jp123jp123";
    private String driver = "com.mysql.cj.jdbc.Driver";

    public void inserirProduto(Produto produto) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO Produto (nome, preco) VALUES (?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getPreco());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    // Método para atualizar um produto
    public void atualizarProduto(Produto produto) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            String sql = "UPDATE Produto SET nome = ?, preco = ? WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getPreco());
            ps.setInt(3, produto.getId());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    // Método para deletar um produto
    public void deletarProduto(int id) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            String sql = "DELETE FROM Produto WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao deletar produto: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    // Método para buscar um produto por ID
    public Produto buscarProdutoPorId(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Produto produto = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM Produto WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                produto = new Produto(rs.getString("nome"), rs.getDouble("preco"));
                produto.setId(rs.getInt("id"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao buscar produto por ID: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }

        return produto;
    }

    // Método para buscar todos os produtos
    public List<Produto> buscarTodosProdutos() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM Produto";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto(rs.getString("nome"), rs.getDouble("preco"));
                produto.setId(rs.getInt("id"));
                produtos.add(produto);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao buscar todos os produtos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }

        return produtos;
    }

    // Método para buscar produtos por nome
    public List<Produto> buscarProdutosPorNome(String nome) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM Produto WHERE nome LIKE ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto(rs.getString("nome"), rs.getDouble("preco"));
                produto.setId(rs.getInt("id"));
                produtos.add(produto);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao buscar produtos por nome: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }

        return produtos;
    }
}
