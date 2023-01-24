#!/usr/bin/env bash

CONTAINER_ID=$(docker run -u zap -p 8081:8081 -d owasp/zap2docker-weekly zap.sh -daemon -port 8081 -host 127.0.0.1 -config api.disablekey=true  -config connection.dnsTtlSuccessfulQueries=-1 -config api.addrs.addr.name=.* -config api.addrs.addr.regex=true)

echo "TRYING TO STRAT ZAP PROXY CONTAINER"
docker logs $CONTAINER_ID