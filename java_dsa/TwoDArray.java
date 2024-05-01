public class TwoDArray {
    public static void main(String[] args) {
        int[][] x = new int[][]{{1,2,3,4,5}
                                ,{1,3,5,6,7}
                                ,{1,6,5,0,7}
                            };
        System.out.println(x[1][1]);
        System.out.println(x.length);

        int[][] y = new int[][] {
            {1,2,3},
            {2,3,4,5},
            {5,6}
        };
        int totalElements = 0;
        for(int[] a : y) {
            System.out.println(a.length);
            totalElements += a.length;
            for(int k : a) {
                System.out.print(k+" ");
            }
            System.out.println("");
        }
        System.out.println(totalElements);
        printAllAdjacentCells(x,0,1,3,5);
    }

    static void printAllAdjacentCells(int[][] x,int i, int j, int rows, int cols) {
        if(i<0 || j<0 || i>rows-1 || j>cols-1) {
            System.out.println(i+", "+j+" elements are not correct");
            return;
        }
        // 4adj elements are left (i,j-1) right (i,j+1) top (i-1,j) bottom (i+1,j)
        if(i>=0 && j-1>=0 && i<=rows-1 && j<=cols-1) {
            System.out.println("left element "+i+", "+j+" --> "+x[i][j-1]);
        }
        if(i>=0 && j+1>=0 && i<=rows-1 && j<=cols-1) {
            System.out.println("right element "+i+", "+j+" --> "+x[i][j+1]);
        }
        if(i-1>=0 && j>=0 && i<=rows-1 && j<=cols-1) {
            System.out.println("top element "+i+", "+j+" --> "+x[i-1][j]);
        }
        if(i+1>=0 && j>=0 && i<=rows-1 && j<=cols-1) {
            System.out.println("bottom element "+i+", "+j+" --> "+x[i+1][j]);
        }
        return;
    }
}
