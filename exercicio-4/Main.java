import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		String frase = entradaFrase(sc);
		String letraEscolhida = entradaLetra(sc);

		analisarTexto(frase, letraEscolhida);
	}

	public static String entradaFrase(Scanner sc)
	{
		System.out.print("Escreva uma frase: ");
		String frase = sc.nextLine();
		System.out.println("");

		return frase;
	}

	public static String entradaLetra(Scanner sc)
	{
		System.out.print("Escolha uma letra para ser contada: ");
		String letraEscolhida = sc.nextLine();
		System.out.println("");

		return letraEscolhida;
	}

	public static void analisarTexto(String frase, String letraEscolhida)
	{
		System.out.println("Resultado da análise:");
		System.out.println("\nQuantidade de caracteres: " + contarCaracteres(frase));
		System.out.println("Quantidade de letras: " + contarLetras(frase));
		System.out.println("Quantidade de vogais: " + contarVogais(frase));
		System.out.println("Quantidade de consoantes: " + contarConsoantes(frase));
		System.out.println("Quantidade de algarismos: " + contarAlgarismos(frase));
		System.out.println("Quantidade de espaços: " + contarEspacos(frase));
		System.out.println("Quantidade de outros caracteres: " + contarOutrosCaracteres(frase));
		System.out.println("Quantidade de palavras: " + contarPalavras(frase));
		System.out.println("Maior palavra: " + encontrarMaiorPalavra(frase));
		System.out.println("Frequência da letra escolhida: " + contarFrequenciaLetra(frase, letraEscolhida));

		if (verificarPalindromo(frase))
		{
			System.out.println("A frase é um palíndromo.");
		}
		else
		{
			System.out.println("A frase não é um palíndromo.");
		}
	}

	public static int contarCaracteres(String frase)
	{
		int qtdeCaracteres = frase.length();

		return qtdeCaracteres;
	}

	public static int contarLetras(String frase)
	{
		int qtdeLetras = 0;

		for (int i = 0; i < frase.length(); i++)
		{
			if (Character.isLetter(frase.charAt(i)))
			{
				qtdeLetras++;
			}
		}

		return qtdeLetras;
	}

	public static int contarVogais(String frase)
	{
		int qtdeVogais = 0;

		for (int i = 0; i < frase.length(); i++)
		{
			char caractere = Character.toUpperCase(frase.charAt(i));

			if (caractere == 'A' || caractere == 'E' || caractere == 'I' || caractere == 'O' || caractere == 'U')
			{
				qtdeVogais++;
			}
		}

		return qtdeVogais;
	}

	public static int contarConsoantes(String frase)
	{
		int qtdeConsoantes = 0;

		for (int i = 0; i < frase.length(); i++)
		{
			char caractere = Character.toUpperCase(frase.charAt(i));

			if (Character.isLetter(caractere) && caractere != 'A' && caractere != 'E' && caractere != 'I' 
											  && caractere != 'O' && caractere != 'U')
			{
				qtdeConsoantes++;
			}
		}

		return qtdeConsoantes;
	}

	public static int contarAlgarismos(String frase)
	{
		int qtdeAlgarismos = 0;

		for (int i = 0; i < frase.length(); i++)
		{
			if (Character.isDigit(frase.charAt(i)))
			{
				qtdeAlgarismos++;
			}
		}

		return qtdeAlgarismos;
	}

	public static int contarEspacos(String frase)
	{
		int qtdeEspacos = 0;

		for (int i = 0; i < frase.length(); i++)
		{
			if (Character.isWhitespace(frase.charAt(i)))
			{
				qtdeEspacos++;
			}
		}

		return qtdeEspacos;
	}

	public static int contarOutrosCaracteres(String frase)
	{
		int qtdeOutrosCaracteres = 0;

		for (int i = 0; i < frase.length(); i++)
		{
			char caractere = frase.charAt(i);

			if (!Character.isLetter(caractere) &&
				!Character.isDigit(caractere) &&
				!Character.isWhitespace(caractere))
			{
				qtdeOutrosCaracteres++;
			}
		}

		return qtdeOutrosCaracteres;
	}

	public static int contarPalavras(String frase)
	{
		if (frase.trim().isEmpty())
		{
			return 0;
		}

		String palavras[] = frase.trim().split("\\s+");
		int qtdePalavras = palavras.length;

		return qtdePalavras;
	}

	public static String encontrarMaiorPalavra(String frase)
	{
		if (frase.trim().isEmpty())
		{
			return "Não há palavras.";
		}

		String palavras[] = frase.trim().split("\\s+");
		String maiorPalavra = "";

		for (int i = 0; i < palavras.length; i++)
		{
			if (palavras[i].length() > maiorPalavra.length())
			{
				maiorPalavra = palavras[i];
			}
		}

		return maiorPalavra;
	}

	public static int contarFrequenciaLetra(String frase, String letraEscolhida)
	{
		int qtdeLetraEscolhida = 0;
		char letra = Character.toUpperCase(letraEscolhida.charAt(0));

		for (int i = 0; i < frase.length(); i++)
		{
			char caractere = Character.toUpperCase(frase.charAt(i));

			if (caractere == letra)
			{
				qtdeLetraEscolhida++;
			}
		}

		return qtdeLetraEscolhida;
	}

	public static boolean verificarPalindromo(String frase)
	{
		String frasePalindromo = "";

		for (int i = 0; i < frase.length(); i++)
		{
			char caractere = frase.charAt(i);

			if (Character.isLetterOrDigit(caractere))
			{
				frasePalindromo += Character.toLowerCase(caractere);
			}
		}

		for (int i = 0; i < frasePalindromo.length() / 2; i++)
		{
			if (frasePalindromo.charAt(i) != frasePalindromo.charAt(frasePalindromo.length() - 1 - i))
			{
				return false;
			}
		}

		return true;
	}
}