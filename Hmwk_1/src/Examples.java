import static org.junit.Assert.*;

import org.junit.Test;

public class Examples {
	
	RugbyTeam rugbyteam1 = new RugbyTeam("UK","Blue",false,2,0);
	RugbyTeam rugbyteam2 = new RugbyTeam("AU", "Yellow",true,1,1);
	RoboticsTeam robotteam1 = new RoboticsTeam("APECHS","arm",4);
	RoboticsTeam robotteam2 = new RoboticsTeam("OHS","climber",2);
	
	RugbyResult invalidRugbyResult = new RugbyResult(rugbyteam1,rugbyteam2,14.0,170.0);
	RugbyResult validRugbyResult = new RugbyResult(rugbyteam1,rugbyteam2,14.0,10.0);
	RugbyResult edgeRugbyResult = new RugbyResult(rugbyteam1,rugbyteam2,150.0,10.0);
	
	RoboticsResult invalidRobotResult = new RoboticsResult(robotteam1,robotteam2,40.0,12,false,5.0,1,true);
	RoboticsResult validRobotResult = new RoboticsResult(robotteam1, robotteam2, 10.0, 5, false, 16.0, 5, true);
	RoboticsResult edgeRobotResult = new RoboticsResult(robotteam1, robotteam2, 16.1, 8, true, 14.0, 3, true);
	
	
	Match rugby_match = new Match(rugbyteam1,rugbyteam2,validRugbyResult);
	Match robotics_match = new Match(robotteam1,robotteam2,validRobotResult);
	
	//isValid() Tests for Robotic Results
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
	
	//isValid() Tests for Rugby Results
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
	
	//getWinner() Tests
	@Test
	public void winnerRugbyResultTest1() {
		assertEquals(validRugbyResult.getWinner(),rugbyteam1);
	}
	
	@Test
	public void winnerRugbyResultTest2() {
		assertEquals(invalidRugbyResult.getWinner(),rugbyteam2);
	}
	
	@Test
	public void winnerRobotResultTest1() {
		assertEquals(validRobotResult.getWinner(),robotteam2);
	}
	
	@Test
	public void winnerRobotResultTest2() {
		assertEquals(edgeRobotResult.getWinner(),robotteam1);
	}
	
	@Test
	//getScore() Tests
	public void scoreRobotResultTest1() {
		double team1pts = validRobotResult.team1pts;
		int team1tasks = validRobotResult.team1tasks;
		boolean team1fell = validRobotResult.team1fell;
		
		assertEquals(validRobotResult.getScore(team1pts, team1tasks, team1fell), 15.0,0);
				
	}
	
	@Test
		public void scoreRobotResultTest2() {
			double team1pts = validRobotResult.team2pts;
			int team1tasks = validRobotResult.team2tasks;
			boolean team1fell = validRobotResult.team2fell;
			
			assertEquals(validRobotResult.getScore(team1pts, team1tasks, team1fell), 16.0,0);
					
		}
	
}
