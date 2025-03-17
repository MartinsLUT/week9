package main;


import java.util.ArrayList;
import java.util.List;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers;
    private List<RallyRaceResult> races;
    private static int totalDrivers;
    private static int totalRaces;

    private ChampionshipManager() {
        drivers = new ArrayList<>();
        races = new ArrayList<>();
        totalDrivers = 0;
        totalRaces = 0;
    

    }

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }
    public void registerDriver(Driver driver) {
        drivers.add(driver);
        totalDrivers++;
    }

    public void addRaceResult(RallyRaceResult result){
        races.add(result);
        totalRaces++;
    }

    public List<Driver> getDriverStandings() {
        List<Driver> standings = new ArrayList<>(drivers);
        standings.sort((d1, d2) -> Integer.compare(d2.getPoints(), d1.getPoints()));
        return standings;
        
        
    }
    
    public static Driver getLeadingDriver(){
        ChampionshipManager championshipManager = ChampionshipManager.getInstance();
        List<Driver> standings = championshipManager.getDriverStandings();
        return standings.get(0);
    }

    public static int getTotalChampionshipPoints(){
        ChampionshipManager championshipManager = ChampionshipManager.getInstance();
        List<Driver> drivers = championshipManager.drivers;
        int totalPoints = 0;
        for (Driver driver : drivers) {
            totalPoints += driver.getPoints();
        }
        return totalPoints;
    }
    
    public static int getTotalRaces(){
        return totalRaces;
    }

    public static int getTotalDrivers(){
        return totalDrivers;
    }

    public List<Driver> getDrivers(){
        return drivers;
    }

    public List<RallyRaceResult> getRaces(){
        return races;

    }

    
}
