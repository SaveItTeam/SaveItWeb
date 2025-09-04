// funcao para mudar o texto do quadro de funcionalidades ao clicar nos botoes
const divBotoes = document.querySelector(
  "#inicio-funcionalidades-quadro-botoes"
);

divBotoes.addEventListener("click", () => {
  const textos = {
    1: "Texto Bacana 1",
    2: "Texto Bacana 2",
    3: "Texto Bacana 3",
  };

  let h3 = document.getElementById("inicio-funcionalidades-quadro-texto-h3");
  const botao1 = divBotoes.children[0];
  const botao2 = divBotoes.children[1];
  const botao3 = divBotoes.children[2];

  botao1.onclick = () => {
    h3.textContent = textos[1];
    botao1.style.backgroundColor = "#405d49";
    botao2.style.backgroundColor = "#2e2e2e";
    botao3.style.backgroundColor = "#2e2e2e";
  };

  botao2.onclick = () => {
    h3.textContent = textos[2];
    botao2.style.backgroundColor = "#405d49";
    botao1.style.backgroundColor = "#2e2e2e";
    botao3.style.backgroundColor = "#2e2e2e";
  };

  botao3.onclick = () => {
    h3.textContent = textos[3];
    botao3.style.backgroundColor = "#405d49";
    botao1.style.backgroundColor = "#2e2e2e";
    botao2.style.backgroundColor = "#2e2e2e";
  };
});
