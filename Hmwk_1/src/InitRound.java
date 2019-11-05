import java.util.LinkedList;

public class InitRound extends AbsRound implements IWinner {

	/**
	 * Inital round constructor
	 * @param matches List of matches in inital round
	 */
	InitRound(LinkedList<Match> matches) {
		super(matches);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public boolean isWinner(IContestant aCont) {
		for(int i = 0; i<matches.size();i++) {
			if(matches.get(i).winner().equals(aCont)) {
				return true;
			}
		}
		return false;
	}

}
