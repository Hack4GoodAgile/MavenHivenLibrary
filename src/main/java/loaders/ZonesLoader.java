package loaders;

import hivehandlers.HiveHandler;

import java.util.List;

public class ZonesLoader implements Loader<List> {

    @Override
    public List load() {
        return new HiveHandler().launchQuery("Select distinct(entity_name) from cristeam_parkings");
    }

    @Override
    public List load(String string) {
        return null;
    }
}
