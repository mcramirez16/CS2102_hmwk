import java.util.LinkedList;

public abstract class AbsRound {
	
	LinkedList<Match> matches;
	
	AbsRound(LinkedList<Match> matches){
		this.matches = matches;
	}
	
	public LinkedList<IContestant> getMatchWinners() {
		LinkedList<IContestant> winners = new LinkedList<IContestant>();
		return winners;
	}
	
	public int getNumWinners() {
		int numWinners = 0;
		return numWinners;
	}

}
