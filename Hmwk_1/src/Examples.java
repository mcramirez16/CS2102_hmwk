import static org.junit.Assert.*;

import org.junit.Test;

public class Examples {
	
	RugbyTeam rugbyteam1 = new RugbyTeam("UK","Blue",false,2,0);
	RugbyTeam rugbyteam2 = new RugbyTeam("AU", "Yellow",true,1,1);
	RoboticsTeam robotteam1 = new RoboticsTeam("APECHS","arm",4);
	RoboticsTeam robotteam2 = new RoboticsTeam("OHS","climber",2);
	Double Uk_points = 10.0;
	Double Au_points = 14.0;
	
	RugbyResult rugby_result = new RugbyResult(rugbyteam1,rugbyteam2,Uk_points,Au_points);
	RoboticsResult robot_result = new RoboticsResult(robotteam1,robotteam2,40.0,12,false,50.0,1,true);
	
	Match rugby_match = new Match(rugbyteam1,rugbyteam2,rugby_result);
	Match robotics_match = new Match(robotteam1,robotteam2,robot_result);
	

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
