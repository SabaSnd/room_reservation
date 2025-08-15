# Room Reservation System

A Java-based application for managing room reservations. This project allows users to book, view, and manage room reservations efficiently.

## Features

- Create, update, and delete reservations
- View available rooms
- User authentication and authorization
- Admin dashboard for managing rooms and users

## Technologies Used

- Java 17+
- Spring Boot
- Hibernate/JPA
- MySQL/PostgreSQL
- Maven

## Setup Instructions

### Prerequisites

- Java 17 or higher
- Maven
- MySQL or PostgreSQL database

### Steps

1. **Clone the repository**
    ```bash
    git clone https://github.com/yourusername/room_reservation.git
    cd room_reservation
    ```

2. **Configure the database**
You can run the following docker container postgres database:
    ```bash
    docker compose up -d
    ```

    Or update `src/main/resources/application.properties` with your database credentials:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/room_reservation
    spring.datasource.username=your_db_user
    spring.datasource.password=your_db_password
    ```

3. **Build the project**
    ```bash
    mvn clean install
    ```

4. **Run the application**
    ```bash
    mvn spring-boot:run
    ```

5. **Access the application**

    Open your browser and go to: [http://localhost:8080](http://localhost:8080)

## Contributing

Contributions are welcome! Please open issues or submit pull requests.

## License

This project is licensed under the MIT License.