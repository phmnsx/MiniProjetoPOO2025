
package Produto;
import java.math.BigDecimal;
public class Produto {

    protected String codigo;
    protected String nome;
    protected BigDecimal preco;
    protected int estoque;
    private static int codigosCadastrados = 0;
    private static Produto [] produtosCadastrados;

    public Produto(String nome, float preco, int estoque){
        if(preco < 0 || estoque < 0 || nome.replaceAll(" ","").equals("")){
            System.out.println("Produto invalido.");
            return;
        }
        this.preco = new BigDecimal(preco);
        this.estoque = estoque;
        this.nome = nome;
        this.codigo = Integer.toString(codigosCadastrados++);
        adicionarProdutoLista();
    }
    
    private void adicionarProdutoLista(){
        Produto [] novaLista = new Produto[produtosCadastrados.length + 1];
        System.arraycopy( produtosCadastrados, 0, novaLista, 0, novaLista.length );
        novaLista[produtosCadastrados.length] = this;
        produtosCadastrados = novaLista;
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
    public int getEstoque(){
        return this.estoque;
    }
    
    public void setEstoque(int estoque){
        if(estoque < 0){
            System.out.println("Operacao invalida, estoque seria menor que 0.");
            return;
        }
        this.estoque = estoque;
    }
    
    public void setNome(String nome){
        if (nome.replaceAll(" ", "").equals("")){
            System.out.println ("Nome Invalido");
            return;
        }
        this.nome = nome;
    }
    
    public void setPreco(int preco){
        if (preco < 0){
            System.out.println("Operacao invalida, preco seria menor que 0.");
        }
        this.preco = new BigDecimal(preco);
    }
    
    public BigDecimal comprar(int quantidade){
        if(this.estoque == 0){
            System.out.println("Operação invalida, estoque e igual a 0.");
            return BigDecimal.ZERO;
        }
        this.estoque =- quantidade;
        return preco.multiply(new BigDecimal(quantidade));
    }
    
    public static Produto[] getProdutosCadastrados(){
        return produtosCadastrados;
    }
    
    public void printProduto(){
        System.out.println("Produto " + this.codigo +": "+ this.nome + "  #" + this.estoque + "  R$ " + this.preco);
    }
    
    public static Produto getProdutoCodigo(String codigo){
        for(int i = 0; i < produtosCadastrados.length; i++){
            if(produtosCadastrados[i].getCodigo().equals(codigo))
                return produtosCadastrados[i];
        }
        return null;
    }
}
