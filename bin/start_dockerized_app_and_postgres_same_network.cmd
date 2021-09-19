docker network create postgresnet
mkdir %homedrive%%homepath%\docker\volumes\postgres
docker run --rm --name postgres-docker -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=sportsbet -d  --network postgresnet -v %homedrive%%homepath%\docker\volumes\postgres:/var/lib/postgresql/data -p 5432:5432 postgres
docker run --rm --name sportsbet-docker --network postgresnet -d -e POSTGRES_URL=jdbc:postgresql://postgres-docker:5432/sportsbet -p 9006:9006 sportsbet
