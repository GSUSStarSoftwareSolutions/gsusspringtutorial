package com.luv2code.aopdemoPntctDclrtns.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class LuvAopExpressions {
	
	@Pointcut("execution(* com.luv2code.aopdemoPntctDclrtns.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// create a pointcut for getter methods
	
	@Pointcut("execution(* com.luv2code.aopdemoPntctDclrtns.dao.*.get*(..))")
	public void getter() {}

	// create a pointcut for setter methods
	
	@Pointcut("execution(* com.luv2code.aopdemoPntctDclrtns.dao.*.set*(..))")
	public void setter() {}
	
	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}

}
