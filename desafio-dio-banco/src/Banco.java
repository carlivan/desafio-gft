import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Banco {

    private static int totalBancos = 0;

    private  String nome;
    private List<Conta> contas = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
        totalBancos++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void addContas(Conta conta) {
        this.contas.add(conta);
    }

    public static int getTotalBancos() {
        return totalBancos;
    }

    public void totalCliente(Banco banco){
        Set<Cliente> clientes = new HashSet<>();

        for(int i = 0; i < banco.getContas().size();i++){
            clientes.add(banco.getContas().get(i).getCliente());
        }
        System.out.println("Total clientes neste banco -> " + clientes.size());
    }

    public void totalCliente(){
        Set<Cliente> clientes = new HashSet<>();

        for(int i = 0; i < this.getContas().size();i++){
            clientes.add(this.getContas().get(i).getCliente());
        }
        System.out.println("Total clientes neste banco -> " + clientes.size());
    }
}
