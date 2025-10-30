// funcao para mudar o texto do quadro de funcionalidades ao clicar nos botoes
const divBotoes = document.querySelector(
  "#inicio-funcionalidades-quadro-botoes"
);

divBotoes.addEventListener("click", () => {
  const textos = {
    1: "Gerenciador de Estoque",
    2: "Vitrine Virtual",
    3: "Relatórios",
  };

  const h3 = document.getElementById("inicio-funcionalidades-quadro-texto-h3");
  const botoes = [
    divBotoes.children[0],
    divBotoes.children[1],
    divBotoes.children[2],
  ];

  botoes.forEach((botao) => {
    botao.addEventListener("click", () => {
      const pos = botoes.indexOf(botao);
      h3.textContent = textos[pos + 1];
      botao.style.backgroundColor = "#405d49";
      botoes.forEach((botaoNaoClicado) => {
        if (botoes.indexOf(botaoNaoClicado) !== pos) {
          botaoNaoClicado.style.backgroundColor = "#2e2e2e";
        }
      });
    });
  });
});
