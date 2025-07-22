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
        System.out.println("Qual o tipo de produto?\nPerecivel (P)\nDigital (D)\nNormal (N)");
        String tipoProduto = this.scanner.nextLine();
        
        System.out.println("Coloque o nome: ");
        String nome = this.scanner.nextLine();

        System.out.println("Coloque o preco: ");
        float preco =  this.scanner.nextFloat();
        this.scanner.nextLine();
        if (!tipoProduto.equals("D")){
            System.out.println("Coloque o estoque: ");
            int estoque = Integer.parseInt((this.scanner.nextLine()).replaceAll(" ",""));
            if(preco < 0 || estoque < 0 || nome.replaceAll(" ","").equals("")){
                System.out.println("Produto invalido.");
                return false;
            }
            if(tipoProduto.equals("P")){
                System.out.println("Digite quantos meses até a data de validade: ");
                int mesesValidade = Integer.parseInt((this.scanner.nextLine()).replaceAll(" ",""));
                if (mesesValidade <= 0){
                    System.out.println("Produto invalido.");
                    return false;
                }
                ProdutoPerecivel p = new ProdutoPerecivel(nome, preco, estoque, mesesValidade);
            }
            else{
                Produto p = new Produto (nome, preco, estoque);
            }
        
        } else{
            ProdutoDigital p = new ProdutoDigital(nome, preco, 0);
        }
        return true;
    }

    public boolean cadastrarCliente(){
        System.out.println("Qual o tipo de cliente?\nPF (F)\nPJ (J)");
        String tipoCliente = this.scanner.nextLine();
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
        if(tipoCliente.equals("F")){
            System.out.println("Coloque o CPF: ");
            String cpf = this.scanner.nextLine();
            ClienteFisico c = new ClienteFisico(nome, endereco, telefone, cpf);
        }
        else if(tipoCliente.equals("J")){
            System.out.println("Digite o CNPJ: ");
            String cnpj = this.scanner.nextLine();
            ClienteJuridico c = new ClienteJuridico(nome, endereco, telefone, cnpj);
        }
        else{
            Cliente c = new Cliente (nome, endereco, telefone);
        }
        return true;
    }

    public void listarNotasEmitidas(){
        for (int i = 0; i < Nota.getListaNotas().length; i++){
            System.out.println("----------");
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
