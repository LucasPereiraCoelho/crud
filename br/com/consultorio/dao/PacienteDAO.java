package br.com.consultorio.dao;

import br.com.consultorio.entidades.Paciente;
import java.util.List;

public interface PacienteDAO {
    
    public Paciente criar(Paciente paciente) throws Exception;
    
    public Paciente alterar(Paciente paciente);
    
    public Paciente pesquisarPorId(long id);
    
    public List<Paciente> pesquisarTodos();
    
    public void excluir(long id);
}
