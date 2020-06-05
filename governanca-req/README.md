![](../falandosobre_software.png)

# Papo sobre software, com quem entende!

(c) 2020 [**Cleuton Sampaio**](https://github.com/cleuton).

# Governança de Requisitos

![](./postit.jpg)

Requisitos e regras de negócio são talvez a parte mais importante de um **Sistema Corporativo**, pois moldam o funcionamento das aplicações computacionais. Apesar da [**Engenharia de Software**](https://www.computer.org/education/bodies-of-knowledge/software-engineering) sempre tratar **requisitos** como cidadãos de primeira classe, as práticas de desenvolvimento de software, como os métodos *ágeis* tendem a menosprezar sua importância. 

**Entregar não é suficiente**

Pode parecer uma *heresia* para agilistas, mas simplesmente *entregar* o software não satisfaz o investimento que a empresa e o cliente fizeram em sua construção. E mais importante do que *entregas frequentes* é termos *entregas de valor*, nas quais o software (que é parte de um **Sistema Corporativo**) é entregue juntamente com tudo aquilo que garantirá seu uso continuado, como: Testes automatizados e requisitos rastreados.

Um **Sistema Corporativo** é composto por: Hardware, Software, Base de conhecimento e Pessoas! De quê adianta entregar rapidamente novas versões do software, se falta conhecimento para sua operação e integração ao *Sistema*? De quê adianta um monte de *post-its* se não há uma base onde os requisitos estão especificados, versionados e rastreados com sua implementação?

**Uma parábola**

Em um universo paralelo, de repente os diretores acordaram e passaram a pressionar para a implantação de um sistema urgente. Feito *à toque de caixa*, foi entregue no prazo que os *mimados* gestores queriam, mas sem requisitos, sem testes automatizados, sem rastreabilidade. O software funcionava e a prova era: *La garantia soy jo".

Um infeliz (parecido comigo) foi designado (na verdade: CONDENADO) a manter tal ignomínia, uma vergonha para qualquer Desenvolvedor que tenha um mínimo de estudo. 

Bom, lá pelas tantas, um *engraçadinho* disse que havia um erro na saída do tal software e, como sempre, queria o problema resolvido na mesma hora. É sempre assim... 

Ao examinar o tal software, o *infeliz* descobriu que, na verdade, o tal *erro* não se tratava de um erro, mas de uma característica motivada por regras de negócio implementadas no código. Sem documentação alguma, havia vários **ifs** que determinavam o comportamento do software. 

E então, o *infeliz* fez o que pode: Encaminhou seus achados para quem estava reclamando e o silêncio voltou a reinar. 

Moral da história: **Nenhuma**!

Para começar, o usuário reclamava de algo que o software produzia, mas tal resultado era proposital e isto estava aparente no código-fonte. Para ilustrar melhor, deixe-me perguntar uma coisa: *Jabuti sobe em árvore?* Não? Ok, código também não se materializa do nada! Alguém colocou ali e por alguma razão. Saber quem colocou é fácil, mas entender o motivo é difícil. Isto se resolve com a rastreabilidade de requisitos. 

## Rastreabilidade

É um princípio importante de segurança de informação e significa saber quem alterou a informação e quem a utilizou e onde ela está materializada agora. Em termos de requisitos, significa manter um registro versionado dos mesmos, com apontamentos para as partes do software onde estes se materializam. 

Se um requisito foi alterado, é fácil saber, pois o controle de versão apontará isso, assim como apontará as partes do código-fonte alteradas em função da mudança de requisitos. Dá para saber quem fez e quem mandou fazer. 

É simples e TODAS as ferramentas de versionamento de artefatos fazem isto.

## Governança

Mas a **rastreabilidade** para nada serve se não houver um **DONO**! Sim, um **DONO** da informação! Alguém que controle ou *governe* os caminhos que o software deverá tomar, com base em seus requisitos.

Fala-se muito sobre *governança* e sua prima-irmã: a *compliance* mas, na verdade, ninguém pratica isso nas menores escalas. 

Não basta manter uma base versionada de requisitos e de código, se não houver alguém para controlar as manutenções, aprovar as mudanças e validar os resultados de testes, garantindo que a rastreabilidade continue a ser mantida. 

Uma só pessoa pode fazer isso? Claro que não! Não é uma pessoa e nem duas pessoas! Governança é um papel, a ser exercido por um colegiado corporativo, ou seja, uma entidade a prova de *férias*, *doenças* e *demissões* (voluntárias ou não). 

É claro que existem os *experts* em determinados assuntos de negócios, e estes devem ser consultados, mas não deve ter o poder de tomar decisões sozinhos, sem a aprovação de um colegiado da Empresa, que aja de acordo com as boas práticas de *compliance* e objetivando a saúde corporativa e a lucratividade. 

Assim como os Desenvolvedores não devem tomar decisões de negócio sozinhos, os usuários também não devem poder interferir com algo que é propriedade da Empresa, pois podem não estar agindo em conformidade com o que ela deseja. 

## Conclusão

Ágil ou não, o processo de desenvolvimento de um software deve aplicar princípios de governança e rastreabilidade de requisitos e regras de negócio, assim como o seu correto versionamento. Tais práticas não diminuem a *agilidade* de entrega, já que [*agilidade* não significa *rapidez*](https://agileschool.com.br/ser-agil-nao-e-ser-rapido-e-ser-adaptativo/).



