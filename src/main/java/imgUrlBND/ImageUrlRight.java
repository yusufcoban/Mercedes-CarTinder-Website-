package imgUrlBND;

import java.util.List;

public class ImageUrlRight{
	  private String configurationId; 
	  private String vehicleId; 
	  private InitialPrice initialPrice; 
	  private ConfigurationPrice configurationPrice; 
	  private String modelYear; 
	  private List<VehicleComponents> vehicleComponents; 
	  private Links links; 
	  private StageInformation stageInformation; 

	  public String getConfigurationId(){
	  	return configurationId; 
	  }
	  public void setConfigurationId(String input){
	  	 this.configurationId = input;
	  }
	  public String getVehicleId(){
	  	return vehicleId; 
	  }
	  public void setVehicleId(String input){
	  	 this.vehicleId = input;
	  }
	  public InitialPrice getInitialPrice(){
	  	return initialPrice; 
	  }
	  public void setInitialPrice(InitialPrice input){
	  	 this.initialPrice = input;
	  }
	  public ConfigurationPrice getConfigurationPrice(){
	  	return configurationPrice; 
	  }
	  public void setConfigurationPrice(ConfigurationPrice input){
	  	 this.configurationPrice = input;
	  }
	  public String getModelYear(){
	  	return modelYear; 
	  }
	  public void setModelYear(String input){
	  	 this.modelYear = input;
	  }
	  public List<VehicleComponents> getVehicleComponents(){
	  	return vehicleComponents; 
	  }
	  public void setVehicleComponents(List<VehicleComponents> input){
	  	 this.vehicleComponents = input;
	  }
	  public Links getLinks(){
	  	return links; 
	  }
	  public void setLinks(Links input){
	  	 this.links = input;
	  }
	  public StageInformation getStageInformation(){
	  	return stageInformation; 
	  }
	  public void setStageInformation(StageInformation input){
	  	 this.stageInformation = input;
	  }
}