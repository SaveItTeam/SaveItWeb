const botaoEditar = document.querySelector("#botao-editar");
const botaoCancelar = document.querySelector("#botao-cancelar");
const botaoSalvar = document.querySelector("#botao-salvar");
const imgPreview = document.querySelector("#imgPreviewUser");

let valoresIniciais = [];
let editando = false;

// INICIALIZAÇÃO
document.addEventListener('DOMContentLoaded', function() {
    inicializarToggleSenha();
    inicializarPreviewImagem();
});

// BOTÃO EDITAR
botaoEditar.addEventListener("click", () => {
    const inputs = document.querySelectorAll("input");

    // alterna o estado definido inicialmente como false
    editando = !editando;

    // altera o fundo do botão conforme o estado
    botaoEditar.style.background = editando
        ? "rgba(176, 186, 195, 0.25)"
        : "#ffffff00";

    if (editando) {
        // salva o estado inicial
        valoresIniciais = [imgPreview.src];
        inputs.forEach((e) => {
            if (e.type !== "file" && e.id !== "inputSenhaAntiga" && e.id !== "inputSenhaNovaConfirmar") {
                valoresIniciais.push(e.value);
            }
        });

        // mostra os inputs de senha extra
        const senhasExtra = document.querySelector("#senhas-extra");
        if (senhasExtra) {
            senhasExtra.style.display = "flex";
            // Inicializa os botões de toggle senha quando os campos aparecem
            setTimeout(() => {
                inicializarToggleSenha();
            }, 0);
        }

        const labelInputFile = document.querySelector("label[for='inputFile']");
        if (labelInputFile) {
            labelInputFile.style.display = "flex";
        }

        // ativa inputs e seus respectivos estilos
        inputs.forEach((e) => {
            e.removeAttribute("disabled");
            getComputedStyle(document.documentElement).getPropertyValue(
                "--cor-fundo"
            ) === "#f0ece1"
                ? (e.style.background = "rgba(46, 46, 46, 0.1)")
                : (e.style.background = "rgba(240, 236, 225, 0.1)");
            e.style.paddingLeft = "0.5rem";
        });

        // Mostrar/ocultar botões
        botaoSalvar.style.display = "inline-block";
        botaoCancelar.style.display = "inline-block";
        botaoEditar.style.display = "none";

        // focus no primeiro input de texto
        const primeiroAtivo = [...inputs].find((e) => e.type !== "file");
        if (primeiroAtivo) {
            primeiroAtivo.focus();
            const len = primeiroAtivo.value.length;
            primeiroAtivo.setSelectionRange(len, len);
        }
    } else {
        cancelarEdicao();
    }
});

// CANCELAR EDIÇÃO
botaoCancelar.addEventListener("click", cancelarEdicao);

function cancelarEdicao() {
    if (!valoresIniciais.length) return;

    const inputs = document.querySelectorAll("input");
    imgPreview.src = valoresIniciais[0];

    // oculta os inputs de senha extra e limpa seus valores
    const senhasExtra = document.querySelector("#senhas-extra");
    if (senhasExtra) {
        senhasExtra.style.display = "none";
        const senhaAntiga = document.querySelector("#inputSenhaAntiga");
        const senhaNovaConfirmar = document.querySelector("#inputSenhaNovaConfirmar");
        if (senhaAntiga) {
            senhaAntiga.value = "";
            senhaAntiga.disabled = true;
            senhaAntiga.style.background = "transparent";
            senhaAntiga.style.paddingLeft = 0;
        }
        if (senhaNovaConfirmar) {
            senhaNovaConfirmar.value = "";
            senhaNovaConfirmar.disabled = true;
            senhaNovaConfirmar.style.background = "transparent";
            senhaNovaConfirmar.style.paddingLeft = 0;
        }
    }

    // restaura valores iniciais
    let i = 1;
    inputs.forEach((e) => {
        if (e.type !== "file") {
            e.value = valoresIniciais[i] || "";
            i++;
        }
        e.disabled = true;
        e.style.background = "transparent";
        e.style.paddingLeft = 0;
    });

    // Restaurar visibilidade dos botões
    botaoSalvar.style.display = "none";
    botaoCancelar.style.display = "none";
    botaoEditar.style.display = "inline-block";

    // Esconder label da imagem
    const labelInputFile = document.querySelector("label[for='inputFile']");
    if (labelInputFile) {
        labelInputFile.style.display = "none";
    }

    // Limpar input file
    const inputFile = document.querySelector("#inputFile");
    if (inputFile) {
        inputFile.value = "";
    }

    botaoEditar.style.background = "transparent";
    editando = false;
}

// FUNCIONALIDADE DE MOSTRAR/OCULTAR SENHA
function inicializarToggleSenha() {
    document.querySelectorAll(".toggle-password").forEach((button) => {
        // Remove listeners anteriores se existirem
        const newButton = button.cloneNode(true);
        button.parentNode.replaceChild(newButton, button);

        newButton.addEventListener("click", () => {
            const targetId = newButton.getAttribute("data-target");
            const input = document.querySelector(`#${targetId}`);
            const icon = newButton.querySelector("i");

            if (input) {
                if (input.type === "password") {
                    input.type = "text";
                    icon.classList.remove("ri-eye-line");
                    icon.classList.add("ri-eye-off-line");
                } else {
                    input.type = "password";
                    icon.classList.remove("ri-eye-off-line");
                    icon.classList.add("ri-eye-line");
                }
            }
        });
    });
}

// PREVIEW DA IMAGEM
function inicializarPreviewImagem() {
    const inputFile = document.querySelector("#inputFile");

    if (inputFile) {
        inputFile.addEventListener("change", function(e) {
            const file = e.target.files[0];
            if (file) {
                // Validar tamanho (5MB)
                if (file.size > 5 * 1024 * 1024) {
                    alert('A imagem deve ter no máximo 5MB');
                    this.value = '';
                    return;
                }

                // Validar tipo
                if (!file.type.startsWith('image/')) {
                    alert('Por favor, selecione apenas imagens');
                    this.value = '';
                    return;
                }

                const reader = new FileReader();
                reader.onload = function(e) {
                    imgPreview.src = e.target.result;
                }
                reader.readAsDataURL(file);
            }
        });
    }
}

// VALIDAÇÃO DO FORMULÁRIO
document.querySelector('form')?.addEventListener('submit', function(e) {
    if (!editando) {
        e.preventDefault();
        return;
    }

    // Verificar se há alterações
    const nome = document.querySelector('#inputNome').value;
    const email = document.querySelector('#inputEmail').value;
    const inputFile = document.querySelector('#inputFile');
    const temArquivo = inputFile.files.length > 0;
    const senhaAntiga = document.querySelector('#inputSenhaAntiga').value;
    const senhaNova = document.querySelector('#inputSenhaNovaConfirmar').value;

    const nomeAlterado = nome !== valoresIniciais[1];
    const emailAlterado = email !== valoresIniciais[2];
    const senhaPreenchida = senhaAntiga.trim() !== "" || senhaNova.trim() !== "";

    if (!nomeAlterado && !emailAlterado && !temArquivo && !senhaPreenchida) {
        e.preventDefault();
        alert('Nenhuma alteração foi feita');
        return;
    }

    // Verificar se preencheu campos de senha
    if ((senhaAntiga || senhaNova) && (!senhaAntiga || !senhaNova)) {
        e.preventDefault();
        alert('Para alterar a senha, preencha ambos os campos: Senha Antiga e Nova Senha');
        return;
    }

    // Mostrar loading
    const botaoSalvar = document.querySelector('#botao-salvar');
    if (botaoSalvar) {
        botaoSalvar.innerHTML = 'Salvando...';
        botaoSalvar.disabled = true;
    }
});

// Inicializar quando a página carregar
inicializarToggleSenha();
inicializarPreviewImagem();