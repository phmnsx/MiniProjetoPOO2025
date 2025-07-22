
package Produto;
import java.math.BigDecimal;
import java.util.Scanner;
import Interfaces.*;

public abstract class Produto implements Printable{

    protected String codigo;
    protected String nome;
    protected BigDecimal preco;
    private static int codigosCadastrados = 0;
    private static Produto [] produtosCadastrados = null;

    public Produto(String nome, float preco){
        if(preco < 0 || nome.replaceAll(" ","").equals("")){
            System.out.println("Produto invalido.");
            return;
        }
        this.preco = new BigDecimal(preco);
        this.nome = nome;
        this.codigo = Integer.toString(codigosCadastrados++);
        adicionarProdutoLista();
    }
    
    private void adicionarProdutoLista(){
        if (produtosCadastrados == null){
            produtosCadastrados = new Produto[1];
            produtosCadastrados[0] = this;
        }
        else{
            Produto [] novaLista = new Produto[produtosCadastrados.length + 1];
            System.arraycopy(produtosCadastrados, 0, novaLista, 0, produtosCadastrados.length);
            novaLista[produtosCadastrados.length] = this;
            produtosCadastrados = novaLista;
        }
    }
    
    public String getCodigo(){
        return this.codigo;
    }
    public String getNome(){
        return this.nome;
    }
    public BigDecimal getPreco(){
        return this.preco;
    }
    
    public void setNome(String nome){
        if (nome.replaceAll(" ", "").equals("")){
            System.out.println ("Nome Invalido");
            return;
        }
        this.nome = nome;
    }
    
    public void setPreco(float preco){
        if (preco < 0){
            System.out.println("Operacao invalida, preco seria menor que 0.");
        }
        this.preco = new BigDecimal(preco);
    }
    
    
    public static Produto[] getProdutosCadastrados(){
        return produtosCadastrados;
    }
    
    
    public static Produto getProdutoCodigo(String codigo){
        for(int i = 0; i < produtosCadastrados.length; i++){
            if(produtosCadastrados[i].getCodigo().equals(codigo))
                return produtosCadastrados[i];
        }
        return null;
    } 
}


