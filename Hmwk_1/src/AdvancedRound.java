import java.util.LinkedList;

public class AdvancedRound extends AbsRound implements IWinner {
	
	LinkedList<IContestant> previousWinners;

	AdvancedRound(LinkedList<Match> matches, LinkedList<IContestant> contestants) {
		super(matches);
		this.previousWinners = contestants;
	}
	

	public boolean isWinner(IContestant aCont) {
		for(int i = 0; i<previousWinners.size();i++) {
			if(previousWinners.get(i)==aCont) {
				return true;
			}
		}
		
		return false;
	}
}
