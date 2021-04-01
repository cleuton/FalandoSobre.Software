# Merge com dor

Poucas coisas causam tanto prazer na vida como: Relaxar numa bela praia, Ganhar na loteria ou Merge sem conflitos. Quando trabalhamos em equipe, conflitos podem ocorrer e temos que saber como lidar com eles em nossa Gestão de Configuração de Software. 

Aqui, gostaria de relembrar o que eu disse no início: 

> Boas práticas de **Liderança técnica** podem mitigar a ocorrência de conflitos. 

Se estão ocorrendo muitos conflitos em seu projeto, talvez seja interessante mudar a maneira como você está atribuindo tarefas à Equipe. Fazer rastreamento das **histórias de usuário** até o **código fonte** pode ser uma boa atitude e então, dividir as histórias de acordo com o código-fonte afetado. Assim, evita-se que duas pessoas alterem o mesmo artefato simultaneamente.

Mas vamos lá...

## A história de um conflito

Se você seguiu minhas orientações, então tem 2 repositórios locais diferentes, representando dois desenvolvedores diferentes. 

O desenvolvedor 1 fez alterações em um artefato (requirements.txt): 

```
gunicorn
flask
```

E executou os comandos: 

```
C:\Users\Cleuton Sampaio\projetos\meuprojetogitlab\gitprojsample>git status
On branch master
Your branch is up to date with 'origin/master'.

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   requirements.txt

no changes added to commit (use "git add" and/or "git commit -a")

C:\Users\Cleuton Sampaio\projetos\meuprojetogitlab\gitprojsample>git add *

C:\Users\Cleuton Sampaio\projetos\meuprojetogitlab\gitprojsample>git commit -m "Adicionando gunicorn"
[master 87b63cc] Adicionando gunicorn
 1 file changed, 1 insertion(+)
```

Ao mesmo tempo, o desenvolvedor 2 fez alterações no mesmo arquivo (requirements.txt):

```
requests
flask
```

E também executou os mesmos comandos.

O Desenvolvedor 1 foi o primeiro a fazer **git push** (na verdade, a ordem não importaria): 

```
C:\Users\Cleuton Sampaio\projetos\meuprojetogitlab\gitprojsample>git push origin master
Enumerating objects: 9, done.
Counting objects: 100% (8/8), done.
Delta compression using up to 8 threads
Compressing objects: 100% (4/4), done.
Writing objects: 100% (5/5), 515 bytes | 515.00 KiB/s, done.
Total 5 (delta 2), reused 0 (delta 0), pack-reused 0
To https://gitlab.com/cleuton.sampaio/gitprojsample.git
   47938a7..f7b21c8  master -> master
```

Antes de fazer um **git push**, o Desenvolvedor 2 foi esperto e fez um **git pull origin master** puxando possíveis modificações feitas no branch remoto e realmente pegou: 

```
C:\Users\Cleuton Sampaio\projetos\outrodev\gitprojsample>git pull origin master
remote: Enumerating objects: 9, done.
remote: Counting objects: 100% (8/8), done.
remote: Compressing objects: 100% (4/4), done.
remote: Total 5 (delta 2), reused 0 (delta 0), pack-reused 0
Unpacking objects: 100% (5/5), 495 bytes | 30.00 KiB/s, done.
From https://gitlab.com/cleuton.sampaio/gitprojsample
 * branch            master     -> FETCH_HEAD
   47938a7..f7b21c8  master     -> origin/master
Auto-merging requirements.txt
CONFLICT (content): Merge conflict in requirements.txt
Automatic merge failed; fix conflicts and then commit the result.
```

Como pode ver, ele não conseguiu fazer o merge automatico e relatou um conflito. Se fizermos um **git status** veremos: 

```
C:\Users\Cleuton Sampaio\projetos\outrodev\gitprojsample>git status
On branch master
Your branch and 'origin/master' have diverged,
and have 1 and 2 different commits each, respectively.
  (use "git pull" to merge the remote branch into yours)

You have unmerged paths.
  (fix conflicts and run "git commit")
  (use "git merge --abort" to abort the merge)

Unmerged paths:
  (use "git add <file>..." to mark resolution)
        both modified:   requirements.txt

no changes added to commit (use "git add" and/or "git commit -a")
```

Ele marcou os arquivos em conflito e não jogou nada no **index**. Você tem que resolver o(s) conflito(s) e jogar na **staging area** ou **index** e depois fazer **commit**. Se olhar o arquivo em conflito (requirements.txt) em sua **workspace** verá este conteúdo: 

```
<<<<<<< HEAD
requests
flask
=======
gunicorn
flask
>>>>>>> f7b21c87bb7d03ed656d3e348f40c805f49d95fe
```
O marcador **HEAD** indica qual é o conteúdo que está na sua versão, ou seja, apontado pela referência **HEAD** no branch **master** na sua máquina (você já havia feito commit). E, depois dos sinais "=" está o conteúdo que está no repositório remoto, cujo commit foi descrito depois dos sinais ">". Cabe a você corrigir o arquivo, adicionar ao **index**, fazer **commit** e depois **git push**. Vamos corrigir o arquivo para ficar assim: 

```
requests
gunicorn
flask
```

Depois, o Desenvolvedor 2 fez exatamente isso: 

```
C:\Users\Cleuton Sampaio\projetos\outrodev\gitprojsample>git add *

C:\Users\Cleuton Sampaio\projetos\outrodev\gitprojsample>git commit -m "Resolvendo conflito requirements.txt"
[master 6020428] Resolvendo conflito requirements.txt

C:\Users\Cleuton Sampaio\projetos\outrodev\gitprojsample>git push origin master
Enumerating objects: 10, done.
Counting objects: 100% (10/10), done.
Delta compression using up to 8 threads
Compressing objects: 100% (4/4), done.
Writing objects: 100% (6/6), 583 bytes | 583.00 KiB/s, done.
Total 6 (delta 2), reused 0 (delta 0), pack-reused 0
To https://gitlab.com/cleuton.sampaio/gitprojsample.git
   f7b21c8..6020428  master -> master
```

Agora, se o Desenvolvedor 1 fizer um **git pull**: 

```
C:\Users\Cleuton Sampaio\projetos\meuprojetogitlab\gitprojsample>git pull
remote: Enumerating objects: 10, done.
remote: Counting objects: 100% (10/10), done.
remote: Compressing objects: 100% (4/4), done.
remote: Total 6 (delta 2), reused 0 (delta 0), pack-reused 0
Unpacking objects: 100% (6/6), 563 bytes | 26.00 KiB/s, done.
From https://gitlab.com/cleuton.sampaio/gitprojsample
   f7b21c8..6020428  master     -> origin/master
Updating f7b21c8..6020428
Fast-forward
 requirements.txt | 3 ++-
 1 file changed, 2 insertions(+), 1 deletion(-)
```

Verá seu arquivo "requirements.txt" com o mesmo conteúdo que o Desenvolvedor 2 atualizou: 

```
requests
gunicorn
flask
```

Este foi um conflito simples, cuja correção foi bem fácil. Imagine conflitos em vários artefatos e em vários pontos... A resolução pode exigir a participação de mais de um desenvolvedor.

Conflitos também podem surgir quando tentamos integrar um **branch** a outro. 

Vamos supor que o Desenvolvedor 3 recebeu uma tarefa, um **hotfix** e criou um branch para isso: 

```
C:\Users\Cleuton Sampaio\projetos\dev3>git clone https://gitlab.com/cleuton.sampaio/gitprojsample.git
Cloning into 'gitprojsample'...
remote: Enumerating objects: 23, done.
remote: Counting objects: 100% (23/23), done.
remote: Compressing objects: 100% (17/17), done.
remote: Total 23 (delta 9), reused 0 (delta 0), pack-reused 0
Receiving objects: 100% (23/23), done.
Resolving deltas: 100% (9/9), done.

C:\Users\Cleuton Sampaio\projetos\dev3>dir
 O volume na unidade C não tem nome.
 O Número de Série do Volume é 083B-550F

 Pasta de C:\Users\Cleuton Sampaio\projetos\dev3

29/03/2021  14:14    <DIR>          .
29/03/2021  14:14    <DIR>          ..
29/03/2021  14:14    <DIR>          gitprojsample
               0 arquivo(s)              0 bytes
               3 pasta(s)   409.449.177.088 bytes disponíveis

C:\Users\Cleuton Sampaio\projetos\dev3>cd gitprojsample

C:\Users\Cleuton Sampaio\projetos\dev3\gitprojsample>git checkout -b hotfix1
Switched to a new branch 'hotfix1'

C:\Users\Cleuton Sampaio\projetos\dev3\gitprojsample>git status
On branch hotfix1
nothing to commit, working tree clean
```

Ele clonou o projeto e criou um novo branch com o nome "hotfix1": ***git checkout -b hotfix1**. O comando **git checkout** nos permite mudar o **HEAD** para apontar para outro commit, seja ele um novo **branch** ou um **tag**. 

> **Tag** é um tipo de referência a um **commit**.

Tudo o que ele fizer será salvo no branch **hotfix1**. Vamos supor que ele editou o arquivo "servidor.py": 

**msg="OK"**\
  response = app.response_class(\
  response=json.dumps({'status':**msg**}),

 E ele fez commit e push disso para um novo branch remoto "hotfix1". Por que? Bom, talvez ele ainda tenha que testar antes de incorporar ao **master**: 

```
C:\Users\Cleuton Sampaio\projetos\dev3\gitprojsample>git add *

C:\Users\Cleuton Sampaio\projetos\dev3\gitprojsample>git commit -m "Hotfix1"
[hotfix1 83ab25e] Hotfix1
 1 file changed, 2 insertions(+), 2 deletions(-)

C:\Users\Cleuton Sampaio\projetos\dev3\gitprojsample>git push origin hotfix1
Enumerating objects: 5, done.
Counting objects: 100% (5/5), done.
Delta compression using up to 8 threads
Compressing objects: 100% (3/3), done.
Writing objects: 100% (3/3), 299 bytes | 299.00 KiB/s, done.
Total 3 (delta 2), reused 0 (delta 0), pack-reused 0
remote:
remote: To create a merge request for hotfix1, visit:
remote:   https://gitlab.com/cleuton.sampaio/gitprojsample/-/merge_requests/new?merge_request%5Bsource_branch%5D=hotfix1
remote:
To https://gitlab.com/cleuton.sampaio/gitprojsample.git
 * [new branch]      hotfix1 -> hotfix1
```

Como podemos ver, foi criado um novo branch remoto. Enquanto isso, a vida prossegue... Os outros desenvolvedores continuam trabalhando. O Desenvolvedor 1 modificou o mesmo arquivo: 

status=200\
**descricao="processamento ok"**\
response = app.response_class(\
    response=json.dumps({'status':'OK', **'descricao':descricao**}),

E ele sincronizou isso enviando para o **origin/master**: 

```
C:\Users\Cleuton Sampaio\projetos\meuprojetogitlab\gitprojsample>git add *

C:\Users\Cleuton Sampaio\projetos\meuprojetogitlab\gitprojsample>git commit -m "Campo descricao"
[master 6a06cdb] Campo descricao
 1 file changed, 2 insertions(+), 2 deletions(-)

C:\Users\Cleuton Sampaio\projetos\meuprojetogitlab\gitprojsample>git push origin master
Enumerating objects: 5, done.
Counting objects: 100% (5/5), done.
Delta compression using up to 8 threads
Compressing objects: 100% (3/3), done.
Writing objects: 100% (3/3), 330 bytes | 330.00 KiB/s, done.
Total 3 (delta 2), reused 0 (delta 0), pack-reused 0
To https://gitlab.com/cleuton.sampaio/gitprojsample.git
   6020428..6a06cdb  master -> master
```

O nosso amigo Desenvolvedor 3, que trabalhou em um **branch** diferente do **master**, terminou seus testes e quer incorporar suas alterações ao **master**. Ele precisa fazer um **merge** entre o branch "hotfix1" e o "master" local. 

Antes de fazer o **merge**, é bom ele atualizar seu próprio branch **master** local com um **git pull**. Para isso, ele precisa mudar para o master: 

```
C:\Users\Cleuton Sampaio\projetos\dev3\gitprojsample>git checkout master
Switched to branch 'master'
Your branch is up to date with 'origin/master'.

C:\Users\Cleuton Sampaio\projetos\dev3\gitprojsample>git pull
remote: Enumerating objects: 5, done.
remote: Counting objects: 100% (5/5), done.
remote: Compressing objects: 100% (3/3), done.
remote: Total 3 (delta 2), reused 0 (delta 0), pack-reused 0
Unpacking objects: 100% (3/3), 310 bytes | 28.00 KiB/s, done.
From https://gitlab.com/cleuton.sampaio/gitprojsample
   6020428..6a06cdb  master     -> origin/master
Updating 6020428..6a06cdb
Fast-forward
 servidor.py | 4 ++--
 1 file changed, 2 insertions(+), 2 deletions(-)

C:\Users\Cleuton Sampaio\projetos\dev3\gitprojsample>git status
On branch master
Your branch is up to date with 'origin/master'.

nothing to commit, working tree clean
```

Pelo resultado do **git pull** ele vê que havia alterações no **master** remoto, e pelo **git status** ele vê que não havia conflitos. Ótimo. Agora, ele pode fazer o merge do **master** com o **hotfix1**: 

```
C:\Users\Cleuton Sampaio\projetos\dev3\gitprojsample>git merge hotfix1
Auto-merging servidor.py
CONFLICT (content): Merge conflict in servidor.py
Automatic merge failed; fix conflicts and then commit the result.
```

Era esperado... Ele está no branch **master**. Se olharmos o arquivo "servidor.py" veremos o conflito: 

```
import os, sys
from flask import Flask,   json

app = Flask(__name__)

@app.route('/', methods=['GET'])
def get_method():

        status=200
<<<<<<< HEAD
        descricao="processamento ok"
        response = app.response_class(
            response=json.dumps({'status':'OK', 'descricao':descricao}),
=======
        msg="OK"
        response = app.response_class(
            response=json.dumps({'status':msg}),
>>>>>>> hotfix1
            status=status,
            mimetype='application/json'
        )
        return response
app.run(host='0.0.0.0', port=8088, debug=True)
```

Agora pense... Como vamos resolver isso? Não é apenas um arquivo de configuração, é código-fonte... Será que as alterações ainda são válidas simultaneamente? Será que uma não foi para corrigir a outra? Como saber isso? Conversando! É necessário que os dois desenvolvedores (Desenvolvedor 1 e Desenvolvedor 3) conversem e cheguem a um consenso de como deve ficar o código-fonte. Por exemplo: 

```
import os, sys
from flask import Flask,   json

app = Flask(__name__)

@app.route('/', methods=['GET'])
def get_method():

        status=200
        msg="OK"
        descricao="processamento ok"
        response = app.response_class(
            response=json.dumps({'status':msg, 'descricao':descricao}),
            status=status,
            mimetype='application/json'
        )        
        return response
app.run(host='0.0.0.0', port=8088, debug=True)
```

E subimos o novo branch **master** para o repositório remoto: 

```
C:\Users\Cleuton Sampaio\projetos\dev3\gitprojsample>git add *

C:\Users\Cleuton Sampaio\projetos\dev3\gitprojsample>git commit -m "Resolvendo conflito servidor.py'
[master c237c06] Resolvendo conflito servidor.py'

C:\Users\Cleuton Sampaio\projetos\dev3\gitprojsample>git push origin master
Enumerating objects: 7, done.
Counting objects: 100% (7/7), done.
Delta compression using up to 8 threads
Compressing objects: 100% (3/3), done.
Writing objects: 100% (3/3), 344 bytes | 344.00 KiB/s, done.
Total 3 (delta 2), reused 0 (delta 0), pack-reused 0
To https://gitlab.com/cleuton.sampaio/gitprojsample.git
   6a06cdb..c237c06  master -> master
```

Pronto! Conflito resolvido. 

