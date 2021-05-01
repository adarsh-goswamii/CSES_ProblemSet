import java.util.*;
import java.io.*;

class TrafficLights {
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
        int x= ni(), n= ni();

        TreeSet<Integer> set= new TreeSet<>();
        set.add(0);
        set.add(x);

        TreeMap<Integer, Integer> map= new TreeMap<>();
        map.put(x,map.getOrDefault(x, 0)+ 1);

        read();
        int[] arr= new int[n];
        for(int i=0;i<n;i++) arr[i]= ni();

        for(int i=0;i<n;i++) {
            int val= arr[i];
            int a= set.floor(val);
            int b= set.ceiling(val);
            set.add(val);

            map.put(b-a, map.get(b-a)-1);
//            if(map.get(b-a)== 0) map.remove(b-a);

            map.put(val-a, map.getOrDefault(val-a, 0)+ 1);
            map.put(b-val, map.getOrDefault(b-val, 0)+ 1);

            int ans;
            while(true) {
                ans= map.lastKey();
                if(map.get(ans)> 0) {
                    out.print(ans+" ");
                    break;
                }

                map.pollLastEntry();
            }

        }
        out.println();
    }

    class BST {
        BST left, right;
        int key, val;

        BST(int key, int val) {
            this.key= key;
            this.val= val;
            left= null;
            right= null;
        }

        BST() {

        }
    }

    void add(BST root, int key) {
        if(root== null) return;
        else {
            if(root.key== key) root.val++;
            else if(root.key< key) {
                if(root.right!= null) add(root.right, key);
                else root.right= new BST(key, 1);
            }
            else {
                if(root.left!= null) add(root.left, key);
                else root.left= new BST(key, 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new TrafficLights().run();
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