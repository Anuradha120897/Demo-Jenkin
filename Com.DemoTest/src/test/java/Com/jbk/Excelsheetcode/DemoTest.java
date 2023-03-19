package Com.jbk.Excelsheetcode;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class DemoTest {

	
	@Test
	public void test01() throws Exception {
		
		DataFormatter df = new DataFormatter();
		
		FileInputStream fis = new FileInputStream("Myfile.xlsx");
		
//file contain the workbook so here we use the workbook class 
//in previous we had use the workbook class , but the apachi poi provide the workbook factory class 
//which contain the create method , by using this method u can make the workbook
		
		Workbook wb = WorkbookFactory.create(fis);
		
// workbook contain the multiple sheets so by using the ref of workbook we can create the sheet 
// when we use the apachi poi libary all import should be from poi.ss package
		
		Sheet sh = wb.getSheet("sheet1"); 
//now sheet contain the rows and col so by using the sheet ref we can access the rows 
// from this we get the total count of rows	     
		int rows= sh.getLastRowNum();
		
//for row no we can use the for loop row is start from the zero so 
		
		for (int i = 1; i < rows; i++) {
			
//	from rows we can calculate the column i.e. cell so by using the ref of sheet first call the row nd from perticular 
//we can get the column or cell no, as like of row again use the for loop for col 			
// when it will go the row it will check for the all cells 		
	int cols=sh.getRow(i).getLastCellNum();
			
	for (int j = 0; j < cols; j++) {
		
	Cell c = sh.getRow(i).getCell(j);
				
//now Cell contain the data of sheet which conatin the row and col and this data should be in any format
//it will be in integer or will be in string format this all data will convert into string format by using the dataformater
//so here we use the DataFormator class and will make the object of this class before file inputstream object 
//and by usin the ref of this dataformatter we can convert all the data in string format by using fromatcellvalue 	 
	
	System.out.println(df.formatCellValue(c)+"       ");
			}
			
	System.out.println();
		}
	
	}
}
