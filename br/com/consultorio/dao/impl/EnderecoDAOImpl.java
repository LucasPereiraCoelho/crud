package br.com.consultorio.dao.impl;

import br.com.consultorio.dao.ConnectionManager;
import br.com.consultorio.dao.EnderecoDAO;
import br.com.consultorio.entidades.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAOImpl implements EnderecoDAO {

    @Override
    public void criar(Endereco endereco, long idPaciente) throws Exception {

        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultado = null;

        try {
            //instrução sql
            String sql = "INSERT INTO endereco (logradouro, cep, id_paciente, numero) VALUES(?, ?, ?, ?)";

            //abrir conexão com banco
            conexao = ConnectionManager.abrirConexao();

            //preparar o sql
            preparedStatement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            //Setar os valores para os colunas
            preparedStatement.setString(1, endereco.getLogradouro());
            preparedStatement.setString(2, endereco.getCep());
            preparedStatement.setLong(3, idPaciente);
            preparedStatement.setLong(4, endereco.getNumero());

            //executar o comnando no banco
            preparedStatement.executeUpdate();

            //gerar o id do produto no banco
            resultado = preparedStatement.getGeneratedKeys();

            if (resultado.next()) {
                endereco.setId(resultado.getLong(1));
            }

        } catch (Exception ex) {
            throw new Exception(ex);
        } finally {
            ConnectionManager.fecharConexao(conexao);
        }

    }

    @Override
    public Endereco alterar(Endereco endereco) {

        Connection conexao = null;
        PreparedStatement prepararSql = null;
        String sql = "UPDATE endereco SET logradouro = ?, cep = ?, numero = ? WHERE id = ?";

        try {
            conexao = ConnectionManager.abrirConexao();
            prepararSql = conexao.prepareStatement(sql);
            prepararSql.setString(1, endereco.getLogradouro());
            prepararSql.setString(2, endereco.getCep());
            prepararSql.setInt(3, endereco.getNumero());
            prepararSql.setLong(4, endereco.getId());

            prepararSql.executeUpdate();

        } catch (Exception ex) {
            System.err.println("Erro ao alterar: " + ex.getMessage());
        } finally {
            ConnectionManager.fecharConexao(conexao);
        }
        return endereco;

    }

    @Override
    public Endereco pesquisarPorId(long id) {

        Endereco endereco = null;
        Connection conexao = null;
        PreparedStatement prepararSql = null;
        ResultSet resultado = null;
        String sql = "SELECT * FROM endereco WHERE id = ?";

        try {

            conexao = ConnectionManager.abrirConexao();
            prepararSql = conexao.prepareStatement(sql);
            prepararSql.setLong(1, id);
            resultado = prepararSql.executeQuery();

            if (resultado.next()) {
                endereco = new Endereco();
                endereco.setId(id);
                endereco.setLogradouro(resultado.getString("logradouro"));
                endereco.setCep(resultado.getString("cep"));
                endereco.setNumero(resultado.getInt("numero"));
            }

        } catch (Exception ex) {
            System.err.println("Erro ao pesquisar por ID: " + ex.getMessage());
        } finally {
            ConnectionManager.fecharConexao(conexao);
        }
        return endereco;
    }

    @Override
    public List<Endereco> pesquisarTodosPacientes(long idPaciente) {

        List<Endereco> enderecos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement prepararSql = null;
        ResultSet resultado = null;
        String sql = "SELECT * FROM endereco WHERE id_paciente = ?";

        try {
            conexao = ConnectionManager.abrirConexao();
            prepararSql = conexao.prepareStatement(sql);
            prepararSql.setLong(1, idPaciente);
            resultado = prepararSql.executeQuery();

            while (resultado.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(resultado.getLong("id"));
                endereco.setLogradouro(resultado.getString("logradouro"));
                endereco.setCep(resultado.getString("cep"));
                endereco.setNumero(resultado.getInt("numero"));
                enderecos.add(endereco);
            }
        } catch (Exception ex) {
            System.err.println("Erro ao pesquisar todos: " + ex.getMessage());
        } finally {
            ConnectionManager.fecharConexao(conexao);
        }
        return enderecos;

    }

    @Override
    public void excluir(long id) {

        Connection conexao = null;
        PreparedStatement prepararSql = null;
        String sql = "DELETE FROM endereco WHERE id = ?";

        try {
            conexao = ConnectionManager.abrirConexao();
            prepararSql = conexao.prepareStatement(sql);
            prepararSql.setLong(1, id);

            prepararSql.executeUpdate();

        } catch (Exception ex) {
            System.err.println("Erro ao excluir ID: " + ex.getMessage());
        } finally {
            ConnectionManager.fecharConexao(conexao);
        }

    }

}
