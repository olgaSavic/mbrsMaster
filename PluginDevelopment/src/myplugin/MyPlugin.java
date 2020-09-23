package myplugin;

import java.io.File;

import javax.swing.JOptionPane;

import myplugin.generator.options.GeneratorOptions;
import myplugin.generator.options.ProjectOptions;


import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;

/** MagicDraw plugin that performes code generation */
public class MyPlugin extends com.nomagic.magicdraw.plugins.Plugin {
	
	String pluginDir = null;
	
	public void init() {
		JOptionPane.showMessageDialog( null, "My Plugin initialization");
		
		pluginDir = getDescriptor().getPluginDirectory().getPath();
		
		// Creating submenu in the MagicDraw main menu 	
		ActionsConfiguratorsManager manager = ActionsConfiguratorsManager.getInstance();		
		manager.addMainMenuConfigurator(new MainMenuConfigurator(getSubmenuActions()));
		
		/** @Todo: load project options (@see myplugin.generator.options.ProjectOptions) from 
		 * ProjectOptions.xml and take ejb generator options */
		
		//for test purpose only:
		GeneratorOptions ejbOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "ejbclass", "templates", "{0}.java", true, "uns.ftn.mbrs.model");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("EJBGenerator", ejbOptions);
		ejbOptions.setTemplateDir(pluginDir + File.separator + ejbOptions.getTemplateDir()); //apsolutna putanja

		GeneratorOptions controllerOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "controller", "templates", "{0}Controller.java", true, "uns.ftn.mbrs.controller");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ControllerGenerator", controllerOptions);
		controllerOptions.setTemplateDir(pluginDir + File.separator + controllerOptions.getTemplateDir());

		GeneratorOptions serviceOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "service", "templates", "{0}Service.java", true, "uns.ftn.mbrs.service");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ServiceGenerator", serviceOptions);
		serviceOptions.setTemplateDir(pluginDir + File.separator + serviceOptions.getTemplateDir());

		GeneratorOptions serviceImplOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "serviceImpl", "templates", "{0}ServiceImpl.java", true, "uns.ftn.mbrs.service.impl");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ServiceImplGenerator", serviceImplOptions);
		serviceImplOptions.setTemplateDir(pluginDir + File.separator + serviceImplOptions.getTemplateDir());

		GeneratorOptions mainOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "main", "templates", "{0}.java", true, "uns.ftn.mbrs");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("MainGenerator", mainOptions);
		mainOptions.setTemplateDir(pluginDir + File.separator + mainOptions.getTemplateDir());

		GeneratorOptions repositoryOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "repository", "templates", "{0}Repository.java", true, "uns.ftn.mbrs.repository");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("RepoGenerator", repositoryOptions);
		repositoryOptions.setTemplateDir(pluginDir + File.separator + repositoryOptions.getTemplateDir());

		GeneratorOptions pomOptions = new GeneratorOptions("c:/temp/mbrs", "pom", "templates", "pom.xml", true, "");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("PomGenerator", pomOptions);
		pomOptions.setTemplateDir(pluginDir + File.separator + pomOptions.getTemplateDir());

		GeneratorOptions appPropOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "applicationproperties", "templates", "application.properties.xml", true, "");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("AppPropertiesGenerator", appPropOptions);
		appPropOptions.setTemplateDir(pluginDir + File.separator + appPropOptions.getTemplateDir());

		// FRONT-END
		GeneratorOptions formOptions = new GeneratorOptions("c:/temp/mbrs/src/main/webapp/WEB-INF/jsp", "jsp_form", "templates", "{0}.jsp", true, "");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("FormGenerator", formOptions);
		formOptions.setTemplateDir(pluginDir + File.separator + formOptions.getTemplateDir());

		GeneratorOptions listOptions = new GeneratorOptions("c:/temp/mbrs/src/main/webapp/WEB-INF/jsp", "jsp_list", "templates", "{0}.jsp", true, "");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ListGenerator", listOptions);
		listOptions.setTemplateDir(pluginDir + File.separator + listOptions.getTemplateDir());

		GeneratorOptions navigationOptions = new GeneratorOptions("c:/temp/mbrs/src/main/webapp/WEB-INF/jsp", "jsp_navigation", "templates", "{0}.jsp", true, "");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("NavigationGenerator", navigationOptions);
		navigationOptions.setTemplateDir(pluginDir + File.separator + navigationOptions.getTemplateDir());

		GeneratorOptions detailsOptions = new GeneratorOptions("c:/temp/mbrs/src/main/webapp/WEB-INF/jsp", "jsp_details_page", "templates", "{0}.jsp", true, "");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("DetailsGenerator", detailsOptions);
		detailsOptions.setTemplateDir(pluginDir + File.separator + detailsOptions.getTemplateDir());
	}

	private NMAction[] getSubmenuActions()
	{
	   return new NMAction[]{
			new GenerateAction("Generate code"),
	   };
	}
	
	public boolean close() {
		return true;
	}
	
	public boolean isSupported() {				
		return true;
	}
}


