import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ConcertTickets {
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }
    }
    public static void main(String[] args) throws IOException {
        Reader br = new Reader();

//        read();
        int n = br.nextInt(), m = br.nextInt();
        TreeMap<Integer, Integer> a = new TreeMap<>();
//        read();
        for (int i = 0; i < n; i++) {
            int key = br.nextInt();
            a.put(key, a.getOrDefault(key, 0) + 1);
        }

//        read();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int val = br.nextInt();
            b.add(val);
        }

        StringBuffer out= new StringBuffer();
        Map.Entry<Integer, Integer> curr;
        for (int val : b) {
            curr = a.floorEntry(val);
            if (curr == null) out.append(-1).append('\n');
            else {
                if (curr.getValue() == 1) a.remove(curr.getKey());
                else a.put(curr.getKey(), curr.getValue() - 1);

                out.append(curr.getKey()).append('\n');
            }
        }
        System.out.print(out);
    }
}