# Vehicule-Management-Project 🚗

## Overview
Vehicule-Management-Project is a full-stack web application for managing vehicles.  
It features user registration and login with JWT authentication, and supports full CRUD (Create / Read / Update / Delete) operations on vehicles.  
Frontend is built with Angular and backend with Spring Boot (Java 21).

---

## 🧰 Tech Stack

| Layer | Technology / Framework / Language |
|-------|-------------------------------|
| Backend | Java 21, Spring Boot, Spring Data / JPA, Spring Security (JWT) |
| Frontend | Angular 19, TypeScript, Angular Router, Angular Forms |
| API | REST API (JSON) |
| Auth | JWT (JSON Web Tokens) |
| Database | (configured with your choice — e.g. PostgreSQL / MySQL / H2) |
| Build / Dev Tools | Maven (backend), Angular CLI (frontend), Node JS, npm |

---

## ✅ Features

- User registration (sign-up)
- User authentication (sign-in) with JWT tokens
- Protected routes (only logged-in users can access vehicle management)
- CRUD operations on vehicles (add, view/list, update, delete)
- Responsive UI with Angular
- Clear separation between frontend and backend
- Token-based authentication stored in `localStorage`

---

## 🚀 Getting Started

### 1. Clone the repo


git clone https://github.com/harzaliolfa/Vehicule-Management-Project.git
cd Vehicule-Management-Project
2. Backend Setup
bash
Copy code
cd backend
./mvnw clean install   # or mvn clean install
./mvnw spring-boot:run # to start the Spring Boot server
The backend will run on default port 8080

Make sure your database is configured properly (e.g. in application.properties)

The API base URL: http://localhost:8080

3. Frontend Setup
bash
Copy code
cd ../frontendV
npm install
ng serve
The frontend will run on default port 4200

The Angular app expects the backend at http://localhost:8080

📄 API Endpoints (example)
Method	Endpoint	Description
POST	/login	Sign in, returns JWT token
POST	/register	Register new user
GET	/vehicules	Retrieve list of vehicles (protected)
POST	/vehicules	Add a new vehicle (protected)
PUT	/vehicules/{id}	Update a vehicle (protected)
DELETE	/vehicules/{id}	Delete a vehicle (protected)

⚠️ All protected endpoints require a valid JWT token in the Authorization: Bearer <token> header.

🧑‍💻 Usage Flow
Open the app in the browser (http://localhost:4200) → See welcome page

Register a new account or login (existing account)

On successful login, you are redirected to the vehicles dashboard

You can add, update or delete vehicles

Logout to end session (token removed)

✅ Why This Project Stands Out
Clean separation between frontend & backend

Token-based authentication ensures secure access

Simple REST API + SPA architecture — ideal for learning or real-world usage

Easily extensible (roles, more entities, permissions, search, filters, etc.)

🔭 Future Improvements (Ideas)
Add user roles (admin / user) with permissions

Add search, filtering, and pagination for vehicles list

Add vehicle images upload

Add unit / integration tests (backend & frontend)

Dockerize backend + frontend + database for easy deployment

Add logging, error handling, and better validation

📄 License & Contribution
This is an open project (MIT / whichever license you choose). Feel free to fork, contribute, report issues, or extend it.