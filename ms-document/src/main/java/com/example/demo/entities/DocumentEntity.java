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
    @Column(columnDefinition = "LONGBLOB")
    private byte[] savingAccountFile;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] worksheetFile;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] incomeFile;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] appraisalFile;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] creditHistoryFile;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] firstHomeFile;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] businessPlanFile;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] remodelingBudgetFile;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] updatedAppraisalFile;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] financialStatement;

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

