import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

 
        System.out.println("SEJA BEM VINDO AO SEU BICHINHO VIRTUAL, COMO SERÁ O NOME DELE?");
        String nomeTamagotchi = scanner.nextLine();
        Tamagotchi tamagotchi = new Tamagotchi(nomeTamagotchi);

        while (tamagotchi.getIdade() < 15) {
            int desejo = (int) (Math.random() * 3) + 1;

            switch (desejo) {
                case 1:
                    tamagotchi.lidarComSono(scanner);
                    break;

                case 2:
                    System.out.println(tamagotchi.getNome() + " está com fome. O que deseja fazer?");
                    System.out.println("1. Comer muito");
                    System.out.println("2. Comer pouco");
                    System.out.println("3. Não comer");

                    int opcaoFome = scanner.nextInt();
                    tamagotchi.comer(opcaoFome);
                    break;

                case 3:
                    System.out.println(tamagotchi.getNome() + " está entediado. O que deseja fazer?");
                    System.out.println("1. Correr 10 minutos");
                    System.out.println("2. Caminhar 10 minutos");

                    int opcaoExercicio = scanner.nextInt();
                    tamagotchi.exercitar(opcaoExercicio);
                    break;
            }

            System.out.println("Níveis do seu bichinho:");
            System.out.println("Nome: " + tamagotchi.getNome());
            System.out.println("Idade: " + tamagotchi.getIdade() + " dias");
            System.out.println("Peso: " + tamagotchi.getPeso() + " quilos");
            System.out.println("--------------------------");
        }

        System.out.println("Nome"+" completou 15 dias e morreu.");
    }
}