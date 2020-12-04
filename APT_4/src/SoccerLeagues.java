/*
    Each team plays (match.length -1) *2
    Home games represented cleanly
        Have to decipher away games
        if team 0 has W, other team has L
        if team 0 has D, other team has D
        if team 0 has L, other team has W

    Create ArrayLists of Arrays[(match.length -1) *2





 */



public class SoccerLeagues {
    public int[] points(String[] matches) {
        int[] ret = new int[(matches.length)];
            for (int k = 0; k < matches.length; k++) {
                String[] score = matches[k].split("");
                int index = 0;
                for (String t : score) {
                    if (t.equals("W")) {
                        ret[k] = ret[k] + 3;
                        ret[index] = ret[index] + 0;
                    }
                    if (t.equals("D")) {
                        ret[k] = ret[k] + 1;
                        ret[index] = ret[index] + 1;
                    }
                    if (t.equals("L")) {
                        ret[k] = ret[k] + 0;
                        ret[index] = ret[index] + 3;
                    }
                    index = index + 1;
                }
        }
        return ret;
    }
}