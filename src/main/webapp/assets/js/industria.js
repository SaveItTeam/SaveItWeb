// botaos e/do forms
const btnEditar = document.querySelector("#btnEditar");
const btnCancelar = document.querySelector("#btnCancelar");
const btnSalvar = document.querySelector("#btnSalvar");
const form = document.querySelector("form");

// obter inputs, select e radio buttons do forms
function obterElementosFormulario() {
    return {
        todosInputs: document.querySelectorAll("input[type='text'], input[type='tel']"),
        selectEstado: document.querySelector("#selectEstado"),
        inputImg: document.querySelector("#inputImg"),
        radiosCategorias: document.querySelectorAll("input[type='radio'][name='categoria-radio']")
    };
}

// variavel pra verificar se esta em edicao ou nao
let emModoEdicao = false;
let valoresOriginais = {};

// pega os valores originais
function salvarValoresOriginais() {
    const elementos = obterElementosFormulario();
    valoresOriginais = {}; // armazena valores originais
    
    elementos.todosInputs.forEach(input => {
        valoresOriginais[input.id] = input.value;
    });
    
    valoresOriginais[elementos.selectEstado.id] = elementos.selectEstado.value;


    elementos.radiosCategorias.forEach(radio => {
        if (radio.checked) {
            valoresOriginais.categoriaRadio = radio.value;
        }
    });
    // Se nenhum estava selecionado, salvar null
    if (!valoresOriginais.categoriaRadio) {
        valoresOriginais.categoriaRadio = null;
    }
    

    valoresOriginais[elementos.inputImg.id] = elementos.inputImg.files && elementos.inputImg.files.length > 0;
}

// restaura os valores originais no click do botao cancelar
function restaurarValoresOriginais() {
    const elementos = obterElementosFormulario();
    
    elementos.todosInputs.forEach(input => {
        if (valoresOriginais[input.id] !== undefined) {
            input.value = valoresOriginais[input.id];
        }
    });
    
    if (valoresOriginais[elementos.selectEstado.id] !== undefined) {
        elementos.selectEstado.value = valoresOriginais[elementos.selectEstado.id];
    }
    

    if (valoresOriginais.categoriaRadio !== undefined) {
        elementos.radiosCategorias.forEach(radio => {
            radio.checked = radio.value === valoresOriginais.categoriaRadio;
        });
    }

    if (elementos.inputImg.files && elementos.inputImg.files.length > 0) {
        elementos.inputImg.value = '';
    }
}

// habilita os campos
function habilitarCampos() {
    const elementos = obterElementosFormulario();
    
    elementos.todosInputs.forEach(input => {
        input.disabled = false;
    });
    elementos.selectEstado.disabled = false;
    elementos.inputImg.disabled = false;
    elementos.radiosCategorias.forEach(radio => {
        radio.disabled = false;
    }); 
    emModoEdicao = true;
    
    // foca no primeiro input
    const primeiroInput = document.querySelector("#inputNome");
    if (primeiroInput) {
        setTimeout(() => {
            primeiroInput.focus();
        }, 100);
    }
}

// desabilita os campos
function desabilitarCampos() {
    const elementos = obterElementosFormulario();
    
    elementos.todosInputs.forEach(input => {
        input.disabled = true;
    });
    elementos.selectEstado.disabled = true;
    elementos.inputImg.disabled = true;
    elementos.radiosCategorias.forEach(radio => {
        radio.disabled = true;
    });
    btnSalvar.disabled = true;
    emModoEdicao = false;
}

// evento de clique no botao editar
btnEditar.addEventListener("click", () => {
    if (emModoEdicao) {
        // sair do modo de edicao
        desabilitarCampos();
        btnEditar.style.background = "transparent"
    } else {
        // entra no modo de edicao
        salvarValoresOriginais();
        habilitarCampos();
        btnEditar.style.background = "rgba(176, 186, 195, 0.25)"
    }
});

// evento de clique no botao cancelar p restaurar os valores originais
btnCancelar.addEventListener("click", () => {
    if (emModoEdicao) {
        // Restaurar valores originais
        restaurarValoresOriginais();
        // Sair do modo de edição
        desabilitarCampos();
    }
});