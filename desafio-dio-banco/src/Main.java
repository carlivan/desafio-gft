public class Main {
    public static void main(String[] args) {
        Cliente fulano = new Cliente("Fulano");
        Cliente beltrano = new Cliente("Beltrano");
        Conta cc = new ContaCorrente(fulano);
        cc.depositar(100);
        Conta cc1 = new ContaCorrente(beltrano);

        Conta cp = new ContaPoupanca(fulano);
        Conta cp1 = new ContaPoupanca(beltrano);

        Banco b1 = new Banco("Brasil");
        Banco b2 = new Banco("Noruega");

        b1.addContas(cc);
        b1.addContas(cp1);
        b2.addContas(cc1);
        b1.totalCliente(b1);
        b2.totalCliente();

        cc.depositar(200);
        cc.extrato();
        System.out.println("+++++++++++++++++++++++++++++++++");
        cc.sacar(50);
        cc.extrato();
        System.out.println("+++++++++++++++++++++++++++++++++");
        cc.sacar(500);
        cc.extrato();
        System.out.println("+++++++++++++++++++++++++++++++++");
        cc.transferir(50,cc1);
        cc.extrato();

        System.out.println(Banco.getTotalBancos());

        System.out.println(cp.getTotalContas());
        System.out.println(ContaPoupanca.getTotalPoupancas());
        System.out.println(Cliente.getTotalClientes());
    }
}
