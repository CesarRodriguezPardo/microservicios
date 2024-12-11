package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "savingAccountEntity")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SavingAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    String rut;
    int seniority; // in years
    float balance;

    float retiredCash;
    float periodicDeposit;
    float recentlyRetiredCash;


    int negativePoints = 0;
    int typeCapacity;


    public Long getId() {
        return id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getRetiredCash() {
        return retiredCash;
    }

    public void setRetiredCash(float retiredCash) {
        this.retiredCash = retiredCash;
    }

    public float getPeriodicDeposit() {
        return periodicDeposit;
    }

    public void setPeriodicDeposit(float periodicDeposit) {
        this.periodicDeposit = periodicDeposit;
    }

    public float getRecentlyRetiredCash() {
        return recentlyRetiredCash;
    }

    public void setRecentlyRetiredCash(float recentlyRetiredCash) {
        this.recentlyRetiredCash = recentlyRetiredCash;
    }

    public int getNegativePoints() {
        return negativePoints;
    }

    public void setNegativePoints(int negativePoints) {
        this.negativePoints = negativePoints;
    }

    public int getTypeCapacity() {
        return typeCapacity;
    }

    public void setTypeCapacity(int typeCapacity) {
        this.typeCapacity = typeCapacity;
    }
}
