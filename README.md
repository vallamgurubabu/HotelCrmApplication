# 🏨 Hotel CRM System - Project Overview
The **Hotel CRM System** is a **Monolithic Application** built with **Spring Boot** to manage hotel operations such as customer details, bookings, room inventory, and admin control. It follows proper layering with **Controller**, **Service**, and **Repository** to ensure modular and maintainable code.

---

## 🚀 Key Features
- ✅ **Customer Management**  
  Add, view, update, and delete customer records.  
- ✅ **Booking Management**  
  Manage hotel room bookings with check-in, check-out, and billing details.  
- ✅ **Room Inventory Management**  
  Manage room details like availability, type, and pricing.  
- ✅ **Admin Management**  
  Add and manage admins who oversee customer, booking, and room records.  
- ✅ **Global Exception Handling**  
  Ensures user-friendly error messages for better debugging.  
- ✅ **Robust Data Management**  
  Uses **Spring Data JPA** with a **MySQL Database** for efficient CRUD operations.

---

## 📂 Project Structure
```
HotelCRM/
│── src/
│   ├── main/java/com/hotel/crm/
│   │   ├── controller/
│   │   ├── model/
│   │   ├── repository/
│   │   ├── service/
│   │   ├── exception/
│   │   ├── HotelCrmApplication.java
│   ├── resources/
│   │   ├── application.properties
│── pom.xml
│── README.md
```

---

## 🛠️ Technology Stack
- ✅ Java 17  
- ✅ Spring Boot  
- ✅ Spring Data JPA  
- ✅ MySQL Database  
- ✅ Maven  

---

## 📋 API Endpoints Summary for Hotel CRM System

### 🤞🧑‍🧑 Customer Management Endpoints
| **Endpoint**                  | **Method** | **Description**                    |
|-------------------------------|-------------|------------------------------------|
| `/customers/add`               | `POST`       | Add a new customer                 |
| `/customers/all`               | `GET`        | Retrieve all customers             |
| `/customers/{id}`              | `GET`        | Get a specific customer by ID       |
| `/customers/delete/{id}`       | `DELETE`     | Delete a specific customer by ID    |
| `/customers/delete/all`        | `DELETE`     | Delete all customer records         |
| `/customers/room/{roomNumber}` | `GET`        | Get customers by room number        |

### 🏨 Admin Management Endpoints
| **Endpoint**                  | **Method** | **Description**                    |
|-------------------------------|-------------|------------------------------------|
| `/admin/add`                   | `POST`       | Add a new admin                    |
| `/admin/all`                   | `GET`        | Retrieve all admins                 |
| `/admin/{id}`                  | `GET`        | Get a specific admin by ID          |
| `/admin/delete/{id}`           | `DELETE`     | Delete a specific admin by ID       |
| `/admin/all`                   | `DELETE`     | Delete all admin records            |

### 🛏️ Room Management Endpoints
| **Endpoint**                      | **Method** | **Description**                    |
|-----------------------------------|-------------|------------------------------------|
| `/rooms/add`                       | `POST`       | Add a new room                     |
| `/rooms/all`                       | `GET`        | Retrieve all rooms                 |
| `/rooms/{id}`                      | `GET`        | Get room details by ID             |
| `/rooms/check-availability/{roomNumber}` | `GET`  | Check room availability            |
| `/rooms/book/{roomId}`             | `POST`       | Mark a room as booked              |
| `/rooms/delete/{id}`               | `DELETE`     | Delete a room by ID                |

### 🗓️ Booking Management Endpoints
| **Endpoint**                  | **Method** | **Description**                    |
|-------------------------------|-------------|------------------------------------|
| `/bookings/add`                | `POST`       | Add a new booking                  |
| `/bookings/all`                | `GET`        | Retrieve all bookings               |
| `/bookings/{id}`                | `GET`        | Get booking details by ID           |
| `/bookings/delete/{id}`         | `DELETE`     | Delete a booking by ID              |

---

## ⚙️ Core Business Logic
### Booking Logic
✔️ Before confirming a booking, the system checks room availability.  
✔️ Once booked, the room status is updated as **Booked**.

### Room Availability Logic
✔️ The system efficiently tracks available rooms.  
✔️ Admins can manually mark rooms as **Available** or **Unavailable**.

---

## 🚀 How to Run the Project
**1️⃣ Clone the Repository**  
```bash
git clone https://github.com/vallamgurubabu/HotelCrmApplication/tree/main
cd HotelCRM
```

**2️⃣ Create MySQL Database**  
```sql
CREATE DATABASE hotel_crm;
```

**3️⃣ Configure `application.properties`**  
```properties
spring.application.name=HotelCrmApplication
# Server Configuration
server.port=8080 
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/hotel_crm
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

**4️⃣ Build and Run**  
```bash
mvn spring-boot:run
```

**5️⃣ Test Endpoints in Postman**  
- **`GET http://localhost:8080/customers/all`**  
- **`POST http://localhost:8080/rooms/add`**  
- **`GET http://localhost:8080/rooms/check-availability/{roomNumber}`**  

---

## 🌟 Future Enhancements
✅ Add **Spring Security** for secure admin access.  
✅ Implement **Swagger API Documentation**.  
✅ Introduce **Email Notifications** for booking confirmations.  
✅ Add **Search and Filter Features** for better room and booking management.

---

If you found this project helpful, please ⭐️ the repository and feel free to contribute! 😊
