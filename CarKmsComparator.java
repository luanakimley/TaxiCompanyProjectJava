package groupprojecttaxi;

import java.util.Comparator;

/**
 *
 * @author luanakimley
 */
public class CarKmsComparator implements Comparator<Car>
{
    @Override
    public int compare(Car car1, Car car2)
    {
        return Double.compare(car1.getKms(), car2.getKms());
    }
}
