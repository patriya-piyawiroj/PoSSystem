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

<img width="660" alt="Screen Shot 2566-03-09 at 01 53 17" src="https://user-images.githubusercontent.com/33531627/223808660-4f633a99-ef1e-46a2-8f1b-cd234653d8ff.png">

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

<img width="655" alt="Screen Shot 2566-03-09 at 01 53 25" src="https://user-images.githubusercontent.com/33531627/223808707-18875155-76c6-4295-ab84-3c5d2c364448.png">
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
