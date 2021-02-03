# movie_recommendation_system
A program which uses data from movies and databases, including user ratings -- and can answer questions about the data, including which items should be recommended to a user based on their ratings of several movies.

## Classes

<b>Movie</b> - a Plain Old Java Object (POJO) class for storing the data about one movie. It includes the following:
* Eight private variables to represent information about a movie including:
>* id - a String variable representing the IMDB ID of the movie
>* title - a String variable for the movie’s title
>* year - an integer representing the year
>* genres - one String of one or more genres separated by commas
>* director - one String of one or more directors of the movie separated by commas
>* country - one String of one or more countries the film was made in, separated by commas
>* minutes - an integer for the length of the movie
>* poster - a String that is a link to an image of the movie poster if one exists, or “N/A” if no poster exists
* A constructor with eight parameters to initialize the private variables
* Eight getter methods to return the private information such as the method *getGenres* that returns a String of all the genres for this movie.
* A *toString* method for representing movie information as a String so it can easily be printed.

<b>Rating</b> - a POJO class for storing the data about one rating of an item. It includes:
* Two private variables to represent information about a rating:
>* item - a String description of the item being rated (for this assignment you should use the IMDB ID of the movie being rated)
>* value - a double of the actual rating
* A constructor with two parameters to initialize the private variables.
* Two getter methods *getItem* and *getValue*.
* A *toString* method to represent rating information as a String.
* A *compareTo* method to compare this rating with another rating.

<b>Rater</b> - a class that keeps track of one rater and all their ratings. This class includes:
* Two private variables:
>* myID - a unique String ID for this rater
>* myRatings - an ArrayList of Ratings
* A constructor with one parameter of the ID for the rater.
* A method *addRating* that has two parameters, a String named item and a double named rating. A new Rating is created and added to myRatings.
* A method *getID* with no parameters to get the ID of the rater.
* A method *getRating* that has one parameter item. This method returns the double rating of this item if it is in myRatings. Otherwise this method returns -1.
* A method *numRatings* that returns the number of ratings this rater has.
* A method *getItemsRated* that has no parameters. This method returns an ArrayList of Strings representing a list of all the items that have been rated. 

<b>FirstRatings</b> - a class that processes the movie and ratings data and to answer questions about them. Contains the folling methods:

* *loadMovies* - takes in 1 parameter, the filename of a csv containing movies that have been rated. Loads the movies in and returns the result in an ArrayList local variable, movieData. Also calls printMovieData to prints the number of movies, and print each movie.
* *printMovieData* - takes in an ArrayList movieData, analyzes it, and prints the total # of movies, the # of comedies, the # of movies with runtime greater than 150 mins, and the driector(s) with the greatest # of movies.
* *loadRaters* - takes in 1 parameter, the filename of a csv containing raters and their ratings, then processes every record and return an ArrayList of type Rater with all the rater data from the file. 
* *printRaterData* - takes in an ArrayList rater of type Rater, and prints the total # of raters. Then for each rater, prints their ID and the # of movies rated, and prints each movie along with the rating. 
* *printRatingsByID* -takes in 2 parameters, a String id which represents a rater id, and an ArrayList raterData of type Rater. Checks to see if the rater id exists in the ArrayList and, if so, prints the rater information. Otherwise prints that no rater information could be found. 
* *findMaxNoRatings* - takes in 1 parameter, an ArrayList raterData of type Rater. Returns and int of the highest # of ratings given by a single rater.
* *findMaxRaters* - takes in 2 parameters, an ArrayList raterData of type Rater, and an int maxNoRatings representing the maximum number of ratings. Returns all raters who are greater than or equal the maxNoRatings. 
* *printMaxRaters* - takes in 1 parameter, an ArrayList raterData of type Rater. Calls findMaxNoRatings and findMaxRaters, then prints the maximum # of ratings and all raters who ratings that many movies. 
* *findNoRatingsForMovie* - takes in 2 parameters, a String movieID representing a movie, and an ArrayList raterData of type Rater. Returns an int representing the number of ratings for the given movie.
* *findNoMoviesRated* - takes in 1 parameter, an ArrayList raterData of type Rater. Analyzes the ArrayList and returns the # of movies that have been rated.
* *testLoadMovies* - a void method with tests loading a csv containing movies into an ArrayList of type Movie. Prints the resulting ArrayList.
* *testLoadRaters* - a void method with tests loading a csv containing movies into an ArrayList of type Rater. Prints the resulting ArrayList.

<b>SecondRatings</b> - a class to do calculations focusing on computing averages on movie ratings. Includes two private variables, one named myMovies of type ArrayList of type Movie, and a second one named myRaters of type ArrayList of type Rater. Contains the folling methods:

* *SecondRatings* - default constructor that loads the files "ratedmoviesfull.csv", "ratings.csv" by calling them into the second constructor.
* *SecondRatings* - second constructor that creates a FirstRatings object and then calls the loadMovies and loadRaters methods in FirstRatings to read in all the movie and ratings data and store them in the two private ArrayList variables of the SecondRatings class, myMovies and myRaters.
* *getMovieSize* - returns the number of movies that were read in and stored in the ArrayList of type Movie.
* *getRaterSize* - returns the number of raters that were read in and stored in the ArrayList of type Rater.
* *getAverageByID* - has two parameters: a String named id representing a movie ID and an integer named minimalRaters. This method returns a double representing the average movie rating for this ID if there are at least minimalRaters ratings. If there are not minimalRaters ratings, then it returns 0.0.
* *getAverageRatings* - has one int parameter named minimalRaters. This method finds the average rating for every movie that has been rated by at least minimalRaters raters. Stores each such rating in a Rating object in which the movie ID and the average rating are used in creating the Rating object. Returns an ArrayList of all the Rating objects for movies that have at least the minimal number of raters supplying a rating. 
>* For example, if minimalRaters has the value 10, then this method returns rating information (the movie ID and its average rating) for each movie that has at least 10 ratings. 
* *getTitle* - has one String parameter named id, representing the ID of a movie. This method returns the title of the movie with that ID. If the movie ID does not exist, then this method should return a String indicating the ID was not found.
* *getID* - has one String parameter named title representing the title of a movie. This method returns the movie ID of this movie. If the title is not found, return an appropriate message such as “NO SUCH TITLE.”  Note that the movie title must be spelled exactly as it appears in the movie data files.

<b>MovieRunnerAverage</b> - used to test the methods created in SecondRatings by creating a SecondRatings object in MovieRunnerAverage and calling its methods. Contains the following methods:

* *printAverageRatings* - has no parameters. Creates a SecondRatings object and use the CSV filenames of movie information and ratings information from the first assignment when calling the constructor. Prints the number of movies and number of raters from the two files by calling the appropriate methods in the SecondRatings class. 
>* For example, if run on the files ratings_short.csv and ratedmovies_short.csv, you should see 5 raters and 5 movies.
* *getAverageRatingOneMovie* - this method first creates a SecondRatings object, reading in data from the movie and ratings data files. Then this method prints out the average ratings for a specific movie title, such as  the movie “The Godfather”. If the moviefile is set to the file named ratedmovies_short.csv, and the ratingsfile is set to the file ratings_short.csv, then the average for the movie “The Godfather”  would be 9.0.

## Data files

In creating recommendations we'll need two data files: one of movies (ratedmoviesfull.csv), and one of ratings of these movies by different raters (ratings.csv). These files are contained in the 'data' folder. 

ratedmoviesfull.csv - has a header row as the first line, first followed by one line for each movie.
ratings.csv - has a header first followed by one line for each rating.

## Link to exercises:
https://www.coursera.org/learn/java-programming-recommender/supplement/ILMcl/programming-exercise-step-one
https://www.coursera.org/learn/java-programming-recommender/supplement/KTrOQ/programming-exercise-step-two