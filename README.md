# 📝 Student Feedback System

A simple Java-based **CRUD application** that allows a college department to manage student feedback efficiently using:
- **JDBC**
- **Apache Commons DBCP (Database Connection Pooling)**
- **MySQL**
- **Maven**

---

## 📌 Features

- Add feedback manually with **student ID and name**
- View all feedback entries
- Search feedback by ID
- Update existing feedback
- Delete feedback by ID
- Backend logic includes **JDBC connection pooling**, **input validation**, and **resource management**

---

## 🛠️ Technologies Used

| Technology       | Description                              |
|------------------|------------------------------------------|
| Java (JDK 17)     | Core programming language                |
| MySQL            | Relational database                      |
| JDBC             | Java Database Connectivity (manual SQL)  |
| Apache Commons DBCP | Connection pooling for efficiency     |
| Maven            | Project and dependency management        |
| IntelliJ IDEA    | IDE used for development                 |

---

## 📁 Project Structure

student-feedback-system/
├── pom.xml
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/college/feedback/
│ │ │ ├── Feedback.java
│ │ │ ├── FeedbackDAO.java
│ │ │ ├── FeedbackApp.java
│ │ │ └── DBConnectionPool.java
│ │ └── resources/
│ │ └── db.properties


---

## ⚙️ Database Setup

1. Open MySQL
2. Run the following:

```sql
CREATE DATABASE feedbackdb;
USE feedbackdb;

CREATE TABLE feedback (
    id INT PRIMARY KEY,
    student_name VARCHAR(100) NOT NULL,
    feedback_text TEXT NOT NULL);
```

---
## 📂**Update your `db.properties`**
```
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/feedbackdb
jdbc.username=root
jdbc.password=your_password
```

---
🚀 Running the Project
✅ Prerequisites:
Java JDK 17+
MySQL running locally
IntelliJ IDEA
Maven installed (or IntelliJ with Maven support)

---
🪜 Steps:
Clone or download this repository
Open the project in IntelliJ
Right-click pom.xml → Reload Maven
Run FeedbackApp.java
Use the console menu to perform CRUD operations

---
🔧 Sample Usage
1. Add Feedback
2. View All
3. View by ID
4. Update
5. Delete
6. Exit

---
📃 License
This project is licensed under the MIT License. Feel free to use and modify.

---
🙋‍♀️ Author

Ragavan A

Aspiring  Developer | Passionate about Backend Engineering

---

<img width="1366" height="768" alt="Screenshot (300)" src="https://github.com/user-attachments/assets/2c9413ea-9114-44a3-bcd6-bc9d44ac3f79" />
<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/90f1db77-7b19-4f86-b694-1b9cb59b8d72" />
<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/85e3d3ab-d3fc-4028-8b68-568c7af1baf9" />
<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/267a6af6-f0be-46f6-a24d-955a26d8d3c4" />





