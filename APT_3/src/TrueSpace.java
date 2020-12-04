public class TrueSpace {
    public long calculateSpace(int[] sizes, int clusterSize) {
        long total = 0;
        for (int k = 0; k < sizes.length; k++) {
            if (sizes[k] != 0 && sizes[k] % clusterSize != 0) {
                int multiplier = (sizes[k] / clusterSize);
                multiplier = ((multiplier + 1) * clusterSize);
                total = total + multiplier;}
            else if (sizes[k] != 0 && sizes[k] % clusterSize == 0) {
                int multiplier = (sizes[k] / clusterSize);
                multiplier = ((multiplier) * clusterSize);
                total = total + multiplier;
            }

        }
        return total;
    }
}
