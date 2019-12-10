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
		  
		  public void addWriteIn(String name) throws CandidateExistsException{
		    	try {
			  data.addCandidate(name);
		    	}catch(CandidateExistsException e) {
		    		System.out.print("Candidate Already Exists");
		    		
		    	}
		    	
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
