AWS-Ubuntu-Cassandra-cluster setting up

System Requirement

Ubuntu Server 18.04

Setting up steps

step[1]

Update, Upgrade and Restart the instances

$ sudo apt update

$ sudo apt upgrade -y

Change the current hosting machine name, so as to make it easy for DevOps

$ sudo hostname aws-cassandra-1

$ sudo vi /etc/hostname

aws-cassandra-1

You may need to reboot instance

step[2]

Install Jdk 8

sudo apt install openjdk-8-jre-headless

Install Python

sudo apt install python

check the Java and Pyton env

java -version

python --version

step[3]

make the jdk env and make it working effect

vi ~/.bashrc

--------------------------------------------------------------

# Java env variables

export JAVA\_HOME=/usr/lib/jvm/java-8-openjdk-amd64

export JRE\_HOME=$JAVA\_HOME/jre

export PATH=$PATH:$JAVA\_HOME/bin:$JAVA\_HOME/jre/bin

# Cassandra env vairable

export CASSANDRA\_HOME=/home/ubuntu/opt/apache-cassandra-3.11.3

export CASSANDRA\_RE=$CASSANDRA\_HOME/bin

export PATH=$PATH:$CASSANDRA\_RE

--------------------------------------------------------------

:wq

source ~/.bashrc

step[4]

install cassandra

mkdir opt

cd opt/

wget[http](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[://](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[archive](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[.](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[apache](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[.](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[org](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[/](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[dist](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[/](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[cassandra](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[/3.11.3/](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[apache](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[-](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[cassandra](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[-3.11.3-](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[bin](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[.](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[tar](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[.](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[gz](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)

chmod 777 apache-cassandra-3.11.3-bin.tar.gz

tar -xvf apache-cassandra-3.11.3-bin.tar.gz

--------------------------------------------------------------

ubuntu@ip-172-31-19-217:~$ mkdir opt

ubuntu@ip-172-31-19-217:~$ cd opt/

ubuntu@ip-172-31-19-217:~/opt$ pwd

/home/ubuntu/opt

ubuntu@ip-172-31-19-217:~/opt$wget[http](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[://](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[archive](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[.](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[apache](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[.](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[org](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[/](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[dist](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[/](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[cassandra](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[/3.11.3/](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[apache](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[-](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[cassandra](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[-3.11.3-](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[bin](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[.](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[tar](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[.](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)[gz](http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz)

--2019-12-29 05:30:24--  http://archive.apache.org/dist/cassandra/3.11.3/apache-cassandra-3.11.3-bin.tar.gz

Resolving archive.apache.org (archive.apache.org)... 163.172.17.199

Connecting to archive.apache.org (archive.apache.org)|163.172.17.199|:80... connected.

HTTP request sent, awaiting response... 200 OK

Length: 37317433 (36M) [application/x-gzip]

Saving to: &#39;apache-cassandra-3.11.3-bin.tar.gz&#39;

apache-cassandra-3.11.3-bin.tar.gz                 100%[================================================================================================================\&gt;]  35.59M  9.44MB/s    in 4.7s

2019-12-29 05:30:29 (7.57 MB/s) - &#39;apache-cassandra-3.11.3-bin.tar.gz&#39; saved [37317433/37317433]

ubuntu@ip-172-31-19-217:~/opt$ chmod 777 apache-cassandra-3.11.3-bin.tar.gz

ubuntu@ip-172-31-19-217:~/opt$ tar -xvf apache-cassandra-3.11.3-bin.tar.gz

--------------------------------------------------------------

step[5]

modify the configuration file-cassandra.yml

check current-cluster node for seeding  ip = 172.31.31.29

current ip address = 172.31.31.29

--------------------------------------------------------------

**(1)listening brocasting address**

listen\_address: 172.31.31.29

**(2)rpc setting**

start\_rpc: true

rpc\_address:172.31.31.29

**(3)seeding node address**

seed\_provider:

   # Addresses of hosts that are deemed contact points.

   # Cassandra nodes use this list of hosts to find each other and learn

   # the topology of the ring.  You must change this if you are running

   # multiple nodes!

   - class\_name: org.apache.cassandra.locator.SimpleSeedProvider

     parameters:

         # seeds is actually a comma-delimited list of addresses.

         # Ex: &quot;\&lt;ip1\&gt;,\&lt;ip2\&gt;,\&lt;ip3\&gt;&quot;

         - seeds: &quot;172.31.31.29&quot;

(3)

data\_file\_directories:

       - /var/lib/cassandra/data

\*if need for fault tolerant we need to configure the last one parameter

(4)cassandra.override\_decommission=true

vi /home/ubuntu/opt/apache-cassandra-3.11.3/conf/jvm.options

-Dcassandra.override\_decommission=true

-Dcassandra.ignore\_dc=true

:wq

ubuntu@ip-172-31-19-217:/var$ sudo mkdir /var/lib/cassandra

ubuntu@ip-172-31-19-217:/var$ sudo mkdir /var/log/cassandra

ubuntu@ip-172-31-19-217:/var$ sudo chown -R ubuntu:ubuntu /var/log/cassandra/

ubuntu@ip-172-31-19-217:/var$ sudo chown -R ubuntu:ubuntu /var/lib/cassandra/

--------------------------------------------------------------

step[6]

starting cassandra

/home/ubuntu/opt/apache-cassandra-3.11.3/bin/cassandra  # runing in backgound /daemon   -di

**reference for starting and stopping process**

/home/ubuntu/opt/apache-cassandra-3.11.3/bin/cassandra -f  # forground runing -it

ubuntu@ip-172-31-19-217:~/opt/apache-cassandra-3.11.3/bin$ ps -ef |grep cassandra | awk &#39;{print $2}&#39;|xargs kill -9

step[7]

checking status

ubuntu@ip-172-31-19-217:~/opt/apache-cassandra-3.11.3/bin$ ./nodetool status

ubuntu@ip-172-31-19-217:~/opt/apache-cassandra-3.11.3/bin$ ./nodetool info

ubuntu@ip-172-31-19-217:~/opt/apache-cassandra-3.11.3/bin$ ./nodetool ring

--------------------------------------------------------------

ubuntu@ip-172-31-19-217:~/opt/apache-cassandra-3.11.3/bin$ ./nodetool status

Datacenter: datacenter1

=======================

Status=Up/Down

|/ State=Normal/Leaving/Joining/Moving

--  Address        Load       Tokens       Owns (effective)  Host ID                               Rack

UN  172.31.19.217  213.92 KiB  256          100.0%            4cbfea34-8c36-4f28-8e38-06998e98c33a  rack1

--------------------------------------------------------------

step[8]

Using Cqlsh

sudo apt install python

create cassandra env variables

vim ~/.bashrc

# Java env variables

export JAVA\_HOME=/usr/lib/jvm/java-8-openjdk-amd64

export JRE\_HOME=$JAVA\_HOME/jre

export PATH=$PATH:$JAVA\_HOME/bin:$JAVA\_HOME/jre/bin

# Cassandra env vairable

export CASSANDRA\_HOME=/home/ubuntu/opt/apache-cassandra-3.11.3

export CASSANDRA\_RE=$CASSANDRA\_HOME/bin

export PATH=$PATH:$CASSANDRA\_RE

:wq

ubuntu@ip-172-31-19-217:~$source .bashrc

Last login: Sun Dec 29 16:05:46 2019 from 65.79.148.44

ubuntu@ip-172-31-19-217:~$ cqlsh

Connected to Test Cluster at 172.31.19.217:9042.

[cqlsh 5.0.1 | Cassandra 3.11.3 | CQL spec 3.4.4 | Native protocol v4]

Use HELP for help.

cqlsh\&gt; exit

ubuntu@ip-172-31-19-217:~$ nodetool describecluster

Cluster Information:

        Name: Test Cluster

        Snitch: org.apache.cassandra.locator.SimpleSnitch

        DynamicEndPointSnitch: enabled

        Partitioner: org.apache.cassandra.dht.Murmur3Partitioner

        Schema versions:

                ea63e099-37c5-3d7b-9ace-32f4c833653d: [172.31.19.217]

step[9]

clusting setting up

------------------------------------------------------------------------

name                            internal ip                              public ip                    memo

aws-cassandra-1        172.31.16.221                         34.222.47.188             node-1

aws-cassandra-2        172.31.27.250                        54.190.1.126                node-2

aws-cassandra-3        172.31.29.45                          18.237.81.135              node-3

aws-cassandra-4        172.31.17.176                          34.213.228.242 .         node-4

------------------------------------------------------------------------

starting node1 and make it as a seeding node

node1 has create a database schema-demo\_key\_space

after configured the listen address/rpc\_address = node-2&#39;s ip address, seed host = node-1,starting it up

------------------------------------------------------------------------

ubuntu@aws-cassandra-1:~$ nodetool status

Datacenter: datacenter1

=======================

Status=Up/Down

|/ State=Normal/Leaving/Joining/Moving

--  Address        Load       Tokens       Owns (effective)  Host ID                               Rack

UN  172.31.16.221  192.5 KiB  256          44.6%             ca8009c4-b82b-4640-90a8-7e7c7c7cfc84  rack1        #node-2

UN  172.31.27.250  101.12 KiB  256          55.4%             0c60c6b3-3b6f-4b06-847a-28e801400d85  rack1      #node-1

ubuntu@aws-cassandra-2:~$ cqlsh

Connected to Test Cluster at 172.31.27.250:9042.

[cqlsh 5.0.1 | Cassandra 3.11.3 | CQL spec 3.4.4 | Native protocol v4]

Use HELP for help.

cqlsh\&gt; describe keyspaces;

system\_schema  system          system\_distributed

system\_auth    demo\_key\_space  system\_traces  #we haven&#39;t create any schema before, but now node-2 has got this database (sync)

cqlsh\&gt;

------------------------------------------------------------------------

step[10]

stress test for the cluster and see its status difference

go to node-1

cassandra-stress -d 172.31.16.221 -n 100000            #node-1 ip address = 172.31.16.221

step[11]

change the hostname and the hosts configuration

------------------------------------------------------------------------

name                            internal ip                              public ip                    memo

aws-cassandra-1        172.31.16.221                         34.222.47.188             node-1

aws-cassandra-2        172.31.27.250                        54.190.1.126                node-2

aws-cassandra-3        172.31.29.45                          18.237.81.135              node-3

aws-cassandra-4        172.31.17.176                          34.213.228.242           node-4

aws-cassandra-5        172.31.20.114                          34.217.180.214           node-5

aws-cassandra-6        172.31.19.159                          18.237.248.6               node-6

aws-cassandra-7        172.31.25.17                            54.149.231.142           node-7

//etc/hosts

127.0.0.1      localhost

172.31.16.221  aws-cassandra-1

172.31.27.250  aws-cassandra-2

172.31.29.45   aws-cassandra-3

172.31.17.176  aws-cassandra-4

172.31.20.114  aws-cassandra-5

172.31.19.159  aws-cassandra-6

172.31.25.17   aws-cassandra-7

------------------------------------------------------------------------

step[12]

monitoring

------------------------------------------------------------------------

(1)nodetool

nodetool info

nodetool status

nodetool ring

nodetool cfstats   #column family statistic

nodetool cfhistograms

nodetool compactionstats

(2)jconsole

    cd $JAVA\_HOME/bin/

    ./jconsole &amp;

New Connection - \&gt;

Remote Process: localhost:7199

------------------------------------------------------------------------

Questions for review and knowledge to know

**Q1: How do the monitoring tools communicate with a Cassandra cluster?**

A: JMX

**Q2: After installing Cassandra, the installation of nodetool requires additional steps, is that true?**

A: false, nodetool is a built-in tool in Cassandra

**Q3:once a node is decommission for maintenance, how to put the node back into service?**

A:that means to rejoin the cluster, and since the data is not removed from the node when it is decommissioned(the data is copied to the other nodes, but not removed from the decommissioned node), it is best to clear the data from the decommissioned node, if the node has been down for any length of time, before putting the node back into service.

In general, it is faster to have the node join as a clean one(with no data), rather than have it join with old data that then needs repair.

Once the data has been deleted from the decommissioned node, the node can join as a new node.

To completely remove the data on a Cassandra node ,the data, commitlog, and save\_caches directories need to be cleared.

This can be one on the command line using the **rm** command.

---------------------------------------------------------------------------------

ubuntu@aws-cassandra-4:~$ ps -ef|grep cassandra|awk &#39;{print $2}&#39;|xargs kill -9

ubuntu@aws-cassandra-4:/var/lib/cassandra$ rm -r commitlog data sached\_caches

vi /home/ubuntu/opt/apache-cassandra-3.11.3/conf/jvm.options

-Dcassandra.override\_decommission=true

:wq

ubuntu@aws-cassandra-4:~/opt$cassandra //start it, and put it back to the cluster and service

ubuntu@aws-cassandra-4:~/opt$node tool -h aws-cassandra-1 -p 7199 cleanup

ubuntu@aws-cassandra-3:~$ nodetool -h 127.0.0.1 -p 7199 cleanup      // cleanup each replica nodes[node-1, node-2, node-3]

WARN  19:54:32,925 Small commitlog volume detected at /home/ubuntu/opt/apache-cassandra-3.11.3/data/commitlog; setting commitlog\_total\_space\_in\_mb to 1969.  You can override this in cassandra.yaml

WARN  19:54:32,933 Small cdc volume detected at /home/ubuntu/opt/apache-cassandra-3.11.3/data/cdc\_raw; setting cdc\_total\_space\_in\_mb to 984.  You can override this in cassandra.yaml

WARN  19:54:32,935 Only 5.855GiB free across all data volumes. Consider adding more capacity to your cluster or removing obsolete snapshots

---------------------------------------------------------------------------------

**Q4:What happens when removing a dead node from the cluster behid the scene?**

A: Removing a dead node from the cluster is done to reassign the token ranges that the dead node was responsible for to other nodes in the cluster and to populate other other nodes with the data that the dead node had been responsible for.

To remove a dead node from the cluster, and reassign its token ranges and data, the nodetool removenode command can be used.

**Q5: Why do we need Removing A Node ?**

A: A node may need to be removed from a cluster for a variety of reasons. For example, the capacity might no longer be needed, or a node need hardware maintenance, such as having more memory added, or a node might be down due to hardware failure.

Designed for fault tolerant, Cassandra handles node removal gracefully.

Depending on whether a node is planned for removal or has unexpectedly died, the **nodetool decommission** or **nodetool removenode** commands can be used to handle the node removal.

**nodetool decommission**  command is for a planned removal

**nodetool removenode** command is for a dead node.

---------------------------------------------------------------------------------

ubuntu@aws-cassandra-4:~$ nodetool status

Datacenter: datacenter1

=======================

Status=Up/Down

|/ State=Normal/Leaving/Joining/Moving

--  Address             Load               Tokens       Owns (effective)  Host ID                                                                  Rack

UN  172.31.29.45   497.31 KiB       256            50.0%                 47d7cc1b-bbc8-4fd2-bf75-a225bf5b4fd8       rack1

UN  172.31.16.221  440.61 KiB      256             47.7%                  ca8009c4-b82b-4640-90a8-7e7c7c7cfc84     rack1

UN  172.31.27.250  620.48 KiB     256             54.4%                 0c60c6b3-3b6f-4b06-847a-28e801400d85  rack1

UN  172.31.17.176   360.9 KiB        256             47.9%                  f89358d7-04ea-41b3-8b06-29e552129420   rack1

ubuntu@aws-cassandra-4:~$ nodetool -h 172.31.17.176 -p 7199 decommission

nodetool: Failed to connect to &#39;172.31.17.176:7199&#39; - ConnectException: &#39;Connection refused (Connection refused)&#39;.

ubuntu@aws-cassandra-4:~$ nodetool -h 127.0.0.1 -p 7199 decommission    #node-4 ip address : 172.31.17.176

ubuntu@aws-cassandra-4:~$ nodetool status

Datacenter: datacenter1

=======================

Status=Up/Down

|/ State=Normal/Leaving/Joining/Moving

--  Address              Load              Tokens       Owns (effective)  Host ID                                                                  Rack

UN  172.31.29.45    463.91 KiB     256            66.7%                  47d7cc1b-bbc8-4fd2-bf75-a225bf5b4fd8      rack1

UN  172.31.16.221    440.61 KiB    256            60.2%                  ca8009c4-b82b-4640-90a8-7e7c7c7cfc84    rack1

UN  172.31.27.250   620.48 KiB    256           73.1%                   0c60c6b3-3b6f-4b06-847a-28e801400d85  rack1

ubuntu@aws-cassandra-4:~$

---------------------------------------------------------------------------------

**Q6: What kind of change for replication strategy for a keyspace(aka database), when it is in multiple data center cluster?**

A: In order to specify the number of replicas per data center for a keyspace in a multiple data center cluster, the replication strategy for the keyspace needs to be **NetworkTopologyStrategy**.

The replication strategy for a keyspace can be updated from SimpleStrategy to NetworkTopologyStrategy by using the **ALTER KEYSPACE** command.

---------------------------------------------------------------------------------

ALTER KEYSPACE demo\_key\_space WITH replication = {&#39;class&#39;: &#39;NetworkTopologyStrategy&#39;, &#39;dc1&#39;: **2** , &#39;dc2&#39;: **1** };

---------------------------------------------------------------------------------

#it means how many replicas in each data-center that we need to have.

The number of replicas in each data center does not have to match, and can vary for each keyspace.

**Q7: How to run a \*.cql from in Cassandra CQL env?**

A: cqlsh\&gt; SOURCE &#39;file-path/file-name.cql&#39;

---------------------------------------------------------

root@1f5e7b9ac7f4:/opt/cassandra-data-import# more create\_keyspace\_playground.txt

CREATE KEYSPACE playground WITH replication = {&#39;class&#39;: &#39;SimpleStrategy&#39;, &#39;replication\_factor&#39; : 1};

root@1f5e7b9ac7f4:/opt/cassandra-data-import# more create.cql

USE playground;

CREATE TABLE messages\_by\_user (

sender text,

sent timestamp,

recip text,

body text,

message\_id uuid,

PRIMARY KEY (sender, sent)

) WITH CLUSTERING ORDER BY (sent DESC);

COPY messages\_by\_user (sender, sent, recip, body, message\_id) FROM &#39;/opt/cassandra-data-import/messages.csv&#39; WITH header = true AND delimiter = &#39;|&#39;;

root@1f5e7b9ac7f4:/opt/cassandra-data-import#cqlsh

Connected to Test Cluster at 127.0.0.1:9042.

[cqlsh 5.0.1 | Cassandra 3.11.5 | CQL spec 3.4.4 | Native protocol v4]

Use HELP for help.

cqlsh\&gt; CREATE KEYSPACE playground WITH replication = {&#39;class&#39;: &#39;SimpleStrategy&#39;, &#39;replication\_factor&#39; : 1};

cqlsh\&gt; SOURCE &#39;/opt/cassandra-data-import/create.cql&#39;;

Starting copy of playground.messages\_by\_user with columns [sender, sent, recip, body, message\_id].

Processed: 6 rows; Rate:      11 rows/s; Avg. rate:      16 rows/s

6 rows imported from 1 files in 0.386 seconds (0 skipped).

cqlsh\&gt; USE playground ;

cqlsh:playground\&gt; select \* FROM messages\_by\_user ;

sender | sent                            | body                                   | message\_id                           | recip

--------+---------------------------------+----------------------------------------+--------------------------------------+--------

  axel | 2013-07-21 15:34:55.000000+0000 |          for sure! 6:00 at our spot :) | e74fb030-bffc-11e3-8a33-0800200c9a66 | jonesy

 bobby | 2013-07-21 15:34:01.000000+0000 |                            np, will do | dd963780-bffc-11e3-8a33-0800200c9a66 |   juju

 annie | 2013-07-21 15:31:23.000000+0000 | will be great to see you guys tonight! | f594a470-bffc-11e3-8a33-0800200c9a66 |   juju

jonesy | 2013-07-21 15:34:03.000000+0000 |                         meet up today? | c764e974-bffc-11e3-8a33-0800200c9a66 |   axel

  juju | 2013-07-21 15:32:58.000000+0000 |                             and mixer! | c764e971-bffc-11e3-8a33-0800200c9a66 |  bobby

  juju | 2013-07-21 15:32:16.000000+0000 |                  please pick up snacks | f81d4fae-7dec-11d0-a765-00a0c91e6bf6 |  bobby

(6 rows)

cqlsh:playground\&gt;

---------------------------------------------------------

**Q8: How to import csv data to into Cassandra?**

A: cqlsh\&gt; COPY table-name(column-1, column-2, column-3,..., column-n) from &#39;file-path/table-name.csv&#39; WITH header = true AND delimiter = &#39;|&#39;;

**please take the follow example for the guidance**

root@7824e7b38e86:/opt/cassandra-data-import# cqlsh

Connected to Test Cluster at 127.0.0.1:9042.

[cqlsh 5.0.1 | Cassandra 3.11.5 | CQL spec 3.4.4 | Native protocol v4]

Use HELP for help.

cqlsh\&gt; use demo\_key\_space ;

cqlsh:demo\_key\_space\&gt; select \* from location ;

vehicle\_id | date | time | latitude | longitude

------------+------+------+----------+-----------

(0 rows)

cqlsh:demo\_key\_space\&gt; copy location(vehicle\_id,date,time,latitude,longitude) from &#39;/home/ubuntu/opt/cassandra-data-import/locations.csv&#39; with header = true and delimiter = &#39;|&#39;;

Using 1 child processes

Starting copy of demo\_key\_space.location with columns [vehicle\_id, date, time, latitude, longitude].

Processed: 30 rows; Rate:      51 rows/s; Avg. rate:      75 rows/s

30 rows imported from 1 files in 0.398 seconds (0 skipped).

cqlsh:demo\_key\_space\&gt; select \* from location ;

vehicle\_id | date       | time                            | latitude | longitude

------------+------------+---------------------------------+----------+------------

  ME100AAS | 2014-05-19 | 2014-05-19 08:50:00.000000+0000 | 44.74941 |   -67.2507

  ME100AAS | 2014-05-19 | 2014-05-19 08:40:00.000000+0000 | 44.74648 |  -67.26444

  ME100AAS | 2014-05-19 | 2014-05-19 08:30:00.000000+0000 | 44.74258 |  -67.34272

  ME100AAS | 2014-05-19 | 2014-05-19 08:20:00.000000+0000 | 44.72795 |  -67.40177

  ME100AAS | 2014-05-19 | 2014-05-19 08:10:00.000000+0000 | 44.69965 |  -67.47043

  ME100AAS | 2014-05-19 | 2014-05-19 08:00:00.000000+0000 | 44.61909 |   -67.8462

  FLN78197 | 2014-05-19 | 2014-05-19 08:50:00.000000+0000 | 24.67026 |  -81.35636

  FLN78197 | 2014-05-19 | 2014-05-19 08:40:00.000000+0000 | 24.64779 |  -81.32752

  FLN78197 | 2014-05-19 | 2014-05-19 08:30:00.000000+0000 | 24.66027 |  -81.27396

  FLN78197 | 2014-05-19 | 2014-05-19 08:20:00.000000+0000 | 24.69147 |  -81.19019

  FLN78197 | 2014-05-19 | 2014-05-19 08:10:00.000000+0000 | 24.70644 |  -81.12702

  FLN78197 | 2014-05-19 | 2014-05-19 08:00:00.000000+0000 |  24.7027 |   -81.1435

  LAKRM489 | 2014-05-19 | 2014-05-19 08:50:00.000000+0000 | 30.12634 |  -93.70228

  LAKRM489 | 2014-05-19 | 2014-05-19 08:40:00.000000+0000 | 30.13228 |  -93.68717

  LAKRM489 | 2014-05-19 | 2014-05-19 08:30:00.000000+0000 | 30.13941 |  -93.66206

  LAKRM489 | 2014-05-19 | 2014-05-19 08:20:00.000000+0000 | 30.15188 |  -93.63636

  LAKRM489 | 2014-05-19 | 2014-05-19 08:10:00.000000+0000 |  30.1685 |  -93.59516

  LAKRM489 | 2014-05-19 | 2014-05-19 08:00:00.000000+0000 | 30.18749 |  -93.53748

  WA063JXD | 2014-05-19 | 2014-05-19 08:50:00.000000+0000 | 47.70144 | -117.01791

  WA063JXD | 2014-05-19 | 2014-05-19 08:40:00.000000+0000 | 47.69589 | -117.04126

  WA063JXD | 2014-05-19 | 2014-05-19 08:30:00.000000+0000 | 47.68711 |  -117.0701

  WA063JXD | 2014-05-19 | 2014-05-19 08:20:00.000000+0000 | 47.68017 | -117.08932

  WA063JXD | 2014-05-19 | 2014-05-19 08:10:00.000000+0000 | 47.67093 | -117.10924

  WA063JXD | 2014-05-19 | 2014-05-19 08:00:00.000000+0000 | 47.67547 | -117.23619

 CA6AFL218 | 2014-05-19 | 2014-05-19 08:50:00.000000+0000 | 36.11959 | -115.17258

 CA6AFL218 | 2014-05-19 | 2014-05-19 08:40:00.000000+0000 | 36.04423 | -115.18112

 CA6AFL218 | 2014-05-19 | 2014-05-19 08:30:00.000000+0000 | 35.91153 | -115.20631

 CA6AFL218 | 2014-05-19 | 2014-05-19 08:20:00.000000+0000 | 35.88326 | -115.22528

 CA6AFL218 | 2014-05-19 | 2014-05-19 08:10:00.000000+0000 | 35.76301 | -115.33514

 CA6AFL218 | 2014-05-19 | 2014-05-19 08:00:00.000000+0000 | 35.69166 |  -115.3681

(30 rows)

cqlsh:demo\_key\_space\&gt; select \* from user ;

id | address | age | created\_time | name

----+---------+-----+--------------+------

(0 rows)

cqlsh:demo\_key\_space\&gt; copy user(id, address, age, created\_time, name) from &#39;/home/ubuntu/opt/cassandra-data-import/users.csv&#39; with header = true and delimiter = &#39;|&#39;;

Using 1 child processes

Starting copy of demo\_key\_space.user with columns [id, address, age, created\_time, name].

Processed: 4 rows; Rate:       6 rows/s; Avg. rate:       9 rows/s

4 rows imported from 1 files in 0.437 seconds (0 skipped).

cqlsh:demo\_key\_space\&gt; select \* from user;

id  | address                                      | age | created\_time                    | name

-----+----------------------------------------------+-----+---------------------------------+-------

237 | 300 E Market Street, San Francisco, CA 94014 |  46 | 2019-12-20 02:08:29.825000+0000 | Allan

234 |  1702 Chestnut Road, Silver Spring, MD, 2902 |  35 | 2019-12-26 01:58:28.387000+0000 | Peter

236 |         787 Fargo Ave, San Leandro, CA 94579 |  38 | 2019-12-26 02:07:54.391000+0000 |   Sam

239 |         504 E Bayview Ave, Oakland, CA 94610 |  62 | 2019-12-25 08:03:29.825000+0000 | Jerry

(4 rows)

cqlsh:demo\_key\_space\&gt; select \* from home;

home\_id | address | alt\_phone | city | contact\_name | email | guest\_code | main\_code | phone | phone\_password | state | zip

---------+---------+-----------+------+--------------+-------+------------+-----------+-------+----------------+-------+-----

(0 rows)

cqlsh:demo\_key\_space\&gt; copy home(home\_id, address, city, state, zip, contact\_name, phone, alt\_phone, phone\_password, email, main\_code, guest\_code) from &#39;/home/ubuntu/opt/cassandra-data-import/homes.csv&#39; with header = true and delimiter = &#39;|&#39;;

Using 1 child processes

Starting copy of demo\_key\_space.home with columns [home\_id, address, city, state, zip, contact\_name, phone, alt\_phone, phone\_password, email, main\_code, guest\_code].

Processed: 5 rows; Rate:       7 rows/s; Avg. rate:      11 rows/s

5 rows imported from 1 files in 0.444 seconds (0 skipped).

cqlsh:demo\_key\_space\&gt; select \* from home;

home\_id   | address                   | alt\_phone    | city          | contact\_name      | email                | guest\_code | main\_code | phone        | phone\_password | state | zip

-----------+---------------------------+--------------+---------------+-------------------+----------------------+------------+-----------+--------------+----------------+-------+-------

H01474777 |       518 Crestview Drive |         null | Beverly Hills |      Jed Clampett |    jclampett@bhb.com |       7778 |      5599 | 310-775-4011 |            oil |    CA | 90046

H01033638 |      129 West 81st Street | 212-483-1072 |      New York |    Jerry Seinfeld |   jerry@seinfeld.com |       1919 |      2121 | 212-440-5657 |         elaine |    NY | 10024

H02257222 | 1164 Morning Glory Circle |         null |      Westport |   Darrin Stephens | darrin@bewitched.com |       2566 |      1566 | 860-777-7564 |            sam |    CT | 06880

H01545551 |   565 North Clinton Drive |         null |     Milwaukee | Arthur Fonzarelli | fonzie@happydays.com |       4445 |      8889 | 414-858-1033 |         harley |    WI | 53525

H00999943 |      245 East 73rd Street | 212-495-5755 |      New York |   Carrie Bradshaw |      carrie@sitc.com |       1256 |      1245 | 212-520-0250 |          prada |    NY | 10021

(5 rows)

cqlsh:demo\_key\_space\&gt; describe tables;

**home  user  location  activity**

cqlsh:demo\_key\_space\&gt; select \* from activity ;

home\_id | datetime | code\_used | event

---------+----------+-----------+-------

(0 rows)

cqlsh:demo\_key\_space\&gt; copy activity(home\_id, datetime, event, code\_used) from &#39;/home/ubuntu/opt/cassandra-data-import/activities.csv&#39; with header = true and delimiter = &#39;|&#39;;

Using 1 child processes

Starting copy of demo\_key\_space.activity with columns [home\_id, datetime, event, code\_used].

Processed: 32 rows; Rate:      46 rows/s; Avg. rate:      71 rows/s

32 rows imported from 1 files in 0.448 seconds (0 skipped).

cqlsh:demo\_key\_space\&gt; select \* from activity ;

home\_id   | datetime                        | code\_used | event

-----------+---------------------------------+-----------+-----------------------

H01474777 | 2014-05-23 18:28:41.000000+0000 |      5599 |      alarm turned off

H01474777 | 2014-05-23 07:44:23.000000+0000 |      5599 |             alarm set

H01474777 | 2014-05-22 17:22:15.000000+0000 |      5599 |      alarm turned off

H01474777 | 2014-05-22 11:44:07.000000+0000 |      null | alarm reset by office

H01474777 | 2014-05-22 11:25:00.000000+0000 |      null |         police called

H01474777 | 2014-05-22 11:23:59.000000+0000 |      null |        alarm breached

H01474777 | 2014-05-22 07:44:13.000000+0000 |      5599 |             alarm set

H01474777 | 2014-05-21 18:30:33.000000+0000 |      5599 |      alarm turned off

H01474777 | 2014-05-21 07:32:16.000000+0000 |      5599 |             alarm set

H01033638 | 2014-05-22 07:45:28.000000+0000 |      2121 |             alarm set

H01033638 | 2014-05-21 19:01:46.000000+0000 |      2121 |      alarm turned off

H01033638 | 2014-05-21 16:58:39.000000+0000 |      1919 |             alarm set

H01033638 | 2014-05-21 13:02:11.000000+0000 |      1919 |      alarm turned off

H01033638 | 2014-05-21 07:55:58.000000+0000 |      2121 |             alarm set

H01033638 | 2014-05-21 07:50:43.000000+0000 |      2121 |      alarm turned off

H01033638 | 2014-05-21 07:50:22.000000+0000 |      2121 |             alarm set

H02257222 | 2014-05-23 18:06:58.000000+0000 |      1566 |      alarm turned off

H02257222 | 2014-05-23 07:49:36.000000+0000 |      1566 |             alarm set

H02257222 | 2014-05-22 21:59:44.000000+0000 |      1566 |      alarm turned off

H02257222 | 2014-05-21 05:29:47.000000+0000 |      1566 |             alarm set

H01545551 | 2014-05-23 18:14:53.000000+0000 |      8889 |      alarm turned off

H01545551 | 2014-05-23 08:28:16.000000+0000 |      8889 |             alarm set

H01545551 | 2014-05-22 18:35:29.000000+0000 |      8889 |      alarm turned off

H01545551 | 2014-05-22 08:32:22.000000+0000 |      8889 |             alarm set

H01545551 | 2014-05-21 18:41:02.000000+0000 |      8889 |      alarm turned off

H01545551 | 2014-05-21 08:30:14.000000+0000 |      8889 |             alarm set

H00999943 | 2014-05-23 18:56:23.000000+0000 |      1245 |      alarm turned off

H00999943 | 2014-05-23 08:52:19.000000+0000 |      1245 |             alarm set

H00999943 | 2014-05-22 19:10:56.000000+0000 |      1245 |      alarm turned off

H00999943 | 2014-05-22 08:55:10.000000+0000 |      1245 |             alarm set

H00999943 | 2014-05-21 19:03:33.000000+0000 |      1245 |      alarm turned off

H00999943 | 2014-05-21 09:05:54.000000+0000 |      1245 |             alarm set

(32 rows)

cqlsh:demo\_key\_space\&gt;
