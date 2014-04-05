package hivelibrarymodel;

import junit.framework.Assert;
import hivelibrarymodel.Parking;
import org.junit.Test;

public class ParkingTest {
    @Test
    public void getZoneParkingTest() {
        Parking parking = new Parking("Zone1", 3);
        Assert.assertEquals("Zone1",parking.getZone());
    }

    @Test
    public void getFreePlacesTest() {
        Parking parking = new Parking("Zone1", 3);
        Assert.assertEquals(3, parking.getFreePlaces());
    }
}
