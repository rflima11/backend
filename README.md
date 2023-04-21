O backend depende de diversos serviços externos, como: banco de dados postgres da aplicação, keycloak e banco de dados do keycloak. Para subir todos esses serviços você deve ter instalado o docker na sua maquina e executar o seguinte comando:

```shell
docker compose up
```

Para iniciar o desenvolvimento com uma configuração minima do keycloak e da aplicação, execute os seguintes comandos para efetuar um restore dos bancos de dados:

```shell
cat postgres-keycloak-backup.sql | docker exec -i postgres-keycloak psql -U root -d fluyt
cat postgres-app-backup.sql | docker exec -i postgres-app psql -U root -d fluyt
```

Caso queira realizar algum novo backup dos bancos de dados execute os comandos a seguir:

```shell
docker exec -i postgres-keycloak /usr/bin/pg_dumpall -U root > postgres-keycloak-backup.sql
docker exec -i postgres-app /usr/bin/pg_dumpall -U root > postgres-app-backup.sql
```