package br.com.consultorio.entidades;

import br.com.consultorio.dao.EnderecoDAO;
import br.com.consultorio.dao.PacienteDAO;
import br.com.consultorio.dao.impl.EnderecoDAOImpl;
import br.com.consultorio.dao.impl.PacienteDAOImpl;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            PacienteDAO pacienteDAO = new PacienteDAOImpl();
            EnderecoDAO enderecoDAO = new EnderecoDAOImpl();

            //CRIAR         
            //PACIENTE           
            Paciente lucas = new Paciente();
            lucas.setNome("Lucas");
            lucas.setCpf("12345");
            lucas.setNascimento(LocalDate.of(2001, Month.SEPTEMBER, 26));
            criarPaciente(pacienteDAO, lucas);
            System.out.println("Paciente criado, seu id no banco é: " + lucas.getId());

            //ENDEREÇO
            Endereco enderecoLucas = new Endereco();

            enderecoLucas.setLogradouro("Rua ARLINDO ALCEBIADES DE ANDRADE");
            enderecoLucas.setCep("88130-335");
            enderecoLucas.setNumero(423);

            criarEndereco(enderecoDAO, enderecoLucas, lucas);
            System.out.println("Endereço criado, seu id no banco é: " + enderecoLucas.getId());
            System.out.println();

//============================================================================================            
            //PACIENTE
            Paciente jean = new Paciente();
            jean.setNome("JEAN");
            jean.setCpf("2424");
            jean.setNascimento(LocalDate.of(2001, Month.SEPTEMBER, 26));
            criarPaciente(pacienteDAO, jean);
            System.out.println("Paciente criado, seu id no banco é: " + jean.getId());

            //ENDERECO
            Endereco enderecoJean = new Endereco();

            enderecoJean.setLogradouro("Rua do JEAN");
            enderecoJean.setCep("88333-444");
            enderecoJean.setNumero(500);

            criarEndereco(enderecoDAO, enderecoJean, jean);
            System.out.println("Endereço criado, seu id no banco é: " + enderecoJean.getId());
            System.out.println();

//============================================================================================
            //PACIENTE
            Paciente leo = new Paciente();
            leo.setNome("LEO");
            leo.setCpf("150");
            leo.setNascimento(LocalDate.of(2001, Month.SEPTEMBER, 26));
            criarPaciente(pacienteDAO, leo);

            System.out.println("Paciente criado, seu id no banco é: " + leo.getId());

            //ENDERECO
            Endereco enderecoLeo = new Endereco();

            enderecoLeo.setLogradouro("Rua dos BOBO");
            enderecoLeo.setCep("88333-444");
            enderecoLeo.setNumero(500);

            criarEndereco(enderecoDAO, enderecoLeo, leo);
            System.out.println("Endereço criado, seu id no banco é: " + enderecoLeo.getId());
            System.out.println();

//============================================================================================   
            //PACIENTE
            Paciente rogerio = new Paciente();
            rogerio.setNome("ROGERIO");
            rogerio.setCpf("00");
            rogerio.setNascimento(LocalDate.of(2001, Month.SEPTEMBER, 26));
            criarPaciente(pacienteDAO, rogerio);

            System.out.println("Paciente criado, seu id no banco é: " + rogerio.getId());

            //ENDERECO
            Endereco enderecoRogerio = new Endereco();

            enderecoRogerio.setLogradouro("Rua do ROGERIO");
            enderecoRogerio.setCep("88333-444");
            enderecoRogerio.setNumero(500);

            criarEndereco(enderecoDAO, enderecoRogerio, rogerio);
            System.out.println("Endereço criado, seu id no banco é: " + enderecoRogerio.getId());
            System.out.println();

//============================================================================================            
            //PACIENTE
            Paciente nathan = new Paciente();
            nathan.setNome("NATHAN");
            nathan.setCpf("8989");
            nathan.setNascimento(LocalDate.of(2001, Month.SEPTEMBER, 26));
            criarPaciente(pacienteDAO, nathan);

            System.out.println("Paciente criado, seu id no banco é: " + nathan.getId());

            //ENDERECO
            Endereco enderecoNathan = new Endereco();

            enderecoNathan.setLogradouro("Rua do NATHAN");
            enderecoNathan.setCep("88333-444");
            enderecoNathan.setNumero(500);

            criarEndereco(enderecoDAO, enderecoNathan, nathan);
            System.out.println("Endereço criado, seu id no banco é: " + enderecoNathan.getId());
            System.out.println();

//============================================================================================ 
            //PESQUISAR PACIENTE POR ID
            pesquisarPacienteID(pacienteDAO, enderecoDAO, lucas);

//============================================================================================ 
            //ALTERAR PACIENTE
            alterarPaciente(pacienteDAO, jean);

            //============================================================================================ 
            //PESQUISAR TODOS PACIENTES
            pesquisarTodosPacientes(pacienteDAO, enderecoDAO);

            //============================================================================================ 
            //EXCLUIR PACIENTE
            excluirPaciente(pacienteDAO, enderecoDAO, nathan);

            //============================================================================================ 
            //PESQUISAR ENDEREÇO POR ID
            pesquisarEnderecoPorId(enderecoDAO, enderecoLucas);

            //============================================================================================ 
            //ALTERAR ENDEREÇO
            alterarEndereco(enderecoDAO, enderecoJean);

            //============================================================================================ 
            //PESQUISAR TODOS ENDERECOS
            pesquisarTodosEnderecos(enderecoDAO, lucas);

            //============================================================================================ 
            //EXCLUIR ENDEREÇO
            excluirEndereco(enderecoDAO, enderecoNathan);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    public static void criarPaciente(PacienteDAO pacienteDAO, Paciente paciente) {

        try {
            pacienteDAO.criar(paciente);
        } catch (Exception ex) {
            System.out.println("Erro ao criar paciente " + ex.getMessage());
        }

    }

    public static void pesquisarPacienteID(PacienteDAO pacienteDAO, EnderecoDAO enderecoDAO, Paciente paciente) {

        System.out.println(paciente.toString() + "  " + enderecoDAO.pesquisarTodosPacientes(paciente.getId()));

    }

    public static void alterarPaciente(PacienteDAO pacienteDAO, Paciente paciente) {

        if (paciente.getId() != 0) {
            paciente.setNome("JEANZAO O MONSTRO");
            paciente.setCpf("76767");
            paciente.setNascimento(LocalDate.of(2000, Month.MARCH, 20));

            pacienteDAO.alterar(paciente);

            System.out.println(paciente.toString());
        } else {
            System.out.println("Não existe paciente com esse ID");
        }

    }

    public static void pesquisarTodosPacientes(PacienteDAO pacienteDAO, EnderecoDAO endereco) {

        for (Paciente paciente : pacienteDAO.pesquisarTodos()) {

            System.out.println(paciente.toString() + "  " + endereco.pesquisarTodosPacientes(paciente.getId()));

        }

    }

    public static void excluirPaciente(PacienteDAO pacienteDAO, EnderecoDAO enderecoDAO, Paciente paciente) {

        List<Endereco> enderecosExcluir = enderecoDAO.pesquisarTodosPacientes(paciente.getId());
        if (paciente.getId() != 0) {

            for (Endereco endereco : enderecosExcluir) {
                enderecoDAO.excluir(endereco.getId());
            }
            pacienteDAO.excluir(paciente.getId());
            System.out.println("Paciente excluido");

        }

    }

    public static void criarEndereco(EnderecoDAO enderecoDAO, Endereco endereco, Paciente paciente) {

        try {
            enderecoDAO.criar(endereco, paciente.getId());
        } catch (Exception ex) {
            System.out.println("Erro ao criar endereço " + ex.getMessage());
        }

    }

    public static void pesquisarEnderecoPorId(EnderecoDAO enderecoDAO, Endereco endereco) {

        if (enderecoDAO.pesquisarPorId(endereco.getId()) != null) {
            endereco.toString();

        } else {

            System.out.println("ID de endereço não existe");
        }

    }

    public static void alterarEndereco(EnderecoDAO enderecoDAO, Endereco endereco) {

        if (endereco.getId() != 0) {
            endereco.setLogradouro("RUA DO JEAN BAMBAMBAM");
            endereco.setCep("3030");
            endereco.setNumero(12);

            enderecoDAO.alterar(endereco);

            System.out.println(endereco.toString());
        } else {
            System.out.println("Não existe esse endereço");
        }

    }

    public static void pesquisarTodosEnderecos(EnderecoDAO enderecoDAO, Paciente paciente) {

        for (Endereco endereco : enderecoDAO.pesquisarTodosPacientes(paciente.getId())) {

            System.out.println(endereco.toString());

        }

    }

    public static void excluirEndereco(EnderecoDAO enderecoDAO, Endereco endereco) {

        if (endereco.getId() != 0) {
            enderecoDAO.excluir(endereco.getId());
            System.out.println("Endereço excluido");

        } else {

            System.out.println("Endereço inexistente");
        }

    }

}
