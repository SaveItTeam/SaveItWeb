const estoAntes = document.getElementById('estoAntes');
const viAntes = document.getElementById('viAntes');
const relAntes = document.getElementById('relAntes');
const estoDepois = document.getElementById('estoDepois');
const viDepois = document.getElementById('viDepois');
const relDepois = document.getElementById('relDepois');
const tamnhoSection = document.getElementById('Saveit-4');

estoAntes.addEventListener("click", () => {
    if(viAntes.classList.contains("invisivel")){
        viAntes.classList.toggle("invisivel");
        viDepois.classList.toggle("invisivel");
        estoAntes.classList.toggle("outrosEstoClicado");
        relAntes.classList.toggle("outrosEstoClicado");
        relAntes.classList.toggle("relViClicado");
    }
    if(relAntes.classList.contains("invisivel")){
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
    tamnhoSection.style.height = "100vh";

})
estoDepois.addEventListener("click", () =>{
    if(viAntes.classList.contains("invisivel")){
        viAntes.classList.toggle("invisivel");
        viDepois.classList.toggle("invisivel");
        estoAntes.classList.toggle("outrosEstoClicado");
        relAntes.classList.toggle("outrosEstoClicado");
        relAntes.classList.toggle("relViClicado");
    }
    if(relAntes.classList.contains("invisivel")){
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
    tamnhoSection.style.height = "60vh";

})
viAntes.addEventListener("click", () =>{
    if(estoAntes.classList.contains("invisivel")){
        estoAntes.classList.toggle("invisivel");
        estoDepois.classList.toggle("invisivel");
        viAntes.classList.toggle("outrosEstoClicado");
        viAntes.classList.toggle("viEstoClicado");
        relAntes.classList.toggle('outrosEstoClicado');
    }
    if(relAntes.classList.contains("invisivel")){
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
    tamnhoSection.style.height = "100vh";


})
viDepois.addEventListener("click", () =>{
    if(estoAntes.classList.contains("invisivel")){
        estoAntes.classList.toggle("invisivel");
        estoDepois.classList.toggle("invisivel");
        viAntes.classList.toggle("outrosEstoClicado");
        viAntes.classList.toggle("viEstoClicado");
        relAntes.classList.toggle('outrosEstoClicado');
    }
    if(relAntes.classList.contains("invisivel")){
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
    tamnhoSection.style.height = "60vh";

})
relAntes.addEventListener("click", () =>{
    if(viAntes.classList.contains("invisivel")){
        viAntes.classList.toggle("invisivel");
        viDepois.classList.toggle("invisivel");
        estoAntes.classList.toggle("outrosEstoClicado");
        relAntes.classList.toggle("outrosEstoClicado");
        relAntes.classList.toggle("relViClicado");
    }
    if(estoAntes.classList.contains("invisivel")){
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
    tamnhoSection.style.height = "100vh";

})

relDepois.addEventListener("click", () =>{
    if(viAntes.classList.contains("invisivel")){
        viAntes.classList.toggle("invisivel");
        viDepois.classList.toggle("invisivel");
        estoAntes.classList.toggle("outrosEstoClicado");
        relAntes.classList.toggle("outrosEstoClicado");
        relAntes.classList.toggle("relViClicado");
    }
    if(estoAntes.classList.contains("invisivel")){
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
    tamnhoSection.style.height = "60vh";
})