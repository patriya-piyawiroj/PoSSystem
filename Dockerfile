FROM postgres:12 as db
WORKDIR /app
COPY ./scripts/db/init.sh /docker-entrypoint-initdb.d
COPY ./scripts/db/payment.sql ./scripts/db/payment.sql
COPY ./scripts/db/sale.sql ./scripts/db/sale.sql
COPY data/payment.csv ./data/payment.csv
COPY data/sale.csv ./data/sale.csv
