import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MapGui extends JFrame
{
    JTextArea exitExplicit = new JTextArea();
    JTextArea resultText =  new JTextArea();
    ImageIcon ic = new   ImageIcon("map.jpg");
    JDesktopPane dp = new JDesktopPane();
    JLabel lbl = new JLabel(ic);
    JPanel transparentPanel = new JPanel();
    static ArrayList<BuildingCheckBox> boxes = new ArrayList();
    public String building1, building2, mode;
    int numSelected = 0;
    BuildingCheckBox[] selected = new BuildingCheckBox[2];
    public MapGui()
    {
	
	lbl.setBounds(0,0,850,1100); 
	
	
	transparentPanel.setOpaque(false);
	transparentPanel.setBounds(0,0,1000,1000);


	//BUILDINGS ARE:
	//HFH, LIB, CAMPBELL, UCEN, SAN NIC, REC CEN, PHELPS, HSSB, SRB, MARINE BIO, PYSCH, MANZI,, NORTH, GIRVETZ,, EVENTS CENTER 

	
	BuildingCheckBox HFH = new BuildingCheckBox();

	// add HFH 1st
	HFH.Name = "HFH";
	this.setLayout(null);
	transparentPanel.setLayout(null);

	HFH.setBounds(710,430,20,20);
	transparentPanel.add(HFH); 
	boxes.add(HFH);
	



	//add DAVDIDSON -2
	
	BuildingCheckBox LIB = new BuildingCheckBox();
	LIB.Name = "LIB";
	LIB.setBounds(460, 430, 20,20);
	transparentPanel.add(LIB);
	boxes.add(LIB);


	//add CAMPBELL -3

	BuildingCheckBox CAMPB_HALL = new BuildingCheckBox();
	CAMPB_HALL.Name = "CAMPB";
	CAMPB_HALL.setBounds(475, 246, 20,20);
	transparentPanel.add(CAMPB_HALL);
	boxes.add(CAMPB_HALL);

	//add UCEN -4

	BuildingCheckBox UCEN = new BuildingCheckBox();
	UCEN.Name = "UCEN";
	UCEN.setBounds(370,565,20,20);
	transparentPanel.add(UCEN);
	boxes.add(UCEN);


	//add San Nic -5

	BuildingCheckBox SAN_NIC = new BuildingCheckBox();
	SAN_NIC.Name = "SAN NIC";
	SAN_NIC.setBounds( 420, 700, 20,20);
	boxes.add(SAN_NIC);
	transparentPanel.add(SAN_NIC);

	//add REC CEN -6**

	BuildingCheckBox REC = new BuildingCheckBox();
	REC.Name = "RECEN";
	REC.setBounds(265,110,20,20);
	boxes.add(REC);
	transparentPanel.add(REC);

	//add SRB - 7th**
	BuildingCheckBox SRB  = new BuildingCheckBox();
	SRB.Name = "SRB";
	SRB.setBounds(55, 490,20,20);
	boxes.add(SRB);
	transparentPanel.add(SRB);
	    

	    //add MARINE BIO -8th
	BuildingCheckBox MARINE = new BuildingCheckBox();
	MARINE.Name = "MLAB";
	MARINE.setBounds(590, 810, 20,20);
	boxes.add(MARINE);
	transparentPanel.add(MARINE);
	   
	super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	dp.add(lbl,new Integer(50));
	dp.add(transparentPanel,new Integer(350));
	
	setLayeredPane(dp);
	
	
	
	//add HSSB - 9th

	BuildingCheckBox HSSB = new BuildingCheckBox();
	HSSB.Name = "HSSB";
	HSSB.setBounds(189, 434, 20,20);
	boxes.add(HSSB);
	transparentPanel.add(HSSB);

	//add MANZI -10th

	BuildingCheckBox MANZI = new BuildingCheckBox();
	MANZI.Name = "MANZ";
	MANZI.setBounds(43, 740,20,20);
	boxes.add(MANZI);
	transparentPanel.add(MANZI);
	      	       		
	//add phelps -11th

	BuildingCheckBox PHELPS = new BuildingCheckBox();
	PHELPS.Name  = "PHELP";
	PHELPS.setBounds(530,250,20,20);
	boxes.add(PHELPS);
	transparentPanel.add(PHELPS);
	
	// add Psych 12th

	BuildingCheckBox PSYCH = new BuildingCheckBox();
	PSYCH.Name = "PSYCH";
	PSYCH.setBounds(480,520,20,20);
	boxes.add(PSYCH);
	transparentPanel.add(PSYCH);


	//add North hall 13th

	BuildingCheckBox NH = new BuildingCheckBox();
	NH.Name = "NH";
	NH.setBounds(410,326,20,20);
	boxes.add(NH);
	transparentPanel.add(NH);



	//add GIRVETZ 14th 

	BuildingCheckBox GIRV = new BuildingCheckBox();
	GIRV.Name = "GIRV";
	GIRV.setBounds(380,420,20,20);
	boxes.add(GIRV);
	transparentPanel.add(GIRV);


	//add Events Center 15th

	BuildingCheckBox EC = new BuildingCheckBox();
	EC.Name = "EVENT CENTR";
	EC.setBounds(130, 440, 20,20);
	boxes.add(EC);
	transparentPanel.add(EC);

	//****END OF BUILDINGS*****

	//add explicit exit instructions

	exitExplicit.setEditable(false);
	exitExplicit.setText("Close window to exit program");
	exitExplicit.setBounds(540,10,300,20);
	transparentPanel.add(exitExplicit);
	
	//add TextArea that  asks for users selection
	resultText.setEditable(false);
	resultText.setBounds(540,40,300,140);
	resultText.setText("Click two buildings and select preffered \n method of transportation");
	transparentPanel.add(resultText);
	
	//Add calculate button that calls Calculuate((
	
	JButton CalcWalk = new JButton("Calculate Walking");
	CalcWalk.setBounds(20,20,190,30);
	transparentPanel.add(CalcWalk);
	CalcWalk.addActionListener(new CalcWalkListener());
	
	JButton CalcBike = new JButton("Calculate Biking");
	CalcBike.setBounds(20,60,190,30);
	transparentPanel.add(CalcBike);
	CalcBike.addActionListener(new CalcBikeListener());


	 JButton Calc747 = new JButton("Calculate 747");
	 Calc747.setBounds(20,100,140,30);
	 transparentPanel.add(Calc747);
	 Calc747.addActionListener(new Calc747Listener());

	 JButton Clear  = new JButton("Clear Boxes");
	 Clear.setBounds(20,140, 140,30);
	 transparentPanel.add(Clear);
	 Clear.addActionListener(new ClearListener());
	 
	
    }
    class ClearListener implements ActionListener{
	public void actionPerformed( ActionEvent event){
	    for(int i = 0; i < boxes.size(); i++){
		boxes.get(i).setSelected(false);
	    }
	}
    }
   
    class Calc747Listener implements ActionListener {
	public void actionPerformed(ActionEvent event){
	  
		getSelectedBuildings();
		if(numSelected == 2){
		    UCSBWalk.calc747(selected[0].Name, selected[1].Name);
		resultText.setText(UCSBWalk.result);
		}
		else if(numSelected > 2)
		    resultText.setText("You clicked more than two buildings!");

		else
		    resultText.setText("You need to click two buildings!");
				      
	    
	}
	
    }
            
    
    class CalcWalkListener implements ActionListener {
	public void actionPerformed(ActionEvent event){
	  
		getSelectedBuildings();
		if(numSelected == 2){
		    UCSBWalk.calculate(selected[0].Name, selected[1].Name, "walking");
		resultText.setText(UCSBWalk.result);
		}
		else if(numSelected > 2)
		    resultText.setText("You clicked more than two buildings!");

		else
		    resultText.setText("You need to click two buildings!");
				      
	    
	}
	
    }
    
    class CalcBikeListener implements ActionListener {
	public void actionPerformed(ActionEvent event){

		getSelectedBuildings();
		if(numSelected == 2){
		    UCSBWalk.calculate(selected[0].Name, selected[1].Name, "biking");
		    resultText.setText(UCSBWalk.result);
		}

		else if(numSelected > 2 )
		    resultText.setText("You clicked more than two buildings!");
		else
		    resultText.setText("You need to click two buildings!");


	}
	
	
    }
    
 
    
    
    
    
    public void getSelectedBuildings(){
	numSelected =0;
	int firstSel = 0;
	int secSel = 0;
	for(int i =0; i < boxes.size(); i++){
	    if(boxes.get(i).isSelected()){
		numSelected++;
		if( firstSel ==0)
		    firstSel =i;
		else
		    secSel = i;
	       
	    }
	
	   
	   
		selected[0] = boxes.get(firstSel);
		selected[1] = boxes.get(secSel);
		   
		
    }
    }
    

    
    public static void main(String[] args)
    {
	MapGui map = new MapGui();
	map.setSize(850, 1050); 
	map.setVisible(true);
	
	
    }
    
    
}
