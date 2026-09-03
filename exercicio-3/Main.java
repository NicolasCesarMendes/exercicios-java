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

		while (true)
		{
			System.out.println("""
			Bem vindo à calculadora interativa!
			
			Escolha a operação:

			1. soma;
			2. subtração;
			3. multiplicação;
			4. divisão;
			5. potenciação;
			6. resto da divisão;
			7. encerrar.""");

			System.out.println("");

			System.out.print("Digite o número da operação: ");
			int operacao = sc.nextInt();

			System.out.println("");

			if (operacao < 1 || operacao > 7)
			{
				System.out.println("Operação inválida!");
				System.out.println("");
				continue;
			}

			if (operacao == 7)
			{
    			break;
			}

			double numero, numero2;

			System.out.print("Digite o primeiro número: ");
			numero = sc.nextDouble();

			System.out.println("");

			System.out.print("Digite o segundo número: ");
			numero2 = sc.nextDouble();

			System.out.println("");

			double resultado = 0;

			switch (operacao) 
			{
				case 1 -> resultado = adicao(numero, numero2);
				case 2 -> resultado = subtracao(numero, numero2);
				case 3 -> resultado = multiplicacao(numero, numero2);
				case 4 -> resultado = divisao(numero, numero2);
				case 5 -> resultado = potenciacao(numero, numero2);
				case 6 -> resultado = resto(numero, numero2);
			}

			System.out.println("Resultado: " + resultado);
		}		
	}

	public static double adicao(double numero, double numero2)
	{
		double resultado = numero + numero2;

		return resultado;
	}

	public static double subtracao(double numero, double numero2)
	{
		double resultado = numero - numero2;

		return resultado;
	}

	public static double multiplicacao(double numero, double numero2)
	{
		double resultado = numero * numero2;

		return resultado;
	}

	public static double divisao(double numero, double numero2)
	{
		if (numero2 == 0)
		{
			System.out.println("Não existe divisão por 0.");

			return 0;
		}

		double resultado = numero / numero2;

		return resultado;
	}

	public static double potenciacao(double numero, double numero2)
	{
		double resultado = Math.pow(numero, numero2);

		return resultado;
	}

	public static double resto(double numero, double numero2)
	{
		double resultado = numero % numero2;

		return resultado;
	}
}