import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> numeros = entrada(sc);

		analisarNumeros(numeros);
	}

	public static ArrayList<Integer> entrada(Scanner sc)
	{
		System.out.println("Bem vindo ao analisador de números!");
		System.out.println("\nDigite 0 para parar o programa.");

		ArrayList<Integer> numeros = new ArrayList<>();

		while (true)
		{
			System.out.print("\nDigite um número inteiro: ");
			int numero = sc.nextInt();

			if (numero == 0)
			{
				break;
			}

			numeros.add(numero);
		}

		return numeros;
	}

	public static void analisarNumeros(ArrayList<Integer> numeros)
	{
		if (numeros.isEmpty())
		{
			System.out.println("\nNenhum número foi digitado.");
			return;
		}

		System.out.println("\nResultado da análise:");
		System.out.println("\nQuantidade de números digitados: " + contarNumeros(numeros));
		System.out.println("Soma dos valores: " + calcularSoma(numeros));
		System.out.printf("Média geral: %.2f%n", calcularMedia(numeros));
		System.out.println("Maior valor: " + encontrarMaior(numeros));
		System.out.println("Menor valor: " + encontrarMenor(numeros));
		System.out.println("Quantidade de valores positivos: " + contarPositivos(numeros));
		System.out.println("Quantidade de valores negativos: " + contarNegativos(numeros));
		System.out.println("Quantidade de valores pares: " + contarPares(numeros));
		System.out.println("Quantidade de valores ímpares: " + contarImpares(numeros));
		System.out.println("Quantidade de múltiplos de três: " + contarMultiplosTres(numeros));
	}

	public static int contarNumeros(ArrayList<Integer> numeros)
	{
		int qtdeNumeros = numeros.size();

		return qtdeNumeros;
	}

	public static int calcularSoma(ArrayList<Integer> numeros)
	{
		int somaNumeros = 0;

		for (int i = 0; i < numeros.size(); i++)
		{
			somaNumeros += numeros.get(i);
		}

		return somaNumeros;
	}

	public static double calcularMedia(ArrayList<Integer> numeros)
	{
		int somaNumeros = calcularSoma(numeros);
		int qtdeNumeros = contarNumeros(numeros);

		double media = (double) somaNumeros / qtdeNumeros;

		return media;
	}

	public static int encontrarMaior(ArrayList<Integer> numeros)
	{
		int maiorNumero = numeros.get(0);

		for (int i = 0; i < numeros.size(); i++)
		{
			if (numeros.get(i) > maiorNumero)
			{
				maiorNumero = numeros.get(i);
			}
		}

		return maiorNumero;
	}

	public static int encontrarMenor(ArrayList<Integer> numeros)
	{
		int menorNumero = numeros.get(0);

		for (int i = 0; i < numeros.size(); i++)
		{
			if (numeros.get(i) < menorNumero)
			{
				menorNumero = numeros.get(i);
			}
		}

		return menorNumero;
	}

	public static int contarPositivos(ArrayList<Integer> numeros)
	{
		int qtdePositivos = 0;

		for (int i = 0; i < numeros.size(); i++)
		{
			if (numeros.get(i) > 0)
			{
				qtdePositivos++;
			}
		}

		return qtdePositivos;
	}

	public static int contarNegativos(ArrayList<Integer> numeros)
	{
		int qtdeNegativos = 0;

		for (int i = 0; i < numeros.size(); i++)
		{
			if (numeros.get(i) < 0)
			{
				qtdeNegativos++;
			}
		}

		return qtdeNegativos;
	}

	public static int contarPares(ArrayList<Integer> numeros)
	{
		int qtdePares = 0;

		for (int i = 0; i < numeros.size(); i++)
		{
			if (numeros.get(i) % 2 == 0)
			{
				qtdePares++;
			}
		}

		return qtdePares;
	}

	public static int contarImpares(ArrayList<Integer> numeros)
	{
		int qtdeImpares = 0;

		for (int i = 0; i < numeros.size(); i++)
		{
			if (numeros.get(i) % 2 != 0)
			{
				qtdeImpares++;
			}
		}

		return qtdeImpares;
	}

	public static int contarMultiplosTres(ArrayList<Integer> numeros)
	{
		int qtdeMultiplosTres = 0;

		for (int i = 0; i < numeros.size(); i++)
		{
			if (numeros.get(i) % 3 == 0)
			{
				qtdeMultiplosTres++;
			}
		}

		return qtdeMultiplosTres;
	}
}