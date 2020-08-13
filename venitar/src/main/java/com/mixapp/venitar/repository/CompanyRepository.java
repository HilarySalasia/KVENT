package com.mixapp.venitar.repository;

import com.mixapp.venitar.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
