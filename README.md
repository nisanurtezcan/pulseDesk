## PulseDesk: AI-Powered Ticketing System
PulseDesk is an intelligent customer feedback assistant that leverages Large Language Models to transform raw user comments into structured, actionable support tickets. This project was developed as a technical case study to demonstrate AI integration within a Spring Boot ecosystem.

# Project Purpose
The goal is to be the bridge the gap between customer feedback and technical support. The system distinguishes between general praise and actual technical issues by using the Qwen2.5 (72B-Instruct) model via Hugging Face. If a comment contains a bug or a complaint, PulseDesk automatically assigns a title, categorizes the issue, sets a priority level, and generates a short summary.

# Technologies Used
Backend: Java 17, Spring Boot 3.x, Spring Data JPA

Frontend: HTML5, CSS3, JavaScript (Fetch API)

Database: H2 Database (In memory)

AI Integration: Hugging Face Inference API (Qwen/Qwen2.5-72B-Instruct)

Postman: For testing purposes

# Key Features

Intelligent Analysis: Automatically distinguishes between compliments and functional complaints.

Automated Categorization: AI assigns a Title, Category (Bug, Feature, Billing, Account, etc.), and Priority.

Actionable Summaries: Converts long user descriptions into short, professional summaries for support teams.

Simple UI: A clean interface to submit feedback and view the real-time "Pulse" of recent comments. (Note: Focus was primarily on backend logic; UI responsiveness and UI itself is a work in progress...)

# How to Run

1. Clone the repository

```bash
git clone https://github.com/nisanurtezcan/pulseDesk.git
```

2. Set up the API key
For security, the API key should not be not hardcoded. You should set your Hugging Face API key as an environment variable:
```bash
Windows (CMD): set HUGGINGFACE_API_KEY=your_key_here

Linux/Mac: export HUGGINGFACE_API_KEY="your_key_here"
```

Alternatively, for local testing, you can add huggingface.api.key=your_key to your src/main/resources/application.properties file.

3. Run the Application
Environment Note:

I personally developed and tested this application using Spring Tool Suite 4 (STS). However, it is fully compatible with any Java IDE (IntelliJ, Eclipse, etc.) or can be run directly via Maven.

4. Access the App

Open your browser and navigate to: http://localhost:8080 or http://localhost:8080/index.html

Available Endpoints:

GET /comments - View all submitted comments. http://localhost:8080/comments


GET /tickets - View all AI-generated tickets. http://localhost:8080/tickets


GET /tickets/{id} - View a specific ticket detail. http://localhost:8080/tickets/{ticketId}


# What I Practiced

- LLM Integration: Connecting a Java backend to external AI models and parsing complex JSON/String responses into structured Java objects.

- Spring Boot Fundamentals: Implementing the full MVC stack (REST Controllers, Service Layers, and Repository Patterns).

- Asynchronous Communication: Using the JavaScript Fetch API to handle data flow without refreshing the page.

- Secure Coding: Using .gitignore to prevent sensitive configuration files (application.properties) from being leaked to public repositories, ensuring API credentials remain private.

# Future Improvements

Enhanced UI/UX: Improving mobile responsiveness and adding a dashboard for support agents.

Input Validation: Implementing stricter server-side validation for user comments.
