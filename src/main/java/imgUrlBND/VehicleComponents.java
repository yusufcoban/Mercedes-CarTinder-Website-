package imgUrlBND;

public class VehicleComponents{
	  private String id; 
	  private String name; 
	  private String code; 
	  private String codeType; 
	  private String componentType; 
	  private PriceInformation priceInformation; 
	  private boolean standard; 
	  private boolean selected; 
	  private boolean fixed; 
	  private boolean hidden; 
	  private boolean pseudoCode; 

	  public String getId(){
	  	return id; 
	  }
	  public void setId(String input){
	  	 this.id = input;
	  }
	  public String getName(){
	  	return name; 
	  }
	  public void setName(String input){
	  	 this.name = input;
	  }
	  public String getCode(){
	  	return code; 
	  }
	  public void setCode(String input){
	  	 this.code = input;
	  }
	  public String getCodeType(){
	  	return codeType; 
	  }
	  public void setCodeType(String input){
	  	 this.codeType = input;
	  }
	  public String getComponentType(){
	  	return componentType; 
	  }
	  public void setComponentType(String input){
	  	 this.componentType = input;
	  }
	  public PriceInformation getPriceInformation(){
	  	return priceInformation; 
	  }
	  public void setPriceInformation(PriceInformation input){
	  	 this.priceInformation = input;
	  }
	  public boolean getStandard(){
	  	return standard; 
	  }
	  public void setStandard(boolean input){
	  	 this.standard = input;
	  }
	  public boolean getSelected(){
	  	return selected; 
	  }
	  public void setSelected(boolean input){
	  	 this.selected = input;
	  }
	  public boolean getFixed(){
	  	return fixed; 
	  }
	  public void setFixed(boolean input){
	  	 this.fixed = input;
	  }
	  public boolean getHidden(){
	  	return hidden; 
	  }
	  public void setHidden(boolean input){
	  	 this.hidden = input;
	  }
	  public boolean getPseudoCode(){
	  	return pseudoCode; 
	  }
	  public void setPseudoCode(boolean input){
	  	 this.pseudoCode = input;
	  }
}