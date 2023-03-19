package Com.jbk.Excelsheetcode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginwithExcel {

	int count =1;
	Sheet sh = null;
	Row r = null;
	Cell c = null;


	public String getcellvalue(int row, int col) throws Exception {
		//here we make the getstringvalue method and pass the rows and col as argument and set the return type as string 
		//data formatter method class has a formatcellvalue method return any data in string format so in return statement here we write the string value c 
		DataFormatter df = new DataFormatter();

		FileInputStream fis = new FileInputStream("Myfile.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("sheet1");
		Cell c=sh.getRow(row).getCell(col);

		return df.formatCellValue(c);
		// here we read the file and create the workbook and after the we get the sheet by using get sheet method 
		// now sheet contain the row and col i.e cell so by using the ref of sheet call them and save in ref c of class Cell
		// below in sendkeys we pass the getcellvalue method which having arg row and col , in sheet1 2 col and 5 row is present 
		// so for username here we pass the count for row and then will write the count++ which will increase the count one by one and pass the arg for col =0 for username and col= 1for pass		
		//col will be remain 2 but the cell will be multiple thats why the count is set for row 	

	}

	public void writecell(int row,int col,String Data) throws Exception {
		FileInputStream fis = new FileInputStream("Myfile.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		if (wb.getSheet("Sheet1")==null) {

			sh=wb.createSheet("Sheet1");
			r=sh.createRow(row);
			c=r.createCell(col);}
		else {
			sh=wb.getSheet("Sheet1");
			if(sh.getRow(row)==null) {
				r=sh.createRow(row);
				c=r.createCell(col);
			}
			else {				
				r=sh.getRow(row);
				if(r.getCell(col)==null)
					c=r.createCell(col);

				else 
					c=r.getCell(col);
			}


		}
		c.setCellValue(Data);

		FileOutputStream fos = new FileOutputStream("Myfile.xlsx");
		wb.write(fos);
		wb.close();
		fos.close();

	}

	@Test
	public void JBklogin() throws Exception {
		while(count<5) {
			//step1-first we write this method and here we write code of sendkeys of data to the offline website of jbk 
			// after that the we have to add the data in sendkeys are present in excel sheet , whose code is presend in DemoTest class
			//copy this code here for that make the other method inside this copy the code and paste here
			System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("file:///D:/JBK/Anuradha/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
			driver.findElement(By.id("email")).sendKeys(getcellvalue(count, 0));
			driver.findElement(By.id("password")).sendKeys(getcellvalue(count, 1));
			driver.findElement(By.xpath("//button")).click();

			if (driver.getTitle().contains("Dashboard")) {
				writecell(count, 2, "PASS");
				count++;
			}
			else {
				writecell(count, 2, "FAIL");
				count++;

			}

		}}

}
