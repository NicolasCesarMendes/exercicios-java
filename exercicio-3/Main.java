import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		calculadora();
	}

	public static void calculadora()
	{
		Scanner sc = new Scanner(System.in);

		int operacao = 0;

		while (operacao != 7)
		{
			System.out.println("""
			Bem vindo à calculadora interativa!
			
			Escolha a operação:

			1. soma;
			2. subtração;
			3. multiplicação;
			4. divisão;
			6. resto da divisão;
			7. encerrar.""");

			System.out.println("");

			System.out.print("Digite o número da operação: ");
			operacao = sc.nextInt();

			System.out.println("");
		}		
	}
}