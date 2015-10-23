package br.com.sigaas.teste;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.sigaas.dto.Turma;

public class LimparInformacao {

	public static void main(String[] args) {
		File file = new File("informacoes.html");
		Document doc = null;
		try {
			doc = Jsoup.parse(file, "ISO-8859-1");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements elementos = doc.select(".listagem tbody .destaque,.listagem tbody .linhaPar,.listagem tbody .linhaImpar");

		ArrayList<Turma> turmas = new ArrayList<Turma>();
		String codDisciplina = "";
		String nomeDisciplina = "";
		int index;
		String nivel = "";
		String buffer;
		String[] splitresult;
		Turma turma;
		for (Element elemento : elementos) {

			if(elemento.classNames().contains("destaque")){
				splitresult =  elemento.select("td").text().split(" - ");
				codDisciplina = splitresult[0];
				buffer = splitresult[1];
				index = buffer.indexOf("(");
				nomeDisciplina = buffer.substring(0, index-1);
				nivel = buffer.substring(index+1,buffer.length()-1);
			}
			else if (!elemento.classNames().contains("no-hover")) {
				turma = new Turma();
				turma.setCodDisciplina(codDisciplina); turma.setNomeDisclina(nomeDisciplina);
				turma.setNivel(nivel);
				splitresult = elemento.select("td").get(0).text().split("\\.");
				turma.setAno(Integer.valueOf(splitresult[0]));
				turma.setPeriodo(Integer.valueOf(splitresult[1]));
				turma.setNomeTurma(elemento.select("td").get(1).text());
				splitresult = elemento.select("td").get(2).text().split(" e ");
				for(String result:splitresult){
					turma.addDocente(result.substring(0, result.indexOf("(")-1));
				}
				turma.setTipo(elemento.select("td").get(3).text());
				turma.setModalidade(elemento.select("td").get(4).text());
				turma.setSituação(elemento.select("td").get(5).text());
				splitresult = elemento.select("td").get(6).text().split(" ");
				for(String horario:splitresult){
					turma.addHorario(horario);
				}
				
				turma.setLocal(elemento.select("td").get(7).text());
				buffer = elemento.select("td").get(8).text();
				splitresult = buffer.substring(0,buffer.indexOf("alunos")-1).split("\\/");
				turma.setQtdAlunosMatriculados(Integer.valueOf(splitresult[0]));
				turma.setCapacidadeTurma((splitresult.length == 1) ? 0 : Integer.valueOf(splitresult[1]));
				turmas.add(turma);
			}
			
		}
		for (Turma iterTurma:turmas){
			System.out.println(iterTurma);
		}

	}

}
