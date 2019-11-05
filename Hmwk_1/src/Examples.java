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

	RugbyResult validRugbyResult = new RugbyResult(rugbyteam1, rugbyteam2, 14.0, 10.0);// Team 1 wins
	RugbyResult validRugbyResult2 = new RugbyResult(rugbyteam1, rugbyteam3, 19.0, 11.0);// Team 1 wins
	RugbyResult validRugbyResult3 = new RugbyResult(rugbyteam2, rugbyteam3, 18.0, 11.0);// Team 2 wins
	RugbyResult validRugbyResult4 = new RugbyResult(rugbyteam1, rugbyteam3, 18.0, 20.0);// Team 3 wins

	RoboticsResult validRobotResult = new RoboticsResult(robotteam1, robotteam2, 10.0, 5, false, 16.0, 5, true);// Team
																												// 2
																												// wins
	RoboticsResult validRobotResult2 = new RoboticsResult(robotteam2, robotteam3, 12.0, 0, false, 14.0, 0, false);// Team
																													// 3
																													// wins
	RoboticsResult validRobotResult3 = new RoboticsResult(robotteam1, robotteam3, 12.0, 0, false, 14.0, 0, false);// Team
																													// 3
																													// wins
	RoboticsResult validRobotResult4 = new RoboticsResult(robotteam1, robotteam2, 10.0, 5, false, 9.0, 5, false);// Team
																													// 1
																													// wins

	Match validRugbyMatch = new Match(rugbyteam1, rugbyteam2, validRugbyResult);
	Match validRugbyMatch2 = new Match(rugbyteam1, rugbyteam3, validRugbyResult2);
	Match validRugbyMatch3 = new Match(rugbyteam2, rugbyteam3, validRugbyResult3);
	Match validRugbyMatch4 = new Match(rugbyteam1, rugbyteam3, validRugbyResult4);

	Match validRobotMatch = new Match(robotteam1, robotteam2, validRobotResult);
	Match validRobotMatch2 = new Match(robotteam2, robotteam3, validRobotResult2);
	Match validRobotMatch3 = new Match(robotteam1, robotteam3, validRobotResult3);
	Match validRobotMatch4 = new Match(robotteam1, robotteam2, validRobotResult4);

	LinkedList<Match> rugbySeedingMatches = new LinkedList<Match>();
	LinkedList<Match> robotSeedingMatches = new LinkedList<Match>();
	LinkedList<Match> rugbyEliminationMatches = new LinkedList<Match>();
	LinkedList<Match> robotEliminationMatches = new LinkedList<Match>();
	LinkedList<Match> rugbySemifinalMatches = new LinkedList<Match>();
	LinkedList<Match> robotSemifinalMatches = new LinkedList<Match>();

	InitRound rugbyRound1 = new InitRound(rugbySeedingMatches);
	InitRound robotRound1 = new InitRound(robotSeedingMatches);
	InitRound rugbyRound2 = new InitRound(rugbyEliminationMatches);
	InitRound robotRound2 = new InitRound(robotEliminationMatches);
	InitRound rugbyRound3 = new InitRound(rugbySemifinalMatches);
	InitRound robotRound3 = new InitRound(robotSemifinalMatches);

	LinkedList<Match> rugbyFinalMatches = new LinkedList<Match>();
	LinkedList<Match> robotFinalMatches = new LinkedList<Match>();

	LinkedList<IContestant> rugbyFinalContestants = new LinkedList<IContestant>();
	LinkedList<IContestant> robotFinalContestants = new LinkedList<IContestant>();

	AdvancedRound rugbyFinals = new AdvancedRound(rugbyFinalMatches, rugbyFinalContestants);
	AdvancedRound robotFinals = new AdvancedRound(robotFinalMatches, robotFinalContestants);

	LinkedList<IWinner> rugbyBracket = new LinkedList<IWinner>();
	LinkedList<IWinner> robotBracket = new LinkedList<IWinner>();

	Tournament rugbyTournament = new Tournament(rugbyBracket);
	Tournament robotTournament = new Tournament(robotBracket);

	@Test
	public void getMatchWinnersRugbySeedingTest() {
		rugbySeedingMatches.add(validRugbyMatch);
		rugbySeedingMatches.add(validRugbyMatch2);
		rugbySeedingMatches.add(validRugbyMatch3);
		LinkedList<IContestant> rugbySeedingWinners = rugbyRound1.getMatchWinners();

		LinkedList<IContestant> rugbyExpectedWinners = new LinkedList<IContestant>();
		rugbyExpectedWinners.add(rugbyteam1);
		rugbyExpectedWinners.add(rugbyteam1);
		rugbyExpectedWinners.add(rugbyteam2);

		assertEquals(rugbySeedingWinners, rugbyExpectedWinners);

	}

	@Test
	public void getMatchNumWinnersRugbySeedingTest() {
		rugbySeedingMatches.add(validRugbyMatch);
		rugbySeedingMatches.add(validRugbyMatch2);
		rugbySeedingMatches.add(validRugbyMatch3);

		int numWinners = rugbyRound1.getNumWinners();

		assertEquals(numWinners, 3);
	}
	
	@Test
	public void getMatchWinnersRobotSeedingTest() {
		robotSeedingMatches.add(validRobotMatch);
		robotSeedingMatches.add(validRobotMatch2);
		robotSeedingMatches.add(validRobotMatch3);
		LinkedList<IContestant> robotSeedingWinners = robotRound1.getMatchWinners();

		LinkedList<IContestant> robotExpectedWinners = new LinkedList<IContestant>();
		robotExpectedWinners.add(robotteam2);
		robotExpectedWinners.add(robotteam3);
		robotExpectedWinners.add(robotteam3);

		assertEquals(robotSeedingWinners, robotExpectedWinners);
	}
	
	@Test
	public void getMatchNumWinnersRobotSeedingTest() {
		robotSeedingMatches.add(validRobotMatch);
		robotSeedingMatches.add(validRobotMatch2);
		robotSeedingMatches.add(validRobotMatch3);

		int numWinners = robotRound1.getNumWinners();

		assertEquals(numWinners, 3);
	}

	@Test
	public void isWinnerRugbyAdvancedRdTest1() {
		rugbyFinalContestants.add(rugbyteam1);
		rugbyFinalContestants.add(rugbyteam3);

		assertTrue(rugbyFinals.isWinner(rugbyteam3));
	}

	@Test
	public void isWinnerRugbyAdvancedRdTest2() {
		rugbyFinalContestants.add(rugbyteam1);
		rugbyFinalContestants.add(rugbyteam3);

		assertFalse(rugbyFinals.isWinner(rugbyteam2));
	}

	@Test
	public void isWinnerRobotAdvancedRdTest1() {
		robotFinalContestants.add(robotteam1);
		robotFinalContestants.add(robotteam3);

		assertTrue(robotFinals.isWinner(robotteam3));
	}

	@Test
	public void isWinnerRobotAdvancedRdTest2() {
		robotFinalContestants.add(robotteam1);
		robotFinalContestants.add(robotteam3);

		assertFalse(robotFinals.isWinner(robotteam2));
	}

	@Test
	public void isWinnerRugbyInitRdTest1() {
		rugbySeedingMatches.add(validRugbyMatch);
		rugbySeedingMatches.add(validRugbyMatch2);
		rugbySeedingMatches.add(validRugbyMatch3);

		assertTrue(rugbyRound1.isWinner(rugbyteam1));
	}

	@Test
	public void isWinnerRugbyInitRdTest2() {
		rugbySeedingMatches.add(validRugbyMatch);
		rugbySeedingMatches.add(validRugbyMatch2);
		rugbySeedingMatches.add(validRugbyMatch3);

		assertFalse(rugbyRound1.isWinner(rugbyteam3));
	}

	@Test
	public void isWinnerRugbyInitRdTestEdge() {
		rugbySeedingMatches.add(validRugbyMatch);
		rugbySeedingMatches.add(validRugbyMatch2);
		rugbySeedingMatches.add(validRugbyMatch3);

		assertTrue(rugbyRound1.isWinner(rugbyteam2));
	}

	@Test
	public void isWinnerRobotInitRdTest1() {
		robotSeedingMatches.add(validRobotMatch);
		robotSeedingMatches.add(validRobotMatch2);
		robotSeedingMatches.add(validRobotMatch3);

		assertTrue(robotRound1.isWinner(robotteam3));
	}

	@Test
	public void isWinnerRobotInitRdTest2() {
		robotSeedingMatches.add(validRobotMatch);
		robotSeedingMatches.add(validRobotMatch2);
		robotSeedingMatches.add(validRobotMatch3);

		assertFalse(robotRound1.isWinner(robotteam1));
	}

	@Test
	public void isWinnerRobotInitRdTestEdge() {
		robotSeedingMatches.add(validRobotMatch);
		robotSeedingMatches.add(validRobotMatch2);
		robotSeedingMatches.add(validRobotMatch3);

		assertTrue(robotRound1.isWinner(robotteam2));
	}

	@Test
	public void finalWinnerIsValidRugbyTest1() {
		rugbySeedingMatches.add(validRugbyMatch);
		rugbySeedingMatches.add(validRugbyMatch2);
		rugbySeedingMatches.add(validRugbyMatch3);

		rugbyFinalMatches.add(validRugbyMatch);
		rugbyFinalMatches.add(validRugbyMatch2);
		rugbyFinalMatches.add(validRugbyMatch3);

		rugbySemifinalMatches.add(validRugbyMatch);
		rugbySemifinalMatches.add(validRugbyMatch2);
		rugbySemifinalMatches.add(validRugbyMatch3);

		rugbyEliminationMatches.add(validRugbyMatch);
		rugbyEliminationMatches.add(validRugbyMatch2);
		rugbyEliminationMatches.add(validRugbyMatch3);

		rugbyBracket.add(rugbyRound1);
		rugbyBracket.add(rugbyRound2);
		rugbyBracket.add(rugbyRound3);
		rugbyBracket.add(rugbyFinals);

		assertTrue(rugbyTournament.finalWinnerIsValid(rugbyteam1));
	}

	@Test
	public void finalWinnerIsValidRugbyTest2() {
		rugbySeedingMatches.add(validRugbyMatch);
		rugbySeedingMatches.add(validRugbyMatch2);
		rugbySeedingMatches.add(validRugbyMatch3);

		rugbyEliminationMatches.add(validRugbyMatch);
		rugbyEliminationMatches.add(validRugbyMatch2);
		rugbyEliminationMatches.add(validRugbyMatch4);

		rugbySemifinalMatches.add(validRugbyMatch);
		rugbySemifinalMatches.add(validRugbyMatch2);
		rugbySemifinalMatches.add(validRugbyMatch3);

		rugbyFinalMatches.add(validRugbyMatch);
		rugbyFinalMatches.add(validRugbyMatch2);
		rugbyFinalMatches.add(validRugbyMatch3);

		rugbyBracket.add(rugbyRound1);
		rugbyBracket.add(rugbyRound2);
		rugbyBracket.add(rugbyRound3);
		rugbyBracket.add(rugbyFinals);

		assertFalse(rugbyTournament.finalWinnerIsValid(rugbyteam3));
	}

	public void finalWinnerIsValidRugbyTestEdge() {
		rugbySeedingMatches.add(validRugbyMatch);
		rugbySeedingMatches.add(validRugbyMatch2);
		rugbySeedingMatches.add(validRugbyMatch3);

		rugbyEliminationMatches.add(validRugbyMatch);
		rugbyEliminationMatches.add(validRugbyMatch2);
		rugbyEliminationMatches.add(validRugbyMatch4);

		rugbySemifinalMatches.add(validRugbyMatch);
		rugbySemifinalMatches.add(validRugbyMatch2);
		rugbySemifinalMatches.add(validRugbyMatch4);

		rugbyFinalMatches.add(validRugbyMatch);
		rugbyFinalMatches.add(validRugbyMatch2);
		rugbyFinalMatches.add(validRugbyMatch3);

		rugbyBracket.add(rugbyRound1);
		rugbyBracket.add(rugbyRound2);
		rugbyBracket.add(rugbyRound3);
		rugbyBracket.add(rugbyFinals);

		assertTrue(rugbyTournament.finalWinnerIsValid(rugbyteam3));
	}

	@Test
	public void finalWinnerIsValidRobotTest1() {
		robotSeedingMatches.add(validRobotMatch);
		robotSeedingMatches.add(validRobotMatch2);
		robotSeedingMatches.add(validRobotMatch3);

		robotEliminationMatches.add(validRobotMatch);
		robotEliminationMatches.add(validRobotMatch2);
		robotEliminationMatches.add(validRobotMatch4);

		robotSemifinalMatches.add(validRobotMatch);
		robotSemifinalMatches.add(validRobotMatch2);
		robotSemifinalMatches.add(validRobotMatch3);

		robotFinalMatches.add(validRobotMatch);
		robotFinalMatches.add(validRobotMatch2);
		robotFinalMatches.add(validRobotMatch3);

		robotBracket.add(robotRound1);
		robotBracket.add(robotRound2);
		robotBracket.add(robotRound3);
		robotBracket.add(robotFinals);

		assertTrue(robotTournament.finalWinnerIsValid(robotteam2));
	}

	@Test
	public void finalWinnerIsValidRobotTest2() {
		robotSeedingMatches.add(validRobotMatch);
		robotSeedingMatches.add(validRobotMatch2);
		robotSeedingMatches.add(validRobotMatch3);

		robotEliminationMatches.add(validRobotMatch);
		robotEliminationMatches.add(validRobotMatch2);
		robotEliminationMatches.add(validRobotMatch4);

		robotSemifinalMatches.add(validRobotMatch);
		robotSemifinalMatches.add(validRobotMatch2);
		robotSemifinalMatches.add(validRobotMatch3);

		robotFinalMatches.add(validRobotMatch);
		robotFinalMatches.add(validRobotMatch2);
		robotFinalMatches.add(validRobotMatch3);

		robotBracket.add(robotRound1);
		robotBracket.add(robotRound2);
		robotBracket.add(robotRound3);
		robotBracket.add(robotFinals);

		assertFalse(robotTournament.finalWinnerIsValid(robotteam1));
	}

	@Test
	public void finalWinnerIsValidRobotTestEdge() {
		robotSeedingMatches.add(validRobotMatch);
		robotSeedingMatches.add(validRobotMatch2);
		robotSeedingMatches.add(validRobotMatch3);

		robotEliminationMatches.add(validRobotMatch);
		robotEliminationMatches.add(validRobotMatch2);
		robotEliminationMatches.add(validRobotMatch4);

		robotSemifinalMatches.add(validRobotMatch);
		robotSemifinalMatches.add(validRobotMatch2);
		robotSemifinalMatches.add(validRobotMatch4);

		robotFinalMatches.add(validRobotMatch);
		robotFinalMatches.add(validRobotMatch2);
		robotFinalMatches.add(validRobotMatch3);

		robotBracket.add(robotRound1);
		robotBracket.add(robotRound2);
		robotBracket.add(robotRound3);
		robotBracket.add(robotFinals);

		assertTrue(robotTournament.finalWinnerIsValid(robotteam1));
	}

}
