
public class UnknownCandidateException extends Exception {

	private String name;
	
	UnknownCandidateException(String name){
		this.name = name;
	}
	
	/*
	 * gets the name of the unknown candidate 
	 */
	public String getUnknownCand() {
		return this.name;
	}
}
