import java.util.*;
import java.io.*;

class TwoKnights {
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
        int n= ni();
        for(int i=1;i<=n;i++)
            calc(i);
    }

    private void calc(int n) {
        if(n== 1) out.println(0);
        else if(n== 2) out.println(6);
        else if(n== 3) out.println(28);
        else {
            long total= n*n;
            long ways= (total* (total-1))/2;
            long layer= (n<<1)+ ((n-2)<<1);
            total-= layer;
            long sub= 32+ (layer- 12)*4;

            n-= 2;
            layer= (n<<1)+ ((n-2)<<1);
            total-= layer;
            sub+= 16;
            if(layer> 4) { layer-= 4; sub+= layer*6; }

            sub+= total*8;

            out.println(ways- sub/2);
        }
    }

    public static void main(String[] args) throws Exception {
        new TwoKnights().run();
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