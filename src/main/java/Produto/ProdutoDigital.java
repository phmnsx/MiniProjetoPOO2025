package Produto;
import java.math.BigDecimal;

public class ProdutoDigital extends Produto {
    
    
    public ProdutoDigital(String nome, float preco, int estoque){
        super(nome, preco, estoque);
        this.estoque = 0;
    }
    
    @Override
    public void printProduto(){
        System.out.println("Produto (digital)" + this.codigo +": "+ this.nome + "  R$ " + this.preco);
    }
    
    @Override
    public BigDecimal comprar(int quantidade){
        //faz nada
        return BigDecimal.ZERO;
    }
}
