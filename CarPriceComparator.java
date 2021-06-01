package groupprojecttaxi;

import java.util.Comparator;

/**
 *
 * @author luanakimley
 */
public class CarPriceComparator implements Comparator<Car>
{
    @Override
    public int compare(Car car1, Car car2)
    {
        return Double.compare(car1.getCarPrice(), car2.getCarPrice());
    }
}
