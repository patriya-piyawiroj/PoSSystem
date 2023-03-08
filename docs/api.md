## APIs

### Make Payment

Calculate price and points for a given payment method and saves result to database.
<details closed>
<summary>Request</summary>

```agsl
{
  "price": "100.00",                    // String
  "priceModifier": 0.95,                // Float
  "paymentMethod": "MASTERCARD",        // String
  "datetime": "2022-09-01T03:05:00Z"    // String
}
```
</details>
<details closed>
<summary>Response</summary>

```agsl
{
  "finalPrice": "95.0",
  "points": 5
}
```
</details>

<details closed>
<summary>Flow Diagram</summary>

![Screen Shot 2566-03-09 at 01.22.28.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2F8m%2Ft967p_yn57q33pgh9l66yhb40000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_w3pAhO%2FScreen%20Shot%202566-03-09%20at%2001.22.28.png)
</details>

<details closed>
<summary>Errors</summary>

#### Invalid request error

```agsl
{
  "code": 3,  // INVALID_ARGUMENT
  "details": "Request validation failed with error: java.time.format.DateTimeParseException: Text '2022-0901T03:05:00Z' could not be parsed at index 7"
}
```

#### Invalid price modifier error

```agsl
{
  "code": 9,  // FAILED_PRECONDTION
  "details": "Invalid price multiplier: CASH payment is set to accept multipliers between 0.90 and 1.00",
}
```
</details> 



### Get Sales By Hour
Gets sales aggregated by hour
<details closed>
<summary>Request</summary>

```agsl
{
  "startDateTime": "2019-09-01T00:00:00Z", 
  "endDateTime": "2024-09-01T23:59:59Z" 
}
```
</details>
<details closed>
<summary>Response</summary>

```agsl
{
  "finalPrice": "95.0",
  "points": 5
}
```
</details>

<details closed>
<summary>Flow Diagram</summary>

![Screen Shot 2566-03-09 at 01.31.31.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2F8m%2Ft967p_yn57q33pgh9l66yhb40000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_ShU9dW%2FScreen%20Shot%202566-03-09%20at%2001.31.31.png)
</details>

<details closed>
<summary>Errors</summary>

#### Invalid request error

```agsl
{
  "code": 3,
  "details": "Request validation failed with error: java.time.format.DateTimeParseException: Text '2022-0901T03:05:00Z' could not be parsed at index 7",
}
```

</details>