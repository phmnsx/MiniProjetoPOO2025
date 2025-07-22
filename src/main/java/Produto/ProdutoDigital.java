package Produto;

import java.util.Scanner;

public class ProdutoDigital extends Produto {
    
    
    public ProdutoDigital(String nome, float preco, int estoque){
        super(nome, preco, estoque);
        this.estoque = 0;
    }
    
    @Override
    public void printProduto(){
        System.out.println("Produto (digital) " + this.codigo +": "+ this.nome + "  R$ " + this.preco);
    }
    
    @Override
    public boolean alterar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Que alteracao deseja?");
        System.out.println("1- Nome\n2- Preco\n");
        int escolha = Integer.parseInt((scanner.nextLine()).replaceAll(" ",""));
        
        if (escolha == 1){
            System.out.println("Coloque o novo nome: ");
            String nome = scanner.nextLine();
            setNome(nome);
            return true;
        } else if (escolha == 2){
            System.out.println("Coloque o novo preco: ");
            int preco =  Integer.parseInt((scanner.nextLine()).replaceAll(" ",""));
            setPreco(preco);
            return true;
        }
        else {
            System.out.println("Erro de alteracao");
            return false;
        }
    }
}
