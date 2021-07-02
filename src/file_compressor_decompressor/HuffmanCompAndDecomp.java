package file_compressor_decompressor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class HuffmanCompAndDecomp implements Comp_and_Decomp {
	
	private HuffmanTree huffmanTree;
	private String inputString; 
	private Map<Character, String> charToCode;
	private Map<String, Character> codeToChar;
	private Map<Character, Integer> charCount;

	public HuffmanCompAndDecomp(File inputFile) {
		
		inputString= readFile(inputFile);
		huffmanTree = new HuffmanTree(inputString);
		
		charCount= huffmanTree.charCount();
		
		//this will use in encoding
		charToCode= huffmanTree.getCharToCode();
		
		//this will use in decoding
		codeToChar= huffmanTree.getCodeToChar();
	}
    
	private String readFile(File inputFile) {
		
	  System.out.println("============File is reading============"); 
		
		StringBuilder sb= new StringBuilder();
		try (BufferedReader in = new BufferedReader(new FileReader(inputFile))){
			String line = in.readLine();
			while (line != null){
				sb.append(line + "\n");
				line = in.readLine();
			}
		}
		catch (IOException e){
			System.out.println(e);
		}
		System.out.println("============File reading completed============");
		return sb.toString();
	}

	@Override
	public String encode() {
		
		
		System.out.println("============encoding file data============");
		
		StringBuilder sb= new StringBuilder();
		Character ch;
		for(int i=0; i<inputString.length(); i++){
			ch = inputString.charAt(i);
			sb.append(charToCode.get(ch));
		}
		
		System.out.println("============encoding is done============");
		
		return sb.toString();
	}

	@Override
	public String decode(String encodedString) {
		StringBuilder sb= new StringBuilder();
		
		System.out.println("============decoding the data============");
		
		codeToChar.forEach((k, v)->{
			sb.append(k + " = " + v+ "\n");
		});
		
		System.out.println("============decoding is done============");
		
		return sb.toString();
	}

	@Override
	public void conclusion() {
        
		Long totalChar= (long) 0;
		Long totalBit= (long) 0;
		
		for(Map.Entry<Character, Integer> entry : charCount.entrySet()) {
			totalChar += entry.getValue();
			totalBit += entry.getValue()*charToCode.get(entry.getKey()).length();
		}
		
		System.out.println("Total no of characters are =  " + totalChar);
		System.out.println("Total Bit should used if we send data normally = "+ totalChar*8);
		System.out.println("Total Bit should used if we send data by huffman encoding = "+ totalBit);
		
	}
    


}
