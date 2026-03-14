import java.util.Scanner;

public class ControleEstoque {
    // Arrays com os nomes originais que você me mandou
    private static String[] nomesProdutos = new String[100];
    private static double[] precosProdutos = new double[100];
    private static int[] quantidadesProdutos = new int[100];
    private static int totalProdutos = 0;

    // Scanner estático para funcionar em todos os métodos
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int opcao = -1;

        while (opcao != 4) {
            exibirMenu(); // Mostra as opções na tela
            System.out.print("Escolha: ");
            
            try {
                // Lê a opção que o usuário digitou
                opcao = Integer.parseInt(scanner.nextLine().trim());

                // O switch principal fica AQUI! Ele decide qual método chamar.
                switch (opcao) {
                    case 1:
                        // Se digitou 1, chama o método de cadastrar
                        cadastrarProduto();
                        break;
                    case 2:
                        // Se digitou 2, chama o método de consultar
                        consultarEstoque();
                        break;
                    case 3:
                        // Se digitou 3, chama o método de resgidtro de vendas
                        registrarVendas();
                        break;
                    case 4:
                        System.out.println("Saindo do sistema... Até logo!");
                        break;
                    default:
                        // Se digitar 5, 6, 99... cai aqui
                        System.out.println("❌ Opção inválida! Escolha um número de 1 a 4.");
                        break;
                }

            } catch (Exception e) {
                System.out.println("❌ Por favor, digite apenas números.");
            }
        }
        }

    public static void exibirMenu() {
        System.out.println("\n" + "=".repeat(20));
        System.out.println("1--Cadastrar Novo Produto--");
        System.out.println("2--Consultar Estoque--");
        System.out.println("3--Registrar Vendas--");
        System.out.println("4--Sair--");
        System.out.println( "=".repeat(20));
    }

    public static void cadastrarProduto(int opcao) {
        
    }

    public static void cadastrarProduto() {
        System.out.println("\n ----Cadastrar Produto----");

        System.out.println("Produto: ");
        String Produto = scanner.nextLine().trim();

        if (Produto.isEmpty()) {
            System.out.println("Campo nao pode esta vazio");
            return; }

        System.out.println("Preço: ");
        String textoPreço = scanner.nextLine().trim();

        if (textoPreço.isEmpty()) {
            System.out.println("Campo nao pode esta vazio");
            return; }
            // ira converter o texto para numero//
            double Preço = Double.parseDouble(textoPreço);

        System.out.println("Quantidade: ");
        String textoQuantidade = scanner.nextLine().trim();

        if (textoQuantidade.isEmpty()) {
            System.out.println("Campo não pode estar vazio");
            return; }

            int Quantidade = Integer.parseInt(textoQuantidade);

        // Usando seus nomes de arrays originais para salvar
        nomesProdutos[totalProdutos] = Produto;
        precosProdutos[totalProdutos] = Preço;
        quantidadesProdutos[totalProdutos] = Quantidade;
        totalProdutos++;

        System.out.println("Produto cadastrado com sucesso!");

    }
            public static void quantidadesProdutos(int opcao){
            switch (opcao) {
                case 1:
                System.out.println("\n---Quantidade de Produtos no Estoque ---");

                if (totalProdutos == 0) {
                    System.out.println("Nenhum produto cadstrado ainda");
                } else {
                    for (int i = 0; i < totalProdutos; i++) {
                        System.out.println("Produtos: " + nomesProdutos[i] + "Quantidade " + quantidadesProdutos[i]);
                    }
                }

                    break;

            }
        }
    public static void consultarEstoque(){
                System.out.println("\n Consultar no estoque");
                System.out.println("---Digite o nome do produto---");
                String busca = scanner.nextLine().trim().toLowerCase();
                // usamos o boolean para avisar que o produto foi encontrado //
                boolean encontrou = false;

                for (int i = 0; i < totalProdutos; i++){
                    // pegamos o nome  na gaveta i e transfomamos em minusculo//
                    String nomeAtual = nomesProdutos[i].toLowerCase();
                    // pegamos o nome e o contains verifica se faz parte do nome do produto//
                    if (nomeAtual.contains(busca)) {
                    System.out.println("Nome:" + nomesProdutos[i]);
                    System.out.println("Preço: R$" + precosProdutos[i]);
                    System.out.println("Quantidade:" + quantidadesProdutos[i]);

                    encontrou = true;
                    }
                }
                if (!encontrou) {
                    System.out.println("\n Produto não encontrado no estoque ");
                    
                }
        }
        
    public static void registrarVendas() {
                    System.out.println("\n---Registrar Vendas---");
                    if (totalProdutos == 0) {
                        System.out.println("Produto fora de Estoque :(");
                        return;
                    }

                    System.out.println("Digite o nome do produto");
                    String busca = scanner.nextLine().trim().toLowerCase();

                    boolean encontrou = false;
                    // ffor faz a busca exatamente igual ao estoque//
                    for(int i = 0; i < totalProdutos; i++){
                        String nomeAtual = nomesProdutos[i].toLowerCase();

                        if (nomeAtual.contains(busca)) {
                        encontrou = true;
                    System.out.println("Produto encontrado" + nomesProdutos[i]);
                    System.out.println("Preço:" + precosProdutos[i]);
                    System.out.println("Quantidade Disponivel:" + quantidadesProdutos[i]);
                            // usuario ira digitar o produto que deseja vender e o sistema ira escaner//
                    System.out.println("Digite o nome do produto que deseja vender");
                    // pessoa digta o valor quer deseja vender
                    System.out.print("\nDigite a quantidade que deseja vender: ");

                    try{
                        int qtdVenda = Integer.parseInt(scanner.nextLine().trim());
                        // vericar se a pessoa digitou um numero valido e se esta disponivel no estoque//
                        if (qtdVenda <= 0 ) {
                        System.out.println("Quantidade invalida! A Venda foi cancelada");
                            }else if (qtdVenda > quantidadesProdutos[i]){
                        System.out.println("Estoque insuficiente voce sÓ tem " + quantidadesProdutos[i] + "unidades.");
                        } else
                        //pegamos a quantidade antiga e tiramos a vendida//
                        quantidadesProdutos[i] = quantidadesProdutos[i] - qtdVenda;

                        //calcular o total da venda//
                        double valorTotal = qtdVenda * precosProdutos[i];

                        System.out.println("\n💰 Venda realizada com sucesso!");
                        System.out.println("Total a pagar: R$ " + valorTotal);
                        System.out.println("Estoque atualizado de " + nomesProdutos[i] + ": " + quantidadesProdutos[i]);
                    } catch (Exception e) {
                        System.out.println("Por favor digite um numero! ");
                }
                    break;
        
                    
    }
        if (!encontrou) {
            System.out.println("\n produto nao encontrado");
            }
        }
    
    }
}