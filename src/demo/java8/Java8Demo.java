package demo.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

interface Vehicle {
	static String producer() {
		return "N&F Vehicles";
	}
	
	default String getOverview() {
		return "ATV made by "+producer();
	}
}

class VehicleImp implements Vehicle {

	@Override
	public String getOverview() {
		return "Override method!";
	}
}

class MethodRef {
	String str;
	
	public MethodRef() {
		// TODO Auto-generated constructor stub
	}
	
	public MethodRef(String str) {
		this.str = str;
	}
	
	static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
		return pattern.matcher(str).matches();
	}
	
	boolean containNumber(String str) {
		Pattern pattern = Pattern.compile("(.)*(\\d)(.)*");
		return pattern.matcher(str).matches();
	}
}

public class Java8Demo {
	
	public static void main(String args[])
	{
		// Interface static method
		String producer = Vehicle.producer();
		System.out.println(producer);
		
		// Interface default method
		Vehicle vehicle = new VehicleImp();
		System.out.println(vehicle.getOverview());
		
		List<String> strList = new ArrayList<>();
		strList.add("test1");
		strList.add("test2");
		strList.add("test3");
		strList.add("574555");
		strList.add("a");
		
		// Reference to a Static Method
		boolean staticRef = strList.stream().anyMatch(MethodRef::isNumeric);
		System.out.println(staticRef);
		
		// Reference to an Instance Method
		MethodRef methodRef = new MethodRef();
		boolean instanceRef = strList.stream().allMatch(methodRef::containNumber);
		System.out.println(instanceRef);
		
		// Reference to an Instance Method of an Object of a Particular Type
		long emptyCnt = strList.stream().filter(String::isEmpty).count();
		System.out.println(emptyCnt);
		
		// Reference to a Constructor
		List<MethodRef> list = strList.stream().map(MethodRef::new).collect(Collectors.toList());
		for(MethodRef obj : list) {
			System.out.println(obj.str);
		}
		
		// Optional 
		Optional<String> strOpt = Optional.empty(); // return empty Optional
		String str = strOpt.orElse("Default");
		System.out.println("Optional String val : " + str);
		
		strOpt = Optional.of("Test"); // return non null Optional
		str = strOpt.orElse("Default");
		System.out.println("Optional String val : " + str);
		
		str = null;
		strOpt = Optional.ofNullable(str); // return specific value or empty Optional
		str = strOpt.orElse("Default");
		System.out.println("Optional String val : " + str);
	}
}
