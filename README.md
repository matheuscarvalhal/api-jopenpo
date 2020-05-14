# Desafio jokenpô

##  Introdução
Essa API foi desenvolvida para simular uma brincadeira jokenpô, onde os jogadores poderão adicionar, remover
jogadas(PEDRA, PAPEL, TESOURA, LAGARTO, SPOCK) e jogadores.

##  Arquitetura Java
A aplicação usa Spring Boot.

O código se organiza em 3 camadas:

1. common, responsável pelas as entidades, negócios e classes de configuração, utils, enums.
2. services, responsável pelo serviços de alto nível para consulta com os objetos de transferência de dados.
3. controller, responsável pelo o recebimento das requisições do client.

##  Swagger

Para poder utiliza API de maneira mais clara, foi configurado o swagger (http://localhost:8080/swagger-ui.html)

```