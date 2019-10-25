
public class RugbyTeam implements IContestant{
	
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

	
}
