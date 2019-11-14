# stock-exchange-platform

## Collaborators 

* Jaime Moncayo
* Santosh Pradhan
* Chunlei Du
* Sowmya Rangarajan
* Sridhar Mallela

## Running on computer

* Download code
* Import as maven project
* Start App as Sprint Boot Application

* H2 Memory Console -- `http://localhost:8080/h2-console/login.do`
    * `h2:mem:testdb`

### URLS

### Get All Traders

 | Usage | Method | URL | Body |
 | ---- | ---- | ----|---- |
 | List all Traders | GET | `http://localhost:8080/admin/traders` | |
 | Find Trader by Id | GET | `http://localhost:8080/admin/traders/id/3` | |
 | Find Trader by Id | GET | `http://localhost:8080/admin/traders/traderId/9` | |
 | Find Trader by LastName | GET | `http://localhost:8080/admin/traders/lastname/John` | |
 | Create/Update Trader | POST | `http://localhost:8080/admin/traders` | ``` { "firstName": "Jamie", "lastName": "Moncayo",  "email": "123456@gmail.com", "phoneNum": "1236540987"  } ```|
 | Delete Trader | DELETE | `http://localhost:8080/admin/traders` | ``` { "traderId" : 3, "firstName": "Jamie", "lastName": "Moncayo",  "email": "123456@gmail.com", "phoneNum": "1236540987"  } ```|
 | Find Trader by email | GET | `http://localhost:8080/admin/traders/email/123456@gmail.com` | |
 | Find Trader by phoneNum | GET | `http://localhost:8080/admin/traders/phoneNum/123456@gmail.com` | |
 
 ### change history
 test new branch chunlei
