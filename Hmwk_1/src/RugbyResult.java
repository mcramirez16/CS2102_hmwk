
public class RugbyResult implements IResult {
	RugbyTeam team1;
	RugbyTeam team2;
	
	Double team1pts;
	Double team2pts;
	
	public RugbyResult(RugbyTeam team1, RugbyTeam team2, Double team1pts, Double team2pts) {
		this.team1 = team1;
		this.team2 = team2;
		this.team1pts = team1pts;
		this.team2pts = team2pts;
	}

	@Override
	public IContestant getWinner() {
		IContestant winner;
		if(team1pts > team2pts) {
			winner = team1;
		}
		else {
			winner = team2;
		}
		return winner;
	}
}
