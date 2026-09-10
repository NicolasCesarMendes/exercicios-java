import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

	    ArrayList<String> produtos = new ArrayList<>();
		ArrayList<Integer> quantidades = new ArrayList<>();
		ArrayList<Double> precos = new ArrayList<>();

		int operacao;

		while (true)
		{
			operacao = menu(sc);

			if (operacao == 9)
			{
				break;
			}

			switch (operacao) 
			{
				case 1 -> adicionarProduto(sc, produtos, quantidades, precos);
				case 2 -> alterarQtdeProduto(sc, produtos, quantidades);
				case 3 -> alterarPrecoProduto(sc, produtos, precos);
				case 4 -> removerProduto(sc, produtos, quantidades, precos);
				case 5 -> pesquisarProduto(sc, produtos, quantidades, precos);
				case 6 -> listarProdutos(produtos, quantidades, precos);
				case 7 -> calcularValorTotal(produtos, quantidades, precos);
				case 8 -> identificarMaiorSubtotal(produtos, quantidades, precos);
				default -> System.out.println("\nDigite uma operação válida!");
			}
		}
	}

	public static int menu(Scanner sc)
	{
		System.out.println("""
			
			Bem vindo ao Gerenciador de Compras!

			Operações:

			1. Adicionar um produto.
			2. Alterar a quantidade de um produto.
			3. Alterar o preço de um produto.
			4. Remover um produto.
			5. Pesquisar produtos pelo nome ou por parte dele.
			6. Listar todos os produtos.
			7. Calcular o valor total da compra.
			8. Identificar o produto com maior subtotal.
			9. Encerrar.""");

		System.out.print("\nDigite a operação desejada: ");
		int operacao = sc.nextInt();
		sc.nextLine();

		return operacao;
	}

	public static void adicionarProduto(Scanner sc, ArrayList<String> produtos, ArrayList<Integer> quantidades, ArrayList<Double> precos) 
	{
		System.out.print("\nDigite o nome do produto: ");
		String produto = sc.nextLine();

		for (int i = 0; i < produtos.size(); i++)
		{
			if (produto.equals(produtos.get(i)))
			{
				System.out.print("\nO produto já existe, gostaria de editar a quantidade? ");
				System.out.print("\nDigite a sua resposta (sim/não): ");
				String resposta = sc.nextLine().toLowerCase();

				if (resposta.equals("sim"))
				{
					System.out.print("\nDigite a nova quantidade: ");
					int qtde = sc.nextInt();

					if (qtde < 0)
					{
						System.out.println("\nQuantidade inválida!");
						return;
					}

					quantidades.set(i, qtde);
				}
				else if (resposta.equals("não"))
				{
					return;
				}
				else
				{
					System.out.println("\nResposta inválida!");
					return;
				}

				return;
			}
		}

		produtos.add(produto);

		System.out.print("\nDigite a quantidade: ");
		int qtde = sc.nextInt();

		if (qtde < 0)
		{
			System.out.println("\nQuantidade inválida!");
			produtos.remove(produtos.size() - 1);
			return;
		}

		quantidades.add(qtde);

		System.out.print("\nDigite o preço: R$ ");
		double preco = sc.nextDouble();

		if (preco < 0)
		{
			System.out.println("\nPreço inválido!");
			produtos.remove(produtos.size() - 1);
			quantidades.remove(quantidades.size() - 1);
			return;
		}

		precos.add(preco);
	}

	public static void alterarQtdeProduto(Scanner sc, ArrayList<String> produtos, ArrayList<Integer> quantidades) 
	{
		System.out.print("\nDigite o nome do produto a ser alterado a quantidade: ");
		String produto = sc.nextLine();

		for (int i = 0; i < produtos.size(); i++)
		{
			if (produto.equals(produtos.get(i)))
			{
				System.out.print("\nDigite a nova quantidade: ");
				int qtde = sc.nextInt();

				if (qtde < 0)
				{
					System.out.println("\nQuantidade inválida!");
					break;
				}

				quantidades.set(i, qtde);
			}
		}
	}

	public static void alterarPrecoProduto(Scanner sc, ArrayList<String> produtos, ArrayList<Double> precos) 
	{
		System.out.print("\nDigite o nome do produto a ser alterado o preço: ");
		String produto = sc.nextLine();

		for (int i = 0; i < produtos.size(); i++)
		{
			if (produto.equals(produtos.get(i)))
			{
				System.out.print("\nDigite o novo preço: R$ ");
				double preco = sc.nextDouble();

				if (preco <= 0)
				{
					System.out.println("\nPreço inválido!");
					break;
				}

				precos.set(i, preco);
			}
		}
	}

	public static void removerProduto(Scanner sc, ArrayList<String> produtos, ArrayList<Integer> quantidades, ArrayList<Double> precos) 
	{
		System.out.print("\nDigite o nome do produto a ser removido: ");
		String produto = sc.nextLine();

		for (int i = 0; i < produtos.size(); i++)
		{
			if (produto.equals(produtos.get(i)))
			{
				produtos.remove(i);
				quantidades.remove(i);
				precos.remove(i);
				break;
			}
		}
	}

	public static void pesquisarProduto(Scanner sc, ArrayList<String> produtos, ArrayList<Integer> quantidades, ArrayList<Double> precos) 
	{
		System.out.print("\nDigite o nome do produto a ser pesquisado: ");
		String produto = sc.nextLine();

		for (int i = 0; i < produtos.size(); i++)
		{
			if (produtos.get(i).toLowerCase().contains(produto.toLowerCase()))
			{
				System.out.println("\nProduto: " + produtos.get(i));
				System.out.println("Quantidade: " + quantidades.get(i));
				System.out.println("Preço: R$ " + precos.get(i));
			}
		}
	}

	public static void listarProdutos(ArrayList<String> produtos, ArrayList<Integer> quantidades, ArrayList<Double> precos) 
	{
		for (int i = 0; i < produtos.size(); i++)
		{
			System.out.println("\nProduto: " + produtos.get(i));
			System.out.println("Quantidade: " + quantidades.get(i));
			System.out.println("Preço: R$ " + precos.get(i));
		}
	}

	public static void calcularValorTotal(ArrayList<String> produtos, ArrayList<Integer> quantidades, ArrayList<Double> precos) 
	{
		double valorTotal = 0;

		for (int i = 0; i < produtos.size(); i++)
		{
			valorTotal += (double) quantidades.get(i) * precos.get(i);
		}

		System.out.println("\nValor total: R$ " + valorTotal);
	}

	public static void identificarMaiorSubtotal(ArrayList<String> produtos, ArrayList<Integer> quantidades, ArrayList<Double> precos) 
	{
		if (produtos.isEmpty())
		{
			System.out.println("\nNão há produtos cadastrados!");
			return;
		}

		int indiceMaiorSubtotal = 0;

		for (int i = 1; i < produtos.size(); i++)
		{
			if (quantidades.get(i) * precos.get(i) > quantidades.get(indiceMaiorSubtotal) * precos.get(indiceMaiorSubtotal))
			{
				indiceMaiorSubtotal = i;
			}
		}

		System.out.println("\nMaior subtotal: ");
		System.out.println("Produto: " + produtos.get(indiceMaiorSubtotal));
		System.out.println("Quantidade: " + quantidades.get(indiceMaiorSubtotal));
		System.out.println("Preço: R$ " + precos.get(indiceMaiorSubtotal));
		System.out.println("Subtotal: R$ " + quantidades.get(indiceMaiorSubtotal) * precos.get(indiceMaiorSubtotal));
	}
}