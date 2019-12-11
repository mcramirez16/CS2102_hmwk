import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class Examples {
	
	ElectionData ballot = new ElectionData();
	
	public Examples() throws CandidateExistsException, UnknownCandidateException, DuplicateVotesException{
		ballot.addCandidate("Bakugo");
		ballot.addCandidate("Deku");
		ballot.addCandidate("Shoto");
		ballot.addCandidate("AllMight");
	}

	@Test
	public void mostFirstVotesNormalTest() throws UnknownCandidateException, DuplicateVotesException {
		ballot.processVote("Bakugo", "Deku", "AllMight");
		ballot.processVote("Bakugo", "Shoto", "Deku");
		ballot.processVote("Bakugo", "Deku", "AllMight");
		
		assertEquals(ballot.findWinnerMostFirstVotes(),"Bakugo");
	}
	
	@Test
	public void mostFirstVotesOtherCandTest() throws UnknownCandidateException, DuplicateVotesException {
		ballot.processVote("Bakugo", "Deku", "AllMight");
		ballot.processVote("Bakugo", "Shoto", "Deku");
		ballot.processVote("Bakugo", "Deku", "AllMight");
		
		ballot.processVote("Deku", "Bakugo", "AllMight");
		ballot.processVote("Deku", "Shoto", "Bakugo");
		ballot.processVote("Deku", "Bakugo", "AllMight");
		ballot.processVote("Deku", "Shoto", "Bakugo");
		assertEquals(ballot.findWinnerMostFirstVotes(),"Deku");
	}
	
	@Test
	public void mostFirstVotesRunoffTest() throws UnknownCandidateException, DuplicateVotesException {
		ballot.processVote("Bakugo", "Deku", "AllMight");
		ballot.processVote("Bakugo", "Shoto", "Deku");
		ballot.processVote("Bakugo", "Deku", "AllMight");
		
		ballot.processVote("Deku", "Bakugo", "AllMight");
		ballot.processVote("Deku", "Shoto", "Bakugo");
		ballot.processVote("Deku", "Bakugo", "AllMight");
		assertEquals(ballot.findWinnerMostFirstVotes(),"Runoff required");
	}
	
	@Test
	public void mostVotesNormalTest() throws UnknownCandidateException, DuplicateVotesException {
		ballot.processVote("Bakugo", "Deku", "AllMight");
		ballot.processVote("Bakugo", "Shoto", "Deku");
		ballot.processVote("Bakugo", "Deku", "AllMight");
		
		assertEquals(ballot.findWinnerMostPoints(),"Bakugo");
	}
	
	@Test
	public void mostVotesTest1() throws UnknownCandidateException, DuplicateVotesException {
		boolean isWinner = false;
		ballot.processVote("Bakugo", "Deku", "AllMight");
		ballot.processVote("Bakugo", "Shoto", "Deku");
		ballot.processVote("Bakugo", "Deku", "AllMight");
		
		ballot.processVote("Deku", "Shoto", "AllMight");
		ballot.processVote("Shoto", "AllMight", "Deku");
		LinkedList<String> winners = new LinkedList<String>();
		winners.add("Deku");
		winners.add("Bakugo");
		if(winners.contains(ballot.findWinnerMostPoints())) {
			isWinner = true;
		}
		assertTrue(isWinner);
		
	}
	
	@Test
	public void mostVotesTest2() throws UnknownCandidateException, DuplicateVotesException {
		boolean isWinner = false;
		ballot.processVote("Deku", "Bakugo", "AllMight");
		ballot.processVote("Deku", "Shoto", "Bakugo");
		ballot.processVote("Deku", "Bakugo", "AllMight");
		
		ballot.processVote("Bakugo", "Shoto", "AllMight");
		ballot.processVote("Shoto", "AllMight", "Deku");
		LinkedList<String> winners = new LinkedList<String>();
		winners.add("Deku");
		winners.add("Bakugo");
		if(winners.contains(ballot.findWinnerMostPoints())) {
			isWinner = true;
		}
		assertTrue(isWinner);
		
	}
	
	@Test(expected=UnknownCandidateException.class)
	public void unknownProcessVoteTest() throws UnknownCandidateException, DuplicateVotesException {
		ballot.processVote("Hawks", "Bakugo", "Deku");
	}
	
	@Test(expected=DuplicateVotesException.class)
	public void duplicateProcessVoteTest() throws UnknownCandidateException, DuplicateVotesException {
		ballot.processVote("Bakugo", "Bakugo", "Deku");
	}
	
	@Test(expected=CandidateExistsException.class)
	public void candidateExistsTest() throws CandidateExistsException {
		ballot.addCandidate("Deku");
	}
	

}
