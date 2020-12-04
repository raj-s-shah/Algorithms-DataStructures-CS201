
/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author Raj Shah
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		for (int k = 0; k < myWords.length; k++) {
			myWords[k] = source[start + k];
		}
		myToString = "";
		myHash = 0;

		// TODO: initialize all instance variable XXX
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return
	 */
	public int length(){
		// TODO: change this xxx
		return myWords.length;
	}


	/**
	 * Complete appropriate comment here
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof WordGram) || o == null){
			return false;
		}

		// TODO: Complete this method
		WordGram wg = (WordGram) o;
		if (wg.length() != this.length()){
			return false;
		}
		else {
		for(int k = 0; k < wg.length(); k++) {
			if (!(this.wordAt(k).equals(wg.wordAt(k)))){
				return false;
				}
			}
		}

		return true;
	}

	@Override
	public int hashCode(){
		// TODO: complete this method: assign to myHash as needed xxx
		if(myHash == 0) {
			String dummy = this.toString();
			myHash = dummy.hashCode();
		}
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		// TODO: Complete this method
		for (int k = 0; k < wg.length(); k++){
			if (k == wg.length() - 1){
				wg.myWords[k] = last;
			}
			else {
				wg.myWords[k] = wg.wordAt(k + 1);
			}
		}
		return wg;
	}

	@Override
	public String toString(){
		// TODO: Complete this method, assign to myToString as needed xxx
		if(myToString.length() == 0){
			myToString = String.join(" ", myWords);
		}
		return myToString;
	}
}
