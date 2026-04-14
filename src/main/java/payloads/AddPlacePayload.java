package payloads;

import POJO.Serialization.AddPlace;
import POJO.Serialization.Location;

import java.util.ArrayList;
import java.util.List;

public class AddPlacePayload {
    public static AddPlace getAddPlace() {
        AddPlace addPlace = new AddPlace();
        Location location = new Location();
        addPlace.setAccuracy(50);
        addPlace.setAddress("Frontline house");
        addPlace.setLanguage("English");
        addPlace.setWebsite("https://google.com");
        addPlace.setName("Amit Raj");
        addPlace.setPhone_number("(+91) 983 893 3937");
        location.setLat(-38.383494);
        location.setLng(-77.234234);
        addPlace.setLocation(location);
        List<String> types = new ArrayList<>();
        types.add("shoe park");
        types.add("shop");
        addPlace.setTypes(types);
        return addPlace;
    }
}
