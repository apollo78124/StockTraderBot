
public class Adapter {
	public String SKU;
	public String UsedIn;
	public String Company;
	public String BatteryModels;
	public String Chem;
	public String Volts;
	public String mAh;
	public String Category;
	public String PriceCode;
	
	public Adapter(String sKU, String usedIn, String company, String batteryModels, String chem, String volts,
			String mAh, String category, String priceCode) {
		SKU = sKU;
		UsedIn = usedIn;
		Company = company;
		BatteryModels = batteryModels;
		Chem = chem;
		Volts = volts;
		this.mAh = mAh;
		Category = category;
		PriceCode = priceCode;
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public String getUsedIn() {
		return UsedIn;
	}

	public void setUsedIn(String usedIn) {
		UsedIn = usedIn;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getBatteryModels() {
		return BatteryModels;
	}

	public void setBatteryModels(String batteryModels) {
		BatteryModels = batteryModels;
	}

	public String getChem() {
		return Chem;
	}

	public void setChem(String chem) {
		Chem = chem;
	}

	public String getVolts() {
		return Volts;
	}

	public void setVolts(String volts) {
		Volts = volts;
	}

	public String getmAh() {
		return mAh;
	}

	public void setmAh(String mAh) {
		this.mAh = mAh;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getPriceCode() {
		return PriceCode;
	}

	public void setPriceCode(String priceCode) {
		PriceCode = priceCode;
	}
	
	
	
	
}
