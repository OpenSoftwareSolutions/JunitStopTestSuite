/*******************************************************************************
 * Copyright (c) 2015 Open Software Solutions GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0
 * which accompanies this distribution, and is available at
 *
 * Contributors:
 *     Open Software Solutions GmbH
 ******************************************************************************/

package test.org.oss.junit.stoptestsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.oss.junit.stoptestsuite.StopOnFirstFailureSuite;

/**
 * @author Magnus Karlsson
 */
@RunWith(StopOnFirstFailureSuite.class)
@SuiteClasses({StopOnFirstFailureTest.class})
public class SimpleTestSuite {

}
