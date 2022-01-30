import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta{

    private   static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    private static int totalContas = 0;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private int agencia;
    private int numero;
    private double saldo;
    protected Cliente cliente;
    private String dataAbertura;
    private List<String> transacoes = new ArrayList<>();

    public Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        Conta.totalContas++;
        LocalDateTime hoje = LocalDateTime.now();
        this.dataAbertura = hoje.format(formatter);
    }


    @Override
    public void sacar(double valor) {
        if(saldo >= valor){
            saldo -= valor;
            this.transacoes.add("Saque realizado -> "+ valor + " Data-> "+ LocalDateTime.now().format(formatter));
        }else{
            System.out.println("Saldo insuficiente!!");
            this.transacoes.add("Saque não realizado -> "+ LocalDateTime.now().format(formatter));
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        this.transacoes.add("Deposito realizado: " + valor + " Data: " +LocalDateTime.now().format(formatter));
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        if(this.saldo >= valor){
            this.saldo -= valor;
            contaDestino.saldo += valor;
            this.transacoes.add("Transferencia realizada: "+valor+" Data: "+LocalDateTime.now().format(formatter)+"\n" +
                    "De: " + this.getCliente().getNome()+ " Para: "+ contaDestino.getCliente().getNome());
        }else{
            this.transacoes.add("Transferencia nao realizada: "+LocalDateTime.now().format(formatter));
        }
    }

    protected void imprimeInfoComum(){
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.getAgencia()));
        System.out.println(String.format("Conta: %d", this.getNumero()));
        System.out.println(String.format("Saldo: %.2f", this.getSaldo()));
    }

    public void extrato(){
        for(String transacao : transacoes){
            System.out.println(transacao);
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getTotalContas(){
        return totalContas;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public Cliente getCliente() {
        return cliente;
    }

}
