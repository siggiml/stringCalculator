package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",") || text.contains("\n")){
			return filterNegative(splitNumbers(text));
		}
		else
			return toInt(text);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    numbers = numbers.replaceAll("\n" , ",");

	    return numbers.split(",");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
 	    int intNum = 0;
        for(String number : numbers){
        	intNum = toInt(number);
        	if(intNum <= 1000)
		    	total += intNum;
		}
		return total;
    }

    private static int filterNegative(String[] numbers){
 	   String negs = "";
 	   for(String s: numbers) 
 	   {
 	   		if(toInt(s) < 0)
 	   			{
 	   				negs = negs + s + ",";
 	   			}
 	   }

 	   if(negs != "")
 	   {
 	   		throw new IllegalArgumentException("Negatives not allowed: " + negs.substring(0, negs.length()-1));	
 	   }
 	   else
 	   {
 	   		return sum(numbers); 
 	   }
    }


}