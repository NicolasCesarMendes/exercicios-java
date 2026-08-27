import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

	    String nome = lerNome(sc);
	    
		double[] notas = lerNotas(sc);
	    
	    double frequencia = lerFrequencia(sc);
	    
	    double media = calcularMedia(notas);
	    
	    exibirDados(nome, frequencia, media);
	}
	
	
	public static String lerNome(Scanner sc) 
	{
	    System.out.print("Digite o nome do estudante: ");
		String nome = sc.nextLine();
		
		System.out.println();
		
		return nome;
	}
	
	public static double[] lerNotas(Scanner sc) 
	{	    
	    double notas[] = new double[3];
	    
	    for (int i = 0; i < 3; i++) 
	    {
	        int posicao = i + 1;

			System.out.print("Digite a " + posicao + "º nota: ");
			double nota = sc.nextDouble();
			
			while (nota < 0 || nota > 10)
            {
                System.out.println();
                
                System.out.println("Nota inválida! A nota deve estar entre 0 e 10.");
                System.out.print("Digite novamente a " + posicao + "º nota: ");
                nota = sc.nextDouble();
                
                System.out.println();
            }
            
            notas[i] = nota;
			
			System.out.println();
	    }
		
		return notas;
	}
	
	public static double lerFrequencia(Scanner sc)
	{	    
	    System.out.print("Digite a porcentagem de frequência do estudante (apenas números): ");
		double frequencia = sc.nextDouble();
		
		while (frequencia < 0 || frequencia > 100)
        {
            System.out.println();
            
            System.out.println("Frequência inválida! A porcentagem deve estar entre 0 e 100.");
            System.out.print("Digite novamente a frequência: ");
            frequencia = sc.nextDouble();
                
            System.out.println();
        }
		
		System.out.println();
		
		return frequencia;
	}
	
	public static double calcularMedia(double notas[])
	{
	    double soma = 0;
	    
	    double media;
	    
	    for (int i = 0; i < 3; i++) 
	    {
	        soma += notas[i];
	    }
	    
	    media = soma / 3;
	    
	    return media;
	}
	
	public static void exibirDados(String nome, double frequencia, double media)
	{
	    System.out.println("Nome do estudante: " + nome + ".");
	    System.out.println("Frequência: " + frequencia + "%.");
	    System.out.printf("Média: %.2f.%n", media);
	    
	    System.out.println();
	    
	    if (frequencia < 75)
	    {
    		System.out.println("Estado: Reprovado por frequência.");
	    }
	    else if (media < 5)
	    {
	        System.out.println("Estado: Reprovado por nota.");
	    }
	    else if (media < 7)
	    {
	        System.out.println("Estado: Recuperação.");
	    }
	    else
	    {
	        System.out.println("Estado: Aprovado.");
	    }
	}
}