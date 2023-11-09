import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;



@Suite
@SelectPackages({"BookingApp","Flights","CustomLogger"})
public class AllClassesSuite {
}
