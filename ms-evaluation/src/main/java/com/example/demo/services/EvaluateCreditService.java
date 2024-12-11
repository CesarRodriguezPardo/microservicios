package com.example.demo.services;

import com.example.demo.entities.CustomerWorksheetEntity;
import com.example.demo.repositories.CustomerWorksheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluateCreditService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomerWorksheetRepository customerWorksheetRepository;

    public boolean R1feeAndIncomeRatio(double m, String rut){
        CustomerWorksheetEntity worksheetEntity = customerWorksheetRepository.findByRut(rut);

        double ratio = (m / worksheetEntity.getSalary()) * 100;
        return ratio > 35;
    }

    public boolean R2creditHistory(String rut){
        CustomerWorksheetEntity worksheetEntity = customerWorksheetRepository.findByRut(rut);

        return worksheetEntity.getDicom() || worksheetEntity.getLatePayment();
    }

    public boolean R3seniority(String rut){
        CustomerWorksheetEntity worksheetEntity = customerWorksheetRepository.findByRut(rut);
        if (worksheetEntity.getIndependentJob()){
            return worksheetEntity.getIndependentEvaluate();
        }else{
            return (worksheetEntity.getJobSeniority() < 1);
        }
    }

    public boolean R4debtIncome(String rut, double newPayment){
        CustomerWorksheetEntity worksheetEntity = customerWorksheetRepository.findByRut(rut);
        return ((worksheetEntity.getTotalDebts() + newPayment) > (worksheetEntity.getSalary() / 2));
    }

    public boolean R6maxAge(int n, String rut){
        UserEntity user = userRepository.findByRut(rut);
        return (user.getAge() + n) > 70;
    }

}
