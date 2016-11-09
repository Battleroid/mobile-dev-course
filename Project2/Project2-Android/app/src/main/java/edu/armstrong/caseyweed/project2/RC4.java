package edu.armstrong.caseyweed.project2;

public class RC4 {

    private int[] s = new int[256];
    private int I = 0;
    private int J = 0;

    public RC4(int[] key) {
        for (int i = 0; i < 256; i++) {
            s[i] = i;
        }
        int j = 0;
        for (int i = 0; i < 256; i++) {
            int K = key[i % key.length];
            int S = s[i];
            j = ((j + S + K) % 256);
            swap(s[i], s[j]);
        }
    }

    public int next() {
        I = (I + 1) % 256;
        J = (J + s[I]) % 256;
        swap(s[I], s[J]);
        return s[(s[I] + s[J]) % 256];
    }

    private void swap(int a, int b) {
        final int t = a;
        a = b;
        b = t;
    }

}
