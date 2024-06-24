package services;

import dao.*;
import java.util.List;
import models.Tour;

public class TourService {
    
    private TourDao tourDao;
    private DestinateDao DestinateDao;
    
    public TourService(){
        tourDao = new TourDao();
    }
    
    public List<Tour> getAllTours(){
        return tourDao.getAllTours();
    }
    
    public String getDestinateNameById(int DestinateId){
        return tourDao.getDestinateNameById(DestinateId);
    }
    public String getGuideNameById(int GuideId){
        return tourDao.getGuideNameById(GuideId);
    }
    
    public boolean getGuideIdByTour(int tourId){
        return tourDao.getGuideIdByTour(tourId);
    }
    
    public void addTour(Tour tour){
        tourDao.addTour(tour);
    }
    
    public void updateTour(Tour tour, int tourId){
        tourDao.updateTour(tour, tourId);
    }
    
    public void updateGuideIdByTourId(int tourId){
        tourDao.updateGuideIdByTourId(tourId);
    }
    
    public void deleteTourById(int tourId){
        tourDao.deleteTourById(tourId);
    }
    
    public int getIdByTourCode(String tourCode){
        return tourDao.getIdByTourCode(tourCode);
    } 
    
    public Tour getTourById(int tourId){
        return tourDao.getTourById(tourId);
    }
    
    public boolean isExistedTourCode(String code) throws Exception{
        List<Tour> tour_data = tourDao.getAllTours();
        for(Tour tour : tour_data){
            if(tour.getCode().equals(code)){
                return true;
            }
        }
        return false;
    }
    
    public int getGuideIdByTourId(int tourId){
        return tourDao.getGuideIdByTourId(tourId);
    }
    
    public int getDestinateIdByTourId(int tourId){
        return tourDao.getDestinateIdByTourId(tourId);
    }

    public void addListTours(List<Tour> tourData) {
        tourDao.addListTours(tourData);
    }
    public List<Tour> getToursByCustomerId(int CustomerId){
        return tourDao.getToursByCustomerId(CustomerId);
    }
    
    public List<Tour> getToursByDestinateId(int DestinateId){
        return tourDao.getToursByDestinateId(DestinateId);
    }
    
    public List<Tour> getToursByGuideId(int GuideId){
        return tourDao.getToursByGuideId(GuideId);
    }
    
    public Tour getTourByGuideId(int GuideId){
        return tourDao.getTourByGuideId(GuideId);
    }
    
    public Tour getTourByCustomerId(int CustomerId){
        return tourDao.getTourByCustomerId(CustomerId);
    }
}
