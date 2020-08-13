package quiz;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Quiz  {

	String resource;
	int correctAnswers;

	public Quiz(String resource){
		
		this.resource = resource;
	}

	private CSVParser returnParser() throws IOException {
		FileReader file = new FileReader(this.resource);
		CSVFormat format = CSVFormat.DEFAULT.withTrailingDelimiter();
		CSVParser parser = new CSVParser(file,format);
		return parser;
	}

	public ArrayList<ArrayList<String>> getQuestionsAndAnswers() throws IOException {
		try(CSVParser parser = returnParser()){
		ArrayList<String> questions = new ArrayList<String>();
		ArrayList<String> answers = new ArrayList<String>();
		int index = 0;
		for(CSVRecord element : parser) {
			questions.add(index,element.get(0)); 
			answers.add(index, element.get(1));
		}
		ArrayList<ArrayList<String>> QuestionAnswers = new ArrayList<ArrayList<String>>();
		QuestionAnswers.add(questions);
		QuestionAnswers.add(answers);
		return QuestionAnswers;}
	}

	public void start() throws IOException {
		try (Scanner sc=new Scanner(System.in)){
			ArrayList<ArrayList<String>> QuestionAnswers = getQuestionsAndAnswers();
			System.out.println("Here are the questions!");
			correctAnswers = 0;
			for(int i=0;i<QuestionAnswers.get(0).size();i++) {
				String s;
				System.out.println("Question! " +QuestionAnswers.get(0).get(i));
				System.out.print("Your Answer:");
				s = sc.next();
				if(s.equals(QuestionAnswers.get(1).get(i))) {
					correctAnswers++;
				}
			}}
		System.out.println("End of the Quiz!");
	}

	public void printResult() throws IOException {

		ArrayList<ArrayList<String>> QuestionAnswers = getQuestionsAndAnswers();
		System.out.println("Your Score: "+correctAnswers+"/"+QuestionAnswers.get(0).size());

		if(correctAnswers == QuestionAnswers.get(0).size()) {
			System.out.println("Great!:D");
		}
		else if(correctAnswers > QuestionAnswers.get(0).size()/2) {
			System.out.println("Good Job!");
		}
		else {
			System.out.println("Better luck next time!");
		}

	}
	public static void main(String[] args) throws IOException {
		Quiz q = new Quiz(args[0]);
		q.start();
	}


	public void close() throws IOException {
		// TODO Auto-generated method stub

	}

}
