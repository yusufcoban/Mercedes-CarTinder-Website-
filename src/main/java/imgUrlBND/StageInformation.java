package imgUrlBND;

public class StageInformation{
	  private String templateUri; 
	  private String availablePerspectives; 
	  private String availableResolutions; 
	  private String availableMediaQualifiers; 

	  public String getTemplateUri(){
	  	return templateUri; 
	  }
	  public void setTemplateUri(String input){
	  	 this.templateUri = input;
	  }
	  public String getAvailablePerspectives(){
	  	return availablePerspectives; 
	  }
	  public void setAvailablePerspectives(String input){
	  	 this.availablePerspectives = input;
	  }
	  public String getAvailableResolutions(){
	  	return availableResolutions; 
	  }
	  public void setAvailableResolutions(String input){
	  	 this.availableResolutions = input;
	  }
	  public String getAvailableMediaQualifiers(){
	  	return availableMediaQualifiers; 
	  }
	  public void setAvailableMediaQualifiers(String input){
	  	 this.availableMediaQualifiers = input;
	  }
}