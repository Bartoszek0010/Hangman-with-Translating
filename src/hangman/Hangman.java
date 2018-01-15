package hangman;


import java.io.IOException;
import java.util.Scanner;


public class Hangman {
private String los;
private char[] array;
Hangman(String los, int length){
    this.los = los;
    array = new char[length];
    for(int i=0;i<length;i++){
        array[i] = '_';
    }
}
String getString(){
    return los;
}
int getLength(){
    return los.length();
}
void getArray(){
    for(int i=0;i<los.length();i++){
        System.out.print(array[i]+" ");
    }
    System.out.print("\n");
}
void checking(char letter){  
    for(int i=0;i<los.length();i++){
        if(los.charAt(i) == letter){
            array[i] = letter;
        }     
    }
}
boolean ending(){
    for(int i=0;i<los.length();i++){
        if(los.charAt(i) != array[i])
            return false;
    }
    return true;
}
    public static void main(String[] args) throws IOException , Exception{
        findingWord word = new findingWord();
        word.chooseString();
        //////////////////////
        String str = word.getWord();
        Hangman check = new Hangman(str,str.length());
        check.getArray();
        boolean end = false;
        for(int i=0;i<12;i++){
        System.out.println("1.Guess letter. \n2.Guess whole word.");
        int choose;
        Scanner chosing = new Scanner(System.in);
        choose = chosing.nextInt();
        switch(choose){
            case 1:
                Scanner read = new Scanner(System.in);
                String lett;
                char l;
        
                lett = read.nextLine(); // wprowadzanie literki
                l = lett.charAt(0);
        
                check.checking(l);
                check.getArray();
                System.out.println(i+1 + " / " + 12 + "tries.");
                if(check.ending()){
                    System.out.println("You won :)");
                    end = true;
                }
                break;
            case 2:
                Scanner wholeWord = new Scanner(System.in);
                String guess;
                guess = wholeWord.nextLine();
                System.out.println(i+1 + " / " + 12 + "tries.");
                if(check.getString().equals(guess)){
                    System.out.println("You won :)");
                    end = true;
                }
                break;
        }
        if(end)
            break;
        }
        //Translate translation = new Translate(check.getString());
        String fromLang = "en";
        String toLang = "pl";
        String toTranslate = check.getString();
        if(!end){
            System.out.print("You are loooser.\n"+ "Word: " + check.getString() + " --- " );
            Translator.translate(fromLang, toLang, toTranslate);
        }
          
    }
    
}
