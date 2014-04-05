package loaders;

import hivelibrarymodel.Parking;
import junit.framework.Assert;
import org.junit.Test;

public class ParkingLoaderTest {
    @Test
    public void loadSomeParkingZone1() {
        Loader<Parking> loader = new ParkingLoader();
        Assert.assertNotNull(loader.load("zoneTest"));
    }

    @Test
    public void loadParkingInZone1(){
        Loader<Parking> loader = new ParkingLoader();
        Assert.assertEquals(new Parking("zoneTest", 3),loader.load("zoneTest"));
    }

}
