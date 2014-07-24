package org.hibernate.eclipse.console.test;

import java.util.Observable;
import java.util.Observer;

import junit.framework.TestCase;

import org.hibernate.console.ConsoleConfiguration;
import org.hibernate.console.ConsoleQueryParameter;
import org.hibernate.console.KnownConfigurations;
import org.hibernate.console.QueryInputModel;
import org.hibernate.eclipse.console.test.launchcfg.TestConsoleConfigurationPreferences;
import org.jboss.tools.hibernate.spi.IService;

public class QueryParametersTest extends TestCase {
	
	private ConsoleConfiguration consoleCfg;
	private IService service;

	protected void setUp() throws Exception {
		super.setUp();
		
		TestConsoleConfigurationPreferences cfgprefs = new TestConsoleConfigurationPreferences();
		consoleCfg = new ConsoleConfiguration(cfgprefs);
		KnownConfigurations.getInstance().addConfiguration(consoleCfg, true);
		service = consoleCfg.getHibernateExtension().getHibernateService();
	}
	
	protected void tearDown() throws Exception {
		KnownConfigurations.getInstance().removeAllConfigurations();
		consoleCfg = null;
	}

	public void testQueryParameter() {
		QueryInputModel model = new QueryInputModel(service);
		
		ConsoleQueryParameter[] cqps = model.getQueryParameters();
		assertNotNull(cqps);
		
		QueryInputModel qpmodel = model;
		assertNotNull(qpmodel);
		
		class TestObserver implements Observer {
			int cnt = 0;
			public void update(Observable o, Object arg) {
				cnt++;			
			}			
		};
		
		TestObserver testObserver = new TestObserver();
		qpmodel.addObserver(testObserver);
		ConsoleQueryParameter consoleQueryParameter = new ConsoleQueryParameter(service);
		qpmodel.addParameter(consoleQueryParameter);
		assertEquals(1,testObserver.cnt);
		
		qpmodel.removeParameter(consoleQueryParameter);
		assertEquals(2,testObserver.cnt);
	}
	
	public void testCreateUnique() {
		
		QueryInputModel model = new QueryInputModel(service);
		
		ConsoleQueryParameter parameter = model.createUniqueParameter("param"); //$NON-NLS-1$
		model.addParameter(parameter);
		
		assertFalse(model.createUniqueParameter("param").getName().equals(parameter.getName())); //$NON-NLS-1$
	}

}
