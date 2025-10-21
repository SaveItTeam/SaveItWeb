<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login - Essentia</title>
    <link rel="stylesheet" href="landingPage/assets/css/login.css" />
      <link
              rel="shortcut icon"
              href="landingPage/assets/images/logos/favicon_essentia.png"
              type="image/x-icon"
      />
  </head>
  <body>
    

    <div>
      <img src="landingPage/assets/images/logos/essentia_logo_verde.svg" alt="">
      <h1>Entre como administrador</h1>
      <p>Acesse o painel para controlar informações da sua indústria.</p>

      <form action="logarAdmin" method="post">
        <label for="email">Email ou CPF</label>
        <input type="text" placeholder="Digite seu Email ou CPF" id="inputEmail" name="email" />

        <label for="senha">Senha</label>
        <input type="password" placeholder="Digite sua senha" id="inputSenha" name="senha" />

        <input type="submit" value="Entrar" id="botaoEntrar"/>
      </form>
      
    </div>

    <svg viewBox="0 0 200 200" xmlns="http://www.w3.org/2000/svg" id="svg-topo">
      <path fill="#6B8E4E" d="M22.3,-30.2C34.9,-26.7,55.2,-30.6,67.4,-24.7C79.6,-18.7,83.8,-3,83.3,13.1C82.7,29.3,77.4,45.9,65.4,52.8C53.4,59.7,34.7,57,20.4,54.2C6.1,51.4,-3.6,48.6,-14.3,46.4C-24.9,44.3,-36.3,42.8,-41.2,36.2C-46.2,29.6,-44.6,17.9,-45.9,6.8C-47.2,-4.3,-51.4,-14.8,-49,-23.3C-46.6,-31.8,-37.6,-38.2,-28.3,-43.1C-19.1,-48.1,-9.5,-51.7,-2.3,-48.1C4.9,-44.5,9.8,-33.6,22.3,-30.2Z" transform="translate(100 100)" />
    </svg>

    <svg viewBox="0 0 200 200" xmlns="http://www.w3.org/2000/svg" id="svg-baixo">
      <path fill="#6B8E4E" d="M22.3,-30.2C34.9,-26.7,55.2,-30.6,67.4,-24.7C79.6,-18.7,83.8,-3,83.3,13.1C82.7,29.3,77.4,45.9,65.4,52.8C53.4,59.7,34.7,57,20.4,54.2C6.1,51.4,-3.6,48.6,-14.3,46.4C-24.9,44.3,-36.3,42.8,-41.2,36.2C-46.2,29.6,-44.6,17.9,-45.9,6.8C-47.2,-4.3,-51.4,-14.8,-49,-23.3C-46.6,-31.8,-37.6,-38.2,-28.3,-43.1C-19.1,-48.1,-9.5,-51.7,-2.3,-48.1C4.9,-44.5,9.8,-33.6,22.3,-30.2Z" transform="translate(100 100)" />
    </svg>
    <script src="login.js"></script>
  </body>
</html>
