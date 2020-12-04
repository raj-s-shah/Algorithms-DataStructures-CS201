import java.util.Arrays;

public class PercolationUF implements IPercolate {

    private boolean[][] myGrid;
    private int myOpenCount;
    private IUnionFind myFinder;
    private final int VTOP;
    private final int VBOTTOM;

    public PercolationUF(IUnionFind finder, int size) {
        myOpenCount = 0;
        VTOP = size * size;
        VBOTTOM = size * size + 1;
        myGrid = new boolean[size][size];
        finder.initialize(size * size + 2);
        myFinder = finder;
    }

    @Override
    public void open(int row, int col) {
        int[] rowDelta = {-1,1,0,0};
        int[] colDelta = {0,0,-1,1};

        if (! inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        } else{
            if(!isOpen(row, col)) {
                myGrid[row][col] = true;
                myOpenCount++;
            }
            int currentCell = indexFinder(row, col);
            if (inBounds(row + 1, col) && isOpen(row + 1, col)){
                myFinder.union(currentCell, indexFinder(row + 1, col));
            }
            if (inBounds(row - 1, col) && isOpen(row - 1, col)){
                myFinder.union(currentCell, indexFinder(row - 1, col));
            }
            if (inBounds(row, col + 1) && isOpen(row, col + 1)){
                myFinder.union(currentCell, indexFinder(row, col + 1));
            }
            if (inBounds(row, col - 1) && isOpen(row, col - 1)){
                myFinder.union(currentCell, indexFinder(row, col - 1));
            }
            if (row == 0) {
                myFinder.union(currentCell, VTOP);
            }
            if (row == myGrid.length - 1) {
                myFinder.union(currentCell, VBOTTOM);
            }
        }
    }

    @Override
    public boolean isOpen(int row, int col) {
        if (!inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        }
        return myGrid[row][col];
    }

    @Override
    public boolean isFull(int row, int col) {
        if (! inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        }
       return myFinder.connected(VTOP, indexFinder(row, col));
    }

    @Override
    public boolean percolates() {
       return myFinder.connected(VTOP, VBOTTOM);
    }

    @Override
    public int numberOfOpenSites() {
        return myOpenCount;
    }

    protected boolean inBounds(int row, int col) {
        if (row < 0 || row >= myGrid.length) return false;
        if (col < 0 || col >= myGrid[0].length) return false;
        return true;
    }



   public int indexFinder(int row, int col) {
        return row * myGrid.length + col;
    }
}


