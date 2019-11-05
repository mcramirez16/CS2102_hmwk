public class Match {

	IContestant team1;
	IContestant team2;
	IResult aResult;

	public Match(IContestant team1, IContestant team2, IResult aResult) {
		this.team1 = team1;
		this.team2 = team2;
		this.aResult = aResult;
	}

	/**
	 * Get winner of the match
	 * @return A valid winner or null if not valid
	 */
	public IContestant winner() {
		if (aResult.isValid()) {
			return aResult.getWinner();
		} else {
			return null;
		}
	}

}
