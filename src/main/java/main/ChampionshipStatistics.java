package main;

import java.util.List;


public class ChampionshipStatistics {

    public static double CalculateAveragePointsPerDriver(List<Driver> drivers) {
        return ChampionshipManager.getTotalChampionshipPoints() / drivers.size();
    }
    
    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        int maxPoints = 0;
        String country = "";
        for (Driver driver : drivers) {
            if (driver.getPoints() > maxPoints) {
                maxPoints = driver.getPoints();
                country = driver.getCountry();
            }
        }
        return country;
    }

    public static int getTotalRacesHeld() {
        return ChampionshipManager.getTotalRaces();
    }
    
}
