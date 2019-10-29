public class Match {

	IContestant team1;
	IContestant team2;
	IResult aResult;

	public Match(IContestant team1, IContestant team2, IResult aResult) {
		this.team1 = team1;
		this.team2 = team2;
		this.aResult = aResult;
	}

	public IContestant winner() {
		if (aResult.isValid()) {
			return aResult.getWinner();
		} else {
			return null;
		}
	}

}
