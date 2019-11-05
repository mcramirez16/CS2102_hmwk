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
	RugbyResult validRugbyResult = new RugbyResult(rugbyteam1, rugbyteam2, 14.0, 10.0);
	RugbyResult validRugbyResult2 = new RugbyResult(rugbyteam1, rugbyteam3, 19.0, 11.0);
	RugbyResult edgeRugbyResult = new RugbyResult(rugbyteam1, rugbyteam2, 150.0, 10.0);

	RoboticsResult invalidRobotResult = new RoboticsResult(robotteam1, robotteam2, 40.0, 12, false, 5.0, 1, true);
	RoboticsResult validRobotResult = new RoboticsResult(robotteam1, robotteam2, 10.0, 5, false, 16.0, 5, true);
	RoboticsResult edgeRobotResult = new RoboticsResult(robotteam1, robotteam2, 16.1, 8, true, 14.0, 3, true);

	Match validRugbyMatch = new Match(rugbyteam1, rugbyteam2, validRugbyResult);
	Match validRugbyMatch2 = new Match(rugbyteam1, rugbyteam3, validRugbyResult);
	Match invalidRugbyMatch = new Match(rugbyteam1, rugbyteam2, invalidRugbyResult);
	Match validRobotMatch = new Match(robotteam1, robotteam2, validRobotResult);
	Match validRobotMatch2 = new Match(robotteam1, robotteam3, validRobotResult);
	Match invalidRobotMatch = new Match(robotteam1, robotteam2, invalidRobotResult);


	@Test 
	
	
}
