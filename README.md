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

<b>Rater</b> - an interface for classes that keep track of one rater and all their ratings. Contains the following methods:
* *addRating* that has two parameters, a String named item and a double named rating.
* *hasRating* with one String pararemeter for the movie ID. 
* *getID* with no parameters.
* *getRating* that has one parameter item.
* *numRatings* with no parameters.
* *getItemsRated* that has no parameters.

<b>PlainRater</b> - a class that uses the implements the Rater interface. This class includes:
* Two private variables:
>* myID - a unique String ID for this rater
>* myRatings - an ArrayList of Ratings
* A constructor with one parameter of the ID for the rater.
* A method *addRating* that has two parameters, a String named item and a double named rating. A new Rating is created and added to myRatings.
* A method *hasRating* with one String pararemeter for the movie ID. Returns true if a rating exists, false otherwise.
* A method *getID* with no parameters to get the ID of the rater.
* A method *getRating* that has one parameter item. This method returns the double rating of this item if it is in myRatings. Otherwise this method returns -1.
* A method *numRatings* that returns the number of ratings this rater has.
* A method *getItemsRated* that has no parameters. This method returns an ArrayList of Strings representing a list of all the items that have been rated. 

<b>EfficientRater</b> - a class that uses the implements the Rater interface. This class includes:
* Two private variables:
>* myID - a unique String ID for this rater
>* myRatings - a HashMap<String,Rating>. The key in the HashMap is a movie ID, and its value is a rating associated with this movie.
* A constructor with one parameter of the ID for the rater.
* A method *addRating* that has two parameters, a String named item and a double named rating. A new Rating is created and added to myRatings, with the value associated with the movie ID String item as the key in the HashMap.
* A method *hasRating* with one String pararemeter for the movie ID. Returns true if a rating exists, false otherwise.
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

<b>MovieDatabase</b> - This class is an efficient way to get information about movies. It stores movie information in a HashMap for fast lookup of movie information given a movie ID. The class also allows filtering movies based on queries. All methods and fields in the class are static. This means we'll be able to access methods in MovieDatabase without using new to create objects, but by calling methods like MovieDatabase.getMovie("0120915"). This class has the following parts:
* A HashMap named *ourMovies* that maps a movie ID String to a Movie object with all the information about that movie.
* A public initialize method with one String parameter named *moviefile*. We can call this method with the name of the file used to initialize the movie database.
* A private initialize method with no parameters that will load the movie file ratedmoviesfull.csv if no file has been loaded. This method is called as a safety check with any of the other public methods to make sure there is movie data in the database. 
* A private *loadMovies* method to build the HashMap. 
* A *containsID* method with one String parameter named id. This method returns true if the id is a movie in the database, and false otherwise.
* Several getter methods including *getYear*, *getTitle*, *getMovie*, *getPoster*, *getMinutes*, *getCountry*, *getGenres*, and *getDirector*. Each of these takes a movie ID as a parameter and returns information about that movie.
* A *size* method that returns the number of movies in the database. 
* A *filterBy* method that has one Filter parameter named f. This method returns an ArrayList of type String of movie IDs that match the filtering criteria:
*> The interface Filter has only one signature for the method satisfies. Any filters that implement this interface must also have this method. The method satisfies has one String parameter named id representing a movie ID. This method returns true if the movie satisfies the criteria in the method and returns false otherwise.
*> The class <b>TrueFilter</b> can be used to select every movie from MovieDatabase. It’s satisfies method always returns true.
*> The class <b>YearsAfterFilter</b> is a filter for a specified year; it selects only those movies that were created on that year or created later than that year. If the year is 2000, then all movies created in the year 2000 and the years after (2001, 2002, 2003, etc) would be selected if used with MovieDatabase.filterBy.
*> The class <b>AllFilters</b> combines several filters. This class has the following:
*> - A private variable named filters that is an ArrayList of type Filter.
*> - An addFilter method that has one parameter named f of type Filter. This method allows one to add a Filter to the ArrayList filters. 
*> - A satisfies method that has one parameter named id representing a movie ID. This method returns true if the movie satisfies the criteria of all the filters in the filters ArrayList. Otherwise this method returns false.

<b>ThirdRatings</b> - This class does calculations focusing on computing averages on movie ratings. Similar to the SecondRatings class, except movies are stored in the MovieDatabase instead of in the instance variable myMovies.  Includes one private variable, myRaters, of type ArrayList of type Rater. Contains the folling methods:
* *ThirdRatings* - default constructor that loads the files "ratedmoviesfull.csv", "ratings.csv" by calling them into the second constructor.
* *ThirdRatings* - second constructor that creates a FirstRatings object and then calls the loadMovies and loadRaters methods in FirstRatings to read in all the movie and ratings data and store them in the private ArrayList variable of the ThirdRatings class, myRaters.
* *getRaterSize* - returns the number of raters that were read in and stored in the ArrayList of type Rater.
* *getAverageByID* - has two parameters: a String named id representing a movie ID and an integer named minimalRaters. This method returns a double representing the average movie rating for this ID if there are at least minimalRaters ratings. If there are not minimalRaters ratings, then it returns 0.0.
* *getAverageRatings* - has one int parameter named minimalRaters. This method finds the average rating for every movie that has been rated by at least minimalRaters raters. Stores each such rating in a Rating object in which the movie ID and the average rating are used in creating the Rating object. Returns an ArrayList of all the Rating objects for movies that have at least the minimal number of raters supplying a rating. 
>* For example, if minimalRaters has the value 10, then this method returns rating information (the movie ID and its average rating) for each movie that has at least 10 ratings. 
* *getAverageRatingsByFilter* - has two parameters, an int named minimalRaters for the minimum number of ratings a movie must have and a Filter named filterCriteria. This method should create and return an ArrayList of type Rating of all the movies that have at least minimalRaters ratings and satisfies the filter criteria. This method will creates the ArrayList of type String of movie IDs from the MovieDatabase using the filterBy method before calculating those averages. 

<b>MovieRunnerWithFilters</b> - a class used to find the average rating of movies using different filters.
* *printAverageRatings* - has no parameters. Creates a ThirdRatings object and uses the CSV filenames of movie information and ratings information from the first assignment when calling the constructor. Prints the number of movies and number of raters from the two files by calling the MovieDatabase initialize method with the moviefile to set up the movie database. 
* *printAverageRatingsByYear* - similar to printAverageRatings, but also creates a <b>YearAfterFilter</b> and calls *getAverageRatingsByFilter* to get an ArrayList of type Rating of all the movies that have a specified number of minimal ratings and came out in a specified year or later. Print the number of movies found, and for each movie found, print its rating, its year, and its title. 
* *printAverageRatingsByGenre* - creates a <b>GenreFilter</b> and calls * *getAverageRatingsByFilter* to get an ArrayList of type Rating of all the movies that have a specified number of minimal  ratings and include a specified genre. Prints the number of movies found, and for each movie, prints its rating and its title on one line, and its genres on the next line. 
* *printAverageRatingsByMinutes* - creates a <b>MinutesFilter</b> and calls * *getAverageRatingsByFilter* - gets an ArrayList of type Rating of all the movies that have a specified number of minimal ratings and their running time is at least a minimum number of minutes and no more than a maximum number of minutes. Prints the number of movies found, and for each movie prints its rating, its running time, and its title on one line. 
* *printAverageRatingsByDirectors* - creates a <b>DirectorsFilter</b> and calls *getAverageRatingsByFilter* to get an ArrayList of type Rating of all the movies that have a specified number of minimal ratings and include at least one of the directors specified. Print the number of movies found, and for each movie prints its rating and its title on one line, and all its directors on the next line. 
* *printAverageRatingsByYearAfterAndGenre* - creates an <b>AllFilters</b> object that includes criteria based on movies that came out in a specified year or later and have a specified genre as one of its genres. This method calls *getAverageRatingsByFilter* to get an ArrayList of type Rating of all the movies that have a specified number of minimal ratings and the two criteria based on year and genre. Prints the number of movies found, and for each movie, prints its rating, its year, and its title on one line, and all its genres on the next line. 
* *printAverageRatingsByDirectorsAndMinutes* - creates an <b>AllFilters</b> object that includes criteria based on running time (at least a specified minimum number of minutes and at most a specified maximum number of minutes), and directors (at least one of the directors in a list of specified directors—directors are separated by commas). This method calls *getAverageRatingsByFilter* to get an ArrayList of type Rating of all the movies that have a specified number of minimal ratings and the two criteria based on minutes and directors. Prints the number of movies found, and for each movie, prints its rating, its time length, and its title on one line, and all its directors on the next line. 

<b>GenreFilter</b> - a class that implements Filter. The constructor has one parameter named genre representing one genre, and the satisfies method returns true if a movie has this genre. Note that movies may have several genres.

<b>MinutesFilter</b> - a class that implements Filter. Its satisfies method returns true if a movie’s running time is at least min minutes and no more than max minutes.  

<b>DirectorsFilter</b> - a class that implements Filter. The constructor has one parameter named directors representing a list of directors separated by commas (Example: "Charles Chaplin,Michael Mann,Spike Jonze", and its satisfies method should return true if a movie has at least one of these directors as one of its directors. Note that each movie may have several directors.

<b>RaterDatabase</b> - an efficient way to get information about raters. This class contains:
* A HashMap named ourRaters that maps a rater ID String to a Rater object that includes all the movie ratings made by this rater. 
* A public static initialize method with one String parameter named filename. We can call this method with the name of the file used to initialize the rater database.
* A private initialize method with no parameters that initializes the HashMap ourRaters if it does not exist. 
* A public static void *addRatings* method that has one String parameter named filename. We could alternatively call this method to add rater ratings to the database from a file. 
* A public static void *addRaterRating* method that has three parameters, a String named raterID representing a rater ID, a String named movieID that represents a movie ID, and a double named rating that is the rating the rater raterID has given to the movie movieID. This function can be used to add one rater and their movie rating to the database. Notice that the method addRatings calls this method. 
* A method *getRater* has one String parameter named id. This method returns a Rater that has this ID. 
* A method *getRaters* that has no parameters. This method returns an ArrayList of Raters from the database. 
* A method *size* that has no parameters. This method returns the number of raters in the database. 

<b>FourthRatings</b> - This class does calculations focusing on computing averages on movie ratings. Similar to the ThirdRatings class, except raters are stored in the RaterDatabase class, so both movies are ratings are stored in database classes now in place of instance variables.  Includes one private variable, myRaters, of type ArrayList of type Rater. Contains the folling methods:
* *FourthRatings* - default constructor that loads the file, "ratings.csv" by calling them into the second constructor.
* *FourthRatings* - second constructor that creates calls the <b>RaterDatabase</b> *initialize* method to read in all the movie and ratings data.
* *getAverageByID* - has two parameters: a String named id representing a movie ID and an integer named minimalRaters. This method returns a double representing the average movie rating for this ID if there are at least minimalRaters ratings. If there are not minimalRaters ratings, then it returns 0.0.
* *getAverageRatings* - has one int parameter named minimalRaters. This method finds the average rating for every movie that has been rated by at least minimalRaters raters. Stores each such rating in a Rating object in which the movie ID and the average rating are used in creating the Rating object. Returns an ArrayList of all the Rating objects for movies that have at least the minimal number of raters supplying a rating. 
>* For example, if minimalRaters has the value 10, then this method returns rating information (the movie ID and its average rating) for each movie that has at least 10 ratings. 
* *getAverageRatingsByFilter* - has two parameters, an int named minimalRaters for the minimum number of ratings a movie must have and a Filter named filterCriteria. This method should create and return an ArrayList of type Rating of all the movies that have at least minimalRaters ratings and satisfies the filter criteria. This method will creates the ArrayList of type String of movie IDs from the MovieDatabase using the filterBy method before calculating those averages. 
* *dotProduct* - has two parameters, a Rater named me and a Rater named r. This method first translates a rating from the scale 0 to 10 to the scale -5 to 5 and returns the dot product of the ratings of movies that they both rated. This is called by getSimilarities.
* *getSimilarities* - has one String parameter named id—this method computes a similarity rating for each rater in the RaterDatabase (except the rater with the ID given by the parameter) to see how similar they are to the Rater whose ID is the parameter to getSimilarities. This method returns an ArrayList of type Rating sorted by ratings from highest to lowest rating with the highest rating first and only including those raters who have a positive similarity rating since those with negative values are not similar in any way. Note that in each Rating object the item field is a rater’s ID, and the value field is the dot product comparison between that rater and the rater whose ID is the parameter to getSimilarities. 
* *getSimilarRatings* - has three parameters: a String named id representing a rater ID, an integer named numSimilarRaters, and an integer named minimalRaters. This method returns an ArrayList of type Rating, of movies and their weighted average ratings using only the top numSimilarRaters with positive ratings and including only those movies that have at least minimalRaters ratings from those most similar raters (not just minimalRaters ratings overall). 
*> For example, if minimalRaters is 3 and a movie has 4 ratings but only 2 of those ratings were made by raters in the top numSimilarRaters, that movie should not be included. These Rating objects should be returned in sorted order by weighted average rating from largest to smallest ratings. This method is very much like the getAverageRatings method you have written previously. In particular this method should:
*> For every rater, get their similarity rating to the given parameter rater id. Include only those raters with positive similarity ratings—those that are more similar to rater id. 
*> For each movie, calculate a weighted average movie rating based on: Use only the top (largest) numSimilarRaters raters. For each of these raters, multiplies their similarity rating by the rating they gave that movie. This emphasizes those raters who are closer to the rater id, since they have greater weights. The weighted average movie rating for a particular movie is the sum of these weighted average ratings (for each rater multiply their similarity rating by their rating for the movie), divided by the total number of such ratings.
*> This method returns an ArrayList of Ratings for movies and their calculated weighted ratings, in sorted order. 
* *getSimilarRatingsByFilter* - similar to the *getSimilarRatings* method but has one additional Filter parameter named filterCriteria and uses that filter to access and rate only those movies that match the filter criteria. 


<b>MovieRunnerSimilarRatings</b> - a class used to find the average rating of movies using different filters.
* *printAverageRatings* - has no parameters. Creates a FourthRatings object and uses the CSV filenames of movie information and ratings information from the first assignment when calling the constructor. Prints the number of movies and number of raters from the two files by calling the MovieDatabase initialize method with the moviefile to set up the movie database. 
* *printAverageRatingsByYearAfterAndGenre* - creates an <b>AllFilters</b> object that includes criteria based on movies that came out in a specified year or later and have a specified genre as one of its genres. This method calls *getAverageRatingsByFilter* to get an ArrayList of type Rating of all the movies that have a specified number of minimal ratings and the two criteria based on year and genre. Prints the number of movies found, and for each movie, prints its rating, its year, and its title on one line, and all its genres on the next line. 
* *printSimilarRatings* - has no parameters. This method creates a new FourthRatings object, reads data into the <b>MovieDatabase</b> and <b>RaterDatabase</b>, and then calls *getSimilarRatings* for a particular rater ID, a number for the top number of similar raters, and a number of minimal rateSimilarRatings, and then lists recommended movies and their similarity ratings. 
*> For example, using the files ratedmoviesfull.csv and ratings.csv and the rater ID 65, the number of minimal raters 5, and the number of top similar raters set to 20, the movie returned with the top rated average is “The Fault in Our Stars”.
* *printSimilarRatingsByGenre* - has no parameters. This method is similar to *printSimilarRatings* but also uses a genre filter and then lists recommended movies and their similarity ratings, and for each movie prints the movie and its similarity rating on one line and its genres on a separate line below it. 
*> For example, using the files ratedmoviesfull.csv and ratings.csv, the genre “Action”,  the rater ID 65, the number of minimal raters set to 5, and the number of top similar raters set to 20, the movie returned with the top rated average is “Rush”.
* *printSimilarRatingsByDirector* - has no parameters. This method is similar to *printSimilarRatings* but also uses a director filter and then lists recommended movies and their similarity ratings, and for each movie prints the movie and its similarity rating on one line and its directors on a separate line below it. 
*> For example, using the files ratedmoviesfull.csv and ratings.csv, the directors “Clint Eastwood,Sydney Pollack,David Cronenberg,Oliver Stone”, the rater ID 1034, the number of minimal raters set to 3, and the number of top similar raters set to 10, the movie returned with the top rated average is “Unforgiven”.
* *printSimilarRatingsByGenreAndMinutes* - has no parameters. This method is similar to *printSimilarRatings* but also uses a genre filter and a minutes filter and then lists recommended movies and their similarity ratings, and for each movie prints the movie, its minutes, and its similarity rating on one line and its genres on a separate line below it. 
*> For example, using the files ratedmoviesfull.csv and ratings.csv, the genre “Adventure”,  minutes between 100 and 200 inclusive, the rater ID 65, the number of minimal raters set to 5, and the number of top similar raters set to 10, the movie returned with the top rated average is “Interstellar”.
* *printSimilarRatingsByYearAfterAndMinutes* - has no parameters. This method is similar to *printSimilarRatings* but also uses a year-after filter and a minutes filter and then lists recommended movies and their similarity ratings, and for each movie prints the movie, its year, its minutes, and its similarity rating on one line. 
*> For example, using the files ratedmoviesfull.csv and ratings.csv, the year 2000, minutes between 80 and 100 inclusive, the rater ID 65, the number of minimal raters set to 5, and the number of top similar raters set to 10, the movie returned with the top rated average is “The Grand Budapest Hotel”.

## Data files

In creating recommendations we'll need two data files: one of movies (ratedmoviesfull.csv), and one of ratings of these movies by different raters (ratings.csv). These files are contained in the 'data' folder. 

ratedmoviesfull.csv - has a header row as the first line, first followed by one line for each movie.
ratings.csv - has a header first followed by one line for each rating.

## Link to exercises:
* https://www.coursera.org/learn/java-programming-recommender/supplement/ILMcl/programming-exercise-step-one
* https://www.coursera.org/learn/java-programming-recommender/supplement/KTrOQ/programming-exercise-step-two
* https://www.coursera.org/learn/java-programming-recommender/supplement/E9Xy0/programming-exercise-step-three
* https://www.coursera.org/learn/java-programming-recommender/supplement/433EU/programming-exercise-step-four
