# PostgreSQL in Docker

Official image: https://hub.docker.com/_/postgres

There are also help documents on the above page.

Dowonload the image:

``$ docker pull postgres:latest``

(This image's base OS is Debian 11.)

## 1. Simplest Test

Start a postgres instace

``$ docker run --name some-postgres -e POSTGRES_PASSWORD=helloworld -d postgres``

(`POSTGRES_PASSWORD` is required, or the container is not able to create.)

### Test the DB on the server side

The docker container does not have a public port, so it's not able to be accessed by other hosts in the network. However, we can still test it.

1. Login container `some-postgres`:

``$ docker exec -it some-postgres bash``

2. Do some tests as following, running the commands in the docker container:

```text
# su - postgres
$ createdb mydb001 
$ createdb mydb002
$ createdb mydb003 
$ createdb mydb004
$ dropdb mydb004
```

Since the command `docker exec -it some-postgres bash` does not set parameter `--name`, it logins as `root` as default, we use `su - postgres` to change to user `postgres` that's the default user built in the docker container image.

3. Login Postgres shell with ``psql`` and do some test.

```text
$ psql
psql (14.1 (Debian 14.1-1.pgdg110+1))
Type "help" for help.

postgres=# \l
                                 List of databases
   Name    |  Owner   | Encoding |  Collate   |   Ctype    |   Access privileges   
-----------+----------+----------+------------+------------+-----------------------
 mydb001   | postgres | UTF8     | en_US.utf8 | en_US.utf8 | 
 mydb002   | postgres | UTF8     | en_US.utf8 | en_US.utf8 | 
 mydb003   | postgres | UTF8     | en_US.utf8 | en_US.utf8 | 
 postgres  | postgres | UTF8     | en_US.utf8 | en_US.utf8 | 
 template0 | postgres | UTF8     | en_US.utf8 | en_US.utf8 | =c/postgres          +
           |          |          |            |            | postgres=CTc/postgres
 template1 | postgres | UTF8     | en_US.utf8 | en_US.utf8 | =c/postgres          +
           |          |          |            |            | postgres=CTc/postgres
(6 rows)

```

The above shows how to login psql and run a command. If we want to more details of all database, use `\l+` here is a demo:

```text
postgres=# \l+
                                                                   List of databases
   Name    |  Owner   | Encoding |  Collate   |   Ctype    |   Access privileges   |  Size   | Tablespace |                Description                 
-----------+----------+----------+------------+------------+-----------------------+---------+------------+--------------------------------------------
 mydb001   | postgres | UTF8     | en_US.utf8 | en_US.utf8 |                       | 8401 kB | pg_default | 
 mydb002   | postgres | UTF8     | en_US.utf8 | en_US.utf8 |                       | 8553 kB | pg_default | 
 mydb003   | postgres | UTF8     | en_US.utf8 | en_US.utf8 |                       | 8553 kB | pg_default | 
 postgres  | postgres | UTF8     | en_US.utf8 | en_US.utf8 |                       | 8553 kB | pg_default | default administrative connection database
 template0 | postgres | UTF8     | en_US.utf8 | en_US.utf8 | =c/postgres          +| 8401 kB | pg_default | unmodifiable empty database
           |          |          |            |            | postgres=CTc/postgres |         |            | 
 template1 | postgres | UTF8     | en_US.utf8 | en_US.utf8 | =c/postgres          +| 8553 kB | pg_default | default template for new databases
           |          |          |            |            | postgres=CTc/postgres |         |            | 
(6 rows)

```

We can also run `\h` to get help, and we can create database, tables here.

## 2. Another Test with Client

The above sample is too simple to use in a network. As it mentioned, the postgres service is not avaliable for other hosts.

We can start a postgreSQL with more parameters.

e.g.,

```text
$ docker run -d --name test-postgres \ # run in background, the container name is test-postgres
  --restart=always \ # the docker will be restarted when the host restarted
  -p 12345:5432 \ # host's public port: 12345, inner port in the container: 5432
  -v /data/postgres/data:/var/lib/postgresql/data \ # store data to host
  -e POSTGRES_USER=testuser \ # optional, set a default user. If it not set, it will be 'postgres'
  -e POSTGRES_PASSWORD=helloworld \
  -e POSTGRES_DB=mydb001 \ # optional, set a default db
  -e ALLOW_IP_RANGE=0.0.0.0/0 \ # allow all IP to access
  postgres
(Do NOT run this command, it's pseudocode.)
```
For test, we can ignore `-v` and run the following:

```text
$ docker run -d --name test-postgres2 \
  --restart=always \
  -p 12345:5432 \
  -e POSTGRES_USER=testuser \
  -e POSTGRES_PASSWORD=helloworld \
  -e POSTGRES_DB=mydb001 \
  -e ALLOW_IP_RANGE=0.0.0.0/0 \
  postgres
```

### Client

There are several database clients that can be used for PostgreSQL. We will use pgAdmin in this article.

Get its docker image and run:

```text
docker run -p 9999:80 -p 9443:443 \
    --name mypgadmin4demo \
    -e 'PGADMIN_DEFAULT_EMAIL=iridiumcao@gmail.com' \
    -e 'PGADMIN_DEFAULT_PASSWORD=Abc-12345' \
    -d dpage/pgadmin4
```

1. Login the web portal. We can access http://localhost:9999/browser/ with "iridiumcao@gmail.com / Abc-12345" which are set by `PGADMIN_DEFAULT_EMAIL` and `PGADMIN_DEFAULT_PASSWORD`
2. Connect to the database. The paramters are set by creating the container.
   * Host name/address: 192.168.1.123
      * IP should NOT be `localhost` or `127.0.0.1`, should be the host IP, like `192.168.1.123` even when the Postgres docker is running on local host.
   * Port: 12345
   * Mainenance databgase: mydb001
   * Username: testuser
   * Password: helloworld

---

Refs:

1. [Official tutorial](https://www.postgresql.org/docs/current/tutorial.html)
2. <https://www.postgresqltutorial.com/postgresql-administration/postgresql-show-databases/>
3. <https://www.pgadmin.org/docs/pgadmin4/latest/container_deployment.html>

This page is post to [CSDN blog](https://blog.csdn.net/caoi/article/details/127220331).