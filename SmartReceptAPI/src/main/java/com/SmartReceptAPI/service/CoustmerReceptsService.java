package com.SmartReceptAPI.service;

import com.SmartReceptAPI.entity.CoustmerRecepts;
import com.SmartReceptAPI.repo.CoustmerReceptsRepository;
import com.SmartReceptAPI.repo.RecpExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoustmerReceptsService {

    @Autowired
    private RecpExpensesRepository recpExpensesRepository;

    @Autowired
    private CoustmerReceptsRepository coustmerReceptsRepository;

    public CoustmerRecepts createCoustmerRecept(Long receptExpensesId, String name, Long price, String currency, String date, String comment, String category, boolean reimbursable, boolean fullpageimage) {
        // Validate if RecpExpenses exists
        if (!recpExpensesRepository.existsById(receptExpensesId)) {
            throw new IllegalArgumentException("RecpExpenses not found with ID: " + receptExpensesId);
        }
        // Create and save CoustmerRecepts
        CoustmerRecepts coustmerRecepts = new CoustmerRecepts();
        coustmerRecepts.setName(name);
        coustmerRecepts.setPrice(price);
        coustmerRecepts.setCurrency(currency);
        coustmerRecepts.setDate(date);
        coustmerRecepts.setComment(comment);
        coustmerRecepts.setCategory(category);
        coustmerRecepts.setReimbursable(reimbursable);
        coustmerRecepts.setFullpageimage(fullpageimage);
        coustmerRecepts.setRecept_expenses_id(receptExpensesId);

        return coustmerReceptsRepository.save(coustmerRecepts);
    }


    public List<CoustmerRecepts> getAllCoustmerRecepts() {
        return coustmerReceptsRepository.findAll();

    }
}