package org.jboss.tools.hibernate.orm.runtime.exp.internal;

import org.hibernate.cfg.Environment;
import org.jboss.tools.hibernate.runtime.common.AbstractEnvironmentFacade;
import org.jboss.tools.hibernate.runtime.common.IFacadeFactory;

public class EnvironmentFacadeImpl extends AbstractEnvironmentFacade {

	public EnvironmentFacadeImpl(
			IFacadeFactory facadeFactory) {
		super(facadeFactory, null);
	}

	@Override
	public String getTransactionManagerStrategy() {
		return Environment.TRANSACTION_COORDINATOR_STRATEGY;
	}

}
