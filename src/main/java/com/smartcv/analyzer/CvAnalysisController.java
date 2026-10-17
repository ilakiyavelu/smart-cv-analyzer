package com.smartcv.analyzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/cv")
public class CvAnalysisController {

    @Autowired
    private CvAnalysisService cvAnalysisService;

    // POST: Upload & Analyze CV
    @PostMapping("/upload")
    public ResponseEntity<CvAnalysisResult> uploadAndAnalyze(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "skills", required = false) String skills) {
        try {
            CvAnalysisResult result = cvAnalysisService.analyzeAndSave(file, skills);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET: Retrieve all analyzed CVs
    @GetMapping
    public ResponseEntity<List<CvAnalysisResult>> getAllCvs() {
        return ResponseEntity.ok(cvAnalysisService.getAllResults());
    }

    // GET: Retrieve single CV by ID
    @GetMapping("/{id}")
    public ResponseEntity<CvAnalysisResult> getCvById(@PathVariable Long id) {
        return ResponseEntity.ok(cvAnalysisService.getResultById(id));
    }

    // DELETE: Remove CV record
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCv(@PathVariable Long id) {
        cvAnalysisService.deleteResult(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}