import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		char[][] matriz = criarMatriz(sc);
		String[] palavras = criarPalavras(sc);

		procurarPalavras(matriz, palavras);
	}

	public static char[][] criarMatriz(Scanner sc)
	{
		System.out.print("\nDigite a quantidade de linhas: ");
		int qtdeLinhas = sc.nextInt();

		System.out.print("\nDigite a quantidade de colunas: ");
		int qtdeColunas = sc.nextInt();

		char[][] matriz = new char[qtdeLinhas][qtdeColunas];

		System.out.println("\nDigite as letras da matriz:");

		for (int i = 0; i < matriz.length; i++)
		{
			for (int j = 0; j < matriz[i].length; j++)
			{
				System.out.print("Posição [" + i + "][" + j + "]: ");
				matriz[i][j] = sc.next().toUpperCase().charAt(0);
			}
		}

		return matriz;
	}

	public static String[] criarPalavras(Scanner sc)
	{
		System.out.print("\nDigite a quantidade de palavras: ");
		int qtdePalavras = sc.nextInt();

		String[] palavras = new String[qtdePalavras];

		for (int i = 0; i < palavras.length; i++)
		{
			System.out.print("Digite a " + (i + 1) + "º palavra: ");
			palavras[i] = sc.next().toUpperCase();
		}

		return palavras;
	}

	public static void procurarPalavras(char[][] matriz, String[] palavras)
	{
		int[][] direcoes = {
			{ 0,  1},
			{ 0, -1},
			{ 1,  0},
			{-1,  0},
			{ 1,  1},
			{-1, -1},
			{ 1, -1},
			{-1,  1}
		};

		String[] nomesDirecoes = {
			"Horizontal da esquerda para a direita",
			"Horizontal da direita para a esquerda",
			"Vertical de cima para baixo",
			"Vertical de baixo para cima",
			"Diagonal superior esquerda para inferior direita",
			"Diagonal inferior direita para superior esquerda",
			"Diagonal superior direita para inferior esquerda",
			"Diagonal inferior esquerda para superior direita"
		};

		for (int i = 0; i < palavras.length; i++)
		{
			boolean encontrada = false;

			for (int linha = 0; linha < matriz.length && !encontrada; linha++)
			{
				for (int coluna = 0; coluna < matriz[linha].length && !encontrada; coluna++)
				{
					for (int direcao = 0; direcao < direcoes.length && !encontrada; direcao++)
					{
						int direcaoLinha = direcoes[direcao][0];
						int direcaoColuna = direcoes[direcao][1];

						if (verificarPalavra(matriz, palavras[i], linha, coluna, direcaoLinha, direcaoColuna))
						{
							int linhaFinal = linha;
							int colunaFinal = coluna;

							for (int j = 1; j < palavras[i].length(); j++)
							{
								linhaFinal = linhaFinal + direcaoLinha;
								colunaFinal = colunaFinal + direcaoColuna;
							}

							System.out.println("\nPalavra encontrada: " + palavras[i]);
							System.out.println("Posição inicial: [" + linha + "][" + coluna + "]");
							System.out.println("Posição final: [" + linhaFinal + "][" + colunaFinal + "]");
							System.out.println("Direção: " + nomesDirecoes[direcao]);

							encontrada = true;
						}
					}
				}
			}

			if (!encontrada)
			{
				System.out.println("\nPalavra não encontrada: " + palavras[i]);
			}
		}
	}

	public static boolean verificarPalavra(char[][] matriz, String palavra, int linha, int coluna, int direcaoLinha, int direcaoColuna)
	{
		int novaLinha = linha;
		int novaColuna = coluna;

		for (int i = 0; i < palavra.length(); i++)
		{
			if (novaLinha < 0 || novaLinha >= matriz.length || novaColuna < 0 || novaColuna >= matriz[0].length)
			{
				return false;
			}

			if (matriz[novaLinha][novaColuna] != palavra.charAt(i))
			{
				return false;
			}

			novaLinha = novaLinha + direcaoLinha;
			novaColuna = novaColuna + direcaoColuna;
		}

		return true;
	}
}