package practice;

import utils.ExcelUtils;

public class TestExcelUtils {
	
	public static void main(String[] args) {
		ExcelUtils objExcelUtils = new ExcelUtils("./src/test/resources/UserData.xlsx", "Sheet1");
		System.out.println(objExcelUtils.sheet.getLastRowNum());
		System.out.println(objExcelUtils.sheet.getRow(0).getLastCellNum());
		String [][] dataStrings = objExcelUtils.dataTable();
		for(String[] array : dataStrings) {
			for(String s: array) {
				System.out.println(s + ", ");
			}
			System.out.println();
		}
		System.out.println(dataStrings);
		
		int [] ar = new int[3];
		ar[0] = 100;
		ar[1] = 2;
		ar[2] = 3;
		ar[3] = 7;
		System.out.println(ar.length);
		
	}
}
