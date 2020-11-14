/**
 * create a word object that contains the word as a string and its frequency
 */
public class Word {

    //instance variables
    private String word;    //the word being searched for
    private int frequency;  //the number of time the word occurs

    //constructor

    /**
     * pass in a string to assign to word
     * @param string: the string being passed
     */
    public Word(String string){
        word = string;
    }

    //methods

    /**
     * compare two word objects
     * @param data: the word we are comparing with
     * @return: (d < n.data) return -1; (d > n.data) return 1; (d = n.data) return 0
     */
    public int compareTo(Word data){
        //if the two words are the same
        if( word.equals(data.getWord()) ) {
            return 0;
        } else if( word.compareTo(data.getWord()) > 0){
            return 1;
        } else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return word + " = " + frequency + "\n";
    }

    /**
     * increment frequency
     * @return frequency
     */
    public int incFrequency(){
        frequency +=1;
        return frequency;
    }

    /**
     * convert the object word to a string
     * @return the word as a string
     */
    public String getWord(){
        return this.word;
    }

}
