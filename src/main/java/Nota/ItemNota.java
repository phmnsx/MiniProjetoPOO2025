package Nota;
import java.math.BigDecimal;
import Produto.Produto;

public class ItemNota {
    private Produto produto;
    private int quantidade;
    private BigDecimal subtotal;

    public ItemNota (Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
    }
    public BigDecimal getPrecoTotal() {
        return subtotal;
    }

    public void printItemNota(){

        System.out.println("Produto: " + produto.getNome());
        System.out.println("Codigo: " + produto.getCodigo());
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Preco unitario: " + getPrecoTotal());
        System.out.println("Subtotal: " + this.subtotal);
        System.out.print ("\n");
    }
}

