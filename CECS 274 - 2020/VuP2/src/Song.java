/**
 * Tina L Vu
 * 04/27/2020
 * create a song class that contains a song's title, artist name, year published, and rating
 */
public class Song {

    private String title;
    private String artist;
    private int year;
    private int rating; //1-5 stars

    //constructor

    /**
     * set values for title, artist, year, and rating
     * @param songTitle: title of the song
     * @param songArtist: singer of the song
     */
    public Song(String songTitle, String songArtist){
        title = songTitle;
        artist = songArtist;
        year = 0;
        rating = 0;
    }

    /**
     * set values for title, artist, year, and rating
     * @param songTitle: title of the song
     * @param songArtist: singer of the song
     * @param songYear: year the song was released
     * @param songRating: rating of the song
     */
    public Song(String songTitle, String songArtist, int songYear, int songRating){
        title = songTitle;
        artist = songArtist;
        year = songYear;
        rating = songRating;
    }

    /**
     * get the title of the song
     * @return: the title as a string
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * get the artist of the song
     * @return: the artist as a string
     */
    public String getArtist(){
        return this.artist;
    }

    /**
     * get the year of the song
     * @return: the year of the song as an int
     */
    public int getYear(){
        return this.year;
    }

    /**
     * get the rating of the song
     * @return: the rating as an int
     */
    public int getRating(){
        return this.rating;
    }

    @Override
    public String toString() {
        return title + "," + artist + "," + year + "," + rating;
    }

    /**
     * compare by song title and song artist
     * @param songTitle: the title of the song
     * @param songArtist: the artist of the song
     * @return: true if song title and artist is same to param, false if not some
     */
    public boolean equals(String songTitle, String songArtist){
        //if title is the same, compare artist
        if( title == songTitle){
            //if artist is the same, return true
            if( artist == songArtist){
                return true;

                //else return false
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * compare rating, if they are the same then compare by artist, then by title
     * @param songRating: the rating of the song as an integer
     * @param songArtist: the artist of the song as a String
     * @param songTitle: the title of the song as a string
     * @return: 0 if same, 1 if artist/title is greater, -1 if artist/title is lower
     */
    public int compareTo(int songRating, String songArtist, String songTitle){
        //if rating is same, compare Artist
        if(rating == songRating){
            //if artist is the same then compare song titles
            if(artist.equals(songArtist)){
                //if title is the same, they are the same Song
                if(title.equals(songTitle)) {
                    return 0;
                    //else compare the title characters
                } else if(title.charAt(0) == songTitle.charAt(0)){
                    //comparing individual characters
                    int i = 1;
                    //continue to compare each character until the characters doesn't match
                    while(title.charAt(i) == songTitle.charAt(i)){
                        i++;
                    }
                    if(title.charAt(i) > songTitle.charAt(i)){
                        return 1;
                    } else{
                        return -1;
                    }
                    //comparing first character
                } else if(title.charAt(0) > songTitle.charAt(0)){
                    return 1;
                } else{
                    return -1;
                }
            }else if(artist.charAt(0) == songArtist.charAt(0)){
                //comparing individual characters
                int i = 1;
                while(artist.charAt(i) == songArtist.charAt(i)){
                    i++;
                }
                if(artist.charAt(i) > songArtist.charAt(i)){
                    return 1;
                } else{
                    return -1;
                }
                //comparing first character
            }else if(artist.charAt(0) > songArtist.charAt(0)){
                return 1;
            } else {
                return -1;
            }

            //if rating is greater
        } else if( rating > songRating){
            return 1;

            //if rating is lesser
        } else{
            return -1;
        }
    }
}

