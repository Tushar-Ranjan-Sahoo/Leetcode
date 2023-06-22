public class PairsofsongsWithTotalDurationsDivisibleby60 {
    ublic int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int[] remainders = new int [60];
        for ( int t :time){
            int remainder = t%60;
            int complement = (60-remainder)% 60;
            count += remainders[complement];
            remainders[remainder]++;

        }
        return count;
    }
}
