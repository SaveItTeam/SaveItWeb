const estoAntes = document.getElementById('estoAntes');
const viAntes = document.getElementById('viAntes');
const relAntes = document.getElementById('relAntes');
const estoDepois = document.getElementById('estoDepois');
const viDepois = document.getElementById('viDepois');
const relDepois = document.getElementById('relDepois');
const tamnhoSection = document.getElementById('Saveit-4');
const tamanhoTela = window.innerWidth;
estoAntes.addEventListener("click", () => {
    if (viAntes.classList.contains("invisivel")) {
        viAntes.classList.toggle("invisivel");
        viDepois.classList.toggle("invisivel");
        estoAntes.classList.toggle("outrosEstoClicado");
        relAntes.classList.toggle("outrosEstoClicado");
        relAntes.classList.toggle("relViClicado");
    }
    if (relAntes.classList.contains("invisivel")) {
        relAntes.classList.toggle("invisivel");
        relDepois.classList.toggle("invisivel");
        estoAntes.classList.toggle("outrosEstoClicado");
        viAntes.classList.toggle("outrosEstoClicado");
    }

    estoAntes.classList.toggle("invisivel");
    estoDepois.classList.toggle("invisivel");
    viAntes.classList.toggle("outrosEstoClicado");
    viAntes.classList.toggle("viEstoClicado");
    relAntes.classList.toggle('outrosEstoClicado');
    if (tamanhoTela > 800) {
        tamnhoSection.style.height = "100vh";
    }
    else if (tamanhoTela == 412) {
        tamnhoSection.style.height = "80vh";
    }
    else if (tamanhoTela == 800) {
        tamnhoSection.style.height = "120vh";
    }

})
estoDepois.addEventListener("click", () => {
    if (viAntes.classList.contains("invisivel")) {
        viAntes.classList.toggle("invisivel");
        viDepois.classList.toggle("invisivel");
        estoAntes.classList.toggle("outrosEstoClicado");
        relAntes.classList.toggle("outrosEstoClicado");
        relAntes.classList.toggle("relViClicado");
    }
    if (relAntes.classList.contains("invisivel")) {
        relAntes.classList.toggle("invisivel");
        relDepois.classList.toggle("invisivel");
        estoAntes.classList.toggle("outrosEstoClicado");
        viAntes.classList.toggle("outrosEstoClicado");
    }
    estoAntes.classList.toggle("invisivel");
    estoDepois.classList.toggle("invisivel");
    viAntes.classList.toggle("outrosEstoClicado");
    viAntes.classList.toggle("viEstoClicado");
    relAntes.classList.toggle('outrosEstoClicado');
    if (tamanhoTela != 800) {
        tamnhoSection.style.height = "60vh";
    }
    else {
        tamnhoSection.style.height = "80vh";
    }
})
viAntes.addEventListener("click", () => {
    if (estoAntes.classList.contains("invisivel")) {
        estoAntes.classList.toggle("invisivel");
        estoDepois.classList.toggle("invisivel");
        viAntes.classList.toggle("outrosEstoClicado");
        viAntes.classList.toggle("viEstoClicado");
        relAntes.classList.toggle('outrosEstoClicado');
    }
    if (relAntes.classList.contains("invisivel")) {
        relAntes.classList.toggle("invisivel");
        relDepois.classList.toggle("invisivel");
        estoAntes.classList.toggle("outrosEstoClicado");
        viAntes.classList.toggle("outrosEstoClicado");
    }
    viAntes.classList.toggle("invisivel");
    viDepois.classList.toggle("invisivel");
    estoAntes.classList.toggle("outrosEstoClicado");
    relAntes.classList.toggle("outrosEstoClicado");
    relAntes.classList.toggle("relViClicado");
    if (tamanhoTela > 800) {
        tamnhoSection.style.height = "100vh";
    }
    else if (tamanhoTela == 412) {
        tamnhoSection.style.height = "80vh";
    }
    else if (tamanhoTela == 800) {
        tamnhoSection.style.height = "120vh";
    }

})
viDepois.addEventListener("click", () => {
    if (estoAntes.classList.contains("invisivel")) {
        estoAntes.classList.toggle("invisivel");
        estoDepois.classList.toggle("invisivel");
        viAntes.classList.toggle("outrosEstoClicado");
        viAntes.classList.toggle("viEstoClicado");
        relAntes.classList.toggle('outrosEstoClicado');
    }
    if (relAntes.classList.contains("invisivel")) {
        relAntes.classList.toggle("invisivel");
        relDepois.classList.toggle("invisivel");
        estoAntes.classList.toggle("outrosEstoClicado");
        viAntes.classList.toggle("outrosEstoClicado");
    }

    viAntes.classList.toggle("invisivel");
    viDepois.classList.toggle("invisivel");
    estoAntes.classList.toggle("outrosEstoClicado");
    relAntes.classList.toggle("outrosEstoClicado");
    relAntes.classList.toggle("relViClicado");
    if (tamanhoTela != 800) {
        tamnhoSection.style.height = "60vh";
    }
    else {
        tamnhoSection.style.height = "80vh";
    }

})
relAntes.addEventListener("click", () => {
    if (viAntes.classList.contains("invisivel")) {
        viAntes.classList.toggle("invisivel");
        viDepois.classList.toggle("invisivel");
        estoAntes.classList.toggle("outrosEstoClicado");
        relAntes.classList.toggle("outrosEstoClicado");
        relAntes.classList.toggle("relViClicado");
    }
    if (estoAntes.classList.contains("invisivel")) {
        estoAntes.classList.toggle("invisivel");
        estoDepois.classList.toggle("invisivel");
        viAntes.classList.toggle("outrosEstoClicado");
        viAntes.classList.toggle("viEstoClicado");
        relAntes.classList.toggle('outrosEstoClicado');
    }
    relAntes.classList.toggle("invisivel");
    relDepois.classList.toggle("invisivel");
    estoAntes.classList.toggle("outrosEstoClicado");
    viAntes.classList.toggle("outrosEstoClicado");
    if (tamanhoTela > 800) {
        tamnhoSection.style.height = "100vh";
    }
    else if (tamanhoTela == 412) {
        tamnhoSection.style.height = "80vh";
    }
    else if (tamanhoTela == 800) {
        tamnhoSection.style.height = "120vh";
    }
})

relDepois.addEventListener("click", () => {
    if (viAntes.classList.contains("invisivel")) {
        viAntes.classList.toggle("invisivel");
        viDepois.classList.toggle("invisivel");
        estoAntes.classList.toggle("outrosEstoClicado");
        relAntes.classList.toggle("outrosEstoClicado");
        relAntes.classList.toggle("relViClicado");
    }
    if (estoAntes.classList.contains("invisivel")) {
        estoAntes.classList.toggle("invisivel");
        estoDepois.classList.toggle("invisivel");
        viAntes.classList.toggle("outrosEstoClicado");
        viAntes.classList.toggle("viEstoClicado");
        relAntes.classList.toggle('outrosEstoClicado');
    }
    relAntes.classList.toggle("invisivel");
    relDepois.classList.toggle("invisivel");
    estoAntes.classList.toggle("outrosEstoClicado");
    viAntes.classList.toggle("outrosEstoClicado");
    if (tamanhoTela != 800) {
        tamnhoSection.style.height = "60vh";
    }
    else {
        tamnhoSection.style.height = "80vh";
    }
})

document.documentElement.style.overflowX = "hidden"; 