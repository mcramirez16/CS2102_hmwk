import static org.junit.Assert.*;

import org.junit.Test;

public class Examples {
	
	RugbyTeam rugbyteam1 = new RugbyTeam("UK","Blue",false,2,0);
	RugbyTeam rugbyteam2 = new RugbyTeam("AU", "Yellow",true,1,1);
	RoboticsTeam robotteam1 = new RoboticsTeam("APECHS","arm",4);
	RoboticsTeam robotteam2 = new RoboticsTeam("OHS","climber",2);
	
	RugbyResult invalidRugbyResult = new RugbyResult(rugbyteam1,rugbyteam2,170.0,14.0);
	RugbyResult validRugbyResult = new RugbyResult(rugbyteam1,rugbyteam2,14.0,10.0);
	RugbyResult edgeRugbyResult = new RugbyResult(rugbyteam1,rugbyteam2,150.0,10.0);
	RoboticsResult invalidRobotResult = new RoboticsResult(robotteam1,robotteam2,40.0,12,false,5.0,1,true);
	RoboticsResult validRobotResult = new RoboticsResult(robotteam1, robotteam2, 10.0, 5, true, 14.0, 3, true);
	RoboticsResult edgeRobotResult = new RoboticsResult(robotteam1, robotteam2, 16.1, 8, true, 14.0, 3, true);
	
	
	Match rugby_match = new Match(rugbyteam1,rugbyteam2,validRugbyResult);
	Match robotics_match = new Match(robotteam1,robotteam2,validRobotResult);
	

	@Test
	public void invalidRobotResultTest() {
		assertFalse(invalidRobotResult.isValid());
	}
	
	@Test
	public void validRobotResultTest() {
		assertTrue(validRobotResult.isValid());
	}
	
	@Test
	public void edgeRobotResultTest() {
		assertFalse(edgeRobotResult.isValid());
	}
	
	@Test
	public void invalidRugbyResultTest() {
		assertFalse(invalidRugbyResult.isValid());
	}
	
	@Test
	public void validRugbyResultTest() {
		assertTrue(validRugbyResult.isValid());
	}
	
	@Test
	public void edgeRugbyResultTest() {
		assertFalse(edgeRugbyResult.isValid());
	}

}
