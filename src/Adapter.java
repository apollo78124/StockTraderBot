import java.util.ArrayList;

public class Adapter {
	public String SKU;
	public String Title;
	public String Status;
	

	public ArrayList<String> UsedIn;
	public ArrayList<String> Company;
	public ArrayList<String> BatteryModels;
	public ArrayList<String> Chem;
	public ArrayList<String> Volts;
	public ArrayList<String> mAh;
	public ArrayList<String> Category;
	

	public String PriceCode;
	public String USPrice;
	public String CADPrice;
	
	public Adapter() {
		UsedIn = new ArrayList<String>();
		Company = new ArrayList<String>();
		BatteryModels = new ArrayList<String>();
		Chem = new ArrayList<String>();
		Volts = new ArrayList<String>();
		mAh = new ArrayList<String>();
		Category = new ArrayList<String>();
	}
	
	public String convertCodeToCADPrice(String code) {
		switch (code) {
			case "A":
				return "49";
			case "B":
				return "92";
			case "C":
				return "119";
			case "D":
				return "157";
			case "E":
				return "173"; 
			case "F":
				return "184";
			case "G":
				return "200";
			case "H":
				return "211";
			case "I":
				return "221";
			case "J":
				return "232";
			case "K":
				return "491";
				default: 
					return "Contact Cadex Or Representative";
		}
	}
	
	public String convertCodeToUSPrice(String code) {
		switch (code) {
			case "A":
				return "38";
			case "B":
				return "70";
			case "C":
				return "92";
			case "D":
				return "146";
			case "E":
				return "162";
			case "F":
				return "173";
			case "G":
				return "184";
			case "H":
				return "194";
			case "I":
				return "205";
			case "J":
				return "216";
			case "K":
				return "459" ;
				default: 
					return "Contact Cadex Or Representative";
		}
	}
	

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	
	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public ArrayList<String> getUsedIn() {
		return UsedIn;
	}

	public void setUsedIn(String usedIn) {
		if (usedIn == null || UsedIn.contains(usedIn)) {
			return;
		}
		UsedIn.add(usedIn);
	}

	public ArrayList<String> getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		if (company == null || Company.contains(company)) {
			return;
		}
		Company.add(company);
	}

	public ArrayList<String> getBatteryModels() {
		return BatteryModels;
	}

	public void setBatteryModels(String batteryModels) {
		if (batteryModels == null ||BatteryModels.contains(batteryModels)) {
			return;
		}
		BatteryModels.add(batteryModels);
	}

	public ArrayList<String> getChem() {
		return Chem;
	}

	public void setChem(String chem) {
		if (chem == null ||Chem.contains(chem)) {
			return;
		}
		Chem.add(chem);
	}

	public ArrayList<String> getVolts() {
		return Volts;
	}

	public void setVolts(String volts) {
		if (volts == null ||Volts.contains(volts)) {
			return;
		}
		volts = volts.replaceAll(",",".");
		Volts.add(volts);
	}

	public ArrayList<String> getmAh() {
		return mAh;
	}

	public void setmAh(String mAh) {
		if (mAh == null || this.mAh.contains(mAh)) {
			return;
		}
		mAh = mAh.replaceAll(",",".");
		this.mAh.add(mAh);
	}

	public ArrayList<String> getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		if (Category == null || Category.contains(category)) {
			return;
		}
		Category.add(category);
	}

	public String getPriceCode() {
		return PriceCode;
	}

	public void setPriceCode(String priceCode) {
		PriceCode = priceCode;
		USPrice = convertCodeToUSPrice(PriceCode);
		CADPrice = convertCodeToCADPrice(PriceCode);
	}
	
	@Override
	public String toString() {
		return "Adapter [SKU=" + SKU + ", UsedIn=" + UsedIn + ", Title=" + Title + ", Company=" + Company
				+ ", BatteryModels=" + BatteryModels + ", Chem=" + Chem + ", Volts=" + Volts + ", mAh=" + mAh
				+ ", Category=" + Category + ", PriceCode=" + PriceCode + ", USPrice=" + USPrice + ", CADPrice="
				+ CADPrice + "]";
	}
	
	
}
