/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupprojecttaxi;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Luana Kimley & Shakira Lynch
 */
public class MainApp
{

    public static void main(String[] args) throws IOException
    {

        

        Car car1 = new Car("16-C-3619", 5, 5260.5, 2015, 20500);
        Car car2 = new Car("23-D-2517", 7, 10672.78, 2012, 15200.5);
        Car car3 = new Car(5, 2010, 14000);
        Car car4 = new Car(7, 2011, 14000);
        Car car5 = new Car();

        TaxiCompany dundalkTaxi = new TaxiCompany("Dundalk Taxi", "Jane Connor", 7);

        
        readFile("cars.txt", dundalkTaxi);

        dundalkTaxi.addCar(car1);
        dundalkTaxi.addCar(car2);
        dundalkTaxi.addCar(car3);
        dundalkTaxi.addCar(car4);
        dundalkTaxi.addCar(car5);

        printMenu();

        int option = inputValidInt(1, 9, "Input option: ", "Invalid menu option");

        while (option != 9)
        {
            switch (option)
            {
                case 1:
                    displayOption(dundalkTaxi);
                    break;
                case 2:
                    countOption(dundalkTaxi);
                    break;
                case 3:
                    addOption(dundalkTaxi);
                    break;
                case 4:
                    findOption(dundalkTaxi);
                    break;
                case 5:
                    deleteOption(dundalkTaxi);
                    break;
                case 6:
                    sortOption(dundalkTaxi);
                    break;
                case 7:
                    editOption(dundalkTaxi);
                    break;
                case 8:
                    calculateOption(dundalkTaxi);
                    break;
            }
            printMenu();
            option = inputValidInt(1, 9, "Input option: ", "Invalid menu option");
        }
        System.out.println("\nProgram ending - thank you");

    }

    // Main Menu
    /**
     * Displays the main menu
     */
    public static void printMenu()
    {
        System.out.println("\nMain Menu - Cars System");
        System.out.println("1. Option 1- Display methods");
        System.out.println("2. Option 2- Count methods");
        System.out.println("3. Option 3- Add methods");
        System.out.println("4. Option 4- Find methods");
        System.out.println("5. Option 5- Delete methods");
        System.out.println("6. Option 6- Sort methods");
        System.out.println("7. Option 7- Edit methods");
        System.out.println("8. Option 8- Calculation methods");
        System.out.println("9. Exit");
    }

    // Display Menu
    /**
     * Displays the display menu
     */
    public static void printDisplayMenu()
    {
        System.out.println("\nOption 1- Display methods");
        System.out.println("1. Display all cars");
        System.out.println("2. Display cars by registration");
        System.out.println("3. Display cars by number of seats");
        System.out.println("4. Display cars by kms");
        System.out.println("5. Display cars by year made");
        System.out.println("6. Display cars by car price");
        System.out.println("7. Back to main menu");
    }

    /**
     * Displays the display by KMs menu
     */
    public static void printDisplayCarsByKmsMenu()
    {
        System.out.println("\nDisplay cars by kms...");
        System.out.println("1. Display cars if kms more than...");
        System.out.println("2. Display cars if kms less than...");
        System.out.println("3. Display cars if kms in the range of...");
        System.out.println("4. Back to display menu");
    }

    /**
     * Displays the display by year made menu
     */
    public static void printDisplayCarsByYearMadeMenu()
    {
        System.out.println("\nDisplay cars by year made...");
        System.out.println("1. Display cars older than ... years old");
        System.out.println("2. Display cars newer than ... years old");
        System.out.println("3. Display cars made in certain year");
        System.out.println("4. Back to display menu");
    }

    /**
     * Displays the display by car price menu
     */
    public static void printDisplayCarsByCarPriceMenu()
    {
        System.out.println("\nDisplay cars by car price...");
        System.out.println("1. Display cars cheaper than...");
        System.out.println("2. Display cars dearer than...");
        System.out.println("3. Display cars if price in the range of...");
        System.out.println("4. Back to display menu");
    }

    /**
     * Options for display methods
     * @param t TaxiCompany container
     */
    public static void displayOption(TaxiCompany t)
    {
        Scanner keyboard = new Scanner(System.in);

        printDisplayMenu();
        int displayOption = inputValidInt(1, 7, "Input option: ", "Invalid menu option");
        while (displayOption != 7)
        {
            switch (displayOption)
            {
                case 1: //display all cars
                    System.out.println("\nDisplaying all cars...");
                    t.displayCars();
                    break;
                case 2: //display cars by county
                    System.out.println("\nEnter county initial: ");
                    String initial = keyboard.nextLine();
                    System.out.println("Displaying cars with county initial '" + initial.toUpperCase() + "'...");
                    t.displayCarIfRegInCertainCounty(initial.toUpperCase());
                    break;
                case 3: //display cars by number of seats
                    System.out.println("\nEnter number of seats: ");
                    int numSeats = keyboard.nextInt();
                    System.out.println("Displaying cars with " + numSeats + " seats...");
                    t.displayCarIfCertainAmountOfSeats(numSeats);
                    break;
                case 4: //display cars by kms
                    printDisplayCarsByKmsMenu();
                    int displayByKmOption = inputValidInt(1, 4, "Input option: ", "Invalid menu option");
                    while (displayByKmOption != 4)
                    {
                        switch (displayByKmOption)
                        {
                            case 1: //display cars with kms over
                                System.out.println("\nEnter kms: ");
                                double kmsOver = keyboard.nextDouble();
                                System.out.println("\nDisplaying cars with kms over " + kmsOver + "...");
                                t.displayCarIfOverCertainKms(kmsOver);
                                break;
                            case 2: //display cars with kms less than
                                System.out.println("\nEnter kms: ");
                                double kmsLess = keyboard.nextDouble();
                                System.out.println("\nDisplaying cars with kms less than " + kmsLess + "...");
                                t.displayCarIfLessCertainKms(kmsLess);
                                break;
                            case 3: //display cars with kms in the range
                                System.out.println("\nEnter minimum kms: ");
                                double minKms = keyboard.nextDouble();
                                System.out.println("\nEnter maximum kms: ");
                                double maxKms = keyboard.nextDouble();
                                System.out.println("\nDisplaying cars with kms in the range of " + minKms + " and " + maxKms + "...");
                                t.displayCarIfKmInRange(minKms, maxKms);
                        }
                        printDisplayCarsByKmsMenu();
                        displayByKmOption = inputValidInt(1, 4, "Input option: ", "Invalid menu option");
                    }
                    break;
                case 5: //display cars by year made
                    printDisplayCarsByYearMadeMenu();
                    int displayByYearMadeOption = inputValidInt(1, 4, "Input option: ", "Invalid menu option");
                    while (displayByYearMadeOption != 4)
                    {
                        switch (displayByYearMadeOption)
                        {
                            case 1: //display cars older than
                                System.out.println("\nEnter age limit: ");
                                int age = keyboard.nextInt();
                                System.out.println("\nDisplaying cars older than " + age + " years old...");
                                t.displayCarsOlderThan(age);
                                break;
                            case 2: //display cars newer than
                                System.out.println("\nEnter age limit: ");
                                age = keyboard.nextInt();
                                System.out.println("\nDisplaying cars older than " + age + " years old...");
                                t.displayCarsNewerThan(age);
                                break;
                            case 3: //display cars made in certain year
                                System.out.println("\nEnter year: ");
                                int year = keyboard.nextInt();
                                System.out.println("\nDisplaying cars made in " + year + "...");
                                t.displayCarIfInCertainYear(year);
                                break;
                        }
                        printDisplayCarsByYearMadeMenu();
                        displayByYearMadeOption = inputValidInt(1, 4, "Input option: ", "Invalid menu option");
                    }
                    break;
                case 6: //display cars by car price
                    printDisplayCarsByCarPriceMenu();
                    int displayByPriceOption = inputValidInt(1, 4, "Input option: ", "Invalid menu option");
                    while (displayByPriceOption != 4)
                    {
                        switch (displayByPriceOption)
                        {
                            case 1: //display cars cheaper than
                                System.out.println("\nEnter price: ");
                                double price = keyboard.nextDouble();
                                System.out.println("\nDisplaying cars with price cheaper than " + price + "...");
                                t.displayCarCheaperThan(price);
                                break;
                            case 2: //display cars dearer than
                                System.out.println("\nEnter price: ");
                                price = keyboard.nextDouble();
                                System.out.println("\nDisplaying cars with price dearer than " + price + "...");
                                t.displayCarDearerThan(price);
                                break;
                            case 3: //display cars with price in the range 
                                System.out.println("\nEnter minimum price: ");
                                double minPrice = keyboard.nextDouble();
                                System.out.println("\nEnter maximum price: ");
                                double maxPrice = keyboard.nextDouble();
                                System.out.println("\nDisplaying cars with price in the range of " + minPrice + " and " + maxPrice + "...");
                                t.displayCarIfPriceInRange(minPrice, maxPrice);
                                break;
                        }
                        printDisplayCarsByCarPriceMenu();
                        displayByPriceOption = inputValidInt(1, 4, "Input option: ", "Invalid menu option");
                    }
                    break;
            }
            printDisplayMenu();
            displayOption = inputValidInt(1, 7, "Input option: ", "Invalid menu option");
        }
    }

    // Count Menu
    /**
     * Displays the count menu
     */
    public static void printCountMenu()
    {
        System.out.println("\nOption 2- Count methods");
        System.out.println("1. Count all cars");
        System.out.println("2. Count cars by registration");
        System.out.println("3. Count cars by number of seats");
        System.out.println("4. Count cars by kms");
        System.out.println("5. Count cars by year made");
        System.out.println("6. Count cars by car price");
        System.out.println("7. Back to main menu");
    }

    /**
     * Displays the count cars by price menu
     */
    public static void printCountCarsByCarPriceMenu()
    {
        System.out.println("\nCount cars by car price...");
        System.out.println("1. Count cars cheaper than...");
        System.out.println("2. Count cars dearer than...");
        System.out.println("3. Count cars if price in the range of...");
        System.out.println("4. Back to count menu");
    }

    /**
     * Displays the count cars by KMs menu
     */
    public static void printCountCarsByKmsMenu()
    {
        System.out.println("\nCount cars by kms...");
        System.out.println("1. Count cars if kms more than...");
        System.out.println("2. Count cars if kms less than...");
        System.out.println("3. Count cars if kms in the range of...");
        System.out.println("4. Back to count menu");
    }

    /**
     * Displays the count cars by year made menu
     */
    public static void printCountCarsByYearMadeMenu()
    {
        System.out.println("\nCount cars by year made...");
        System.out.println("1. Count cars older than ... years old");
        System.out.println("2. Count cars newer than ... years old");
        System.out.println("3. Count cars made in certain year");
        System.out.println("4. Back to count menu");
    }

    /**
     * Options for count methods
     * @param t TaxiCompany container
     */
    public static void countOption(TaxiCompany t)
    {
        Scanner keyboard = new Scanner(System.in);

        printCountMenu();
        int countOption = inputValidInt(1, 7, "Input option: ", "Invalid menu option");
        while (countOption != 7)
        {
            switch (countOption)
            {
                case 1: //count all cars
                    System.out.println("\nCounting all cars...");
                    System.out.println(t.countCars());
                    break;
                case 2: //count cars by county
                    System.out.println("\nEnter county initial: ");
                    String initial = keyboard.nextLine();
                    System.out.println("Counting cars with county initial '" + initial.toUpperCase() + "'...");
                    System.out.println(t.countCarIfRegInCertainCounty(initial.toUpperCase()));
                    break;
                case 3: //count cars by number of seats
                    System.out.println("\nEnter number of seats: ");
                    int numSeats = keyboard.nextInt();
                    System.out.println("Counting cars with " + numSeats + " seats...");
                    System.out.println(t.countCarIfCertainNumberOfSeats(numSeats));
                    break;
                case 4: //count cars by kms
                    printCountCarsByKmsMenu();
                    int countByKmOption = inputValidInt(1, 4, "Input option: ", "Invalid menu option");
                    while (countByKmOption != 4)
                    {
                        switch (countByKmOption)
                        {
                            case 1: //count cars with kms over
                                System.out.println("\nEnter kms: ");
                                double kmsOver = keyboard.nextDouble();
                                System.out.println("\nCounting cars with kms over " + kmsOver + "...");
                                System.out.println(t.countCarIfOverCertainKms(kmsOver));
                                break;
                            case 2: //count cars with kms less than
                                System.out.println("\nEnter kms: ");
                                double kmsLess = keyboard.nextDouble();
                                System.out.println("\nCounting cars with kms less than " + kmsLess + "...");
                                System.out.println(t.countCarIfLessThanCertainKms(kmsLess));
                                break;
                            case 3: //count cars with kms in the range
                                System.out.println("\nEnter minimum kms: ");
                                double minKms = keyboard.nextDouble();
                                System.out.println("\nEnter maximum kms: ");
                                double maxKms = keyboard.nextDouble();
                                System.out.println("\nCounting cars with kms in the range of " + minKms + " and " + maxKms + "...");
                                System.out.println(t.countCarIfKmInRange(minKms, maxKms));
                        }
                        printCountCarsByKmsMenu();
                        countByKmOption = inputValidInt(1, 4, "Input option: ", "Invalid menu option");
                    }
                    break;
                case 5: //count cars by year made
                    printCountCarsByYearMadeMenu();
                    int countByYearMadeOption = inputValidInt(1, 4, "Input option: ", "Invalid menu option");
                    while (countByYearMadeOption != 4)
                    {
                        switch (countByYearMadeOption)
                        {
                            case 1: //count cars older than
                                System.out.println("\nEnter age limit: ");
                                int age = keyboard.nextInt();
                                System.out.println("\nCounting cars older than " + age + " years old...");
                                System.out.println(t.countCarsOlderThan(age));
                                break;
                            case 2: //count cars newer than
                                System.out.println("\nEnter age limit: ");
                                age = keyboard.nextInt();
                                System.out.println("\nCounting cars older than " + age + " years old...");
                                System.out.println(t.countCarsNewerThan(age));
                                break;
                            case 3: //count cars made in certain year
                                System.out.println("\nEnter year: ");
                                int year = keyboard.nextInt();
                                System.out.println("\nCounting cars made in " + year + "...");
                                System.out.println(t.countCarIfMadeInCertainYear(year));
                                break;
                        }
                        printCountCarsByYearMadeMenu();
                        countByYearMadeOption = inputValidInt(1, 4, "Input option: ", "Invalid menu option");
                    }
                    break;
                case 6: //count cars by car price
                    printCountCarsByCarPriceMenu();
                    int countByPriceOption = inputValidInt(1, 4, "Input option: ", "Invalid menu option");
                    while (countByPriceOption != 4)
                    {
                        switch (countByPriceOption)
                        {
                            case 1: //count cars cheaper than
                                System.out.println("\nEnter price: ");
                                double price = keyboard.nextDouble();
                                System.out.println("\nCounting cars with price cheaper than " + price + "...");
                                System.out.println(t.countCarCheaperThan(price));
                                break;
                            case 2: //count cars dearer than
                                System.out.println("\nEnter price: ");
                                price = keyboard.nextDouble();
                                System.out.println("\nCounting cars with price dearer than " + price + "...");
                                System.out.println(t.countCarDearerThan(price));
                                break;
                            case 3: //count cars with price in the range
                                System.out.println("\nEnter minimum price: ");
                                double minPrice = keyboard.nextDouble();
                                System.out.println("\nEnter maximum price: ");
                                double maxPrice = keyboard.nextDouble();
                                System.out.println("\nDisplaying cars with price in the range of " + minPrice + " and " + maxPrice + "...");
                                System.out.println(t.countCarIfPriceInRange(minPrice, maxPrice));
                                break;
                        }
                        printCountCarsByCarPriceMenu();
                        countByPriceOption = inputValidInt(1, 4, "Input option: ", "Invalid menu option");
                    }
                    break;
            }
            printCountMenu();
            countOption = inputValidInt(1, 7, "Input option: ", "Invalid menu option");
        }
    }

    /**
     * Displays add menu
     */
    public static void printAddMenu()
    {
        System.out.println("\nOption 3- Add method");
        System.out.println("1. Adding a car");
        System.out.println("2. Back to main Menu");

    }

    /**
     * Options for add methods
     * @param t TaxiCompany container
     */
    public static void addOption(TaxiCompany t)
    {
        Scanner keyboard = new Scanner(System.in);

        printAddMenu();
        int addOption = inputValidInt(1, 2, "Input Option: ", "Invalid menu Option");
        while (addOption != 2)
        {
            switch (addOption)
            {
                case 1:
                    System.out.println("\nAdding all details of the car:");
                    System.out.println("Adding a car registration");
                    System.out.println("Please enter the car registration: ");
                    String reg = keyboard.nextLine();

                    System.out.println("Adding the number of seats in the car");
                    System.out.println("Please enter the number of seats in the car: ");
                    int numSeat = keyboard.nextInt();

                    System.out.println("Adding the amount of kilometers");
                    System.out.println("Please enter the amount of kilometers: ");
                    double kms = keyboard.nextDouble();

                    System.out.println("Adding the year the car was made");
                    System.out.println("Please enter the year the car was made: ");
                    int yearMade = keyboard.nextInt();

                    System.out.println("Adding the car price");
                    System.out.println("Please enter the car price: ");
                    double carPrice = keyboard.nextDouble();
                    Car newCar = new Car(reg, numSeat, kms, yearMade, carPrice);
                    t.addCar(newCar);
                    break;
            }
            printAddMenu();
            addOption = inputValidInt(1, 2, "Input Option: ", "Invalid menu Option");
        }
    }

    /**
     * displays the find menu
     */
    public static void printFindMenu()
    {
        System.out.println("\nOption 5- Find methods");
        System.out.println("1. Finding a car by car price");
        System.out.println("2. Finding a car by registration");
        System.out.println("3. Finding a car by kms");
        System.out.println("4. Finding a car by year made");
        System.out.println("5. Back to main Menu");

    }

    /**
     * Options for find methods
     * @param t TaxiCompany container
     */
    public static void findOption(TaxiCompany t)
    {
        Scanner keyboard = new Scanner(System.in);

        printFindMenu();
        int findOption = inputValidInt(1, 5, "Input option: ", "Invalid menu option");
        while (findOption != 5)
        {
            switch (findOption)
            {
                case 1: //find car by price
                    System.out.println("\nEnter a car price: ");
                    double carPrice = keyboard.nextDouble();
                    System.out.println("\nFinding car with the entered car price " + carPrice + "...");
                    System.out.println(t.findCarByPrice(carPrice));
                    break;
                case 2: //find car by registration
                    System.out.println("\nEnter a registration: ");
                    String registration = keyboard.nextLine();
                    System.out.println("\nFinding car with the entered registration " + registration + "...");
                    System.out.println(t.findCarByRegistration(registration));
                    break;
                case 3: //find car by kms
                    System.out.println("\nEnter a car kms: ");
                    double kms = keyboard.nextDouble();
                    System.out.println("\nFinding car with the entered kms " + kms + "...");
                    System.out.println(t.findCarByKms(kms));
                    break;
                case 4: //find car by year made
                    System.out.println("\nEnter a year: ");
                    int yearMade = keyboard.nextInt();
                    System.out.println("\nFinding car with the entered year " + yearMade + "...");
                    System.out.println(t.findCarByYearMade(yearMade));
                    break;
            }
            printFindMenu();
            findOption = inputValidInt(1, 5, "Input option: ", "Invalid menu option");
        }
    }

    // Delete Menu
    /**
     * Displays the delete menu
     */
    public static void printDeleteMenu()
    {
        System.out.println("\nOption 5- Delete methods");
        System.out.println("1. Delete all cars");
        System.out.println("2. Delete cars by registration");
        System.out.println("3. Delete cars by number of seats");
        System.out.println("4. Delete cars by kms");
        System.out.println("5. Delete cars by year made");
        System.out.println("6. Delete cars by car price");
        System.out.println("7. Back to main menu");
    }

    /**
     * Displays the delete car by registration menu
     */
    public static void printDeleteCarsByRegistrationMenu()
    {
        System.out.println("\nDelete cars by registration...");
        System.out.println("1. Delete car by registration plate");
        System.out.println("2. Delete cars by county initial");
        System.out.println("3. Back to delete menu");
    }

    /**
     * Displays the delete car by KMs menu
     */
    public static void printDeleteCarsByKmsMenu()
    {
        System.out.println("\nDelete cars by kms...");
        System.out.println("1. Delete cars if kms more than...");
        System.out.println("2. Delete cars if kms less than...");
        System.out.println("3. Delete cars if kms in the range of...");
        System.out.println("4. Back to delete menu");
    }

    /**
     * Displays the delete cars by car price menu
     */
    public static void printDeleteCarsByCarPriceMenu()
    {
        System.out.println("\nDelete cars by car price...");
        System.out.println("1. Delete cars cheaper than...");
        System.out.println("2. Delete cars dearer than...");
        System.out.println("3. Delete cars if price in the range of...");
        System.out.println("4. Back to delete menu");
    }
    
    /**
     * Options for delete methods
     * @param t TaxiCompany container
     */
    public static void deleteOption(TaxiCompany t)
    {
        Scanner keyboard = new Scanner(System.in);
        printDeleteMenu();
        int deleteOption = inputValidInt(1, 7, "Input option: ", "Invalid menu option");
        while (deleteOption != 7)
        {
            switch (deleteOption)
            {
                case 1: //delete all cars
                    System.out.println("\nDeleting all cars...");
                    t.deleteAllCars();
                    break;
                case 2: //delete cars by registration
                    printDeleteCarsByRegistrationMenu();
                    int deleteByRegistrationOption = inputValidInt(1, 3, "Input option: ", "Invalid menu option");
                    while (deleteByRegistrationOption != 3)
                    {
                        switch (deleteByRegistrationOption)
                        {
                            case 1: //delete car by registration plate
                                System.out.println("\nEnter registration plate: ");
                                String reg = keyboard.nextLine();
                                System.out.println("Deleting car with registation plate '" + reg + "'...");
                                t.deleteCarByRegistration(reg);
                                break;
                            case 2: //delete cars by county 
                                System.out.println("\nEnter county initial: ");
                                String initial = keyboard.nextLine();
                                System.out.println("\nDeleting cars with county initial '" + initial.toUpperCase() + "'...");
                                t.deleteCarByCountyInitial(initial.toUpperCase());
                                break;
                        }
                        printDeleteCarsByRegistrationMenu();
                        deleteByRegistrationOption = inputValidInt(1, 3, "Input option: ", "Invalid menu option");
                    }
                    break;
                case 3: //delete cars by number of seats
                    System.out.println("\nEnter number of seats: ");
                    int numSeat = keyboard.nextInt();
                    System.out.println("\nDeleting cars with " + numSeat + " seats...");
                    t.deleteCarByNumSeats(numSeat);
                    break;
                case 4: //delete cars by kms
                    printDeleteCarsByKmsMenu();
                    int deleteByKmOption = inputValidInt(1, 4, "Input option: ", "Invalid menu option");
                    while (deleteByKmOption != 4)
                    {
                        switch (deleteByKmOption)
                        {
                            case 1: //delete cars with kms over
                                System.out.println("\nEnter kms: ");
                                double kms = keyboard.nextDouble();
                                System.out.println("\nDeleting cars with kms over " + kms + "...");
                                t.deleteCarIfOverCertainKms(kms);
                                break;
                            case 2: //delete cars with kms less than
                                System.out.println("\nEnter kms: ");
                                kms = keyboard.nextDouble();
                                System.out.println("\nDeleting cars with kms less than " + kms + "...");
                                t.deleteCarIfLessCertainKms(kms);
                                break;
                            case 3: //delete cars with kms in the range
                                System.out.println("\nEnter minimum kms: ");
                                double minKms = keyboard.nextDouble();
                                System.out.println("\nEnter maximum kms: ");
                                double maxKms = keyboard.nextDouble();
                                System.out.println("\nDeleting cars with kms in the range of " + minKms + " and " + maxKms + "...");
                                t.deleteCarIfKmsInRange(minKms, maxKms);
                                break;
                        }
                        printDeleteCarsByKmsMenu();
                        deleteByKmOption = inputValidInt(1, 4, "Input option: ", "Invalid menu option");
                    }
                    break;
                case 5: //delete cars by year made
                    System.out.println("\nEnter year made: ");
                    int year = keyboard.nextInt();
                    System.out.println("\nDeleting cars made in " + year + "...");
                    t.deleteCarByYearMade(year);
                    break;
                case 6: //delete cars by car price
                    printDeleteCarsByCarPriceMenu();
                    int deleteByPriceOption = inputValidInt(1, 4, "Input option: ", "Invalid menu option");
                    while (deleteByPriceOption != 4)
                    {
                        switch (deleteByPriceOption)
                        {
                            case 1: //delete cars cheaper than
                                System.out.println("\nEnter price: ");
                                double price = keyboard.nextDouble();
                                System.out.println("\nDeleting cars with price cheaper than " + price + "...");
                                t.deleteCarCheaperThan(price);
                                break;
                            case 2: //delete cars dearer than
                                System.out.println("\nEnter kms: ");
                                price = keyboard.nextDouble();
                                System.out.println("\nCounting cars with price dearer than " + price + "...");
                                t.deleteCarDearerThan(price);
                                break;
                            case 3: //delete cars with price in the range
                                System.out.println("\nEnter minimum price: ");
                                double minPrice = keyboard.nextDouble();
                                System.out.println("\nEnter maximum price: ");
                                double maxPrice = keyboard.nextDouble();
                                System.out.println("\nDeleting cars with price in the range of " + minPrice + " and " + maxPrice + "...");
                                t.deleteCarIfPriceInRange(minPrice, maxPrice);
                                break;
                        }
                        printDeleteCarsByCarPriceMenu();
                        deleteByPriceOption = inputValidInt(1, 4, "Input option: ", "Invalid menu option");
                    }
                    break;
            }
            printDeleteMenu();
            deleteOption = inputValidInt(1, 7, "Input option: ", "Invalid menu option");
        }
    }

    // Sort Menu
    /**
     * Displays the sort menu
     */
    public static void printSortMenu()
    {
        System.out.println("\nOption 6- Sort Methods");
        System.out.println("1. Sort by registration");
        System.out.println("2. Sort by number of seats");
        System.out.println("3. Sort by KMs");
        System.out.println("4. Sort by year made");
        System.out.println("5. Sort by car price");
        System.out.println("6. Back to main menu");
    }

    /**
     * Options for sort methods
     * @param t TaxiCompany container
     */
    public static void sortOption(TaxiCompany t)
    {
        printSortMenu();
        int sortOption = inputValidInt(1, 6, "Input option: ", "Invalid menu option");
        while (sortOption != 6)
        {
            switch (sortOption)
            {
                case 1: // sort by registration
                    System.out.println("\nSorting cars by registration...");
                    t.sortCarsByRegistration();
                    break;
                case 2: // sort by number of seats
                    System.out.println("\nSorting cars by number of seats...");
                    t.sortCarsByNumSeats();
                    break;
                case 3: // sort by kms
                    System.out.println("\nSorting cars by KMs...");
                    t.sortCarsByKms();
                    break;
                case 4: // sort by year made
                    System.out.println("\nSorting cars by year made...");
                    t.sortCarsByYearMade();
                    break;
                case 5: // sort by car price
                    System.out.println("\nSorting cars by car price...");
                    t.sortCarsByPrice();
                    break;
            }
            printSortMenu();
            sortOption = inputValidInt(1, 6, "Input option: ", "Invalid menu option");
        }

    }

    // Edit menu
    /**
     * Displays the edit menu
     */
    public static void printEditMenu()
    {
        System.out.println("\nOption 7- Edit Methods");
        System.out.println("1. Edit registration");
        System.out.println("2. Edit number of seats");
        System.out.println("3. Edit to decrease car price");
        System.out.println("4. Edit to increase KMs");
        System.out.println("5. Back to main menu");
    }

    /**
     * Options for edit methods
     * @param t TaxiCompany container
     */
    public static void editOption(TaxiCompany t)
    {
        Scanner keyboard = new Scanner(System.in);
        printEditMenu();
        int editOption = inputValidInt(1, 5, "Input option: ", "Invalid menu option");
        while (editOption != 5)
        {
            switch (editOption)
            {
                case 1: // edit registration
                    System.out.println("\nEditing registration");
                    System.out.println("Enter car registration: ");
                    String reg = keyboard.next();
                    System.out.println("Enter new registration: ");
                    String changeReg = keyboard.next();
                    t.editCarRegistrationByRegistration(reg, changeReg);
                    System.out.println("\nCar registration changed");
                    break;
                case 2: // edit number of seats
                    System.out.println("\nEditing number of seats");
                    System.out.println("Enter car registration: ");
                    reg = keyboard.next();
                    System.out.println("Enter new number of seats: ");
                    int newNumSeats = keyboard.nextInt();
                    t.editCarNumSeatsByRegistration(reg, newNumSeats);
                    System.out.println("\nCar number of seats changed");
                    break;
                case 3: // edit decrease car price
                    System.out.println("\nEditing to decrease car price");
                    System.out.println("Enter car registration: ");
                    reg = keyboard.next();
                    System.out.println("Enter percentage to decrease car price by:");
                    double percentage = keyboard.nextDouble();
                    t.editCarPriceDecreaseByRegistration(reg, percentage);
                    System.out.println("\nCar price decreased");
                    break;
                case 4: // edit increase kms    
                    System.out.println("\nEditing to increase KMs");
                    System.out.println("Enter car registration: ");
                    reg = keyboard.next();
                    System.out.println("Enter amount to increase kms by:");
                    double amount = keyboard.nextDouble();
                    t.editCarKmsIncreaseByRegistration(reg, amount);
                    System.out.println("\nCar price decreased");
                    break;

            }
            printEditMenu();
            editOption = inputValidInt(1, 5, "Input option: ", "Invalid menu option");
        }
    }

    // Calculate menu
    /**
     * Displays the calculate menu
     */
    public static void printCalculateMenu()
    {
        System.out.println("\nOption 8- Edit Methods");
        System.out.println("1. Calculate average car price");
        System.out.println("2. Calculate average KMs");
        System.out.println("3. Calculate total KMs");
        System.out.println("4. Back to main menu");
    }

    /**
     * Options for calculate methods
     * @param t TaxiCompany container
     */
    public static void calculateOption(TaxiCompany t)
    {
        printCalculateMenu();
        int calculateOption = inputValidInt(1, 4, "Input option: ", "Invalid menu option");
        while (calculateOption != 4)
        {
            switch (calculateOption)
            {
                case 1: // calculate average price
                    System.out.println("\nCalculating average car price...");
                    System.out.printf("Average car price: €%.2f\n", t.calculateAverageCarPrice());
                    break;
                case 2: // calculate average kms
                    System.out.println("\nCalculating average kms...");
                    System.out.printf("Average kms: %.2f kms\n", t.calculateAverageKms());
                    break;
                case 3: // calculate total kms
                    System.out.println("\nCalculating total kms...");
                    System.out.println("Total kms: " + t.calculateTotalKms() + " kms");
                    break;
            }
            printCalculateMenu();
            calculateOption = inputValidInt(1, 4, "Input option: ", "Invalid menu option");
        }
    }

    // Input Valid Int
    /**
     * This method allows the user to input a number and checks if the number is
     * in the range
     *
     * @param min minimum limit of numbers in the range
     * @param max maximum limit of numbers in the range
     * @param prompt prompt message
     * @param errorMessage error message
     * @return number entered
     */
    public static int inputValidInt(int min, int max, String prompt, String errorMessage)
    {
        Scanner keyboard = new Scanner(System.in);
        int num;

        System.out.print(prompt);
        num = keyboard.nextInt();
        while (num < min || num > max)
        {
            System.out.println(errorMessage + " - must be in range" + "[" + min + "," + max + "]  ");
            System.out.print(prompt);
            num = keyboard.nextInt();
        }

        return num;
    }

    // Read from file
    /**
     * Reads car details from file and adds it to TaxiCompany
     * @param fileName file name
     * @param t TaxiCompany container
     * @throws IOException 
     */
    public static void readFile(String fileName, TaxiCompany t) throws IOException
    {
        File file = new File(fileName);
        Scanner input = new Scanner(file);
        
        while (input.hasNext())
        {
            String registration = input.next();
            int numSeats = input.nextInt();
            double kms = input.nextDouble();
            int year = input.nextInt();
            double carPrice = input.nextDouble();

            Car newCar = new Car(registration, numSeats, kms, year, carPrice);
            t.addCar(newCar);
        }
    }
}
