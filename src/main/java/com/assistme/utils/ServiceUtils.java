package com.assistme.utils;

public class ServiceUtils {
	
	public static boolean isNull(String s) {
		if ((s == null) || s.equalsIgnoreCase("null") || s.trim().length() == 0)
			return true;
		else
			return false;
	}

}
