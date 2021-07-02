package file_compressor_decompressor;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
	
	private String inputString;
	private Map<Character, Integer> charCount;
	private Map<Character, String> charToCode;
	private Map<String, Character> codeToChar;
	private PriorityQueue<HNode> pq;
	private HNode root;
	
	//constructor
    public HuffmanTree(String inputString) {
		
		this.inputString= inputString;
		
		//initilizations
		charCount= new HashMap<Character, Integer>();
		charToCode= new HashMap<Character, String>();
		codeToChar= new HashMap<String, Character>();
		pq= new PriorityQueue<HNode>(1, (node1, node2)-> node1.weight - node2.weight);
		 
		 countFrequency(); // 1 step count frequency
		 root= buildTree();// 2 step create tree
		 
		 System.out.println("============Generating the code for each character=============");
		 if(isLeaf(root)) {
			 
			 root.code= "1";
		 }
		 else {
			 createCode(root, "");
		 }
		 
		
		
	}

	private void createCode(HNode root, String code) {
		
		if(isLeaf(root)) {
			root.code=code;
			
			//used in encoding
			charToCode.put(root.ch, root.code);
			
			//used in decoding
			codeToChar.put(root.code, root.ch);
		}
		else {
			createCode(root.left, code+"1");
			createCode(root.right, code+"0");	
		}
	}

	private boolean isLeaf(HNode root) {
		
		return root.left==null && root.right==null;
	}

	private HNode buildTree() {
		
		System.out.println("============Building the huffman Tree============");
		
		//building minheap
		charCount.forEach((k, v)->{
			pq.offer(new HNode(v, k));
		});
		
		while(pq.size() > 1) {
			HNode left= pq.poll();
			HNode right= pq.poll();
			
			HNode node= new HNode(left.weight + right.weight, '$');
			node.left= left;
			node.right= right;
			pq.offer(node);
			
		}
		
		System.out.println("============Huffman tree created============");
		
		return pq.poll();
		
	}

	private void countFrequency() {
		System.out.println("============counting the frequency of each character============");
		for(char ch : inputString.toCharArray()) {
			charCount.put(ch, charCount.getOrDefault(ch, 0)+1);
		}
		
		charCount.forEach((k, v)->{
			System.out.println(k + " occurs "+ v + " times");
		});
		
	}

	public Map<Character, String> getCharToCode() {
		return charToCode;
	}

	public Map<String, Character> getCodeToChar() {
		return codeToChar;
	}	
	
	public Map<Character, Integer> charCount() {
		return charCount;
	}	
	

}
