package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.io.IOException;
import java.io.LineNumberReader;
public class findingWord {
    private String word;
    private int length;
    findingWord()throws IOException{
        File f = new File("dictionary.txt"); // Otwieranie pliku txt
        LineNumberReader reader  = new LineNumberReader(new FileReader(f)); // klasa liczaca ilosc linijek 
        String lines="";
        while((lines = reader.readLine()) != null){} // petla przechodzaca cały plik
        length = reader.getLineNumber(); // ilosc linijek w pliku txt
        Random generator = new Random();  
        int randomInt = generator.nextInt(length) + 0;
        length = randomInt;// wybranie losowej linijki z pliku txt
        reader.close();
    }
    int getLength(){
        return length;
    }
    void chooseString()throws IOException{
        LineNumberReader reader  = new LineNumberReader(new FileReader("dictionary.txt"));
        for(int i=0;i<length;i++){
                   word = reader.readLine();
        }
    }
    String getWord(){
        return word;
    }
}
