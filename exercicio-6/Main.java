import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
    {
	    Scanner sc = new Scanner(System.in);
	    
		int qtdeParticipantes;

		qtdeParticipantes = lerQuantidade(sc);

		String[] participantes = lerParticipantes(sc, qtdeParticipantes);

		int[] tempos = lerTempos(sc, qtdeParticipantes);

		saidaDados(participantes, tempos);

		double tempoMedio = calcularMedia(tempos);

		System.out.println("Tempo médio: " + tempoMedio);

		contagemAbaixoMedia(tempos, tempoMedio);

		int temposOrdenados[] = new int[qtdeParticipantes];
		temposOrdenados = ordernarTempos(tempos);

		String participantesOrdenados[] = new String[qtdeParticipantes];
		participantesOrdenados = ordernarParticipantes(participantes, tempos, temposOrdenados);

		maiorMenorTempo(participantesOrdenados, temposOrdenados);

		exibirRanking(participantesOrdenados, temposOrdenados);

	    calcularMedianaDesvioPadrao(temposOrdenados, tempoMedio);
	}

	public static int lerQuantidade(Scanner sc) 
    {
		int qtdeParticipantes;

		System.out.print("Digite a quantidade de participantes da competição: ");

		qtdeParticipantes = sc.nextInt();
		sc.nextLine();

		System.out.println();

		return qtdeParticipantes;
	}

	public static String[] lerParticipantes(Scanner sc, int qtdeParticipantes) 
    {
		String participantes[] = new String[qtdeParticipantes];

		for (int i = 0; i < qtdeParticipantes; i++)
		{
			int posicao = i + 1;

			System.out.print("Nome do " + posicao + "º participante: ");
			participantes[i] = sc.nextLine();

			System.out.println();
		}

		return participantes;
	}

	public static int[] lerTempos(Scanner sc, int qtdeParticipantes) 
    {
		int tempos[] = new int[qtdeParticipantes];

		for (int i = 0; i < qtdeParticipantes; i++)
		{
			int posicao = i + 1;

			System.out.print("Tempo do " + posicao + "º participante: ");
			tempos[i] = sc.nextInt();

			System.out.println();
		}

		return tempos;
	}

	public static void saidaDados(String participantes[], int tempos[]) 
    {
		System.out.println("Dados cadastrados:");

		for (int i = 0; i < participantes.length; i++)
		{
			System.out.println("Participante: " + participantes[i] + ", Tempo: " + tempos[i] + " segundos.");
		}

		System.out.println();
	}

	public static double calcularMedia(int tempos[]) 
    {
		double soma = 0;

        for (int i = 0; i < tempos.length; i++) 
        {
            soma += tempos[i];
        }

        return soma / tempos.length;
	}

	public static void contagemAbaixoMedia(int tempos[], double media) 
    {
		int contagem = 0;

		for (int i = 0; i < tempos.length; i++)
		{
			if (tempos[i] < media)
			{
				contagem += 1;
			}
		}

		System.out.println("Participantes com tempo abaixo da média: " + contagem);
	}

	public static int[] ordernarTempos(int tempos[]) 
    {
		int limite = tempos.length - 1;
		
		int auxiliar;

		for (int i = 0; i < tempos.length; i++)
		{
			for (int j = 0; j < limite; j++)
			{
				if (tempos[j] > tempos[j + 1])
				{
					auxiliar = tempos[j];
					tempos[j] = tempos[j + 1];
					tempos[j + 1] = auxiliar;
				}
			}
		}
		
		return tempos;
	}

	public static String[] ordernarParticipantes(String participantes[], int tempos[], int temposOrdenados[]) 
    {
		int auxiliar = 0;

        for (int i = 0; i < tempos.length; i++)
        {
            for (int j = auxiliar; j < tempos.length; j++)
            {
                if (tempos[j] == temposOrdenados[i])
                {
                    participantes[i] = participantes[j];
                    auxiliar = j + 1;
                    break;
                }
            }
        }

        return participantes;
	}

	public static void maiorMenorTempo(String participantesOrdenados[], int temposOrdenados[]) 
    {
		int ultimoElemento = temposOrdenados.length - 1;

		System.out.println("Participante com o menor tempo: " + participantesOrdenados[0] + ", com " + temposOrdenados[0] + " segundos.");
		System.out.println("Participante com o maior tempo: " + participantesOrdenados[ultimoElemento] + ", com " + temposOrdenados[ultimoElemento] + " segundos.");
		System.out.println();
	}

	public static void exibirRanking(String participantesOrdenados[], int temposOrdenados[]) 
    {
		System.out.println("Ranking:");

		int posicao = 1;

		for (int i = 0; i < temposOrdenados.length; i++)
		{
			System.out.println(posicao + "º Lugar: " + participantesOrdenados[i] + ", com " + temposOrdenados[i] + " segundos.");
			posicao += 1;
		}

		System.out.println();
	}

	public static void calcularMedianaDesvioPadrao(int temposOrdenados[], double tempoMedio) 
    {
		double mediana;

		double resultado, resultados, variancia, desvioPadrao;

		resultados = 0;

		int metade = (temposOrdenados.length / 2);

		if (temposOrdenados.length % 2 == 0)
		{
			int segundaMetade = metade - 1;

			mediana = (temposOrdenados[metade] + temposOrdenados[segundaMetade]) / 2;
		}
		else
		{
			mediana = temposOrdenados[metade];
		}

		for (int i = 0; i < temposOrdenados.length; i++)
		{
			resultado = temposOrdenados[i] - tempoMedio;

			resultado = resultado * resultado;

			resultados += resultado;
		}

		variancia = resultados / temposOrdenados.length;
		desvioPadrao = Math.round(Math.sqrt(variancia) * 100.0) / 100.0;

		System.out.println("Mediana: " + mediana + " segundos.");
		System.out.println("Desvio Padrão: " + desvioPadrao + " segundos.");
	}
}