package GrammarAnalysis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class gototableUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6612976492439956169L;
	private JTable table=null;
	public gototableUI() {
		super("goto±í");
	try {	
		String input="src/GrammarAnalysis/goto_result.txt";
		FileInputStream incode=new FileInputStream(input);
		BufferedReader strcode=new BufferedReader(new InputStreamReader(incode));	
		String line="";
		int lineNum=0;
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"×´Ì¬","B", "D", "E", "G", "K", "C", "Y", 
				"J", "Z", "S", "L", "M", "N", "O", "P", "Q", "R", "H", "T", "U", "I", "V", "W", "X", "F"});
		while((line=strcode.readLine())!=null){
			lineNum++;
			if(lineNum%2==0) {
				String line1="";
				 line1=line.substring(1, line.length()-1);
				 String[] t=line1.split(",");
				 int n=t.length;
				 String[] a=new String[n];
				 for(int i=0;i<n;i++) {
					 if(t[i].equals("error") || t[i].equals(" error")) {
						 a[i]=" ";
					 }else {
						 a[i]=t[i];
					 }
				 }
		model.addRow(new Object[]{lineNum/2,a[0],a[1],a[2],a[3],a[4],a[5],a[6],a[7],a[8],a[9],a[10],a[11],a[12],a[13]
				,a[14],a[15],a[16],a[17],a[18],a[19],a[20],a[21],a[22],a[23],a[24]});
			}				
		}
		
		table=new JTable(model);
		
		add(new JScrollPane(table));
	   setSize(1000,700); 
	   setLocationRelativeTo(null); 
	   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   setVisible(true);
	   strcode.close();
	}catch (Exception e1) {
		e1.printStackTrace();
      }  
	}
	public static void main(String[] args) {
		new gototableUI();
	}
}
