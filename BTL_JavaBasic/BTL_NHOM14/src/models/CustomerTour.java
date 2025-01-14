package models;

public class CustomerTour {

    private int CustomerId;
    private int tourId;
    private int rate;

    public CustomerTour() {
    }

    public CustomerTour(int CustomerId, int tourId, int rate) {
        this.CustomerId = CustomerId;
        this.tourId = tourId;
        this.rate = rate;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int CustomerId) {
        this.CustomerId = CustomerId;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return CustomerId + "," + tourId + "," + rate;
    }

    public String getResult() {
        if (rate == 0) {
            return "Chưa có đánh giá";
        }

        if (rate >= 85 && rate <= 100) {
            return "A  - Giỏi";
        } else if (rate >= 78 && rate < 85) {
            return "B+ - Khá giỏi";
        } else if (rate >= 70 && rate < 78) {
            return "B  - Khá";
        } else if (rate >= 65 && rate < 70) {
            return "C+ - Trung bình khá";
        } else if (rate >= 55 && rate < 65) {
            return "C  - Trung bình";
        } else if (rate >= 50 && rate < 55) {
            return "D+ - Trung bình yếu";
        } else if (rate >= 40 && rate < 50) {
            return "D  - Yếu";
        } else if (rate < 40) {
            return "F  - Kém";
        } else {
            return "Điểm không hợp lệ";
        }
    }

}
