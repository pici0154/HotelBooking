package Repository;

import Domain.Hotel;
import Domain.HotelValidator;

import java.util.ArrayList;
import java.util.List;

public class HotelRepository {

    private List<Hotel> reservations = new ArrayList<>();
    private HotelValidator validator;


    /**
     * Instantiates a repository.
     * @param validator the validator used by this repository.
     */

    public HotelRepository(HotelValidator validator) {
        this.validator = validator;
    }
    private Hotel findById(int id){
        for(Hotel h : reservations){
            if(h.getIdBooking()==id){
                return h;
            }
        }
        return null;
    }
    /**
     * Adds a reservation to the repository.
     * @param reservation the car to add.
     * Raises RuntimeException if there already is a reservation with the given id or the reservation fails validation.
     */
    //check_in
    public void add(Hotel reservation) {
        if (findById(reservation.getIdBooking()) != null) {
            throw new RuntimeException("A reservation with that ID already exists!");
        }

        validator.validate(reservation);
        reservations.add(reservation);
    }
    /**
     * Updates an existing reservation.
     * @param reservation the reservation to be updated.
     * Raises RuntimeException if there is no reseration with reservation's id or the new reservation fails validation.
     */
    //check_out (update - set the rooms free)
    public void update(Hotel reservation) {
        Hotel existingReservation = findById(reservation.getIdBooking());
        if (existingReservation == null) {
            throw new RuntimeException("There is no reservation with the given ID!");
        }

        validator.validate(reservation);
        for (int i = 0; i < reservations.size(); ++i) {
            if (reservations.get(i).getIdBooking() == existingReservation.getIdBooking()) {
                reservations.set(i, reservation);
                return;
            }
        }
    }
    /**
     * @return all reservations in the repository.
     */
    public List<Hotel> getAll() {
        return reservations;
    }
}

