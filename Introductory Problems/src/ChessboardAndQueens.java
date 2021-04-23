import java.util.*;
import java.io.*;

class ChessboardAndQueens {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;

    /**
     *
     */

    void solve() throws Exception {
        char[][] board= {ns().toCharArray(), ns().toCharArray(), ns().toCharArray(), ns().toCharArray(), ns().toCharArray(),
                ns().toCharArray(), ns().toCharArray(), ns().toCharArray()};

        ans= 0;
        backtracking(board, new boolean[8], new boolean[15], new boolean[15], 0);
        out.println(ans);
    }

    int ans;
    private void backtracking(char[][] board, boolean[] col, boolean[] top_left_bottom_right, boolean[] top_right_bottom_left, int curr) {
        if(curr== 8) ans++;
        else {
            for(int i=0;i<8;i++) {
                if(board[curr][i]== '*') continue;
                else if(col[i]) continue;

                int d1= curr-i+7;
                int d2= 7-curr-i+7;

                if(top_left_bottom_right[d1] || top_right_bottom_left[d2]) continue;

                col[i]= true;
                top_left_bottom_right[d1]= true;
                top_right_bottom_left[d2]= true;
                backtracking(board, col, top_left_bottom_right, top_right_bottom_left, curr+1);

                col[i]= false;
                top_left_bottom_right[d1]= false;
                top_right_bottom_left[d2]= false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new ChessboardAndQueens().run();
    }

    void run() throws Exception {
        out = new PrintWriter(System.out);
        br = new BufferedReader(new InputStreamReader(System.in));

        solve();
        out.flush();
    }

    void read() throws Exception {
        st = new StringTokenizer(br.readLine());
    }

    int ni() {
        return Integer.parseInt(st.nextToken());
    }

    long nl() {
        return Long.parseLong(st.nextToken());
    }

    double nd() {
        return Double.parseDouble(st.nextToken());
    }

    String ns() throws Exception {
        String s = br.readLine();
        return s.length() == 0 ? br.readLine() : s;
    }

    void print(int[] arr) {
        for (int i : arr)
            out.print(i + " ");
        out.println();
    }

    void print(long[] arr) {
        for (long i : arr)
            out.print(i + " ");
        out.println();
    }

    void print(int[][] arr) {
        for (int[] i : arr) {
            for (int j : i)
                out.print(j + " ");
            out.println();
        }
    }

    void print(long[][] arr) {
        for (long[] i : arr) {
            for (long j : i)
                out.print(j + " ");
            out.println();
        }
    }

    long add(long a, long b) {
        if (a + b >= mod)
            return (a + b) - mod;
        else
            return a + b;
    }

    long mul(long a, long b) {
        return (a * b) % mod;
    }
}