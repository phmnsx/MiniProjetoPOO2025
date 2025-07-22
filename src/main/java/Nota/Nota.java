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
    private static Nota[] notasEmitidas;


    public Nota (Cliente pessoa){
        this.pessoa = pessoa;
        this.subtotal = new BigDecimal(0f);
        this.id = Integer.toString(ultimoId++); 
        this.data = LocalDate.now();
    }

    public void colocaProduto (Produto produto, int quantidade){
        ItemNota item;
        if (this.listaProdutos == null){
            listaProdutos = new ItemNota[1];
            item = new ItemNota(produto, quantidade);
            listaProdutos[0] = item;
        }
        else{
            item = new ItemNota(produto, quantidade);
            ItemNota [] listaItemNota = new ItemNota[listaProdutos.length + 1];
            System.arraycopy(listaProdutos, 0, listaItemNota, 0, listaProdutos.length);
            listaItemNota[listaProdutos.length] = item;
            listaProdutos = listaItemNota;
        }
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
    
    public static Nota[] getListaNotas(){
        return notasEmitidas;
    }

    public void printNota (){
        System.out.println("----------");
        this.pessoa.printCliente();
        System.out.println("----------");
        System.out.println ("Total: " + this.subtotal);
        System.out.println ("ID: " + this.id);
        System.out.println("Data da compra: " + this.data);
        System.out.println("Itens da compra:");
        System.out.println("----------");
        for (int i = 0; i < listaProdutos.length; i++) {
            listaProdutos[i].printItemNota();
        }
    }
    
    public void emitirNota (){
        if (notasEmitidas == null){
            notasEmitidas = new Nota[1];
            notasEmitidas[0] = this;
        }
        else{
            Nota [] novaLista = new Nota [notasEmitidas.length + 1];
            System.arraycopy(notasEmitidas, 0, novaLista, 0, notasEmitidas.length );
            novaLista[notasEmitidas.length] = this;
            notasEmitidas = novaLista;
            System.out.println ("Subtotal: " + this.subtotal);
            System.out.println("Itens da compra: ");
        }
	
        
        for (int i = 0; i < listaProdutos.length; i++) {
            listaProdutos[i].printItemNota();
        }
     }
}

