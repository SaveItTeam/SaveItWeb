package br.com.example.saveit.saveitweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

import static java.nio.file.Files.setAttribute;

@WebServlet("/UploadImageServlet")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Object admin = sessao.getAttribute("admin");

        byte[] imagemBytes = null;
        Part filePart = request.getPart("arquivo");
        if(filePart !=null){
            InputStream fileContent = filePart.getInputStream();
            imagemBytes = IOUtils.toByteArray(fileContent);
        }
        String imagemBytesString = java.util.Base64.getEncoder().encodeToString(imagemBytes);

        sessao.setAttribute("imagemBYTE",imagemBytesString);
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }
}
