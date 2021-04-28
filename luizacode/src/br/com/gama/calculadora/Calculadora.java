package br.com.gama.calculadora;

import java.util.Scanner;

public class Calculadora {
    static int numero = 1;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Qual operação deseja fazer?");
        System.out.println("1) Soma");
        System.out.println("2) Subtração");
        System.out.println("3) Multiplicação");
        System.out.println("4) Divisão");
        System.out.println("5) Resto da Divisão");

        double operacao = Double.parseDouble(recebeEntrada(scan));

        switch ((int)operacao){
            case 1:
                System.out.println("A soma dos números digitados é: " +
                        (recebeNumero(scan) + recebeNumero(scan)));
                break;
            case 2:
                System.out.println("A subtração dos números digitados é: " +
                        (recebeNumero(scan) - recebeNumero(scan)));
                break;
            case 3:
                System.out.println("A multiplicação dos números digitados é: " +
                        (recebeNumero(scan) * recebeNumero(scan)));
                break;
            case 4:
                System.out.println("A divisão dos números digitados é: " +
                        (recebeNumero(scan) / verificaDivisor(recebeNumero(scan))));
                break;
            case 5:
                System.out.println("O resto da divisão entre os números digitados é: " +
                        (recebeNumero(scan) % verificaDivisor(recebeNumero(scan))));
                break;
            default:
                System.out.print("Digite uma opção válida.");
        }
    }

    private static String recebeEntrada(Scanner scan) {
        String valor;
        do {
            valor = scan.next();
        } while (validaNumero(valor));
        return valor;
    }

    private static boolean validaNumero(String numero){
        return !numero.matches("^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$");
    }

    private static double recebeNumero(Scanner scan) {
        System.out.printf("%d - Digite o número: ", numero);
        numero++;
        return Double.parseDouble(recebeEntrada(scan));
    }

    private static double verificaDivisor(double numero){
        if (numero == 0) throw new ArithmeticException("Não é possível dividir por 0.");
        return numero;
    }
}
