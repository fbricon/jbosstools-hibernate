package org.jboss.tools.hibernate.runtime.v_5_4.internal.util;

import org.hibernate.dialect.Dialect;

public class MockDialect extends Dialect {

	public int getVersion() {
		return 0;
	}
	
}
