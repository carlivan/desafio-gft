public class ContaPoupanca extends Conta{

    private static int totalPoupancas = 0;

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        totalPoupancas++;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato conta poupança ===");
        super.imprimeInfoComum();
    }

    public static int getTotalPoupancas() {
        return totalPoupancas;
    }
}
