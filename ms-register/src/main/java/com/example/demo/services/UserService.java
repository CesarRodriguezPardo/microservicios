package com.example.demo.services;

import com.example.demo.clients.DocumentsFeignClient;
import com.example.demo.clients.EvaluationFeignClient;
import com.example.demo.entities.UserEntity;
import com.example.demo.models.CustomerWorksheetModel;
import com.example.demo.models.DocumentModel;
import com.example.demo.models.SavingAccountModel;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EvaluationFeignClient savingAccountRepository;

    @Autowired
    private DocumentsFeignClient documentRepository;


    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }

    public UserEntity findById(Long id) {
        Optional<UserEntity> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get(); // Si el usuario está presente, devolverlo
        } else {
            return null; // O manejar el caso de no encontrar el usuario, por ejemplo, devolviendo null o lanzando una excepción
        }
    }


    public UserEntity findByRut(String rut){
        return userRepository.findByRut(rut);
    }
    public UserEntity findByEmail(String email){
        return userRepository.findByPhone(email);
    }
    public UserEntity findByPhone(String phone){
        return userRepository.findByPhone(phone);
    }

    public String getIdByRut(String rut){
        UserEntity user = userRepository.findByRut(rut);
        if (user != null){
            return Long.toString(user.getId());
        }
        return null;
    }

    public Boolean saveApplication(UserEntity user){
        if ((userRepository.findByRut(user.getRut()) != null) ||
                (userRepository.findByEmail(user.getEmail()) != null) ||
                (userRepository.findByPhone(user.getPhone()) != null)) {
            return false;
        }
        CustomerWorksheetModel worksheetEntity = new CustomerWorksheetModel();
        worksheetEntity.setRut(user.getRut());

        SavingAccountModel savingAccountEntity = new SavingAccountModel();
        savingAccountEntity.setRut(user.getRut());

        user.setVerified(false);
        userRepository.save(user);

        DocumentModel documentEntity = new DocumentModel();
        documentEntity.setUserId(Long.toString(user.getId()));

        savingAccountRepository.saveWorksheet(worksheetEntity);
        savingAccountRepository.save(savingAccountEntity);
        documentRepository.save(documentEntity);
        return true;
    }

    public void deleteByRut(Long id){
        userRepository.deleteById(id);
        CustomerWorksheetModel worksheetEntity = savingAccountRepository.findByIdWorksheet(id);
        savingAccountRepository.deleteByIdWorksheet(worksheetEntity.getId());
        SavingAccountModel savingEntity = savingAccountRepository.findById(id);
        savingAccountRepository.deleteById(savingEntity.getId());
        DocumentModel documentEntity = documentRepository.findById(id);
        documentRepository.deleteById(documentEntity.getId());
    }

    public UserEntity login(String email, String password){
        return userRepository.findByEmailAndPassword(email, password);
    }
    public List<UserEntity> findByVerified(boolean verified){
        return userRepository.findByVerified(verified);}


    // employee

    public void setSeniority(String rut, int seniority) {
        SavingAccountModel savingAccount = savingAccountRepository.findByRut(rut);
        savingAccount.setSeniority(seniority);
    }

    public void setBalance(String rut, float balance) {
        SavingAccountModel savingAccount = savingAccountRepository.findByRut(rut);
        savingAccount.setBalance(balance);
        savingAccountRepository.save(savingAccount);
    }

    public void setDicom(String rut, boolean dicom) {
        CustomerWorksheetModel worksheetEntity = savingAccountRepository.findByRutWorksheet(rut);
        worksheetEntity.setDicom(dicom);
        savingAccountRepository.saveWorksheet(worksheetEntity);
    }

    public void setTotalDebts(String rut, float totalDebts) {
        CustomerWorksheetModel worksheetEntity = savingAccountRepository.findByRutWorksheet(rut);
        worksheetEntity.setTotalDebts(totalDebts);
        savingAccountRepository.saveWorksheet(worksheetEntity);
    }

    public void setIndependentJob(String rut, boolean independentJob) {
        CustomerWorksheetModel worksheetEntity = savingAccountRepository.findByRutWorksheet(rut);
        worksheetEntity.setIndependentJob(independentJob);
        savingAccountRepository.saveWorksheet(worksheetEntity);
    }

    public void setJobSeniority(String rut, int jobSeniority) {
        CustomerWorksheetModel worksheetEntity = savingAccountRepository.findByRutWorksheet(rut);
        worksheetEntity.setJobSeniority(jobSeniority);
        savingAccountRepository.saveWorksheet(worksheetEntity);
    }

    public void setSalary(String rut, int salary) {
        CustomerWorksheetModel worksheetEntity = savingAccountRepository.findByRutWorksheet(rut);
        worksheetEntity.setSalary(salary);
        savingAccountRepository.saveWorksheet(worksheetEntity);
    }

    public void setIndepentEvaluate(String rut, Boolean evaluate) {
        CustomerWorksheetModel worksheetEntity = savingAccountRepository.findByRutWorksheet(rut);
        worksheetEntity.setIndependentEvaluate(evaluate);
        savingAccountRepository.saveWorksheet(worksheetEntity);
    }

    public void setLatePayment(String rut, Boolean latePayment) {
        CustomerWorksheetModel worksheetEntity = savingAccountRepository.findByRutWorksheet(rut);
        worksheetEntity.setLatePayment(latePayment);
        savingAccountRepository.saveWorksheet(worksheetEntity);
    }

    public void setRetiredCash(String rut, float retiredCash) {
        SavingAccountModel savingAccount  = savingAccountRepository.findByRut(rut);
        savingAccount.setRetiredCash(retiredCash);
        savingAccountRepository.save(savingAccount);
    }

    public void setPeriodicDeposit(String rut, float periodicDeposit) {
        SavingAccountModel savingAccount  = savingAccountRepository.findByRut(rut);
        savingAccount.setPeriodicDeposit(periodicDeposit);
        savingAccountRepository.save(savingAccount);
    }

    public void setRecentlyRetiredCash(String rut, float recentlyRetiredCash) {
        SavingAccountModel savingAccount  = savingAccountRepository.findByRut(rut);
        savingAccount.setRecentlyRetiredCash(recentlyRetiredCash);
        savingAccountRepository.save(savingAccount);
    }

    public void verifyCostumer(String rut){
        UserEntity costumer = userRepository.findByRut(rut);
        costumer.setVerified(true);
        userRepository.save(costumer);
    }

}
