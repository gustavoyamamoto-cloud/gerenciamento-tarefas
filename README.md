# 📌 API de Gerenciamento de Tarefas

API REST desenvolvida com Java e Spring Boot para gerenciamento de tarefas, permitindo criar, listar, atualizar, deletar e filtrar tarefas.

---

## 🚀 Tecnologias utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* Banco de dados H2
* Maven

---

## 📋 Funcionalidades

* ✅ Criar tarefa
* 📄 Listar todas as tarefas
* 🔍 Buscar tarefa por ID
* ✏️ Atualizar tarefa
* ❌ Deletar tarefa
* 🔎 Filtrar tarefas por status (concluída ou não)
* 🔎 Buscar tarefas por título

---

## 📦 Estrutura do Projeto

* **Controller** → Responsável pelas requisições HTTP
* **Service** → Contém as regras de negócio
* **Repository** → Comunicação com o banco de dados
* **DTO** → Transferência de dados (Request/Response)
* **Entity** → Representação da tabela no banco

---

## ▶️ Como executar o projeto

### Clonar o repositório

```bash
git clone https://github.com/gustavoyamamoto-cloud/gerenciamento-tarefas.git
```

### Entrar na pasta do projeto

```bash
cd gerenciamento-tarefas
```

### Rodar o projeto

```bash
./mvnw spring-boot:run
```

ou

```bash
mvn spring-boot:run
```

---

## 🌐 Endpoints da API

### 🔹 Listar tarefas

```
GET /tarefas
```

### 🔹 Buscar por ID

```
GET /tarefas/{id}
```

### 🔹 Criar tarefa

```
POST /tarefas
```

Exemplo JSON:

```json
{
  "nome": "Estudar Spring Boot",
  "descricao": "Aprender sobre JPA e API REST",
  "concluida": false
}
```

### 🔹 Atualizar tarefa

```
PUT /tarefas/{id}
```

### 🔹 Deletar tarefa

```
DELETE /tarefas/{id}
```

### 🔹 Filtrar por status

```
GET /tarefas/status/{status}
```

### 🔹 Buscar por título

```
GET /tarefas/titulo/{texto}
```

---

## 🧪 Banco de Dados H2

Acesse o console do H2:

```
http://localhost:8080/h2-console
```

Configurações padrão:

* JDBC URL: `jdbc:h2:mem:testdb`
* User: `sa`
* Password: (vazio)

---

## 💡 Melhorias futuras

* [ ] Adicionar validação com Bean Validation
* [ ] Implementar paginação
* [ ] Documentação com Swagger
* [ ] Tratamento global de exceções
* [ ] Autenticação com Spring Security

---

## 👨‍💻 Autor

Desenvolvido por **Gustavo de Souza Yamamoto**

---

## 📌 Observação

Este projeto foi desenvolvido para fins de estudo e prática de desenvolvimento backend com Spring Boot.

