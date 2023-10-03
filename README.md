# Email Service

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

Este repositório contém um projeto Java Spring de um Email Service, baseado no [Uber Coding Challenge](https://github.com/uber-archive/coding-challenge-tools/blob/master/coding_challenge.md). O projeto também utiliza o Amazon SES da AWS.

## Tecnologias utilizadas

* [Java](https://www.java.com/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Amazon SES](https://aws.amazon.com/ses/)

## Descrição

O projeto consiste em um serviço de envio de e-mail simples. Ele permite que o usuário envie e-mails para um destinatário especificado, com um texto e um assunto personalizados. Também utiliza Arquitetura Limpa.

O projeto foi baseado no tutorial do canal [Fernanda Kipper | Dev](https://youtu.be/eFgeO9M9lLw).

## Como usar

Para usar o projeto, siga estas etapas:

1. Clone o repositório para sua máquina local.
2. Crie uma conta na AWS e configure o Amazon SES.
3. Atualize o arquivo `AwsSesConfig.java` com as credenciais da sua conta AWS.
4. Execute o projeto com o comando `mvn spring-boot:run`.

## Exemplos

Para enviar um email, use a seguinte URL:

```code
http://localhost:8080/api/email
```

No corpo da requisição, envie os seguintes dados:

* `to`: Endereço de email do destinatário.
* `subject`: Assunto do email.
* `body`: Corpo do email.
