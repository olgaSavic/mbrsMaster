package myplugin.generator.fmmodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FMClass extends FMType {	
	
	private String visibility;
	

	//Class properties
	private List<FMProperty> FMProperties = new ArrayList<FMProperty>();
	
	//list of packages (for import declarations) 
	private List<String> importedPackages = new ArrayList<String>();

	private List<FMLinkedProperty> FMLinkedProperty = new ArrayList<>();


	/** @ToDo: add list of methods */
	
	
	public FMClass(String name, String classPackage, String visibility) {
		super(name, classPackage);		
		this.visibility = visibility;
	}

	public void addLinkedProperty (myplugin.generator.fmmodel.FMLinkedProperty property) {FMLinkedProperty.add(property);}

	public List<FMProperty> getFMProperties() {
		return FMProperties;
	}

	public void setFMProperties(List<FMProperty> FMProperties) {
		this.FMProperties = FMProperties;
	}

	public void setImportedPackages(List<String> importedPackages) {
		this.importedPackages = importedPackages;
	}

	public List<myplugin.generator.fmmodel.FMLinkedProperty> getFMLinkedProperty() {
		return FMLinkedProperty;
	}

	public void setFMLinkedProperty(List<myplugin.generator.fmmodel.FMLinkedProperty> FMLinkedProperty) {
		this.FMLinkedProperty = FMLinkedProperty;
	}

	public List<FMProperty> getProperties(){
		return FMProperties;
	}
	
	public Iterator<FMProperty> getPropertyIterator(){
		return FMProperties.iterator();
	}
	
	public void addProperty(FMProperty property){
		FMProperties.add(property);		
	}
	
	public int getPropertyCount(){
		return FMProperties.size();
	}
	
	public List<String> getImportedPackages(){
		return importedPackages;
	}

	public Iterator<String> getImportedIterator(){
		return importedPackages.iterator();
	}
	
	public void addImportedPackage(String importedPackage){
		importedPackages.add(importedPackage);		
	}
	
	public int getImportedCount(){
		return FMProperties.size();
	}
	
	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}	

	
	
}
