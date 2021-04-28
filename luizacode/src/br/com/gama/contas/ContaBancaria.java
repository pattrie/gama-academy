package br.com.gama.contas;

public class ContaBancaria {
    public static void main(String[] args) {

        Conta conta = new ContaCorrente(123, 456,
                new Cliente("Paçoca", "123.456.789-10"));

        try {
            conta.deposita(100);
            conta.saca(20);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(conta);
    }
}
