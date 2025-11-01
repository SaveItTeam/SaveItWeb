<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Configurações - Essentia</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/global.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/configuracoes.css">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@4.5.0/fonts/remixicon.css" rel="stylesheet" />
</head>

<body>
    <main>
        <div class="header">
            <div class="modos">
                <button class="dark-mode">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
                        <path
                            d="M10.7625 0.812388C5.1375 1.42489 0.75 6.19989 0.75 11.9999C0.75 14.9836 1.93526 17.8451 4.04505 19.9548C6.15483 22.0646 9.01631 23.2499 12 23.2499C17.7875 23.2499 22.5625 18.8749 23.1875 13.2499C23.3 12.2624 22.2125 11.4749 21.2625 12.0624C20.2421 12.7137 19.0654 13.0788 17.8555 13.1194C16.6456 13.1601 15.447 12.8748 14.3852 12.2934C13.3234 11.712 12.4374 10.8559 11.8198 9.81472C11.2023 8.77351 10.876 7.58545 10.875 6.37489C10.875 5.04989 11.2625 3.79989 11.925 2.76239C12.4875 1.92489 11.875 0.724888 10.7625 0.812388Z"
                            fill="#B3B0C3" />
                    </svg>
                </button>
                <button class="light-mode">
                    <svg xmlns="http://www.w3.org/2000/svg" width="26" height="28" viewBox="0 0 26 28" fill="none">
                        <path
                            d="M12.9996 21.75C13.3311 21.75 13.6491 21.8817 13.8835 22.1161C14.1179 22.3505 14.2496 22.6685 14.2496 23V24.25C14.2496 24.5815 14.1179 24.8995 13.8835 25.1339C13.6491 25.3683 13.3311 25.5 12.9996 25.5C12.6681 25.5 12.3501 25.3683 12.1157 25.1339C11.8813 24.8995 11.7496 24.5815 11.7496 24.25V23C11.7496 22.6685 11.8813 22.3505 12.1157 22.1161C12.3501 21.8817 12.6681 21.75 12.9996 21.75ZM20.9546 19.1875L21.8383 20.0712C22.066 20.307 22.192 20.6228 22.1892 20.9505C22.1863 21.2782 22.0549 21.5918 21.8231 21.8235C21.5914 22.0553 21.2778 22.1867 20.9501 22.1896C20.6223 22.1924 20.3066 22.0664 20.0708 21.8387L19.1871 20.955C18.9594 20.7192 18.8334 20.4035 18.8363 20.0757C18.8391 19.748 18.9706 19.4345 19.2023 19.2027C19.4341 18.971 19.7476 18.8395 20.0753 18.8367C20.4031 18.8338 20.7188 18.9598 20.9546 19.1875ZM5.04459 19.1875C5.26954 18.9633 5.57138 18.8332 5.88882 18.8235C6.20626 18.8138 6.51548 18.9253 6.75369 19.1353C6.9919 19.3454 7.14122 19.6382 7.17134 19.9543C7.20146 20.2705 7.11011 20.5863 6.91584 20.8375L6.81209 20.955L5.92834 21.8387C5.70339 22.0629 5.40155 22.1931 5.08411 22.2028C4.76668 22.2125 4.45745 22.101 4.21924 21.8909C3.98104 21.6809 3.83171 21.3881 3.80159 21.0719C3.77148 20.7558 3.86283 20.44 4.05709 20.1887L4.16084 20.0712L5.04459 19.1875ZM12.9996 5.5C14.9887 5.5 16.8964 6.29018 18.3029 7.6967C19.7094 9.10322 20.4996 11.0109 20.4996 13C20.4996 14.9891 19.7094 16.8968 18.3029 18.3033C16.8964 19.7098 14.9887 20.5 12.9996 20.5C11.0105 20.5 9.10281 19.7098 7.69629 18.3033C6.28977 16.8968 5.49959 14.9891 5.49959 13C5.49959 11.0109 6.28977 9.10322 7.69629 7.6967C9.10281 6.29018 11.0105 5.5 12.9996 5.5Z"
                            fill="#FCC86A" />
                    </svg>
                </button>
            </div>
            <div class="administrador">
                <img src="<%=session.getAttribute("img")%>" alt="" />
                <div>
                    <p><%=session.getAttribute("nome")%></p>
                    <p>Admin</p>
                </div>
            </div>
        </div>

        <%@include file="../../../assets/sidebar.jsp"%>

        <section id="configuracoes">
            <div id="texto-principal">
                <div>
                    <h1>Configurações</h1>
                    <hr />
                </div>
            </div>

            <div id="configuracoes-principal">
                <form method="post" action="alterarConfiguracoesServlet">
                    <div id="imagem-container">
                        <img src="<%=session.getAttribute("img")%>" alt="Imagem do Usuário" id="imgPreviewUser">
                        <label for="inputFile"><i class="ri-camera-line"></i>
                            <input type="file" id="inputFile" name="inputFile" accept="image/*" disabled>
                        </label>
                    </div>

                    <label for="inputNome">Nome</label>
                    <input type="text" id="inputNome" name="inputNome" value="<%=session.getAttribute("nome")%>" disabled>

                    <label for="inputEmail">Email</label>
                    <input type="email" id="inputEmail" name="inputEmail" disabled value="<%=session.getAttribute("email")%>">

                    <div id="senhas-extra" style="display: none;">
                        <label for="inputSenhaAntiga">Senha Antiga</label>
                        <div class="password-container">
                            <input type="password" id="inputSenhaAntiga" name="inputSenhaAntiga" placeholder="Digite sua senha atual">
                            <button type="button" class="toggle-password" data-target="inputSenhaAntiga">
                                <i class="ri-eye-line"></i>
                            </button>
                        </div>

                        <label for="inputSenhaNovaConfirmar">Confirmar Nova Senha</label>
                        <div class="password-container">
                            <input type="password" id="inputSenhaNovaConfirmar" name="inputSenhaNovaConfirmar" placeholder="Confirme a nova senha">
                            <button type="button" class="toggle-password" data-target="inputSenhaNovaConfirmar">
                                <i class="ri-eye-line"></i>
                            </button>
                        </div>
                    </div>

                    <label for="inputSenha">Senha</label>
                    <input type="password" id="inputSenha" name="inputSenha" disabled>

                    <div class="botoes">
                        <button type="submit" id="botao-salvar">Salvar Alterações</button>
                        <button type="button" id="botao-cancelar">Cancelar</button>
                        <button type="button" id="botao-editar"><i class="ri-edit-box-line"></i></button>
                    </div>
                </form>

                <div id="contato">
                    <h2>Contato</h2>
                    <p><i class="ri-map-pin-fill"></i>Rua Irineu José Bordon, 355</p>
                    <p><i class="ri-phone-fill"></i>(11) 3623-6000</p>
                    <a href="mailto:essentia.saveit@gmail.com"><i class="ri-mail-fill"></i>essentia.saveit@gmail.com</a>
                </div>
            </div>
        </section>
    </main>

    <script src="${pageContext.request.contextPath}/assets/js/global.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/configuracoes.js"></script>
</body>
</html>