
public class DuplicateVotesException extends Exception {

	private String name;
	
	DuplicateVotesException(String name){
		this.name = name;
	}
	
	/*
	 * gets the name of the repeated name in one vote
	 */
	public String getDuplicateName() {
		return this.name;
	}
}
