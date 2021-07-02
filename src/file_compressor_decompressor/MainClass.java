package file_compressor_decompressor;

import java.io.File;

public class MainClass {

	public static void main(String[] args) {
		
		final String filePath= "src\\file_compressor_decompressor/files/input.txt";
		
		try {
			File inputFile= new File(filePath);
			
			Comp_and_Decomp hf= new HuffmanCompAndDecomp(inputFile);
			
			String encodedString = hf.encode();
			
			String decodedString = hf.decode(encodedString);
			
			System.out.println(decodedString);
			
			hf.conclusion();

		}
		catch(Exception e) {
			System.out.println("File not found");
		}
		

	}


}
