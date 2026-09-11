import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		boolean[][] assentos = criarSala();

		menu(sc, assentos);
	}

	public static boolean[][] criarSala()
	{
		int qtdeFileiras = 5;
		int qtdeAssentos = 10;

		boolean[][] assentos = new boolean[qtdeFileiras][qtdeAssentos];

		return assentos;
	}

	public static void menu(Scanner sc, boolean[][] assentos)
	{
		int opcao = 0;

		while (opcao != 7)
		{
			System.out.println("""
				
				Bem vindo ao sistema de reservas!

				Escolha a operação:
				
				1 - Exibir o mapa de assentos
				2 - Reservar um assento
				3 - Cancelar uma reserva
				4 - Informar a quantidade e o percentual de assentos ocupados
				5 - Identificar a fileira com maior ocupação
				6 - Procurar assentos consecutivos
				7 - Encerrar""");

			System.out.print("\nEscolha uma opção: ");
			opcao = sc.nextInt();

			switch (opcao)
			{
				case 1 -> exibirMapa(assentos);
				case 2 -> reservarAssento(sc, assentos);
				case 3 -> cancelarReserva(sc, assentos);
				case 4 -> informarMetricasAssentos(assentos);
				case 5 -> encontrarFileiraMaiorOcupacao(assentos);
				case 6 -> procurarAssentosConsecutivos(sc, assentos);
				case 7 -> 
				{
					System.out.println("\nAté a próxima!");
					break;
				}
				default -> System.out.println("\nOpção inválida!");
			}
		}
	}

	public static void exibirMapa(boolean[][] assentos)
	{
		System.out.println("\nMapa de assentos:");
		System.out.print("     ");

		for (int j = 0; j < assentos[0].length; j++)
		{
			System.out.printf("%3d", j + 1);
		}

		System.out.println();

		for (int i = 0; i < assentos.length; i++)
		{
			System.out.printf("%c    ", 'A' + i);

			for (int j = 0; j < assentos[i].length; j++)
			{
				if (assentos[i][j])
				{
					System.out.print("[X]");
				}
				else
				{
					System.out.print("[ ]");
				}
			}

			System.out.println();
		}
	}

	public static void reservarAssento(Scanner sc, boolean[][] assentos)
	{
		System.out.print("\nDigite a fileira (A-E): ");
		char fileira = sc.next().toUpperCase().charAt(0);

		System.out.print("\nDigite o assento: ");
		int assento = sc.nextInt();

		if (fileira < 'A' || fileira > 'E' || assento < 1 || assento > 10)
		{
			System.out.println("\nFileira ou assento inválido!");
			return;
		}

		int indiceFileira = fileira - 'A';
		int indiceAssento = assento - 1;

		if (assentos[indiceFileira][indiceAssento])
		{
			System.out.println("\nEsse assento já está ocupado!");
			return;
		}

		assentos[indiceFileira][indiceAssento] = true;

		System.out.println("\nAssento reservado com sucesso.");
	}

	public static void cancelarReserva(Scanner sc, boolean[][] assentos)
	{
		System.out.print("\nDigite a fileira (A-E): ");
		char fileira = sc.next().toUpperCase().charAt(0);

		System.out.print("Digite o assento: ");
		int assento = sc.nextInt();

		if (fileira < 'A' || fileira > 'E' || assento < 1 || assento > 10)
		{
			System.out.println("\nFileira ou assento inválido!");
			return;
		}

		int indiceFileira = fileira - 'A';
		int indiceAssento = assento - 1;

		if (!assentos[indiceFileira][indiceAssento])
		{
			System.out.println("\nEsse assento está livre!");
			return;
		}

		assentos[indiceFileira][indiceAssento] = false;

		System.out.println("\nReserva cancelada com sucesso!");
	}

	public static void informarMetricasAssentos(boolean[][] assentos)
	{
		int qtdeOcupados = 0;

		for (int i = 0; i < assentos.length; i++)
		{
			for (int j = 0; j < assentos[i].length; j++)
			{
				if (assentos[i][j])
				{
					qtdeOcupados++;
				}
			}
		}

		int qtdeAssentos = assentos.length * assentos[0].length;

		double percentualOcupacao = (double) qtdeOcupados / qtdeAssentos * 100;

		System.out.println("\nQuantidade de assentos ocupados: " + qtdeOcupados);
		System.out.println("Percentual de ocupação: " + percentualOcupacao + "%");
	}

	public static void encontrarFileiraMaiorOcupacao(boolean[][] assentos)
	{
		int maiorOcupacao = 0;
		int fileiraMaiorOcupacao = 0;

		for (int i = 0; i < assentos.length; i++)
		{
			int qtdeOcupados = 0;

			for (int j = 0; j < assentos[i].length; j++)
			{
				if (assentos[i][j])
				{
					qtdeOcupados++;
				}
			}

			if (qtdeOcupados > maiorOcupacao)
			{
				maiorOcupacao = qtdeOcupados;
				fileiraMaiorOcupacao = i;
			}
		}

		System.out.println("\nFileira com maior ocupação: " + (char) ('A' + fileiraMaiorOcupacao));
		System.out.println("Quantidade de assentos ocupados: " + maiorOcupacao);
	}

	public static void procurarAssentosConsecutivos(Scanner sc, boolean[][] assentos)
	{
		System.out.print("\nDigite a quantidade de assentos desejada: ");
		int quantidade = sc.nextInt();

		if (quantidade <= 0 || quantidade > assentos[0].length)
		{
			System.out.println("\nQuantidade inválida.");
			return;
		}

		for (int i = 0; i < assentos.length; i++)
		{
			int inicio = -1, consecutivos = 0;

			for (int j = 0; j < assentos[i].length; j++)
			{
				if (!assentos[i][j])
				{
					consecutivos++;

					if (consecutivos == quantidade)
					{
						inicio = j - quantidade + 1;
						break;
					}
				}
				else
				{
					consecutivos = 0;
				}
			}

			if (inicio != -1)
			{
				System.out.println("\nConjunto encontrado!");
				System.out.println("Fileira: " + (char) ('A' + i));
				System.out.print("Assentos: ");

				for (int j = inicio; j < inicio + quantidade; j++)
				{
					System.out.print(j + 1);

					if (j < inicio + quantidade - 1)
					{
						System.out.print(", ");
					}
				}

				System.out.println();

				return;
			}
		}

		System.out.println("\nNão foi encontrado um conjunto disponível.");
	}
}