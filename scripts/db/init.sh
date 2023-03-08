#!/bin/bash

psql -U $POSTGRES_USER -d $POSTGRES_DB -a -f /app/scripts/db/payment.sql
psql -U $POSTGRES_USER -d $POSTGRES_DB -a -f /app/scripts/db/sale.sql