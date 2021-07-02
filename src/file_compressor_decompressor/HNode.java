package file_compressor_decompressor;

public class HNode {
     int weight;
     char ch;
     String code;
     
     HNode left, right;

	public HNode(int weight, char ch, HNode left, HNode right) {
		super();
		this.weight = weight;
		this.ch = ch;
		this.left = left;
		this.right = right;
	}
	
	public HNode(int weight, char ch) {
		super();
		this.weight = weight;
		this.ch = ch;
		this.left = null;
		this.right = null;
	}

	public char getCh() {
		return ch;
	}

	public void setCh(char ch) {
		this.ch = ch;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public HNode getLeft() {
		return left;
	}

	public void setLeft(HNode left) {
		this.left = left;
	}
     
     
     
}
