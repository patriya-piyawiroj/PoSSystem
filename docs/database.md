## Tables

### Payment Method

A table containing the possible payment methods and associated price modifier and points. 

Data is seeded from [data/payment.csv](/data/payment.csv). 
In order to maintain versioning data, and audit table, 'payment_method_audit' is created to track changes.

<img width="806" alt="Screen Shot 2566-03-09 at 01 52 51" src="https://user-images.githubusercontent.com/33531627/223808471-2f1bbc51-ca0e-4fa7-a227-43ae517bd626.png">

### Sale
A list of raw transaction data seeded from [data/sale.csv](/data/sale.csv). 

Indexed by sale_datetime for lookups by date time. 

Partitioned yearly into sale_y2022, sale_y2023, sale_y2024... in order to efficiently transfer large amounts of old data in to archival storage.

An summed table can be added if aggregated reads are frequently used

<img width="1002" alt="Screen Shot 2566-03-09 at 01 52 56" src="https://user-images.githubusercontent.com/33531627/223808499-9865529c-8945-4550-b8ac-15a883266eda.png">
