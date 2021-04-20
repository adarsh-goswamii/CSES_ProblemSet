import java.util.*;
import java.io.*;

class TwoSets {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;

    /**
     *  Already done a harder version of this problem : EQDIV in codechef long
     *  I don't remember the month though
     */

    void solve() throws Exception {
        read();
        int n= ni();
        if(n%4== 0 || n%4== 3) {
            out.println("YES");
            int[] select= {0, 1, 1, 0};

            if(n%4== 0) {
                out.println(n/2);
                for(int i=0;i<n;i++) if(select[i%4]== 0) out.print((i+1)+" ");
                out.println("\n"+n/2);
                for(int i=0;i<n;i++) if(select[i%4]== 1) out.print((i+1)+" ");
            }
            else {
                out.print((n/2)+"\n3 ");
                for(int i=3;i<n;i++) if(select[(i-3)%4]== 0) out.print((i+1)+" ");
                out.print("\n"+(n/2+1)+"\n1 2 ");
                for(int i=3;i<n;i++) if(select[(i-3)%4]== 1) out.print((i+1)+" ");
            }
        }
        else out.println("NO");
    }

    public static void main(String[] args) throws Exception {
        new TwoSets().run();
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