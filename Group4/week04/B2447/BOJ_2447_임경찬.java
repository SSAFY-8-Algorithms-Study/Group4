
import java.util.Scanner;

public class Main {
	public static StringBuilder sb;
	
	


	public static int oper(char [][]arr1,int input,int counter) {
		
		sb=new StringBuilder();
		


	    
	    char N_arr1[][]= new char[counter][counter];

	    for (int i = 0; i < counter; i++) {
	      
	        for (int j = 0; j < counter; j++)
	        {
	            N_arr1[i][j] = ' ';
	        }
	    }



	    for (int w = 0; w < 3; w++)//더 큰 2차원 배열에 값을 넣는 과정
	    {
	        for (int h = 0; h < 3; h++)
	        {
	            if ((w == 1) && (h == 1))
	            {
	                continue;
	            }
	            for (int i = w * (counter / 3), i2 = 0; i < (w + 1) * (counter / 3); i++, i2++)
	            {
	                for (int j = h * (counter / 3), j2 = 0; j < (h + 1) * (counter / 3); j++, j2++)
	                {
	                    N_arr1[i][j] = arr1[i2][j2];
	                    
	                    
	                }
	              
	            }
	            
	            
	        }
	        
	    }
	    
	    if (counter > input)//입력값에 해당하는 2차원 배열이 만들어졌을 때 if문을 실행하여 2차원 배열출력
	    {
	    	
	    	
	    	
	    	
		        for (int i = 0; i < input; i++)
	        {
	            for (int j = 0; j < input; j++)
	           {
	               // System.out.print((arr1[i][j]));
	            	sb.append(arr1[i][j]);
	    	
	            	
	            }
	            sb.append("\n");
	            
	            //System.out.println("");
	        }
	    	
	    	System.out.println(sb);
	    	
	    	
	    	
	    	
	       // for (int i = 0; i < input; i++)
	        //{
	         //   for (int j = 0; j < input; j++)
	        //    {
	               // System.out.print((arr1[i][j]));
	    	
	            	
	      //      }
	            //System.out.println("");
	    //    }
	      
	    	
	    	
	    	//System.out.print(sb);
	    	
	    	
	    	
	    	
	    	
	    	
	        return 0;
	    }
	    

	        return oper(N_arr1, input, counter * 3);
	    }
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		

			Scanner sc= new Scanner(System.in);
			
		    int input=sc.nextInt();//3^N 
		    
		    
		    char array[][]= new char[3][3];
		    
		    
		    for(int i=0;i<3;i++) {
		    	
		    	for(int j=0;j<3;j++) {
		    		
		    		array[i][j]='*';
		    		
		    	}
		    	
		    }
		    array[1][1]=' ';
		    
		    
		    
		    //N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다.




		    if (input == 3) {
			    for(int i=0;i<3;i++) {
			    	
			    	for(int j=0;j<3;j++) {
			    		
			    		System.out.print(array[i][j]);
			    		
			    	}
			    	System.out.println("");
			    }
		    }


		    else {

		        oper(array, input, 3);

		    }
		    return ;
		
		
		
		
		
	}
}
