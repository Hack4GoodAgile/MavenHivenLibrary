package loaders;

import hivehandlers.HiveHandler;
import hivelibrarymodel.Parking;

import java.util.List;

public class ParkingLoader implements Loader<Parking> {
    @Override
    public Parking load() {
        return null;
    }

    @Override
    public Parking load(String zone) {
        return build(new HiveHandler().launchQuery("Select value from cristeam_parkings where entity_name='"+zone+"' AND attribute_name='free'"), zone);
    }

    private Parking build(List<String> list, String zone) {
        return new Parking(zone, Integer.valueOf(list.get(list.size() - 1)));
    }
}
