package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CreditEntity")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    // Attributes related to the characteristics of the credit
    private int requestedAmount;
    private int requestedTerm;
    private float interestRate;
    private int status;
    private int type;
    private String rejectedReason;

    // Attribute related to the userId that the user requested
    private String rut;

    public Long getId(){
        return id;
    }
    public int getRequestedAmount(){
        return requestedAmount;
    }
    public int getRequestedTerm(){
        return requestedTerm;
    }
    public float getInterestRate(){
        return interestRate;
    }
    public int getStatus(){
        return status;
    }
    public int getType(){
        return type;
    }
    public String getRejectedReason(){
        return rejectedReason;
    }
    public String getRut(){
        return rut;
    }
    public void setRequestedAmount(int requestedAmount){
        this.requestedAmount = requestedAmount;
    }
    public void setRequestedTerm(int requestedTerm){
        this.requestedTerm = requestedTerm;
    }
    public void setInterestRate(float interestRate){
        this.interestRate = interestRate;
    }
    public void setStatus(int status){
        this.status = status;
    }
    public void setType(int type){
        this.type = type;
    }
    public void setRejectedReason(String rejectedReason){
        this.rejectedReason = rejectedReason;
    }
    public void setRut(String rut){
        this.rut = rut;
    }
}

