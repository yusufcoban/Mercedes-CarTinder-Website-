package imgUrlBND;

import java.util.List;

public class ConfigurationPrice{
	  private double price; 
	  private double netPrice; 
	  private String currency; 
	  private List<Taxes> taxes; 

	  public double getPrice(){
	  	return price; 
	  }
	  public void setPrice(double input){
	  	 this.price = input;
	  }
	  public double getNetPrice(){
	  	return netPrice; 
	  }
	  public void setNetPrice(double input){
	  	 this.netPrice = input;
	  }
	  public String getCurrency(){
	  	return currency; 
	  }
	  public void setCurrency(String input){
	  	 this.currency = input;
	  }
	  public List<Taxes> getTaxes(){
	  	return taxes; 
	  }
	  public void setTaxes(List<Taxes> input){
	  	 this.taxes = input;
	  }
}