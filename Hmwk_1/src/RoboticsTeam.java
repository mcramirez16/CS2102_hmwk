
public class RoboticsTeam implements IContestant {

	String school;
	String specialFeat;
	int preScore;
	
	/**
	 * Instantiates a RoboticsTeam
	 * @param school String of school name
	 * @param specialFeat String of robot feature
	 * @param preScore int, Score from previous competition
	 */
	public RoboticsTeam(String school, String specialFeat, int preScore) {
		this.school = school;
		this.specialFeat = specialFeat;
		this.preScore = preScore;
	}

	/**
	 * Determines if this team is expected to beat another team
	 * @param aTeam
	 * @return boolean true if this team is expected to win
	 */
	public boolean expectToBeat(RoboticsTeam aTeam) {
		if (this.preScore > aTeam.preScore)
			return true;
		else
			return false;

	}
}
