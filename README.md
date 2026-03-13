# Open Finance - Core Engine 🏦🚀

Este projeto simula o motor lógico e de processamento principal de um ecossistema Open Finance. O foco principal é a construção de um backend altamente escalável capaz de ingerir, normalizar e processar grandes volumes de dados transacionais provenientes de múltiplas instituições financeiras de forma assíncrona.

## 🏗️ Arquitetura

O projeto foi desenhado utilizando **Arquitetura Hexagonal (Ports and Adapters)** para garantir que o *Core Domain* (regras de negócio de processamento e consolidação de dados) fique completamente isolado das complexidades de infraestrutura, como conectores de APIs bancárias externas e sistemas de mensageria.

## 🛠️ Stack Tecnológica

* **Linguagem:** Java (Spring Boot)
* **Mensageria:** Apache Kafka (Processamento assíncrono e event-driven)
* **Banco de Dados:** PostgreSQL / H2
* **Infraestrutura:** Docker & Docker Compose (Containerização)

## ⚙️ Como executar o projeto localmente

Pré-requisitos: Ter o [Docker](https://www.docker.com/products/docker-desktop) instalado e rodando na sua máquina.

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/seu-usuario/openfinance-core.git](https://github.com/seu-usuario/openfinance-core.git)
   cd openfinance-core