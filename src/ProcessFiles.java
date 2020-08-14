import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ProcessFiles {
	
	public HashMap<String, Adapter> getData() throws IOException {
		// TODO Auto-generated method stub
		HashMap<String, Adapter> adapters = new HashMap<String, Adapter> ();
		BufferedReader csvReader = new BufferedReader(new FileReader("../newadapters.csv"));
		String row;
		
		while ((row = csvReader.readLine()) != null) {
		    String[] data = row.split(";");
		    String description = data[1];
		    description = description.replaceAll("FOR",",");
		    String[] descriptionArray = description.split(",");
		    if (descriptionArray.length > 4)
		    	System.out.println("\nAlert String too long\n");
		    String title = descriptionArray[1].trim();
		    title = toTitleCase(title.toLowerCase() + " Adapter");

		    Adapter temp = new Adapter();
		    temp.setTitle(title);
		    temp.setSKU(data[0]);
		    temp.setStatus(data[2]);
		    try {
			    temp.setCompany(data[3]);
		    } catch(Exception e) {
		    	
		    }
		    try {
		    	temp.setUsedIn(data[4]);
		    } catch(Exception e) {
		    	
		    }
		    try {
		    	temp.setBatteryModels(data[5]);
		    } catch(Exception e) {
		    	
		    }
		    try {
		    	temp.setChem(data[6]);
		    } catch(Exception e) {
		    	
		    }
		    try {
		    	temp.setVolts(data[7]);
		    } catch(Exception e) {
		    	
		    }
		    try {
		    	temp.setmAh(data[8]);
		    } catch(Exception e) {
		    	
		    }
		    try {
		    	temp.setPriceCode(data[9]);
		    } catch(Exception e) {
		    	
		    }
		    if (!adapters.containsKey(temp.getSKU())) {
			    adapters.put(temp.getSKU(), temp);
		    } else {
		    	Adapter temp1 = adapters.get(temp.getSKU());
		    	temp1.setBatteryModels(data[5]);
		    	temp1.setCompany(data[3]);
		    	//temp1.setChem(data[6]);
		    }
		}
		
		csvReader.close();
		
		return adapters;
	}
	
	public String toTitleCase(String input) {
	    StringBuilder titleCase = new StringBuilder(input.length());
	    boolean nextTitleCase = true;

	    for (char c : input.toCharArray()) {
	        if (Character.isSpaceChar(c)) {
	            nextTitleCase = true;
	        } else if (nextTitleCase) {
	            c = Character.toTitleCase(c);
	            nextTitleCase = false;
	        }

	        titleCase.append(c);
	    }
	    return titleCase.toString();
	}

}
