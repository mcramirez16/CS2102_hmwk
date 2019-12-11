import java.util.Scanner;

public class VotingMachine {
	
	ElectionData data = new ElectionData();
	Scanner keyboard = new Scanner(System.in);
	
	VotingMachine(ElectionData data) {
		this.data = data;
	}

	/**
	 * display all the candidates to the voter at voting machine
	 */
	 public void printBallot() {
		    System.out.println("The candidates are ");
		    for (String s : data.getCandidateList()) {
		      System.out.println(s);
		    }
		  }
		  
	 /**
	  * let voter cast vote on voting machine
	  * @throws UnknownCandidateException when the vote contains a name that is not one of the candidates in election data
	  * @throws DuplicateVotesException when the vote has the same name for more than one of the ranked choices, which is not allowed
	  */
		  public void screen() throws UnknownCandidateException, DuplicateVotesException, CandidateExistsException {
		    this.printBallot();
		    System.out.println("Who is your first choice vote?");
		    String cand1 = keyboard.nextLine();
		    System.out.println("Who is your second choice vote?");
		    String cand2 = keyboard.nextLine();
		    System.out.println("Who is your third choice vote?");
		    String cand3 = keyboard.nextLine();
		    try {
		    data.processVote(cand1, cand2, cand3);
		    }
		    catch(UnknownCandidateException e) {
		    	System.out.println("Do you wish to add candidate? Enter Y/N");
		    		String response = keyboard.nextLine();
		    		if(response.contains("y")||response.contains("Y")) {
		    		if(!data.getCandidateList().contains(cand1)) {
		    			addWriteIn(cand1);
		    		}
		    		if(!data.getCandidateList().contains(cand2)) {
		    			addWriteIn(cand2);
		    		}
		    		if(!data.getCandidateList().contains(cand3)) {
		    			addWriteIn(cand3);
		    		}
		    		screen();
		    		}
		    		else {
		    			System.out.println("Candidate not added");
		    		}
		    	
		    	
		    }
		    catch(DuplicateVotesException e) {
		    	System.out.println("You can't vote for the same candidate twice.");
		    	screen();
		    }

		    System.out.println("You voted for " + cand1+cand2+cand3);
		  }
		  
		  /**
		   * tells the voter the name already exists in election data as a candidate when trying to add a new candidate
		   * @param name
		   * @throws CandidateExistsException when the name entered already exists as a candidate in election data
		   */
		  public void addWriteIn(String name) throws CandidateExistsException{
		    	try {
			  data.addCandidate(name);
		    	}catch(CandidateExistsException e) {
		    		System.out.print("Candidate Already Exists");
		    		
		    	}
		    	
		    }
		  
}
