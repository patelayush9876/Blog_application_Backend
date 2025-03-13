# Blog Application Backend (Spring Boot)

## 📌 Objective
This project is a **backend service** built using **Java Spring Boot** that allows users to create, retrieve, and manage blogs. It integrates **JPA for database interactions**, includes an **AI-powered text summarization feature**, and is **deployable on AWS**.

---

## 🚀 Features

### **1. Backend API (Spring Boot + JPA)**
- RESTful APIs for:
  - Adding a new blog (**title, content, author, createdAt**)
  - Fetching all blogs with **pagination**
  - Fetching a single blog by **ID**
  - Updating and deleting a blog
- Uses **Spring Data JPA** for seamless database operations.
- Supports **PostgreSQL/MySQL** as the database.

### **2. AI-Powered Text Summarization**
- Implements an API endpoint for **generating blog summaries**.
- Uses **OpenAI API** or an **NLP library like spaCy** (via a Python REST service).

---

## 🔥 Bonus Features 
- **JWT-based authentication** for secure access.
- 
---

## 🛠️ Tech Stack
- **Backend:** Java, Spring Boot, Spring Data JPA
- **Database:** MySQL
- **AI Integration:** Alternative Approach (Without spaCy) : by leveraging NLTK (Natural Language Toolkit) and  TF-IDF (Term Frequency-Inverse Document Frequency).
Uses NLTK for sentence tokenization.
Uses TF-IDF to rank sentences based on word importance.

- **Security & Caching:** JWT Authentication

---

## ⚙️ Installation & Setup

### **1. Clone the Repository**
```bash
 git clone https://github.com/patelayush9876/Blog_application_Backend.git
 cd Blog_application_Backend
```

### **2. Set Up the Database**
- Install and configure **PostgreSQL** or **MySQL**.
- Update database credentials in `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blog_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### **3. Run the Application**
```properties
 run the application from BlogApplication.java in your IDE.
```

### **4. API Endpoints**
| Method | Endpoint | Description |
|--------|------------|-------------|
| `POST` | `/api/blogs` | Create a new blog |
| `GET` | `/api/blogs` | Fetch all blogs with pagination |
| `GET` | `/api/blogs/{id}` | Fetch a single blog by ID |
| `PUT` | `/api/blogs/{id}` | Update a blog |
| `DELETE` | `/api/blogs/{id}` | Delete a blog |
| `POST` | `/api/blogs/summarize/{id}` | Generate AI-powered summary |

---

## ✨ Contributors
👤 **Ayush Patel**  
🔗 [GitHub](https://github.com/patelayush9876)  
📧 Email: patelayush9876@gmail.com  

---


🚀 **Happy Coding!** 🎉

