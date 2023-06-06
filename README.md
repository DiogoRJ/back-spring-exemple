Como rodar o projeto:

- Ter jdk ou jre instalada (java 11)
- Clonar o projeto para a sua máquina<br/>
  ``` bash 
  git clone https://github.com/DiogoRJ/back-spring-exemple.git
  ```
- Ter instalado o Docker
  - Inicializar kafka e mongodb no docker, dentro da pasta /docker do projeto:
    - comando p/ rodar kafka pelo terminal:
      ``` bash 
      docker-compose -f kafka-docker-compose.yml up -d 
      ```
    - comando p/ rodar mongodb pelo terminal:
      ``` bash 
      docker-compose -f mongodb-docker-compose.yml up -d 
      ```
- Ter uma ide para rodar o projeto pela classe main BackExempleApplication
- Acessar a rota http://localhost:8081 e testar a api
