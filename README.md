# MOVIEFLIX

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/jefferson1995/movieFlix/blob/main/LICENSE.txt) 

# Sobre o projeto


O sistema MovieFlix consiste em um banco de filmes, os quais podem ser listados e avaliados pelos usuários. Usuários podem ser visitantes (VISITOR) e membros (MEMBER). Apenas usuários membros podem inserir avaliações no sistema.

Ao acessar o sistema, o usuário deve fazer seu login. Apenas usuários logados podem navegar nos filmes. Logo após fazer o login, o usuário vai para a listagem de filmes, que mostra os filmes de forma paginada, ordenados alfabeticamente por título. O usuário pode filtrar os filmes por gênero.

Ao selecionar um filme da listagem, é mostrada uma página de detalhes, onde é possível ver todas informações do filme, e também suas avaliações. Se o usuário for MEMBER, ele pode ainda registrar uma avaliação nessa tela.

Um usuário possui nome, email e senha, sendo que o email é seu nome de usuário. Cada filme possui um título, subtítulo, uma imagem, ano de lançamento, sinopse, e um gênero. Os usuários membros podem registrar avaliações para os filmes. Um mesmo usuário membro pode deixar mais de uma avaliação para o mesmo filme.

	Domínio e ORM
- 	Implementação de um modelo de domínio complexo (projeto movieFlix)
-	Autorizações
-	Autorização customizada em nível de serviço
-	Conteúdo customizado para o usuário logado
-	Refresh token
-	Pré-autorização de métodos


## Layout web
![Web 1](https://github.com/jefferson1995/movieFlix/blob/main/Assets/web1.png)
![Web 1](https://github.com/jefferson1995/movieFlix/blob/main/Assets/web2.png)
![Web 1](https://github.com/jefferson1995/movieFlix/blob/main/Assets/web3.png)

## Design Figma

https://www.figma.com/file/qmduL2GXrMrqRLyFjFCk56/MovieFlix-web

# Tecnologias utilizadas
## Back end

- Java
- Spring Boot
- Sprring security
- OAuth2
- JWT refresh token
- Junit 5
- TDD
- JPA / Hibernate
- Maven
- H2 banco de dados


# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/jefferson1995/movieFlix

# entrar na pasta do projeto back end
cd backend

# executar o projeto
./mvnw/wrapper spring-boot:run
```



# Autor

Jefferson Barbosa dos Santos

https://www.linkedin.com/in/jefferson-barbosa-225349149/
