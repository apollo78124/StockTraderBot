import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GenerateTxtFile {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HashMap<String, Adapter> adapters = new HashMap<String, Adapter> ();
		BufferedReader csvReader = new BufferedReader(new FileReader(""));
		String row;
		
		while ((row = csvReader.readLine()) != null) {
		    String[] data = row.split(";");
		    String description = data[1];
		    description = description.replaceAll("FOR",",");
		    String[] descriptionArray = description.split(",");
		    if (descriptionArray.length > 4)
		    	System.out.println("\nAlert title string too long in " + data[0]);
		    String title = descriptionArray[1].trim();
		    title = toTitleCase(title.toLowerCase() + " Adapter");

		    Adapter temp = new Adapter();
		    temp.setTitle(title);
		    temp.setSKU(data[0]);
		    temp.setStatus(data[2]);
		    try {
			    temp.setCompany(data[3]);
		    } catch(Exception e) {
		    	System.out.println("Problem 3 at " + temp.getSKU());
		    	System.out.println(e);
		    }
		    try {
		    	temp.setUsedIn(data[4]);
		    } catch(Exception e) {

		    	System.out.println("Problem 4 at " + temp.getSKU());
		    	System.out.println(e);
		    }
		    try {
		    	temp.setBatteryModels(data[5]);
		    } catch(Exception e) {

		    	System.out.println("Problem 5 at " + temp.getSKU());
		    	System.out.println(e);
		    }
		    try {
		    	temp.setChem(data[6]);
		    } catch(Exception e) {

		    	System.out.println("Problem 6 at " + temp.getSKU());
		    	System.out.println(e);
		    }
		    try {
		    	temp.setVolts(data[7]);
		    } catch(Exception e) {

		    	System.out.println("Problem 7 at " + temp.getSKU());
		    	System.out.println(e);
		    }
		    try {
		    	temp.setmAh(data[8]);
		    } catch(Exception e) {

		    	System.out.println("Problem 8 at " + temp.getSKU());
		    	System.out.println(e);
		    }
		    try {
		    	temp.setPriceCode(data[9]);
		    } catch(Exception e) {

		    	System.out.println("Problem 9 at " + temp.getSKU());
		    	System.out.println(e);
		    }
		    if (!adapters.containsKey(temp.getSKU())) {
			    adapters.put(temp.getSKU(), temp);
		    } else {
		    	Adapter temp1 = adapters.get(temp.getSKU());
		    	System.out.println(temp.getSKU());
		    	temp1.setCompany(data[3]);
		    	temp1.setUsedIn(data[4]);
		    	temp1.setBatteryModels(data[5]);
		    	temp1.setChem(data[6]);
		    	temp1.setVolts(data[7]);
		    	temp1.setmAh(data[8]);
		    }
		}
		
		csvReader.close();
		
		Iterator hmIterator = adapters.entrySet().iterator(); 
		BufferedWriter productDescription = new BufferedWriter( 
                new FileWriter("PurifiedData.txt"));
		while (hmIterator.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            Adapter tempAdapter = (Adapter) mapElement.getValue();
            productDescription.write(tempAdapter.getSKU() + ";");
            productDescription.write(tempAdapter.getTitle() + ";");
            productDescription.write(tempAdapter.getPriceCode() + ";");
            productDescription.write(tempAdapter.CADPrice + ";");
            productDescription.write(tempAdapter.USPrice + ";");
            productDescription.write(tempAdapter.getStatus() + ";");
            ArrayList<String> companies = tempAdapter.getCompany();
    		for(String company : companies) {
    			productDescription.write(company + " ");
    		}
    		
    		
    		ArrayList<String> batteryModels = tempAdapter.getBatteryModels();
    		int i = 0;
    		for(String battery : batteryModels) {
    			if (i == 0) {
    				productDescription.write("" + battery);
    			} else {
    				productDescription.write(battery);
    			}
    			if (i < batteryModels.size() - 1) {
    				productDescription.write(", ");
    			}
    			i++;
    		}
    		ArrayList<String> chemList = tempAdapter.getChem();
    		productDescription.write(" Chemistry: ");
    		i = 0;
    		for(String chem : chemList) {
    			productDescription.write(chem);
    			if (i < chemList.size() - 1) {
    				productDescription.write(", ");
    			}
    			i++;
    		}
    		
    		ArrayList<String> voltsList = tempAdapter.getVolts();
    		productDescription.write(" Voltage: ");
    		i = 0;
    		for(String volt : voltsList) {
    			productDescription.write(volt + " V");
    			if (i < voltsList.size() - 1) {
    				productDescription.write(", ");
    			}
    			i++;
    		}
    		
    		
    		productDescription.write(" Capacity: ");
    		ArrayList<String> capacityList = tempAdapter.getmAh();
    		i = 0;
    		for(String capacity : capacityList) {
    			productDescription.write(capacity + " mAh");
    			if (i < capacityList.size() - 1) {
    				productDescription.write(", ");
    			}
    			i++;
    		}

    		productDescription.write("for ");
    		i = 0;
    		for(String company : companies) {
    			productDescription.write(company);
    			if (i < companies.size() - 1) {
    				productDescription.write(", ");
    			}
    			i++;
    		}
    		
    		ArrayList<String> usedInList = tempAdapter.getUsedIn();
    		i = 0;
    		for(String usedIn : usedInList) {
    			productDescription.write(usedIn);
    			if (i < usedInList.size() - 1) {
    				productDescription.write(", ");
    			}
    			i++;
    		}
    		productDescription.write("Ships in 2 weeks;");
    		productDescription.write("\n");
		}
		productDescription.close();
	}
	
	public static String toTitleCase(String input) {
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
