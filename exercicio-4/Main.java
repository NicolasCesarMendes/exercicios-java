import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
	    Scanner sc = new Scanner(System.in);
		
		System.out.print("Escreva uma frase: ");
		String frase = sc.nextLine();
		System.out.println("");

		System.out.print("Escolha uma letra para ser contada: ");
		String letraEscolhida = sc.nextLine();
		System.out.println("");

		int qtdeCaracteres = frase.length();

		int qtdeLetras = 0, qtdeVogais = 0, qtdeConsoantes = 0, qtdeAlgarismos = 0, qtdeEspacos = 0, qtdeOutrosCaracteres = 0, frequenciaLetraEscolhida = 0;
		char letraEscolhidaChar = letraEscolhida.charAt(0);

		for (int i = 0; i < qtdeCaracteres; i++) 
		{
			char charFrase = frase.charAt(i);

			if (Character.isLetter(charFrase)) 
			{
        		qtdeLetras += 1;
    		}
			else if (Character.isDigit(charFrase))
			{
				qtdeAlgarismos += 1;
			}
			else if (Character.isWhitespace(charFrase))
			{
				qtdeEspacos += 1;
			}
			else
			{
				qtdeOutrosCaracteres += 1;
			}

			charFrase = Character.toUpperCase(charFrase);

			if (charFrase == 'A' || charFrase == 'E' || charFrase == 'I' || charFrase == 'O' || charFrase == 'U') 
			{
        		qtdeVogais += 1;
    		}
			else if (Character.isLetter(charFrase))
			{
				qtdeConsoantes += 1;
			}

			if (charFrase == letraEscolhidaChar)
			{
				frequenciaLetraEscolhida += 1;
			}
		}

		String[] palavras = frase.split("\\s+");

		int qtdePalavras = palavras.length;

		String maiorPalavra = "";

		for (int i = 0; i < qtdePalavras; i++)
		{
			if (palavras[i].length() > maiorPalavra.length())
			{
				maiorPalavra = palavras[i];
			}
		}


	}
}