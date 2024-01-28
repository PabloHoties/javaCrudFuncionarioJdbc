package controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import entities.Funcionario;
import repositories.FuncionarioRepository;

public class FuncionarioController {

	public void cadastrarFuncionario() throws Exception {
		System.out.println("\nCadastro de Funcionário:\n");

		Funcionario funcionario = new Funcionario();
		Scanner scanner = new Scanner(System.in);
		funcionario.setId(UUID.randomUUID());

		System.out.print("\nInforme o nome: ");
		funcionario.setNome(scanner.nextLine());

		System.out.print("\nInforme o CPF: ");
		funcionario.setCpf(scanner.nextLine());

		System.out.print("\nInforme a matrícula: ");
		funcionario.setMatricula(scanner.nextLine());

		System.out.print("\nInforme o salário: ");
		BigDecimal salario = new BigDecimal(scanner.nextLine());
		funcionario.setSalario(salario);

		FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
		funcionarioRepository.create(funcionario);

		System.out.println("\nFuncionário cadastrado com sucesso!");

		scanner.close();
	}

	public void atualizarFuncionario() throws Exception {
		System.out.println("\nEdição de Funcionário:\n");

		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite o ID do Funcionário: ");
		UUID id = UUID.fromString(scanner.nextLine());

		FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
		Funcionario funcionario = funcionarioRepository.findById(id);

		if (funcionario != null) {
			System.out.print("\nInforme o nome: ");
			funcionario.setNome(scanner.nextLine());

			System.out.print("\nInforme o CPF: ");
			funcionario.setCpf(scanner.nextLine());

			System.out.print("\nInforme a matrícula: ");
			funcionario.setMatricula(scanner.nextLine());

			System.out.print("\nInforme o salário: ");
			BigDecimal salario = new BigDecimal(scanner.nextLine());
			funcionario.setSalario(salario);

			funcionarioRepository.update(funcionario);

			System.out.println("\nFuncionário atualizado com sucesso!");
		} else
			System.out.println("\nFuncionário não encontrado. Verifique o ID.");

		scanner.close();
	}

	public void excluirFuncionario() throws Exception {
		System.out.println("\nExclusão de Funcionário:\n");

		Scanner scanner = new Scanner(System.in);

		System.out.print("Informe o ID do Funcionário: ");
		UUID id = UUID.fromString(scanner.nextLine());
		scanner.close();

		FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
		Funcionario funcionario = funcionarioRepository.findById(id);

		if (funcionario != null) {
			funcionarioRepository.delete(funcionario);

			System.out.println("\nFuncionário excluído com sucesso!");
		} else
			System.out.println("\nFuncionário não encontrado. Verifique o ID.");
	}

	public void consultarFuncionarios() throws Exception {
		System.out.println("\nConsulta de Funcionários:\n");

		FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
		List<Funcionario> lista = funcionarioRepository.findAll();

		for (Funcionario funcionario : lista) {
			System.out.print("\nID do Funcionário: " + funcionario.getId());
			System.out.print("\nNome: " + funcionario.getNome());
			System.out.print("\nCPF: " + funcionario.getCpf());
			System.out.print("\nMatrícula: " + funcionario.getMatricula());
			System.out.print("\nSalário: " + funcionario.getSalario());
			System.out.println("\n...");
		}
	}
}
