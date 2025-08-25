# 🛒 API de Gerenciamento de Produtos e Usuários 

API para gerenciamento de produtos e usuários, desenvolvida com o objetivo de praticar o essencial para o desenvolvimento de APIs RESTful com **Spring Boot**.

---

## ⚙️ Tecnologias Utilizadas

- **Spring Boot**
  - **Spring Data JPA**
  - **Spring Security**
- **JWT (Authentication)**
- **PostgreSQL**
- **Lombok**

---

## 🛠️ Funcionalidades da API

Essa API permite:

- ✅ Registrar usuários
- ✅ Autenticar usuários
- ✅ Criar produtos
- ✅ Listar produtos
- ✅ Buscar produto por ID
- ✅ Deletar produtos
- ✅ Proteção de rotas
- ✅ Tratamento de exceções e padrões de resposta 

---

## Como Executar

1. Clone o repositório:

2. Acesse a pasta do projeto:

```bash
# Configure o application.properties para conexão com o banco PostgreSQL
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

# Execute o projeto
./mvnw spring-boot:run
```

3. Acesse a API pelo Insomnia ou Postman:
   
Para interagir com a API, você precisará se autenticar e incluir o token de acesso em todas as requisições. Lembre-se de passar o token no header da requisição, geralmente no formato `Authorization: Bearer <seu_token>`.

```bash
http://localhost:8080/api/produtos

# ou

http://localhost:8080/api/auth

```

---
