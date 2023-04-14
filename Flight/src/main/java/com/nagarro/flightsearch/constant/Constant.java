/**
 * 
 */
package com.nagarro.flightsearch.constant;

/**
 * @author kritikasingh02
 *
 */
public class Constant {
	
	public static final String ECONOMY = "Economy";
	public static final String BUSINESS = "Business";
	public static final String ORDER_CANCEL = "order cancel";
	public static final String ORDER_SUCCESSFUL = "order successful";
	public static final String ORDER_PROCESSING = "order processing";
	public static final String ORDER_FAIL = "order fail";
	public static final String PAYMENT_SUCCESSFUL = "payment successful";
	public static final String PAYMENT_CANCEL = "payment cancel";
	public static final String PAYMENT_FAIL = "payment fail";
	public static final String ONE_WAY = "ONE WAY TRIP";
	public static final String TWO_WAY = "TWO WAY TRIP";

	//for local machine
	public static final String PAYMENT_URL = "http://localhost:9999/payment/";

	//for docker 
	//public static final String PAYMENT_URL = "http://gateway:9999/payment/";

}
