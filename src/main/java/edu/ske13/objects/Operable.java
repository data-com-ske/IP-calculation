package edu.ske13.objects;

import edu.ske13.constants.Base;

/**
 * @author kamontat
 * @version 1.0
 * @since Sun 05/Nov/2017 - 21:24
 */
public interface Operable<T> {
	/**
	 * <b>and</b> operation
	 *
	 * @param t
	 * 		second object
	 * @return new object
	 */
	T and(T t);
	
	/**
	 * <b>or</b> operation
	 *
	 * @param t
	 * 		second object
	 * @return new object
	 */
	T or(T t);
	
	/**
	 * <b>xor</b> operation
	 *
	 * @param t
	 * 		second object
	 * @return new object
	 */
	T xor(T t);
	
	/**
	 * <b>not</b> operation
	 *
	 * @return new object
	 */
	T not();
	
	/**
	 * <b>left shift</b> operation
	 *
	 * @param t
	 * 		second object
	 * @return new object
	 */
	T leftShift(T t);
	
	/**
	 * <b>logical right shift</b> operation
	 *
	 * @param t
	 * 		second object
	 * @return new object
	 */
	T logicalRightShift(T t);
	
	/**
	 * <b>arithmetic right shift</b> operation
	 *
	 * @param t
	 * 		second object
	 * @return new object
	 */
	T arithmeticRightShift(T t);
	
	/**
	 * <b>add</b> operation
	 *
	 * @param t
	 * 		second object
	 * @return new object
	 */
	T add(T t);
	
	/**
	 * <b>minus</b> operation
	 *
	 * @param t
	 * 		second object
	 * @return new object
	 */
	T minus(T t);
	
	/**
	 * <b>and</b> operation
	 *
	 * @param t
	 * 		second object
	 * @param b
	 * 		return base
	 * @return new object
	 */
	T and(T t, Base b);
	
	/**
	 * <b>or</b> operation
	 *
	 * @param t
	 * 		second object
	 * @param b
	 * 		return base
	 * @return new object
	 */
	T or(T t, Base b);
	
	/**
	 * <b>xor</b> operation
	 *
	 * @param t
	 * 		second object
	 * @param b
	 * 		return base
	 * @return new object
	 */
	T xor(T t, Base b);
	
	/**
	 * <b>not</b> operation
	 *
	 * @param b
	 * 		return base
	 * @return new object
	 */
	T not(Base b);
	
	/**
	 * <b>left shift</b> operation
	 *
	 * @param t
	 * 		second object
	 * @param b
	 * 		return base
	 * @return new object
	 */
	T leftShift(T t, Base b);
	
	/**
	 * <b>logical right shift</b> operation
	 *
	 * @param t
	 * 		second object
	 * @param b
	 * 		return base
	 * @return new object
	 */
	T logicalRightShift(T t, Base b);
	
	/**
	 * <b>arithmetic right shift</b> operation
	 *
	 * @param t
	 * 		second object
	 * @param b
	 * 		return base
	 * @return new object
	 */
	T arithmeticRightShift(T t, Base b);
	
	/**
	 * <b>add</b> operation
	 *
	 * @param t
	 * 		second object
	 * @param b
	 * 		return base
	 * @return new object
	 */
	T add(T t, Base b);
	
	/**
	 * <b>minus</b> operation
	 *
	 * @param t
	 * 		second object
	 * @param b
	 * 		return base
	 * @return new object
	 */
	T minus(T t, Base b);
}
