
public class UnknownCandidateException extends Exception {

	private String name;
	
	UnknownCandidateException(String name){
		this.name = name;
	}
	
	public String getUnknownCand() {
		return this.name;
	}
}
