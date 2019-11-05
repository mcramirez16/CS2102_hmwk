import static org.junit.Assert.*;

import org.junit.Test;
import java.util.LinkedList;

public class Examples {

	RugbyTeam rugbyteam1 = new RugbyTeam("UK", "Blue", false, 2, 0);
	RugbyTeam rugbyteam2 = new RugbyTeam("AU", "Yellow", true, 1, 1);
	RugbyTeam rugbyteam3 = new RugbyTeam("Poland", "White", false, 4, 1);
	RoboticsTeam robotteam1 = new RoboticsTeam("APECHS", "arm", 4);
	RoboticsTeam robotteam2 = new RoboticsTeam("OHS", "climber", 2);
	RoboticsTeam robotteam3 = new RoboticsTeam("BMS", "launcher", 3);

	RugbyResult invalidRugbyResult = new RugbyResult(rugbyteam1, rugbyteam2, 14.0, 170.0);
	RugbyResult validRugbyResult = new RugbyResult(rugbyteam1, rugbyteam2, 14.0, 10.0);//Team 1 wins
	RugbyResult validRugbyResult2 = new RugbyResult(rugbyteam1, rugbyteam3, 19.0, 11.0);//Team 1 wins
	RugbyResult validRugbyResult3 = new RugbyResult(rugbyteam2, rugbyteam3, 18.0, 11.0);//Team 2 wins
	RugbyResult edgeRugbyResult = new RugbyResult(rugbyteam1, rugbyteam2, 150.0, 10.0);

	RoboticsResult invalidRobotResult = new RoboticsResult(robotteam1, robotteam2, 40.0, 12, false, 5.0, 1, true);
	RoboticsResult validRobotResult = new RoboticsResult(robotteam1, robotteam2, 10.0, 5, false, 16.0, 5, true);//Team 2 wins
	RoboticsResult validRobotResult2 = new RoboticsResult(robotteam2, robotteam3,12.0,0,false,14.0,0,false);//Team 3 wins
	RoboticsResult validRobotResult3 = new RoboticsResult(robotteam1, robotteam3,12.0,0,false,14.0,0,false);//Team 3 wins
	RoboticsResult edgeRobotResult = new RoboticsResult(robotteam1, robotteam2, 16.1, 8, true, 14.0, 3, true);

	Match validRugbyMatch = new Match(rugbyteam1, rugbyteam2, validRugbyResult);
	Match validRugbyMatch2 = new Match(rugbyteam1, rugbyteam3, validRugbyResult2);
	Match validRugbyMatch3 = new Match(rugbyteam2, rugbyteam3, validRugbyResult3);
	Match invalidRugbyMatch = new Match(rugbyteam1, rugbyteam2, invalidRugbyResult);
	Match validRobotMatch = new Match(robotteam1, robotteam2, validRobotResult);
	Match validRobotMatch2 = new Match(robotteam2, robotteam3, validRobotResult2);
	Match validRobotMatch3 = new Match(robotteam1, robotteam3, validRobotResult3);
	Match invalidRobotMatch = new Match(robotteam1, robotteam2, invalidRobotResult);

	LinkedList<Match> rugbySeedingMatches= new LinkedList<Match>();
	LinkedList<Match> robotSeedingMatches = new LinkedList<Match>();
	
	@Test
	public void getMatchWinnersTest() {
		rugbySeedingMatches.add(validRugbyMatch);
		rugbySeedingMatches.add(validRugbyMatch2);
		rugbySeedingMatches.add(validRugbyMatch3);
		InitRound rugbyRound1 = new InitRound(rugbySeedingMatches);
		LinkedList<IContestant> rugbySeedingWinners = rugbyRound1.getMatchWinners();
		
		LinkedList<IContestant> rugbyExpectedWinners = new LinkedList<IContestant>();
		rugbyExpectedWinners.add(rugbyteam1);
		rugbyExpectedWinners.add(rugbyteam1);
		rugbyExpectedWinners.add(rugbyteam2);
		
		assertEquals(rugbySeedingWinners,rugbyExpectedWinners);
		
	}
	
	
	
}
