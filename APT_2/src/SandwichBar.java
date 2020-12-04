public class SandwichBar {
    public int whichOrder(String[] available, String[] orders) {
        /*
           For loop over each element in 'orders'
            split eleemnt into array 'food'
            while loop until you have found the order

         */

        for (int k = 0; k < orders.length; k++) {
            if (orderAvailable(orders[k], available)) {
                return k;
            }
        }
        return -1;
    }

    public boolean orderAvailable(String k, String[] available) {
        String[] foods = k.split(" ");
        int count = 0;
        for(int i=0; i < foods.length; i++) {
                for (int a = 0; a < available.length; a++) {
                    if (available[a].equals(foods[i])) {
                        count = count + 1;
                        break;
                    }
                }
            }
        if (count == foods.length) {
            return true;
        }
        else {
            return false;
        }
        }

    }
