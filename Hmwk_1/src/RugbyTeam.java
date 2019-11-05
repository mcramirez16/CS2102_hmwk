
public class RugbyTeam implements IContestant {

	String country;
	String jerseyColor;
	boolean hasRitual;
	int wins;
	int losses;

	public RugbyTeam(String country, String jerseyColor, boolean hasRitual, int wins, int losses) {
		this.country = country;
		this.jerseyColor = jerseyColor;
		this.hasRitual = hasRitual;
		this.wins = wins;
		this.losses = losses;
	}

	/**
	 * Determines if this team is expected to beat another team
	 * @param aTeam
	 * @return boolean true if this team is expected to win
	 */
	public boolean expectToBeat(RugbyTeam aTeam) {

		if (this.hasRitual == true && aTeam.hasRitual == false) {
			return true;
		} else if ((this.wins - this.losses) > (aTeam.wins - aTeam.losses)) {
			return true;
		} else {
			return false;
		}
	}
}
