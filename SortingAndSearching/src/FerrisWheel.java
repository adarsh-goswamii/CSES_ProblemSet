import java.util.*;
import java.io.*;

class FerrisWheel {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;

    /**
     *
     */

    void solve() throws Exception {
        read();
        int n= ni(), x= ni();
        TreeMap<Long, Integer> a= new TreeMap<>(); read();
        for(int i=0;i<n;i++) {
            long key= nl();
            a.put(key, a.getOrDefault(key, 0)+ 1);
        }

        int min= 0;
        while(!a.isEmpty()) {
            Map.Entry<Long, Integer> curr= a.pollLastEntry();
            long left= x- curr.getKey();
            if(curr.getValue()!= 1) {
                a.put(curr.getKey(), curr.getValue()-1);
            }

            if(a.floorKey(left)!= null) {
                long val= a.floorKey(left);
                if(a.get(val)== 1) a.remove(val);
                else a.put(val, a.get(val)-1);
            }

            min++;
        }

        out.println(min);
    }

    public static void main(String[] args) throws Exception {
        new FerrisWheel().run();
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