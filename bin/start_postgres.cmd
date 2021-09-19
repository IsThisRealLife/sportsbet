mkdir %homedrive%%homepath%\docker\volumes\postgres
docker run --rm --name postgres-docker -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=sportsbet -d -v %homedrive%%homepath%\docker\volumes\postgres:/var/lib/postgresql/data -p 5432:5432 postgres



