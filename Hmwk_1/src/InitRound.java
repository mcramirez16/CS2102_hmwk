import java.util.LinkedList;

public class InitRound extends AbsRound implements IWinner {

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
