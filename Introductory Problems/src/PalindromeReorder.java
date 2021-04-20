import java.util.*;
import java.io.*;

class PalindromeReorder {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;

    /**
     *
     */

    void solve() throws Exception {
        char[] arr= ns().toCharArray();
        int[] map= new int[26];
        for(char c: arr)
            map[c-'A']++;

        boolean odd= false, bans= true;
        for(int i: map) {
            if (odd && i % 2 != 0) bans = false;
            else if (i % 2 != 0) odd = true;
        }

        if(!bans) out.println("NO SOLUTION");
        else {
            char[] ans= new char[arr.length];
            int start= 0, last= arr.length-1, i= 0;
            while(start<= last && i!= 26) {
                if(map[i]!= 0 && map[i]%2== 0) {
                    while(map[i]!= 0) {
                        ans[start++]= (char)(i+'A');
                        ans[last--]= (char)(i+'A');
                        map[i]-= 2;
                    }
                }
                i++;
            }

            i= 0;
            while(start<= last) {
                if(map[i]!= 0) {
                    while (map[i] > 0) {
                        ans[start++] = (char) (i + 'A');
                        ans[last--] = (char) (i + 'A');
                        map[i] -= 2;
                    }
                }
                i++;
            }

            out.println(new String(ans));
        }
    }

    public static void main(String[] args) throws Exception {
        new PalindromeReorder().run();
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