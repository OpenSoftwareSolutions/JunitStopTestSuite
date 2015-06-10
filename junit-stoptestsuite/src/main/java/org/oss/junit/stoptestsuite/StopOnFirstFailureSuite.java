/*******************************************************************************
 * Copyright (c) 2015 Open Software Solutions GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0
 * which accompanies this distribution, and is available at
 *
 * Contributors:
 *     Open Software Solutions GmbH
 ******************************************************************************/

package org.oss.junit.stoptestsuite;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;

/**
 * The class StopOnFirstFailureSuite is only used if a certain test must succeed before another step in a test cascade can follow.
 * Normally setup steps and initializations of tests must succeed and they can then be wrapped in StopOnFirstFailureSuite.
 *
* @author Magnus Karlsson
*
*/
public class StopOnFirstFailureSuite extends Suite {

	/**
	 *
	 * @param delegateClass, any test class
	 * @param delegateSuiteClasses, any testsuite class
	 * @throws InitializationError
	 */
	public StopOnFirstFailureSuite(Class<?> delegateClass, Class<?>[] delegateSuiteClasses) throws InitializationError {
	        super(delegateClass, delegateSuiteClasses);
	}

	/**
	 * @param delegateClass, any test class
	 * @throws InitializationError
	 */
	public StopOnFirstFailureSuite(Class<?> delegateClass) throws InitializationError {
	        super(delegateClass, delegateClass.getAnnotation(SuiteClasses.class).value());
	}


	/*
	 * (non-Javadoc)
	 * @see org.junit.runners.ParentRunner#run(org.junit.runner.notification.RunNotifier)
	 */
	@Override
	public void run(RunNotifier runNotifier) {
	        runNotifier.addListener(new FailFastListener(runNotifier));
	        super.run(runNotifier);
	}

}
