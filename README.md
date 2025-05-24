# 🏫 RoomTracker

**RoomTracker** is a classroom assignment system that facilitates both manual and automatic allocation of university classrooms. Using a custom algorithm called **Solver**, the system processes specific requirements provided by faculty departments to generate optimized scheduling solutions across available rooms and time slots.

---

## 🚀 Features

- ✅ Manual assignment of classrooms and time slots  
- 🤖 Automatic assignment using the **Solver** algorithm  
- 📅 Optimized scheduling based on faculty constraints  
- 🧩 Conflict detection and resolution  
- 📊 Role-based access for administrators, supervisors, and faculty leaders  
- 🌐 Web-based UI with interactive features  

---

## 🧠 Stakeholders

- **Administration team**: Oversee overall room availability and system maintenance  
- **Supervisors of each major**: Input and manage class-specific scheduling requirements  
- **Faculty leaders**: Review, approve, and monitor classroom allocations  

---

## 🛠️ Built With

- **Java** — Core programming language  
- **Spring Boot** — Backend framework for building RESTful services  
- **Spring MVC** — For handling HTTP requests and managing controllers  
- **JavaScript** — Frontend interaction and dynamic content rendering  
- **HTML/CSS** — UI components and styling  

---

## 📦 Project Structure

```

RoomTracker/
├── src/
│   ├── main/
│   │   ├── java/com/roomtracker/      # Java backend logic
│   │   ├── resources/
│   │   │   ├── static/                # Frontend static assets (JS, CSS)
│   │   │   └── templates/             # Thymeleaf or HTML templates
│   └── test/                          # Unit and integration tests
├── pom.xml                            # Maven build file
└── README.md

````

---

## ⚙️ Getting Started

### 📋 Prerequisites

- Java 17 or higher  
- Maven 3.6 or higher  
- A modern web browser (Chrome, Firefox, etc.)  

### 🧰 Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/RoomTracker.git
   cd RoomTracker
   ````

2. **Build the project:**

   ```bash
   mvn clean install
   ```

3. **Run the application:**

   ```bash
   mvn spring-boot:run
   ```

4. **Open your browser and navigate to:**

   ```bash
   http://localhost:8080
   ```

---

## 🤖 How the Solver Works

The Solver algorithm processes the following input from faculty:

* Number of enrolled students
* Equipment or room features required
* Preferred scheduling times
* Class duration and recurrence

Using this data, the Solver optimizes classroom assignments by:

* Matching room size and capacity
* Avoiding scheduling conflicts
* Fitting within time availability constraints
* Prioritizing preferences where possible

---

## 👤 User Roles & Access

| Role           | Capabilities                                         |
| -------------- | ---------------------------------------------------- |
| Administrator  | Full access to system and data                       |
| Supervisor     | Manage and submit classroom requests for their major |
| Faculty Leader | Review and approve generated schedules               |

