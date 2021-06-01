package groupprojecttaxi;

import java.util.Comparator;

/**
 *
 * @author luanakimley
 */
public class CarRegistrationComparator implements Comparator<Car>
{
    @Override
    public int compare(Car car1, Car car2)
    {
        return car1.getRegistration().compareToIgnoreCase(car2.getRegistration());
    }
}
