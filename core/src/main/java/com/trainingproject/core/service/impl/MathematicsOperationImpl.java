package com.trainingproject.core.service.impl;

import org.osgi.service.component.annotations.Component;

import com.trainingproject.core.service.MathematicsOperation;

@Component(service = MathematicsOperation.class, immediate = true)
public class MathematicsOperationImpl implements MathematicsOperation {
    @Override
    public int additionsOperation(int a, int b) {
        return a+b;
    }

    @Override
    public int multiplicationOperation(int a, int b) {
        return a*b;
    }
}
