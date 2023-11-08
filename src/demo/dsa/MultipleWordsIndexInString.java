package demo.dsa;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MultipleWordsIndexInString {

	public static void main(String[] args) {
		String str = "Bhavik is in ahmedabad covid cases is on rise in ahmedabad Bhavik had taken vacinne Bhavik is safe and can come to ahmedabad office";
		
		String[] strs = str.split(" ");
		
		List<String> list = Arrays.stream(strs)
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.entrySet()
			.stream()
			.filter(entry -> entry.getValue()>1)
			.map(entry -> entry.getKey())
			.toList();
		System.out.println(list);
		
		for(String s : list) {
			int indexOf = -1;
			StringJoiner sj = new StringJoiner(",", "[", "]");
			while(str.indexOf(" "+s+" ", indexOf+1) != -1) {
				indexOf = str.indexOf(" "+s+" ", indexOf+1);
				sj.add(String.valueOf(indexOf));
			}
			System.out.println(s + " : " + sj.toString());
		}
	}
}
