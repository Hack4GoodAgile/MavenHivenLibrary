package loaders;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ZonesLoaderTest {
    @Test
    public void checkListZoneSizeTest() {
        Loader<List> loader = new ZonesLoader();
        Assert.assertEquals(1, loader.load().size());
    }

    @Test
    public void checkCorrectZoneTest() {
        Loader<List> loader = new ZonesLoader();
        List<String> expectedList = buildList("zone1");
        for (String zone : expectedList)
            Assert.assertTrue(loader.load().contains(zone));
    }

    private List buildList(String... values) {
        return Arrays.asList(values);
    }
}
