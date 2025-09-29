<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Login</title>

        <style>
            @import url("https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:ital,wght@0,200..800;1,200..800&display=swap");


            * {
                font-family: "Plus Jakarta Sans", sans-serif;
            }

            body {
                margin: 0;
                top: 0;
                bottom: 0;
                padding: 0;
                background-color: #f0ece1;
                overflow: hidden;
            }

            .voltar-inicio {
                text-decoration: none;
                position: absolute;
                top: 3rem;
                left: 5rem;
                font-size: 6rem;
                color: #2F2F2F;
            }

            div {
                display: flex;
                flex-direction: column;
                align-items: center;
                width: 800px;
                height: 800px;
                margin: 40px auto;
                background-color: #FFFAF0;
                border-radius: 20px;
                box-shadow: 8px 10px 10px rgba(0, 0, 0, 0.2);

                img {
                    width: 50px;
                    height: 50px;
                    padding-top: 70px;
                    margin-bottom: -100px;
                }

                h1 {
                    color: #2F2F2F;
                    font-size: 30px;
                    text-align: center;
                    font-weight: 600;
                    margin-top: 140px;
                    margin-bottom: -10px;
                }


                form {
                    display: flex;
                    gap: 10px;
                    flex-direction: column;
                    justify-content: start;
                    align-items: center;
                    width: 550px;
                    height: 450px;
                    margin-top: 20px;

                    input[placeholder] {
                        width: 95%;
                        height: 50px;
                        border-radius: 20px;
                        background-color: rgba(176, 186, 195, 0.4);
                        padding-left: 20px;
                        border: none;
                        outline: 0.3px solid #7C838A;
                        margin-bottom: 15px;

                        &::placeholder {
                            color: rgba(0, 0, 0, 0.5);
                            font-size: 17px;
                            font-weight: 450;
                        }

                        &:focus {
                            outline: 2px solid #6b8e4e;
                        }
                    }

                    input[type="submit"] {
                        background-color: #6b8e4e;
                        border: none;
                        width: 320px;
                        height: 50px;
                        border-radius: 10px;
                        margin-top: 30px;
                        color: #f0ece1;
                        font-weight: 500;
                        font-size: 20px;
                        margin-top: 10px;
                        cursor: pointer;
                        transition: .3s ease;

                        &:hover {
                            background-color: #5d8040;
                        }
                    }

                    label {
                        margin-right: auto;
                        color: #7C838A;
                        font-weight: 450;
                        font-size: 18px;
                    }
                }
            }

            #svg-topo {
                position: absolute;
                z-index: -1;
                width: 1000px;
                height: 1000px;
                top: -450px;
                left: -450px;
                transform: rotateX(180deg);

            }

            #svg-baixo {
                position: absolute;
                z-index: -1;
                width: 1000px;
                height: 1000px;
                bottom: -400px;
                right: -400px;
                transform: rotateX(180deg);
                object-fit: cover;

            }
        </style>
    </head>

    <body>
        <a href="index.html" class="voltar-inicio">&#8249</a>

        <div>
            <img src="landingPage/assets/images/logos/essentia_logo_verde.svg" alt="">
            <h1>Entre como administrador</h1>
            <p>Acesse o painel para controlar informações da sua indústria.</p>
            <form action="input">
                <label for="email">Email</label>
                <input type="email" placeholder="Digite seu email" id="inputEmail" />

                <label for="cpf">CPF</label>
                <input type="text" placeholder="Digite seu CPF" id="inputCpf" />

                <label for="senha">Senha</label>
                <input type="password" placeholder="Digite sua senha" id="inputSenha" />

                <input type="submit" value="Entrar" id="botaoEntrar" />
            </form>
        </div>

        <svg viewBox="0 0 200 200" xmlns="http://www.w3.org/2000/svg" id="svg-topo">
            <path fill="#6B8E4E"
                d="M22.3,-30.2C34.9,-26.7,55.2,-30.6,67.4,-24.7C79.6,-18.7,83.8,-3,83.3,13.1C82.7,29.3,77.4,45.9,65.4,52.8C53.4,59.7,34.7,57,20.4,54.2C6.1,51.4,-3.6,48.6,-14.3,46.4C-24.9,44.3,-36.3,42.8,-41.2,36.2C-46.2,29.6,-44.6,17.9,-45.9,6.8C-47.2,-4.3,-51.4,-14.8,-49,-23.3C-46.6,-31.8,-37.6,-38.2,-28.3,-43.1C-19.1,-48.1,-9.5,-51.7,-2.3,-48.1C4.9,-44.5,9.8,-33.6,22.3,-30.2Z"
                transform="translate(100 100)" />
        </svg>

        <svg viewBox="0 0 200 200" xmlns="http://www.w3.org/2000/svg" id="svg-baixo">
            <path fill="#6B8E4E"
                d="M22.3,-30.2C34.9,-26.7,55.2,-30.6,67.4,-24.7C79.6,-18.7,83.8,-3,83.3,13.1C82.7,29.3,77.4,45.9,65.4,52.8C53.4,59.7,34.7,57,20.4,54.2C6.1,51.4,-3.6,48.6,-14.3,46.4C-24.9,44.3,-36.3,42.8,-41.2,36.2C-46.2,29.6,-44.6,17.9,-45.9,6.8C-47.2,-4.3,-51.4,-14.8,-49,-23.3C-46.6,-31.8,-37.6,-38.2,-28.3,-43.1C-19.1,-48.1,-9.5,-51.7,-2.3,-48.1C4.9,-44.5,9.8,-33.6,22.3,-30.2Z"
                transform="translate(100 100)" />
        </svg>
        <script src="login.js"></script>
    </body>

    </html>