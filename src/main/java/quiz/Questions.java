package quiz;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Questions {
	
	String resource;
	
	Questions(String resource){
		
		this.resource = resource;
		
	}
	
	private static CSVParser returnParser(String resource) throws IOException {
		FileReader file = new FileReader(resource);
		CSVFormat format = CSVFormat.DEFAULT.withTrailingDelimiter();
		CSVParser parser = new CSVParser(file,format);
		return parser;	
	}
	
	protected ArrayList<ArrayList<String>> getQuestionsAndAnswers() throws IOException {
		CSVParser parser = returnParser(this.resource);
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
		return QuestionAnswers;
	}
	
}
