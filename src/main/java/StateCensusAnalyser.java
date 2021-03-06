
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

/**
 * Class to load data from csv file.
 * 
 * @author Moinuddin
 *
 */
public class StateCensusAnalyser {
	/**
	 * Arraylist of CSVStateCensus Type - censusData
	 */
	ArrayList<CSVStateCensus> censusData = new ArrayList<CSVStateCensus>();

	/**
	 * [1] Method to load csv data to console. 1. Used CSVReader class to read a CSV
	 * file. with argument as csv file path. 2. Read file line by line using while
	 * loop. 3.Adding to list using add method. 4. Using for loop to display data.
	 * catch FileNotFoundException - e catch CsvValidationException - e catch
	 * IOException - e
	 */
	public void loadData() {

		try {
			CSVReader reader = new CSVReader(new FileReader("src/main/resources/IndiaStateCensusData.csv"));
			String[] record;
			record = reader.readNext();
			while ((record = reader.readNext()) != null) {
				censusData.add(new CSVStateCensus(record[0], Long.parseLong(record[1]), Integer.parseInt(record[2]),
						Double.parseDouble(record[3])));
			}

			for (CSVStateCensus data : censusData) {
				System.out.println(data);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method to check size of censusData.
	 * 
	 * @return - true if sized is 5
	 */
	public boolean checkData() {
		if (censusData.size() == 5)
			return true;
		return false;
	}

}
