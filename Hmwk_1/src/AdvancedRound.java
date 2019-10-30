import java.util.LinkedList;

public class AdvancedRound extends AbsRound implements IWinner {
	
	LinkedList<IContestant> contestants;

	AdvancedRound(LinkedList<Match> matches, LinkedList<IContestant> contestants) {
		super(matches);
		// TODO Auto-generated constructor stub
	}

}
