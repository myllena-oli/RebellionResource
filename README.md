# RebellionResource

# Sistema de Gerenciamento de Rebeldes

Este é um aplicativo Java Spring Boot para gerenciar rebeldes em um mundo pós-apocalíptico. Os rebeldes podem ser adicionados, suas localizações atualizadas, itens comprados e traidores reportados. O sistema também fornece estatísticas sobre a porcentagem de traidores e rebeldes leais.

## Sumário

- [Iniciando](#iniciando)
- [Endpoints](#endpoints)
- [Modelo de Dados](#modelo-de-dados)
- [Serviço](#serviço)
- [Repositório](#repositório)

## Iniciando

Para executar este aplicativo localmente, siga estas etapas:

1. Clone este repositório:

   ```shell
   git clone https://github.com/seu-nome/gerenciamento-rebeldes.git
   cd gerenciamento-rebeldes
   ```

2. Verifique se você tem o Java 8 ou superior instalado no seu sistema.

3. Compile e execute o aplicativo:

   ```shell
   ./mvnw spring-boot:run
   ```

   O aplicativo será iniciado em `http://localhost:8090`.

## Endpoints

### Adicionar um Rebelde

- **Endpoint**: `POST /rebelde`
- **Descrição**: Adicione um novo rebelde ao sistema.
- **Corpo da Requisição**: Representação JSON do rebelde.
- **Resposta**: O rebelde criado.

### Listar Rebeldes

- **Endpoint**: `GET /rebelde`
- **Descrição**: Obtenha uma lista de todos os rebeldes no sistema.
- **Resposta**: Matriz JSON de objetos rebeldes.

### Atualizar Localização do Rebelde

- **Endpoint**: `PUT /rebelde/{id}`
- **Descrição**: Atualize a localização de um rebelde.
- **Parâmetro do Caminho**: `id` - ID do rebelde a ser atualizado.
- **Corpo da Requisição**: Nova localização como uma string.
- **Resposta**: O rebelde atualizado.

### Reportar Traidor

- **Endpoint**: `PUT /rebelde/atualizar-traidor/{id}`
- **Descrição**: Denuncie um rebelde como traidor.
- **Parâmetro do Caminho**: `id` - ID do rebelde a ser denunciado.
- **Resposta**: O rebelde denunciado com o status de traidor atualizado.

### Calcular a Porcentagem de Traidores

- **Endpoint**: `GET /rebelde/porcentagem-traidores`
- **Descrição**: Calcule a porcentagem de traidores entre todos os rebeldes.
- **Resposta**: Porcentagem como um valor decimal.

### Calcular a Porcentagem de Rebeldes

- **Endpoint**: `GET /rebelde/porcentagem-rebeldes`
- **Descrição**: Calcule a porcentagem de rebeldes leais entre todos os rebeldes.
- **Resposta**: Porcentagem como um valor decimal.

### Comprar Item

- **Endpoint**: `PUT /rebelde/atualizar-inventario/{id}`
- **Descrição**: Permita que um rebelde compre um item.
- **Parâmetro do Caminho**: `id` - ID do rebelde que está fazendo a compra.
- **Parâmetros da Requisição**: `item` - Nome do item a ser comprado, `quantidade` - Quantidade do item a ser comprado.
- **Resposta**: Mensagem de sucesso se a compra for bem-sucedida ou uma mensagem de falha se falhar.

## Modelo de Dados

### Rebelde

- Atributos:
  - `id`: Long (Auto-gerado)
  - `nome`: String
  - `idade`: int
  - `gênero`: String
  - `localização`: String
  - `carteira`: Double
  - `traidor`: boolean
  - `denúncias`: int
  - `inventario`: Lista de Inventario

### Inventario

- Atributos:
  - `id`: Long (Auto-gerado)
  - `nome`: String
  - `quantidade`: int
  - `rebelde`: Rebelde (Relacionamento Many-to-One)

## Serviço

A classe `RebeldeService` contém a lógica de negócios para gerenciar rebeldes, incluindo a adição de rebeldes, atualização de suas localizações, denúncia de traidores, cálculo das porcentagens de traidores e rebeldes leais, e o processamento de compras de itens.

## Repositório

- `RebeldeRepository`: Repositório JPA para gerenciar entidades Rebelde.
- `InventarioRepository`: Repositório JPA para gerenciar entidades Inventario.
