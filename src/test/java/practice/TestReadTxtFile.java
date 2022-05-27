package practice;

import utils.ReadTxtFile;

public class TestReadTxtFile {
	
	public static void main(String[] args) {
		ReadTxtFile txtFile = new ReadTxtFile("./src/test/resources/QuoteTitle.txt");
		for (String s : txtFile.getListData()) {
			System.out.println(s);
		}
	}
	
	

}
