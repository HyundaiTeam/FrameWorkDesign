package com.FrameWorkDesign.Listerners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.IConfigurationAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer {

	public void transform(IConfigurationAnnotation annotation, Class testClass, Constructor testConstructor,
			Method testMethod) {

	}

}
