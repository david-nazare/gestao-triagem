# gestao-triagem

### PROPÓSITO

> Gerencia o formulário de triagem, permitindo o seu cadastro e manutenção,
bem como a análise e validação dos seus dados.

#### TECNOLOGIAS ENVOLVIDAS

- Java
- Maven
- Spring

#### DEPENDÊNCIAS E VERSÕES

- Java Oracle JDK 21: (https://www.oracle.com/java/technologies/downloads/#java21)
- Maven 3.9.9+: (https://maven.apache.org/download.cgi)

### EXECUÇÃO

#### BAIXAR A APLICAÇÃO

- Se quiser baixar o código para avaliar a estrutura do projeto, 
basta executar a seguinte linha de comando.
```shell script
git clone https://github.com/david-nazare/gestao-triagem.git
```
- Se o intuito for só executar a aplicação, basta baixar o arquivo
executável que se encontra na raíz do repositório, 
gestao-triagem-0.0.1.jar

#### EXECUTAR A APLICAÇÃO

- Para executar o binário, basta executar a seguinte linha de comando
```shell script
java -jar gestao-triagem-0.0.1.jar
```
Feito isso, basta aguardar alguns segundos até a aplicação estar no ar

### TESTAR A APLICAÇÃO

#### PREENCHER TRIAGEM

No Postman, através do verbo POST, utilizar o seguinte endereço:
```shell script
http://localhost:8080/triagem
```
Utilizar no body da requisição o tipo raw, e o formato de dados JSON:
```shell script
{
    "id": "",
    "usuarioId": "123e4567-e89b-12d3-a456-426614174001",
    "profissao": "Analista de Qualidade Pleno",
    "perfilLinkedin": "https://linkedin.com/fulano2",
    "areaAtuacao": "Tecnologia",
    "cargoAtual": "2",
    "areaDeInteresse": "Tecnologia",
    "cargoDeInteresse": "1",
    "tempoParaAlcancarObjetivo": "5",
    "habilidades": [
        "1",
        "2"
    ]
}
```

#### CONSULTAR TRIAGEM

No Postman, através do verbo GET, utilizar o seguinte endereço:
```shell script
http://localhost:8080/triagem/{id da triagem}
```
Onde o {id da triagem} deve ser substituído pela triagem criada no
passo PREENCHER TRIAGEM

O resultado desta operação pode ser uma mensagem informando que a triagem
não foi encontrada, ou os dados da triagem cadastrada previamente.

#### ANALISAR TRIAGEM

No Postman, através do verbo POST, utilizar o seguinte endereço:
```shell script
http://localhost:8080/triagem/{id da triagem}
```
Onde o {id da triagem} deve ser substituído pela triagem criada no 
passo PREENCHER TRIAGEM

O resultado desta operação pode ser uma mensagem informando alguma
inconsistência, ou uma mensagem de sucesso como a abaixo caso todos
os campos tenham sido validados com sucesso.
```shell script
{
    "resultadoAnalise": "Análise realizada com sucesso. Nenhuma inconsistência encontrada"
}
```

#### ATUALIZAR TRIAGEM

No Postman, através do verbo PUT, utilizar o seguinte endereço:
```shell script
http://localhost:8080/triagem/{id da triagem}
```
Onde o {id da triagem} deve ser substituído pela triagem criada no
passo PREENCHER TRIAGEM

Utilizar no body da requisição o tipo raw, e o formato de dados JSON:
```shell script
{
    "id": "",
    "usuarioId": "123e4567-e89b-12d3-a456-426614174001",
    "profissao": "Analista de Qualidade Pleno",
    "perfilLinkedin": "https://linkedin.com/fulano2",
    "areaAtuacao": "Tecnologia",
    "cargoAtual": "2",
    "areaDeInteresse": "Tecnologia",
    "cargoDeInteresse": "1",
    "tempoParaAlcancarObjetivo": "5",
    "habilidades": [
        "1",
        "2",
        "3",
        "5"
    ]
}
```
Neste cenário, o id da triagem do body não precisa estar preenchido,
pois será utilizado o id da URI para realizar a operação de atualização.
