package help;

import java.sql.Connection;

public class Conexao {

	private Connection conexao;

	public Conexao(Connection conexao) {
		this.conexao = conexao;
	}

	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

}