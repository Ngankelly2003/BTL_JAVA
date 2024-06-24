package services;

import dao.AccountDao;
import models.Guide;
import java.util.*;
import dao.GuideDao;
import exception.*;
import static exception.Validator.formatName;
import models.Account;

public class GuideService {
    
    private GuideDao GuideDao;
    private AccountDao accountDao;
    
    public  GuideService(){
        GuideDao = new GuideDao();
        accountDao = new AccountDao();
    }
    //Guide
    public List<Guide> getAllGuides(){
        return GuideDao.getAllGuides();
    }
    
    public void addGuide(Guide Guide){
        GuideDao.addGuide(Guide);
    }
    
    public int getIdByGuide(String GuideCode){
        return GuideDao.getIdByGuide(GuideCode);
    }
    
    public int getIdByGuideName(String name){
        return GuideDao.getIdByGuideName(name);
    }
    
    public Guide getGuideById(int GuideId){
        return GuideDao.getGuideById(GuideId);
    }
    
    public void updateGuide(Guide Guide , int GuideId){
        GuideDao.updateGuide(Guide, GuideId);
    }
    
    public void deleteGuideById(int GuideId){
        GuideDao.deleteGuideById(GuideId);
    }
    
    public int getLastAccountId() throws Exception {
        List<Account> data = accountDao.getAllAcounts();
        if (data != null) {
            if (data.size() == 0) {
                return 0;
            }
            return data.get(data.size() - 1).getId();
        }
        return -1;
    }
    
    public int getLastGuideId() throws Exception {
        List<Guide> data = GuideDao.getAllGuides();
        if (data != null) {
            if (data.size() == 0) {
                return 0;
            }
            return data.get(data.size() - 1).getId();
        }
        return -1;
    }
    
    public static String LastName(String name) {
        String[] splitName = formatName(name).split(" ");
        String lastName = "";
        for (int i = 0; i < splitName.length - 1; i++) {
            lastName += (splitName[i] + " ");
        }
        return lastName.trim();
    }

    public static String FirstName(String name) {
        String[] splitName = formatName(name).split(" ");
        return splitName[splitName.length - 1].trim();
    }
    
    public boolean isCheckCodeGuide(String newCode) throws Exception {
        List<Guide> Guides = GuideDao.getAllGuides();
        for (Guide next : Guides) {
            if (next.getCode().equalsIgnoreCase(newCode)) {
                return true;
            }
        }
        return false;
    }
    
    public Guide getGuideByAccountId(int accountId){
        return GuideDao.getGuideByAccountId(accountId);
    }
    
}
