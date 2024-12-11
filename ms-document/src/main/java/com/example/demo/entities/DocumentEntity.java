package com.example.demo.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DocumentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    @Lob
    private byte[] savingAccountFile; // cuenta de ahorros

    @Lob
    private byte[] worksheetFile; // planilla

    @Lob
    private byte[] incomeFile; // comprobante de ingresos

    @Lob
    private byte[] appraisalFile; // certificado de avalúo

    @Lob
    private byte[] creditHistoryFile; //historial crediticio

    @Lob
    private byte[] firstHomeFile; // escritura primera vivienda

    @Lob
    private byte[] businessPlanFile; // plan de negocios

    @Lob
    private byte[] remodelingBudgetFile; // presupuesto de remodelación

    @Lob
    private byte[] updatedAppraisalFile; // certificado avalúo actualizado

    @Lob
    private byte[] financialStatement; // estado financiero del negocio

    // Getters
    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public byte[] getSavingAccountFile() {
        return savingAccountFile;
    }

    public byte[] getWorksheetFile() {
        return worksheetFile;
    }

    public byte[] getIncomeFile() {
        return incomeFile;
    }

    public byte[] getAppraisalFile() {
        return appraisalFile;
    }

    public byte[] getCreditHistoryFile() {
        return creditHistoryFile;
    }

    public byte[] getFirstHomeFile() {
        return firstHomeFile;
    }

    public byte[] getBusinessPlanFile() {
        return businessPlanFile;
    }

    public byte[] getRemodelingBudgetFile() {
        return remodelingBudgetFile;
    }

    public byte[] getUpdatedAppraisalFile() {
        return updatedAppraisalFile;
    }

    public byte[] getFinancialStatement() {
        return financialStatement;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setSavingAccountFile(byte[] savingAccountFile) {
        this.savingAccountFile = savingAccountFile;
    }

    public void setWorksheetFile(byte[] worksheetFile) {
        this.worksheetFile = worksheetFile;
    }

    public void setIncomeFile(byte[] incomeFile) {
        this.incomeFile = incomeFile;
    }

    public void setAppraisalFile(byte[] appraisalFile) {
        this.appraisalFile = appraisalFile;
    }

    public void setCreditHistoryFile(byte[] creditHistoryFile) {
        this.creditHistoryFile = creditHistoryFile;
    }

    public void setFirstHomeFile(byte[] firstHomeFile) {
        this.firstHomeFile = firstHomeFile;
    }

    public void setBusinessPlanFile(byte[] businessPlanFile) {
        this.businessPlanFile = businessPlanFile;
    }

    public void setRemodelingBudgetFile(byte[] remodelingBudgetFile) {
        this.remodelingBudgetFile = remodelingBudgetFile;
    }

    public void setUpdatedAppraisalFile(byte[] updatedAppraisalFile) {
        this.updatedAppraisalFile = updatedAppraisalFile;
    }

    public void setFinancialStatement(byte[] financialStatement) {
        this.financialStatement = financialStatement;
    }
}

