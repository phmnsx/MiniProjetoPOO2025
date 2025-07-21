package Cliente;

public class Cliente {
	
	protected String codigo;
	protected String nome;
	protected String endereco;
	protected String telefone;
	private static int ultimoCodigo = 0;
	private static Cliente [] listaClientes;
	
	public Cliente (String nome, String endereco, String telefone) {
		if ((nome.trim().replaceAll("\\s+", "").equals("")) || (endereco.trim().replaceAll("\\s+", "").equals("")) || (telefone.trim().replaceAll("\\s+", "").equals("") )){
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
        Cliente [] novaLista = new Cliente[listaClientes.length + 1];
        System.arraycopy(listaClientes, 0, novaLista, 0, novaLista.length );
        novaLista[listaClientes.length] = this;
        listaClientes = novaLista;
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
    
    public void setNome(String nome){
		if (nome.trim().replaceAll("\\s+", "").equals("")){
			System.out.println ("Nome Invalido");
			return;
		}
		this.nome = nome;
	}
	
	public void setEndereco(String Endereco){
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
    
	public void printCliente(){
		
		System.out.println ("Codigo: " + this.codigo);
		System.out.println ("Nome: " + this.nome);
		System.out.println ("Endereco: " + this.endereco);
		System.out.println ("Telefone: " + this.telefone);
	}
}

