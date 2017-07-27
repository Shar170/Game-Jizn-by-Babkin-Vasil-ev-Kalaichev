package version01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class Main {
	
	private static int heightFrame = 600;
	private static int widthFrame = 600;
	
	public static int countRows = 20;
	public static int countColums = 20;
	
	public static int countPoints = 5;
	public static JTable table;

	public static void main(String[] args) {
		if (JOptionPane.showConfirmDialog(null, "Single player game, please enter the \"Yes\"!") == JOptionPane.YES_OPTION) {
			addFrame();
		} else {
			beginSetting();
			addFrame();
		}
	}
	
	private static void addFrame() {
		JFrame frame = new JFrame("Life v0.1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(widthFrame, heightFrame + 10);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		table = new JTable(countRows, countColums);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight((int)heightFrame/countColums);
		for (int i = 0; i < countColums; i++) {
			table.getColumnModel().getColumn(i).setMinWidth((int)widthFrame/countColums);
			table.getColumnModel().getColumn(i).setWidth((int)widthFrame/countColums);
		}
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumnModel().setColumnSelectionAllowed(true);
		for (int i = 0; i < countColums; i++) {
			for (int j = 0; j < countRows; j++) {
				table.setValueAt(0, j, i);
			}
		}
		
		ListSelectionModel listSelectionModel = table.getSelectionModel();
		listSelectionModel.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
					if (table.getSelectedRow() != -1) {
						if (countPoints != 0) {
							String value = table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()).toString();
							if (!value.equals("1")) {
								table.setValueAt("1", table.getSelectedRow(), table.getSelectedColumn());
								countPoints--;
							}
						//table.getColumnModel().getColumn(table.getSelectedColumn()).setCellRenderer(new CustomRenderer(table.getSelectedRow(), table.getSelectedColumn()));
						table.getSelectionModel().clearSelection();
						if (countPoints == 0) {
									Iter();
							}
						}
					}
				
			}
		});
		
		frame.add(table);
		
		frame.setVisible(true);
	}
	
	public static void Iter() {
		JOptionPane.showMessageDialog(null, "Run!!!");
		for (int i = 0; i < 10; i++) {
			try {
				t2.oneGame(table);
				Thread.sleep(1000);
			} catch (Exception e1) {
				
			}
		}
	}
	
	private static void beginSetting() {
		if (JOptionPane.showConfirmDialog(null, "Do you want to become a server?") == JOptionPane.YES_OPTION) {
				countRows = Integer.parseInt(JOptionPane.showInputDialog("Enter the count Rows and Colums"));
				countColums = countRows;
				countPoints = Integer.parseInt(JOptionPane.showInputDialog("Please, enter the points!"));
				Server server = new Server();
		} else {
			Client client = new Client();
		}
	}
	
	public static class CustomRenderer extends DefaultTableCellRenderer implements TableCellRenderer
	{
		int column;
		int row;
		
		public CustomRenderer(int row, int column) {
			this.column = column;
			this.row = row;
			setOpaque(true);
		}
		
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	    		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
	    	
	        	cellRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	        		if (row == this.row && column == this.column) {
	        			cellRenderer.setBackground(Color.RED);
				        //System.out.println(row + " " + column);
				    } else {
				        cellRenderer.setBackground(table.getBackground());
				        //original = null;
				    }
		        
	        return cellRenderer;
	    }
	}
	
}
