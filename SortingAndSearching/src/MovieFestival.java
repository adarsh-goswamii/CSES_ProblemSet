import java.util.*;
import java.io.*;

class MovieFestival {
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
        List<int[]> a= new ArrayList<>();
        for(int i=0;i<n;i++) {
            read();
            a.add(new int[]{ni(), ni()});
        }

        Collections.sort(a, (_a, _b)->(_a[0]-_b[0]));
        dp= new int[n];
        out.println(helper(a, 0));
    }

    int[] dp;
    private int helper(List<int[]> a, int index) {
        if(index>=a.size()) return 0;
        else if(dp[index]!= 0) return dp[index];
        else {
            int new_index= binarySearch(a, 0, a.size()-1, a.get(index)[1]);
            dp[index]= Math.max(helper(a, new_index)+1, helper(a, index+1));

            return dp[index];
        }
    }

    private int binarySearch(List<int[]> a, int start, int last, int find) {
        int ret= a.size();
        while(start<= last) {
            int mid= start+ (last- start)/2;

            if(a.get(mid)[0]>= find) {
                ret= mid;
                last= mid-1;
            }
            else start= mid+1;
        }

        return ret;
    }

    public static void main(String[] args) throws Exception {
        new MovieFestival().run();
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