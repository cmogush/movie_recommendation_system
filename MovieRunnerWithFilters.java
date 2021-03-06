//2018 Christopher Mogush
//MovieRunnerWithFilters.java

import java.util.*;

public class MovieRunnerWithFilters {
    public void printAverageRatings(){
        ThirdRatings third = new ThirdRatings("ratings.csv");
        //ThirdRatings third = new ThirdRatings("ratings_short.csv");
        System.out.println("read data for " + third.getRaterSize() + " raters");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        //MovieDatabase.initialize("ratedmovies_short.csv");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        
        //code to print list of movies and their average ratings
        //must have at least minNoRatings and be sorted by avg
        int noRatings = 35;
        ArrayList<Rating> ratings = third.getAverageRatings(noRatings);
        Collections.sort(ratings);
        for(Rating r : ratings){
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
        }
        System.out.println("Found " + ratings.size() + " movies with " + noRatings + " rating(s)");
    }
    //You will use the YearsAfterFilter to calculate the number of movies in the database that have 
    //at least a minimal number of ratings and came out in a particular year or later.   
    
    public void printAverageRatingsByYearAfter(){
        ThirdRatings third = new ThirdRatings("ratings.csv");
        //ThirdRatings third = new ThirdRatings("ratings_short.csv");
        System.out.println("read data for " + third.getRaterSize() + " raters");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        //MovieDatabase.initialize("ratedmovies_short.csv");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        
        //code to print list of movies and their average ratings
        //must have at least minNoRatings and be sorted by avg
        int noRatings = 20;
        int year = 2000;
        ArrayList<Rating> ratings = third.getAverageRatingsByFilter(noRatings, new YearAfterFilter(year)); 
        Collections.sort(ratings);
        for(Rating r : ratings){
            System.out.println(r.getValue() + " " + MovieDatabase.getYear(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()));
        }
        System.out.println("Found " + ratings.size() + " movies with " + noRatings + " rating(s) made after " + year);
        
    }
    
    public void printAverageRatingsByGenre(){
        ThirdRatings third = new ThirdRatings("ratings.csv");
        //ThirdRatings third = new ThirdRatings("ratings_short.csv");
        System.out.println("read data for " + third.getRaterSize() + " raters");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        //MovieDatabase.initialize("ratedmovies_short.csv");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        
        //code to print list of movies and their average ratings
        //must have at least minNoRatings and be sorted by avg
        int noRatings = 20;
        String genre = "Comedy";
        ArrayList<Rating> ratings = third.getAverageRatingsByFilter(noRatings, new GenreFilter(genre)); 
        Collections.sort(ratings);
        for(Rating r : ratings){
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
            System.out.println("\t" + MovieDatabase.getGenres(r.getItem()));
        }
        System.out.println("Found " + ratings.size() + " movies with " + noRatings + " rating(s) and with the genre " + genre);
    }
    
    public void printAverageRatingsByMinutes(){
        ThirdRatings third = new ThirdRatings("ratings.csv");
        //ThirdRatings third = new ThirdRatings("ratings_short.csv");
        System.out.println("read data for " + third.getRaterSize() + " raters");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        //MovieDatabase.initialize("ratedmovies_short.csv");
        //MovieDatabase.initialize("ratedmovies_smallsample.csv");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        
        //code to print list of movies and their average ratings
        //must have at least minNoRatings and be sorted by avg
        int noRatings = 5;
        int minMinutes = 105;
        int maxMinutes = 130;
        ArrayList<Rating> ratings = third.getAverageRatingsByFilter(noRatings, new MinutesFilter(minMinutes, maxMinutes)); 
        Collections.sort(ratings);
        for(Rating r : ratings){
            System.out.println(r.getValue() + " Time: " + MovieDatabase.getMinutes(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()));
        }
        System.out.println("Found " + ratings.size() + " movies with " + noRatings 
            + " rating(s) and with runtime between " + minMinutes + " and " + maxMinutes);
    }
    
    public void printAverageRatingsByDirectors(){
        ThirdRatings third = new ThirdRatings("ratings.csv");
        //ThirdRatings third = new ThirdRatings("ratings_short.csv");
        System.out.println("read data for " + third.getRaterSize() + " raters");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        //MovieDatabase.initialize("ratedmovies_short.csv");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        
        //code to print list of movies and their average ratings
        //must have at least minNoRatings and be sorted by avg
        int noRatings = 4;
        String directors = "Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack";
        ArrayList<Rating> ratings = third.getAverageRatingsByFilter(noRatings, new DirectorsFilter(directors)); 
        Collections.sort(ratings);
        for(Rating r : ratings){
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
            System.out.println("\t" + MovieDatabase.getDirector(r.getItem()));
        }
        System.out.println("Found " + ratings.size() + " movies with " + noRatings 
            + " rating(s) and directed by one of: " + directors);
    }
    
    public void printAverageRatingsByYearAfterAndGenre(){
        ThirdRatings third = new ThirdRatings("ratings.csv");
        //ThirdRatings third = new ThirdRatings("ratings_short.csv");
        System.out.println("read data for " + third.getRaterSize() + " raters");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        //MovieDatabase.initialize("ratedmovies_short.csv");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        
        //Criteria for filters
        int noRatings = 8; //must have at least minNoRatings and be sorted by avg
        int year = 1990;
        String genre = "Drama";
        //int minMinutes = 110;
        //int maxMinutes = 170;
        //String directors = "Charles Chaplin,Michael Mann,Spike Jonze";
        
        //AllFilters object to combine filters
        AllFilters f = new AllFilters();
        f.addFilter(new YearAfterFilter(year));
        f.addFilter(new GenreFilter(genre));
        
        //Get movies that match filter and no. ratings
        ArrayList<Rating> ratings = third.getAverageRatingsByFilter(noRatings, f); 
        
        //Sort list
        Collections.sort(ratings);
        //Print list of results
        for(Rating r : ratings){
            System.out.println(r.getValue() + " " + MovieDatabase.getYear(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()));
            System.out.println("\t" + MovieDatabase.getGenres(r.getItem()));
        }
         //Print out # found matching criteria
        System.out.println("Found " + ratings.size() + " movies with " + noRatings 
            + " rating(s), made after year " + year + ", of genre: " + genre);
    }
    
    public void printAverageRatingsByDirectorsAndMinutes(){
        ThirdRatings third = new ThirdRatings("ratings.csv");
        //ThirdRatings third = new ThirdRatings("ratings_short.csv");
        System.out.println("read data for " + third.getRaterSize() + " raters");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        //MovieDatabase.initialize("ratedmovies_short.csv");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        
        //Criteria for filters
        int noRatings = 3; //must have at least minNoRatings and be sorted by avg
        //int year = 1980;
        //String genre = "Romance";
        int minMinutes = 90;
        int maxMinutes = 180;
        String directors = "Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack";
        
        //AllFilters object to combine filters
        AllFilters f = new AllFilters();
        f.addFilter(new MinutesFilter(minMinutes, maxMinutes));
        f.addFilter(new DirectorsFilter(directors));
        
        //Get movies that match filter and no. ratings
        ArrayList<Rating> ratings = third.getAverageRatingsByFilter(noRatings, f); 
        
        //Sort list
        Collections.sort(ratings);
        //Print list of results
        for(Rating r : ratings){
            System.out.println(r.getValue() + " Time: " + MovieDatabase.getMinutes(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()));
            System.out.println("\t" + MovieDatabase.getDirector(r.getItem()));
        }
        //Print out # found matching criteria
        System.out.println("Found " + ratings.size() + " movies with " + noRatings 
            + " rating(s), of runtime between " + minMinutes + " and " + maxMinutes + ", directed by one of: " + directors);        
    }
}
