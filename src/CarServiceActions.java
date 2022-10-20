import Menu.CarServiceMenu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CarServiceActions {

    protected static void displayMenu(){
        for(CarServiceMenu menu: CarServiceMenu.values()){
            System.out.println(menu.getOptionNumber() + "-" + menu.getOptionDescription());
        }
        System.out.print("Please choose an option: ");
    }

    protected static int readOptionNumberFromConsole(){
        Scanner scanner = new Scanner(System.in);
        boolean isNumber = false;
        int optionNumberFromKeyboard = 0;
        while (!isNumber){
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a number!");
                displayMenu();
                scanner = new Scanner(System.in);
            }
            optionNumberFromKeyboard = scanner.nextInt();
            isNumber = true;
        }
        return optionNumberFromKeyboard;
    }

    protected static void showOptionsScreen(){
        displayMenu();
        while (true){
            int optionNumber = readOptionNumberFromConsole();
            if(optionNumber == CarServiceMenu.DISPLAY_ALL_EXISTING_CARS_IN_SERVICE.getOptionNumber()){
                System.out.println("--ALL CARS THAT EXIST RIGHT NOW IN SERVICE--");
                displayCars();
                System.out.println("If you want to do another operation, please enter an option number");
                displayMenu();
            }else if(optionNumber == CarServiceMenu.ADD_CARS_IN_SERVICE.getOptionNumber()){
                System.out.println("--INTRODUCE A NEW CAR IN SERVICE--");
                addCarsInService();
                System.out.println("If you want to do another operation, please enter an option number");
                displayMenu();
            }else if(optionNumber == CarServiceMenu.ADD_CAR_QUOTE.getOptionNumber()){
                System.out.println("--ADD A CAR QUOTE--");
                addCarQuote();
                System.out.println("If you want to do another operation, please enter an option number");
                displayMenu();
            }else if(optionNumber == CarServiceMenu.DELETE_CARS_FROM_SERVICE.getOptionNumber()){
                System.out.println("--DELETE A CAR FROM SERVICE--");
                displayCars();
                deleteCar();
                System.out.println("If you want to do another operation, please enter an option number");
                displayMenu();
            }else if(optionNumber == CarServiceMenu.EXPORT_ALL_CARS_IN_TEXT_FILE.getOptionNumber()){
                System.out.println("--EXPORT ALL CARS IN A TEXT FILE--");
                addCarsInFile();
                System.out.println("If you want to do another operation, please enter an option number");
                displayMenu();
            }else if(optionNumber == CarServiceMenu.DISPLAY_CARS_OLDER_THAN_2020.getOptionNumber()){
                System.out.println("--DISPLAY CARS OLDER THAN 2020--");
                displayCarsOlderThan2020();
                displayMenu();
            }else if(optionNumber == CarServiceMenu.DISPLAY_CARS_THAT_DONT_START.getOptionNumber()){
                System.out.println("--DISPLAY CARS THAT DON'T START--");
                displayCarsThatDontStart();
                displayMenu();
            }
            else if(optionNumber == CarServiceMenu.EXIT.getOptionNumber()){
                System.exit(0);
            }else {
                System.out.println("This option does not exist!");
                displayMenu();
            }
        }
    }

    protected static ArrayList<Car> createCars(){
        ArrayList<Car> listOfCars = new ArrayList<>();
        listOfCars.add(new Car("SM-05-GDS", "Nechita Carina", "Volvo", "blue", 2014));
        listOfCars.add(new Car("CJ-98-FDT", "Popescu Mihai", "Audi", "red", 2005));
        return listOfCars;
    }

    protected static ArrayList<Car> cars = createCars();

    protected static void displayCars(){
        for(Car car : cars){
            System.out.println(car);
        }
    }

    protected static void addCarsInService(){
        boolean carExists = false;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the registration number of the car: ");
        String registrationNumber = scanner.nextLine();
        for(Car car : cars){
            if(car.getRegistrationNumber().equals(registrationNumber)){
                carExists = true;
                break;
            }
        }
        while (carExists) {
            carExists = false;
            System.out.print("A car with this registration number already exists! Please enter a valid one: ");
            registrationNumber = scanner.nextLine();
            for (Car car : cars) {
                if (car.getRegistrationNumber().equals(registrationNumber)) {
                    carExists = true;
                    break;
                }
            }
        }
        System.out.print("Please enter the owner name: ");
        String ownerName = scanner.nextLine();
        System.out.print("Please enter the brand of the car: ");
        String carBrand = scanner.nextLine();
        System.out.print("Please enter the color of the car: ");
        String carColor = scanner.nextLine();
        System.out.print("Please enter the fabrication year of the car: ");
        int fabricationYear = scanner.nextInt();
        cars.add(new Car(registrationNumber, ownerName, carBrand, carColor, fabricationYear));
        System.out.println("The car was added successfully!");
    }

    protected static void addCarQuote(){
        boolean carExist = false;
        boolean problemExist = false;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the registration number of the car: ");
        String registrationNumber = scanner.nextLine();
        for(Car car : cars){
            if(car.toString().contains(registrationNumber)){
                carExist = true;
                for(Problems problems : Problems.values())
                    System.out.println(problems.getProblemNumber() + "-" + problems);
                System.out.print("Please enter the problem number: ");
                int numberQuote = scanner.nextInt();
                for(Problems problems : Problems.values()){
                    if(numberQuote == problems.getProblemNumber()){
                        problemExist = true;
                        car.setProblemDetails(problems.toString());
                        System.out.println("Success!");
                        break;
                    }
                }
                break;
            }
        }
        if(!carExist) System.out.println("The car with this registration number does not exist in service!");
        if(!problemExist && carExist) System.out.println("The service is not authorized to resolve this problem!");
    }

    protected static void deleteCar(){
        boolean carExist = false;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the registration number of the car you want to delete: ");
        String registrationNumber = scanner.nextLine();
        for(Car car : cars){
            if(car.toString().contains(registrationNumber)){
                carExist = true;
                cars.remove(car);
                System.out.println("The car was removed successfully!");
                break;
            }
        }
        if(!carExist) System.out.println("The car with the registration number you entered does not exist!");
    }
    protected static void addCarsInFile(){
        try {
            File file = new File("cars.txt");
            if(file.createNewFile()){
                System.out.println("The file was created successfully!");
            }else {
                System.out.println("The file already exists!");
            }
        }catch (IOException e){
            System.out.println("The file couldn't be created!");
            e.printStackTrace();
        }
        try {
            FileWriter fileWriter = new FileWriter("cars.txt");
            for(Car car : cars){
                fileWriter.write(car.toString());
                fileWriter.append('\n');
            }
            fileWriter.close();
            System.out.println("The cars were wrote to the file successfully!");
        }catch (IOException e){
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
    }

    protected static void displayCarsOlderThan2020(){
        for(Car car : cars){
            if(car.getFabricationYear() < 2020){
                System.out.println(car);
            }
        }
    }

    protected static void displayCarsThatDontStart(){
        for (Car car : cars){
            if(car.getProblemDetails().equals(Problems.DOESNT_START.toString())){
                System.out.println(car);
            }
        }
    }
}
