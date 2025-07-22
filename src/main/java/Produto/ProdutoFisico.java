
package Produto;

public class ProdutoFisico extends Produto{
    
    protected int estoque;
    
    public ProdutoFisico(String nome, float preco, int estoque){
            super(nome, preco);
            this.estoque = estoque;
    }
    
    public int getEstoque(){
        return estoque;
    }
    
    public void setEstoque(int estoque){
        if (estoque >= 0){
            this.estoque = estoque;
        }
        
    }
    
    public void print(){
        System.out.println("Produto (fisico) " + this.codigo +": "+ this.nome + "  #" + this.estoque + "  R$ " +this.preco);
    }
}
