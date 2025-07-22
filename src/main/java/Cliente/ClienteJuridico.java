package Cliente;

import java.util.Scanner;

public class ClienteJuridico extends Cliente {

    private String cnpj;

    public ClienteJuridico (String nome, String endereco, String telefone, String cnpj) {
        super (nome, endereco, telefone);
        this.cnpj = cnpj;
    }

    public String getCNPJ(){
        return this.cnpj;
    }


    public void setCNPJ(String cnpj){
        if (cnpj.trim().replaceAll("\\s+", "").equals("")){
            System.out.println ("CNPJ Invalido");
            return;
        }
        this.cnpj = cnpj;
    }

    public void printCliente(){
        System.out.println ("Codigo: " + this.codigo);
        System.out.println ("Nome: " + this.nome);
        System.out.println ("CNPJ: " + this.cnpj);
        System.out.println ("Endereco: " + this.endereco);
        System.out.println ("Telefone: " + this.telefone);
    }
    
    @Override
    public boolean alterar (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Que alteracao deseja?");
        System.out.println("1 - Nome\n2 - Endereco\n3 - Telefone\n4 - CNPJ");
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
            System.out.println("Coloque o novo CNPJ: ");
            String cnpj = scanner.nextLine();
            this.setCNPJ(cnpj);
            return true;
        }
        else {
            System.out.println("Erro de alteracao");
            return false;	
        }
    }
}

