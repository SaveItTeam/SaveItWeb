<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="logar.html" method="post">
    <label for="nome">Nome:</label>
    <input name="nome" type="text" /><br/>

    <label for="cpf">CPF:</label>
    <input name="cpf" type="text" /><br/>

    <label for="rg">RG:</label>
    <input name="rg" type="text" /><br/>

    <label for="sexo">Sexo:</label>
    <input name="sexo" type="text" maxlength="1" /><br/>

    <label for="dt_nascimento">Data de Nascimento:</label>
    <input name="dt_nascimento" type="date" /><br/>

    <label for="email">Email:</label>
    <input name="email" type="email" /><br/>

    <label for="senha">Senha:</label>
    <input name="senha" type="password" /><br/>

    <label for="cargo">Cargo:</label>
    <input name="cargo" type="text" /><br/>

    <label for="telefone">Telefone:</label>
    <input name="telefone" type="text" /><br/>

    <label for="experiencia">Experiência:</label>
    <input name="experiencia" type="text" /><br/>

    <label for="id_empresa">ID Empresa:</label>
    <input name="id_empresa" type="number" /><br/>

    <label for="id_industria">ID Indústria:</label>
    <input name="id_industria" type="number" /><br/>

    <label for="id_admin">ID Admin:</label>
    <input name="id_admin" type="number" /><br/>

    <input type="submit" value="Registrar" />
</form>
<br>
<a href="logar.html">Já tem cadastro?</a>

</body>
</html>