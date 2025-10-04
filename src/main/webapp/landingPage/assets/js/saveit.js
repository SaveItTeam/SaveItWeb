const estoAntes = document.getElementById('estoAntes');
const viAntes = document.getElementById('viAntes');
const relAntes = document.getElementById('relAntes');
const estoDepois = document.getElementById('estoDepois');
const viDepois = document.getElementById('viDepois');
const relDepois = document.getElementById('relDepois');

estoAntes.addEventListener("click", () => {
    estoAntes.classList.toggle("invisivel");
    estoDepois.classList.toggle("invisivel");
    viAntes.classList.toggle("outrosEstoClicado");
    viAntes.classList.toggle("viEstoClicado");
    relAntes.classList.toggle('outrosEstoClicado');
})
estoDepois.addEventListener("click", () =>{
    estoAntes.classList.toggle("invisivel");
    estoDepois.classList.toggle("invisivel");
    viAntes.classList.toggle("outrosEstoClicado");
    viAntes.classList.toggle("viEstoClicado");
    relAntes.classList.toggle('outrosEstoClicado');
})
viAntes.addEventListener("click", () =>{
    viAntes.classList.toggle("invisivel");
    viDepois.classList.toggle("invisivel");
    estoAntes.classList.toggle("outrosEstoClicado");
    relAntes.classList.toggle("outrosEstoClicado");
    relAntes.classList.toggle("relViClicado");

})
viDepois.addEventListener("click", () =>{
    viAntes.classList.toggle("invisivel");
    viDepois.classList.toggle("invisivel");
    estoAntes.classList.toggle("outrosEstoClicado");
    relAntes.classList.toggle("outrosEstoClicado");
    relAntes.classList.toggle("relViClicado");
})
relAntes.addEventListener("click", () =>{
    relAntes.classList.toggle("invisivel");
    relDepois.classList.toggle("invisivel");
    estoAntes.classList.toggle("outrosEstoClicado");
    viAntes.classList.toggle("outrosEstoClicado");
})

relDepois.addEventListener("click", () =>{
    relAntes.classList.toggle("invisivel");
    relDepois.classList.toggle("invisivel");
    estoAntes.classList.toggle("outrosEstoClicado");
    viAntes.classList.toggle("outrosEstoClicado");
})