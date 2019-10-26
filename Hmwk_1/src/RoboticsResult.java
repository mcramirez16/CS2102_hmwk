
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
	
	public boolean isValid(RoboticsResult aResult) {
		if(aResult.team1tasks < 8 && aResult.team2tasks < 8 && aResult.team1pts <= 16 && aResult.team2pts <= 16) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int[] getScore(RoboticsResult aResult) {
		int[] bothScores = new int[2];//Trying to use array to return the scores of both teams
		bothScores[0] = (int) (aResult.team1pts + aResult.team1tasks);//Is this how you convert double to integer?
		bothScores[1] = (int) (aResult.team2pts + aResult.team2tasks);
		
		if(team1fell = true) {
			bothScores[0] = bothScores[0] - 5;
		}
		
		if(team2fell = true) {
			bothScores[1] = bothScores[1] - 5;
		}
		
		return bothScores;
	}
}
