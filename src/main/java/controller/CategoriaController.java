package controller;

import dao.CategoriaDAO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import model.Categoria;

/**
 * 
 * @author lojademoveis.com.br
 */
public class CategoriaController {

//    /**
//     * Método para salvar um produto na memória ou na base de dados.
//     * 
//     * @param prProduto String nome do produto
//     * @param prTipo String tipo descritivo do produto
//     * @param prPreco double valor de venda do produto
//     * @return <code>boolean</code> true: sucesso, false: falho
//     */
//    public static boolean Salvar(String nome, String descricao, Double precoCompra, Double precoVenda, int quantidade, boolean disponivel) {
//        //Salvo na memória
//        Produto pr = new Produto(null, nome, descricao, precoCompra, precoVenda, quantidade, disponivel);
//        return ProdutoDAO.salvar(pr);
//    }
    
//    /**
//     * Método para excluir determinado produto.
//     * 
//     * @param indice inteiro com a localização da linha que contém o produto a ser excluído
//     * @return <code>boolean</code> true: sucesso, false: falho
//     */
//    public static boolean Excluir(int indice) {
//        return ProdutoDAO.excluir(indice);
//    }
//
//    /**
//     * Método para atualizar determinado produto.
//     * 
//     * @param prIdProduto inteiro ID do produto
//     * @param prProduto String nome do produto
//     * @param prTipo String tipo descritivo do produto
//     * @param prPreco double valor de venda do produto
//     * @return <code>boolean</code> true: sucesso, false: falho
//     */
//    public static boolean Atualizar(int prIdProduto, String prProduto, String prTipo, double prPreco, int prQuantidade) {
//        Produto pr = new Produto(prIdProduto, prProduto, prTipo, prPreco, prQuantidade);
//        return ProdutoDAO.atualizar(pr);
//
//    }
//
    /**
     * Transforma uma lista de objetos Cliente em uma lista de Strings
     *
     * @return lista de string
     */
    public static ArrayList<String> getCategorias() {
        ArrayList<Categoria> categorias = CategoriaDAO.getCategorias();
        ArrayList<String> listaCategorias = new ArrayList<>();
        listaCategorias.add(categorias.toString());
        return listaCategorias;

    }

}
