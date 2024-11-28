package com.SmartReceptAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SmartReceptAPI.entity.RecpExpenses;

public interface RecpExpensesRepository extends JpaRepository<RecpExpenses, Long> {
    RecpExpenses findByName(String name);
}
