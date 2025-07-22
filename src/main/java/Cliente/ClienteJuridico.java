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

    @Override
    public void print(){
        System.out.println ("Codigo: " + this.codigo);
        System.out.println ("Nome: " + this.nome);
        System.out.println ("CNPJ: " + this.cnpj);
        System.out.println ("Endereco: " + this.endereco);
        System.out.println ("Telefone: " + this.telefone);
    }
    
}

