package main;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RallyRaceResult implements RaceResult {
    private String raceName;
    private String location;
    private Map<Driver, Integer> results;

    public RallyRaceResult(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
        this.results = new HashMap<>();
    }

    public String getRaceName() {
        return raceName;
    }

    public String getLocation() {
        return location;
    }   
    
    @Override
    public void recordResult(Driver driver, int position, int points) {
        results.put(driver, points);
        driver.addPoints(points);
    }

    @Override
    public int getDriverPoints(Driver driver) {
        return results.get(driver);
    }

    @Override
    public List<Driver> getResult() {
        return results.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .map(Map.Entry::getKey)
                .toList();
    }
}
