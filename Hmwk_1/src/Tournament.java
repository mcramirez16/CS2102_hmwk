import java.util.LinkedList;

public class Tournament {

	LinkedList<IWinner> rounds;

	/**
	 * Instantiates a Tournament
	 * @param rounds List of rounds in tournament
	 */
	public Tournament(LinkedList<IWinner> rounds) {
		this.rounds = rounds;
	}

	/**
	 * Determines if the contestant is the champion of the tournament
	 * @param team
	 * @return boolean true if contestant won more than half of the rounds
	 */
	public boolean finalWinnerIsValid(IContestant team) {
		int winCount = 0;

		for (int i = 0; i < rounds.size(); i++) {
			if (rounds.get(i).isWinner(team)) {
				winCount += 1;
			}
		}

		if (winCount >= (rounds.size() / 2)) {

			return true;
		} else {
			return false;
		}

	}
}