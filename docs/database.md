## Tables

### Payment Method

A table containing the possible payment methods and associated price modifier and points. 

Data is seeded from [data/payment.csv](/data/payment.csv). 
In order to maintain versioning data, and audit table, 'payment_method_audit' is created to track changes.

![Screen Shot 2566-03-09 at 01.41.31.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2F8m%2Ft967p_yn57q33pgh9l66yhb40000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_v2Gc1z%2FScreen%20Shot%202566-03-09%20at%2001.41.31.png)

### Sale
A list of raw transaction data seeded from [data/sale.csv](/data/sale.csv). 

Indexed by sale_datetime for lookups by date time. 

Partitioned yearly into sale_y2022, sale_y2023, sale_y2024... in order to efficiently transfer large amounts of old data in to archival storage.

An summed table can be added if aggregated reads are frequently used

![Screen Shot 2566-03-09 at 01.43.47.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2F8m%2Ft967p_yn57q33pgh9l66yhb40000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_RZO9kl%2FScreen%20Shot%202566-03-09%20at%2001.43.47.png)