package Com.jbk.Excelsheetcode;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class DemoTest1 {
//  declared the variable sheet,row and col above as null and make sure that all import should be from poi.ss package 
		
	Sheet sh = null;
	Row r = null;
	Cell c = null;
	
	
	@Test
	public void test01() throws Exception {
         
	                    
		
		FileInputStream fis = new FileInputStream("Myfile.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
// make ths sheet by using the coding for that first we read the file and then create workbook by using Workbookfactory class
//if sheet is null then only this code will be executed		
		if (wb.getSheet("Test")==null) {
			
			sh=wb.createSheet("Test");
//if sheet is null then create sheet method will create the sheet , if the sheet is created it become blank
//so by using create row method we can create the rows into the sheet 
//if row is created then should create the cell also by calling the createcell method using the row ref.			
			r=sh.createRow(3);
			c=r.createCell(5);
//so here we create the row at 3 no and cell at 5 no, we get the cell then we can set the value inside it.
			
		}
		
//	above condition for if sheet is not present 
//	if sheet is present then it will run below condition
//in below condition is sheet is present but the row is null then we have to create the row if row is null then cell is also not present
		
		else {
			sh=wb.getSheet("Test");
			if(sh.getRow(3)==null) {
				r=sh.createRow(3);
				c=r.createCell(5);
			}
			
			else {
//	if row is present but cell is null then this loop will exceute
//	if row is present and cell is null then first call the row by using get row method.
//	then use the if condition and then create the cell 	
// if cell is not present then create it if the cell is presend then return the cell 				
				r=sh.getRow(3);
				if(r.getCell(5)==null)
				c=r.createCell(5);
				
				else 
					c=r.getCell(5);
			}
			
			
		}
		c.setCellValue("TheKiranAcadamy");
		
//	here we write the file but now we have to save the file for that we will write the below code
		
		FileOutputStream fos = new FileOutputStream("Myfile.xlsx");
		wb.write(fos);
		wb.close();
		fos.close();
//this is the code for saving the file		
		
//	IMP Note--> things that are present then use get method and the things that are not present then use create method 	
		
	}
}

