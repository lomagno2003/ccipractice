package Question1_8;

public class Question1_8 {
	public static Boolean isRotation(String word, String rotation){
		if(word.length() == rotation.length()){
			String concatenation = rotation + rotation;
			
			//Represents the isSubstring of the question
			return concatenation.contains(word);
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		if(isRotation("waterbottle", "erbottlewat")){
			System.out.println("OK");
		}
		
		if(isRotation("abba", "baab")){
			System.out.println("OK");
		}
		
	}

}
