# Agentic AI Demo

Agentic AI Demo is a Spring Boot application that integrates AI chat functionality with additional tools like DateTime utilities. The application provides a simple chat interface where users can interact with an AI model and receive responses.

## Features

- **AI Chat**: Communicate with an AI model using a chat interface.
- **DateTime Tools**: Get the current date and time or set alarms.
- **Streaming Responses**: Supports streaming responses from the backend to the frontend.

## Technologies Used

- **Backend**:
    - Java
    - Spring Boot
    - Maven
    - WebClient for HTTP requests
    - Reactor for reactive programming
- **Frontend**:
    - HTML, CSS, JavaScript
    - Fetch API for communication with the backend
- **AI Integration**:
    - Ollama API for AI chat models
    - Gson for JSON serialization/deserialization

## Prerequisites

- Java 21 or higher
- Maven 3.6+
- Ollama API running locally (default: `http://localhost:11434`)

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/CODINGSAINT/agentic-ai-demo.git
git clone https://github.com/CODINGSAINT/agentic-ai-demo.git
cd agentic-ai-demo
```
### 2. Configure the Application

Update the following configurations in `application.properties`:

- **Ollama API Base URL**:
    - Default: `http://localhost:11434`
- **AI Model**:
    - Default: `llama3.2`
### 3. Build and Run the Application

To build and run the application, execute the following commands:

```bash
mvn clean install
mvn spring-boot:run

```

### 4. Access the Chat Interface

- **Chat Interface**: Open your browser and navigate to `http://localhost:8080/index.html`.
- **Agent Mode Interface**: Open your browser and navigate to `http://localhost:8080/agent.html`.
- 
- 
### 5. Project Structure

- **`src/main/java`**:
    - `AgenticAiDemoApplication`: Main entry point for the Spring Boot application.
    - `ChatClientService`: Handles communication with the AI model and integrates tools like DateTime.
    - `DateTimeTools`: Provides utilities for date and time operations.
    - `ChatController`: REST controller for handling chat requests.
- **`src/main/resources/static`**:
    - `index.html`: Frontend chat interface.
    - `agent.html`: Enhanced frontend chat interface for agent mode.

### 6. API Endpoints

- **POST `/api/chat`**: Sends a message to the AI model and returns the response.
- **POST `/api/chat/v2`**: Enhanced endpoint for plain string responses.

### 7. Example Usage

#### Chat with AI

1. Type a message in the chat box (e.g., "Hello, AI!").
2. Receive a response from the AI model.

#### DateTime Tools

- Ask: "What is the current date and time?"
- Response: "2025-10-04T12:34:56+05:30[Asia/Kolkata]"

### 8. License

This project is licensed under the MIT License.