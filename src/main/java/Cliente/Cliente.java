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
		}
		this.nome = nome;
	}
	
	public void setEndereco(String Endereco){
		if (endereco.trim().replaceAll("\\s+", "").equals("")){
			System.out.println ("Endereco Invalido");
		}
		this.endereco = endereco;
	}
	
	public void setTelefone(String telefone){
		if (telefone.trim().replaceAll("\\s+", "").equals("")){
			System.out.println ("Telefone Invalido");
			
		}
		this.telefone = telefone;
	}
    
	static public void printaListaClientes(){
		
		for (int i =0; i <(listaClientes.length-1); i++){
		System.out.println ("Cliente " + (i+1) + " :");
		System.out.println ("Codigo: " + listaClientes[i].codigo);
		System.out.println ("Nome: " + listaClientes[i].nome);
		System.out.println ("Endereco: " + listaClientes[i].endereco);
		System.out.println ("Telefone: " + listaClientes[i].telefone);
		System.out.print ("/n/n");
		}
	}
}

