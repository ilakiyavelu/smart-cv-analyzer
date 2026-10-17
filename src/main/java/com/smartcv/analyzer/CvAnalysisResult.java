package com.smartcv.analyzer;

import jakarta.persistence.*;

@Entity
public class CvAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String extractedEmail;
    private String extractedPhone;
    private String matchedSkills;
    private String missingSkills;
    private int score;
    private String eligibilityStatus;
    private String remarks;
    private String statusMessage;

    public CvAnalysisResult() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getExtractedEmail() { return extractedEmail; }
    public void setExtractedEmail(String extractedEmail) { this.extractedEmail = extractedEmail; }

    public String getExtractedPhone() { return extractedPhone; }
    public void setExtractedPhone(String extractedPhone) { this.extractedPhone = extractedPhone; }

    public String getMatchedSkills() { return matchedSkills; }
    public void setMatchedSkills(String matchedSkills) { this.matchedSkills = matchedSkills; }

    public String getMissingSkills() { return missingSkills; }
    public void setMissingSkills(String missingSkills) { this.missingSkills = missingSkills; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public String getEligibilityStatus() { return eligibilityStatus; }
    public void setEligibilityStatus(String eligibilityStatus) { this.eligibilityStatus = eligibilityStatus; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

    public String getStatusMessage() { return statusMessage; }
    public void setStatusMessage(String statusMessage) { this.statusMessage = statusMessage; }
}