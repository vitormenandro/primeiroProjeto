package com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.protobuf.TextFormat.ParseException;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int contador = 0;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionaContatoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet");
    }

    public void destroy() {
        super.destroy();
        log("Destruindo a servlet");
    }
    
    protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

		contador++; // a cada requisição a mesma variável é incrementada

        PrintWriter out = response.getWriter();

        // pegando os parâmetros do request
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String dataEmTexto = request.getParameter("dataNascimento");
        Calendar dataNascimento = null;

        // fazendo a conversão da data
        try {
            java.util.Date date = new SimpleDateFormat("dd/MM/yyyy")
                    .parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (java.text.ParseException e) {
            out.println("Erro de conversão da data");
            return; //para a execução do método
		}

        // monta um objeto contato - não estou usando DAO
        // Contato contato = new Contato();
        // contato.setNome(nome);
        // contato.setEndereco(endereco);
        // contato.setEmail(email);
        // contato.setDataNascimento(dataNascimento);

        // salva o contato
        // ContatoDao dao = new ContatoDao();
        // dao.adiciona(contato);

        // imprime o nome do contato que foi adicionado
        out.println("<html>");
        out.println("<body>");
        out.println("Contato " + nome +
                " adicionado com sucesso");
        out.println("Contador agora é: " + contador);
        out.println("</body>");
        out.println("</html>");
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
