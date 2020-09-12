# Exercício 2 - Cálculo de Custo de Obra

Aplicação que recebe um arquivo JSON com uma lista de composições e insumos necessários para a realização de uma obra.
A aplicação calcula o custo de cada composição de materiais e serviços em uma obra com base no conteúdo do arquivo.

Esta é uma aplicação desenvolvida utilizando Java 8 e a biblioteca [jackson](https://github.com/FasterXML/jackson).
Como ferramenta de Build foi utilizado o Maven.


## Instalação

Após baixar o código fonte da aplicação, executar o comando abaixo para realizar o build da aplicação com o Maven e executar os testes unitários:

No diretório raiz da aplicação:
```js
mvn clean install
```

O processo de build gera dois artefatos executáveis no diretório target do projeto:
```js
CustoObraApp.jar
CustoObraApp-jar-with-dependencies.jar
```

* O primeiro arquivo (CustoObraApp.jar) precisa das bibliotecas do jackson disponibilizadas no diretório lib para ser executado.
* O segundo arquivo (CustoObraApp-jar-with-dependencies.jar) conterá todas as biblitecas necessárias, portanto,
 pode ser executado de qualquer outro diretório ou máquina que possua o Java instalado.

## Execução

Após compilar o código com sucesso, pode-se executar a aplicação utilizando os comando abaixo:

 - Executando a aplicação passando o local de um arquivo JSON como argumento na linha de comando:
```js
java -jar CustoObraApp.jar "C:\dev\dados-entrada-servicos-composicoes.json"
```

 - Executando a aplicação sem argumentos, será solicitado posteriormente ao usuário que insira o local de um arquivo JSON:
```js
java -jar CustoObraApp.jar

Insira nome e diretório do arquivo de dados:
C:\dev\dados-entrada-servicos-composicoes.json
```

## Sobre design da aplicação

No design da aplicação foram utilizados principalmente três pontos

1. Biblioteca jackson-databind para auxiliar na deserialização de arquivos JSON;
2. Utilização do padrão de Repositório para armazendar as composições e insumos recebidos no arquivo JSON;
3. Utilização do padrão [Composite](https://www.tutorialspoint.com/design_pattern/composite_pattern.htm) (design pattern)
para organização e cálculo do custo das composições;