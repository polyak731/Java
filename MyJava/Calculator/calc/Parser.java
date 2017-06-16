package calc;

import java.util.ArrayList;

public class Parser {
	
	private StringBuilder formule;
	
	public Parser(StringBuilder formule){
		this.formule = formule;
	}

	public String getFormule() {
		return formule.toString();
	}

	public void setFormule(String formule) {
		this.formule.delete(0, this.formule.length());
		this.formule.append(formule);
	}
	
	public String getResult(){
		String value = "";
		
		while(formule.lastIndexOf("(")!=-1){
			int start = formule.lastIndexOf("(")+1;
			int end = start + formule.substring(start).indexOf(")");
			
			System.out.println(formule);
			
			StringBuilder sub = new StringBuilder(formule.substring(start,end));
			formule.replace(start-1,end+1, calc(sub));
		}
		value = calc(formule);
		
		return value;
	}
	
	private String calc(StringBuilder formule){
		
		String value = "";
		
		ArrayList<Character> attrs = new ArrayList<>();
		ArrayList<String> nums = new ArrayList<>();
		StringBuilder number = new StringBuilder();
		
		for(int i=0;i<formule.length();i++){
			switch(formule.charAt(i)){
			case '+':
				attrs.add(formule.charAt(i));
				nums.add(number.toString());
				number.setLength(0);
				break;
			case '/':
				attrs.add(formule.charAt(i));
				nums.add(number.toString());
				number.setLength(0);
				break;
			case '*':
				attrs.add(formule.charAt(i));
				nums.add(number.toString());
				number.setLength(0);
				break;
			case '^':
				attrs.add(formule.charAt(i));
				nums.add(number.toString());
				number.setLength(0);
				break;
			case '-':
				if(i==0 || (formule.charAt(i-1) == '+' ||
				formule.charAt(i-1) == '-' ||
				formule.charAt(i-1) == '*' || 
				formule.charAt(i-1) == '/')){
					number.append(formule.charAt(i));
				}else{
					attrs.add(formule.charAt(i));
					nums.add(number.toString());
					number.setLength(0);
				}
				break;
			default:
				number.append(formule.charAt(i));
					break;
			}
			if(i==formule.length()-1){
				nums.add(number.toString());
				number.setLength(0);
			}
		}
		
		for(int i=attrs.size()-1;i>=0;i--){			
			if(attrs.get(i).compareTo('^') == 0){
				String val = String.valueOf(Math.pow(Double.parseDouble(nums.get(i)),Double.parseDouble(nums.get(i+1))));
				nums.set(i, val);
				nums.remove(i+1);
				attrs.remove(i);
			}
		}
		
		for(int i=attrs.size()-1;i>=0;i--){			
			if(attrs.get(i).compareTo('/') == 0){
				String val = String.valueOf(Double.parseDouble(nums.get(i)) / Double.parseDouble(nums.get(i+1)));
				nums.set(i, val);
				nums.remove(i+1);
				attrs.remove(i);
			}
		}
		
		for(int i=attrs.size()-1;i>=0;i--){			
			if(attrs.get(i).compareTo('*') == 0){
				String val = String.valueOf(Double.parseDouble(nums.get(i)) * Double.parseDouble(nums.get(i+1)));
				nums.set(i, val);
				nums.remove(i+1);
				attrs.remove(i);
			}
		}
		
		for(int i=attrs.size()-1;i>=0;i--){			
			if(attrs.get(i).compareTo('+') == 0){
				String val = String.valueOf(Double.parseDouble(nums.get(i)) + Double.parseDouble(nums.get(i+1)));
				nums.set(i, val);
				nums.remove(i+1);
				attrs.remove(i);
			}
		}
		
		for(int i=attrs.size()-1;i>=0;i--){			
			if(attrs.get(i).compareTo('-') == 0){
				String val = String.valueOf(Double.parseDouble(nums.get(i)) - Double.parseDouble(nums.get(i+1)));
				nums.set(i, val);
				nums.remove(i+1);
				attrs.remove(i);
			}
		}
		value = nums.get(0);
		return value;
	}
}
