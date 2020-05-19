# Jokenpo multiplayer

Tecnologias:
Java
Spring Boot
Arquitetura Rest Api
Junit
Maven
Json

Serviços Jogar e salva em um arquivo txt
POST - http://localhost:8080/jogada/jogar

[
    { "id": 1, "jogador": { "nome": "Diogo" }, "jokenpoItem": "PAPEL" },
    { "id": 2, "jogador": { "nome": "Miguel" }, "jokenpoItem": "tesoura" },
    { "id": 4, "jogador": { "nome": "Pedro" }, "jokenpoItem": "PAPEL" }
]

Excluir Jogada
DELETE - http://localhost:8080/jogada/1

Buscar todas Jogada
GET - http://localhost:8080/jogada

Salvar Jogador
POST - http://localhost:8080/jogador
{ "id": 1, "nome": "Andre Almeida" }

Excluir jogador
DELETE - http://localhost:8080/jogador/1

Buscar todos jogadores
GET - http://localhost:8080/jogador
