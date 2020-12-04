/*
Create char array and put message in it

Create map<Char, Char>
Create ret[message.length] string
var int scale = letter[0] - 97
Indexed loop over each char --> k is current:
        map.putIfAbsent(k, 97 + (letter[k] - scale)
        ret[k] = map.get(k)

 */


import java.util.HashMap;

public class Encryption {
    public String encrypt(String message){
        char[] letters = new char[message.length()];
        for (int k = 0;k < message.length(); k++){
            letters[k] = message.charAt(k);
        }

        char[] charArray = new char[message.length()];
        HashMap<Character, Character> map = new HashMap<>();
        char current = 'a';
        for (int k = 0; k < letters.length; k++){
            if (!(map.keySet().contains(letters[k]))){
                map.putIfAbsent(letters[k], current);
                current += 1;
            }
            charArray[k] = map.get(letters[k]);
        }
        String ret = new String(charArray);
        return ret;

    }
}