package br.com.example.saveit.saveitweb.servlet;

import br.com.example.saveit.saveitweb.hash.Hash;
import br.com.example.saveit.saveitweb.model.funcionario.FuncionarioDAO;
import br.com.example.saveit.saveitweb.model.imagem.ImagemDAO;
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
        ImagemDAO imagemDAO = new ImagemDAO();

        if (admin != null) {
            try {
                String nomeAntigo = (String) sessao.getAttribute("nome");
                String emailAntigo = (String) sessao.getAttribute("email");
                String senhaAntigaHash = (String) sessao.getAttribute("senha"); // Senha já está hasheada

                String nomeNovo = request.getParameter("inputNome");
                String emailNovo = request.getParameter("inputEmail");
                String senhaAntigaDigitada = request.getParameter("inputSenhaAntiga");
                String senhaNova = request.getParameter("inputSenhaNovaConfirmar");

                int id = (int) sessao.getAttribute("id_funcionario");

                // Verificar se há alterações
                boolean temAlteracoes = false;

                // Processar upload da imagem
                Part filePart = request.getPart("arquivo");
                if (filePart != null && filePart.getSize() > 0) {
                    InputStream fileContent = filePart.getInputStream();
                    byte[] imagemBytes = IOUtils.toByteArray(fileContent);

                    // Atualizar imagem no banco de dados
                    imagemDAO.salvarImagemFuncionario(imagemBytes, id);

                    // Atualizar imagem na sessão (convertendo para Base64 para exibição)
                    String imagemBytesString = java.util.Base64.getEncoder().encodeToString(imagemBytes);
                    // Atualizar ambas as chaves na sessão
                    sessao.setAttribute("img", "data:image/jpeg;base64," + imagemBytesString);
                    sessao.setAttribute("img_funcionario", "data:image/jpeg;base64," + imagemBytesString);
                    temAlteracoes = true;
                }

                // Atualizar nome
                if (nomeNovo != null && !nomeNovo.trim().isEmpty() && !nomeNovo.equals(nomeAntigo)) {
                    funcionarioDAO.alterarNome(nomeNovo, id);
                    sessao.setAttribute("nome", nomeNovo);
                    temAlteracoes = true;
                }

                // Atualizar email
                if (emailNovo != null && !emailNovo.trim().isEmpty() && !emailNovo.equals(emailAntigo)) {
                    funcionarioDAO.alterarEmail(emailNovo, id);
                    sessao.setAttribute("email", emailNovo);
                    temAlteracoes = true;
                }

                if (senhaNova != null && !senhaNova.trim().isEmpty() &&
                        senhaAntigaDigitada != null && !senhaAntigaDigitada.trim().isEmpty()) {

                    Hash hash = new Hash();

                    String senhaAntigaDigitadaHash = hash.hashar(senhaAntigaDigitada);
                    if (!senhaAntigaDigitadaHash.equals(senhaAntigaHash)) {
                        // Se for DIFERENTE → FAZ UPDATE
                        String senhaNovaHash = hash.hashar(senhaNova);
                        funcionarioDAO.alterarSenha(senhaNovaHash, id);
                        sessao.setAttribute("senha", senhaNovaHash);
                        temAlteracoes = true;
                    } else {
                        // Se for IGUAL → NADA ACONTECE (só continua sem alterar senha)
                        // Não faz nada, só não altera a senha
                    }
                }

                if (!temAlteracoes) {
                    request.setAttribute("error", "Nenhuma alteração foi feita");
                    request.getRequestDispatcher("/WEB-INF/view/admin/configuracoes.jsp").forward(request, response);
                    return;
                }

                request.getRequestDispatcher("/WEB-INF/view/admin/inicio.jsp").forward(request, response);

            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "Erro ao atualizar configurações: " + e.getMessage());
                request.getRequestDispatcher("/WEB-INF/view/admin/configuracoes.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}