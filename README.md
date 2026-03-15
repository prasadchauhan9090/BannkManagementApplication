# 🏦 Spring Boot Bank Application – Account Controller

This project contains a **REST API for managing bank accounts** built using **Spring Boot**.

The `AccountController` provides endpoints to:

* Create a bank account
* Fetch account details
* Fetch all accounts
* Deposit money
* Withdraw money
* Delete (close) an account

---

# ⚙️ Technologies Used

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* REST API
* Maven

---

# 📂 Project Structure

```text
spring-boot-bank-app
│
├── controller
│   └── AccountController.java
│
├── service
│   └── AccountService.java
│
├── entity
│   └── Account.java
│
├── repository
│   └── AccountRepository.java
```

---

# 🌐 Base URL

```text
http://localhost:8080/account
```

---

# 📌 API Endpoints

## 1️⃣ Create Account

Creates a new bank account.

### Endpoint

```http
POST /account/create
```

### Request Body

```json
{
  "name": "Prasad",
  "balance": 5000
}
```

### Response

```json
{
  "accountNumber": 1001,
  "name": "Prasad",
  "balance": 5000
}
```

### Controller Code

```java
@PostMapping("/create")
public ResponseEntity<Account> createAccount(@RequestBody Account account)
{
    Account createAccount = service.createAccount(account);
    return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
}
```

---

# 2️⃣ Get Account by Account Number

Fetch details of a specific account.

### Endpoint

```http
GET /account/{accountNumber}
```

### Example

```http
GET /account/1001
```

### Controller Code

```java
@GetMapping("/{accountNumber}")
public Account getAccountByAccountNumber(@PathVariable Long accountNumber)
{
    return service.getAccountDetailsByAccountNumber(accountNumber);
}
```

---

# 3️⃣ Get All Accounts

Fetch all accounts from the database.

### Endpoint

```http
GET /account/getallaccounts
```

### Controller Code

```java
@GetMapping("/getallaccounts")
public List<Account> getAllAccountDetails()
{
    return service.getAllAccountDetails();
}
```

---

# 4️⃣ Deposit Amount

Deposits money into an account.

### Endpoint

```http
PUT /account/deposit/{accountNumber}/{amount}
```

### Example

```http
PUT /account/deposit/1001/2000
```

### Controller Code

```java
@PutMapping("/deposit/{accountNumber}/{amount}")
public Account depositAmount(@PathVariable Long accountNumber, @PathVariable Double amount)
{
    return service.depositAmount(accountNumber, amount);
}
```

---

# 5️⃣ Withdraw Amount

Withdraws money from an account.

### Endpoint

```http
PUT /account/withdrwa/{accountNumber}/{amount}
```

### Example

```http
PUT /account/withdrwa/1001/500
```

### Controller Code

```java
@PutMapping("/withdrwa/{accountNumber}/{amount}")
public Account withdrwaAmount(@PathVariable Long accountNumber, @PathVariable Double amount)
{
    return service.withdrwaAmount(accountNumber, amount);
}
```

---

# 6️⃣ Delete Account

Closes an account permanently.

### Endpoint

```http
DELETE /account/delete/{accountNumber}
```

### Example

```http
DELETE /account/delete/1001
```

### Response

```text
YOUR ACCOUNT CLOSED SUCCESSFULLY
```

### Controller Code

```java
@DeleteMapping("/delete/{accountNumber}")
public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber)
{
    service.closeAccount(accountNumber);
    return ResponseEntity.status(HttpStatus.ACCEPTED)
            .body("YOUR ACCOUNT CLOSED SUCCESSFULLY");
}
```

---

# 📊 API Summary

| Method | Endpoint                                     | Description         |
| ------ | -------------------------------------------- | ------------------- |
| POST   | `/account/create`                            | Create new account  |
| GET    | `/account/{accountNumber}`                   | Get account details |
| GET    | `/account/getallaccounts`                    | Get all accounts    |
| PUT    | `/account/deposit/{accountNumber}/{amount}`  | Deposit money       |
| PUT    | `/account/withdrwa/{accountNumber}/{amount}` | Withdraw money      |
| DELETE | `/account/delete/{accountNumber}`            | Delete account      |

---

# ▶️ How to Run the Project

### 1️⃣ Clone Repository

```bash
git clone https://github.com/yourusername/spring-boot-bank-app.git
```

### 2️⃣ Open in IDE

* IntelliJ
* Eclipse
* VS Code

### 3️⃣ Run Application

```bash
mvn spring-boot:run
```

---

# 🧪 Test APIs

You can test APIs using:

* Postman
* Swagger
* Curl

Example:

```bash
curl -X GET http://localhost:8080/account/getallaccounts
```

---

# ⭐ Future Improvements

* Add validation
* Add transaction history
* Add authentication (Spring Security + JWT)
* Add exception handling
* Add Swagger documentation

---

# 👨‍💻 Author

**Prasad Chauhan**

Java Backend Developer
Spring Boot | Microservices | REST APIs
