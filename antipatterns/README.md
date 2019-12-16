![](../falandosobre_software.png)

# Papo sobre software, com quem entende!

(c) 2018 [**Cleuton Sampaio**](https://github.com/cleuton).

# Aqui há monstros (a influência dos antipatterns em um projeto de software)

![](./aqui-ha-monstros-pq.png)

Nos mapas antigos, da época das grandes navegações, algumas regiões eram marcadas com avisos: **Aqui, há monstros!** A ignorância e a demarcação de “território”, eram as principais motivações para tais avisos. Tá, e o que isso tem a ver com *antipatterns*? Na verdade, muita coisa. Os “antipatterns” podem bem serem encarados como os “monstros” dos mapas de antigamente, os quais, seja por ignorância ou demarcação de território, nós mantemos dentro de nosso código-fonte.

## Antipatterns

O que é um **antipattern**? Bem, você sabe o que é um **pattern**, não? 

Um [**design pattern** (padrão de projeto)](https://pt.wikipedia.org/wiki/Padr%C3%A3o_de_projeto_de_software) é uma solução reusável para um problema recorrente e  comum, em um contexto determinado, no projeto de um software.

O problema é que, da mesma forma que a matéria possui a antimatéria, o “pattern” possui o “antipattern”...

Um [**antipattern**](https://pt.wikipedia.org/wiki/Antipadr%C3%A3o) é um padrão que diz como ir de um **problema** até **outro pior**.

Na verdade, nós conhecemos os “antipatterns” com outros nomes, como: **gambiarra**, **marreta**, **bacalhau** e, mais modernamente, **solução de contorno**. São abordagens **ad-hoc**, ou seja, criadas para um fim específico, que são portadas para diversos problemas, como se fossem solucioná-los. 

Uma solução baseada em “antipatterns” pode até funcionar temporariamente, resolvendo um problema pontual, mas, certamente, trará consequências ruins para o ciclo de vida do software. Mais do que isto, acabará prejudicando a mesma pessoa que a implementou!

O fato preocupante é que muitos projetistas confundem **agilidade** com **rapidez**, acabando por institucionalizar antipatterns como soluções arquiteturais. 

## Como nascem os “antipatterns”?

Como toda boa ideia, os “antipatterns” nascem como soluções de problemas arquiteturais ou de projeto. Porém, existem alguns fatores que diferenciam um “antipattern” de uma boa solução, entre eles:
- **Hermetismo**: um “antipattern”, geralmente, nasce com um grupo de pessoas e não é “oxigenado” por ideias de outros, ficando fechado em seu próprio mundo;
- **Fundamentação**: normalmente, a justificativa ou motivação para uso de um “antipattern” carece de fundamentação coerente, flutuando em um mar de subjetividade;
- **Trade-off**: em arquitetura e projeto de software, um “trade-off” representa a consequência da adoção de determinada solução, ou seja, o que estamos trocando pelo uso daquela solução. Com “antipatterns” os “trade-offs” não são claramente listados e analisados;
- **Má interpretação de "agilidade"**: Infelizmente, como eu já mencionei, muita gente confunde "ágil" com **rápido**, abandonando as boas práticas da **Eng
enharia de Software** em prol de mecanismos subjetivos e heterodoxos.

Até mesmo boas soluções podem se transformar em “antipatterns”, devido a inabilidade da equipe em aplicá-la. Só para ilustrar, temos o ditado de *Robert Anthony*:


```
Se você encontrar uma boa solução, e ficar muito ligado a ela, a solução se tornará o seu próximo problema.
    
- Robert Anthony.
```

É fácil identificar quando um “antipattern” está sendo aplicado por uma equipe. Basta começar a questionar a motivação ou a justificativa para seu uso, e começaremos a receber vários argumentos carregados de emoção e subjetividade. 

Existe uma grande lista de “antipatterns” em um catálogo, que pode ser acessado em: 

http://c2.com/cgi/wiki?AntiPatternsCatalog

## Como evitar “antipatterns”? 

Não se trata apenas de evitar os “antipatterns” tradicionais, ou seja, aqueles que estão listados no catálogo, mas também de evitar que boas soluções se transformem em “antipatterns”. Alguns apressadinhos vão dizer logo: “é só usar o *bom senso!*”

Eu sou radicalmente contra “bom senso”. Por que? Para começar, “bom senso” é o que dizemos quando não sabemos o que devemos recomendar... Além disso, o que é “bom senso” para uns, pode ser uma porcaria para outros. E, finalmente, sempre que ouço a palavra “bom senso”, suspeito de “antipattern”.

Não existe uma fórmula para evitar “antipatterns”, mas eu diria que temos algumas boas medidas:
- Entenda o problema! Estude, simule, faça provas de conceito, pesquise, ou seja, procure entender a natureza do problema, seu contexto, suas variáveis e os requisitos das possíveis soluções;
- Pesquise! Veja o que os outros já fizeram para resolver o problema. Busque soluções candidatas (mais de uma), e analise suas características contra os requisitos do seu caso. Crie uma tabela de critérios e pontue as alternativas. Liste os prós e contras e analise os impactos da adoção de cada solução;
- Discuta! Converse com outros, apresente as alternativas, com as análises de critérios. Procure saber o que pensam, sem tentar impor;
- Documente! Deixe claro a justificativa e a motivação para escolha de determinada alternativa. Liste também os prós, contras e consequências, como aviso para quem vier a manter o sistema futuramente;

Entender o problema nos faz buscar uma solução eficaz, ao invés de cair em armadilhas, como “gambiarras” por exemplo. Para isto, temos que “sujar as mãos”, criar provas de conceito e documentar isso.

## Antipatterns pessoais

Muitas vezes, os “antipatterns” estão dentro de nós mesmos, logo, a nossa tendência sempre será adotar soluções “discutíveis”. E esses “antipatterns” pessoais podem ser motivados por coisas como: insatisfação, preguiça (de se atualizar) e teimosia. Os principais “antipatterns” pessoais que eu observo são:

- **ProgramaçãoBaseadaEmFé**: Acreditar que tudo vai se resolver por sinergia ou transporte passivo (osmose). Não investir em capacitação ou mesmo em entendimento do problema por pensar que o conjunto é maior que a soma de seus membros. É querer formar um time com “craques” e ficar com algo igual à seleção de 1982... A pessoa que sofre desse problema acredita que se usar só técnicas e frameworks bons, terá alguma coisa boa ao final.

- **SempreFizAssim / SempreFizemosAssim**: Aplicar sempre a mesma solução em problemas semelhantes. O problema é exatamente igual à citação que publiquei antes. Você fica tão apegado a certas soluções, que as repete para todos os casos semelhantes. Só tem dois problemas: 1 – você não sabe se a solução tem falhas e 2 – “semelhante” não significa “igual”.

- **JogarParaAtorcida**: É o cara que resolve problemas! Ele os resolve rapidamente, sem avaliar o impacto futuro de sua solução. O mais importante é o agora, pois o futuro “a Deus pertence”. Esse cara, geralmente, quer agradar ao Cliente e ao Chefe a qualquer custo, deixando a culpa dos problemas futuros para os coitados que derem manutenção ao software.

- **ProgramadorCientista**: O programador-cientista é aquele que sempre tira “coelhos da cartola”, dando soluções mirabolantes para os mais complexos problemas, e ninguém ousa questioná-lo. Ele tem um primo, o **Herói**, que é o programador-cientísta que adora um drama, que vive apregoando que não dorme há meses.

Normalmente, atrás de um “antipattern” pessoal bem sucedido, há um Chefe do tipo **"se mexer, estraga”**. 

## Antipatterns no café da manhã

Mesmo que você não queira, acaba acordando com “antipatterns” em sua cama, tomando café com eles e dando carona para o trabalho, afinal, “antipattern” é uma parte do que é ser humano. Mas, mesmo assim, temos que lutar contra eles ao invés de simplesmente colocar avisos: “aqui, há monstros!”. Vejamos comportamentos típicos de equipes, especialmente em ambientes de alta subjetividade, como os projetos **ágeis**:

- **Junkyard coding (Programação de ferro-velho)**: Tentativa de juntar partes de aplicações antigas para construir ou alterar um sistema novo. Normalmente, é causado por algumas atitudes:
    - **“Transplante” de código** – inserção de código de uma aplicação não modular em outra;
    - **Gambiarra** – uso excessivo e redundante de dependências, muitas vezes mal documentadas;
    - **Contaminação** – Transformação de código bom e bem estruturado através da inclusão de código que não segue os mesmos padrões.

Normalmente, “Junkyard coding” é praticado em associação com **JogarParaAtorcida**.

- **CutAndPaste programming**: É o reuso de código-fonte com um mínimo de esforço e critério. Não há cuidado com encapsulamento, segregação de interfaces e inversão de dependências, gerando um código baseado em retalhos, com alto acoplamento e baixa coesão. Ele é primo do **Junkyard Coding**.

- **ReiventingTheWheel** (Reinventando a roda): Criar soluções que já foram inventadas, resolvendo problemas com “antolhos”. É o “Xácomigo”, ou seja, fazer do seu jeito, sem importar se os outros já fizeram. 
Não há garantias de que você vai fazer algo melhor do que outras soluções, mas é certo que vai perder tempo implementando o que outros já fizeram (e testaram). Você aumenta o custo, o prazo e o risco do projeto, e sua solução pode não ser a melhor possível. Exemplos de soluções “ReinventingTheWheel”:
    - **Sincronização baseada em file system**: Você fica varrendo um diretório, recebendo pedidos e postando arquivos de resposta nele. Ela tem uma prima, que é a “Sincronização baseada em banco de dados”;
    - **Parsing” via substrings**: Nesta “solução”, você traduz arquivos-texto, como XML, por exemplo, através de análise de substrings (posição, tamanho e texto), normalmente com os valores numéricos “hardcoded” (números mágicos) e os textos também;
    - **Mamãe, fiz meu próprio servidor**: Criar servidores baseados em “socket programming”, para atender solicitações da aplicação. Solução temerária e insegura, que, além de criar problemas de escalabilidade, também cria brechas de segurança. Já existem vários mecanismos para criar servidores, além de vários protocolos padronizados. Logo, criar seu próprio servidor só tem um propósito: mostrar para a Mamãe.

- **Complexidade acidental**: Quando o código-fonte se torna complexo devido ao mal projeto das interfaces de um módulo, e essa complexidade adicional é exigida pela solução, e não pelo problema. É quando uma solução requer a criação de grande quantidade de “boilerplate code”, ou código-fonte sem utilidade, e sem variação. 

- **CargoCultProgramming ou VoodooChickenCoding** (Programação mística): Esse é um dos meus preferidos! E, por incrível que pareça, ele também gosta de mim, pois sempre aparece para me assombrar! Acontece devido a dois motivos:
    - Usarmos uma solução sem entendermos bem a natureza do problema;
    - Usarmos uma solução sem entendermos exatamente como ela funciona;

O **CargoCultProgramming** está mais relacionado ao uso de uma solução sem entender como ela funciona, e o **VoodooChickenCoding** está mais relacionado ao fato de não podermos explicar como o problema foi solucionado, por exemplo, a simples alteração da ordem de duas linhas de código-fonte resolveu o problema, só não sabemos o motivo.

- **Golden Hammer** (Martelo de ouro): Acreditar que uma solução vai resolver todos os problemas, sem  consequências ou impactos negativos, normalmente sem fundamentação para tal fé. É como vender algo que não entende bem, mas que acredita que resolverá o problema, da mesma forma que os “vendedores de elixir” faziam no século 18. 


## Conclusão

A [**Engenharia de Software**](https://www.computer.org/education/bodies-of-knowledge/software-engineering) veio para **botar ordem no galinheiro**, dando um chute no trazeiro do “bom senso” e do “herói. Aliada às práticas de gestão de projetos (PMI), e de processo (CMMI), pode produzir repetidos casos de projetos bem sucedidos. Porém, tristemente, ainda existem pessoas refratárias a elas. Para estas pessoas, eu digo que não devemos temer a inovação e a crítica, pois, quanto mais nos expusermos a elas, melhor nos tornaremos. 

A repetida prática de usar **antipatterns** é algo que deve ser combatido por todos, e não só pelos Gerentes. Deve começar por nós, Engenheiros de Software, ou seja, aqueles que estão na “frente de batalha” do dia a dia. 

E tudo começa com o questionamento. Se você tiver que resvalar para a subjetividade, então, provavelmente, um **monstro** está nascendo. Mesmo boas soluções podem se tornar “antipatterns”, caso seu uso não seja compreendido, justificado e documentado, com base em critérios bem pensados e aliados ao valor que se deseja agregar ao projeto.


