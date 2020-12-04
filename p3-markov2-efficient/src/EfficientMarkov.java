import java.util.*;

public class EfficientMarkov extends BaseMarkov {
	private Map<String,ArrayList<String>> myMap;
	
	public EfficientMarkov(){
		this(3);
	}

	public EfficientMarkov(int order) {
		super(order);
		myMap = new HashMap<>();
	}

	@Override
	public void setTraining(String text) {
		super.setTraining(text);
		myMap.clear();

		for (int i = 0; i < myText.length() - myOrder + 1; i++) {
			String key = myText.substring(i, i + myOrder);

			if (! myMap.containsKey(key)){
				myMap.put(key, new ArrayList<String>());
			}

			String value;
			if (i == myText.length() - myOrder){
				value = PSEUDO_EOS;
			}

			else {
				value = myText.substring(i + myOrder, i + myOrder + 1);
			}

			myMap.get(key).add(value);
			}
		}

	@Override
	public ArrayList<String> getFollows(String key) {
		if (!(myMap.keySet().contains(key))) {
			throw new NoSuchElementException(key + " not in map");
		}
		else{
			return myMap.get(key);
		}
	}
}	
