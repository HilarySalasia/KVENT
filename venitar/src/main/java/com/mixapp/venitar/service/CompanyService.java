package com.mixapp.venitar.service;

import com.mixapp.venitar.entity.Company;
import com.mixapp.venitar.exception.ErrorClass;
import com.mixapp.venitar.exception.InvalidCompanyException;
import com.mixapp.venitar.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;
    ErrorClass errorClass;
    String invalidCompany = "Invalid Company!!";

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public Company findCompany(Long companyId) {
        return companyRepository.getOne(companyId);
    }

    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    public void delCompany(Long companyId) {companyRepository.deleteById(companyId);}

    public Boolean checkCompany(Long companyId) { return companyRepository.existsById(companyId);}

    public Company editCompany(Company company) throws InvalidCompanyException {
        if (checkCompany(company.getCompanyId())) {
            return companyRepository.saveAndFlush(company);
        } else {
            throw new InvalidCompanyException(invalidCompany);
        }
    }

}
