import java.util.Hashtable;

class Solution {

	public int romanToInt(String roman) {
		int num=0;
		Hashtable<String,Integer> h = new Hashtable<String,Integer>(); // basic dictionary for numbers and letters
		h.put("I",1);
		h.put("V", 5);
		h.put("L", 50);
		h.put("X", 10);
		h.put("C", 100);
		h.put("D", 500);
		h.put("M", 1000);

		for(int i =0; i<roman.length();i++){
			String romanNum = "";  // char to String
			romanNum += roman.charAt(i);// char to String
			String romanNumAfter ="";// char to String
			num += h.get(romanNum); // adding the numbers 
			if(i!=roman.length()-1) { // to avoid IndexOutOfBoundsException
				romanNumAfter +=roman.charAt(i+1);// char to String
				/*
        	 if a letter comes to before another bigger letter it means first one makes smaller our number.
        	 For example;
        	 C<M (100<1000) CM=M-C ---> 1000-100 = 900
        	 I<V (1<5) IV = V-I----> 5-1=4
				 */
				if(h.get(romanNum)<h.get(romanNumAfter) ) { 
					num -= 2*h.get(romanNum); // the reason of two times is we added this minus number as a positive number first time means deleting number second time means we reduce the number
				}}
		}


		return num;}
}