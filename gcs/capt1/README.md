# Capítulo 1: As dores do parto do software

Vamos imaginar que um cliente lhe pediu para reformar sua casa, refazendo a pintura e trocando o piso. Você tem várias pessoas em sua equipe, alguns especializados em alvenaria (paredes, reboco, piso), outros especializados em acabamento (pintura). Então, fica fácil distribuir o trabalho entre eles e acompanhar sua execução. Você coloca 2 pessoas para lixar as paredes e consertar buracos e infiltrações, coloca uma pessoa para retirar o piso antigo, colocar uma massa e assentar um piso novo, e coloca alguém para lixar e pintar as portas e as paredes. 

Mas e a construção ou "reforma" de um software? Há uma tendência de separar especialidades, como: **Front end** e **back end**, mas quantas pessoas exatamente você precisa? O que terá que alterar ou construir? O quanto isso vai custar? 

A produção de software é um trabalho intelectual, daí a dificuldade de compará-la a qualquer outro tipo de projeto.

Quer um exemplo? Você mandou aplicar uma nova demão de tinta em uma parede, mas nota que ficou uma mancha. Por que a mancha está lá? Não importa... Você pode lixar, aplicar massa e pintar por cima. Pronto! Mas e com software? Uma nova versão foi criada e um bug que já havia sido consertado, voltou a aparecer... Por que? Como? 

Imagine uma equipe com 4 ou 5 desenvolvedores, todos trabalhando no mesmo software. Alguns estão implementando novas funcionalidades (as vezes mais de uma nova funcionalidade), outros estão corrigindo bugs, e tudo será incorporado ao software principal, em algum momento futuro. Agora, imagine que um usuário reportou um bug em determinada versão do software... O que você faz? Você pode simplesmente sugerir que ele instale a versão mais recente?

Não é tão simples. 

## Itens de configuração

O que é um "Item de configuração" de um software? Ou melhor: Uma "história de usuário" seria um item de configuração? Um arquivo [**json**](https://json.org/json-pt.html) com parâmetros é um item de configuração? Um executável compilado é um item de configuração?

Alguns consideram que apenas o código-fonte deva ser considerado um item de configuração e, portanto versionado. 

Eu pesquisei e há muita confusão a respeito. Mesmo a Wikipedia em Português apresenta certa confusão. A [versão em inglês](https://en.wikipedia.org/wiki/Configuration_item) tem uma definição bem legal, que eu traduzi para vocês: 

> O termo Item de Configuração (IC) se refere à unidade fundamental estrutural de um sistema de gestão de configuração. Exemplos de ICs includem: Documentos de requisitos, software, modelos e planos.

Essa definição é a mais geral possível. Eu gosto de dar uma visão ortogonal do assunto. Para mim, o item de configuração é: 

> Qualquer componente fundamental de um projeto de software, ou seja: Aquele que não pode ser regerado.

Na pergunta que eu fiz no início deste tópico, eu propus alguns exemplos. Vamos ver quais seriam "Itens de Configuração" (ou IC):

- **História de usuário**: Não pode ser regerado e é um requisito do software. Sim, é IC;
- **Um arquivo json com parâmetros**: Igualmente, não pode ser regerado, então sim, é IC;
- **Um executável compilado**: Pode ser regerado (assimindo-se que você tenha o código-fonte), então não é um IC;

Mas, o que justifica manter "História de usuário" em um Sistema de Gestão de Configuração? Bom, "História de usuário" é um [**requisito**](https://pt.wikipedia.org/wiki/Requisito), portanto, um documento importante que orientou a geração de uma determinada versão do software. E também está sujeito à mudanças, que devem ser acompanhadas. Por exemplo, podemos saber qual era a versão de um requisito para determinada versão do software. Isso se chama [**rastreabilidade**](http://www-di.inf.puc-rio.br/~julio/rastreabilidade5.pdf). 

Quantas vezes não perdemos tempo porque um arquivo de parâmetros sumiu ou está desatualizado? Quanto tempo perdemos tentando entender como instalar um software para testar? Logo, arquivos de parâmetros e manuais são também ICs e precisam ser versionandos e controlados.

## Versão

O que é versão? É uma "fotografia" de um conjunto de artefatos em um determinado momento no tempo. Aquele conjunto de artefatos, sejam de software ou documentos, são relativos a uma determinada versão do software, liberada em determinado momento temporal.

Como são criadas as versões? Podem ser resultado de novas implementações ou de manutenções. Novas implementações (ou manutenção evolutiva), são resultado de um esforço mais amplo, como um [**projeto de software**](https://pt.wikipedia.org/wiki/Projeto_de_software). Um Projeto pode gerar a versão inicial ou versões futuras do software. Já a manutenção é um trabalho rotineiro, feito a partir da entrega de uma versão do software. Uma equipe analisa as [**Solicitações de Mudança**](https://pt.wikipedia.org/wiki/Gest%C3%A3o_de_mudan%C3%A7a_(engenharia)) e alterar partes do software para atendê-las, gerando novas versões. 

Qual é a diferença entre a versão gerada por um **projeto** e a versão gerada por uma **solicitação de mudança**? Basicamente, o tamanho. Geralmente, a versão resultante de um **projeto** possui muito mais alterações e novidades do que a versão gerada por uma **mudança**.

***Mas como fazemos isso? Como atribuir número de versão a um arquivo json ou a um documento de texto?***

Ai é que entra um Sistema de Controle de Configuração (ou Controle de versão), como o **Git** por exemplo. Uma versão no **Git** é um conjunto de artefatos relacionados a um **commit** (ou **push**, se for um repositório remoto). Cada **commit** tem um **id** e podemos recuperar todos os artefatos relacionados a ele. Mas o **Git** tem um recurso interessante, que é o **Tag**, ou seja um **rótulo** aplicado a TODOS os artefatos em um determinado **commit**. 

Você pode recuperar um objeto de um repositório utilizando o Tag: 

```
git checkout tags/<seu tag> <nome do arquivo>
```

O formato da identificação da versão fica totalmente a seu critério. Mas existem alguns padrões como o [**SEMVER**](https://semver.org/) ou **Semantic Versioning** que são bem interessantes: 

```
<major>.<minor>.<patch>
1.3.7
```
- **MAJOR**: Versão na qual foram feitas alterações incompatíveis com versões anteriores;
- **MINOR**: Versão na qual foram adicionadas funcionalidades, mas mantendo compatibilidade retroativa;
- **PATCH**: Versão na qual forma feitas correções totalmente compatíveis.

## Versões baseadas em tarefas

Tarefas ou **features** são unidades de trabalho feitas por desenvolvedores em artefatos do projeto. 

Software como o [**Jira**](https://www.atlassian.com/br/software/jira) são muito utilizados para controle de manutenção e evolução de software. E alguns desenvolvedores gostam de nomear a versão utilizando os números de registros nesses sistemas. Outros gostam de utilizar o **build number** (número da compilação) associado à versão do software. 

Estes esquemas servem para identificar conjuntos de artefatos, com certeza, mas será que devem fazer parte da versão final?

Vejamos... Um desenvolvedor pegou uma tarefa no Jira, cujo número é: 2055, outro pegou a tarefa: 2058. Ambos criam ramificações [**branches**](https://git-scm.com/docs/git-branch) no **Git** com os números de suas tarefas. Quanto integrarem ao projeto principal, qual será o número da versão do software? 2055, 2058?

## Gestão de release

O [**ITIL**](https://www.itil-docs.com/release-management-process-flow/), que é uma biblioteca de referência para gestão de configuração, prevê a gestão de releases (Release Management) justamente para controlar a geração de uma versão do software, determinando quais **features** (ou resultado de tarefa) comporão determinada versão do software, a ser entregue de acordo com o ciclo de vida ou **roadmap** do software.

Por exemplo, foi decidido que a versão 2.4.2, a ser gerada em 20 dias, será composta pelas tarefas: 2012, 2055, 2062. A tarefa 2058 ficará para o próximo **release**. Esta é uma decisão da gestão de release, baseada em diversos critérios. 

Assim, o número de versão de um software está ligada aos números de cada tarefa individual que gerou ou modificou artefatos. 

## Merge 

Essa palavra é temida por todo desenvolvedor! É o momento em que precisamos integrar diversas versões diferentes e gerar uma versão final. Isso é feito em vários momentos ao longo do trabalho e é um processo semi automático e complexo. A única maneira de não se perder é manter a **rastreabilidade** entre o código e os requisitos (ou "histórias de usuário").

Vejamos os nossos dois desenvolvedores, um com a tarefa 2055 e outro com a tarefa 2058. Eles podem trabalhar em ramos separados do repositório do projeto, mas, em determinado momento, suas alterações terão que ser incorporadas uma a outra e ao ramo principal no repositório. Coisas podem acontecer: Sem conflitos ou com conflitos. 

Um conflito ocorre quando alterações em uma versão do artefato provocam mudanças em outra versão do artefato. 

Um exemplo simples...

**Master**
```dotnetcli
mensagem = {"tipo":7}
```
**Branch: novo**
```
mensagem = {"tipo":7,"gerar":"true"}
```

Se tentarmos incorporar a ramificação "novo" no "Master" (ramo principal do repositório), haverá um conflito, pois a linha é diferente. Você precisará decidir qual deve prevalecer. 

Conflitos podem ocorrer sim, mas... Deveriam?

> Boas práticas de **Liderança técnica** podem mitigar a ocorrência de conflitos. 

Quando eu leciono e toco nesse assunto, muitas pessoas questionam essa minha afirmação. Vou explicar resumidamente aqui, mas depois falarei mais sobre o assunto. Conflitos ocorrem por algumas razões: 

1. Você alterou propositalmente alguma coisa no ramo onde quer inserir suas modificações;
2. Dois ou mais desenvolvedores, alteraram a mesma parte do código-fonte em tarefas diferentes e simultâneas;
3. Um desenvolvedor resolveu **refatorar** o código mesmo sem estar atribuída a ele essa tarefa.

Exceto a primeira razão, as outras duas podem ser mitigadas. Se dois (ou mais desenvolvedores) alterarão o mesmo trecho de código, não seria melhor refatorar essas tarefas? Talvez juntando em uma só ou dividindo de maneira diferente? Já a terceira é uma **praga** dos tempos modernos. Alguns entendem que a "propriedade coletiva" do código-fonte, uma das diretrizes dos **métodos ágeis**, lhes dá direito de alterá-lo sem consultar ou sem discutir com outros desenvolvedores. 


