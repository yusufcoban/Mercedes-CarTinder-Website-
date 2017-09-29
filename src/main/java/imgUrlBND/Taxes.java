package imgUrlBND;

public class Taxes{
	  private String id; 
	  private double amount; 
	  private double baseAmount; 
	  private double charge; 
	  private double rate; 

	  public String getId(){
	  	return id; 
	  }
	  public void setId(String input){
	  	 this.id = input;
	  }
	  public double getAmount(){
	  	return amount; 
	  }
	  public void setAmount(double input){
	  	 this.amount = input;
	  }
	  public double getBaseAmount(){
	  	return baseAmount; 
	  }
	  public void setBaseAmount(double input){
	  	 this.baseAmount = input;
	  }
	  public double getCharge(){
	  	return charge; 
	  }
	  public void setCharge(double input){
	  	 this.charge = input;
	  }
	  public double getRate(){
	  	return rate; 
	  }
	  public void setRate(double input){
	  	 this.rate = input;
	  }
}
