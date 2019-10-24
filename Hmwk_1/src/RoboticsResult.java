
public class RoboticsResult {
	RoboticsTeam team1;
	RoboticsTeam team2;
	Double team1pts;
	Double team2pts;
	int team1tasks;
	int team2tasks;
	boolean team1fell;
	boolean team2fell;
	
	public RoboticsResult(RoboticsTeam team1, RoboticsTeam team2, Double team1pts, Double team2pts, boolean team1fell, boolean team2fell, int team1tasks, int team2tasks) {
		this.team1 = team1;
		this.team2 = team2;
		this.team1pts = team1pts;
		this.team2pts = team2pts;
		this.team1tasks = team1tasks;
		this.team2tasks = team2tasks;
		this.team1fell = team1fell;
		this.team2fell = team2fell;
	}
}
