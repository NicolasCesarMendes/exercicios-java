import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite a quantidade de números que serão digitados: ");
		int qtdeNumeros = sc.nextInt();
		System.out.println();

		int[] numeros = new int[qtdeNumeros];

		for (int i = 0; i < numeros.length; i++)
		{
			System.out.print("Digite o " + (i + 1) + "º número: ");

			numeros[i] = sc.nextInt();
		}

		System.out.print("\nDigite o valor alvo: ");
		int numeroAlvo = sc.nextInt();

		sc.close();

		verificarPares(numeros, numeroAlvo);
	}

	public static void verificarPares(int[] numeros, int numeroAlvo)
	{
		int qtdePares = 0;

		for (int i = 0; i < numeros.length; i++)
		{
			for (int j = i + 1; j < numeros.length; j++)
			{
				if (numeros[i] + numeros[j] == numeroAlvo)
				{
					if (qtdePares == 0)
					{
						System.out.println("\nPar encontrado!");
					}
					else
					{
						System.out.println("\nNovo par encontrado!");
					}					
					
					System.out.println(numeros[i] + " + " + numeros[j] + " = " + numeroAlvo + ".");
					System.out.println("Índices: " + (i + 1) + " e " + (j + 1) + ".");

					qtdePares++;
				}
			}
		}

		if (qtdePares == 0)
		{
			System.out.println("Nenhum par foi encontrado.");
		}
		else
		{
			System.out.println("\nQuantidade de pares encontrada: " + qtdePares);
		}
	}
}