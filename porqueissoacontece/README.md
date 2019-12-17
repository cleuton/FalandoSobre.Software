![](../falandosobre_software.png)

# Papo sobre software, com quem entende!

(c) 2018 [**Cleuton Sampaio**](https://github.com/cleuton).

# Erros catastróficos - Por que acontecem?

![](./projetos-falhos.png)

Sabe o que é **guacamole de jiló**? É quando a soma dos insumos resulta em algo ruim. Experimente colocar em uma panela: Jiló, café, vinagre e ovos. Misture bem e beba. Vai ficar uma M... certo? É isso o que acontece em muitos projetos de software: A soma dos insumos resulta em algo ruim, gerando erros catastróficos. 

Não há uma só causa para o "guacamole de jiló", porém, podemos começar com a mania de ignorar as [**boas práticas da engenharia de software**](https://www.computer.org/education/bodies-of-knowledge/software-engineering), da [**arquitetura de software**](https://pt.wikipedia.org/wiki/Arquitetura_de_software) e da [**negligência das boas práticas de gestão de projetos**](https://brasil.pmi.org/brazil/PMBOKGuideAndStandards.aspx). 

Não adianta misturar tudo o que é moderninho, pois se ignorar essas práticas, o resultado tenderá ao fracasso. Por exemplo, nada adianta misturar: Angular, HTML 5, CSS 3, Java EE, EJB, ORM, Scrum, Kanban, Planning Poker, se você deixar de prestar atenção à [**arquitetura do software**](https://pt.wikipedia.org/wiki/Arquitetura_de_software), aos [**testes segregados**](http://falandosobre.software/testes/) e às [**restrições do projeto**](https://www.smartsheet.com/triple-constraint-triangle-theory).

*Mas, isto você já sabe, certo?*

## O ambiente moderno de software

A complexidade do desenvolvimento de software aumentou muito, nos últimos 10 anos e, consequentemente os desafios de conduzir um bom projeto também. Entre eles: 

- Crescente complexidade dos projetos;
- Ubiquidade, mobilidade e outras “dades”;
- Concorrência;
- Múltiplas plataformas;
- Efeito amplificador dos erros.

Porém, notamos um movimento inverso das práticas e métodos de desenvolvimento e gestão de projetos de software. Saímos de um modelo estruturado, definido e burocrático, dos anos 90, para uma "nuvem" de práticas subjetivas, denominada "métodos ágeis". Mas isso, em si, não é o maior dos problemas. Na verdade, o que é perturbador é: 

*Há uma tendência em abandonar boas práticas de engenharia de software em projetos ágeis!*

Há sim! E não podemos negar. Em um imenso projeto em que trabalhei, as pessoas simplesmente não desenvolviam sequer testes unitários, quanto mais de integração. Os testes eram manuais, como na década de 70! E, em nome do "o que vale é o entendimento da Equipe", deixavam de registrar adequadamente os requisitos (quando o faziam), gerando um problema para os futuros membros do Projeto. 

E não foi o único projeto ágil com esta característica. 

Mas sejamos justos: **Não só projetos ágeis falham nas boas práticas da engenharia de software**. É verdade! Projetos que usam modelo [**em cascata**](https://pt.wikipedia.org/wiki/Modelo_em_cascata) ou [**iterativo**](https://pt.wikipedia.org/wiki/Processo_unificado) também falham miseravelmente em aplicar as boas práticas. 

A verdade é que a diversidade das plataformas de desenvolvimento aumentaram muito a **entropia** das técnicas de projeto, programação e testes, turbinando a [**complexidade acidental**](http://www.obomprogramador.com/2012/12/complexidade-acidental.html) dos projetos de software.

Para demonstrar as causas combinadas do **guacamole de jiló**, analisarei os 3 aspectos que mais mudaram nos últimos anos, e que, na minha opinião, causaram estas falhas catastróficas.

## Gestão de requisitos

Isso passou a ser um **palavrão** nas equipes ágeis. Mas por que? O [**Manifesto ágil**](https://www.manifestoagil.com.br/) não proíbe documentar o que o Cliente deseja. Embora haja algumas pessoas (leigas no desenvolvimento de software) que acreditem nisso, na verdade, em nenhum trecho o **Manifesto** recomenda deixar de documentar adequadamente os requisitos. 

Ele diz, sim, para valorizar mais **Software em funcionamento mais que documentação abrangente**, e também diz em seus princípios que **O Método mais eficiente e eficaz de transmitir informações para, e por dentro de um time de desenvolvimento, é através de uma conversa cara a cara**. Mas isso significa deixar de documentar os requisitos?

O **Manifesto** também diz que **Nossa maior prioridade é satisfazer o cliente, através da entrega adiantada e contínua de software de valor** e também **Software funcional é a medida primária de progresso**. Como você sabe que o software entregue é de **valor**? Como sabe que ele é **funcional**? Tendo os requisitos documentados e testando contra eles, é claro!

É possível ser ágil documentando os requisitos. Chame-os como quiser, por exemplo: "histórias de usuários" ("estórias" não existe em Português!)

Um [**bom requisito**](https://medium.com/lfdev-blog/como-escrever-requisitos-de-software-de-forma-simples-e-garantir-o-m%C3%ADnimo-de-erros-no-sistema-app-74df2ee241cc) deve ser claro, sucinto e objetivo, mas não precisa ser complicado. Vejamos um exemplo:  

*"Ao entrar na página inicial, todos os usuários verão o mesmo conteúdo, que serão as notícias importantes. Para acessarem conteúdo personalizado, deverão efetuar login, informando seu email e senha, que serão validados contra o cadastro"*

Ok, vamos tentar quebrar esse requisito em partes: 

- **Ator**: Qualquer usuário;
- **Pré-condições**": Nenhuma;
- **Ação**: Acessar o site;
- **Resultado esperado**: Página inicial, com as notícias importantes, não personalizadas, e o formulário HTML para fazer login;
- **Ações possíveis**: Efetuar login, para ver o conteúdo personalizado.

Ele é bom porque permite ao desenvolvedor e ao Cliente entenderem o que acontece na página inicial do site. Alguém poderia argumentar: "Mas está faltando o que acontece depois do login", eu digo que não. Para a página inicial, está tudo certo. Se o usuário conseguir efetuar login, então outro requisito será acionado. Caso não consiga, é fácil entender que uma mensagem de erro deverá aparecer. 

Agora, vejamos um requisito não tão bom (que eu vi em um projeto de software): 

- *Como usuário*
- *Eu quero acessar a página inicial*
- *Então vejo as notícias*

Este requisito está em formato [**BDD - Behavior Driven Development**](https://www.devmedia.com.br/desenvolvimento-orientado-por-comportamento-bdd/21127), uma técnica moderna que permite derivar casos de teste diretamente dos requisitos. Mas não está bom. O que mais pode acontecer na página inicial? Que notícias ele vê? Há possibilidade de login? Não está claro. 

Na verdade, não importa a técnica que você utilize para escrever o requisito, ele tem que ser claro, sucinto e objetivo, não deixando nada "de fora". Se algo acontecerá naquele cenário, o requisito tem que mencionar, mas não deve incluir comportamentos de outros cenários, caso contrário, poder gerar duplicidade de interpretações. 

A boa prática é dividir a funcionalidade em cenários. A [**UML**](https://pt.wikipedia.org/wiki/UML) tinha um excelente padrão para isso que era o [**modelo de casos de uso**](https://pt.wikipedia.org/wiki/Caso_de_uso). Nos modelos ágeis, não temos nada claro para isso... Geralmente, usamos **BDD** para descrever as histórias do usuário, o que pode ser ruim, pois tem um nível de abstração difícil para os clientes entenderem. E é muito importante que entendam e aprovem cada história. 

Além do mais, precisamos de algo para unir as várias histórias, formando o [**escopo do projeto**](https://pt.wikipedia.org/wiki/Escopo_(gerenciamento_de_projeto)). Uma boa forma de fazer isso seria termos uma [**Estrutura analítica do projeto ou WBS**](https://pt.wikipedia.org/wiki/Estrutura_anal%C3%ADtica_do_projeto), um excelente instrumento para documentar escopo e estimar tempo e custo. 

Porém, EAP "caiu em desgraça" nas equipes ágeis, que utilizam algo meio *nebuloso*, gerado através de uma [**inception**](https://www.thoughtworks.com/pt/insights/blog/inception-o-que-quem-onde-quando-como-0), composto por inúmeros postits e documentos não estruturados de texto, o que acaba comprometento o entendimento do escopo. 

Mas, tudo bem! O importante é que haja alguma forma de enxergar o todo (a "big picture") e poder fazer "drill down" até chegar aos níveis mais baixos de abstração, para manter a rastreabilidade do trabalho, pois desta "big picture" serão derivados os cenários, requisitos e casos de teste.

[**Rastreabilidade**](https://www.projectbuilder.com.br/blog/veja-como-a-matriz-de-rastreabilidade-de-requisitos-pode-ajuda-lo-nos-processos-de-gerenciamento/) é a palavra-chave em projetos de software. Significa partirmos de um requisito e chegarmos até aos artefatos, aos desenvolvedores e aos custos envolvidos nele. Uma boa matriz de rastreabilidade nos permite gerenciarmos melhor as mudanças, pois poderemos analisar os impactos de forma objetiva e clara.

Em última análise, os requisitos deverão guiar os testes do futuro software. Se não for assim, então haverá problemas sérios. E, para isto, a rastreabilidade é importantíssima.

As causas dos problemas relacionadas a requisitos incluem: 
- Falta de ou má especificação de requisitos;
- Falta de atualização de requisitos;
- Falta de rastreabilidade de requisitos, o que impede as equipes de compreenderem o todo e suas partes;

## Arquitetura

Todos dizem entender [**arquitetura de software**](https://pt.wikipedia.org/wiki/Arquitetura_de_software) mas poucos sabem o que estão dizendo. Falando grosseiramente, a arquitetura do software é a materalização do TODO, ou seja, da **EAP** ou do resultado de uma **inception ágil**. Ela deve indicar as camadas, componentes, padrões e integrações, indo até ao nível das [**intefaces**](https://pt.wikipedia.org/wiki/Interface_(ci%C3%AAncia_da_computa%C3%A7%C3%A3o)) dos componentes, afinal de contas, elas serão utilizadas para os [**testes de integração**](https://pt.wikipedia.org/wiki/Teste_de_integra%C3%A7%C3%A3o). 

A arquitetura deve ser desenhada para otimizar ou maximizar a probabilidade de atender aos [**requisitos não funcionais**](https://pt.wikipedia.org/wiki/Requisito_n%C3%A3o_funcional) ou capacidades do software. Em modelos iterativos, ela pode ser expressada como um [**conjunto de visões**](https://pt.wikipedia.org/wiki/Arquitetura_de_software#Vis%C3%B5es) do SuD (software under development - software em desenvolvimento), que mostra como serão realizados ou materializados os requisitos do usuários.

É muito importante que a arquitetura esteja definida e aprovada ANTES do desenvolvimento, pois uma mudança arquitetural terá custos e consequências altíssimas para o cliente. 

Já em projetos tocados sob o guarda-chuva **ágil**, arquitetura é um dos produtos da [**inception**](https://www.thoughtworks.com/pt/insights/blog/inception-o-que-quem-onde-quando-como-0), materializada de várias formas diferentes. Porém, em muitos projetos, mudanças arquiteturais são introduzidas ao longo dos [**Sprints**](https://www.culturaagil.com.br/sprint-o-coracao-scrum/), o que pode gerar retrabalho e inconsistências. Não quero afirmar que isso sempre aconteça, mas, em minha experiência, é uma das causas mais frequentes de **guacamole de jiló**.

Faz parte da arquitetura do software a versão dos componentes utilizados. Desde a versão da linguagem, e do sistema operacional, até as versões dos componentes auxiliares. Para isto, o arquieto de software conta com a ajuda de técnicas e ferramentas de [**integração contínua**](https://aws.amazon.com/pt/devops/continuous-integration/), criando um ambiente **sala limpa** para construção, testes e integração do SuD. Isto ajuda a evitar o [**configuration drift**](https://www.continuitysoftware.com/blog/it-resilience/what-is-configuration-drift/) ou **divergência de configuração**, uma das grandes causas de problemas. 

Um exemplo sério de **configuration drift** é quando um desenvolvedor constrói (compila) o SuD em sua própria estação, enviando para o ambiente **de produção** uma versão que pode conter versões de componentes e insumos diferentes do que está na [**base de congfiguração do software**](http://falandosobre.software/gestao_configuracao/).

Ter uma arquitetura estável, documentada, com interfaces pré-definidas e instrumentos de integração contínua, é uma boa atitude para garantir o sucesso do projeto de software. 

As causas de problemas relacionadas à arquitetura do sofware são: 

- Arquitetura mal documentada ou mal compreendida;
- Mudanças arquiteturais negligenciadas;
- Interfaces indefinidas ou mal documentadas;
- Divergência de configuração;
- Integrações não documentadas;
- Falta de aderência aos requisitos não funcionais;

## Práticas de engenharia de software

Neste aspecto, há uma grande variedade de causas de problemas. A começar pela negligência com as boas práticas de engenharia de software, como: [**código limpo**](https://www.dropbox.com/sh/35d8k6ubnv09wtp/AABkOomGb_lfS9K8iA4UTOJwa?dl=0) ou [**testes**](http://falandosobre.software/testes/).

É papel do **arquiteto** ou **líder técnico** controlar a qualidade do software e dos testes produzidos, analisando [**métricas**](http://www.obomprogramador.com/2014/07/selecao-de-artigos-sobre-qualidade-de.html) de qualidade e de [**cobertura**](http://www.obomprogramador.com/2014/03/voce-testa-direito.html) de testes do código.

Este papel de **líder técnico** é frequentemente rebaixado pelos **gerentes de projeto** ou até mesmo **Scrum masters**, que tendem a assumir a liderança interferindo em áreas diversas de suas especialidades. Tenho visto isso acontecer com muita frequência, em situações onde o **líder técnico** é desrespeitado sistematicamente, deixando o projeto ser conduzido por **amadores** em engenharia de software.

Existe uma tendência dos **gerentes de projeto**, **Scrum masters** e **chefes de equipe** em menosprezar as práticas que desconhecem, como a engenharia e a arquitetura do software. Eles pensam que basta **açoitar** os desenvolvedores que o software ficará pronto, sem maiores preocupações. 

É essa tendência que os faz negligenciarem os **testes** do software!

Cada unidade do software deve ser testada de acordo com os **requisitos**, e de forma automática. O ambiente de integração contínua deve executar os testes unitários e de integração a cada novo **commit** na base de configuração. E os testes devem se segregados por objetivo: 

Tipo de teste | Modo de teste | Objetivo 
--- | --- | ---
Unitário | Caixa branca | Testar as partes do software com o máximo de cobertura possível
Integração | Caixa branca | Testar as integrações entre os módulos, exercitando o máximo delas possível
Sistema | Caixa branca | Testar o sistema em seus limites de requisitos não funcionais, avaliando seu comportamento
Aceitação | Caixa preta | Testar a funcionalidade, de acordo com a especificação
Desempenho | Caixa preta | Testar se o sistema atente aos requisitos de desempenho
Vulnerabilidade | Caixa preta | Testar se o sistema apresenta alguma vulnerabilidade explorável

A diferença entre “teste de sistema” e “teste de desempenho” é que, no primeiro, queremos ver como o sistema se comporta, incluindo seu funcionamento interno. No segundo, queremos ver apenas os sintomas externos (tempo de resposta, consumo de recursos, consistência de dados e erros).

Todos os testes podem e devem ser automatizados, inclusive os testes de aceitação. Testes executados por pessoas podem existir, sendo geralmente de **usabilidade**. A evidência de que o software está **funcional** é a presença e execução de testes automatizados. 

E tem mais: **Testes fazem parte do produto de software, foram pagos pelo Cliente, e a ele devem ser entregues!**

A falta de uma cultura de testes, como o [**TDD - Test-driven Development**](https://pt.wikipedia.org/wiki/Test-driven_development), mitigam o risco de problemas, permitindo criar software mais limpo e preciso. 

As causas de problema com engenharia de software geralmente são: 

- Falta de atenção à qualidade do código produzido: Baixa manutenibilidade, acurácia comprometida, vulnerabilidades (de segurança);
- Falta de atenção aos requisitos não funcionais: Baixa performance do software, exagerado consumo de memória etc;
- Falta de testes abrangentes, segregados e automatizados.

## Conclusão

Na verdade, existem muito mais aspectos que implicam em erro catastrófico, como a [**segurança da informação**](https://www.devmedia.com.br/introducao-ao-desenvolvimento-de-software-com-foco-em-seguranca/28161), mas eu foquei nos principais aspectos que são fonte de inúmeros problemas: **requisitos**, **arquitetura** e **engenharia** de software.

São mais de **41 anos** desenvolvendo aplicações, em vários ambientes, plataformas e linguagens. Já passei por várias metodologias e técnicas, desde a **análise estruturada** até ao **modelo ágil**. Portanto, acredito que tenho uma razoável certeza do que estou escrevendo.

Cleuton Sampaio, M.Sc.











