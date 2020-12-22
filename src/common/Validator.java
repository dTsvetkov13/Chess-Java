package common;

public class Validator
{
	public static <T extends Comparable<T>> boolean isGreaterThan(T compareToValue, T actualValue)
	{
		return actualValue.compareTo(compareToValue) > 0;
	}
	
	public static <T extends Comparable<T>> boolean isLessThan(T compareToValue, T actualValue)
	{
		return actualValue.compareTo(compareToValue) < 0;
	}
	
	public static boolean isNull(Object obj)
	{
		return obj == null;
	}
	
	public static boolean isNullOrEmpty(String str)
	{
		return isNull(str) || str.isEmpty();
	}
}
