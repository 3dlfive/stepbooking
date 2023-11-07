import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;



@Suite
@SelectPackages({"BookingApp","Flights"})
public class AllClassesSuite {
}
