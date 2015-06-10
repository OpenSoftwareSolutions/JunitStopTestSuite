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


import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;

/**
* @author Magnus Karlsson
*
*/
public class FailFastListener extends RunListener {

	private RunNotifier delegate;

	/**
	 * Access to RunNotifier
	 */
	public FailFastListener(RunNotifier runNotifier) {
		super();
		this.delegate = runNotifier;
	}

	/*
	 * (non-Javadoc)
	 * @see org.junit.runner.notification.RunListener#testFailure(org.junit.runner.notification.Failure)
	 */
	@Override
	public void testFailure(Failure failure) throws Exception {
		this.delegate.pleaseStop();
	}
}