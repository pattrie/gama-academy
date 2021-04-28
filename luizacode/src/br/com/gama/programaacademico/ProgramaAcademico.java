package br.com.gama.programaacademico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramaAcademico {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Double> notas = new ArrayList<>();
        double somaDasNotas = 0;
        double mediaAprovacao = 7;

        double porcentualFaltasPermitidas = 0.25;
        int totalNumeroDeAulas = 68;
        double faltasPermitidas = porcentualFaltasPermitidas * totalNumeroDeAulas;

        for (int i = 0; i < 3; i++){
            double nota = -1;
            System.out.printf("%d - Digite sua nota: ", i+1);
            while (nota <= -1 || nota > 10) {
                nota = Double.parseDouble(recebeEntrada(scan));
            }
            notas.add(nota);
            somaDasNotas += notas.get(i);
        }

        double mediaDeNotas = somaDasNotas / 3;

        System.out.print("Digite o total de faltas: ");
        int numeroDeFaltas = scan.nextInt();

        if (numeroDeFaltas > faltasPermitidas) System.out.printf("\tReprovado por faltas. \n\tTotal de faltas: %d\n", numeroDeFaltas);
        else if (mediaDeNotas < mediaAprovacao) System.out.printf("\tReprovado por nota. \n\tMédia total: %.2f\n", mediaDeNotas);
        if (mediaDeNotas >= mediaAprovacao && numeroDeFaltas <= faltasPermitidas)
            System.out.printf("\tParabéns, você foi aprovado! \n\tMédia total: %.2f\n", mediaDeNotas);
    }

    private static String recebeEntrada(Scanner scan) {
        String valor;
        do {
            valor = scan.next();
        } while (validaNumero(valor));
        return valor;
    }

    private static boolean validaNumero(String numero){
        return !numero.matches("^[+]?([0-9]+([.][0-9]*)?|[.][0-9]+)$");
    }
}
