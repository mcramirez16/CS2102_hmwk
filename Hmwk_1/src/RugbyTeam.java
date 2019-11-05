
public class RugbyTeam implements IContestant {

	String country;
	String jerseyColor;
	boolean hasRitual;
	int wins;
	int losses;

	/**
	 * Instantiates a RugbyTeam
	 * @param country String of country name
	 * @param jerseyColor String of jersey color
	 * @param hasRitual Boolean, True if team has a haka
	 * @param wins int, Number of previous wins
	 * @param losses int, Number of previous loses
	 */
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
