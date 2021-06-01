package groupprojecttaxi;
import java.util.Comparator;
/**
 *
 * @author luanakimley
 */
public class CarNumSeatsComparator implements Comparator<Car>
{
    @Override
    public int compare(Car car1, Car car2)
    {
        return Integer.compare(car1.getNumSeats(), car2.getNumSeats());
    }
}
