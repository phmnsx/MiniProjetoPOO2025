import java.util.Scanner;
import UI.*;
import Produto.*;
import Cliente.*;
        
public class Main {
    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);
        ConsoleMenu menu = new ConsoleMenu(scanner);
        int opcao = 0;
        do{
            System.out.println("Menu da \"Loja\"\n");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Alterar Produto");
            System.out.println("3 - Cadastrar Cliente");
            System.out.println("4 - Alterar Cliente");
            System.out.println("5 - Criar Nota");
            System.out.println("6 - Listar Notas Emitidas");
            System.out.println("7 - Listar Produtos");
            System.out.println("8 - Listas Clientes");
            System.out.println("0 - Sair");
            int opcao = Integer.parseInt((this.scanner.nextLine()).replaceAll(" ",""));
            
            if(opcao == 1){
                menu.cadastrarProduto();
            }
            if(opcao == 2){
                System.out.println("Digite o codigo do produto a ser alterado.");
                String auxiliar = scanner.nextLine();
                Produto produto = Produto.getProdutoCodigo(auxiliar);
                if(produto == null){
                    System.out.println("Produto não encontrado.");
                }
                else
                menu.alterarProduto(produto);
            }
            if(opcao == 3)
                menu.cadastrarCliente();
            if(opcao == 4){
                System.out.println("Digite o codigo do cliente a ser alterado.");
                String auxiliar = scanner.nextLine();
                Cliente cliente = Cliente.getClienteCodigo(auxiliar);
                if(cliente == null){
                    System.out.println("Produto não encontrado.");
                }
                else
                menu.alterarCliente(cliente);
            }
            if(opcao == 5)
                menu.criarNota();
            if(opcao == 6)
                menu.listarNotasEmitidas();
            if(opcao == 7)
                menu.listarProdutos();
            if(opcao == 8)
                menu.listarClientes();
        }while(opcao != 0);
    }
}
