import java.util.*;
import java.io.*;

class GrayCode {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;
    int n;

    /**
     *  Time Complexity: O(2^n*16)
     */

    void solve() throws Exception {
        read();
        n= ni();

        HashSet<Integer> set= new HashSet<>();
        for(int i=1;i<= (1<<n);i++) set.add(i);

        print(0);
        generateGrayCode(set, 0, n);
    }

    private void generateGrayCode(HashSet<Integer> set, int curr, int n) {
        if(set.size()== 0) return;
        else {
            for(int i=0;i<=n;i++) {
                int find= (1<<i)^ curr;
                if(set.contains(find)) {
                    print(find);
                    set.remove(find);
                    generateGrayCode(set, find, n);
                    break;
                }
            }
        }
    }

    private void print(int find) {
        int temp= n;
        while(temp!= 0) {
            out.print(find&1);
            find>>= 1;
            temp--;
        }
        out.println();
    }

    public static void main(String[] args) throws Exception {
        new GrayCode().run();
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