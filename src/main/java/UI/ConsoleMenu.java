package UI;
import Nota.*;
import java.util.Scanner;
import Produto.*;
import Cliente.*;



public class ConsoleMenu {
	
    private final Scanner scanner;

    public ConsoleMenu(Scanner scanner){
    this.scanner = scanner;
    }
    
    public void iniciarMenu(){
        int opcao;
        do{
            System.out.println("Menu da \"Loja\"\n");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Alterar Produto");
            System.out.println("3 - Cadastrar Cliente");
            System.out.println("4 - Alterar Cliente");
            System.out.println("5 - Criar Nota");
            System.out.println("6 - Listar Notas Emitidas");
            System.out.println("7 - Listar Produtos");
            System.out.println("8 - Listar Clientes");
            System.out.println("0 - Sair");
            opcao = Integer.parseInt((scanner.nextLine()).replaceAll(" ",""));
            
            if(opcao == 1){
                cadastrarProduto();
            }
            if(opcao == 2){
                System.out.println("Digite o codigo do produto a ser alterado.");
                String auxiliar = scanner.nextLine();
                Produto produto = Produto.getProdutoCodigo(auxiliar);
                if(produto == null){
                    System.out.println("Produto não encontrado.");
                }
                else
                alterarProduto(produto);
            }
            if(opcao == 3)
                cadastrarCliente();
            if(opcao == 4){
                System.out.println("Digite o codigo do cliente a ser alterado.");
                String auxiliar = scanner.nextLine();
                Cliente cliente = Cliente.getClienteCodigo(auxiliar);
                if(cliente == null){
                    System.out.println("Cliente não encontrado.");
                }
                else
                alterarCliente(cliente);
            }
            if(opcao == 5)
                criarNota();
            if(opcao == 6)
                listarNotasEmitidas();
            if(opcao == 7)
                listarProdutos();
            if(opcao == 8)
                listarClientes();
        }while(opcao != 0);
    }

    public boolean cadastrarProduto (){
        System.out.println("Qual o tipo de produto?\nFisico (F)\nPerecivel (P)\nDigital (D)");
        String tipoProduto = this.scanner.nextLine();
        
        System.out.println("Coloque o nome: ");
        String nome = this.scanner.nextLine();

        System.out.println("Coloque o preco: ");
        float preco =  this.scanner.nextFloat();
        this.scanner.nextLine();
        if (tipoProduto.equals("F")){
            System.out.println("Coloque o estoque: ");
            int estoque = Integer.parseInt((this.scanner.nextLine()).replaceAll(" ",""));
            
            if(preco < 0 || estoque < 0 || nome.replaceAll(" ","").equals("")){
                System.out.println("Produto invalido.");
                return false;
            }
            ProdutoFisico p = new ProdutoFisico(nome, preco, estoque);
            return true;
        }
        else if(tipoProduto.equals("P")){
            System.out.println("Coloque o estoque: ");
            int estoque = Integer.parseInt((this.scanner.nextLine()).replaceAll(" ",""));

            if(preco < 0 || estoque < 0 || nome.replaceAll(" ","").equals("")){
                System.out.println("Produto invalido.");
                return false;
            }
            System.out.println("Digite quantos meses até a data de validade: ");
            int mesesValidade = Integer.parseInt((this.scanner.nextLine()).replaceAll(" ",""));
            if (mesesValidade <= 0){
                System.out.println("Produto invalido.");
                return false;
            }
            ProdutoPerecivel p = new ProdutoPerecivel(nome, preco, estoque, mesesValidade);
            return true;
        }
        else if (tipoProduto.equals("D")){
            System.out.println("Digite o site relacionado ao produto: ");
            String site = this.scanner.nextLine().replaceAll(" ","");
            if(site.length() == 0){
                System.out.println("Produto invalido.");
                return false;
            }
            ProdutoDigital p = new ProdutoDigital(nome, preco, site);
            return true;
        }
        else{
            System.out.println("Tipo de produto invalido.");
            return false;
        }
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
        if (tipoCliente.equals("F")){
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
            System.out.println("Tipo de cliente invalido");
        }
        return true;
    }

    public void listarNotasEmitidas(){
        if (Nota.getListaNotas() == null){
            System.out.println("Lista vazia.");
            return;
        }
        for (int i = 0; i < Nota.getListaNotas().length; i++){
            System.out.println("----------");
            Nota.getListaNotas()[i].print();
            System.out.print ("\n");
        }
    }

    public void listarProdutos (){
        if (Produto.getProdutosCadastrados() == null){
            System.out.println("Lista vazia.");
            return;
        }
        Produto produtoAtual;
        for (int i = 0; i < Produto.getProdutosCadastrados().length; i++){
            produtoAtual = Produto.getProdutosCadastrados()[i];
            produtoAtual.print();
            System.out.print("\n");
        }
    }

    public void listarClientes(){
        if (Cliente.getListaCliente() == null){
            System.out.println("Lista vazia.");
            return;
        }
        Cliente clienteAtual;
        for (int i=0; i < Cliente.getListaCliente().length; i++){
            clienteAtual = Cliente.getListaCliente()[i];
            clienteAtual.print();
            System.out.print("\n");
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
                nota.print();
            }
            else if(opcao.equals("C")){
                nota.emitirNota();
            }
            else{
                System.out.println("Opcao invalida.");
            }
        } while(!opcao.equals("C"));
    }
    
    public void alterarProduto(Produto produto){
        if(produto == null){
            return;
        }
        int opcao;
        String alteracao;
        System.out.println("Que alteracao deseja?");
        System.out.println("1- Nome\n2- Preco");
        if(produto instanceof ProdutoDigital){
            System.out.println("3- Site Relacionado ao produto");
            opcao = Integer.parseInt((this.scanner.nextLine()).replaceAll(" ",""));
            
            if (opcao == 3){
                System.out.println("Digite o novo site relacionado ao produto: ");
                alteracao = this.scanner.nextLine();
                ((ProdutoDigital) produto).setSiteRelacionado(alteracao);
                return;
            }
        }
        else{
            System.out.println("3- Estoque");
            if(produto instanceof ProdutoPerecivel){
                System.out.println("4- Data de validade");
                opcao = Integer.parseInt((this.scanner.nextLine()).replaceAll(" ",""));
                
                if (opcao == 4){
                    System.out.println("Digite a quantidade de meses ate a data de validade: ");
                    alteracao = scanner.nextLine();
                    ((ProdutoPerecivel) produto).setDataValidade(Integer.parseInt(alteracao.replaceAll(" ","")));
                    return;
                }
            } 
            else{
                opcao = Integer.parseInt((this.scanner.nextLine()).replaceAll(" ",""));
            }
            if (opcao == 3){
                System.out.println("Digite o novo estoque: ");
                alteracao = scanner.nextLine();
                ((ProdutoFisico) produto).setEstoque(Integer.parseInt(alteracao.replaceAll(" ","")));
                return;
            }
        }
        if (opcao == 1){
            System.out.println("Digite o novo nome: ");
            alteracao = scanner.nextLine();
            produto.setNome(alteracao);
        }
        else if (opcao == 2){
            System.out.println("Digite o novo preco");
            alteracao = scanner.nextLine();
            produto.setPreco(Float.parseFloat(alteracao));
        }
    }
    
    public void alterarCliente(Cliente cliente){
        if (cliente == null)
            return;
        System.out.println("Que alteracao deseja?");
        System.out.println("1 - Nome\n2 - Endereco\n3 - Telefone");
        int escolha = 0;
        
        if(cliente instanceof ClienteFisico){
            System.out.println("4- CPF");
            escolha = Integer.parseInt((scanner.nextLine()).replaceAll(" ",""));
            if (escolha == 4){
                System.out.println("Coloque o novo CPF: ");
                String cpf = scanner.nextLine();
                ((ClienteFisico)cliente).setCPF(cpf);
                return;
            }
        }
        else if (cliente instanceof ClienteJuridico){
            escolha = Integer.parseInt((scanner.nextLine()).replaceAll(" ",""));
            if (escolha == 4){
                System.out.println("Coloque o novo CNPJ: ");
                String cnpj = scanner.nextLine();
                ((ClienteJuridico) cliente).setCNPJ(cnpj);
                return;
            }   
        }
        if (escolha == 1){
            System.out.println("Coloque o novo nome: ");
            String nome = scanner.nextLine();
            cliente.setNome(nome);
        } 
        else if (escolha == 2){
            System.out.println("Coloque o novo endereco: ");
            String endereco = scanner.nextLine();
            cliente.setEndereco(endereco);
        }
        else if (escolha == 3){
            System.out.println("Coloque o novo telefone: ");
            String telefone = scanner.nextLine();
            cliente.setTelefone(telefone);
        }
    }
}
