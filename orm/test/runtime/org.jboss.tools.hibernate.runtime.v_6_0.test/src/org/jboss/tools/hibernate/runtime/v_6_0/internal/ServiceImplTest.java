package org.jboss.tools.hibernate.runtime.v_6_0.internal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.Dialect;
import org.hibernate.tool.api.export.ExporterConstants;
import org.jboss.tools.hibernate.runtime.common.IFacade;
import org.jboss.tools.hibernate.runtime.spi.IConfiguration;
import org.jboss.tools.hibernate.runtime.spi.IHibernateMappingExporter;
import org.jboss.tools.hibernate.runtime.v_6_0.internal.util.JpaConfiguration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServiceImplTest {
	
	private ServiceImpl service = null;
	
	@Before
	public void before() {
		service = new ServiceImpl();
	}
	
	@Test
	public void testNewAnnotationConfiguration() {
		IConfiguration annotationConfiguration = service.newAnnotationConfiguration();
		assertNotNull(annotationConfiguration);
		assertTrue(((IFacade)annotationConfiguration).getTarget() instanceof Configuration);
	}

	@Test
	public void testNewJpaConfiguration() {
		IConfiguration jpaConfiguration = service.newJpaConfiguration(null, "test", null);
		assertNotNull(jpaConfiguration);
		Object target = ((IFacade)jpaConfiguration).getTarget();
		assertNotNull(target);
		assertTrue(target instanceof JpaConfiguration);
		assertEquals("test", ((JpaConfiguration)target).getPersistenceUnit());
		
	}
	
	@Test
	public void testNewDefaultConfiguration() {
		IConfiguration defaultConfiguration = service.newDefaultConfiguration();
		assertNotNull(defaultConfiguration);
		assertTrue(((IFacade)defaultConfiguration).getTarget() instanceof Configuration);
	}

	@Test
	public void testNewHibernateMappingExporter() {
		IConfiguration configuration = service.newDefaultConfiguration();
		configuration.setProperty("hibernate.dialect", TestDialect.class.getName());
		File file = new File("");
		IHibernateMappingExporter hibernateMappingExporter = 
				service.newHibernateMappingExporter(configuration, file);
		HibernateMappingExporterExtension hmee = 
				(HibernateMappingExporterExtension)((IFacade)hibernateMappingExporter).getTarget();
		Assert.assertSame(file, hmee.getProperties().get(ExporterConstants.OUTPUT_FILE_NAME));
		Assert.assertSame(
				((ConfigurationFacadeImpl)configuration).getMetadata(), 
				hmee.getMetadata());
	}
	
	public static class TestDialect extends Dialect {
		@Override public int getVersion() { return 0; }	
	}
	
}
