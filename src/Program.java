import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        AccountBank acc;
        int option = 0;
        Scanner sc = new Scanner(System.in);

        // Boas-vindas e cadastro
        System.out.println("Bem vindo ao Bleibleide Bank");
        System.out.printf("%nAntes de a Bleibleide Cantar, vamos fazer seu cadastro: %n");
        System.out.print("Digite seu nome: ");
        String name = sc.nextLine();
        int id = new Random().nextInt(9999);
        System.out.print("Deseja depositar um valor inicial? (y/n) ");
        char initialDeposit = sc.nextLine().charAt(0);

        if (initialDeposit == 'y') {
            System.out.print("Digite o depósito inicial: ");
            double amount = sc.nextDouble();
            acc = new AccountBank(name, id, amount);
        } else {
            acc = new AccountBank(name, id);
        }

        System.out.println(acc);

        // Menu de opções
        while (option != 4) {
            System.out.println("Menu inicial:");
            System.out.printf("1- Saldo%n2- Saque%n3- Depósito%n4- Sair%n%nEscolha uma opção: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println(acc);
                    break;
                case 2:
                    System.out.print("Quanto você irá sacar: ");
                    double amount = sc.nextDouble();
                    acc.atualizarSaque(amount);
                    break;
                case 3:
                    System.out.print("Quanto você irá depositar: ");
                    double deposit = sc.nextDouble();
                    acc.atualizarDeposito(deposit);
                    break;
                case 4:
                    System.out.println("Obrigado por usar o banco Bleibleide, até a próxima!");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }

        sc.close();
    }
}
