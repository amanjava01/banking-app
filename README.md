# Bank App

A Spring Boot application to manage bank accounts.

## Features

- Create new bank accounts
- View account details by ID
- Deposit and withdraw money
- List all accounts
- Delete accounts

## API Endpoints

- **Create Account**  
  `POST /api/accounts`  
  Accepts a JSON body with account details.

- **Get Account by ID**  
  `GET /api/accounts/{id}`  
  Returns account details for the given ID.

- **Deposit Money**  
  `PUT /api/accounts/{id}/deposit`  
  Accepts a JSON body like `{ "amount": 500.0 }`.

- **Withdraw Money**  
  `PUT /api/accounts/{id}/withdraw`  
  Accepts a JSON body like `{ "amount": 200.0 }`.

- **List All Accounts**  
  `GET /api/accounts/getall`  
  Returns a list of all accounts.

- **Delete Account**  
  `DELETE /api/accounts/{id}`  
  Deletes the account for the given ID.

## Quick Start

1. **Clone the repository:**
    ```bash
    git clone https://github.com/amanjava01/bank_app.git
    cd bank_app
    ```

2. **Run the application:**
    ```bash
    mvn spring-boot:run
    ```

## Example JSON Requests

**Create Account**
```json
{
  "name": "Alice",
  "balance": 1000.0
}
```

**Deposit**
```json
{
  "amount": 500.0
}
```

**Withdraw**
```json
{
  "amount": 200.0
}
```

## Contributing

Feel free to submit pull requests or open issues!

## License

This project is licensed under the MIT License.