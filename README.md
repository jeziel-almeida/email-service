# Email Service

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

Projeto Java Spring de um Email Service do [Uber Coding Challenge](https://github.com/uber-archive/coding-challenge-tools/blob/master/coding_challenge.md).

## Tecnologias utilizadas

* [Java](https://www.java.com/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Amazon SES](https://aws.amazon.com/ses/)
* [SendGrid](https://sendgrid.com)

## Descrição

O projeto consiste em um serviço de envio de e-mail simples. Ele permite que o usuário envie e-mails para um destinatário especificado, com um texto e um assunto personalizados.<br>
O projeto foi baseado no tutorial do canal [Fernanda Kipper | Dev](https://youtu.be/eFgeO9M9lLw).

## Arquitetura

- A aplicação foi dividida em camadas onde uma encapsula a outra.
1. **Camada Core:** Camada central. Responsável por reunir as regras de negócio da aplicação. Também reúne os casos de usos que definem o que a aplicação faz e não como ela faz.
2. **Camada de Aplicação:** Contém a implementação dos casos de usos. Possui a classe EmailSenderService cuja função na arquitetura é fornecer uma camada de abstração sobre os diferentes serviços de e-mail. Isso permite que os outros componentes da arquitetura sejam desacoplados dos serviços de e-mail específicos. Isso torna a arquitetura mais flexível e fácil de manter. Além disso, a classe EmailSenderService implementa um mecanismo de _fallback_. Se o primeiro serviço de e-mail falhar, a classe EmailSenderService tentará enviar o e-mail usando o segundo serviço de e-mail. Isso melhora a resiliência da arquitetura.
3. **Camada de Adapters:** Possui a classe EmailSenderGateway que é uma interface adapter. Uma interface adapter é um padrão de design que permite que um sistema se conecte a diferentes fornecedores de terceiros sem ter que depender de suas implementações específicas.
4. **Camada de Infraestrutura**: É responsável por fornecer as implementações de cada serviço de e-mail específico. Essas implementações são responsáveis por realizar as tarefas necessárias para enviar e-mails, como conectar-se ao serviço de e-mail, autenticar-se e enviar a mensagem.

## Como usar

Para usar o projeto, siga estas etapas:

1. Clone o repositório para sua máquina local.
2. Crie uma conta na AWS e configure o Amazon SES.
3. Atualize o arquivo `AwsSesConfig.java` com as credenciais da sua conta AWS, bem como o email remetente.
4. Crie uma conta na SendGrid e configure sua API Key.
5. Atualize o arquivo `SendgridEmailSender.java` com a sua API Key, bem como o email remetente.
6. Execute o projeto com o comando `mvn spring-boot:run`.

## Exemplos

Para enviar um email, use a seguinte URL:

```code
http://localhost:8080/api/email
```

No corpo da requisição, envie os seguintes dados:

```json
{
    "to": "Email do destinatário",
    "subject": "Assunto do email",
    "body": "Corpo do email",
}
```
