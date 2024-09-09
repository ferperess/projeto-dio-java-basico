import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class processoSeletivo {

    static String[] selecionados = new String[5];

    public static void main(String[] args) throws Exception {
        System.out.println("PROCESSO SELETIVO");
        System.out.println("=================");
        selecionandoCandidatos();
        System.out.println("=================");
        impressaoSelecionados();
        System.out.println("=================");
        entrandoEmContato();
    }

    // Método para gerar valor aleatório pretendido pelos candidatos
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    // Método para selecionar candidatos
    static void selecionandoCandidatos() {
        String[] candidatos = {"AYLA SANTOS", "RAFAEL ALMEIDA", "LARISSA OLIVEIRA", "DIOGO PEREIRA", "LAURA FERNANDES", "LUCAS BARBOSA", "ISABELLA COSTA", "PEDRO SOUZA", "MARIANNA LIMA", "GUSTAVO RODRIGUES"};

        int candidatosSelecionados = 0;
        double salarioBase = 2000.0;

        // Informando lista de candidatos
        for (int i = 0; i < candidatos.length && candidatosSelecionados < 5; i++) {
            String candidato = candidatos[i];
            double salarioPretendido = valorPretendido();
            DecimalFormat df = new DecimalFormat("#,##0.00");
            String salarioPretendidoFormatado = df.format(salarioPretendido);

            System.out.println("CANDIDATO: " + candidato + "\nSALÁRIO SOLICITADO: R$" + salarioPretendidoFormatado + "\n");
            if (salarioBase >= salarioPretendido) {
                selecionados[candidatosSelecionados] = candidato;
                candidatosSelecionados++;
            }
        }
    }

    // Método para imprimir os candidatos selecionados
    static void impressaoSelecionados() {
        for (int i = 0; i < selecionados.length; i++) {
            if (selecionados[i] != null)
                System.out.println((i + 1) + "º CANDIDATO SELECIONADO: " + selecionados[i] + "\n");
        }
    }

    // Método auxiliar para simular a tentativa de contato
    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    // Método para tentar contato com os candidatos selecionados
    static void entrandoEmContato() {
        for (String selecionado : selecionados) {
            if (selecionado != null) {
                int tentativasRealizadas = 1;
                boolean continuarTentando = true;
                boolean atendeu = false;

                do {
                    atendeu = atender();
                    continuarTentando = !atendeu;
                    if (continuarTentando)
                        tentativasRealizadas++;
                    else
                        System.out.print("CONTATO REALIZADO COM SUCESSO!");
                } while (continuarTentando && tentativasRealizadas < 3);

                // Imprimir o resultado da tentativa de contato
                if (atendeu) {
                    System.out.println(" CONSEGUIMOS CONTATO COM " + selecionado + " NA " + tentativasRealizadas + "ª TENTATIVA");
                } else {
                    System.out.println("NÃO CONSEGUIMOS CONTATO COM " + selecionado + ". " + tentativasRealizadas + " TENTATIVAS FORAM REALIZADAS!");
                }
            }
        }
    }
}


