const estoAntes = document.getElementById("estoAntes");
const viAntes = document.getElementById("viAntes");
const relAntes = document.getElementById("relAntes");

const estoDepois = document.getElementById("estoDepois");
const viDepois = document.getElementById("viDepois");
const relDepois = document.getElementById("relDepois");

const tamnhoSection = document.getElementById("Saveit-4");
const tamanhoTela = window.innerWidth;

// alterna funcionalidades
function alternarFuncionalidade(
  antes,
  depois,
  outros1,
  outros2,
  outrosDepois1,
  outrosDepois2
) {
  if (outros1.classList.contains("invisivel")) {
    outros1.classList.toggle("invisivel");
    outrosDepois1.classList.toggle("invisivel");
    outros1.classList.toggle("outrosEstoClicado");
    outros2.classList.toggle("outrosEstoClicado");
  }
  if (outros2.classList.contains("invisivel")) {
    outros2.classList.toggle("invisivel");
    outrosDepois2.classList.toggle("invisivel");
    outros1.classList.toggle("outrosEstoClicado");
    outros2.classList.toggle("outrosEstoClicado");
  }

  antes.classList.toggle("invisivel");
  depois.classList.toggle("invisivel");

  // Ajustar altura da seção
  if (depois.classList.contains("invisivel")) {
    // Quando está fechando
    if (tamanhoTela != 800) {
      tamnhoSection.style.height = "60vh";
    } else {
      tamnhoSection.style.height = "80vh";
    }
  } else {
    // Quando está abrindo
    if (tamanhoTela > 800) {
      tamnhoSection.style.height = "100vh";
    } else if (tamanhoTela == 412) {
      tamnhoSection.style.height = "80vh";
    } else if (tamanhoTela == 800) {
      tamnhoSection.style.height = "120vh";
    }
  }
}

// eventos para sessao de funcionalidades
estoAntes.addEventListener("click", () => {
  alternarFuncionalidade(
    estoAntes,
    estoDepois,
    viAntes,
    relAntes,
    viDepois,
    relDepois
  );
});

estoDepois.addEventListener("click", () => {
  alternarFuncionalidade(
    estoAntes,
    estoDepois,
    viAntes,
    relAntes,
    viDepois,
    relDepois
  );
});

viAntes.addEventListener("click", () => {
  alternarFuncionalidade(
    viAntes,
    viDepois,
    estoAntes,
    relAntes,
    estoDepois,
    relDepois
  );
});

viDepois.addEventListener("click", () => {
  alternarFuncionalidade(
    viAntes,
    viDepois,
    estoAntes,
    relAntes,
    estoDepois,
    relDepois
  );
});

relAntes.addEventListener("click", () => {
  alternarFuncionalidade(
    relAntes,
    relDepois,
    estoAntes,
    viAntes,
    estoDepois,
    viDepois
  );
});

relDepois.addEventListener("click", () => {
  alternarFuncionalidade(
    relAntes,
    relDepois,
    estoAntes,
    viAntes,
    estoDepois,
    viDepois
  );
});

// FAQ
const divPerguntas = Array.from(document.querySelectorAll(".div-perguntas"));

divPerguntas.forEach((p) => {
  p.addEventListener("click", () => {
    const resposta = p.querySelector(".div-perguntas-resposta");
    const icones = p.querySelectorAll(".plus-minus");

    // Fecha todas as outras perguntas
    divPerguntas.forEach((outraPergunta) => {
      if (outraPergunta !== p) {
        const outraResposta = outraPergunta.querySelector(
          ".div-perguntas-resposta"
        );
        const outrosIcones = outraPergunta.querySelectorAll(".plus-minus");

        outraResposta.classList.add("invisivel");
        outrosIcones[0].classList.remove("invisivel");
        outrosIcones[1].classList.add("invisivel");
      }
    });

    resposta.classList.toggle("invisivel");

    icones[0].classList.toggle("invisivel");
    icones[1].classList.toggle("invisivel");
  });
});

document.documentElement.style.overflowX = "hidden";

window.addEventListener("load", function () {
  viAntes.classList.add("outrosEstoClicado");
  relAntes.classList.add("outrosEstoClicado");
});
