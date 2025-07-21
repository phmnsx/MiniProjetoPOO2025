package UI;
import Nota.*;
import java.util.Scanner;
import Produto.*;
import Cliente.*;



public class ConsoleMenu {
	
    private Scanner scanner;

    public ConsoleMenu(Scanner scanner){
    this.scanner = scanner;

    }

    public boolean cadastrarProduto (){
        System.out.println("Coloque o nome: ");
        String nome = this.scanner.nextLine();

        System.out.println("Coloque o preco: ");
        int preco =  Integer.parseInt((this.scanner.nextLine()).replaceAll(" ",""));

        System.out.println("Coloque o estoque: ");
        int estoque = Integer.parseInt((this.scanner.nextLine()).replaceAll(" ",""));
        if(preco < 0 || estoque < 0 || nome.replaceAll(" ","").equals("")){
            System.out.println("Produto invalido.");
            return false;
        }
        Produto p = new Produto (nome, preco, estoque);
        return true;
    }

    public boolean alterarProduto (Produto produto){
        System.out.println("Que alteracao deseja?");
        System.out.println("1- Nome\n2- Preco\n3- Estoque");
        int escolha = Integer.parseInt((this.scanner.nextLine()).replaceAll(" ",""));
        
        if (escolha == 1){
            System.out.println("Coloque o novo nome: ");
            String nome = this.scanner.nextLine();
            produto.setNome(nome);
            return true;
        } else if (escolha == 2){
            System.out.println("Coloque o novo preco: ");
            int preco =  Integer.parseInt((this.scanner.nextLine()).replaceAll(" ",""));
            produto.setPreco(preco);
            return true;
        }else if (escolha == 3){
            System.out.println("Coloque o novo estoque: ");
            int estoque =  Integer.parseInt((this.scanner.nextLine()).replaceAll(" ",""));
            produto.setEstoque(estoque);
            return true;
        }	
        else {
            System.out.println("Erro de alteracao");
            return false;
        }
    }
    public boolean alterarProduto (ProdutoPerecivel produto){
        System.out.println("Que alteracao deseja?");
        System.out.println("1- Nome\n2- Preco\n3- Estoque\n4 - Mes de Validade");
        int escolha = Integer.parseInt((this.scanner.nextLine()).replaceAll(" ",""));
        
        if (escolha == 1){
            System.out.println("Coloque o novo nome: ");
            String nome = this.scanner.nextLine();
            produto.setNome(nome);
            return true;
        } else if (escolha == 2){
            System.out.println("Coloque o novo preco: ");
            int preco = Integer.parseInt((this.scanner.nextLine()).replaceAll(" ",""));
            produto.setPreco(preco);
            return true;
        }else if (escolha == 3){
            System.out.println("Coloque o novo estoque: ");
            int estoque = Integer.parseInt((this.scanner.nextLine()).replaceAll(" ",""));
            produto.setEstoque(estoque);
            return true;
        }else if (escolha == 4){
            System.out.println("Coloque a quantidade de meses até a validade: ");
            int mesValidade = Integer.parseInt((this.scanner.nextLine()).replaceAll(" ",""));
            produto.setDataValidade(mesValidade);
            return true;
        }
        else {
            System.out.println("Erro de alteracao");
            return false;
        }
    }

    public boolean cadastrarCliente(){
        System.out.println("Coloque o nome: ");
        String nome = this.scanner.nextLine();

        System.out.println("Coloque o endereco: ");
        String endereco = this.scanner.nextLine();

        System.out.println("Coloque o telefone: ");
        String telefone = this.scanner.nextLine();

        if ((nome.replaceAll(" ", "").equals("")) || (endereco.replaceAll(" ", "").equals("")) || (telefone.replaceAll(" ", "").equals("") )){
            System.out.println ("Cliente Invalido");
            return false;
        } 
        Cliente c = new Cliente (nome, endereco, telefone);
        return true;
    }


    public boolean alterarCliente (Cliente cliente){
        System.out.println("Que alteracao deseja?");
        System.out.println("1- Nome\n2- Endereco\n3- Telefone");
        int escolha = Integer.parseInt((this.scanner.nextLine()).replaceAll(" ",""));
        
        if (escolha == 1){
            System.out.println("Coloque o novo nome: ");
            String nome = this.scanner.nextLine();
            cliente.setNome(nome);
            return true;
        } 
        else if (escolha == 2){
            System.out.println("Coloque o novo endereco: ");
            String endereco = this.scanner.nextLine();
            cliente.setEndereco(endereco);
            return true;
        }
        else if (escolha == 3){
            System.out.println("Coloque o novo telefone: ");
            String telefone = this.scanner.nextLine();
            cliente.setTelefone(telefone);
            return true;
        }	
        else {
            System.out.println("Erro de alteracao");
            return false;	
        }
    }

    public void listarNotasEmitidas(){
        for (int i = 0; i < Nota.getListaNotas().length; i++){
            Nota.getListaNotas()[i].printNota();
            System.out.print ("\n");
        }
    }

    public void listarProdutos (){
        for (int i = 0; i < Produto.getProdutosCadastrados().length; i++){
            Produto.getProdutosCadastrados()[i].printProduto();
            System.out.print ("\n");
        }
    }

    public void listarClientes(){
        for (int i=0; i < Cliente.getListaCliente().length; i++){
            Cliente.getListaCliente()[i].printCliente();
            System.out.print ("\n");
        }
    }

    public void criarNota(){
        Cliente cliente;
        do{
            System.out.println("Digite o codigo do cliente: ");
            String codigo = scanner.nextLine();
            cliente = Cliente.getClienteCodigo(codigo);
            if(cliente == null){
                System.out.println("Cliente não encontrado.");
                return;
            }
        } while(cliente == null);
        
        Nota nota = new Nota(cliente);
        String opcao;
        String auxiliar;
        do{
            System.out.println("O que deseja fazer?\nAdicionar Item (A)\nExibir Lista ate o momento (B)\nEmitir Nota (C)");
            opcao = scanner.nextLine();
            
            if(opcao.equals("A")){
                System.out.println("Digite o codigo do produto que deseja adicionar: ");
                auxiliar = scanner.nextLine();
                Produto produto = Produto.getProdutoCodigo(auxiliar);
                if (produto == null)
                    System.out.println("Produto não encontrado.");
                else{
                    System.out.println("Digite a quantidade desejada: ");
                    int quantidade = Integer.parseInt((this.scanner.nextLine()).replaceAll(" ",""));
                    nota.colocaProduto(produto, quantidade);
                    System.out.println("Produto inserido com sucesso.");
                }
            }
            else if(opcao.equals("B")){
                nota.printNota();
            }
            else if(opcao.equals("C")){
                nota.emitirNota();
            }
            else{
                System.out.println("Opcao invalida.");
            }
        } while(!opcao.equals("C"));
    }
}
