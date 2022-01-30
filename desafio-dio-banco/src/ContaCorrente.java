public class ContaCorrente extends Conta{
    private static int totalCorrentes = 0;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        totalCorrentes++;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato conta corrente ===");
        super.imprimeInfoComum();
    }

    public static int getTotalCorrentes() {
        return totalCorrentes;
    }
}
