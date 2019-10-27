
public class RoboticsResult {
	RoboticsTeam team1;
	RoboticsTeam team2;
	Double team1pts;
	Double team2pts;
	int team1tasks;
	int team2tasks;
	boolean team1fell;
	boolean team2fell;
	
	public RoboticsResult(RoboticsTeam team1, RoboticsTeam team2, Double team1pts, int team1tasks, boolean team1fell, Double team2pts, int team2tasks, boolean team2fell) {
		this.team1 = team1;
		this.team2 = team2;
		this.team1pts = team1pts;
		this.team2pts = team2pts;
		this.team1tasks = team1tasks;
		this.team2tasks = team2tasks;
		this.team1fell = team1fell;
		this.team2fell = team2fell;
	}
	
	public boolean isValid() {
		if(this.team1tasks < 8 && this.team2tasks < 8 && this.team1pts <= 16 && this.team2pts <= 16) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public double getScore(double teampts, int teamtasks, boolean teamfell) {//do these have to be the same with actual field names
		double score = teampts + teamtasks;// not sure this is the correct way to do getScore, but at least conforms to compile check 
		
		if(teamfell = true) {
			score = score - 5;
		}
		
		return score;
	}
}
