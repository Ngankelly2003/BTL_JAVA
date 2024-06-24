package exception;

public class TransmittedDataShowData {
    private String typeData;
    private String backToPage;
    private int tourId;
    private int guideId;
    private int customerId;
    private boolean isCustomer;
    
    public TransmittedDataShowData() {
    }
    
    public TransmittedDataShowData(String typeData, String backToPage, int tourId, int Id, boolean isCustomer ) {
        this.typeData = typeData;
        this.backToPage = backToPage;
        this.tourId = tourId;
        this.isCustomer = isCustomer;
        if(isCustomer) this.customerId  = Id;
        else this.guideId = Id;
    }
    
    public TransmittedDataShowData(String typeData, String backToPage,int Id, boolean isCustomer ) {
        this.typeData = typeData;
        this.backToPage = backToPage;
        this.isCustomer = isCustomer;
        if(isCustomer) this.customerId  = Id;
        else this.guideId = Id;
    }

    public TransmittedDataShowData(String typeData, String backToPage) {
        this.typeData = typeData;
        this.backToPage = backToPage;
    }

    public void setTypeData(String typeData) {
        this.typeData = typeData;
    }

    public void setBackToPage(String backToPage) {
        this.backToPage = backToPage;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public boolean isIsCustomer() {
        return isCustomer;
    }

    public void setIsCustomer(boolean isCustomer) {
        this.isCustomer = isCustomer;
    }
    
    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public void setGuideId(int guideId) {
        this.guideId = guideId;
    }

    public String getTypeData() {
        return typeData;
    }

    public String getBackToPage() {
        return backToPage;
    }

    public int getTourId() {
        return tourId;
    }

    public int getGuideId() {
        return guideId;
    }
}


