package demo.dsa;

public class MatrixSpiralDemo {

	public static void main(String[] args) {
		int a[][] = {{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20},{21,22,23,24,25,26,27,28,29,30},{31,32,33,34,35,36,37,38,39,40},{41,42,43,44,45,46,47,48,49,50},
				{51,52,53,54,55,56,57,58,59,60},{61,62,63,64,65,66,67,68,69,70},{71,72,73,74,75,76,77,78,79,80},{81,82,83,84,85,86,87,88,89,90},{91,92,93,94,95,96,97,98,99,100}};
		int fr=0,lr=a.length-1,fc=0,lc=a.length-1;
		int dir=0;
		
		while(fr<=lr && fc<=lc){
		    if(dir == 0){
    		    for(int i=fc; i<=lc; i++){
    		        System.out.print(a[fr][i]+" ");
    		    }
    		    fr++;
    		    dir++;
    		    dir %= 4;
		    }
		    
		    if(dir == 1){
    		    for(int i=fr; i<=lr; i++){
    		        System.out.print(a[i][lc]+" ");
    		    }
    		    lc--;
    		    dir++;
    		    dir %= 4;
		    }
		    
		    if(dir == 2){
    		    for(int i=lc; i>=fc; i--){
    		        System.out.print(a[lr][i]+" ");
    		    }
    		    lr--;
    		    dir++;
    		    dir %= 4;
		    }
		    
		    if(dir == 3){
    		    for(int i=lr; i>=fr; i--){
    		        System.out.print(a[i][fc]+" ");
    		    }
    		    fc++;
    		    dir++;
    		    dir %= 4;
		    }
		    
		}

	}

}
