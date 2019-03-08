package Domain;

public class HotelReportViewModel {

    private int NrRoom;
    private double ratingAvaerage;

    public HotelReportViewModel(int NrRoom, double ratingAvaerage) {
        this.NrRoom = NrRoom;
        this.ratingAvaerage = ratingAvaerage;
    }

    public int getRoom() {
        return NrRoom;
    }

    public void setRoom(int NrRoom) {
        NrRoom = NrRoom;
    }

    public double getRatingAvaerage() {
        return ratingAvaerage;
    }

    public void setRatingAvaerage(double ratingAvaerage) {
        this.ratingAvaerage = ratingAvaerage;
    }
}
