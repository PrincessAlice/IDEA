public static double calcPi(int n){
  double Pi4=0;
  for(int i=0;i<n;i++){
  int m=2*i+1;
  if(i%2==0){
  //jia
	Pi4=Pi4+1.0/m;
   }else{
  //jian
	Pi4=Pi4-1.0/m;
   }
  }
	return Pi4*4;
}
 
double Pi=clacPi