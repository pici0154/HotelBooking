import UI.Console;
import Domain.HotelValidator;
import Repository.HotelRepository;
import Service.HotelService;

public class Main {

    public static void main(String[] args) {
        HotelValidator hotelValidator = new HotelValidator();
        HotelRepository hotelRepository = new HotelRepository(hotelValidator);
        HotelService hotelService = new HotelService(hotelRepository);
        Console console = new Console(hotelService);
        console.run();

    }
}
