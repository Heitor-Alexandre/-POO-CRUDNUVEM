package Uniceplac_Produto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Produto {

	public static void main(String[] args) {
		
		//CONEXÃO LOCAL
		String url = "jdbc:mysql://root:QMxqIliRLTdJODrznnSgLjvflvqIDYsv@sakura.proxy.rlwy.net:35098/railway";
		String usuariobanco = "root";
		String bancosenha = "QMxqIliRLTdJODrznnSgLjvflvqIDYsv";
		
		//CONEXÃO NO CÉU
		Scanner sc = new Scanner(System.in);
		
	try {
		
	Connection conexao = DriverManager.getConnection(url, usuariobanco, bancosenha);
	
	int opcao = -1;
		while(opcao != 0) {
			System.out.println("1 - Inserir | 2 - Listar | 3- Atualizar | 4- Deletar | 0 - Sair");
			opcao = sc.nextInt();
			
		switch(opcao) {
		case 1:
			System.out.println("Código do produto: ");
			int codigo = sc.nextInt();
			
			System.out.println("Nome do produto: ");
			String nome = sc.next();
			
			System.out.println("Preço do produto: ");
			float preco = sc.nextFloat();
		 
			String sql = "INSERT INTO PRODUTO(CODIGO, NOME, PRECO) VALUES(?,?,?)";
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigo);
			stmt.setString(2, nome);
			stmt.setFloat(3, preco);
			stmt.executeUpdate();
			System.out.println("Inserido com sucesso");
			
			
		case 2:
			default:
				System.out.println("Opção inválida");
		
		case 3:
			System.out.println("Código do produto para atualizar: ");
			int codAtualizar = sc.nextInt();
			System.out.println("Novo nome do produto: ");
			String novoNome = sc.next();
			System.out.println("Novo preço do produto: ");
			float novoPreco = sc.nextFloat();

			String sqlUpdate = "UPDATE PRODUTO SET NOME = ?, PRECO = ? WHERE CODIGO = ?";
			PreparedStatement stmtUpdate = conexao.prepareStatement(sqlUpdate);
			stmtUpdate.setString(1, novoNome);
			stmtUpdate.setFloat(2, novoPreco);
			stmtUpdate.setInt(3, codAtualizar);
			stmtUpdate.executeUpdate();
			System.out.println("Atualizado com sucesso!");
			break;

		case 4:
			System.out.println("Código do produto para deletar: ");
			int codDeletar = sc.nextInt();

			String sqlDelete = "DELETE FROM PRODUTO WHERE CODIGO = ?";
			PreparedStatement stmtDelete = conexao.prepareStatement(sqlDelete);
			stmtDelete.setInt(1, codDeletar);
			stmtDelete.executeUpdate();
			System.out.println("Deletado com sucesso!");
			break;
		
			
			
			
			
			
			
		}
		}
	
	}catch(Exception e){
		System.out.println("Erro de cadastro"+e.getMessage());
	}
}

}