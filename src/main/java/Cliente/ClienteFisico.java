package Cliente;

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

    @Override
    public void print(){
        System.out.println ("Codigo: " + this.codigo);
        System.out.println ("Nome: " + this.nome);
        System.out.println ("CPF: " + this.cpf);
        System.out.println ("Endereco: " + this.endereco);
        System.out.println ("Telefone: " + this.telefone);
    }
}

