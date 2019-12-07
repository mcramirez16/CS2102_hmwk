import java.util.LinkedList;
import java.util.HashMap;
import java.util.Scanner;

class ElectionData {
	HashMap<String,Integer> firstChoice = new HashMap<String,Integer>();
	HashMap<String,Integer> secondChoice = new HashMap<String,Integer>();
	HashMap<String,Integer> thirdChoice = new HashMap<String,Integer>();
	
  Scanner keyboard = new Scanner(System.in);
  
  ElectionData() {
    
  }
  
  public void processVote(String first, String second, String third) {
	  if(firstChoice.containsKey(first)) {
		  firstChoice.replace(first, (firstChoice.get(first)+1));
	  }
	  if(secondChoice.containsKey(second)) {
		  firstChoice.replace(second, (secondChoice.get(second)+1));
	  }
	  if(thirdChoice.containsKey(third)) {
		  firstChoice.replace(third, (thirdChoice.get(third)+1));
	  }
  }
  
  public void addCandidate(String cand) throws CandidateExistsException {
	  firstChoice.put(cand, 0);
	  secondChoice.put(cand, 0);
	  thirdChoice.put(cand, 0);
  }
  
  public void printBallot() {
    System.out.println("The candidates are ");
    for (String s : ballot) {
      System.out.println(s);
    }
  }
  
  public void screen() {
    this.printBallot();
    System.out.println("Who do you want to vote for?");
    String candidate = keyboard.next();
    votes.add(candidate);
    System.out.println("You voted for " + candidate);
  }
  
  public int countVotes(String forcand) {
    int numvotes = 0;
    for (String s : votes) {
      if (s.equals(forcand))
        numvotes = numvotes+1;
    }
    return numvotes;
    }
  }
