/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categoria;
import utils.GerenciadorConexao;

/**
 *
 * @author lojademoveis.com.br
 * @see Controller.ProdutoController
 */
public class CategoriaDAO {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    private static final String SERVIDOR = "localhost";     //servidor de banco de dados
    private static final String BASEDADOS = "produtobd";      //nome da base de dados
    private static final String LOGIN = "root";             //nome de um usuário do banco de dados
    private static final String SENHA = "";                 //sua senha de acesso
    private static String url = "";
    private static Connection conexao;
    
    /**
     * Método para inserir produtos no banco de dados.
     * 
     * @param p objeto do tipo Produto
     * @return <code>boolean</code> true: sucesso, false: falha;
     */
    public static boolean salvar(Produto p)
    {
        
        boolean retorno = false;
        
        //Crio um comando PreparedStatement utilizando minha classe de conexão
        PreparedStatement comando = GerenciadorConexao.getPreparedStatement("INSERT INTO Produto (Modelo,Tipo,Preco,Quantidade) VALUES(?,?,?,?);");
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        try {
            comando.setString(1,p.getNome());
            comando.setString(2,p.getdescricao());
            comando.setString(3,String.valueOf(p.getPrecoCompra()));
            comando.setString(4,String.valueOf(p.getPrecoVenda()));
            comando.setString(5, String.valueOf(p.getQuantidade()));
            comando.setString(6, String.valueOf(p.isDisponivel()));
            comando.setString(7, String.valueOf(p.getDtCadastro()));
            
            retorno = GerenciadorConexao.executarUpdate();
            
        } catch (SQLException ex) {
            retorno = false;
        }
        finally{
            GerenciadorConexao.fecharConexao();
        }
        
        return retorno;
    }
    
    /**
     * Método para atualizar os produtos do banco de dados.
     * 
     * @param p objeto do tipo Produto
     * @return <code>boolean</code> true: sucesso, false: falha;
     */
//    public static boolean atualizar(Produto p)
//    {
//        //Simulo um  UPDATE no banco de dados (UPDATE TabelaXYZ SET...)
//        //return SimulaDB.getInstance().AtualizarCliente(p);
//        boolean retorno = false;
//        
//        PreparedStatement comando = GerenciadorConexao.getPreparedStatement("UPDATE Produto SET Modelo=?, Tipo=?, Preco=?, Quantidade=? WHERE IdProduto=?;");
//        
//        try {
//            comando.setString(1,p.getModelo());
//            comando.setString(2,p.getTipo());
//            comando.setString(3,String.valueOf(p.getPreco()));
//            comando.setInt(4,p.getQuantidade());
//            comando.setInt(5,p.getId());
//            retorno = GerenciadorConexao.executarUpdate();
//            
//        } catch (SQLException ex) {
//            retorno = false;
//        }
//        finally{
//            GerenciadorConexao.fecharConexao();
//        }
//        
//        return retorno;
//        
//    }
    
    /**
     * Método para excluir determinado produto do banco de dados.
     * 
     * @param pID número inteiro referente ao ID do produto
     * @return <code>boolean</code> true: sucesso, false: falha;
     */
    public static boolean excluir(int pID)
    {
        boolean retorno = false;
        
        PreparedStatement comando = GerenciadorConexao.getPreparedStatement("DELETE FROM Produto WHERE IdProduto=?;");
        
        try {
            comando.setInt(1,pID);
            retorno = GerenciadorConexao.executarUpdate();
            
        } catch(SQLException ex) {
            retorno = false;
        }
        finally{
            GerenciadorConexao.fecharConexao();
        }
        
        return retorno;
                       
    }
    /**
     * Método para retornar todos os produtos do banco.
     * 
     * @return <code>ArrayList(Produto)</code> retorna todos os clientes cadastrados no banco de dados;
     */
    public static ArrayList<Categoria> getCategorias()
    {
        ArrayList<Categoria> listaCategorias = new ArrayList<>();
        
        try {
            //return SimulaDB.getInstance().getClientes();
            
            //Tento carregar o driver para conectar ao MySQL
            Class.forName(DRIVER);
            url = "jdbc:mysql://" + SERVIDOR + ":3306/" + BASEDADOS;
            conexao = DriverManager.getConnection(url,LOGIN,SENHA);
            
            Statement comando = conexao.createStatement();
            
            ResultSet rs = comando.executeQuery("SELECT * FROM Categoria;");
            while(rs.next())
            {
                Categoria c = new Categoria();
//                c.setId(rs.getInt("Id"));
                c.setNome(rs.getString("Nome"));
                
                listaCategorias.add(c);
            }
            rs.close();
            
        } catch (ClassNotFoundException ex) {
            listaCategorias = null;
        } catch (SQLException ex) {
            listaCategorias = null;
        }finally{
        
            try {
                if(conexao!=null)
                {
                    if(!conexao.isClosed())
                        conexao.close();
                    else
                    {
                        System.out.println("Conexão já fechada");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
        return listaCategorias;
       
    }
//    
//    
//    public static ArrayList<Produto> getProdutosPorModelo(String pModelo)
//    {
//        ArrayList<Produto> listaProdutos = new ArrayList<>();
//        
//        try {
//            //return SimulaDB.getInstance().getClientes();
//            
//            //Tento carregar o driver para conectar ao MySQL
//            Class.forName(DRIVER);
//            url = "jdbc:mysql://" + SERVIDOR + ":3306/" + BASEDADOS;
//            conexao = DriverManager.getConnection(url,LOGIN,SENHA);
//            
//            //Statement comando = conexao.createStatement();
//            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM Produto WHERE Modelo LIKE ? ");
//            comando.setString(1, pModelo + "%");
//            ResultSet rs = comando.executeQuery();
//            //ResultSet rs = comando.executeQuery("SELECT * FROM cliente WHERE nome LIKE'%" + pNome + "%';");
//            
//            while(rs.next())
//            {
//                Produto p = new Produto();
//                p.setId(rs.getInt("IdProduto"));
//                p.setModelo(rs.getString("Modelo"));
//                p.setTipo(rs.getString("Tipo"));
//                p.setPreco(rs.getDouble("Preco"));
//                p.setQuantidade(rs.getInt("Quantidade"));
//                
//                listaProdutos.add(p);
//            }
//            rs.close();
//            
//        } catch (ClassNotFoundException ex) {
//            listaProdutos = null;
//        } catch (SQLException ex) {
//            listaProdutos = null;
//        }finally{
//        
//            try {
//                if(!conexao.isClosed())
//                    conexao.close();
//                else
//                {
//                    System.out.println("Conexão já fechada");
//                }
//            } catch (SQLException ex) {
//                listaProdutos = null;
//            }
//        
//        }
//        
//        return listaProdutos;
//       
//        
//    }
//    
}
