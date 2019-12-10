import static org.junit.Assert.*;

import org.junit.Test;

public class Examples {
	ElectionData ballot = new ElectionData();
	
	public Examples() throws CandidateExistsException, UnknownCandidateException, DuplicateVotesException{
		ballot.addCandidate("Bakugo");
		ballot.addCandidate("Deku");
		ballot.addCandidate("Shoto");
		ballot.addCandidate("AllMight");
		
		ballot.processVote("Bakugo", "Deku", "AllMight");
		ballot.processVote("Bakugo", "Shoto", "Deku");
		ballot.processVote("Bakugo", "Deku", "AllMight");
	}

	@Test
	public void mostFirstVotesTest() {
		assertEquals(ballot.findWinnerMostFirstVotes(),"Bakugo");
	}

}
