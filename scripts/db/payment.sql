-- Create Table
CREATE TABLE IF NOT EXISTS payment_method (
  "name" TEXT PRIMARY KEY,
  "price_modifier_min" numeric(3,2) NOT NULL DEFAULT 1.00,
  "price_modifier_max" numeric(3,2) NOT NULL DEFAULT 1.00,
  "point_multiplier" numeric(3,2) NOT NULL DEFAULT 0.05,
  CONSTRAINT price_modifier_min CHECK (price_modifier_min <= price_modifier_max),
  CONSTRAINT price_modifier_max CHECK (price_modifier_min <= price_modifier_max)
);

-- Create Audit Table
create type audit_action as enum ('SNAPSHOT',
    'INSERT',
    'UPDATE_OLD',
    'UPDATE_NEW',
    'DELETE'
);
CREATE TABLE IF NOT EXISTS payment_method_audit (
    "name" TEXT,
    "price_modifier_min" numeric(3,2),
    "price_modifier_max" numeric(3,2),
    "point_multiplier" numeric(3,2),
    action "audit_action" NOT NULL,
    "log_time" TIMESTAMPTZ NOT NULL
);

-- Seed
COPY payment_method(name, price_modifier_min, price_modifier_max, point_multiplier)
FROM '/app/data/payment.csv'
DELIMITER ','
CSV HEADER;
