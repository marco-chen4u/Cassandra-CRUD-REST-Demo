# Cassandra-CRUD-REST-Demo
Cassandra CRUD Demo by REST, it's a Spring Boot Data Cassandra tech stack

Demostrate How to use Partition Key and Clustering Key from the model objects, DAOs, services and controllers.

* In controllers, the are introduced by Swagger functionality, so to get more easier for testing.

* It also provides some data source sample for your database(aka keyspace in cassandra) to run in CQL import them.

* Swagger functionality

## Setting up
### Cassandra
Requirement : Ubuntu Server 18.04, AWS free tire instance

## Cassandra installation guide
please read [AWS-Ubuntu-Cassandra-cluster setting up](https://bit.ly/2NiolAN)

## Database and table import
### database creation
Login to the cassandra linux environment  
ubuntu@aws-cassandra-1:~$ cqlsh  
cqlsh\> SOURCE 'file-path/database_tables_creation.cql'  
...  
cqlsh\> use demo_key_space ;   
cqlsh:demo_key_space\>  
please see section of Questions for review and knowledge to know in [AWS-Ubuntu-Cassandra-cluster setting up](https://bit.ly/2NiolAN)
* this [database_tables_creation.cql](.//database-data-sample/database_tables_creation.cql) could be found in the file folder of database-data-sample  

### table data import
please see section of Questions for review and knowledge to know in [AWS-Ubuntu-Cassandra-cluster setting up](https://bit.ly/2NiolAN)  

## API testing
open web browser access http://127.0.0.1:9201/swagger-ui.html#/  
### RESTFUL API
[RESTFULI api](.//image/swagger-test1.png)  

### User Controller API
[User Controller api](.//image/swagger-test-user-controller.png)  

### Vehicle Tracker Controller API
[Vehicle Tracker Controller api](.//image/swagger-test-vehicle-tracker-controller.png)
