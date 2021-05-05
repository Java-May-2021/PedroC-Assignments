import java.util.HashMap;
import java.util.Set;

public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Lorem", "Lorem lyrics");
        trackList.put("Ipsum", "Ipsum lyrics");
        trackList.put("Consectetur", "Consectetur lyrics");
        trackList.put("Ullamcorper", "Ullamcorper lyrics");
        trackList.remove("Consectetur");

        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.println(key + ": "+trackList.get(key));
        }
    }
}