package com.zero.spring.annotaions.common.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;


public class AspectUtil {

	/**
	 * get class name
	 *
	 * @param point	端点
	 *
	 */
	public static String getClassName(ProceedingJoinPoint point) {
		return point.getTarget().getClass().getName().replaceAll("\\.", "_");
	}

	/**
	 * get method
	 *
	 * @param point	端点
	 *
	 * @throws NoSuchMethodException	异常
	 */
	public static Method getMethod(ProceedingJoinPoint point) throws NoSuchMethodException {
		Signature sig = point.getSignature();
		MethodSignature ms = (MethodSignature) sig;
		Object target = point.getTarget();
		return target.getClass().getMethod(ms.getName(), ms.getParameterTypes());
	}


}
