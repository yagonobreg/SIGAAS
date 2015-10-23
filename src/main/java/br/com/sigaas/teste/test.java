package br.com.sigaas.teste;

import java.util.ArrayList;
import java.util.Date;

import modelo2.Requisitante;
import modelo2.RequisitanteDao;
import modelo2.Sala;
import modelo2.SalaDao;
import br.com.sigaas.dao.*;
import br.com.sigaas.gerenciadores.SimpleEntityManager;
import br.com.sigaas.modelo.Ambiente;
import br.com.sigaas.modelo.Aula;
import br.com.sigaas.modelo.InformacaoLogin;
import br.com.sigaas.modelo.Papel;
import br.com.sigaas.modelo.Usuario;
import br.com.sigaas.servicos.ServicoAmbiente;
import br.com.sigaas.servicos.ServicoAula;
import br.com.sigaas.servicos.ServicoEvento;
import br.com.sigaas.servicos.ServicoInformacaoLogin;
import br.com.sigaas.servicos.ServicoPapel;
import br.com.sigaas.servicos.ServicoSolicitacaoTroca;
import br.com.sigaas.servicos.ServicoUsuario;



public class test {

	public static void main(String[] args) {
		//testRequisitante();
		//testSala();
		testRequisicao();
		System.out.println("test");
	}
	
	public static void testRequisicao(){
		SimpleEntityManager simpleEntityManager = new SimpleEntityManager("sigaasPU");
		ServicoAmbiente servicoAmbiente = new ServicoAmbiente(simpleEntityManager);
		ServicoAula servicoAula = new ServicoAula(simpleEntityManager);
		ServicoEvento servicoEvento = new ServicoEvento(simpleEntityManager);
		ServicoInformacaoLogin servicoInformacaoLogin = new ServicoInformacaoLogin(simpleEntityManager);
		ServicoPapel servicoPapel = new ServicoPapel(simpleEntityManager);
		ServicoSolicitacaoTroca servicoSolicitacaoTroca = new ServicoSolicitacaoTroca(simpleEntityManager);
		ServicoUsuario servicoUsuario = new ServicoUsuario(simpleEntityManager);
		
		Papel papelAluno =servicoPapel.getPapelAluno();
		Usuario usuario = new Usuario();
		InformacaoLogin informacaoLogin = new InformacaoLogin();
		informacaoLogin.setSenha("asd2");
		informacaoLogin.setLogin("login2");
		usuario.setInformacaoLogin(informacaoLogin);
		usuario.setNome("nome 3");
		usuario.setEmail("mails23");
		usuario.addPapel(papelAluno);
		
		servicoUsuario.save(usuario);
		System.out.println(papelAluno.getNome());
		
		simpleEntityManager.close();
		
	}
	public static void testSala(){
		Sala sala = new Sala("sala 1",25);
		SalaDao dao = new SalaDao();
		dao.salvar(sala);
	}
	
	public static void testRequisitante(){
		Requisitante requisitante = new Requisitante("aaaa@mail.com", "aluno");
		RequisitanteDao dao = new RequisitanteDao();
		dao.salvar(requisitante);
	}
	
	
	

}
