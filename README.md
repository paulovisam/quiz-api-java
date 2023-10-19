# Quiz em Java Spring Boot

Este é um projeto de exemplo de um sistema de quiz de perguntas e respostas desenvolvido em Java com o framework Spring Boot. O sistema segue a arquitetura MVCR (Model, View, Controller, Repository) e permite a criação, edição, exclusão e visualização de perguntas e alternativas.

## Requisitos
Certifique-se de que você tenha as seguintes ferramentas instaladas:

- Java Development Kit (JDK)
- Spring Boot
- Maven (opcional, pode ser usado o wrapper do Maven)

## Configuração
Clone o repositório para a sua máquina:

```git clone https://github.com/paulovisam/quiz-api-java.git```

Navegue até o diretório do projeto:

```cd quiz-api-java```

Configure as propriedades do banco de dados no arquivo application.properties. Você pode usar um banco de dados embutido para testes locais ou configurar um banco de dados de produção, como MySQL, PostgreSQL, etc.

## Execute o projeto Spring Boot:

```./mvnw spring-boot:run```

O projeto será iniciado e estará acessível em http://localhost:8080. Você pode alterar a porta no arquivo de propriedades, se necessário.

## Endpoints da API

/question: Endpoint para criar, editar, listar e excluir perguntas em um quiz.

/alternative: Endpoint para criar, editar, listar e excluir alternativas para uma pergunta.
Estrutura do Projeto
A estrutura do projeto segue a arquitetura MVCR:

Model: Classes que representam os dados do aplicativo e são mapeadas para o banco de dados.

View (DTO): Padrões de entrada e saída da API 

Controller: Controladores que lidam com as requisições da API e as interações com o banco de dados.

Repository: Interfaces que definem as operações de banco de dados (CRUD) para as entidades.

## Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para criar problemas (issues) e enviar solicitações de pull (pull requests).

## Licença
Este projeto é distribuído sob a licença MIT.