import java.util.Random;
import java.util.Scanner;

public class Jokenpo {
    public static void main(String[] args) {
        System.out.println("Bem vindo ao Jokenpo Go!");
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        boolean comecovalida = false;
        boolean jogarNovamente = true;

        String[] opcoesJokenpo = {"Pedra", "Papel", "Tesoura"};

        while(jogarNovamente){
            while(!comecovalida) {
                System.out.println("Digite 'Go' para começar: ");
                String comecarJogo = scan.nextLine();

                if (comecarJogo.equalsIgnoreCase("Go")) {
                    comecovalida = true;
                } else {
                    System.out.println("Entrada inválida, tente novamente!");
                }
            }
            int escolhaUsuario = -1;

            while(escolhaUsuario < 0 || escolhaUsuario > 2 ){
                System.out.println("Escolha (0)Pedra, (1)Papel e (2)Tesoura: ");
                if (scan.hasNextInt()) {
                    escolhaUsuario = scan.nextInt();
                    scan.nextLine();
                    if (escolhaUsuario < 0 || escolhaUsuario > 2) {
                        System.out.println("Escolha inválida. Por favor, escolha 0, 1 ou 2.");
                    }
                } else {
                    System.out.println("Entrada inválida. Por favor, digite um número.");
                    scan.next();
                }
            }

            int computadorEscolhe = random.nextInt(3);

            System.out.println("Você escolheu: " + opcoesJokenpo[escolhaUsuario]);
            System.out.println("O computador escolheu: " + opcoesJokenpo[computadorEscolhe]);

            if (escolhaUsuario==computadorEscolhe){
                System.out.println("Empate!");
            } else if ((escolhaUsuario == 0 && computadorEscolhe == 2) ||
                    (escolhaUsuario == 1 && computadorEscolhe == 0) ||
                    (escolhaUsuario == 2 && computadorEscolhe == 1)) {
                System.out.println("Você ganhou!");
            } else {
                System.out.println("Você perdeu!");
            }
            System.out.println("Deseja jogar novamente(s/n)?");
            String resposta = scan.nextLine();

            if(resposta.equals("s")){
                jogarNovamente = true;
            } else if (resposta.equals("n")){
                jogarNovamente = false;
                System.out.println("Obrigado por jogar o Jokenpo Go!");
            }
        }


        scan.close();

    }
}