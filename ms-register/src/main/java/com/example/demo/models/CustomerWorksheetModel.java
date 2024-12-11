package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CustomerWorksheetModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    String rut;

    Boolean dicom;
    float totalDebts;

    private Boolean independentJob;
    private int jobSeniority;
    private float salary;
    private Boolean independentEvaluate;
    private Boolean latePayment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Boolean getDicom() {
        return dicom;
    }

    public void setDicom(Boolean dicom) {
        this.dicom = dicom;
    }

    public float getTotalDebts() {
        return totalDebts;
    }

    public void setTotalDebts(float totalDebts) {
        this.totalDebts = totalDebts;
    }

    public Boolean getIndependentJob() {
        return independentJob;
    }

    public void setIndependentJob(Boolean independentJob) {
        this.independentJob = independentJob;
    }

    public int getJobSeniority() {
        return jobSeniority;
    }

    public void setJobSeniority(int jobSeniority) {
        this.jobSeniority = jobSeniority;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Boolean getIndependentEvaluate() {
        return independentEvaluate;
    }

    public void setIndependentEvaluate(Boolean independentEvaluate) {
        this.independentEvaluate = independentEvaluate;
    }

    public Boolean getLatePayment() {
        return latePayment;
    }

    public void setLatePayment(Boolean latePayment) {
        this.latePayment = latePayment;
    }

}
