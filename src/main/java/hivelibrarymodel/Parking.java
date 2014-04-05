package hivelibrarymodel;

public class Parking {
    private int freePlaces;
    private String zone;

    public Parking(String zone, int freePlaces) {
        this.zone = zone;
        this.freePlaces = freePlaces;
    }

    public String getZone() {
        return zone;
    }


    public int getFreePlaces() {
        return freePlaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parking parking = (Parking) o;

        if (freePlaces != parking.freePlaces) return false;
        if (zone != null ? !zone.equals(parking.zone) : parking.zone != null) return false;

        return true;
    }

}
