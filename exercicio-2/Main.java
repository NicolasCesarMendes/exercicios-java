import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
	    int data[] = lerData();

		boolean anoBissexto = verificarAnoBissexto(data);

		int maximoDias = verificarDiasMes(data, anoBissexto);

		boolean dataValida = verificarData(data, maximoDias);

		while (!dataValida)
		{
			System.out.println("Digite uma data válida!");
			System.out.println();

			data = lerData();

		    anoBissexto = verificarAnoBissexto(data);

			maximoDias = verificarDiasMes(data, anoBissexto);

			dataValida = verificarData(data, maximoDias);
		}

		verificarTrimestre(data);

		verificarPosicao(data, anoBissexto);
	}

	public static int[] lerData() 
	{
		int data[] = new int[3];		

		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o ano: ");
		data[0] = sc.nextInt();

		System.out.print("Digite o mês: ");
		data[1] = sc.nextInt();

		System.out.print("Digite o dia: ");
		data[2] = sc.nextInt();
		System.out.println();	
		
		System.out.println("Data cadastrada: " + data[0] + "/" + data[1] + "/" + data[2]);

		System.out.println();	

		return data;
	}

	public static boolean verificarAnoBissexto(int data[]) 
	{
		boolean anoBissexto = false;

		if ((data[0] % 4 == 0 && data[0] % 100 != 0) || data[0] % 400 == 0)
		{
			anoBissexto = true;
		}	

		return anoBissexto;
	}

	public static int verificarDiasMes(int data[], boolean anoBissexto) 
	{
		int maximoDias;

		if (data[1] == 1 || data[1] == 3 || data[1] == 5 || data[1] == 7 || data[1] == 8 || data[1] == 10 || data[1] == 12)
		{
			maximoDias = 31;
		}
		else if (data[1] == 2)
		{
			if (anoBissexto)
			{
				maximoDias = 29;
			}
			else 
			{
				maximoDias = 28;
			}
		}
		else
		{
			maximoDias = 30;
		}

		return maximoDias;
	}

	public static boolean verificarData(int data[], int maximoDias) 
	{
		boolean dataValida = true;

		if (data[0] < 1 || data[0] > 2026)
		{
			dataValida = false;
		}
		else if (data[1] < 1 || data[1] > 12)
		{
			dataValida = false;
		}
		else
		{
			if (data[2] < 1 || data[2] > maximoDias)
			{
				dataValida = false;
			}
		}

		return dataValida;
	}

	public static void verificarTrimestre(int data[]) 
	{
		if (data[1] < 4)
		{
			System.out.println("A data pertence ao 1º Trimestre do ano.");
		}
		else if (data[1] < 7)
		{
			System.out.println("A data pertence ao 2º Trimestre do ano.");
		}
		else if (data[1] < 10)
		{
			System.out.println("A data pertence ao 3º Trimestre do ano.");
		}
		else
		{
			System.out.println("A data pertence ao 4º Trimestre do ano.");
		}
		
		System.out.println();
	}

	public static void verificarPosicao(int data[], boolean anoBissexto) 
	{
		int posicao = data[2];

    	for (int i = 1; i < data[1]; i++)
    	{
        	int mes[] = {data[0], i, 1};

        	posicao += verificarDiasMes(mes, anoBissexto);
    	}

    	System.out.println("Posição no ano: dia " + posicao + ".");
	}
}