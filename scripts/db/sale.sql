-- Create Table
CREATE TABLE IF NOT EXISTS sale (
  "id" SERIAL NOT NULL,
  "payment_method" TEXT NOT NULL,
  "sale_price" numeric NOT NULL DEFAULT 0.00,
  "earned_points" integer NOT NULL DEFAULT 0.00,
  "sale_datetime" TIMESTAMPTZ NOT NULL DEFAULT NOW(),
  primary key ("id", "sale_datetime"),
  CONSTRAINT fk_payment_method
      FOREIGN KEY(payment_method)
	  REFERENCES payment_method(name)
) PARTITION BY RANGE (sale_datetime);

CREATE INDEX sale_datetime ON sale (sale_datetime);

-- Parition data to be moved to different storage types according to access frequency
SET enable_partition_pruning = on;
CREATE TABLE sale_y2022 PARTITION OF sale
    FOR VALUES FROM ('2022-01-01') TO ('2023-01-01');
CREATE TABLE sale_y2023 PARTITION OF sale
    FOR VALUES FROM ('2023-01-01') TO ('2024-01-01');

-- Seed
COPY sale(payment_method, sale_price, earned_points, sale_datetime)
FROM '/app/data/sale.csv'
DELIMITER ','
CSV HEADER;