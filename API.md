# Smart CV Analyzer - API Documentation

## Base URL
`http://localhost:8080`

---

## Endpoints

### 1. Analyze CV & Upload Resume
* **URL**: `/api/cv/analyze`
* **Method**: `POST`
* **Consumes**: `multipart/form-data`
* **Parameters**:
  * `file`: PDF file of the resume (MultipartFile)
  * `jobDescription`: Target keywords or job description (String)
* **Response Example**:
  ```json
  {
    "id": 1,
    "candidateName": "Ilakiya V",
    "email": "ilakiya@example.com",
    "matchScore": 85.5,
    "analyzedDate": "2026-04-20"
  }