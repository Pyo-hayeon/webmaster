package chap05;

public class Examp223 {

	public static void main(String[] args) {
		//문제5번
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
		int sum = 0;
		double avg = 0.0;
		int cnt = 0;
//		for(int i=0; i<array.length; i++) {
//			for(int j=0; j<array[i].length; j++) {
//				sum += array[i][j];
//				cnt++;
//			}
//		}
		
		for(int[] row : array) {
			for(int j : row) {
				sum += j;
				cnt++;
			}
		}
		
		avg = (double)sum/cnt;
		System.out.println("sum: "+sum);
		System.out.println("avg: "+avg);
		
		
		for(int i=0; i<array.length; i++) {
			for(int row : array[i]) {
				System.out.print(row+" ");
			}
			System.out.print("\t");
		}
		System.out.println();
		
		
		for(int[] row : array) {
			System.out.println(row);
		}
		
	}

}
