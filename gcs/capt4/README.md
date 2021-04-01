# Gestão suave na nave de mudanças

Imagine o cenário: Uma equipe com 8 desenvolvedores, um projeto que está em "produção" e tem manutenções, além de novos desenvolvimentos. Alguns desenvolvedores trabalharão em bug fixes e outros em novas funcionalidades. Como gerenciar todas essas mudanças?

## Mudanças normais e out-of-band

Esse termo é "emprestado" da área de telecomunicações e, no nosso contexto, significa aquelas mudanças que não seguem o **workflow** normal de desenvolvimento. O normal é o **Cliente** discutir com o **Product Owner**, que conversará com o **Scrum master**, que tentará encaixar o pedido no **backlog** e por aí vai...

Mas tem coisas que não seguem esse fluxo, como correções de falhas, por exemplo. Também há mudanças derivadas de legislação ou regulamentação, que simplesmente têm que ser feitas urgentemente. 

## Release

O fim de um **Sprint** não significa que uma nova versão do software será implantada. Esta decisão é a **Gestão de Release** do software e depende de negociação posterior. Um comitê formado pelo Product Owner, o Cliente, O Scrum Master e o Líder técnico, se houver, decidirá quais mudanças entrarão no próximo release do software. 

É bom que esta decisão seja feita envolvendo o Product Owner e até o Cliente, e não todos os desenvolvedores. E deve haver um calendário, previamente acordado, com as datas de release (implantação em produção) do software. Este calendário não está relacionado aos Sprints, e deve ser previamente combinado inclusive com o pessoal de TI e **DevOps**. 

O que vai entrar em um release? Para começar, aquilo que foi testado e homologado pelo Cliente. O segundo critério pode ser negocial, ou seja, o que interessa mais ao Cliente na próxima versão. E também há o critério técnico, ou seja, quais alterações podem ser feitas em determinado release. Por exemplo, uma alteração que foi testada mas depende de outra, que não entrará agora, não pode ser liberada.

E é bom que os desenvolvedores saibam o que entrará em qual release. Um diagrama na parede pode ajudar bastante.

## Sprint backlog e manutenção corretiva

Ao montar seu Backlog de Sprint, é necessário considerar que uma parte da equipe deverá continuar a atender às manutenções corretivas e que elas nem sempre seguem o calendário do Scrum. Um erro comum é incluir manutenção corretiva junto com o backlog do Sprint, o que gera insatisfação por parte do Cliente. Além disso, é sempre bom analisar quais manutenções estão previstas e em andamento antes de agendar itens para serem feitos no Sprint. 

Um grande problema dos métodos ágeis é a estimativa por pontuação, usando **planning poker**, por exemplo. Os pontos são obtidos por **feeling** e acordados em consenso, mas não representam a duração da tarefa. Ao juntar várias tarefas baseados nessas estimativas, podermos gerar vários problemas de **Gestão de Configuração**. É melhor passar um "pente fino" nas tarefas evitando que dois (ou mais) desenvolvedores mexam simultaneamente nos mesmos artefatos. 

## Versão Stable

Todo software tem uma versão **stable**, que é a última versão implantada em produção. As únicas mudanças que vão direto para este **branch** são as correções ou exigências regulamentais. 

Quando um novo release do software é liberado, o **branch** considerado **stable** é atualizado. 

Em muitas equipes, o branch **master** é considerado como a versão **stable**. 

## Versão Development

É a versão que está sendo desenvolvida e será entregue no próximo release. Pode ser um branch padronizado, como: **development**. Eu não gosto disso. Eu prefiro criar um branch com o número da futura release. Por exemplo, vamos supor que o **master** esteja na versão 1.2.7 (e você deve criar um **Tag** nele para isso). Se o próximo release incluir apenas correções retrocompatíveis, o próximo release pode ser dev-1.2.8 ou dev-1.3. Assim, você mantem o histórico de versões e pode fazer bugfixes específicos para cada uma delas. 

Se um desenvolvedor vai trabalhar em um release, ele sabe qual branch de desenvolvimento deve baixar. No release, aquele branch é incorporado ao **master**, que ganha um novo **Tag** de versão. 

Esta estratégia permite o desenvolvimento de mais de uma versão simultaneamente. Por exemplo, alguns podem estar trabalhando na versão dev-1.2.8 e outros na dev-1.3.

## Feature branches

Cada desenvolvedor que for implementar uma história cria um novo branch para ela a partir do branch **developement** correspondente (dev-x.y.z). O nome deste branch pode ser um identificador da história, algo como um número **Jira** por exemplo. 

Uma **feature** pode ser uma evolução, algo que veio do **backlog**, ou uma correção (**bugfix**). 

O ideal é que um só desenvolvedor trabalhem naquela **feature**, ou seja, naquele **branch**. Mas, caso seja necessário, dois desenvolvedores podem trabalhar naquela **feature**, neste caso é preciso um grande controle para evitar problemas. 

É importante manter a **rastreabilidade** entre a história, a tarefa e a versão alvo, por isto é fundamental manter uma nomenclatura consistente nos branches de features. Um exemplo: 

```
<release>_<numero>
```
Por exemplo, vamos supor que você está implementando a tarefa **Jira** 1344, cuja versão alvo é a 1.2.8, então seu branch seria: 1.2.8_1344. 

Feature branches só podem ser utilizados para desenvolvimento e não para integração. Porém, há o caso em que é preciso integrar dois feature branches antes de integrá-los ao branch do release. Por exemplo, algo que só faça sentido em conjunto. Neste caso, você pode criar um branch com a versão alvo e o nome do módulo: **1.2.8_xpto**, onde **xpto** é o nome da funcionalidade que abrange as features separadas. 




