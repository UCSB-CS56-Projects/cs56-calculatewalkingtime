import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MapGui extends JFrame
{
    JTextArea resultText =  new JTextArea();
    ImageIcon ic = new   ImageIcon("map.jpg");
    JDesktopPane dp = new JDesktopPane();
    JLabel lbl = new JLabel(ic);
    JPanel transparentPanel = new JPanel();
    static ArrayList<BuildingCheckBox> boxes = new ArrayList();
    public String building1, building2, mode;
    
    BuildingCheckBox[] selected = new BuildingCheckBox[2];
    public MapGui()
    {
	
	lbl.setBounds(0,0,850,1100); 
	
	
	transparentPanel.setOpaque(false);
	transparentPanel.setBounds(0,0,1000,1000);
	
	BuildingCheckBox HFH = new BuildingCheckBox();
	
	
	HFH.Name = "HFH";
	this.setLayout(null);
	transparentPanel.setLayout(null);
	//HFH.setSize(50,50);
	HFH.setBounds(690,410,20,20);
	transparentPanel.add(HFH); 
	boxes.add(HFH);
	
	
	//add DAVDIDSON
	
	BuildingCheckBox LIB = new BuildingCheckBox();
	LIB.Name = "LIB";
	LIB.setBounds(460, 430, 20,20);
	transparentPanel.add(LIB);
	boxes.add(LIB);
	super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	dp.add(lbl,new Integer(50));
	dp.add(transparentPanel,new Integer(350));
	
	setLayeredPane(dp);
	
	
	
	
	//put the two selected boxes into boxes array
	
   	
	
	
	
	
	
	
	
	//add TextArea that outputs the result
	
	resultText.setBounds(540,40,300,140);
	resultText.setText("Click two buildings and select preffered \n method of transportation");
	transparentPanel.add(resultText);
	
	//Add calculate button that calls Calculuate((
	
	JButton CalcWalk = new JButton("Calculate Walking");
	CalcWalk.setBounds(20,20,200,30);
	transparentPanel.add(CalcWalk);
	CalcWalk.addActionListener(new CalcWalkListener());
	
	JButton CalcBike = new JButton("Calculate Biking");
	CalcBike.setBounds(250,20,200,30);
	transparentPanel.add(CalcBike);
	CalcBike.addActionListener(new CalcBikeListener());
    }
    
    
    
    
    
    class CalcWalkListener implements ActionListener {
	public void actionPerformed(ActionEvent event){
	    if(boxes.get(0).isSelected() && boxes.get(0).isSelected()){
		getSelectedBuildings();
		UCSBWalk.calculate(selected[0].Name, selected[1].Name, "walking");
		resultText.setText(UCSBWalk.result);
		
	    }
	}
	
    }
    
    class CalcBikeListener implements ActionListener {
	public void actionPerformed(ActionEvent event){
	    if(boxes.get(0).isSelected() && boxes.get(0).isSelected()){
		getSelectedBuildings();
		UCSBWalk.calculate(selected[0].Name, selected[1].Name, "biking");
		resultText.setText(UCSBWalk.result);
	    }
	}
	
    }
    
    //add TextArea that outputs the result
    
    
    
    
    public void getSelectedBuildings(){
	int numSelected = 0;
	for(int i =0; i < boxes.length; i++){
	    if(numSelected<2 && boxes.get(i).isSelected()){
		selected[numSelected] = boxes.get(i);
		numSelected++;
	    }
	    
	    else{
		resultText.setText("You Selected too many boxes /n only select two!");
	    }
	}
    }
    

    
    public static void main(String[] args)
    {
	MapGui map = new MapGui();
	map.setSize(850, 1050); 
	map.setVisible(true);
	
	
    }
    
    
}
