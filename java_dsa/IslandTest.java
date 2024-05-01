import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class IslandTest {
    static int rows;
    static int cols;
    public static void main(String[] args) {
        int[][] ip = new int[][]{
            {0,1,1,0,1,0},
            {1,0,1,1,0,0},
            {1,0,1,1,1,0},
            {0,1,1,1,0,0}
        };
        System.out.println(Arrays.toString(ip[0]));
        System.out.println(Arrays.toString(ip[1]));

        rows = ip.length;
        cols = ip[0].length;
        int[][] vis = new int[rows][cols];
        System.out.println(rows+" "+cols);
        int islands = 0;
        for(int n=0; n<rows; n++) {
            for(int m=0; m<cols; m++) {
                System.out.println("NodeVertex "+n+" "+m);
                int v = 0;
                if(vis[n][m]==0) 
                    v=bfs(n, m, ip, vis);
                islands=islands+v;
            }
        }
        System.out.println("Number of Islands:"+islands);
    }

    private static int bfs(int i, int j, int[][] arr, int[][] vis) {
        vis[i][j] = 1;
        if(arr[i][j]==0) {
            return 0;
        }
        
        Deque<Pair> q = new ArrayDeque<>(); //behave like a queue
        q.add(new Pair(i,j));
        while(!q.isEmpty()) {
            Pair p = q.remove();
            i = p.row;
            j = p.col;

            //check for all neighbouring cells
            for(int deltarow=-1; deltarow<2; deltarow++) {
                for(int deltacol=-1; deltacol<2; deltacol++) {
                    if(Math.abs(deltarow) == 1 && Math.abs(deltacol) == 1)
                        continue;
                    i = p.row + deltarow;
                    j = p.col + deltacol;
                    if(isValidCell(i,j) && arr[i][j] == 1 && vis[i][j] == 0) {
                        vis[i][j] = 1;
                        q.add(new Pair(i,j));
                        System.out.println("Vertex: ("+i+","+j+")");
                    }
                }
            }
        }
        return 1;
    }

    private static boolean isValidCell(int i, int j) {
        if(i>=0 && i<rows && j>=0 && j<cols)
            return true;
        return false;
    }
}

class Pair {
    int row;
    int col;
    Pair(int row, int col) {
        this.row=row;
        this.col=col;
    }
}
