import java.util.*;
import java.io.*;

class SumOfTwoValues {
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

        List<int[]> a= new ArrayList<>(); read();
        for(int i=0;i<n;i++) a.add(new int[]{i+1, ni()});

        Collections.sort(a, (_a, _b)->(_a[1]-_b[1]));
        int i= 0, j= n-1;
        while(i< j) {
            if(a.get(i)[1]+ a.get(j)[1]== x) {
                out.println(a.get(i)[0]+" "+a.get(j)[0]);
                break;
            }
            else if(a.get(i)[1]+ a.get(j)[1]> x) j--;
            else i++;
        }

        if(i>=j) out.println("IMPOSSIBLE");
    }

    public static void main(String[] args) throws Exception {
        new SumOfTwoValues().run();
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