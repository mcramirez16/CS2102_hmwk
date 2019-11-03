import java.util.LinkedList;

public class InitRound extends AbsRound implements IWinner {

	InitRound(LinkedList<Match> matches) {
		super(matches);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isWinner(IContestant aCont) {
		// TODO Auto-generated method stub
		return false;
	}

}
