public class Match {

	RugbyTeam Country1;
	RugbyTeam Country2;
	RugbyResult RugbyGame;
	RoboticsTeam School1;
	RoboticsTeam School2;
	RoboticsResult RobotsComp;
	
	public Match(RugbyTeam Country1, RugbyTeam Country2, RugbyResult RugbyGame) {
		this.Country1 = Country1;
		this.Country2 = Country2;
		this.RugbyGame = RugbyGame;
	}
	
	public Match(RoboticsTeam School1, RoboticsTeam School2, RoboticsResult RobotsComp) {
		this.School1 = School1;
		this.School2 = School2;
		this.RobotsComp = RobotsComp;
	}
	
}
