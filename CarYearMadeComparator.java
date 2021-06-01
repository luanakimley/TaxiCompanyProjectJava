package groupprojecttaxi;

import java.util.Comparator;

/**
 * 
 * @author luanakimley
 */
public class CarYearMadeComparator implements Comparator<Car>
{
    @Override
    public int compare(Car car1, Car car2)
    {
        return Integer.compare(car1.getYearMade(), car2.getYearMade());
    }
}
