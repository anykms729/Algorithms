import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

public class Movies {
    public static void main(String[] args) throws IOException {
        Movies movies = new Movies();
        movies.printData();
    }

    private String name;
    private Date release;
    private int rating;
    private String genre;

    public Movies() {
    }

    public Movies(String name, Date release, int rating, String genre) {
        this.name = name;
        this.release = release;
        this.rating = rating;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "******************************* \n Movie Name:\t" + this.name + "\n Release Date\t" + this.release + "\n Rating\t" + this.rating + "\n Genre\t" + this.genre;
    }

    public void printData() throws IOException {
        BufferedReader br = null;
        ArrayList<Movies> movieList = new ArrayList<Movies>();
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\Algorithms\\src\\movie_data.csv"));
            String line = "";
            String[] tempArr; // using this to store each column in a line

            br.readLine(); // reading first line to avoid the header

            // this is used to format the incoming date
            SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");

            while ((line = br.readLine()) != null) { // reading each line of file
                tempArr = line.split(","); // each column has a comma between it

                //associating each input with a variable type
                // first input is the title so it's string
                String title = tempArr[0];
                //second input is a Date so we need to convert string to date
                Date release = ft.parse(tempArr[1]);
                // third input is the rating which is an int
                int rating = Integer.parseInt(tempArr[2]);
                // fourth input is the genre which stays as string
                String genre = tempArr[3];

                movieList.add(new Movies(title, release, rating, genre));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally { // closes the buffered read regardless of whether an exception was called.
            if (br != null) {
                br.close();
            }
        }

        // prints out all the movie data
        for (Movies movie : movieList) {
            System.out.println(movie);
        }
    }
}
	 