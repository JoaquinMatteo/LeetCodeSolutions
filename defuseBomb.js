class Solution {
	public int[] decrypt(int[] code, int k) {
		int[] finalCode = new int [code.length];
		int sum=0;
		int largo=code.length;
		for(int i=0; i<largo;i++){
			sum=0;
			if(k>=0){
			for(int j=0;j<k;j++){
				int newPos=i+j+1;sum+=code[newPos%largo];
           }
        finalCode[i]=sum;
      }else{
	      for(int j=Math.abs(k);j>0;j--){
	        int newPos=i-j;
          if(newPos<0){
	          sum+=code[largo+newPos];
          }else{
	          sum+=code[newPos];
          }
      	}
      finalCode[i]=sum;

	   }
   }

   return finalCode;
   }
}