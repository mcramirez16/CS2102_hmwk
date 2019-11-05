
public class RoboticsResult implements IResult {
	RoboticsTeam team1;
	RoboticsTeam team2;
	Double team1pts;
	Double team2pts;
	int team1tasks;
	int team2tasks;
	boolean team1fell;
	boolean team2fell;

	/**
	 * Instantiates a RoboticsResult
	 * @param team1 First RoboticsTeam
	 * @param team2 Second RoboticsTeam
	 * @param team1pts Double, amount of points for team 1
	 * @param team1tasks int, number of tasks completed
	 * @param team1fell Boolean, True if robot 1 fell during match
	 * @param team2pts Double, amount of points for team 2
	 * @param team2tasks int, number of tasks completed
	 * @param team2fell Boolean, True if robot 2 fell during match
	 */
	public RoboticsResult(RoboticsTeam team1, RoboticsTeam team2, Double team1pts, int team1tasks, boolean team1fell,
			Double team2pts, int team2tasks, boolean team2fell) {
		this.team1 = team1;
		this.team2 = team2;
		this.team1pts = team1pts;
		this.team2pts = team2pts;
		this.team1tasks = team1tasks;
		this.team2tasks = team2tasks;
		this.team1fell = team1fell;
		this.team2fell = team2fell;
	}
	
	/**
	 * Determines if the points and tasks are within bounds of a reasonable result
	 * @return boolean true if the result is reasonable
	 */
	public boolean isValid() {
		if (this.team1tasks < 8 && this.team2tasks < 8 && this.team1pts <= 16 && this.team2pts <= 16) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Calculates a score based on team performance in the match
	 * @param teampts
	 * @param teamtasks
	 * @param teamfell
	 * @return double Team's score for the match
	 */
	public double getScore(double teampts, int teamtasks, boolean teamfell) {

		double score = teampts + teamtasks;

		if (teamfell == true) {
			score = score - 5;
		}

		return score;
	}

	/**
	 * Determines which team won the match
	 * @return IContestant The team that won the match
	 */
	@Override
	public IContestant getWinner() {
		IContestant winner;
		if (getScore(team1pts, team1tasks, team1fell) > getScore(team2pts, team2tasks, team2fell)) {
			winner = team1;
		} else {
			winner = team2;
		}
		return winner;
	}

}
