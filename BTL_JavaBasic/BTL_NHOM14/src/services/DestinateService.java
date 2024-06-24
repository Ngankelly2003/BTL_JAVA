package services;

import dao.DestinateDao;
import models.*;

import java.util.List;


// Lớp Service: Triển khai và sử lý logic từ lớp DAO
public class DestinateService {
    
    private DestinateDao DestinateDao;
    
    public DestinateService() {
        DestinateDao = new DestinateDao();
    }
    // GetAll
    public List<Destinate> getAllDestinate(){
        return DestinateDao.getAllDestinate();
    }
    
    // GetId
    public int GetIdByDestinate(String code, String name, String description, String TimeStay, String SleepPlace, String address){
        return DestinateDao.getIdByDestinate(code, name, description, TimeStay, SleepPlace, address);
    }
    public int getIdByDestinateName(String name){
        return DestinateDao.getIdByDestinateName(name);
    }
    
    // GetDestinate
    public Destinate getDestinateById(int DestinateId){
        return DestinateDao.getDestinateById(DestinateId);
    }
    
    // Add
    public void addDestinate(Destinate Destinate){
        DestinateDao.addDestinate(Destinate);
    }
    
    // Update
    public void updateDestinate(Destinate Destinate , int id){
        DestinateDao.updateDestinate(Destinate , id);
    }
    
    // Delete 
    public void deleteDestinateById(int DestinateId) {
        DestinateDao.deleteDestinateById(DestinateId);
    }
    
    // Kiểm tra tồn tại mã doanh nghiệp
    public boolean isExistedComCode(String DestinateCode) {
        List<Destinate> Destinate_data = DestinateDao.getAllDestinate();
        for (Destinate com : Destinate_data) {
            if (com.getCode().trim().equals(DestinateCode.trim())) {
                return true;
            }
        }
        return false;
    }

    // Kiểm tra tồn tại tên doanh nghiệp
    public boolean isExistedComName(String DestinateName) {
        List<Destinate> Destinate_data = DestinateDao.getAllDestinate();
        for(Destinate com : Destinate_data){
            if(com.getName().trim().equals(DestinateName.trim())){
                return true;
            }
        }
        return false;
    }
}
