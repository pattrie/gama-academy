package br.com.gama.contas;

public abstract class Conta {
    private double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;

    public Conta(int agencia, int numero, Cliente titular) {
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;
    }

    public void deposita(double valor) {
        if (valor < 0) throw new IllegalArgumentException("Deposite um valor acima de R$ 0.");
        this.saldo = valor;
    }

    public void saca(double valor) {
        if (this.saldo < valor)
            throw new IllegalArgumentException("O saldo é menor do que valor desejado para saque.");
        if (valor < 1)
            throw new IllegalArgumentException("Saque somente disponível para valores acima de R$ 1.");
        double novoSaldo = this.saldo - valor;
        this.deposita(novoSaldo);
    }

    @Override
    public String toString() {
        return String.format("Conta{saldo=%.2f, " +
                             "agencia=%d, " +
                             "numero=%d, " +
                             "titular=%s}",
                saldo, agencia, numero, titular);
    }
}
