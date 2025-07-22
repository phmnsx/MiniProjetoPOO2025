package Cliente;

import java.util.Scanner;

public class ClienteFisico extends Cliente {

    private String cpf;

    public ClienteFisico (String nome, String endereco, String telefone, String cpf) {
        super(nome, endereco, telefone);
        this.cpf = cpf;
    }

    public String getCPF (){
        return this.cpf;
    }

    public void setCPF (String cpf){
        if (cpf.trim().replaceAll("\\s+", "").equals("")){
            System.out.println ("CPF Invalido");
            return;
        }
        this.cpf = cpf;
    }


    public void printCliente(){
        System.out.println ("Codigo: " + this.codigo);
        System.out.println ("Nome: " + this.nome);
        System.out.println ("CPF: " + this.cpf);
        System.out.println ("Endereco: " + this.endereco);
        System.out.println ("Telefone: " + this.telefone);
    }
    public boolean alterar (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Que alteracao deseja?");
        System.out.println("1 - Nome\n2 - Endereco\n3 - Telefone\n4 - CPF");
        int escolha = Integer.parseInt((scanner.nextLine()).replaceAll(" ",""));
        
        if (escolha == 1){
            System.out.println("Coloque o novo nome: ");
            String nome = scanner.nextLine();
            this.setNome(nome);
            return true;
        } 
        else if (escolha == 2){
            System.out.println("Coloque o novo endereco: ");
            String endereco = scanner.nextLine();
            this.setEndereco(endereco);
            return true;
        }
        else if (escolha == 3){
            System.out.println("Coloque o novo telefone: ");
            String telefone = scanner.nextLine();
            this.setTelefone(telefone);
            return true;
        }
        else if (escolha == 4){
            System.out.println("Coloque o novo CPF: ");
            String cpf = scanner.nextLine();
            this.setCPF(cpf);
            return true;
        }
        else {
            System.out.println("Erro de alteracao");
            return false;	
        }
    }
}

