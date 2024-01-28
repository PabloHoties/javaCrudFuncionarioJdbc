package principal;

import java.util.Scanner;

import controllers.FuncionarioController;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nSistema para controle de Funcionários:\n");

		try {
			System.out.println("(1) Cadastrar Funcionário");
			System.out.println("(2) Atualizar Funcionário");
			System.out.println("(3) Excluir Funcionário");
			System.out.println("(4) Consultar Funcionários");

			System.out.print("\nInforme a opção desejada: ");
			Integer opcao = Integer.parseInt(scanner.nextLine());

			FuncionarioController funcionarioController = new FuncionarioController();

			switch (opcao) {
			case 1:
				funcionarioController.cadastrarFuncionario();
				break;
			case 2:
				funcionarioController.atualizarFuncionario();
				break;
			case 3:
				funcionarioController.excluirFuncionario();
				break;
			case 4:
				funcionarioController.consultarFuncionarios();
				break;
			default:
				System.out.println("\nOpção inválida!");
				break;
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro: " + e.getMessage());
		}
		scanner.close();
	}

}
