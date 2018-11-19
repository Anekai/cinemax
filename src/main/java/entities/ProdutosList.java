
package entities;

import java.util.ArrayList;
import java.util.List;

public class ProdutosList {

    private List<Produto> produtos;

    public ProdutosList(){
        produtos = new ArrayList<Produto>();
    }

    public void setProdutos(List<Produto> elbows){
        this.produtos.clear();
        this.produtos = elbows;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void add(Produto produto){
        produtos.add(produto);
    }

}
