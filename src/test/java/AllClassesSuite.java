import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;



@Suite
@SelectPackages({"BookingApp","Flights","CustomLogger","table"})
public class AllClassesSuite {
}
