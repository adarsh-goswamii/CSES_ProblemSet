import java.util.*;
import java.io.*;

class AppleDivision {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final long lmax = Long.MAX_VALUE, lmin = Long.MIN_VALUE;
    final int mod = 1000000007;

    /**
     *
     */

    void solve() throws Exception {
        read();
        int n= ni();

        read();
        int[] arr= new int[n];
        for(int i=0;i<n;i++) arr[i]= ni();

        long sum= 0l;
        for(int i: arr) sum+= i;

        min= lmax;
        subset(arr, sum, 0, 0);
        out.println(min);
    }

    long min;
    void subset(int[] arr, long sum, int curr, long curr_sum) {
        if(curr== arr.length) min= Math.min(min, Math.abs(curr_sum-(sum- curr_sum)));
        else {
            subset(arr, sum, curr+1, curr_sum);
            subset(arr, sum, curr+1, curr_sum+ arr[curr]);
        }
    }

    public static void main(String[] args) throws Exception {
        new AppleDivision().run();
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