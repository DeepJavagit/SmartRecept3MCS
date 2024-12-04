package com.SmartReceptAPI.repo;

import com.SmartReceptAPI.entity.CoustmerRecepts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoustmerReceptsRepository extends JpaRepository<CoustmerRecepts, Long> {
}