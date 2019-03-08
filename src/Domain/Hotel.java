package Domain;

public class Hotel {
    private int IdBooking;
    private int NrPers;
    private int NrOfDays;
    private int NrRoom;
    private String FeedBack;
    private double NrRating;
    private boolean empty;

    public Hotel(int IdBooking,
                 int NrPers,
                 int NrRoom,
                 String feedback,
                 int NrOfDays) {
        this(IdBooking,NrPers,NrOfDays, NrRoom, "", 0);
        empty = false;
    }

    public Hotel(int idBooking, int nrPers, int nrOfDays, int nrRoom, String feedBack, double nrRating) {
        IdBooking = idBooking;
        NrPers = nrPers;
        NrOfDays = nrOfDays;
        NrRoom = nrRoom;
        FeedBack = feedBack;
        NrRating = nrRating;
    }

    public int getIdBooking() {
        return IdBooking;
    }

    public int getNrPers() {
        return NrPers;
    }

    public int getNrOfDays() {
        return NrOfDays;
    }

    public int getNrRoom() {
        return NrRoom;
    }

    public String getFeedBack() {
        return FeedBack;
    }

    public double getNrRating() {
        return NrRating;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setIdBooking(int idBooking) {
        IdBooking = idBooking;
    }

    public void setNrPers(int nrPers) {
        NrPers = nrPers;
    }

    public void setNrOfDays(int nrOfDays) {
        NrOfDays = nrOfDays;
    }

    public void setNrRoom(int nrRoom) {
        NrRoom = nrRoom;
    }

    public void setFeedBack(String feedBack) {
        FeedBack = feedBack;
    }

    public void setNrRating(double nrRating) {
        NrRating = nrRating;
    }

    public boolean hasLeftRoom() {
        return empty;
    }

    public void setLeftRoom(boolean leftRoom) {
        this.empty = leftRoom;
    }


}
