package br.com.consultorio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    
    private static final String USUARIO_BD = "root";
    
    private static final String SENHA_BD = "Senac";
    
    private static final String NOME_BANCO = "consultorio";
    
    private static final String TIMEZONE = "?useTimezone=true&serverTimezone=America/Sao_Paulo&zeroDateTimeBehavior=convertToNull";
    
    private static final String STR_CON = "jdbc:mysql://localhost:3306/"+NOME_BANCO + TIMEZONE;
    
    
    
    public static Connection abrirConexao() throws Exception{
    
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(STR_CON, USUARIO_BD, SENHA_BD);
            System.out.println("Conectou ao banco!");
            return conexao;
        }catch (SQLException ex) {
            throw new Exception("Deu problema na conexão com banco: " + ex.getMessage());
        }catch(Exception ex){
            throw new Exception("Outro tipo de problema: " + ex.getMessage());
        }
    
    }
    
    
    public static void fecharConexao(Connection conexao){
    
        if(conexao != null){
            try {
                conexao.close();
                System.out.println("Fechou conexão");
            } catch (SQLException ex) {
                System.err.println("Deu problema ao fechar conexão: " + ex.getMessage());
            }
        
        
        }
    
    
    
    }
    
}
