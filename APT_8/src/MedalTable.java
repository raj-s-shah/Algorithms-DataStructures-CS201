import java.lang.reflect.Array;
import java.util.*;

public class MedalTable {

    public String[] generate(String[] results) {
        HashMap<String, MedalCountry> map = new HashMap<>();
        for (String s : results) {
            String[] data = s.split(" ");
            int index = 0;
            for (String c : data) {
                if (!map.containsKey(c)) {
                    map.put(c, new MedalCountry(c));
                }
                if (index == 0){
                    map.get(c).myGold += 1;
                }
                if (index == 1) {
                    map.get(c).mySilver += 1;
                }
                if (index == 2) {
                    map.get(c).myBronze += 1;
                }
                index++;
            }
        }
        ArrayList<MedalCountry> list = new ArrayList<>(map.values());

        Comparator<MedalCountry> gold = Comparator.comparing(MedalCountry::getMyGold).reversed();
        Comparator<MedalCountry> silver = Comparator.comparing(MedalCountry::getMySilver).reversed();
        Comparator<MedalCountry> bronze = Comparator.comparing(MedalCountry::getMyBronze).reversed();
        Comparator<MedalCountry> name = Comparator.comparing(MedalCountry::getMyCountryName);

        Comparator<MedalCountry> comp = gold.thenComparing(silver).thenComparing(bronze).thenComparing(name);
        Collections.sort(list, comp);

        ArrayList<String> ret = new ArrayList<>();

        for (MedalCountry c : list) {
            ret.add(c.toString());
        }
        return ret.toArray(new String[0]);
    }
}

class MedalCountry {
    String myCountryName;
    int myGold;
    int mySilver;
    int myBronze;

    MedalCountry(String name) {
        myCountryName= name;
    }
    public int getMyGold() {
        return myGold;
    }
    public int getMySilver() {
        return mySilver;
    }
    public int getMyBronze() {
        return myBronze;
    }

    public String getMyCountryName() { return myCountryName; }

    @Override
    public String toString(){
        return String.format("%s %d %d %d", myCountryName, myGold, mySilver, myBronze);
    }
}