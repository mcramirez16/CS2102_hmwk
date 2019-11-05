
public class RugbyResult implements IResult {
	RugbyTeam team1;
	RugbyTeam team2;

	Double team1pts;
	Double team2pts;

	/**
	 * Instantiates a Rugby Result
	 * @param team1 First RugbyTeam
	 * @param team2 Second RugbyTeam
	 * @param team1pts Double amount of points for team 1
	 * @param team2pts Double amount of points for team 2
	 */
	public RugbyResult(RugbyTeam team1, RugbyTeam team2, Double team1pts, Double team2pts) {
		this.team1 = team1;
		this.team2 = team2;
		this.team1pts = team1pts;
		this.team2pts = team2pts;
	}

	/**
	 * Determines if the points and tasks are within bounds of a reasonable result
	 * @return boolean true if the result is reasonable
	 */
	public boolean isValid() {
		if (this.team1pts < 150 && this.team2pts < 150) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Determines which team won the match
	 * @return IContestant The team that won the match
	 */
	@Override
	public IContestant getWinner() {
		IContestant winner;
		if (team1pts > team2pts) {
			winner = team1;
		} else {
			winner = team2;
		}
		return winner;
	}

}
