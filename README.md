# Cassandra-CRUD-REST-Demo
Cassandra CRUD Demo by REST, it's a Spring Boot Data Cassandra tech stack

Demostrate How to use Partition Key and Clustering Key from the model objects, DAOs, services and controllers.

In controllers, the are introduced by Swagger functionality, so to get more easier for testing.

I also provide some data source sample for your database(aka keyspace in cassandra) to run in CQL import them.

## Setting up
### Cassandra
Requirement : Ubuntu Server 18.04, AWS free tire instance

## Cassandra installation guide
please read <<AWS-Ubuntu-Cassandra-cluster setting up>>
* this guide document could be found in the file folder of database-data-sample

## Database and table import
###database creation
Login to the cassandra linux environment
ubuntu@aws-cassandra-1:~$ cqlsh
cqlsh> SOURCE 'file-path/database_tables_creation.cql'
...
cqlsh> use demo_key_space ;   
cqlsh:demo_key_space>
please see section of Questions for review and knowledge to know in <<AWS-Ubuntu-Cassandra-cluster setting up>>
* this database_tables_creation.cql could be found in the file folder of database-data-sample
* this guide document could be found in the file folder of database-data-sample

###table data import
please see section of Questions for review and knowledge to know in <<AWS-Ubuntu-Cassandra-cluster setting up>>
* this guide document could be found in the file folder of database-data-sample
