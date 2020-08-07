package quiz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class QuizValidation {

	public static void validation(String resource) throws IOException {
		Scanner sc = new Scanner(System.in);
		ArrayList<ArrayList<String>> QuestionAnswers = new Questions(resource).getQuestionsAndAnswers();
		System.out.println("Here are the questions!");
		int correct = 0;
		for(int i=0;i<QuestionAnswers.get(0).size();i++) {
			String s;
			System.out.println("Question! " +QuestionAnswers.get(0).get(i));
			System.out.print("Your Answer:");
			s = sc.next();
			if(s.equals(QuestionAnswers.get(1).get(i))) {
				correct++;
			}
		}
		System.out.println("End of the Quiz!");
		System.out.println("Your Score: "+correct+"/"+QuestionAnswers.get(0).size());
		
		if(correct > QuestionAnswers.get(0).size()/2) {
			System.out.println("Good Job!:D");
		}
		else if(correct == QuestionAnswers.get(0).size()) {
			System.out.println("Great!");
		}
		else {
			System.out.println("Better luck next time!");
		}
	}

	public static void main(String args[]) throws IOException {
		validation(args[0]);
	}

}