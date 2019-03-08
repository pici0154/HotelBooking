package Domain;

public class HotelValidator {
    /**
     * Validates a hotel.
     *
     * @param hotel the car to validate.
     *              Raises RuntimeException if there are validation errors.
     */
    public void validate(Hotel hotel) {

        int number = hotel.getNrOfDays();
        String errors = "";
        if (number < 0) {
            errors += "The number of days must be greater then 0\n";
        }
        int room = hotel.getNrRoom();
        String strRoom = "" + room;

        if (strRoom == "") {
            errors += "The number of room should not be initial ";
        }
        String feedback = hotel.getFeedBack();
        if (feedback == null) {
            errors += "The feedback must not be null";
        }

        double rating = hotel.getNrRating();
        if (rating < 1 && rating > 5) {
            errors += "The rating should be betwin 1 and 5";
        }

        if (!errors.equals("")) {
            throw new RuntimeException(errors);
        }
    }


}
