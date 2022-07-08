
public class LetterInventory {
	//a class constant to standardize the size of the counting lists
   private final int arraysize = 26;
	//the private fields of the class
	private boolean isEmpty;
	private int[] counts = new int[arraysize];
	private char[] letters = new char[arraysize];
	private int size = 0;
	
	//instantiates the fields and fills the letter array
	public LetterInventory(String s) {
		for (int i = 0; i < 26; i++) {
			letters[i] = (char)(i + 'a');
		}
		s = s.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < letters.length; j++) {
				if (s.charAt(i)==letters[j]) {
					counts[j]++;
               size ++;
					isEmpty = false;
				}
			}
		}
	}
	
	//void constructor to allow for use within the class
	private LetterInventory() {
	}
	
	//returns the number of instances a letter appears in the inventory
   //first checks to see if the letter is a valid letter
	public int get(char letter) {
	   for (int i = 0; i < letters.length; i++){
         if(letter == letters[i]){
	        return counts[Math.abs(letter - 'a')];
         } 
		} 
      throw new IllegalArgumentException();   
	}
	
	//allows the client to set a certain value to a letter in the inventory
	public void set(char letter, int value) {
		if (value < 0 || value > 25) {
			throw new IllegalArgumentException();
		}
		int index = letter-'a';
		size -= counts[index];
		counts[index] = value;
		size += value;
      if (size == 0){
         isEmpty = true;
      }
	}
	
	//returns the size of the inventory
	public int size() {
		return size;
	}
	
	//returns the boolean isEmpty: states whether the inventory has any values
	public boolean isEmpty() {
		return isEmpty;
	}
	
	//adds two inventories together
	public LetterInventory add(LetterInventory other) {
		LetterInventory added = new LetterInventory();
		for (int i = 0; i < this.letters.length; i++) {
			added.counts[i] = this.counts[i] + other.counts[i];
			added.size += added.counts[i];
		}
		added.isEmpty = false;
		return added;
	}
	
   //subtracts an inventory from another
   public LetterInventory subtract(LetterInventory other){
      LetterInventory subbed = new LetterInventory();
      for (int i = 0; i < this.letters.length; i++) {
			subbed.counts[i] = this.counts[i] - other.counts[i];
         //ensures that there will not be any negative counts
         if (subbed.counts[i] < 0) {
             return null;
         }
			subbed.size += subbed.counts[i];
		}
		if (subbed.size == 0){
         subbed.isEmpty = true;
      }
		return subbed; 
   }
   
	// creating a string representing the letters in the inventory
	public String toString(){
		String s = "[";
		for (int i = 0; i < counts.length; i++) {
			for (int j = 0; j < counts[i]; j++) {
				s += (char)('a'+ i);
			}
		}
      s +="]";
		return s;
	}
	
	
}