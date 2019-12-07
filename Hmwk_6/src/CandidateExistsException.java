
public class CandidateExistsException extends Exception {
	String name;
	
	CandidateExistsException(String name){
		this.name = name;
	}
}
