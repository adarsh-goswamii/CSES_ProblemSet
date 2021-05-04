

import java.util.*;
import java.io.*;

class SumOfFourValues {
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
        int n= ni(), find= ni();

        int[] arr= new int[n]; read();
        for(int i=0;i<n;i++) arr[i]= ni();

        Map<Integer, List<int[]>> map= new HashMap<>();
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int key= arr[i]+ arr[j];
                if(map.containsKey(key)) map.get(key).add(new int[]{i+1, j+1});
                else {
                    List<int[]> temp= new ArrayList<>();
                    temp.add(new int[]{i+1, j+1});
                    map.put(key, temp);
                }
            }
        }

        boolean found= false;
        outer: for(int i: map.keySet()) {
            int key= find- i;

            if(map.containsKey(key)) {
                for(int[] j: map.get(i)) {
                    for(int[] k: map.get(key)) {
                        if(unique(j, k)) {
                            found= true;
                            out.println(j[0]+" "+j[1]+" "+k[0]+" "+k[1]);
                            break outer;
                        }
                    }
                }
            }
        }

        if(!found) out.println("IMPOSSIBLE");
    }

    private boolean unique(int[] a, int[] b) {
        if(a[0]!= b[0] && a[0]!= b[1] && a[1]!= b[0] && a[1]!= b[1]) return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        new SumOfFourValues().run();
    }

    void run() throws Exception {
        out = new PrintWriter(System.out);
        br = new BufferedReader(new InputStreamReader(System.in));

//        File file= new File("C:\\Users\\Adarsh Goswami\\Downloads\\test_input (4).txt");
//        br = new BufferedReader(new FileReader(file));
//        out= new PrintWriter("output.txt");

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
            return a + b >= 0 ? a + b : a + b + mod;
    }

    long mul(long a, long b) {
        return (a * b) % mod;
    }
}
