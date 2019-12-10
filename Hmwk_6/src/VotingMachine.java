import java.util.Scanner;

public class VotingMachine {
	
	ElectionData data = new ElectionData();
	Scanner keyboard = new Scanner(System.in);
	
	VotingMachine(ElectionData data) {
		this.data = data;
	}

	 public void printBallot() {
		    System.out.println("The candidates are ");
		    for (String s : data.getCandidateList()) {
		      System.out.println(s);
		    }
		  }
		  
		  public void screen() throws UnknownCandidateException,CandidateExistsException {
		    this.printBallot();
		    System.out.println("Who do you want to vote for?");
		    String candidate = keyboard.next();
		    try {
		    data.addCandidate(candidate);
		    }
		    catch(UnknownCandidateException e) {
		    	System.out.println("Candidate not on list");
		    }
		    
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
