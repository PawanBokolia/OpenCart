package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException 
	{
		String path=".\\testData\\Opencart_loginData.xlsx";                                    //".\\testData\\Opencart_loginData.xlsx";
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols =xlutil.getCellCount("Sheet1",1);
		
		String logindata[][]= new String [totalrows][totalcols]; 	// creating two dimension array which can stor
		
		for(int i=1; i<=totalrows;i++)			 //1				//reading the data from xl storig in two deminsional array 
		{
			for(int j=0; j<totalcols; j++)							//0  i is row j is col
			{
				logindata[i-1][j] = xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
		return logindata;  											//returning two dimension array
	}
}
