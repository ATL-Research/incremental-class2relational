/*******************************************************************************
 * Copyright (c) 2010-2015, Zoltan Ujhelyi, Gabor Szarnyas
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package se.liu.ida.sas.pelab.c2r;

import atl.research.AbstractDriver;

// Setup
public class ViatraIncrementalSolution extends AbstractDriver {
    public static void main(String[] args) throws Exception {
    	// SETUP
    	ViatraIncrementalSolution solution = new ViatraIncrementalSolution();

        solution.init();
        if (solution.isBatchMode()) {
            solution.applyChange();
            solution.applyTransformation();
        }
        else {
            solution.applyTransformation();
            solution.applyChange();
        }
        solution.saveTarget();
    } 

    @Override
    protected void applyTransformation() {
    	new IncrementalC2R_v2(getResourceSet(),getTarget());
    }
}
