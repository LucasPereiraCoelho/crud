package br.com.consultorio.dao.impl;

import br.com.consultorio.dao.ConnectionManager;
import br.com.consultorio.dao.PacienteDAO;
import br.com.consultorio.entidades.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAOImpl implements PacienteDAO {

    @Override
    public Paciente criar(Paciente paciente) throws Exception{
        
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultado = null;

        try {
            //instrução sql
            String sql = "INSERT INTO paciente (nome, cpf, nascimento) VALUES(?, ?, ?)";

            //abrir conexão com banco
            conexao = ConnectionManager.abrirConexao();

            //preparar o sql
            preparedStatement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            //Setar os valores para os colunas
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getCpf());
            preparedStatement.setDate(3, Date.valueOf(paciente.getNascimento()));

            //executar o comnando no banco
            preparedStatement.executeUpdate();

            //gerar o id do produto no banco
            resultado = preparedStatement.getGeneratedKeys();

            if (resultado.next()) {
                paciente.setId(resultado.getLong(1));
            }

            return paciente;
        } catch (Exception ex) {
            throw new Exception(ex);
        } finally {
            ConnectionManager.fecharConexao(conexao);
        }
        
    }

    @Override
    public Paciente alterar(Paciente paciente) {
        
        Connection conexao = null;
        PreparedStatement prepararSql = null;
        String sql = "UPDATE paciente SET nome = ?, cpf = ?, nascimento = ? WHERE id = ?";

        try {
            conexao = ConnectionManager.abrirConexao();
            prepararSql = conexao.prepareStatement(sql);
            prepararSql.setString(1, paciente.getNome());
            prepararSql.setString(2, paciente.getCpf());
            prepararSql.setDate(3, Date.valueOf(paciente.getNascimento()));
            prepararSql.setLong(4, paciente.getId());

            prepararSql.executeUpdate();

        } catch (Exception ex) {
            System.err.println("Erro ao alterar: " + ex.getMessage());
        } finally {
            ConnectionManager.fecharConexao(conexao);
        }
        return paciente;
        
    }

    @Override
    public Paciente pesquisarPorId(long id) {
        
        Paciente paciente = null;
        Connection conexao = null;
        PreparedStatement prepararSql = null;
        ResultSet resultado = null;
        String sql = "SELECT * FROM paciente WHERE id = ?";

        try {

            conexao = ConnectionManager.abrirConexao();
            prepararSql = conexao.prepareStatement(sql);
            prepararSql.setLong(1, id);
            resultado = prepararSql.executeQuery();

            if (resultado.next()) {
                paciente = new Paciente();
                paciente.setId(id);
                paciente.setNome(resultado.getString("nome"));
                paciente.setCpf(resultado.getString("cpf"));
                paciente.setNascimento(resultado.getDate("nascimento").toLocalDate());
            }

        } catch (Exception ex) {
            System.err.println("Erro ao pesquisar por ID: " + ex.getMessage());
        } finally {
            ConnectionManager.fecharConexao(conexao);
        }
        return paciente;
        
        
    }

    @Override
    public List<Paciente> pesquisarTodos() {
        
        List<Paciente> produtos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement prepararSql = null;
        ResultSet resultado = null;
        String sql = "SELECT * FROM paciente ORDER BY id ASC";

        try {
            conexao = ConnectionManager.abrirConexao();
            prepararSql = conexao.prepareStatement(sql);
            resultado = prepararSql.executeQuery();
            
            while(resultado.next()){
                Paciente paciente = new Paciente();
                paciente.setId(resultado.getLong("id"));
                paciente.setNome(resultado.getString("nome"));
                paciente.setCpf(resultado.getString("cpf"));
                paciente.setNascimento(resultado.getDate("nascimento").toLocalDate());
                produtos.add(paciente);
            }
        } catch (Exception ex) {
            System.err.println("Erro ao pesquisar todos: " + ex.getMessage());
        } finally {
            ConnectionManager.fecharConexao(conexao);
        }
        return produtos; 

    }

    @Override
    public void excluir(long id) {
        
        Connection conexao = null;
        PreparedStatement prepararSql = null;
        String sql = "DELETE FROM paciente WHERE id = ?";

        try {
            conexao = ConnectionManager.abrirConexao();
            prepararSql = conexao.prepareStatement(sql);
            prepararSql.setLong(1, id);

            prepararSql.executeUpdate();

        } catch (Exception ex) {
            System.err.println("Erro ao pesquisar por ID: " + ex.getMessage());
        } finally {
            ConnectionManager.fecharConexao(conexao);
        }
    
        
    }
    
}
