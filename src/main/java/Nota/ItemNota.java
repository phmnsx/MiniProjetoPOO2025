package Nota;
import java.math.BigDecimal;
import Produto.Produto;

public class ItemNota {
	private Produto produto;
	private int quantidade;
	
	public ItemNota (Produto produto, int quantidade){
		this.produto = produto;
		this.quantidade = quantidade;
		}

	 public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return produto.getPreco(); 
    }


    public BigDecimal getPrecoTotal() {
        return produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
    }
	
	public void printItemNota(){
		
	  System.out.println("Produto: " + produto.getNome());
	  System.out.println("Codigo: " + produto.getCodigo());
	  System.out.println("Quantidade: " + quantidade);
	  System.out.println("Preco unitario: " + getPrecoUnitario());
	  System.out.println("Total: " + getPrecoTotal());
	  System.out.print ("\n\n");
		}
}

