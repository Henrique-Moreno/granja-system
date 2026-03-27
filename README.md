# 🐔 granja-system – Sistema de Controle de Animais (Granja)

O **granja-system** é uma API RESTful desenvolvida para o gerenciamento completo de criação de aves em ambiente de granja. O sistema permite o controle do ciclo produtivo, abrangendo o cadastro de lotes de animais, o acompanhamento da produção diária de ovos e o registro de vendas com atualização automática de estoque.

O sistema foi construído com **Java e Spring Boot**, seguindo boas práticas de arquitetura em camadas e persistência de dados com **MongoDB Atlas**.

---

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.5.13
- Spring Web
- Spring Data MongoDB
- Bean Validation
- Lombok
- Spring Boot DevTools
- MongoDB Atlas (AWS São Paulo)
- Maven

---

## 🏗️ Arquitetura do Sistema

O projeto segue a **arquitetura em camadas por módulo**, promovendo organização, escalabilidade e fácil manutenção:

| Camada | Responsabilidade |
|--------|-----------------|
| Controller | Exposição dos endpoints REST |
| Service | Regras de negócio |
| Repository | Comunicação com o MongoDB |
| Entities | Documentos mapeados no banco |

---

## 📂 Estrutura de Pastas
```text
src/main/java/com/granja/system
├── modules
│   ├── animal
│   │   ├── controller
│   │   ├── service
│   │   ├── repository
│   │   └── entities
│   ├── producao
│   │   ├── controller
│   │   ├── service
│   │   ├── repository
│   │   └── entities
│   └── venda
│       ├── controller
│       ├── service
│       ├── repository
│       └── entities
└── GranjaSystemApplication.java
```

---

## ⚙️ Como Configurar e Executar

### Pré-requisitos
- Java 17 ou superior
- Maven 3.8+
- Conta no [MongoDB Atlas](https://mongodb.com/atlas) (gratuita)
- IntelliJ IDEA ou outra IDE Java

### 1. Clone o repositório
```bash
git clone https://github.com/granja-system.git
```

### 2. Configure o MongoDB Atlas
1. Crie um cluster gratuito no MongoDB Atlas
2. Crie um usuário em **Database Access**
3. Libere o IP em **Network Access** → `0.0.0.0/0`
4. Copie a URI de conexão em **Connect → Drivers**

### 3. Configure o application.properties
Abra o arquivo `src/main/resources/application.properties` e substitua com seus dados:
```properties
spring.application.name=granja-system

spring.data.mongodb.uri=mongodb+srv://SEU_USERNAME:SUA_SENHA@granja-cluster.ia8cm6i.mongodb.net/granja_db?retryWrites=true&w=majority&appName=granja-cluster

spring.data.mongodb.database=granja_db
```

### 4. Execute o projeto
Abra o projeto no IntelliJ IDEA e execute a classe `GranjaSystemApplication.java`.

O sistema estará disponível em: `http://localhost:8080`

---

## 📋 Endpoints Disponíveis

### 🐓 Animais
| Método | URL | Descrição |
|--------|-----|-----------|
| POST | `/animais` | Cadastrar animal |
| GET | `/animais` | Listar todos |
| GET | `/animais/{id}` | Buscar por ID |
| GET | `/animais/tipo/{tipo}` | Filtrar por tipo |
| GET | `/animais/idade/{idade}` | Filtrar por idade |
| GET | `/animais/data/{data}` | Filtrar por data de entrada |
| PUT | `/animais/{id}` | Atualizar animal |
| DELETE | `/animais/{id}` | Remover animal |

### 🥚 Produções
| Método | URL | Descrição |
|--------|-----|-----------|
| POST | `/producoes` | Registrar produção |
| GET | `/producoes` | Listar todas |
| GET | `/producoes/{id}` | Buscar por ID |
| GET | `/producoes/data/{data}` | Filtrar por data |
| GET | `/producoes/animal/{idAnimal}` | Filtrar por animal |
| PUT | `/producoes/{id}` | Atualizar produção |
| DELETE | `/producoes/{id}` | Remover produção |

### 💰 Vendas
| Método | URL | Descrição |
|--------|-----|-----------|
| POST | `/vendas` | Registrar venda |
| GET | `/vendas` | Listar todas |
| GET | `/vendas/{id}` | Buscar por ID |
| GET | `/vendas/tipo/{tipo}` | Filtrar por tipo |
| GET | `/vendas/data/{data}` | Filtrar por data |
| PUT | `/vendas/{id}` | Atualizar venda |
| DELETE | `/vendas/{id}` | Remover venda |

---

## 🗄️ Banco de Dados

- **Tipo:** NoSQL orientado a documentos
- **Banco:** MongoDB Atlas
- **Região:** AWS São Paulo (sa-east-1)
- **Coleções:** `animais`, `producoes`, `vendas`

---

## 📄 Licença

Este projeto está licenciado sob a MIT License.
