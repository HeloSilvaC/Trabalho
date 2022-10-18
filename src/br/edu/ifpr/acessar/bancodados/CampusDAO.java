package br.edu.ifpr.acessar.bancodados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifpr.conexao.Conexao;
import br.edu.ifpr.paranavai.turma.Campus;

public class CampusDAO {
	// inserção
	// atualização
	// remoção

	// executar sql, que retorna um resultset
	public ArrayList<Campus> listar() {
		ArrayList<Campus> listaDeCampus = new ArrayList<Campus>();
		String SQL = "SELECT * FROM matricula.tb_campus";

		try {
			PreparedStatement sqlPreparada = Conexao.getConexao().prepareStatement(SQL);
			ResultSet resultado = sqlPreparada.executeQuery();

			// percorrer o resultset e transformar cada registro para objeto
			while (resultado.next()) {
				Campus campus = transformarResultSetEmObjeto(resultado);
				// adicionar cada registo na listaDeCampus
				listaDeCampus.add(campus);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return listaDeCampus;
	}

	// listagem

	// transformação
	public Campus transformarResultSetEmObjeto(ResultSet resultSet) throws SQLException {

		Campus campus = new Campus();
		try {
			campus.setIdCampus(resultSet.getInt("id_campus"));
			campus.setNome(resultSet.getString("nome"));
			campus.setEndereco(resultSet.getString("endereco"));
			campus.setCidade(resultSet.getString("cidade"));

			return campus;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro ao transformar!");
		}
	}
}
