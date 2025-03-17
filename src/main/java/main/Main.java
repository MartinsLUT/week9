package main;

/**
 * In UML, there was written RallyChampionship, but in the descripition
 * it was written Main, so Called it main but it is the same as RallyChampionship
 */
public class Main 
{
    public static void main( String[] args )
    {
        ChampionshipManager championshipManager = ChampionshipManager.getInstance();


        // Creating RallyCars
        RallyCar car1 = new AsphaltCar("Subaru", "Impreza", 300, 100);
        RallyCar car2 = new GravelCar("Mitsubishi", "Lancer", 320, 120);
        

        // Creating Drivers
        Driver driver1 = new Driver("Ott Tanak", "Estonia", car1);
        Driver driver2 = new Driver("Kalle Rovanpera", "Finland", car2);
        Driver driver3 = new Driver("Thierry Neuville", "Belgium", car1);
        Driver driver4 = new Driver("Sebastian Ogier", "France", car2);

        // Registering Drivers
        championshipManager.registerDriver(driver1);
        championshipManager.registerDriver(driver2);
        championshipManager.registerDriver(driver3);
        championshipManager.registerDriver(driver4);

        // Creating RallyRaces
        RallyRaceResult race1 = new RallyRaceResult("Rally Finland", "Jyvaskyla");
        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        championshipManager.addRaceResult(race1);
        championshipManager.addRaceResult(race2);

        // Adding result for race1
        race1.recordResult(driver1, 1, 25);
        race1.recordResult(driver2, 2, 18);
        race1.recordResult(driver3, 3, 15);
        race1.recordResult(driver4, 4, 12);

        // Adding result for race2
        race2.recordResult(driver2, 1, 25);
        race2.recordResult(driver1, 2, 18);
        race2.recordResult(driver4, 3, 15);
        race2.recordResult(driver3, 4, 12);





        
        // Listing the standings
        int i  = 1;
        for (Driver driver : championshipManager.getDriverStandings()) {
            System.out.println(i + ". " + driver.getName() + " (" + driver.getCountry() + "): " + driver.getPoints() + " points");
            i++;
        }

        //Championship Leader
        System.out.println("\n==== Championship Leader ====");
        System.out.println(ChampionshipManager.getLeadingDriver().getName() + " with " + ChampionshipManager.getLeadingDriver().getPoints() + " points");


        //Championship Statistics
        System.out.println("\n==== Championship Statistics ====");
        System.out.println("Total drivers: " + ChampionshipManager.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipManager.getTotalRaces());
        System.out.println("Average Points per Driver: " + ChampionshipStatistics.CalculateAveragePointsPerDriver(championshipManager.getDrivers()));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(championshipManager.getDrivers()));
        System.out.println("Total Championship Points: " + ChampionshipManager.getTotalChampionshipPoints());


        System.out.println("\n==== Race Results ====");
        for (RallyRaceResult races : championshipManager.getRaces()) {
            System.out.println("Race: " + races.getRaceName() + " (" + races.getLocation() + ")");
            int p = 1;
            for (Driver driver : races.getResult()){
                System.out.println("Position " + p + ": " + driver.getName() + " - " + races.getDriverPoints(driver) + " points");
                p++;
            }
            System.out.println();
            
        }

        System.out.println("\n==== Car performance ratings ====");
        System.out.println("Gravel Car Performance: " + car2 .calculaterPreformance());
        System.out.println("Asphalt Car Performance: " + car1.calculaterPreformance());


}
}
