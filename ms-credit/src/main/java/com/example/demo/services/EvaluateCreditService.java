package com.example.demo.services;

import com.example.demo.clients.EvaluationFeignClient;
import com.example.demo.clients.RegisterFeignClient;
import com.example.demo.models.CustomerWorksheetModel;
import com.example.demo.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluateCreditService {
    @Autowired
    RegisterFeignClient registerFeignClient;

    @Autowired
    EvaluationFeignClient customerWorksheetRepository;

    public boolean R1feeAndIncomeRatio(double m, String rut){
        CustomerWorksheetModel worksheetEntity = customerWorksheetRepository.findByRutWorksheet(rut);

        double ratio = (m / worksheetEntity.getSalary()) * 100;
        return ratio > 35;
    }

    public boolean R2creditHistory(String rut){
        CustomerWorksheetModel worksheetEntity = customerWorksheetRepository.findByRutWorksheet(rut);

        return worksheetEntity.getDicom() || worksheetEntity.getLatePayment();
    }

    public boolean R3seniority(String rut){
        CustomerWorksheetModel worksheetEntity = customerWorksheetRepository.findByRutWorksheet(rut);
        if (worksheetEntity.getIndependentJob()){
            return worksheetEntity.getIndependentEvaluate();
        }else{
            return (worksheetEntity.getJobSeniority() < 1);
        }
    }

    public boolean R4debtIncome(String rut, double newPayment){
        CustomerWorksheetModel worksheetEntity = customerWorksheetRepository.findByRutWorksheet(rut);
        return ((worksheetEntity.getTotalDebts() + newPayment) > (worksheetEntity.getSalary() / 2));
    }

    public boolean R6maxAge(int n, String rut){
        UserModel user = registerFeignClient.findByRut(rut);
        return (user.getAge() + n) > 70;
    }

}
