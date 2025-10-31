const abrirCategoriaDiv = document.querySelector("#abrir-categorias");
const categoriasIndustriaDiv = document.querySelector("#categorias-industria");

abrirCategoriaDiv.addEventListener("click", () => {
    categoriasIndustriaDiv.style.display = "block";
})

document.querySelector("#fechar-categorias").addEventListener("click", () => {
    categoriasIndustriaDiv.style.display = "none";
})