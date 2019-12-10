
public class VotingMachine {

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
//		    int numvotes = 0;
//		    for (String s : votes) {
//		      if (s.equals(forcand))
//		        numvotes = numvotes+1;
//		    }
//		    return numvotes;
//		    }
}
