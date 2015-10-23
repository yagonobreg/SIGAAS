package br.com.sigaas.teste;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URI;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HttpClientSigaa {

	public static void main(String[] args) throws Exception {
		BasicCookieStore cookieStore = new BasicCookieStore();
		CloseableHttpClient httpclient = HttpClients.custom()
				.setRedirectStrategy(new LaxRedirectStrategy())
				.setDefaultCookieStore(cookieStore).build();
		try {
			HttpUriRequest login = RequestBuilder.post()
					.setUri(new URI(
							"https://sigaa.ufrn.br/sigaa/logar.do?dispatch=logOn"))
					.setHeader("Connection", "keep-alive")
					.addParameter("width", "1920")
					.addParameter("height", "1080")
					.addParameter("urlRedirect", "")
					.addParameter("subsistemaRedirect", "")
					.addParameter("acao", "")
					.addParameter("acessibilidade", "")
					.addParameter("user.login", Usuario.usuario)
					.addParameter("user.senha", Usuario.senha).build();
			CloseableHttpResponse response = httpclient.execute(login);
			try {
				HttpEntity entity = response.getEntity();

				System.out.println("Login form get: "
						+ response.getStatusLine());
				String html = EntityUtils.toString(entity, "UTF-8");
				Writer writer = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream("new_login.html"), "utf-8"));
				writer.write(html);
				writer.close();
				EntityUtils.consume(entity);
				System.out.println("Post logon cookies:");
				List<Cookie> cookies = cookieStore.getCookies();
				if (cookies.isEmpty()) {
					System.out.println("None");
				} else {
					for (int i = 0; i < cookies.size(); i++) {
						System.out.println("- " + cookies.get(i).toString());
					}
				}
			} finally {
				response.close();
			}
			HttpUriRequest opcoes_informacoes = RequestBuilder.post()
					.setUri(new URI("https://sigaa.ufrn.br/sigaa/portais/discente/discente.jsf"))
					.setHeader("Connection", "keep-alive")
					.addParameter("menu:form_menu_discente","menu:form_menu_discente")
					.addParameter("id", "557193")
					.addParameter("jscook_action", "menu_form_menu_discente_j_id_jsp_1205428818_101_menu:A]#{ buscaTurmaBean.popularBuscaGeral }")
					.addParameter("javax.faces.ViewState","j_id1").build();
			 response = httpclient.execute(opcoes_informacoes);
			
			try {
				HttpEntity entity = response.getEntity();

				System.out.println("opcoes form get: "
						+ response.getStatusLine());
				String html = EntityUtils.toString(entity, "UTF-8");
				Writer writer = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream("opcoes.html"), "utf-8"));
				writer.write(html);
				writer.close();
				EntityUtils.consume(entity);
				System.out.println("opcoes cookies:");
				List<Cookie> cookies = cookieStore.getCookies();
				if (cookies.isEmpty()) {
					System.out.println("None");
				} else {
					for (int i = 0; i < cookies.size(); i++) {
						System.out.println("- " + cookies.get(i).toString());
					}
				}
			} finally {
				response.close();
			}
			
			HttpUriRequest informacoes = RequestBuilder.post()
					.setUri(new URI("https://sigaa.ufrn.br/sigaa/ensino/turma/busca_turma.jsf"))
					.setHeader("Connection", "keep-alive")
					.addParameter("form", "form")
					.addParameter("form:checkNivel", "on")
					.addParameter("form:selectNivelTurma", "G")
					.addParameter("form:checkAnoPeriodo", "on")
					.addParameter("form:inputAno", "2015")
					.addParameter("form:inputPeriodo", "2")
					.addParameter("form:checkUnidade", "on")
					.addParameter("form:selectUnidade", "235")
					.addParameter("form:inputCodDisciplina", "")
					.addParameter("form:inputCodTurma", "")
					.addParameter("form:inputLocal", "")
					.addParameter("form:inputHorario", "")
					.addParameter("form:inputNomeDisciplina", "")
					.addParameter("form:inputNomeDocente", "")
					.addParameter("form:selectCurso", "0")
					.addParameter("form:selectSituacaoTurma", "1")
					.addParameter("form:selectTipoTurma", "0")
					.addParameter("form:selectModalidade", "0")
					.addParameter("form:selectOpcaoOrdenacao", "1")
					.addParameter("turmasEAD", "false")
					.addParameter("form:buttonBuscar", "Buscar")
					.addParameter("javax.faces.ViewState","j_id2").build();
			 response = httpclient.execute(informacoes);
			
			try {
				HttpEntity entity = response.getEntity();

				System.out.println("informacoesform get: "
						+ response.getStatusLine());
				String html = EntityUtils.toString(entity, "UTF-8");
				Writer writer = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream("informacoes.html"), "utf-8"));
				writer.write(html);
				writer.close();
				Document doc = Jsoup.parse(html, "ISO-8859-1");
				Elements newsHeadlines = doc.select(".linhaPar,.linhaImpar");
				String[] collumns = { "Ano Período", "Turma", "Docente(s)", "Tipo",
						"Modalidade", "Situação", "Horário", "Local", "Mat./Cap." };
				for (Element elemento : newsHeadlines) {
					if ((!elemento.classNames().contains("no-hover"))
							&& (elemento.text().contains("Presencial"))) {
						System.out.println("============");
						for (int x = 0; x < collumns.length; x++) {
							System.out.println(collumns[x] + ": "
									+ elemento.select("td").get(x).text());
						}
					}
				}
				EntityUtils.consume(entity);
				System.out.println("informacoes cookies:");
				List<Cookie> cookies = cookieStore.getCookies();
				if (cookies.isEmpty()) {
					System.out.println("None");
				} else {
					for (int i = 0; i < cookies.size(); i++) {
						System.out.println("- " + cookies.get(i).toString());
					}
				}
			} finally {
				response.close();
			}

		} finally {
			httpclient.close();
		}
		
	}

}
