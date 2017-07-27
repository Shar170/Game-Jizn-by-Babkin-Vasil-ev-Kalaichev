	
package version01;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JTable;
	
public class t2 {
public static Component oneGame (JTable table){
	int i = 0, j = 0, N, k = 0;
	N = table.getRowCount(); 
	int arrk[][] = new int[N][N];
	//while (true) {
	for (i = 0; i < N; i++){
		for (j = 0; j < N; j++){
			if ((i != 0) && (j != 0) && (i < N - 1) && (j < N - 1)){
				//System.out.println(i + " Center " + j);
				if (Integer.parseInt(table.getValueAt(i-1, j-1).toString()) == 1) k++;
				if (Integer.parseInt(table.getValueAt(i-1, j).toString()) == 1)   k++;
				if (Integer.parseInt(table.getValueAt(i-1, j+1).toString()) == 1) k++;
				if (Integer.parseInt(table.getValueAt(i, j-1).toString()) == 1)   k++;
				if (Integer.parseInt(table.getValueAt(i, j+1).toString()) == 1)   k++;
				if (Integer.parseInt(table.getValueAt(i+1, j-1).toString()) == 1) k++;
				if (Integer.parseInt(table.getValueAt(i+1, j).toString()) == 1)   k++;
				if (Integer.parseInt(table.getValueAt(i+1, j+1).toString()) == 1) k++;
				arrk[i][j] = k;
				k = 0;
			}
			if ((i == 0) && (j > 0) && (j < N-1)){
				//System.out.println(i + " UpStr " + j);
				if (Integer.parseInt(table.getValueAt(i, j-1).toString()) == 1)   k++;
				if (Integer.parseInt(table.getValueAt(i, j+1).toString()) == 1)   k++;
				if (Integer.parseInt(table.getValueAt(i+1, j-1).toString()) == 1) k++;
				if (Integer.parseInt(table.getValueAt(i+1, j).toString()) == 1)   k++;
				if (Integer.parseInt(table.getValueAt(i+1, j+1).toString()) == 1) k++;
				arrk[i][j] = k;
				k = 0;
			}
			if ((j == 0) && (i == 0)){
				//System.out.println(i + " LU Corner " + j);
				if (Integer.parseInt(table.getValueAt(i+1, j).toString()) == 1)   k++;
				if (Integer.parseInt(table.getValueAt(i+1, j+1).toString()) == 1) k++;
				if (Integer.parseInt(table.getValueAt(i, j+1).toString()) == 1)   k++;
				arrk[i][j] = k;
				k = 0;
		   }
		   if ((i > 0) && (i < N - 1) && (j == 0)){
				//System.out.println(i + " lStripe " + j);
			    if (Integer.parseInt(table.getValueAt(i-1, j).toString()) == 1)   k++;
				if (Integer.parseInt(table.getValueAt(i-1, j+1).toString()) == 1) k++;
				if (Integer.parseInt(table.getValueAt(i+1, j).toString()) == 1)   k++;
				if (Integer.parseInt(table.getValueAt(i+1, j+1).toString()) == 1) k++;
				if (Integer.parseInt(table.getValueAt(i, j+1).toString()) == 1)   k++;
				arrk[i][j] = k;
				k = 0;
			}
		   if ((i == N - 1) && (j > 0) && (j < N - 1)){
				//System.out.println(i + " Down Stripe " + j);
				if (Integer.parseInt(table.getValueAt(i-1, j-1).toString()) == 1) k++;
				if (Integer.parseInt(table.getValueAt(i-1, j).toString()) == 1)   k++;
				if (Integer.parseInt(table.getValueAt(i-1, j+1).toString()) == 1) k++;
				if (Integer.parseInt(table.getValueAt(i, j-1).toString()) == 1)   k++;
				if (Integer.parseInt(table.getValueAt(i, j+1).toString()) == 1)   k++;
				arrk[i][j] = k;
				k = 0;
			}
			if ((i == N - 1) && (j == 0)){
				//System.out.println(i + " LD Corner " + j);
				if (Integer.parseInt(table.getValueAt(i-1, j).toString()) == 1)   k++;
				if (Integer.parseInt(table.getValueAt(i-1, j+1).toString()) == 1) k++;
				if (Integer.parseInt(table.getValueAt(i, j+1).toString()) == 1)   k++;
				arrk[i][j] = k;
				k = 0;
			}
			if ((i == N - 1) && (j == N - 1)){
				//System.out.println(i + " RD Corner " + j);
				if (Integer.parseInt(table.getValueAt(i-1, j-1).toString()) == 1) k++;
				if (Integer.parseInt(table.getValueAt(i-1, j).toString()) == 1)   k++;
				if (Integer.parseInt(table.getValueAt(i, j-1).toString()) == 1)   k++;
				arrk[i][j] = k;
				k = 0;
			}
			if ((i == 0) && (j == N - 1 )){
				//System.out.println(i + " RU Corner " + j);
				if (Integer.parseInt(table.getValueAt(i, j-1).toString()) == 1)   k++;
				if (Integer.parseInt(table.getValueAt(i+1, j).toString()) == 1)   k++;
				if (Integer.parseInt(table.getValueAt(i+1, j-1).toString()) == 1) k++;
				arrk[i][j] = k;
				k = 0;
			}
			if ((j == N - 1) && (i > 0) && (i < N - 1)){
			//	System.out.println(i + " Right Stripe " + j);
				if (Integer.parseInt(table.getValueAt(i-1, j-1).toString()) == 1) k++;
				if (Integer.parseInt(table.getValueAt(i-1, j).toString()) == 1)   k++;
				if (Integer.parseInt(table.getValueAt(i, j-1).toString()) == 1)   k++;
				if (Integer.parseInt(table.getValueAt(i+1, j).toString()) == 1)   k++;
				if (Integer.parseInt(table.getValueAt(i+1, j-1).toString()) == 1) k++;
				arrk[i][j] = k;
				k = 0;
			}
			
		}
	}
	for(i = 0; i < N; i++){
		for (j = 0; j < N;j++){
			if (arrk[i][j] + Integer.parseInt(table.getValueAt(i, j).toString()) != 3){
				table.setValueAt(0, i, j);
			}
			if (arrk[i][j] + Integer.parseInt(table.getValueAt(i, j).toString()) == 3){
				table.setValueAt(1, i, j);
			}
		}
	}
	return table;
	//}
}
}