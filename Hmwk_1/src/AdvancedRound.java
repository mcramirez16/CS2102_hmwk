import java.util.LinkedList;

public class AdvancedRound extends AbsRound implements IWinner {
	
	LinkedList<IContestant> contestants;

	AdvancedRound(LinkedList<Match> matches, LinkedList<IContestant> contestants) {
		super(matches);
		this.contestants = contestants;
	}
	

	public boolean isWinner(IContestant aCont) {
		LinkedList<IContestant> winners = this.getMatchWinners();
		for(int i = 0; i<winners.size();i++) {
			if(winners.get(i)==aCont) {
				return true;
			}
		}
		
		return false;
	}
}
