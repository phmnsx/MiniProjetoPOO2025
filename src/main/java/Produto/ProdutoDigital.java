package Produto;

import java.util.Scanner;

public class ProdutoDigital extends Produto {
    
    private String siteRelacionado;
    
    public ProdutoDigital(String nome, float preco, String siteRelacionado){
        super(nome, preco);
        this.siteRelacionado = siteRelacionado;
    }
    
    @Override
    public void print(){
        System.out.println("Produto (digital) " + this.codigo +": "+ this.nome + "  R$ " + this.preco + "  Link: " + this.siteRelacionado);
    }
    
    public void setSiteRelacionado(String siteRelacionado){
        this.siteRelacionado = siteRelacionado;
    }
}
