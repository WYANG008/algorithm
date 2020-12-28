package math;

public class HammingDistance {

    public int hammingDistance(int x, int y) {

        int distance = 0;
        while (x >0 || y>0) {
            distance += (x & 1) ^ (y&1);
            x = x>>1;
            y = y>>1;
        }


        return distance;
    }

    public static void main(String[] args) {

        HammingDistance  runClass = new HammingDistance();
        int result = runClass.hammingDistance(1,4);
        System.out.println(String.format("result is: %d", result));

    }
}
