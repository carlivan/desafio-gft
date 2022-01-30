public class Cliente {
    private static int totalClientes = 0;
    private  String nome;

    public Cliente(String nome) {
        this.nome = nome;
        totalClientes++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static int getTotalClientes() {
        return totalClientes;
    }
}
