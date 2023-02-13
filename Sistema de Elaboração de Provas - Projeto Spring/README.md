# Sobre o projeto
## Arquitetura
* Segue a arquitetura MVP, ou seja, **para cada View, há um Presenter**. Além disso utiliza-se dos frameworks **Vaadin e Spring (boot, security e data).**
* O front-end, cadama View, é feito utilizando páginas web **HTML, CSS e Javascript**, criadas por classes java escritas pelo desenvolvedor graças ao [Vaadin](https://vaadin.com)
* A lógica de aplicação e camada **Presenter**, são feitas em Java e potencializadas com os frameworks já mencionados.
* A persistência de dados é feita em duas camadas, a parte de acesso, e a parte do Banco de Dados propriamente dita.
  * Para o CRUD e ORM foram utilizadas as tecnologias **Spring Data JPA e Hibernate**, evitando sempre utilizar somente a especificação Hibernate.
  * Para a Persistência propriamente dita, o SGBD escolhido foi o **PostgreSQL**, banco relacional e o qual os programadores tinham maior familiaridade.
* Nota: o projeto foi feito para rodar localmente, mas é perfeitamente configurável para ser lançado na web.
## Mais documentações
* Todos os artefatos estão presentes em [Artefatos do projeto.](https://github.com/JoaoUFG/portifolio/tree/main/Sistema%20de%20Elabora%C3%A7%C3%A3o%20de%20Provas/Artefatos%20do%20Projeto)

# Requisitos para executar o projeto
* Ter o PostgreSQL instalado. Recomendo [baixar o pgAdmin](https://www.postgresql.org/ftp/pgadmin/pgadmin4/), pois na sua intalação ele já insere o PostgreSQL na sua máquina
* A máquina ter o necessário para compilar e executar códigos java, ou seja, [ter o JDK instalado.](https://www.oracle.com/java/technologies/downloads/#jdk19-windows)
* Uma conexão com a internet ( caso utilize um servidor proxy, deve-se configurar o proxy no terminal dentro da pasta do projeto).
# Executando o projeto
* Crie um servidor de banco de dados no localhost pelo pgAdmin e coloque na porta 5432
* Crie um banco de dados de nome 'sep', não é necessária a criação de um Schema, o sistema já criara um padrão (o Public).
* Vá em src/main/resources/application.properties, pela linha 17, em spring.datasource.password, e insira após o '=' a senha do seu PostgreSQL ( colocada no momento da instalação do mesmo)
* Clone o repositório em sua máquina, utilizando o _git clone https://github.com/JoaoUFG/portifolio_
* Entre na pasta Sitema de Elaboração de Provas-> SEP, abra o terminal nela e digite 'mvnw' (sem as aspas), caso não dê, digite './mvnw' (sem as aspas).
* Aguarde, se tudo der certo, o maven irá baixar **todas** as dependência do proejto, esse processo pode demorar bastante. (10 a 15 minutos)
* Quando abrir, coloque como CPF '999', e como login 'ooo'. Para consultar os outros logins e senhas, basta acessar a table de Cadastro no banco de dados.
* Nota: a criação de contas não estava presente no escopo, pois a tabela de Cadastros seria populada por outro banco de dados ( o do Instituto Verbena ), os quais já possuiriam mais de 500 tuplas.
