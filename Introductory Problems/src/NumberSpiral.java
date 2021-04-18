import java.util.*;
import java.io.*;

class NumberSpiral {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;

    /**
     *    1  2  3  4  5
     * 1  1  2  9 10 25
     * 2  4  3  8 11 24
     * 3  5  6  7 12 23
     * 4 16 15 14 13 22
     * 5 17 18 19 20 21
     *
     */

    void solve() throws Exception {
        read();
        int t= ni();
        for(int ii= 0;ii<t;ii++) {
            read();
            int n= ni(), m= ni();

            long rstart, cstart;
            if(n%2== 0) rstart= n*1l*n;
            else rstart= (n-1)*1l*(n-1)+1;

            if(m%2== 1) cstart= m*1l*m;
            else cstart= (m-1)*1l*(m-1)+1;

//            out.println(rstart+" "+cstart);

            if(rstart> cstart) {
                int mul= n%2== 0? -1: 1;
                out.println(rstart+ mul*--m);
            }
            else {
                int mul= m%2== 0? 1: -1;
                out.println(cstart+ mul*--n);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new NumberSpiral().run();
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