package Nota;
import java.time.LocalDate;
import java.math.BigDecimal;
import Nota.ItemNota;
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
		printNota();
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

	public void setPessoa (Cliente pessoa){
		this.pessoa = pessoa;
		}
		
	public void setSubtotal (BigDecimal subtotal){
		this.subtotal = subtotal;
		}
	
	public void setId (String id){
		this.id = id;
		}
		
	public void setData(LocalDate novaData) {
    this.data = novaData;
	}
	
	public void printNota (){
		System.out.println ("Cliente: " + this.pessoa);
		System.out.println ("Subtotal: " + this.subtotal);
		System.out.println ("ID: " + this.id);
		System.out.println("Data da compra: " + this.data);
		System.out.print ("\n\n");
		System.out.println("Itens da nota:");
		for (int i = 0; i < listaProdutos.length; i++) {
        listaProdutos[i].printItemNota();
		}
		}
		
}
