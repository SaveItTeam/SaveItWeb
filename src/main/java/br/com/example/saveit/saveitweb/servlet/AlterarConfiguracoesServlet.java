package br.com.example.saveit.saveitweb.servlet;

import br.com.example.saveit.saveitweb.hash.Hash;
import br.com.example.saveit.saveitweb.model.funcionario.FuncionarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

@WebServlet("/alterarConfiguracoesServlet")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5) // 5MB
public class AlterarConfiguracoesServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Object admin = sessao.getAttribute("admin");

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        if (admin != null) {
            try {
                String nomeAntigo = (String) sessao.getAttribute("nome");
                String emailAntigo = (String) sessao.getAttribute("email");
                String senhaAntiga = (String) sessao.getAttribute("senha");

                String nomeNovo = request.getParameter("inputNome");
                String emailNovo = request.getParameter("inputEmail");
                String senhaNova = request.getParameter("inputSenha");

                int id = (int) sessao.getAttribute("id_funcionario");

                // Processar upload da imagem
                Part filePart = request.getPart("arquivo");
                if (filePart != null && filePart.getSize() > 0) {
                    InputStream fileContent = filePart.getInputStream();
                    byte[] imagemBytes = IOUtils.toByteArray(fileContent);
                    String imagemBytesString = java.util.Base64.getEncoder().encodeToString(imagemBytes);

                    // Atualizar imagem no banco de dados (você precisará implementar este método)
                    funcionarioDAO.alterarImagem(imagemBytes, id);

                    // Atualizar imagem na sessão
                    sessao.setAttribute("imagemBYTE", imagemBytesString);
                    sessao.setAttribute("img_funcionario", "data:image/jpeg;base64," + imagemBytesString);
                }

                // Atualizar nome
                if (nomeNovo != null && !nomeNovo.equals(nomeAntigo)) {
                    funcionarioDAO.alterarNome(nomeNovo, id);
                    sessao.setAttribute("nome", nomeNovo);
                }

                // Atualizar email
                if (emailNovo != null && !emailNovo.equals(emailAntigo)) {
                    funcionarioDAO.alterarEmail(emailNovo, id);
                    sessao.setAttribute("email", emailNovo);
                }

                // Atualizar senha
                if (senhaNova != null && !senhaNova.isEmpty() && !senhaNova.equals(senhaAntiga)) {
                    Hash hash = new Hash();
                    String senhaNovaHash = hash.hashar(senhaNova);
                    funcionarioDAO.alterarSenha(senhaNovaHash, id);
                    sessao.setAttribute("senha", senhaNova);
                }

                request.getRequestDispatcher("/WEB-INF/view/admin/inicio.jsp").forward(request, response);

            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "Erro ao atualizar configurações: " + e.getMessage());
                request.getRequestDispatcher("/WEB-INF/view/admin/inicio.jsp").forward(request, response);
            }
        } else {
            try {
                request.setAttribute("error", "Credenciais inválidas");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}