package repositories;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import entities.Funcionario;
import factories.ConnectionFactory;

public class FuncionarioRepository {

	public void create(Funcionario funcionario) throws Exception {
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("insert into funcionario(id, nome, cpf, matricula, salario) values(?, ?, ?, ?, ?)");

		statement.setObject(1, funcionario.getId());
		statement.setString(2, funcionario.getNome());
		statement.setString(3, funcionario.getCpf());
		statement.setString(4, funcionario.getMatricula());
		statement.setBigDecimal(5, funcionario.getSalario());

		statement.execute();
		connection.close();
	}

	public void update(Funcionario funcionario) throws Exception {
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("update funcionario set nome=?, cpf=?, matricula=?, salario=? where id=?");

		statement.setString(1, funcionario.getNome());
		statement.setString(2, funcionario.getCpf());
		statement.setString(3, funcionario.getMatricula());
		statement.setBigDecimal(4, funcionario.getSalario());
		statement.setObject(5, funcionario.getId());

		statement.execute();
		connection.close();
	}

	public void delete(Funcionario funcionario) throws Exception {
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("delete from funcionario where id=?");

		statement.setObject(1, funcionario.getId());

		statement.execute();
		connection.close();
	}

	public List<Funcionario> findAll() throws Exception {
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from funcionario order by nome");

		ResultSet resultSet = statement.executeQuery();

		List<Funcionario> lista = new ArrayList<Funcionario>();

		while (resultSet.next()) {
			Funcionario funcionario = new Funcionario();

			funcionario.setId(UUID.fromString(resultSet.getString("id")));
			funcionario.setNome(resultSet.getString("nome"));
			funcionario.setCpf(resultSet.getString("cpf"));
			funcionario.setMatricula(resultSet.getString("matricula"));
			BigDecimal salario = new BigDecimal(resultSet.getString("salario"));
			funcionario.setSalario(salario);

			lista.add(funcionario);
		}
		connection.close();
		return lista;
	}

	public Funcionario findById(UUID id) throws Exception {
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from funcionario where id=?");

		statement.setObject(1, id);
		ResultSet resultSet = statement.executeQuery();

		Funcionario funcionario = null;

		if (resultSet.next()) {
			funcionario = new Funcionario();

			funcionario.setId(UUID.fromString(resultSet.getString("id")));
			funcionario.setNome(resultSet.getString("nome"));
			funcionario.setCpf(resultSet.getString("cpf"));
			funcionario.setMatricula(resultSet.getString("matricula"));
			BigDecimal salario = new BigDecimal(resultSet.getString("salario"));
			funcionario.setSalario(salario);
		}
		connection.close();
		return funcionario;
	}
}
