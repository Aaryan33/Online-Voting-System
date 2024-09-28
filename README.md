# Online Voting System

## 1. Overview

This project is an Online Voting System built using Java Servlets and JSP. The application allows users to log in, view party and candidate details, and cast their votes. It features session management and a enhanced user interface.

## 2. Features

- User login and authentication
- Display of parties and candidates
- Voting functionality
- Session management
- Logout feature

## 3. Getting Started

### Step 1: Clone the Repository
Clone this repository to your local machine using:
```bash
https://github.com/Aaryan33/Online-Voting-System.git
```

### Step 2: Set Up MySQL Database
Create a database & Create a table named login_auth with the following schema:

    CREATE TABLE login_auth (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    voted BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (username)
    );

### Step 3: Configure Database Connection
In the ```loginServlet.java``` and ```VoteServlet.java``` files, update the database connection URL, username, and password as per your MySQL configuration.

### Step 4: Deploy the Application
Deploy the application on a Java servlet container such as Apache Tomcat.

### Step 5: Access the Application
Open a web browser and go to ```http://localhost:8080/OnlineVotingSystem/login.jsp``` to access the login page.


## Technologies Used

    -> Java
    
    -> Jakarta EE (Servlets and JSP)
    
    -> MySQL
    
    -> HTML/CSS
