package com.SmartReceptAPI.Controller;

import com.SmartReceptAPI.entity.CoustmerRecepts;
import com.SmartReceptAPI.service.CoustmerReceptsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/coustmer-recept")
public class CoustmerReceptsController {

    @Autowired
    private CoustmerReceptsService coustmerReceptsService;

    @PostMapping("/create")
    public ResponseEntity<CoustmerRecepts> createCoustmerRecept(@RequestBody CoustmerRecepts coustmerRecepts) {
        CoustmerRecepts createdRecept = coustmerReceptsService.createCoustmerRecept(
                coustmerRecepts.getRecept_expenses_id(),
                coustmerRecepts.getName(),
                coustmerRecepts.getPrice(),
                coustmerRecepts.getCurrency(),
                coustmerRecepts.getDate(),
                coustmerRecepts.getComment(),
                coustmerRecepts.getCategory(),
                coustmerRecepts.isReimbursable(),
                coustmerRecepts.isFullpageimage());
        return ResponseEntity.ok(createdRecept);
    }

    @GetMapping
    public ResponseEntity<List<CoustmerRecepts>> getAllCoustmerRecepts() {
        List<CoustmerRecepts> coustmerReceptsList = coustmerReceptsService.getAllCoustmerRecepts();
        return ResponseEntity.ok(coustmerReceptsList);
    }
}