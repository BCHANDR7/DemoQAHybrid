package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import lombok.val;

public class ExcelUtil {
	public static List<HashMap<String, String>> data(String filepath, String sheetname) throws Exception
	{
		List<HashMap<String, String>> mydata=new ArrayList<HashMap<String,String>>();
		FileInputStream file=new FileInputStream(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet(sheetname);
		int totalRows=sheet.getLastRowNum();
		XSSFRow headerRow=sheet.getRow(0);
		
		if (headerRow == null) {
	        throw new RuntimeException("Header row is missing in sheet: " + sheetname);
	    }
		
		for(int i=1;i<=totalRows;i++)
		{
			HashMap<String, String> map=new HashMap<String, String>();
			XSSFRow currentRow=sheet.getRow(i);
			 if (currentRow == null) {
		            continue; // skip empty rows
		        }
			for(int j=0;j<currentRow.getLastCellNum();j++)
			{
				
				String key = headerRow.getCell(j).toString();
	            String value;
	            DataFormatter format= new DataFormatter();
	            if(currentRow.getCell(j)!=null)
	            {
	            	value=format.formatCellValue(currentRow.getCell(j));// removes if any point in datasheet
	            }
	            else
	            {
	            	value="";
	            }
	            map.put(key, value);
			}
			
			mydata.add(map);
		}
				
		
		
		return mydata;
	}

}
