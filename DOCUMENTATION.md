Documentação - Solução técnica
====================

> Essa Web API possui um endpoint para enviar emails através de dois serviços de email.

Conteúdo
====================

1. [Stack utilizada](#stack-utilizada)
2. [Arquitetura](#arquitetura)
3. [Endpoints](#endpoints)

Stack utilizada
====================

- Java
- Spring Boot 3
- Amazon SES
- SendGrid
- Design Pattern Adapter

Arquitetura
====================

- A aplicação foi dividida em camadas onde uma encapsula a outra.
1. **Camada Core:** Camada central. Responsável por reunir as regras de negócio da aplicação. Também reúne os casos de usos que definem o que a aplicação faz e não como ela faz.
2. **Camada de Aplicação:** Contém a implementação dos casos de usos. Possui a classe EmailSenderService cuja função na arquitetura é fornecer uma camada de abstração sobre os diferentes serviços de e-mail. Isso permite que os outros componentes da arquitetura sejam desacoplados dos serviços de e-mail específicos. Isso torna a arquitetura mais flexível e fácil de manter. Além disso, a classe EmailSenderService implementa um mecanismo de _fallback_. Se o primeiro serviço de e-mail falhar, a classe EmailSenderService tentará enviar o e-mail usando o segundo serviço de e-mail. Isso melhora a resiliência da arquitetura.
3. **Camada de Adapters:** Possui a classe EmailSenderGateway que é uma interface adapter. Uma interface adapter é um padrão de design que permite que um sistema se conecte a diferentes fornecedores de terceiros sem ter que depender de suas implementações específicas.
4. **Camada de Infraestrutura**: É responsável por fornecer as implementações de cada serviço de e-mail específico. Essas implementações são responsáveis por realizar as tarefas necessárias para enviar e-mails, como conectar-se ao serviço de e-mail, autenticar-se e enviar a mensagem.

Endpoints
=====================

### Erros HTTP

|          |                        Descrição                         |
|:--------:|:----------------------------------------------------------:|
| HTTP 4xx | Código de retorno quanto o erro é cometido pelo remetente. |
| HTTP 5xx |  Código de retorno quando o erro é emitido pelo servidor.  |

### Endpoints de usuário
#### [POST] - api/email

Envia um email para o endereço de email fornecido com o assunto e corpo do email.

|                     |   Nome    |              Descriçao               | Obrigatorio |
|:-------------------:|:---------:|:------------------------------------:|:-----------:|
| Corpo da requisição | to |       Email do destinatário       |     sim     |
| Corpo da requisição | subject  |        Assunto do email        |     sim     |
| Corpo da requisição |   body   |           Corpo do email           |     sim     |

#### Corpo de exemplo

```json
{
    "to": "Email do destinatário",
    "subject": "Assunto do email",
    "body": "Corpo do email",
}
```
#### Resposta - HTTP 200 (OK)
