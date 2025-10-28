// funcoes para mudar o SVG do header
// ao passar o mouse por cima e voltar ao normal ao tirar o mouse

window.addEventListener("load", () => {
  document.documentElement.style.overflow = "hidden hidden";
  setTimeout(() => {
    document.querySelector("iframe").remove();
    document.documentElement.style.overflow = "hidden scroll"
  }, 2000)
})

let html = window.location.pathname; // pegar o caminho do arquivo para verificacao
html = html.substring(html.lastIndexOf("/") + 1); // selecionar com substring para apenas pegar o nome

const svg = document.querySelector("#svg");
svg.addEventListener("mouseover", () => {
  svg.classList.add("transicaoSvg");
  svg.style.opacity = 0;

  let src;

  if (html === "index.html") {
    src = "landingPage/assets/images/logos/essentia_logo_branco.svg";
  } else {
    src = "../assets/images/logos/essentia_logo_branco.svg";
  }

  setTimeout(() => {
    svg.src = src;
    svg.style.opacity = 1;
  }, 125);
});

svg.addEventListener("mouseout", () => {
  svg.classList.add("transicaoSvg");
  svg.style.opacity = 0;

  let src;

  if (html === "index.html") {
    src = "landingPage/assets/images/logos/essentia_logo_verde.svg";
  } else {
    src = "../assets/images/logos/essentia_logo_verde.svg";
  }

  setTimeout(() => {
    svg.src = src;
    svg.style.opacity = 1;
  }, 125);
});

// funcao para mudar a cor do header ao rolar a página
// adiciona a classe "scrolled" quando a pagina eh scrollada
// e remove quando a pagina esta no topo

window.addEventListener("scroll", () => {
  const header = document.querySelector("header");
  const inicio = document.getElementById("inicio");
  const essentia = document.getElementById("Essentia");
  const saveit = document.getElementById("SaveIt");
  const contato = document.getElementById("Contato");

  if (window.scrollY > 190) {
    header.classList.add("scrolled");
    inicio.classList.add("mudarCor");
    essentia.classList.add("mudarCor");
    saveit.classList.add("mudarCor");
    contato.classList.add("mudarCor");
  } else {
    header.classList.remove("scrolled");
    inicio.classList.remove("mudarCor");
    essentia.classList.remove("mudarCor");
    saveit.classList.remove("mudarCor");
    contato.classList.remove("mudarCor");
  }
});
