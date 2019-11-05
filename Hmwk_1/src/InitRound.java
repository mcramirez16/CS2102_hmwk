import java.util.LinkedList;

public class InitRound extends AbsRound implements IWinner {

	InitRound(LinkedList<Match> matches) {
		super(matches);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Determines if contestant won at least one match
	 * @param aCont
	 * @return boolean true if contestant won a match
	 */
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
