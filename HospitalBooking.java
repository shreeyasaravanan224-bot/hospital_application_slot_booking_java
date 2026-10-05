import java.util.Scanner;

public class HospitalBooking {

    static Scanner sc = new Scanner(System.in);

    static String[] patients = new String[10];
    static String[] doctors = {
        "Dr. Ananya - Cardiologist",
        "Dr. Rahul - Dermatologist",
        "Dr. Priya - Pediatrician",
        "Dr. Arjun - Orthopedic"
    };

    static String[] slots = {
        "10:00 AM",
        "11:00 AM",
        "12:00 PM",
        "2:00 PM"
    };

    static boolean[] booked = new boolean[4];
    static int patientCount = 0;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== HOSPITAL APPOINTMENT SYSTEM =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Doctors");
            System.out.println("3. View Available Slots");
            System.out.println("4. Book Appointment");
            System.out.println("5. View Patients");
            System.out.println("6. Cancel Appointment");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    viewDoctors();
                    break;

                case 3:
                    viewSlots();
                    break;

                case 4:
                    bookAppointment();
                    break;

                case 5:
                    viewPatients();
                    break;

                case 6:
                    cancelAppointment();
                    break;

                case 7:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);
    }

    static void addPatient() {

        if (patientCount < patients.length) {

            sc.nextLine();

            System.out.print("Enter patient name: ");
            patients[patientCount] = sc.nextLine();

            patientCount++;

            System.out.println("Patient added successfully!");

        } else {
            System.out.println("Patient limit reached!");
        }
    }

    static void viewDoctors() {

        System.out.println("\n--- DOCTORS ---");

        for (int i = 0; i < doctors.length; i++) {
            System.out.println((i + 1) + ". " + doctors[i]);
        }
    }

    static void viewSlots() {

        System.out.println("\n--- AVAILABLE SLOTS ---");

        for (int i = 0; i < slots.length; i++) {

            if (!booked[i]) {
                System.out.println((i + 1) + ". " + slots[i]);
            }
        }
    }

    static void bookAppointment() {

        if (patientCount == 0) {
            System.out.println("Please add a patient first!");
            return;
        }

        viewPatients();

        System.out.print("Select patient number: ");
        int patient = sc.nextInt();

        viewSlots();

        System.out.print("Select slot number: ");
        int slot = sc.nextInt();

        if (slot >= 1 && slot <= 4 && !booked[slot - 1]) {

            booked[slot - 1] = true;

            System.out.println("Appointment booked successfully!");
            System.out.println("Patient: " + patients[patient - 1]);
            System.out.println("Time: " + slots[slot - 1]);

        } else {
            System.out.println("Slot is not available!");
        }
    }

    static void viewPatients() {

        System.out.println("\n--- PATIENTS ---");

        for (int i = 0; i < patientCount; i++) {
            System.out.println((i + 1) + ". " + patients[i]);
        }
    }

    static void cancelAppointment() {

        viewSlots();

        System.out.print("Enter slot number to cancel: ");
        int slot = sc.nextInt();

        if (slot >= 1 && slot <= 4 && booked[slot - 1]) {

            booked[slot - 1] = false;

            System.out.println("Appointment cancelled!");

        } else {
            System.out.println("No appointment found!");
        }
    }
}
