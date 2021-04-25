import java.util.*;
import java.io.*;

class Apartments {
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
        int n= ni(), m= ni(), k= ni();
        List<Long> a= new ArrayList<>();
        read();
        for(int i=0;i<n;i++) a.add(nl());

        read();
        List<Long> b= new ArrayList<>();
        for(int i=0;i<m;i++) b.add(nl());

        Collections.sort(a);
        Collections.sort(b);

        int ans= 0;
        for(int i=0, j= 0;i<n && j<m;) {
            long diff= Math.abs(a.get(i)- b.get(j));
            if(diff<= k) {
                ans++;
                i++;
                j++;
            }
            else if(a.get(i)> b.get(j)) j++;
            else if(b.get(j)> a.get(i)) i++;
        }

        out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Apartments().run();
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