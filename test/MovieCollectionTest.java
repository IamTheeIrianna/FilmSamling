import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest {

    @Test
    void addMovie() {


        //Arrange
        MovieCollection movieCollection = new MovieCollection(movieCollection.getMovieCollectionList());

        //Act
        movieCollection.addMovie("Batman", "Chris Nolan", 2007, true, 120, "action");
        movieCollection.addMovie("John", "Peter", 2010, true, 120, "comedy");

        ArrayList<Movie> movies = movieCollection.getMovieCollectionList();
        int actuelResult = movies.size();

        int expectedResult1 = 0;
        int expectedResult2 = 1;
        int expectedResult3 = 2;

        //Assert
        assertEquals(expectedResult1,actuelResult);
        assertEquals(expectedResult2,actuelResult);
        assertEquals(expectedResult3,actuelResult);


    }
}