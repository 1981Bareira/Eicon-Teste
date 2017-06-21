Configurações da base de dados

criar o schema utilizando:


CREATE SCHEMA `pedidos`;

Criar um novo usuario utilizando:

CREATE USER 'root'@'password' IDENTIFIED BY 'root';

Conceder permissões ao usuario utilizando:


GRANT SELECT, INSERT, DELETE, CREATE, ALTER, DROP ON *.* TO 'root'@'password';
FLUSH PRIVILEGES;

Criar a tabela Pedidos

CREATE TABLE pedidos
(
   nr_controle bigint PRIMARY KEY NOT NULL,
   dt_registro timestamp,
   id_cli bigint,
   nome_produto varchar(255),
   qtde int,
   vlr_produto decimal(19,2),
   vlr_total decimal(19,2)
)
;
CREATE UNIQUE INDEX PRIMARY ON pedidos(nr_controle)
;


para compilar e rodar a aplicação utilize


   mvn clean package spring-boot:run


para buscar todos os pedidos utilize: 


Metodo **GET**
/pedidos


para buscar um pedido dado seu número de controle utilize: 


Metodo **GET**
/pedido/{id}


para compilar e rodar a aplicação utilize


Metodo **POST**
/save
e coloque no **body** da chamada o JSON como no exemplo abaixo: 


JSON de teste: 


[	
	{  
      "nrControle":9,
      "dtRegistro" : "23-12-2012",
      "nomeProduto":"Teste",
      "valorProduto":100.00,
      "idCli":10,
      "quantidade" : 5,
      "valorTotal":10000
      
    }
      ,
    {  
      "nrControle":10,
      "dtRegistro" : "23-12-2012",
      "nomeProduto":"Teste",
      "valorProduto":100.00,
      "idCli":10,
      "quantidade" : 5,
      "valorTotal":10000
      
    }
 ]  
