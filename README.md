# PulseDesk: AI-Powered Ticketing System

PulseDesk is an intelligent customer feedback assistant that leverages Large Language Models to transform raw user comments into structured, actionable support tickets. This project was developed as a technical case study to demonstrate AI integration within a Spring Boot ecosystem.

## Project Purpose
The goal is to bridge the gap between customer feedback and technical support. The system distinguishes between general praise and actual technical issues using the Qwen2.5 (72B-Instruct) model via Hugging Face. If a comment contains a bug or a complaint, PulseDesk automatically assigns a title, categorizes the issue, sets a priority level, and generates a concise summary.

## Technologies Used
- **Backend:** Java 17, Spring Boot 3.x, Spring Data JPA  
- **Frontend:** HTML5, CSS3, JavaScript (Fetch API)  
- **Database:** H2 Database (in-memory)  
- **AI Integration:** Hugging Face Inference API (Qwen/Qwen2.5-72B-Instruct)  
- **Postman:** For testing purposes  

## Key Features
- **Intelligent Analysis:** Automatically distinguishes between compliments and functional complaints.  
- **Automated Categorization:** AI assigns a Title, Category (Bug, Feature, Billing, Account, etc.), and Priority.  
- **Actionable Summaries:** Converts long user descriptions into short, professional summaries for support teams.  
- **Simple UI:** A clean interface to submit feedback and view the real-time "Pulse" of recent comments. (Note: The primary focus was on backend logic; the UI and responsiveness are still a work in progress.)

## Screenshots

| Feature | Preview | Description |
| :--- | :--- | :--- |
| **How AI Works** | ![AI Analysis](myScreenshots/1buttonsPressed.png) | When a user sends a complaint, the AI creates a title, category, and priority automatically. |
| **Positive Comments** | ![Positive Feedback](myScreenshots/2positiveComment.png) | If the comment is positive, the system just responds with a simple message and does not create a ticket. |
| **Postman Test** | ![API Testing](myScreenshots/3testInPostman.png) | Backend and API endpoints tested in Postman, showing JSON responses. |
| **Comment History** | ![History List](myScreenshots/4pageAfterPostman.png) | A list where all previous comments and ticket priority results can be viewed. |

## How to Run

### 1. Clone the repository
```bash
git clone https://github.com/nisanurtezcan/pulseDesk.git
```

### 2. Set up the API key
For security reasons, the API key should not be hardcoded. You should set your Hugging Face API key as an environment variable:

```bash
# Windows (CMD)
set HUGGINGFACE_API_KEY=your_key_here

# Linux/Mac
export HUGGINGFACE_API_KEY="your_key_here"
```

Alternatively, for local testing, you can add the following line to your `src/main/resources/application.properties` file:

```properties
huggingface.api.key=your_key
```

### 3. Run the Application

**Environment Note:**  
This application was developed and tested using Spring Tool Suite 4 (STS). However, it is fully compatible with any Java IDE (IntelliJ, Eclipse, etc.) or can be run directly via Maven.

### 4. Access the App

Open your browser and navigate to:  
http://localhost:8080 or http://localhost:8080/index.html

**Available Endpoints:**

- `GET /comments` – View all submitted comments  
  http://localhost:8080/comments  

- `GET /tickets` – View all AI-generated tickets  
  http://localhost:8080/tickets  

- `GET /tickets/{id}` – View a specific ticket  
  http://localhost:8080/tickets/{ticketId}


## API Testing with Postman

If you want to test the backend directly using Postman, follow these steps to ensure the AI integration works correctly (You can check 3rd screenshot above to see an example result):

### 1. Request Configuration
- **Method:** `POST`
- **URL:** `http://localhost:8080/comments`

### 2. Headers & Authentication
You need to provide your Hugging Face API Key to authorize the AI processing:

- **Authorization:** - Go to the **Auth** tab in Postman.
  - Select **Bearer Token**.
  - Paste your `Hugging Face API Key` here.
- **Headers:**
  - `Content-Type`: `application/json`
  - `Authorization`: `Bearer YOUR_HUGGINGFACE_API_KEY`

### 3. Request Body
Select **raw** and **JSON** format, you can paste the example below:

```json
{
  "commentText": "Sometimes the system does not keep my input after I refresh the page. It is a small issue, but it can be a bit annoying if I accidentally reload and lose what I wrote."
}
```

## What I Practiced
- **LLM Integration:** Connecting a Java backend to external AI models and parsing complex JSON/String responses into structured Java objects.  
- **Spring Boot Fundamentals:** Implementing the full MVC stack (REST Controllers, Service Layers, and Repository Patterns).
- **API Testing & Documentation:** Using Postman to verify REST endpoints, manage Request Headers (Bearer Tokens), and validate JSON response structures.
- **Asynchronous Communication:** Using the JavaScript Fetch API to handle data flow without refreshing the page.  
- **Secure Coding:** Using `.gitignore` to prevent sensitive configuration files (such as `application.properties`) from being exposed in public repositories, ensuring API credentials remain private.  

## Future Improvements
- **Enhanced UI/UX:** Improving mobile responsiveness and adding a dashboard for support agents.  
- **Input Validation:** Implementing stricter server-side validation for user comments.

---

## 💬 Final Words 💬

This project was a fantastic challenge for me. While I have previously worked on a small LLM-related Python assignment during my university studies, it was very limited in scope. This project was my first time integrating such a capable, large-scale system into a full-stack Spring Boot application, and it significantly pushed my development skills forward.

Building PulseDesk allowed me to practice bridging the gap between AI potential and real-world software solutions. It was a great learning experience, and I enjoyed every step of the process!

**Thank you for your time and for this opportunity! ✨**
