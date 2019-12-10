import java.util.LinkedList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class ElectionData {
	private HashMap<String,Integer> firstChoice = new HashMap<String,Integer>();
	private HashMap<String,Integer> secondChoice = new HashMap<String,Integer>();
	private HashMap<String,Integer> thirdChoice = new HashMap<String,Integer>();
	
  Scanner keyboard = new Scanner(System.in);
  
  ElectionData() {
    
  }
  
  public void processVote(String first, String second, String third) throws UnknownCandidateException, DuplicateVotesException{
	 
	   
	 if(first.equals(second) || first.equals(third)) {
		 throw new DuplicateVotesException(first);
	 }
	 
	 if(second.equals(third)) {
		 throw new DuplicateVotesException(second);
	 }
	 
	 whoAreYou(first);
	 whoAreYou(second);
	 whoAreYou(third);
	 

		  firstChoice.replace(first, (firstChoice.get(first)+1));

		  secondChoice.replace(second, (secondChoice.get(second)+1));

		  thirdChoice.replace(third, (thirdChoice.get(third)+1));

  }
  
  public void whoAreYou(String aCand) throws UnknownCandidateException {
	  if(!firstChoice.containsKey(aCand) && !secondChoice.containsKey(aCand) && !thirdChoice.containsKey(aCand)) {
		  throw new UnknownCandidateException(aCand);
	  }
  }
  
  public void addCandidate(String cand) throws CandidateExistsException {
	  
	  if(firstChoice.containsKey(cand) && secondChoice.containsKey(cand) && thirdChoice.containsKey(cand)) {
		  throw new CandidateExistsException(cand);
	  }
	  
	  firstChoice.put(cand, 0);
	  secondChoice.put(cand, 0);
	  thirdChoice.put(cand, 0);
  }
  
  public String findWinnerMostFirstVotes() {
	  int allVotes = 0;
	  String Winner = "InitialHolder";
	  boolean winnerExists = false;
	  
	  Set<String> favVotes = firstChoice.keySet();
	  
	  for(String key : favVotes) {
		  allVotes = allVotes + firstChoice.get(key);
	  }
	  
	  for(String key : favVotes) {
		  if(firstChoice.get(key) > (allVotes / 2)) {
			  Winner = key;
			  winnerExists = true;
		  }
	  }
	  
	  if(!winnerExists) {
		  Winner = "Runoff required";
	  }
	  
	  return Winner;
  }
  
  public String findWinnerMostPoints() {
	  HashMap<String, Integer> totalScore = new HashMap<String, Integer>();
	  
	  Set<String> fcVotes = firstChoice.keySet();
	  
	  for(String key : fcVotes) {
		  totalScore.put(key, firstChoice.get(key) * 3 + secondChoice.get(key) * 2 + thirdChoice.get(key));
	  }
	  
	  Set<String> voteScore = totalScore.keySet();
	  int lastCandScore = 0;
	  String winner = "InitialHolder";
	  
	  for(String key : voteScore) {
		  if(totalScore.get(key) >= lastCandScore) {
			  lastCandScore = totalScore.get(key);
			  winner = key;
		  }
	  }
	  
	  return winner;
  }
  
  public void printBallot() {
    System.out.println("The candidates are ");
    for (String s : ballot) {
      System.out.println(s);
    }
  }
  
  public void screen() throws CandidateExistsException {
    this.printBallot();
    System.out.println("Who do you want to vote for?");
    String candidate = keyboard.next();
    addCandidate(candidate);
    System.out.println("You voted for " + candidate);
  }
  
//  public int countVotes(String forcand) {
//    int numvotes = 0;
//    for (String s : votes) {
//      if (s.equals(forcand))
//        numvotes = numvotes+1;
//    }
//    return numvotes;
//    }
  }
