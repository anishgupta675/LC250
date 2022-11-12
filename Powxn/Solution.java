import java.util.*;
class Solution {
    public double myPow(double x, int n) {
        long nm = n;
		if(n<0){
		   nm = -nm;
		   x = 1/x;
		  }
        return pow(x,nm);
    }
    public double pow(double x, long n)
    {
        if(n==0)
            return 1;
			
        if(n%2==0)
            return pow(x*x, n/2);
        else
            return x * pow(x,n-1);
    }
    public static void main(String[] args) throws Exception {}
}