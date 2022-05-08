
//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> res = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        if(markdown.length() == 0){
            return(null);
        }
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            
            if(openBracket == -1 && closeBracket == -1 && openParen == -1 && closeParen == -1){
                System.out.println("This paragraph is not a link! Please enter a valid link");
                break;
            }
                if(openBracket == -1 ){
                    System.out.println("Invalid input: missing open bracket");
                    break;
                }
                else if(closeBracket == -1){
                    System.out.println("Invalid input: missing closed bracket");
                    break;
                }
                else if(openParen == -1){
                    System.out.println("Invaid input: missing open parenthesis");
                    break;
                }
                else if(closeParen == -1){
                    System.out.println("Invalid input: missing close parenthesis");
                    break;
                }

            res.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;

        }
        

        return res;
    }
 




    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}

 
//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

