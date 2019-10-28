public class Match {

	IContestant team1;
	IContestant team2;
	IResult aResult;
	
	public Match(IContestant team1, IContestant team2, IResult aResult) {
		this.team1 = team1;
		this.team2 = team2;
		this.aResult = aResult;
	}
// Really Don't know how to write winner because don't know how to properly call getWinner and isValid.
	public IContestant winner() {
		if(aResult.isValid()) {
			return aResult.getWinner();
		}
		else {
			return null;
		}
	}
}
