package Service;

import Domain.Hotel;
import Domain.HotelReportViewModel;
import Repository.HotelRepository;
import java.util.*;

public class HotelService {
    private HotelRepository repository;


    public HotelService(HotelRepository repository){this.repository=repository;}

    //add the reservation to the list
    /*private int IdBooking;
    private int NrPers;
    private int NrOfDays;
    private int NrRoom;
    private String FeedBack;
    private int NrRating;
    private boolean empty;*/

    public void enterReservation(int idBooking, int nrPers, int NoOfDays, int NrRoom){
        //check if the room is not reserved
        for (Hotel h : repository.getAll()){
            if(h.getNrRoom()== NrRoom && !h.hasLeftRoom())
            {
                throw new RuntimeException("That room is already taken by another reservation!");
            }
        }

        // if is not reserved, then add the room in the list of reservations
        Hotel hotel=new Hotel (idBooking,nrPers,NoOfDays,NrRoom,"",0);
        repository.add(hotel);
    }

    //remove a reservation from list reservations

    public void leaveRoom(int nrRoom, String feedback, double rating){
        //check if the room is reserved
        for(Hotel h: repository.getAll()){
            if(h.getNrRoom()==nrRoom && !h.hasLeftRoom() ){
                h.setLeftRoom(true);
                h.setFeedBack(feedback);
                h.setNrRating(rating);
                repository.update(h);
                return;
            }
        }
        throw new RuntimeException("There is no room on the given number!");
    }
    //return reservations order descendic by rating average

    public List<HotelReportViewModel> getRoomsReport(){

        //group by number of rooms
        Map<Integer, List<Double>> roomGroups = new HashMap<>();
        for (Hotel h : repository.getAll()) {
            if (h.hasLeftRoom()) {
                int roomNumber = h.getNrRoom();

                if (roomGroups.containsKey(roomNumber)) {
                    roomGroups.get(roomNumber).add(h.getNrRating());
                } else {
                    List<Double> rating = new ArrayList<>();
                    rating.add(h.getNrRating());
                    roomGroups.put(roomNumber, rating);
                }
            }
        }

        List<HotelReportViewModel> result = new ArrayList<>();
        for (Integer roomNumber : roomGroups.keySet()) {
            double average = 0;
            for (Double rating : roomGroups.get(roomNumber)) {
                average += rating;
            }
            average /= roomGroups.get(roomNumber).size();

            result.add(new HotelReportViewModel(roomNumber, average));
        }

        result.sort((v1, v2) -> v1.getRatingAvaerage() > v2.getRatingAvaerage() ? -1 : 0);
        return result;

    }


}
