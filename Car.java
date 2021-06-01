package groupprojecttaxi;
/**
 * Basic Car Class
 * @author Luana Kimley & Shakira Lynch
 */
public class Car
{
    private String registration;
    private int numSeats;
    private double kms;
    private int yearMade;
    private double carPrice;
    
    /**
     * Car constructor
     * @param registration Car registration
     * @param numSeats number of seats in a Car
     * @param kms KMs in the Car
     * @param yearMade year the Car is made
     * @param carPrice price of the Car
     */
    public Car(String registration, int numSeats, double kms, int yearMade, double carPrice)
    {
        this.registration = registration;
        this.numSeats = numSeats;
        this.kms = kms;
        this.yearMade = yearMade;
        this.carPrice = carPrice;
    }
    
    /**
     * Overloaded Car constructor with 3 parameters
     * @param numSeats number of seats in a car
     * @param yearMade year the car is made
     * @param carPrice price of the car
     */
    public Car(int numSeats, int yearMade, double carPrice)
    {
        this.registration = "";
        this.numSeats = numSeats;
        this.kms = 0;
        this.yearMade = yearMade;
        this.carPrice = carPrice;
    }
    
    /**
     * Default Car constructor with no arguments
     */
    public Car()
    {
        this.registration = "";
        this.numSeats = 0;
        this.kms = 0;
        this.yearMade = 0;
        this.carPrice = 0;
    }
    
    /**
     * Returns the value of Car's registration
     * @return Car's registration
     */
    public String getRegistration()
    {
        return this.registration;
    }
    
    /**
     * Returns the value of Car's number of seats
     * @return Car's number of seats
     */
    public int getNumSeats()
    {
        return this.numSeats;
    }
    
    /**
     * Returns the value of Car's KMs
     * @return Car's KMs
     */
    public double getKms()
    {
        return this.kms;
    }
    
    /**
     * Returns the value of Car's year made
     * @return Car's year made
     */
    public int getYearMade()
    {
        return this.yearMade;
    }
    
    /**
     * Returns the value of Car's price
     * @return Car's price
     */
    public double getCarPrice()
    {
        return this.carPrice;
    }

    /**
     * Changes Car registration to registration
     * @param registration new registration for Car
     */
    public void setRegistration(String registration)
    {
        this.registration = registration;
    }

    /**
     * Changes Car number of seats to numSeats
     * @param numSeats new number of seats for Car
     */
    public void setNumSeats(int numSeats)
    {
        this.numSeats = numSeats;
    }
 
    /**
     * Changes Car kms to kms
     * @param kms new kms for Car
     */
    public void setKms(double kms)
    {
        this.kms = kms;
    }

    /**
     * Changes Car year made to yearMade
     * @param yearMade new year made for Car
     */
    public void setYearMade(int yearMade)
    {
        this.yearMade = yearMade;
    }

    /**
     * Changes Car price to carPrice
     * @param carPrice new car price for Car
     */
    public void setCarPrice(double carPrice)
    {
        this.carPrice = carPrice;
    }

    /**
     * Decreases car price by certain percentage
     * @param percent percentage of price to be decreased
     */
    public void decreaseCarPrice(double percent)
    {
        this.carPrice = this.carPrice - this.carPrice * percent / 100;
    }

    /**
     * Increases car KMs by certain amount
     * @param amount amount of KMs to be added
     */
    public void increaseKms(double amount)
    {
        this.kms = this.kms + amount;
    }

    
    @Override
    public String toString()
    {
        return "Car{" + "registration=" + registration + "\nnumSeats=" + numSeats + "\nkms" + kms + "\nyearMade" + yearMade + "\ncarPrice= " + carPrice + '}';
    }
    
}

