package com.smartcv.analyzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.*;

@Service
public class CvAnalysisService {

    @Autowired
    private CvRepository cvRepository;

    // Method used by Controller for file upload analysis
    public CvAnalysisResult analyzeAndSave(MultipartFile file, String skillsParam) throws IOException {
        String fileName = file.getOriginalFilename();
        
        // Read text directly from uploaded file bytes (Simple & Error-free)
        String cvText = new String(file.getBytes());

        List<String> requiredSkills = Arrays.asList(skillsParam.split(","));

        CvAnalysisResult result = new CvAnalysisResult();
        result.setFileName(fileName);

        // 1. Email Extraction
        String email = cvText.lines()
                .filter(line -> line.contains("@"))
                .findFirst()
                .orElse("Not Found");
        result.setExtractedEmail(email);

        // 2. Phone Extraction
        String phone = cvText.lines()
                .filter(line -> line.matches(".*\\+?\\d{10,12}.*"))
                .findFirst()
                .orElse("Not Found");
        result.setExtractedPhone(phone);

        // 3. Matched & Missing Skills
        List<String> matched = new ArrayList<>();
        List<String> missing = new ArrayList<>();

        for (String skill : requiredSkills) {
            String trimmedSkill = skill.trim();
            if (cvText.toLowerCase().contains(trimmedSkill.toLowerCase())) {
                matched.add(trimmedSkill);
            } else {
                missing.add(trimmedSkill);
            }
        }

        result.setMatchedSkills(matched.isEmpty() ? "None" : String.join(", ", matched));
        result.setMissingSkills(missing.isEmpty() ? "None" : String.join(", ", missing));

        // 4. Score Calculation
        int totalSkills = requiredSkills.size();
        int score = totalSkills > 0 ? (matched.size() * 100) / totalSkills : 0;
        result.setScore(score);

        // 5. Eligibility & HR Remarks
        if (score >= 70) {
            result.setEligibilityStatus("ELIGIBLE");
            result.setRemarks("Excellent match! Candidate recommended for interview.");
        } else if (score >= 40) {
            result.setEligibilityStatus("PARTIALLY ELIGIBLE");
            result.setRemarks("Moderate match. Lacks a few secondary required skills.");
        } else {
            result.setEligibilityStatus("NOT ELIGIBLE");
            result.setRemarks("Low match score. Lacks critical required skills.");
        }

        result.setStatusMessage("Analysis Completed Successfully");

        return cvRepository.save(result);
    }

    // Additional helper methods required by Controller
    public List<CvAnalysisResult> getAllResults() {
        return cvRepository.findAll();
    }

    public CvAnalysisResult getResultById(Long id) {
        return cvRepository.findById(id).orElse(null);
    }

    public void deleteResult(Long id) {
        cvRepository.deleteById(id);
    }
}