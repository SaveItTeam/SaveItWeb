// funcoes para mudar o SVG do header
// ao passar o mouse por cima e voltar ao normal ao tirar o mouse
function svgBranco() {
  let svg = document.getElementById("svg");
  svg.classList.add("transicaoSvg");
  svg.style.opacity = 0;
  setTimeout(() => {
    svg.src = "src/main/webapp/landingPage/assets/images/logos/essentia_logo_branco.svg";
    svg.style.opacity = 1;
  }, 125);
}

function svgVerde() {
  let svg = document.getElementById("svg");
  svg.classList.add("transicaoSvg");
  svg.style.opacity = 0;
  setTimeout(() => {
    svg.src = "src/main/webapp/landingPage/assets/images/logos/essentia_logo_verde.svg";
    svg.style.opacity = 1;
  }, 125);
}

// funcao para mudar a cor do header ao rolar a página
// adiciona a classe "scrolled" quando a pagina eh scrollada
// e remove quando a pagina esta no topo
function mudarHeaderScroll() {
  const header = document.querySelector("header");

  if (window.scrollY > 190) {
    header.classList.add("scrolled");
  } else {
    header.classList.remove("scrolled");
  }
}

window.addEventListener("scroll", mudarHeaderScroll);

// funcao para mudar o texto do quadro de funcionalidades ao clicar nos botoes
function mudarTextoQuadro() {
  const textos = {
    1: "Texto Bacana 2",
    2: "Texto Bacana 3",
    3: "Texto Bacana 4"
  }

  
  let h3 = document.getElementById("inicio-funcionalidades-quadro-texto-h3");
  const botao1 = divBotoes.children[0];
  const botao2 = divBotoes.children[1];
  const botao3 = divBotoes.children[2];
  
  botao1.onclick = () => {
    h3.textContent = textos[1];
    botao1.style.backgroundColor = "#405d49";
    botao2.style.backgroundColor = "#2e2e2e";
    botao3.style.backgroundColor = "#2e2e2e";
  }

  botao2.onclick = () => {
    h3.textContent = textos[2];
    botao2.style.backgroundColor = "#405d49";
    botao1.style.backgroundColor = "#2e2e2e";
    botao3.style.backgroundColor = "#2e2e2e";
  }

  botao3.onclick = () => {
    h3.textContent = textos[3];
    botao3.style.backgroundColor = "#405d49";
    botao1.style.backgroundColor = "#2e2e2e";
    botao2.style.backgroundColor = "#2e2e2e";
  }
}

const divBotoes = document.getElementById("inicio-funcionalidades-quadro-botoes");
divBotoes.addEventListener("click", mudarTextoQuadro);
