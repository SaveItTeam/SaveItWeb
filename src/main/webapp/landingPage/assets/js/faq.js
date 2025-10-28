let input = document.querySelector("#input-usuario input"); // input dentro da div #input-usuario
let botaoSend = document.querySelector("#input-usuario button"); // botão dentro da div #input-usuario
let divMensagens = document.querySelector("#mensagens"); // div onde aparecem as mensagens

// adiciona uma nova mensagem ao chat
function appendMessage(texto, tipo) {
  let div = document.createElement("div");
  let pDiv = document.createElement("p");

  pDiv.textContent = texto;
  div.classList.add(tipo === "usuario" ? "mensagem-usuario" : "mensagem-vit");

  if (texto.length > 400) {
    div.style.width = "40%";
  }

  div.append(pDiv);

  let horario = document.createElement("small");
  horario.innerHTML = `<strong>${horarioAgora()}</strong>`;
  div.append(horario);

  divMensagens.append(div);
  divMensagens.scrollTop = divMensagens.scrollHeight;
}

// envia a mensagem do usuário
async function envio() {
  if (input.value.trim()) {
    appendMessage(input.value, "usuario");
    const texto = input.value;
    input.value = "";
    respostaVit(texto);
  }
}

// retorna o horário atual no formato HH:MM
function horarioAgora() {
  let horario = new Date();
  let h = String(horario.getHours()).padStart(2, "0");
  let m = String(horario.getMinutes()).padStart(2, "0");
  return `${h}:${m}`;
}

// faz a requisição para a API da IA
async function requisicaoVit(texto) {
  const url = "https://faq-ia.onrender.com/faq";
  try {
    const res = await fetch(url, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ question: texto }),
    });

    if (!res.ok) {
      throw new Error(`Erro na requisição: ${res.status} ${res.statusText}`);
    }

    const data = await res.json();
    return data;
  } catch (err) {
    console.error("Falha ao buscar dados:", err);
    return { answer: "Erro ao buscar resposta" };
  }
}

// mostra o carregamento e depois exibe a resposta
async function respostaVit(texto) {
  let div = mostrarCarregamento();
  const res = await requisicaoVit(texto);

  // Remove o carregamento antes da resposta
  div.remove();

  appendMessage(res.answer || "Resposta indisponível", "vit");
}

// exibe o carregamento da IA
function mostrarCarregamento() {
  let divCarregamento = document.createElement("div");
  for(let i = 0; i < 3; i++) {
    let divBolinha = document.createElement("div");
    divBolinha.classList.add("bolinha");
    divCarregamento.append(divBolinha)
  }
  divCarregamento.classList.add("carregamento");
  divMensagens.append(divCarregamento);
  divMensagens.scrollTop = divMensagens.scrollHeight;
  return divCarregamento;
}

// eventos de envio de mensagem
botaoSend.addEventListener("click", envio);
input.addEventListener("keydown", (e) => {
  if (e.key === "Enter" && !e.shiftKey) {
    e.preventDefault();
    envio();
  }
});
