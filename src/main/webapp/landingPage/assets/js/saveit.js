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


const plus1 = document.getElementById('plus1');
const plus2 = document.getElementById('plus2');
const plus3 = document.getElementById('plus3');
const plus4 = document.getElementById('plus4');

const minus1 = document.getElementById('minus1');
const minus2 = document.getElementById('minus2');
const minus3 = document.getElementById('minus3');
const minus4 = document.getElementById('minus4');

const pergunta1 = document.getElementById('pergunta1');
const pergunta2 = document.getElementById('pergunta2');
const pergunta3 = document.getElementById('pergunta3');
const pergunta4 = document.getElementById('pergunta4');

const p1 = document.getElementById('p1');
const p2 = document.getElementById('p2');
const p3 = document.getElementById('p3');
const p4 = document.getElementById('p4');

const tamanhoSecaoPerguntas = document.getElementById('Faq-perguntas');

p1.addEventListener("click", () => {
    if (!pergunta2.classList.contains("invisivel")) {
        pergunta2.classList.toggle("invisivel");
        plus2.classList.toggle("invisivel");
        minus2.classList.toggle("invisivel");
    }
    if (!pergunta3.classList.contains("invisivel")) {
        pergunta3.classList.toggle("invisivel");
        plus3.classList.toggle("invisivel");
        minus3.classList.toggle("invisivel");
    }
    if (!pergunta4.classList.contains("invisivel")) {
        pergunta4.classList.toggle("invisivel");
        plus4.classList.toggle("invisivel");
        minus4.classList.toggle("invisivel");
    }
    pergunta1.classList.toggle("invisivel");
    plus1.classList.toggle("invisivel");
    minus1.classList.toggle("invisivel");

})
p2.addEventListener("click", () => {
    if (!pergunta1.classList.contains("invisivel")) {
        pergunta1.classList.toggle("invisivel");
        plus1.classList.toggle("invisivel");
        minus1.classList.toggle("invisivel");
    }
    if (!pergunta3.classList.contains("invisivel")) {
        pergunta3.classList.toggle("invisivel");
        plus3.classList.toggle("invisivel");
        minus3.classList.toggle("invisivel");
    }
    if (!pergunta4.classList.contains("invisivel")) {
        pergunta4.classList.toggle("invisivel");
        plus4.classList.toggle("invisivel");
        minus4.classList.toggle("invisivel");
    }
    pergunta2.classList.toggle("invisivel");
    plus2.classList.toggle("invisivel");
    minus2.classList.toggle("invisivel");

})
p3.addEventListener("click", () => {
    if (!pergunta2.classList.contains("invisivel")) {
        pergunta2.classList.toggle("invisivel");
        plus2.classList.toggle("invisivel");
        minus2.classList.toggle("invisivel");
    }
    if (!pergunta1.classList.contains("invisivel")) {
        pergunta1.classList.toggle("invisivel");
        plus1.classList.toggle("invisivel");
        minus1.classList.toggle("invisivel");
    }
    if (!pergunta4.classList.contains("invisivel")) {
        pergunta4.classList.toggle("invisivel");
        plus4.classList.toggle("invisivel");
        minus4.classList.toggle("invisivel");
    }
    pergunta3.classList.toggle("invisivel");
    plus3.classList.toggle("invisivel");
    minus3.classList.toggle("invisivel");

})
p4.addEventListener("click", () => {
    if (!pergunta2.classList.contains("invisivel")) {
        pergunta2.classList.toggle("invisivel");
        plus2.classList.toggle("invisivel");
        minus2.classList.toggle("invisivel");
    }
    if (!pergunta3.classList.contains("invisivel")) {
        pergunta3.classList.toggle("invisivel");
        plus3.classList.toggle("invisivel");
        minus3.classList.toggle("invisivel");
    }
    if (!pergunta1.classList.contains("invisivel")) {
        pergunta1.classList.toggle("invisivel");
        plus1.classList.toggle("invisivel");
        minus1.classList.toggle("invisivel");
    }
    pergunta4.classList.toggle("invisivel");
    plus4.classList.toggle("invisivel");
    minus4.classList.toggle("invisivel");


})

document.documentElement.style.overflowX = "hidden"; 