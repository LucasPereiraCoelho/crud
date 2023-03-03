package br.com.consultorio.dao;

import br.com.consultorio.entidades.Endereco;
import java.util.List;

public interface EnderecoDAO {
    
    public void criar(Endereco endereco, long idPaciente) throws Exception;
    
    public Endereco alterar(Endereco endereco);
    
    public Endereco pesquisarPorId(long id);
    
    public List<Endereco> pesquisarTodosPacientes(long idPaciente);
    
    public void excluir(long id);
    
}
