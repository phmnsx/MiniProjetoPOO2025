package Nota;
import java.time.LocalDate;
import java.math.BigDecimal;
import Produto.Produto;
import Cliente.Cliente;

public class Nota {
private Cliente pessoa;
private BigDecimal subtotal;
private ItemNota[] listaProdutos;
private String id;
private LocalDate data;
private static int ultimoId = 0;

	
public Nota (Cliente pessoa){
    this.pessoa = pessoa;
    this.subtotal = new BigDecimal(0f);
    this.id = Integer.toString(ultimoId++); 
    this.data = LocalDate.now();
    }

    public void colocaProduto (Produto produto, int quantidade){
        ItemNota item = new ItemNota(produto, quantidade);
        ItemNota [] listaItemNota = new ItemNota[listaProdutos.length + 1];
        System.arraycopy(listaProdutos, 0, listaItemNota, 0, listaProdutos.length);
        listaItemNota[listaProdutos.length] = item;
        listaProdutos = listaItemNota;

        subtotal = subtotal.add(item.getPrecoTotal());
    }

    public Cliente getPessoa(){
        return this.pessoa;
    }

    public BigDecimal getSubtotal(){
        return this.subtotal;
    }

    public String getId(){
        return this.id;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void emitirNota (){
        System.out.println ("Cliente: " + this.pessoa);
        System.out.println ("Subtotal: " + this.subtotal);
        System.out.println ("ID: " + this.id);
        System.out.println("Data da compra: " + this.data);
        System.out.println("Itens da compra:");

        for (int i = 0; i < listaProdutos.length; i++) {
            listaProdutos[i].printItemNota();
        }
    }

}
