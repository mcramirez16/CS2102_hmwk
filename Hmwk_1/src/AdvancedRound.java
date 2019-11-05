import java.util.LinkedList;

public class AdvancedRound extends AbsRound implements IWinner {
	
	LinkedList<IContestant> previousWinners;
	
	/*
	 * Instantiates an AdvancedRound
	 * @param matches List of matches in the advanced round
	 * @param contestants List of previous winners
	 */
	AdvancedRound(LinkedList<Match> matches, LinkedList<IContestant> contestants) {
		super(matches);
		this.previousWinners = contestants;
	}
	
	/**
	 * Determines if the contestant won any previous rounds
	 * @param aCont
	 * @return boolean true if the contestant won at least one round previously
	 */
	public boolean isWinner(IContestant aCont) {
		for(int i = 0; i<previousWinners.size();i++) {
			if(previousWinners.get(i)==aCont) {
				return true;
			}
		}
		
		return false;
	}
}
