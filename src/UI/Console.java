package UI;

import Domain.HotelReportViewModel;
import Service.HotelService;

import java.util.List;
import java.util.Scanner;

public class Console {

    private HotelService service;
    private Scanner in = new Scanner(System.in);

    public Console(HotelService service) {
        this.service = service;
    }

    private void showMenu() {
        System.out.println("1. Check-in");
        System.out.println("2. Check-out");
        System.out.println("3. Show rooms in descending order by rating");
        System.out.println("0. Exit.");
        System.out.print("Your option: ");
    }

    private void AddRoom() {
        System.out.print("Booking id: ");
        int id = in.nextInt();
        System.out.print("Number of persons: ");
        int nrPers = in.nextInt();
        System.out.print("Number of room: ");
        int nrRoom = in.nextInt();
        System.out.print("Number of days: ");
        int days = in.nextInt();

        try {
            service.enterReservation(id,nrPers,days, nrRoom);
            System.out.println("Reservation added successfully!");
        } catch (RuntimeException rex) {
            System.out.println("We have errors:");
            System.out.println(rex.getMessage());
        }
    }

    private void LeaveRoom() {
        System.out.print("Room number: ");
        int roomNumber = in.nextInt();
        System.out.print("Feedback: ");
        in.nextLine();
        String feedback = in.nextLine();
        System.out.print("Rating: ");
        double rating = in.nextDouble();

        try {
            service.leaveRoom(roomNumber, feedback, rating);
            System.out.println("Room left successfully!");
        } catch (RuntimeException rex) {
            System.out.println("We have errors:");
            System.out.println(rex.getMessage());
        }
    }

    private void showRating() {

        List<HotelReportViewModel> roomReports = service.getRoomsReport();
        for (HotelReportViewModel roomReport : roomReports) {
            System.out.println(String.format("Room: %d Rating Average: %f", roomReport.getRoom(), roomReport.getRatingAvaerage()));
        }
    }

    public void run() {

        while (true) {
            showMenu();

            int option = in.nextInt();
            if (option == 1) {
                AddRoom();
            } else if (option == 2) {
                LeaveRoom();
            } else if (option == 3) {
                showRating();
            } else if (option == 0) {
                break;
            } else {
                System.out.println("Invalid option!");
            }
        }
    }
}