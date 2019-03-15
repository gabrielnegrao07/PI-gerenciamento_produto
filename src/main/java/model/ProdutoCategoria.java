package model;

public class ProdutoCategoria {
    
    private Integer idProduto;
    private Integer idCategoria;

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto produto) {
        this.idProduto = produto.getIdProduto();
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria categoria) {
        this.idCategoria = categoria.getId();
    }   
}
