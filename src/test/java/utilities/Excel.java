package utilities;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pojo.AmazonSearchResult;

public class Excel {
	public static void exportAmazonSearchResult(String seachTerm, List<AmazonSearchResult> results) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(seachTerm);
		XSSFRow headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Price");
		headerRow.createCell(2).setCellValue("Title");

		double firstResultPrice = results.get(0).price;
		double min = firstResultPrice;
		double max = firstResultPrice;
		double avg = 0.0;
		double sum = 0;
		int minid = 0;
		int maxid = 0;
		for (int index = 0; index < results.size(); index++) {
			XSSFRow row = sheet.createRow(index + 1);
			AmazonSearchResult result = results.get(index);
			row.createCell(0).setCellValue(result.id);
			row.createCell(1).setCellValue(result.price);
			row.createCell(2).setCellValue(result.title);

			if (result.price > max) {
				max = result.price;
				maxid = result.id;
			}
			if (result.price < min) {
				min = result.price;
				minid = result.id;
			}

			sum += result.price;

		}
		avg = sum / results.size();

		XSSFRow minRow = sheet.createRow(results.size() + 2);
		minRow.createCell(0).setCellValue("Min");
		minRow.createCell(1).setCellValue(minid);
		minRow.createCell(2).setCellValue(min);

		XSSFRow maxRow = sheet.createRow(results.size() + 3);
		maxRow.createCell(0).setCellValue("Max");
		maxRow.createCell(1).setCellValue(maxid);
		maxRow.createCell(2).setCellValue(max);

		XSSFRow avgRow = sheet.createRow(results.size() + 4);
		avgRow.createCell(0).setCellValue("Avg");
		avgRow.createCell(2).setCellValue(avg);

		FileOutputStream fos;
		String timeStamp = Keywords.getTimeStamp();
		try {
			fos = new FileOutputStream("target/Amazon-" + timeStamp + ".xlsx");
			workbook.write(fos);

			workbook.close();
			fos.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
