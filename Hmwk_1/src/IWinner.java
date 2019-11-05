
public interface IWinner {
	/**
	 * Determines if contestant won at least one match
	 * @param aCont The contestant being compared
	 * @return boolean true if contestant won a match
	 */
	public boolean isWinner(IContestant aCont);
}
