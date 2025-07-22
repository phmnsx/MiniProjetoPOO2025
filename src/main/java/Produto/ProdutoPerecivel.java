package Produto;
import java.time.LocalDate;
import java.util.Scanner;
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
        System.out.println("Produto (perecivel) " + this.codigo +": "+ this.nome + "  #" + this.estoque + "  R$ " +this.preco + " Data de Validade: " + getDataValidade().toString());
    }
    
    @Override
    public boolean alterar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Que alteracao deseja?");
        System.out.println("1- Nome\n2- Preco\n3- Estoque\n4 - Mes de Validade");
        int escolha = Integer.parseInt((scanner.nextLine()).replaceAll(" ",""));
        
        if (escolha == 1){
            System.out.println("Coloque o novo nome: ");
            String nome = scanner.nextLine();
            setNome(nome);
            return true;
        } else if (escolha == 2){
            System.out.println("Coloque o novo preco: ");
            int preco = Integer.parseInt((scanner.nextLine()).replaceAll(" ",""));
            setPreco(preco);
            return true;
        }else if (escolha == 3){
            System.out.println("Coloque o novo estoque: ");
            int estoque = Integer.parseInt((scanner.nextLine()).replaceAll(" ",""));
            setEstoque(estoque);
            return true;
        }else if (escolha == 4){
            System.out.println("Coloque a quantidade de meses até a validade: ");
            int mesValidade = Integer.parseInt((scanner.nextLine()).replaceAll(" ",""));
            setDataValidade(mesValidade);
            return true;
        }
        else {
            System.out.println("Erro de alteracao");
            return false;
        }
    }
}
