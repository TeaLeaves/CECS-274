import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
/**
 * Tina L Vu
 * 04/27/2020
 * create a linked list of songs that is initially populated from"songs.txt"
 */
public class Main {
    public static void main(String[] args){

        //boolean to exit the program
        boolean exit = true;
        //create linked list of songs
        LinkedList list = new LinkedList();

        //add songs into linked list and array
        try{
            //scan file
            Scanner read = new Scanner( new File("songs.txt"));
            //repeat until end of file
            while( read.hasNext()){
                //read from the file
                String line = read.nextLine();
                //seperate the values
                String[] values = line.split(",");
                //the title of the song
                String title = values[0];
                //the artist of the song
                String artist = values[1];
                //the year the song was published
                int year = Integer.parseInt(values[2]);
                //the rating of the song
                int rating = Integer.parseInt(values[3]);

                //create Song Object
                Song s1 = new Song(title,artist,year,rating);
                //add the Song into the linked list
                list.add( s1 );
                //sort the linked list of songs
                list.sort();
            }
            read.close();
        } catch ( FileNotFoundException fnf ){
            System.out.println("File was not Found");
        }

        //continue program until prompt to exit
        while(exit == true) {
            //print out the menu
            System.out.println("Menu:");
            System.out.println("1. Add");
            System.out.println("2. Play");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Quit");

            //get user's input
            int userInput = CheckInput.getIntRange(1, 5);

            //go to what ever function chosen
            //add a song to the list then resort the list
            if(userInput == 1){
                //get title
                System.out.print("Title of the Song: ");
                String inputTitle = CheckInput.getString();

                //get artist name
                System.out.print("Name of the Artist: ");
                String inputArtist = CheckInput.getString();

                //get year published
                System.out.print("Year Published: ");
                int inputYear = CheckInput.getPositiveInt();

                //get rating of the song
                System.out.print("Song's Rating: ");
                int inputRating = CheckInput.getIntRange(1,5);

                //create Song Object
                Song s1 = new Song(inputTitle,inputArtist,inputYear,inputRating);
                //add the Song into the linked list
                list.add( s1 );
//                //add the Song into the array list
//                songList.add( s1 );

                    list.sort();

                //remove the song from the front of the list. Display song info
            } else if(userInput == 2){
                System.out.println(list.remove());
//                songList.remove(0);

                //display song searched
            } else if(userInput == 3){
                //print new menu
                System.out.println();
                System.out.println("----------------------------------------------------------------");
                System.out.println("Search By:");
                System.out.println("1. Title and Artist");
                System.out.println("2. Artist");
                System.out.println("3. Decade");

                //get user's input
                userInput = CheckInput.getIntRange(1,3);

                //search by Title and artist
                if(userInput == 1){
                    //get title
                    System.out.print("Title: ");
                    String title = CheckInput.getString();

                    //get artist
                    System.out.print("Artist: ");
                    String artist = CheckInput.getString();

                    //display matching song or "NOT FOUND"
                    Song song = list.searchSong(title, artist);
                    if(song == null){
                        System.out.println("NOT FOUND");
                    } else{
                        System.out.println(song);
                    }

                    //search by Artist
                } else if( userInput == 2 ){
                    //get artist
                    System.out.print("Artist: ");
                    String artist = CheckInput.getString();

                    //display matching songs or "NOT FOUND"
                    ArrayList<Song> songs = list.searchArtist(artist);
                    if(songs == null){
                        System.out.println("NOT FOUND");
                    } else {
                        for(int i = 0; i< songs.size(); i++) {
                            System.out.println(songs.get(i));
                        }
                    }

                    //search by decade
                } else{
                    //get decade
                    System.out.print("Decade: ");
                    int decade = CheckInput.getPositiveInt();

                    //display matching songs or "NOT FOUND"
                    ArrayList<Song> songs = list.searchDecade(decade);
                    if(songs == null){
                        System.out.println("NOT FOUND");
                    } else {
                        list.display(songs);
                    }
                }

                //display the number of songs, then display each song  in the list
            } else if(userInput == 4){
                list.sort();
                System.out.println("TOTAL SONGS: " + list.size());
                list.display();

                //exit
            } else{
                //write the link list of songs back to the file using the toString() function
                try{
                    PrintWriter writer = new PrintWriter("songs.txt");
                    //write to file
                    writer.print(list.toString());
                    writer.close();

                    // if file is not found
                } catch ( FileNotFoundException fnf ){
                    System.out.println("File Not Found");
                }

                //exit the program
                exit = false;
                System.out.println("Good Bye");
            }

        }
    }
}