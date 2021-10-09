package pages;

public class randomtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("test");
		
		int a[] = {30,70,40,90,50,80,95};

		int b[] =new int[20];
		int i,j,k;
		for(i=0;i<a.length-1;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();

		for(i=0;i<a.length-1;i++){
			System.out.println("a --"+i+" "+a[i]);					
			System.out.println("a+1 --"+(i+1)+" "+a[i+1]);					
		 if(a[i]<a[i+1]){
			 b[i]=a[i+1];
			 b[i+1]=a[i];
			 for(k=0;k<a.length-1;k++){
					System.out.print(b[k]+" ");
				}
			 
//			 System.out.println("b "+b[i]);
		 }
		 System.out.println();

		}
//		for(i=0;i<a.length-1;i++){
//			System.out.print(b[i]+" ");
//		}
//		System.out.println(b[0]);
//		System.out.println(b[1]);


	}

}
