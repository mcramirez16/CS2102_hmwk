import java.util.LinkedList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class ElectionData {
	private HashMap<String,Integer> firstChoice = new HashMap<String,Integer>();
	private HashMap<String,Integer> secondChoice = new HashMap<String,Integer>();
	private HashMap<String,Integer> thirdChoice = new HashMap<String,Integer>();
  
  ElectionData() {

  }
  
  /**
   * Gets the list of candidates from election data
   * @return a LinkedList that contains all the candidates 
   */
  public LinkedList<String> getCandidateList(){
	  Set<String> fcVotes = firstChoice.keySet();
	  LinkedList<String> candList = new LinkedList<String>();
	  
	  for(String key : fcVotes) {
		  candList.add(key);
	  }
	  
	  return candList;
  }
  
  /**
   * Takes in a vote casted and stores the choices in election data
   * @param first is the voter's top choice
   * @param second is the voter's second choice
   * @param third is the voter's third choice
   * @throws UnknownCandidateException when the vote contains a name that is not one of the candidates in election data
   * @throws DuplicateVotesException when the vote has the same name for more than one of the ranked choices, which is not allowed
   */
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
  
  /**
   * Checks if a name is not in the list of candidates in election data
   * @param aCand is a name
   * @throws UnknownCandidateException when the name is not in the current list of candidates in election data
   */
  public void whoAreYou(String aCand) throws UnknownCandidateException {
	  if(!firstChoice.containsKey(aCand) && !secondChoice.containsKey(aCand) && !thirdChoice.containsKey(aCand)) {
		  throw new UnknownCandidateException(aCand);
	  }
  }
  
  /**
   * Adds a new candidate in election data
   * @param cand is the name of a new candidate
   * @throws CandidateExistsException when the name entered already is a candidate in election data
   */
  public void addCandidate(String cand) throws CandidateExistsException {
	  
	  if(firstChoice.containsKey(cand) && secondChoice.containsKey(cand) && thirdChoice.containsKey(cand)) {
		  throw new CandidateExistsException(cand);
	  }
	  
	  firstChoice.put(cand, 0);
	  secondChoice.put(cand, 0);
	  thirdChoice.put(cand, 0);
  }
  
  /**
   * Determines the winner of the election, who wins by having more than half of all the votes
   * @return the name of the winner as a String; if there is no clear winner, returns the message "Runoff required"
   */
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
  
  /**
   * Determines the winner of the election, who wins by having the highest score
   * @return the name of the winner as a String
   */
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
  
  }
