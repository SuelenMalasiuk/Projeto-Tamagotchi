import java.util.Scanner;

public class Tamagotchi {
    private String nome;
    private int idade;
    private int peso;
    private int vezesAcordado; 
    
    public Tamagotchi(String nome) {
        this.nome = nome;
        this.idade = 0;
        this.peso = 1;
        this.vezesAcordado = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPeso() {
        return peso;
    }

    public void dormir() {
        System.out.println(nome + " a mimir... ");
        idade++;
    }

    public void comer(int opcao) {
    switch (opcao) {
        case 1: 
            peso += 5;
            System.out.println(nome + " comeu muito, eita!");
            dormir(); 
            break;
        case 2:
            peso++;
            System.out.println(nome + " comeu pouco, obrigada!");
            break;
        case 3:
            peso -= 2;
            System.out.println(nome + " não comeu e emagreceu, triste!");
            if (peso <= 0) {
                System.out.println(nome + " a não fiquei desnutrido, ADEUS!");
                System.exit(0);
            }
            break;
    }

    if (peso <= 0) {
        System.out.println(nome + " a não fiquei desnutrido, ADEUS!");
        System.exit(0);
    }
}

    public void exercitar(int opcao) {
        switch (opcao) {
            case 1:
                peso -= 4;
                System.out.println(nome + " corri e fiquei mais magro");
                comer(2);
                break;
            case 2:
                peso--;
                System.out.println(nome + " caminheeei.");
                if (peso <= 0) {
                    System.out.println(nome + " a não fiquei desnutrido, ADEUS!!");
                    System.exit(0);
                }
                break;
        }
    }

    public void lidarComSono(Scanner scanner){
        System.out.println(nome + " está com sono. O que faremos?");
        System.out.println("1. Dormir");
        System.out.println("2. Permanecer acordado");

        int opcaoSono = scanner.nextInt();
        if (opcaoSono == 2) {
            vezesAcordado++; 
            if (vezesAcordado >= 5) {
                vezesAcordado = 0;
                dormir();
            } else {
                exercitar((int) (Math.random() * 2) + 1); 
            }
        } else {
            vezesAcordado = 0;
            dormir();
        }
    }
}
