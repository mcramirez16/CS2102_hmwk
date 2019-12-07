
public class DuplicateVotesException extends Exception {

	private String name;
	
	DuplicateVotesException(String name){
		this.name = name;
	}
	
	public String getDuplicateName() {
		return this.name;
	}
}
