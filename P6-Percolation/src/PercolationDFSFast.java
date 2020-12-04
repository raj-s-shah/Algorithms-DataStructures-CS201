public class PercolationDFSFast extends PercolationDFS {

    public PercolationDFSFast(int n) {
        super(n);
    }

    private boolean checkAdjacent(int row, int col) {
        if (    inBounds(row + 1, col) && isFull(row + 1, col) ||
                inBounds(row - 1, col) && isFull(row - 1, col) ||
                inBounds(row, col + 1) && isFull(row, col + 1)  ||
                inBounds(row, col - 1) && isFull(row, col - 1)) {
            return true;
        }
        return false;
    }

    @Override
    protected void updateOnOpen(int row, int col){
        if (row == 0 || checkAdjacent(row, col)) {
            dfs(row, col);
        }
    }


}
