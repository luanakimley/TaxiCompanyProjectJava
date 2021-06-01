package groupprojecttaxi;
import java.util.Iterator;
import java.util.ArrayList;
import java.time.Year;
import java.util.Collections;
/**
 * Taxi Company Container Class
 * @author Luana Kimley & Shakira Lynch
 */
public class TaxiCompany
{

    private String name;
    private String CEO;
    private double fareRate;
    private ArrayList<Car> cars;

    /**
     * Taxi Company constructor
     * @param name Taxi Company name
     * @param CEO Taxi Company CEO
     * @param fareRate Taxi Company fare rate
     */
    public TaxiCompany(String name, String CEO, double fareRate)
    {
        this.name = name;
        this.CEO = CEO;
        this.fareRate = fareRate;
        cars = new ArrayList<>();
    }

    /**
     * Adds Car to cars ArrayList
     * @param c Car object to be added
     */
    public void addCar(Car c)
    {
        cars.add(c);
    }

    /**
     * Returns the value of TaxiCompany name
     * @return TaxiCompany name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Changes TaxiCompany name to name
     * @param name new name for TaxiCompany
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns the value of TaxiCompany CEO
     * @return TaxiCompany CEO
     */
    public String getCEO()
    {
        return CEO;
    }

    /**
     * Changes TaxiCompany CEO to CEO
     * @param CEO
     */
    public void setCEO(String CEO)
    {
        this.CEO = CEO;
    }

    /**
     * Returns the value of TaxiCompany fare rate
     * @return TaxiCompany fare rate
     */
    public double getFareRate()
    {
        return fareRate;
    }

    /**
     * Changes TaxiCompany fare rate to fareRate
     * @param fareRate TaxiCompany fare rate
     */
    public void setFareRate(double fareRate)
    {
        this.fareRate = fareRate;
    }
    
    @Override
    public String toString()
    {
        return "Taxi Company{" + "name=" + name + ", CEO=" + CEO + ", fareRate= " + fareRate + ", cars=" + cars + '}';
    }


    // Comparators 
    
    CarRegistrationComparator byRegistration = new CarRegistrationComparator();
    CarNumSeatsComparator byNumSeats = new CarNumSeatsComparator();
    CarYearMadeComparator byYearMade = new CarYearMadeComparator();
    CarKmsComparator byKms = new CarKmsComparator();
    CarPriceComparator byPrice = new CarPriceComparator();
    
    // Display Methods

    /**
     * Display all cars in ArrayList
     */
    public void displayCars()
    {
        System.out.println("Registration\tNumber of Seats\t\tKMs\tYear Made\tCar Price");
        for (Car car : cars)
        {
            System.out.printf("%-15s%16s%12s%14s%16s\n",
                    car.getRegistration(),
                    car.getNumSeats(),
                    car.getKms(),
                    car.getYearMade(),
                    car.getCarPrice()
            );
        }
    }

    // - Display by registration

    /**
     * Display cars from a certain county
     * @param countyInitials car's county initial in its registration
     */
    public void displayCarIfRegInCertainCounty(String countyInitials)
    {
        System.out.println("Registration\tNumber of Seats\t\tKMs\tYear Made\tCar Price");
        for (Car car : cars)
        {
            if (car.getRegistration().contains(countyInitials))
            {

                System.out.printf("%-15s%16s%12s%14s%16s\n",
                        car.getRegistration(),
                        car.getNumSeats(),
                        car.getKms(),
                        car.getYearMade(),
                        car.getCarPrice()
                );
            }
        }
    }
    
    // - Display by number of seats

    /**
     * Display cars if its number of seats is in a certain value
     * @param numSeats the number of seats in a car
     */
    public void displayCarIfCertainAmountOfSeats(int numSeats)
    {
        System.out.println("Registration\tNumber of Seats\t\tKMs\tYear Made\tCar Price");
        for (Car car : cars)
        {
            if (car.getNumSeats() == numSeats)
            {

                System.out.printf("%-15s%16s%12s%14s%16s\n",
                        car.getRegistration(),
                        car.getNumSeats(),
                        car.getKms(),
                        car.getYearMade(),
                        car.getCarPrice()
                );
            }

        }

    }
    
    // - Display by year made

    /**
     * Display cars when it is older than the age entered
     * @param age car age
     */
    public void displayCarsOlderThan(int age)
    {
        System.out.println("Registration\tNumber of Seats\t\tKMs\tYear Made\tCar Price");
        for (Car car : cars)
        {
            int currentYear = Year.now().getValue();
            if (currentYear - car.getYearMade() > age)
            {
                System.out.printf("%-15s%16s%12s%14s%16s\n",
                        car.getRegistration(),
                        car.getNumSeats(),
                        car.getKms(),
                        car.getYearMade(),
                        car.getCarPrice()
                );
            }
        }
    }

    /**
     * Display cars when it is newer than the age entered
     * @param age car age
     */
    public void displayCarsNewerThan(int age)
    {
        System.out.println("Registration\tNumber of Seats\t\tKMs\tYear Made\tCar Price");
        int currentYear = Year.now().getValue();
        for (Car car : cars)
        {
            if (currentYear - car.getYearMade() < age)
            {
                System.out.printf("%-15s%16s%12s%14s%16s\n",
                        car.getRegistration(),
                        car.getNumSeats(),
                        car.getKms(),
                        car.getYearMade(),
                        car.getCarPrice()
                );
            }
        }
    }
    
    /**
     * Display cars made in a certain year
     * @param year year the car is made
     */
    public void displayCarIfInCertainYear(int year)
    {
        System.out.println("Registration\tNumber of Seats\t\tKMs\tYear Made\tCar Price");
        for (Car car : cars)
        {
            if (car.getYearMade() == year)
            {
                System.out.printf("%-15s%16s%12s%14s%16s\n",
                        car.getRegistration(),
                        car.getNumSeats(),
                        car.getKms(),
                        car.getYearMade(),
                        car.getCarPrice()
                );
            }
        }
    }

    // - Display by kms

    /**
     * Display cars with KMs over the value entered
     * @param kms the KMs in a car
     */
    public void displayCarIfOverCertainKms(double kms)
    {
        System.out.println("Registration\tNumber of Seats\t\tKMs\tYear Made\tCar Price");
        for (Car car : cars)
        {
            if (car.getKms() > kms)
            {

                System.out.printf("%-15s%16s%12s%14s%16s\n",
                        car.getRegistration(),
                        car.getNumSeats(),
                        car.getKms(),
                        car.getYearMade(),
                        car.getCarPrice()
                );
            }

        }
    }
    
    /**
     * Display cars with KMs less than the value entered
     * @param kms the KMs in a car
     */
    public void displayCarIfLessCertainKms(double kms)
    {
        System.out.println("Registration\tNumber of Seats\t\tKMs\tYear Made\tCar Price");
        for (Car car : cars)
        {
            if (car.getKms() < kms)
            {

                System.out.printf("%-15s%16s%12s%14s%16s\n",
                        car.getRegistration(),
                        car.getNumSeats(),
                        car.getKms(),
                        car.getYearMade(),
                        car.getCarPrice()
                );
            }

        }
    }

    /**
     * Display cars with KMs in the range (inclusive) of the min and max value entered
     * @param min minimum limit of the car's KMs
     * @param max maximum limit of the car's KMs
     */
    public void displayCarIfKmInRange(double min, double max)
    {
        System.out.println("Registration\tNumber of Seats\t\tKMs\tYear Made\tCar Price");
        for (Car car : cars)
        {
            if (min <= car.getKms() && max >= car.getKms())
            {
                System.out.printf("%-15s%16s%12s%14s%16s\n",
                        car.getRegistration(),
                        car.getNumSeats(),
                        car.getKms(),
                        car.getYearMade(),
                        car.getCarPrice()
                );
            }

        }
    }
    
    // - Display by price

    /**
     * Display cars with price cheaper than the value entered
     * @param carPrice the price of the car
     */
    public void displayCarCheaperThan(double carPrice)
    {
        System.out.println("Registration\tNumber of Seats\t\tKMs\tYear Made\tCar Price");
        for (Car car : cars)
        {
            if (car.getCarPrice() < carPrice)
            {


                System.out.printf("%-15s%16s%12s%14s%16s\n",
                        car.getRegistration(),
                        car.getNumSeats(),
                        car.getKms(),
                        car.getYearMade(),
                        car.getCarPrice());

            }
        } 
    }
    
    /**
     * Display cars with price dearer than the value entered
     * @param carPrice the price of the car
     */
    public void displayCarDearerThan(double carPrice)
    {
        System.out.println("Registration\tNumber of Seats\t\tKMs\tYear Made\tCar Price");
        for (Car car : cars)
        {
            if (car.getCarPrice() > carPrice)
            {

                System.out.printf("%-15s%16s%12s%14s%16s\n",
                        car.getRegistration(),
                        car.getNumSeats(),
                        car.getKms(),
                        car.getYearMade(),
                        car.getCarPrice()
                );
            } 
        }
    }
    
    /**
     * Display cars with price in the range (inclusive) of the min and max value entered
     * @param min minimum limit of the car's price
     * @param max minimum limit of the car's price
     */
    public void displayCarIfPriceInRange(double min, double max)
    {
        System.out.println("Registration\tNumber of Seats\t\tKMs\tYear Made\tCar Price");
        for (Car car : cars)
        {
            if (min <= car.getCarPrice() && max >= car.getCarPrice())
            {
                System.out.printf("%-15s%16s%12s%14s%16s\n",
                        car.getRegistration(),
                        car.getNumSeats(),
                        car.getKms(),
                        car.getYearMade(),
                        car.getCarPrice()
                );
            }

        }
    }
    
    
    
    
    // Count Methods

    /**
     * Count total number of cars in ArrayList
     * @return total number of cars in ArrayList
     */
    public int countCars()
    {
        return cars.size();
    }
    
    // - Count by registration

    /**
     * Count cars from a certain county
     * @param countyInitials car's county initial in its registration
     * @return number of cars from a certain county
     */
    public int countCarIfRegInCertainCounty(String countyInitials)
    {
        int count = 0;
        for (Car car : cars)
        {
            if (car.getRegistration().contains(countyInitials))
            {
                count++;
            }
        }
        return count;
    }
    
    // - Count by number of seats

    /**
     * Count cars if its number of seats is in a certain value
     * @param numSeats the number of seats in a car
     * @return number of cars with certain number of seats
     */
    public int countCarIfCertainNumberOfSeats(int numSeats)
    {
        int count = 0;
        for (Car car : cars)
        {
            if (car.getNumSeats() == numSeats)
            {
                count++;
            }
        }  
        return count;
    }
    
    // - Count by kms

    /**
     * Count cars with KMs over the value entered
     * @param kms the KMs in a car
     * @return number of cars with KMs over the value entered
     */
    public int countCarIfOverCertainKms(double kms)
    {
        int count = 0;
        for (Car car : cars)
        {
            if (car.getKms() > kms)
            {
                count++;
            }
        }  
        return count;
    }
    
    /**
     * Count cars with KMs less than the value entered
     * @param kms the KMs in a car
     * @return number of cars with KMs less than the value entered
     */
    public int countCarIfLessThanCertainKms(double kms)
    {
        int count = 0;
        for (Car car : cars)
        {
            if (car.getKms() < kms)
            {
                count++;
            }
        }  
        return count;
    }

    /**
     * Count cars with KMs in the range (inclusive) of the min and max value entered
     * @param min minimum limit of the car's KMs
     * @param max maximum limit of the car's KMs
     * @return number of cars with KMs in the range of the min and max value 
     */
    public int countCarIfKmInRange(double min, double max)
    {
        int count = 0;
        for (Car car : cars)
        {
            if (min <= car.getKms() && max >= car.getKms())
            {
                count++;
            }

        }
        return count;
    }
    
    // - Count by price

    /**
     * Count cars with price cheaper than the value entered
     * @param carPrice the price of the car
     * @return number of cars with price cheaper than certain price
     */
    public int countCarCheaperThan(double carPrice)
    {
        int count = 0;
        for (Car car : cars)
        {
            if (car.getCarPrice() < carPrice)
            {
                count++;
            }
        }  
        return count;
    }
    
    /**
     * Count cars with price dearer than the value entered
     * @param carPrice the price of the car
     * @return number of cars with price dearer than certain price
     */
    public int countCarDearerThan(double carPrice)
    {
        int count = 0;
        for (Car car : cars)
        {
            if (car.getCarPrice() > carPrice)
            {
                count++;
            }
        }  
        return count;
    }
    
    /**
     * Count cars with price in the range (inclusive) of the min and max value entered
     * @param min minimum limit of the car's price
     * @param max maximum limit of the car's price
     * @return number of cars with price in the range of the min and max value 
     */
    public int countCarIfPriceInRange(double min, double max)
    {
        int count = 0;
        for (Car car : cars)
        {
            if (min <= car.getCarPrice() && max >= car.getCarPrice())
            {
                count++;
            }

        }
        return count;
    }
    // - Count by year made

    /**
     * Count cars made in a certain year
     * @param yearMade year car is made
     * @return number of cars made in a certain year
     */
    public int countCarIfMadeInCertainYear(int yearMade)
    {
        int count = 0;
        for (Car car : cars)
        {
            if (car.getYearMade() == yearMade)
            {
                count++;
            }
        }  
        return count;
    }
    
    /**
     * Count cars if it is older than the age entered
     * @param age car age
     * @return number of cars older than certain age
     */
    public int countCarsOlderThan(int age)
    {
        int count = 0;
        for (Car car : cars)
        {
            int currentYear = Year.now().getValue();
            if (currentYear - car.getYearMade() > age)
            {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Count cars if it is newer than the age entered
     * @param age car age
     * @return number of cars newer than certain age
     */
    public int countCarsNewerThan(int age)
    {
        int count = 0;
        int currentYear = Year.now().getValue();
        for (Car car : cars)
        {
            if (currentYear - car.getYearMade() < age)
            {
                count++;
            }
        }
        return count;
    }

    // Delete Methods

    /**
     * Delete all cars in ArrayList
     */
    public void deleteAllCars()
    {
        Iterator<Car> it = cars.iterator();
        while (it.hasNext())
        {
            it.next();
            it.remove();
        }
    }
    
    // - Delete by registration

    /**
     * Delete cars with certain registration
     * @param registration car registration
     */
    public void deleteCarByRegistration(String registration)
    {
    	for (int i = 0; i < cars.size(); i++)
        {
            if (cars.get(i).getRegistration().equalsIgnoreCase(registration))
            {
              	cars.remove(i);
            }
        }
    }
    
    /**
     * Delete cars from a certain county
     * @param initial car's county initial in its registration
     */
    public void deleteCarByCountyInitial(String initial)
    {
        Iterator<Car> it = cars.iterator();
        while (it.hasNext())
        {
            Car c = it.next();
            if (c.getRegistration().contains(initial))
            {
                it.remove();
            }
        }
    }
    
    // - Delete by number of seats

    /**
     * Delete cars if its number of seats is in a certain value
     * @param numSeat number of seats in a car
     */
    public void deleteCarByNumSeats(int numSeat)
    {
        Iterator<Car> it = cars.iterator();
        while (it.hasNext())
        {
            Car c = it.next();
            if (c.getNumSeats() == numSeat)
            {
                it.remove();
            }
        }
    }
    
    // - Delete by kms

    /**
     * Delete cars with KMs over the value entered
     * @param kms KMs in the car
     */
    public void deleteCarIfOverCertainKms(double kms)
    {
        Iterator<Car> it = cars.iterator();
        while (it.hasNext())
        {
            Car c = it.next();
            if (kms < c.getKms())
            {
                it.remove();
            }
        }
    }
    
    /**
     * Delete cars with KMs less than the value entered
     * @param kms KMs in the car
     */
    public void deleteCarIfLessCertainKms(double kms)
    {
        Iterator<Car> it = cars.iterator();
        while (it.hasNext())
        {
            Car c = it.next();
            if (c.getKms() < kms)
            {
                it.remove();
            }
        }
    }
    
    /**
     * Delete cars with KMs in the range (inclusive) of the min and max value entered
     * @param min minimum limit of the car's KMs
     * @param max maximum limit of the car's KMs
     */
    public void deleteCarIfKmsInRange(double min, double max)
    {
        Iterator<Car> it = cars.iterator();
        while (it.hasNext())
        {
            Car c = it.next();
            if (min <= c.getKms() && max >= c.getKms())
            {
                it.remove();
            }
        }
    }
    
    // - Delete by year made

    /**
     * Delete cars made in a certain year
     * @param yearMade year car is made
     */
    public void deleteCarByYearMade(int yearMade)
    {
        Iterator<Car> it = cars.iterator();
        while (it.hasNext())
        {
            Car c = it.next();
            if (c.getYearMade() == yearMade)
            {
                it.remove();
            }
        }
    }
    
    // - Delete by price

    /**
     * Delete cars with price cheaper than the value entered
     * @param price price of the car
     */
    public void deleteCarCheaperThan(double price)
    {
        Iterator<Car> it = cars.iterator();
        while (it.hasNext())
        {
            Car c = it.next();
            if (c.getCarPrice() < price)
            {
                it.remove();
            }
        }
    }
    
    /**
     * Delete cars with price dearer than the value entered
     * @param price price of the car
     */
    public void deleteCarDearerThan(double price)
    {
        Iterator<Car> it = cars.iterator();
        while (it.hasNext())
        {
            Car c = it.next();
            if (c.getCarPrice() > price)
            {
                it.remove();
            }
        }
    }
    
    /**
     * Delete cars with price in the range (inclusive) of the min and max value entered
     * @param min minimum limit of the car's price
     * @param max maximum limit of the car's price
     */
    public void deleteCarIfPriceInRange(double min, double max)
    {
        Iterator<Car> it = cars.iterator();
        while (it.hasNext())
        {
            Car c = it.next();
            if (min <= c.getCarPrice() && max >= c.getCarPrice())
            {
                it.remove();
            }
        }
    }
    
    // Sort Methods
    /**
     * Sort cars by its registration
     */
    public void sortCarsByRegistration()
    {
        Collections.sort(cars, byRegistration);
    }
    
    /**
     * Sort cars by its number of seats
     */
    public void sortCarsByNumSeats()
    {
        Collections.sort(cars, byNumSeats);
    }
    
    /**
     * Sort cars by its KMs
     */
    public void sortCarsByKms()
    {
        Collections.sort(cars, byKms);
    }

    /**
     * Sort cars by the year it was made
     */
    public void sortCarsByYearMade()
    {
        Collections.sort(cars, byYearMade);
    }
    
    /**
     * Sort cars by its price
     */
    public void sortCarsByPrice()
    {
        Collections.sort(cars, byPrice);
    }
    
    /**
     * finds the car registration and displays
     * @param registration car registration
     * @return cars that apply to the registration
     */
    public ArrayList<Car> findCarByRegistration(String registration)
    {
        ArrayList<Car> c = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++)
        {
            if (cars.get(i).getRegistration().equalsIgnoreCase(registration))
            {
                c.add(cars.get(i));
            }
        }
        return c;

    }

    /**
     * finds the car by the price and displays
     *
     * @param price to find the car by the price
     * @return cars that apply to the price
     */
    public ArrayList<Car> findCarByPrice(double price)
    {

        ArrayList<Car> c = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++)
        {
            if (cars.get(i).getCarPrice() == price)
            {
                c.add(cars.get(i));
            }
        }
        return c;

    }

    /**
     * finds the car by the kms and displays
     *
     * @param kms to find the car by the kms
     * @return cars that apply to the kms
     */
   public ArrayList<Car> findCarByKms(double kms)
    {

        ArrayList<Car> c = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++)
        {
            if (cars.get(i).getKms() == kms)
            {
                c.add(cars.get(i));
            }
        }
        return c;

    }
    /**
     * finds the car by the year made and displays
     *
     * @param yearMade to find the car by the yearMade
     * @return cars that apply to the yearMade
     */

  public ArrayList<Car> findCarByYearMade(int yearMade)
    {

        ArrayList<Car> c = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++)
        {
            if (cars.get(i).getYearMade() == yearMade)
            {
                c.add(cars.get(i));
            }
        }
        return c;

    }
  
    /**
     * uses the car registration to find the car the user is looking to change the registration for
     * @param registration to find the car you want to change the registration through registration
     * @param changeReg to change the registration to this
     */
    public void editCarRegistrationByRegistration(String registration, String changeReg)
    {
        
        for (Car car : cars)
        {
            if (car != null && registration.equals(car.getRegistration()))
            {
                car.setRegistration(changeReg);
               
            }
        }

    }

    /**
     * uses the car registration to find the car the user is looking to change the number of seats for
     * @param registration to find the car registration you want to change
     * @param changeSeats to change the number of seats to this
     * 
     */
    public void editCarNumSeatsByRegistration(String registration, int changeSeats)
    {
        
        for (Car car : cars)
        {
            if (car != null && registration.equals(car.getRegistration()))
            {
                car.setNumSeats(changeSeats);
               
            }
        }

    }
    
    /**
     * uses the car registration to decrease the car price
     * @param registration to find the car registration you want to change
     * @param percentage to decrease the car price by this percent
     */
    public void editCarPriceDecreaseByRegistration(String registration, double percentage)
    {
        for (Car car : cars)
        {
             if (car != null && registration.equals(car.getRegistration()))
            {
                car.decreaseCarPrice(percentage);
               
            }
        }
    }
    
    /**
     * uses the car registration to increase the car KMs
     * @param registration to find the car registration you want to change
     * @param amount to increase the car KMs to this amount
     */
    public void editCarKmsIncreaseByRegistration(String registration, double amount)
    {
        for (Car car : cars)
        {
             if (car != null && registration.equals(car.getRegistration()))
            {
                car.increaseKms(amount);
               
            }
        }
    }
    
    /**
     * This method calculates the average car price
     * @return average car price
     */
    public double calculateAverageCarPrice()
    {
        double total = 0;
        for (Car car : cars)
        {
            total += car.getCarPrice();
        }
        double average = total / cars.size();
        return average;
    }
    
    /**
     * This method calculates the average kms
     * @return average kms
     */
    public double calculateAverageKms()
    {
        double total = 0;
        for (Car car : cars)
        {
            total += car.getKms();
        }
        double average = total / cars.size();
        return average;
    }
    
    /**
     * This method calculates the total kms
     * @return total kms
     */
    public double calculateTotalKms()
    {
        double total = 0;
        for (Car car : cars)
        {
            total += car.getKms();
        }
        return total;
    }
}
