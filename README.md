## PulseDesk: AI-Powered Ticketing System
PulseDesk is an intelligent customer feedback assistant that leverages Large Language Models to transform raw user comments into structured, actionable support tickets. This project was developed as a technical case study to demonstrate AI integration within a Spring Boot ecosystem.

# Project Purpose
The goal is to be the bridge the gap between customer feedback and technical support. The system distinguishes between general praise and actual technical issues by using the Qwen2.5 (72B-Instruct) model via Hugging Face. If a comment contains a bug or a complaint, PulseDesk automatically assigns a title, categorizes the issue, sets a priority level, and generates a short summary.

# Technologies Used
Backend: Java 17, Spring Boot 3.x, Spring Data JPA

Frontend: HTML5, CSS3, JavaScript (Fetch API)

Database: H2 Database (In memory)

AI Integration: Hugging Face Inference API (Qwen/Qwen2.5-72B-Instruct)

# Key Features

Intelligent Analysis: Automatically distinguishes between compliments and functional complaints.

Automated Categorization: AI assigns a Title, Category (Bug, Feature, Billing, Account, etc.), and Priority.

Actionable Summaries: Converts long user descriptions into short, professional summaries for support teams.

Simple UI: A clean interface to submit feedback and view the real-time "Pulse" of recent comments. (Note: Focus was primarily on backend logic; UI responsiveness and UI itself is a work in progress...)

# How to Run

git clone https://github.com/nisanurtezcan/pulseDesk.git
