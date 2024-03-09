package pkg2;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C {

	public static void main(String[] args) {

       

        // Initialize ChromeDriver
        WebDriver driver = new FirefoxDriver();

        // Navigate to the website where you want to select a product
        driver.get("https://amazon.in");

        // Locate and click on the element representing the product you want to select
        WebElement productElement = driver.findElement(By.xpath("//img[@class='s-image']"));
        productElement.click();

        // Get the selected product name
        String selectedProduct = productElement.getText();

      
        // Write the selected product to an Excel sheet using Apache POI
        writeProductToExcel(selectedProduct, "C:\\Users\\dell\\eclipse-workspace\\kart\\drivers\\file.xlsx");
    }

    private static void writeProductToExcel(String product, String outputPath) {
        try{
        	Workbook workbook = new XSSFWorkbook();
            // Create a new sheet
            Sheet sheet = workbook.createSheet("iphone");

            // Create a row
            Row row = sheet.createRow(0);

            // Create a cell and set the product name
            Cell cell = row.createCell(0);
            cell.setCellValue(product);

            // Write the workbook to a file
            try{
            	FileOutputStream outputStream = new FileOutputStream(outputPath);
                workbook.write(outputStream);
            }catch (Exception e) {
			
			}

            System.out.println("Product '" + product + "' written to Excel successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    


	}

}
