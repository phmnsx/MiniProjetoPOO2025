package Produto;
import java.time.LocalDate;
public class ProdutoPerecivel extends Produto {
    
    private int mesValidade;
    
    public ProdutoPerecivel(String nome, float preco, int estoque, int mesValidade){
        super(nome, preco, estoque);
        this.mesValidade = mesValidade;
    }
    
    public LocalDate getDataValidade(){
        LocalDate data = LocalDate.now().plusMonths(mesValidade);
        return data;
    }
    
    public void setDataValidade(int mesValidade){
        if (mesValidade > 0){
           this.mesValidade = mesValidade;
        }
    }
    
    @Override
    public void printProduto(){
        System.out.println("Produto (perecivel)" + this.codigo +": "+ this.nome + "  #" + this.estoque + "  R$ " +this.preco + " Data de Validade:" + getDataValidade().toString());
    }
}
