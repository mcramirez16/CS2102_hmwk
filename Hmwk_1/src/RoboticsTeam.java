
public class RoboticsTeam implements IContestant{
	
	String school;
	String specialFeat;
	int preScore;
	
	public RoboticsTeam(String school, String specialFeat, int preScore) {
		this.school = school;
		this.specialFeat = specialFeat;
		this.preScore = preScore;
	}
	
	public boolean expectToBeat(RoboticsTeam aTeam) {
		if(this.preScore > aTeam.preScore) 
			return true;
		else 
			return false;
			
		
	}



}
