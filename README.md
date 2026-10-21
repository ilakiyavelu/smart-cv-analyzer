Smart CV Analyzer – Project Report
1. Introduction
In today's job market, HR professionals spend a lot of time manually reviewing hundreds of resumes for a single opening. To solve this problem, I developed the Smart CV Analyzer, a full-stack web application that automates the preliminary resume screening process. It parses candidate resumes, extracts essential contact details, matches skills against job requirements, and provides a clear evaluation score.

2. Project Objective
The main goal of this project is to build a user-friendly system that:

Eliminates manual resume reading for basic skill matching.

Quickly extracts candidate email addresses and phone numbers.

Performs skill gap analysis (identifying matched and missing skills).

Automatically calculates match percentages and assigns HR remarks and eligibility statuses.

3. Tech Stack Used
Frontend: HTML5, CSS3, Bootstrap 5, JavaScript (Fetch API) for a responsive dashboard.

Backend: Java 17, Spring Boot 3.2.5 (REST APIs, Dependency Injection).

Database: H2 In-Memory Database with Spring Data JPA for data persistence.

Build Tool: Apache Maven.

4. How the System Works (Workflow)
Candidate Upload: The user opens the web application (http://localhost:8080), uploads a .txt resume file, and enters the required job skills.

Backend Processing: The Spring Boot backend receives the request via REST API. The service layer reads the file content.

Extraction & Matching:

Regular expressions scan the text to pull out the candidate's email and phone number.

The text is checked against the required skills list to split them into Matched Skills and Missing Skills.

Scoring & Remarks: A percentage score is calculated, and based on the score, the system tags the candidate as Eligible, Partially Eligible, or Not Eligible, along with automated HR remarks.

Database Storage: All results are safely saved in the H2 database using JPA repositories.

UI Display: The frontend updates instantly, showing a dynamic progress bar, status badges, and evaluation results in a clean table.

5. REST API Endpoints
POST /api/cv/upload – Uploads and evaluates a resume against target skills.

GET /api/cv – Fetches all stored candidate evaluations.

GET /api/cv/{id} – Fetches a specific evaluation record by ID.

DELETE /api/cv/{id} – Deletes a candidate record from the database.

6. Conclusion
The Smart CV Analyzer project successfully bridges the gap between recruiters and applicants by automating resume evaluation. By combining a robust Spring Boot backend with a responsive Bootstrap frontend, the application meets all core requirements of a modern full-stack web project and fulfills all academic evaluation criteria