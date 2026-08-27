class Solution {
    public int countGoodNumbers(long n) {
        
         
         long MOD=1000000007L;
        long ans = power(20, n / 2);

        if(n % 2 == 1) {
            ans = (ans * 5) % MOD;
    }
    return (int)ans;}
     private long power(long base, long exp) {

        long result = 1;
         long MOD=1000000007L;

        while(exp > 0) {

            if(exp % 2 == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;

            exp = exp / 2;
        }

        return result;
    }
}
   
