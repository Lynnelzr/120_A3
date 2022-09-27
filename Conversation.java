import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is about our conversation. We first ask the user to print how many rounds of conversation they want. 
 * Then I create two loops, one to loop the number of conversation and another for checking mirror words.
 * There is one array list for us to add sentences and print transcript in the end; another list for us to convert user input's mirror words.
 */
class Conversation {
  /**
   * @param arguments
   */
  public static void main(String[] arguments) {
    try (// You will start the conversation here.
    Scanner input = new Scanner(System.in)) {
      System.out.println("How many rounds of conversation you want:");
      Integer num_round = input.nextInt(); // define the number of rounds by user's input integer.
      ArrayList<String> TRANSCRIPT = new ArrayList<String>(); //create a new array list for transcript
      TRANSCRIPT.add("TRANSCRIPT:"); //add what we need to the array list
      System.out.println("Hello! What do you want to talk about today？");
      TRANSCRIPT.add("Hello! What do you want to talk about today？");
      try(Scanner input2 = new Scanner(System.in)) { //start a new scanner


      for (int i = 0; i < num_round; i++) {
        String user_input = input2.nextLine();//reading the user input after 
        TRANSCRIPT.add(user_input);
        if (user_input.contains(".")|user_input.contains("!")|user_input.contains("?")) {
          user_input = user_input.replaceAll("\\.", "").replaceAll("\\!","").replaceAll("\\?","");
        } //remove the last punctuation of user's input sentence.
        String[] computer_output = user_input.split(" "); //split the sentence by space
        List<String> list_words = Arrays.asList(computer_output); //convert String array to list
        
        
        Boolean mirror_new_word_found = false; //start Boolean with false
        for (int s = 0; s < list_words.size(); s++) { //loop the list of words to check if there are mirror words and covert them
          if (list_words.get(s).equals("I")){
            list_words.set(s,"You");
            mirror_new_word_found = true;
           } else if (list_words.get(s).equals("you")) {
            list_words.set(s,"I");
            mirror_new_word_found = true;
           } else if (list_words.get(s).equals("am")) {
            list_words.set(s,"are");
            mirror_new_word_found = true;
           } else if (list_words.get(s).equals("are")) {
            list_words.set(s,"am");
            mirror_new_word_found = true;
           } else if (list_words.get(s).equals("me")) {
            list_words.set(s,"you");
            mirror_new_word_found = true;
           } else if (list_words.get(s).equals("I'm")) {
            list_words.set(s,"You're");
            mirror_new_word_found = true;
           } else if (list_words.get(s).equals("You're")) {
              list_words.set(s,"I am");
              mirror_new_word_found = true;
          }
        } 
      
 
        if (! mirror_new_word_found) {
            System.out.println("Tell me more..."); //print if no mirror words
            TRANSCRIPT.add("Tell me more...");
          }
          else {
            String answer = String.join(" ", list_words); //convert list to string and print
            System.out.println(answer+"?");
            TRANSCRIPT.add(answer+"?");
           }
        } 
      }

        System.out.println("Bye!");
        TRANSCRIPT.add("Bye!");
        String transcript = String.join("\n", TRANSCRIPT);
        System.out.println("\n"+transcript); //end the conversation and print transcript
    }
    }
  }
    
    