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
