Claro, aqui está o conteúdo completo em formato Markdown:

```markdown
# PharmacyApi

Bem-vindo ao repositório PharmacyApi! Este projeto é uma API REST desenvolvida com Spring Boot para gerenciar informações de farmácias.

## Funcionalidades

- Cadastro de usuários com senha criptografada usando Bcrypt.
- Operações CRUD para farmácias.
- Outras funcionalidades específicas do seu projeto.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Bcrypt
- MySQL (ou outro banco de dados de sua escolha)

## Pré-requisitos

- Java 8 ou superior
- Maven
- MySQL (ou outro banco de dados)

## Configuração do Banco de Dados

1. Configure as propriedades do banco de dados no arquivo `application.properties`.

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco_de_dados
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.show-sql=true
   spring.jpa.hibernate.ddl-auto=update
   ```

   Substitua as informações do banco de dados conforme necessário.

## Como Executar

1. Clone o repositório.

   ```bash
   git clone https://github.com/EduBarrros/PharmacyApi.git
   ```

2. Navegue até o diretório do projeto.

   ```bash
   cd PharmacyApi
   ```

3. Execute o aplicativo.

   ```bash
   mvn spring-boot:run
   ```

   O aplicativo será iniciado em http://localhost:8080.

## Rotas da API

A API possui os seguintes endpoints:

### 1. Registro de Usuário

- **URL:** `/auth`
- **Método:** `POST`
- **Descrição:** Endpoint para registrar um novo usuário na API.
- **Corpo da Requisição:**
  ```json
  {
    "username": "seu_nome_de_usuario",
    "password": "sua_senha"
  }
  ```

#### 1.1 Realizar Login

- **URL:** `/auth/login`
- **Método:** `Post`
- **Descrição:** Endpoint para logar um usuário na aplicação e receber um token.
- **Corpo da Requisição:**
  ```json
  {
    "username": "seu_nome_de_usuario",
    "password": "sua_senha"
  }
  ```

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues, enviar pull requests ou fornecer feedback.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).
```
