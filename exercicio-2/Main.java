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

		System.out.print("Digite o dia: ");
		data[0] = sc.nextInt();

		System.out.print("Digite o mês: ");
		data[1] = sc.nextInt();

		System.out.print("Digite o ano: ");
		data[2] = sc.nextInt();	
		System.out.println();	
		
		System.out.println("Data cadastrada: " + data[0] + "/" + data[1] + "/" + data[2]);

		System.out.println();	

		return data;
	}

	public static boolean verificarAnoBissexto(int data[]) 
	{
		boolean anoBissexto = false;

		if ((data[2] % 4 == 0 && data[2] % 100 != 0) || data[2] % 400 == 0)
		{
			anoBissexto = true;
		}	

		return anoBissexto;
	}

	public static int verificarDiasMes(int data[], boolean anoBissexto) 
	{
		int maximoDias = 0;

            switch (data[1]) 
			{
                case 1 -> maximoDias = 31;
				case 2 -> 
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
                case 3 -> maximoDias = 31;
				case 4 -> maximoDias = 30;
                case 5 -> maximoDias = 31;
				case 6 -> maximoDias = 30;
                case 7 -> maximoDias = 31;
                case 8 -> maximoDias = 31;
				case 9 -> maximoDias = 30;
                case 10 -> maximoDias = 31;
				case 11 -> maximoDias = 30;
                case 12 -> maximoDias = 31;
            }

		return maximoDias;
	}

	public static boolean verificarData(int data[], int maximoDias) 
	{
		boolean dataValida = true;

		if (data[2] < 1)
		{
			dataValida = false;
		}
		else if (data[1] < 1 || data[1] > 12)
		{
			dataValida = false;
		}
		else if (data[0] < 1 || data[0] > maximoDias)
		{
			dataValida = false;
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
		int posicao = data[0];

    	for (int i = 1; i < data[1]; i++)
    	{
        	int mes[] = {1, i, data[2]};

        	posicao += verificarDiasMes(mes, anoBissexto);
    	}

    	System.out.println("Posição no ano: dia " + posicao + ".");
	}
}