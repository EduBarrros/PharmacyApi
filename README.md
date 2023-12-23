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

### 1. Rotas de criação e autenticação de usuário

#### 1.1 Registro de Usuário

- **URL:** `/auth/register`
- **Método:** `POST`
- **Descrição:** Endpoint para registrar um novo usuário na API.
- **Corpo da Requisição:**
  ```json
  {
    "username": "seu_nome_de_usuario",
    "password": "sua_senha"
  }
  ```

#### 1.2 Realizar Login

- **URL:** `/auth/login`
- **Método:** `POST`
- **Descrição:** Endpoint para logar um usuário na aplicação e receber um token.
- **Corpo da Requisição:**
  ```json
  {
    "username": "seu_nome_de_usuario",
    "password": "sua_senha"
  }
  ```

### 2. Rotas de registro, atualização, listagem, desativação/ativação e deleção de remédios.

#### 2.1 Registro de remédio

- **URL:** `/remedy`
- **Método:** `POST`
- **Descrição:** Endpoint para registrar um novo remédio.
- **Corpo da Requisição:**
  ```json
  {
  	 "nome": "nome_do_remedio",
	 "via": "via_do_remedio",
	 "lote": "lote_do_remedio",
	 "quantidade": quantidade_do_remedio,
	 "validade": "data_de_vencimento_do_remedio",
	 "laboratorio": "laboratorio_do_remedio"
  }
  ```

#### 2.2 Atualização de remédio

- **URL:** `/remedy`
- **Método:** `PUT`
- **Descrição:** Endpoint para atualizar um remédio.
- **Corpo da Requisição:**
  ```json
  {
  	 "nome": "nome_do_remedio",
	 "via": "via_do_remedio",
	 "lote": "lote_do_remedio",
	 "quantidade": quantidade_do_remedio,
	 "validade": "data_de_vencimento_do_remedio",
	 "laboratorio": "laboratorio_do_remedio"
  }
  ```

#### 2.3 Listagem de remédio

- **URL:** `/remedy`
- **Método:** `GET`
- **Descrição:** Endpoint para listar remédios.
- 

#### 2.4 Busca de remédio por Id

- **URL:** `/remedy/{id}`
- **Método:** `GET`
- **Descrição:** Endpoint para listar remédios.
- **Propriedade:** id do remédio.

#### 2.5 Desativação de remédio por Id

- **URL:** `/remedy/disable/{id}`
- **Método:** `PUT`
- **Descrição:** Endpoint para desativar remédio.
- **Propriedade:** id do remédio.

#### 2.6 Ativação de remédio por Id

- **URL:** `/remedy/eneble/{id}`
- **Método:** `PUT`
- **Descrição:** Endpoint para ativar remédio.
- **Propriedade:** id do remédio.

#### 2.7 Deleção de remédio

- **URL:** `/remedy/{id}`
- **Método:** `DELETE`
- **Descrição:** Endpoint para listar remédios.
- **Propriedade:** id do remédio.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues, enviar pull requests ou fornecer feedback.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).
