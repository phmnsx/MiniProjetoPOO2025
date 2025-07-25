package Cliente;
import Interfaces.*;

public abstract class Cliente implements Printable{
	
    protected String codigo;
    protected String nome;
    protected String endereco;
    protected String telefone;
    private static int ultimoCodigo = 0;
    private static Cliente [] listaClientes = null;

    public Cliente (String nome, String endereco, String telefone) {
        if ((nome.trim().replaceAll(" ", "").equals("")) || (endereco.replaceAll(" ", "").equals("")) || (telefone.replaceAll(" ", "").equals("") )){
            System.out.println ("Cliente Invalido");
            return;
        }
        
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.codigo = Integer.toString(ultimoCodigo++);
        adicionarClienteLista();
    }
    private void adicionarClienteLista(){
        if(listaClientes == null){
            listaClientes = new Cliente[1];
            listaClientes[0] = this;
        }
        else{
            Cliente [] novaLista = new Cliente[listaClientes.length + 1];
            System.arraycopy(listaClientes, 0, novaLista, 0, listaClientes.length );
            novaLista[listaClientes.length] = this;
            listaClientes = novaLista;
        }
    }
	
    public String getCodigo(){
        return this.codigo;
    }
    public String getNome(){
        return this.nome;
    }
    public String getEndereco(){
        return this.endereco;
    }
    public String getTelefone(){
        return this.telefone;
    }
    public static Cliente getClienteCodigo(String codigo){
        for(int i = 0; i < listaClientes.length; i++){
            if(listaClientes[i].getCodigo().equals(codigo))
                return listaClientes[i];
        }
        return null;
    }
    
    public static Cliente [] getListaCliente(){
        return listaClientes;
    }
    
    public void setNome(String nome){
        if (nome.trim().replaceAll("\\s+", "").equals("")){
            System.out.println ("Nome Invalido");
            return;
        }
        this.nome = nome;
    }

    public void setEndereco(String endereco){
        if (endereco.trim().replaceAll("\\s+", "").equals("")){
            System.out.println ("Endereco Invalido");
            return;
        }
        this.endereco = endereco;
    }

    public void setTelefone(String telefone){
        if (telefone.trim().replaceAll("\\s+", "").equals("")){
            System.out.println ("Telefone Invalido");
            return;
        }
        this.telefone = telefone;
    }
}

