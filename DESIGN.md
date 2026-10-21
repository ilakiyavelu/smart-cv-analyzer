# Smart CV Analyzer - System Design

## 1. System Architecture
The application follows a standard **3-Tier Architecture**:
* **Presentation Layer (Frontend)**: HTML5, CSS3, Bootstrap (Interactive UI for file upload and dashboard).
* **Business Logic Layer (Backend)**: Spring Boot REST Controllers & Services (Handles parsing, scoring, and workflow).
* **Data Access Layer**: Spring Data JPA & H2 In-memory Database (Persists candidate analysis records).

## 2. System Workflow / Data Flow
1. **User Uploads CV**: The user uploads a resume PDF file and enters target skills/job description via the Bootstrap UI.
2. **Controller Layer**: `CvAnalysisController` receives the multipart request.
3. **Text Extraction**: `PdfTextExtractorService` uses **Apache PDFBox** to extract raw text content from the PDF stream.
4. **Scoring Algorithm**: `CvAnalysisService` normalizes texts, tokenizes keywords, and calculates the match percentage.
5. **Database Persistence**: The record is saved via `CvRepository` into the **H2 Database**.
6. **Response**: JSON result is returned to the frontend dashboard.