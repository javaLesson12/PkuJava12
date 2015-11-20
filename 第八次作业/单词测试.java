import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;


public class ProcessWords {
	public static void main(String[] args) {		
		//读取文件1单词
		Map<String,Integer> map1 = readWordsFromFile("words1.txt");
		//读取文件2单词
		Map<String,Integer> map2 = readWordsFromFile("words2.txt");
		
		//输出文件1中不重复的单词
		System.out.println("文件1中的不重复单词：");
		for(Map.Entry<String,Integer> entry:map1.entrySet()){
			if(entry.getValue().intValue()<2){
				System.out.println(entry.getKey());
			}
		}
		
		//输出文件2中不重复的单词
		System.out.println("文件2中的不重复单词：");
		for(Map.Entry<String,Integer> entry:map2.entrySet()){
			if(entry.getValue().intValue()<2){
				System.out.println(entry.getKey());
			}
		}
		
		//输出同时出现在两个文件中的单词
		System.out.println("同时出现在两个文件中的单词：");
		for(Map.Entry<String,Integer> entry:map1.entrySet()){
			if(map2.containsKey(entry.getKey())){
				System.out.println(entry.getKey());
			}
		}
		
		//进行单词的统计
		int wordCount=0;	//统计文件中的单词个数
		int dupWordCount=0;	//统计文件中的重复单词个数
		double dupPercent=0; //统计重复单词个数在文件中所占的百分比
		
		wordCount=map1.size();
		for(Map.Entry<String,Integer> entry:map1.entrySet()){
			if(entry.getValue().intValue()>1){
				dupWordCount++;
			}
		}
		
		//保留3位小数
		java.text.DecimalFormat df=new java.text.DecimalFormat("##.###"); 
		dupPercent = dupWordCount*1.0/wordCount;
		System.out.println("文件1单词个数："+String.valueOf(wordCount)+",重复单词个数："+String.valueOf(dupWordCount)+",重复单词占总数的百分比："+String.valueOf(df.format(dupPercent))+"%");
		
		
		wordCount=map2.size();
		dupWordCount=0;
		for(Map.Entry<String,Integer> entry:map2.entrySet()){
			if(entry.getValue().intValue()>1){
				dupWordCount++;
			}
		}
		dupPercent = dupWordCount*1.0/wordCount;
		System.out.println("文件2单词个数："+String.valueOf(wordCount)+",重复单词个数："+String.valueOf(dupWordCount)+",重复单词占总数的百分比："+String.valueOf(df.format(dupPercent))+"%");
	}
	
	//读取文件中的单词，并放置到HashMap<String,Integer>
	public static Map<String,Integer> readWordsFromFile(String filePath){
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		try{
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			String s;
			while((s=br.readLine())!=null){
				String[] words = s.split(" ");
				for(int i=0;i<words.length;i++){
					String tmp = words[i].trim();
					if(tmp==""){
						break;
					}
					if(map.containsKey(tmp)){
						map.put(tmp, new Integer(map.get(tmp).intValue()+1));
					}else{
						map.put(tmp, new Integer(1));
					}
				}
			}
		}catch(Exception e){
			return null;
		}
		
		return map;
	}

}