// funcao para mudar o texto do quadro de funcionalidades ao clicar nos botoes
const divBotoes = document.querySelector(
  "#inicio-funcionalidades-quadro-botoes"
);

divBotoes.addEventListener("click", () => {
  const textos = {
    1: {h3: "Gerenciador de Estoque", p: "Com o SaveIt, o controle do seu estoque se torna simples e estratégico. Acompanhe em tempo real o uso de cada insumo, receba alertas sobre prazos e mantenha a produção sempre equilibrada." },
    2: {h3: "Vitrine Virtual", p: "A vitrine virtual do SaveIt é um espaço onde as indústrias podem anunciar insumos que não serão utilizados, permitindo que restaurantes, padarias e outros estabelecimentos os comprem a preços acessíveis. Essa funcionalidade transforma o desperdício em oportunidade, conectando empresas e promovendo um ciclo mais sustentável dentro da cadeia alimentícia" },
    3: {h3: "Relatórios", p:  "Os relatórios mensais do SaveIt reúnem dados detalhados sobre entradas, saídas, consumo e desperdício de insumos. Com essas informações, as indústrias podem analisar seu desempenho, identificar falhas e otimizar processos, tornando o gerenciamento mais eficiente. Além de facilitar a tomada de decisões, os relatórios incentivam uma gestão inteligente e sustentável dos estoques."}
  };

  const h3 = document.getElementById("inicio-funcionalidades-quadro-texto-h3");
  const p = document.querySelector("#inicio-funcionalidades-quadro-texto-p")
  const botoes = [
    divBotoes.children[0],
    divBotoes.children[1],
    divBotoes.children[2],
  ];

  botoes.forEach((botao) => {
    botao.addEventListener("click", () => {
      const pos = botoes.indexOf(botao);
      h3.textContent = textos[pos + 1].h3;
      p.textContent = textos[pos + 1].p;
      botao.style.backgroundColor = "#405d49";
      botoes.forEach((botaoNaoClicado) => {
        if (botoes.indexOf(botaoNaoClicado) !== pos) {
          botaoNaoClicado.style.backgroundColor = "#2e2e2e";
        }
      });
    });
  });
});
