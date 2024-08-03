import java.util.Scanner;
import java.text.DecimalFormat;
public class ContaTerminal {
    public static void main(String[] args) throws Exception {
    
      //Definição das variáveis
      int numero;
      String agencia, nomeCliente;
      double saldo;

     //Coleta dos dados
     Scanner scanner = new Scanner(System.in);

     System.out.print("Por favor, digite o número da agência: ");
      agencia = scanner.nextLine();
     System.out.print("Agora, digite o número da conta: ");
      numero = scanner.nextInt();
      scanner.nextLine();
     System.out.print("Digite seu nome completo: ");
      nomeCliente = scanner.nextLine();
     System.out.print("Por último, digite o saldo da conta: ");
      saldo = scanner.nextDouble();

     // Formatação do saldo com duas casas decimais
      DecimalFormat decimalFormat = new DecimalFormat("#.00");
      String saldoFormatado = decimalFormat.format(saldo);
      
     //Mensagem de Cadastro Concluído
     System.out.println("Cadastro concluído!");
     System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco. Sua agência é " + agencia + 
     ", conta " + numero + " e seu saldo R$" + saldoFormatado + " já está disponível para saque");
    }
}
