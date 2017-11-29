import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
// a simple issues library
//import ca.odell.issuezilla.*;
// glazed lists
//import ca.odell.glazedlists.*;
//import ca.odell.glazedlists.swing.*;

public class MapGui extends JFrame
{
    JTextArea exitExplicit = new JTextArea();
    JTextArea resultText =  new JTextArea();
    //ImageIcon ic = new   ImageIcon("map.jpg");
    java.net.URL imgURL = getClass().getResource("/map.jpg");
     ImageIcon ic = new ImageIcon(imgURL);
    JDesktopPane dp = new JDesktopPane();
    JLabel lbl = new JLabel(ic);
    JPanel transparentPanel = new JPanel();
    static ArrayList<BuildingCheckBox> boxes = new ArrayList();
    public String building1, building2, mode;
    int numSelected = 0;
    BuildingCheckBox[] selected = new BuildingCheckBox[2];
    String[] buildingNames;
    public MapGui()
    {
	
	lbl.setBounds(0,0,850,1100); 
	
	
	transparentPanel.setOpaque(false);
	transparentPanel.setBounds(0,0,1000,1000);
	this.setLayout(null);
	transparentPanel.setLayout(null);

	//BUILDINGS ARE:
	//HFH, LIB, CAMPBELL, UCEN, SAN NIC, REC CEN, PHELPS, HSSB, SRB, MARINE BIO, PYSCH, MANZI, NORTH, GIRVETZ, EVENTS CENTER, RGYM, ANCAP HALL 

	makeBuilding("HFH",710,430,20,20);
	makeBuilding("RGYM",246,248,20,20);
	makeBuilding("ANCAP_HALL",590,610,20,20);
	makeBuilding("LIB",460,430,20,20);
	makeBuilding("CAMPB_HALL",475, 246, 20,20);
        makeBuilding("UCEN",370,565,20,20);
        makeBuilding("SAN_NIC",420, 700, 20,20);
	makeBuilding("REC",265,110,20,20);
	makeBuilding("SRB",55, 490,20,20);
        makeBuilding("MARINE",590, 810, 20,20);
	super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	dp.add(lbl,new Integer(50));
	dp.add(transparentPanel,new Integer(350));
	
	setLayeredPane(dp);

        makeBuilding("HSSB",189, 434, 20,20);
        makeBuilding("MANZI",43, 740,20,20);	
	makeBuilding("PHELPS",530,250,20,20);
        makeBuilding("PSYCH",480,520,20,20);
        makeBuilding("NH",410,326,20,20);
        makeBuilding("GIRV",380,420,20,20);
        makeBuilding("EC",130, 440, 20,20);
        makeBuilding("ARTS",260,510,20,20);
        makeBuilding("BIOL2",628,520,20,20);
        makeBuilding("BROIDA",595,380,20,20);
        makeBuilding("BREN",653,470,20,20); 
        makeBuilding("BUCHN_HALL",516,298,20,20);			    
        makeBuilding("CHEM",623,316,20,20);
        makeBuilding("ENGR2",695,346,20,20);
        makeBuilding("KOHN",780,320,20,20);
        makeBuilding("LSB",565,568,20,20);
        makeBuilding("MUSIC",370,517,20,20);
        makeBuilding("NOBLE",550,510,20,20);
        makeBuilding("SAN_MIGEL",370,645,20,20);
	makeBuilding("SAN_RAFEL",110,610,20,20);
        makeBuilding("SANTA_CRUZ",590,680,20,20);
        makeBuilding("SANTA_ROSA",500,610,20,20);
        makeBuilding("WEBB",565,456,20,20);
        makeBuilding("DLG",470,700,20,20);
	//****END OF BUILDINGS*****
	//add explicit exit instructions

	exitExplicit.setEditable(false);
	exitExplicit.setText("Close window to exit program");
	exitExplicit.setBounds(540,10,300,20);
	transparentPanel.add(exitExplicit);
	
	//add TextArea that  asks for users selection
	resultText.setEditable(false);
	resultText.setBounds(540,40,300,140);
	resultText.setText("Click two buildings or\nselect two buildings in the drop down menu\nand select preffered method of transportation");
	transparentPanel.add(resultText);
	
	//Add calculate button that calls UCSBWalk.calculuate()
	
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
	
	
	
	//Add dropdown box that will automatically click the button you want
	buildingNames = new String[boxes.size()];
	namesToStringList();
        JComboBox dropDown = new JComboBox(buildingNames);

	//Requires SwingX support GrazedLists more easily converts
	//http://www.glazedlists.com/
	AutoCompleteJComboBox.decorate(dropDown); //find in method AutoCompleteJComboBox.java
	//AutoCompleteSupport.install(dropDown, GlazedLists.eventListOf(buildingNames));
	
	dropDown.setBounds(300, 20,200,30);	
	transparentPanel.add(dropDown);

	//ActionListener for dropDown
	ActionListener dropDownAction = new ActionListener(){
		public void actionPerformed(ActionEvent e){
		    String selection = (String) dropDown.getSelectedItem();
		    
		    for(int i = 0; i < boxes.size(); i++){
			if (selection == boxes.get(i).Name)
			    boxes.get(i).setSelected(true);
		    }
		}
	    };
	    
	dropDown.addActionListener(dropDownAction);
	    
	
    }
    //ActionListener Classes
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
		    JOptionPane.showMessageDialog(null, "You clicked more than two buildings!", "Two Checkboxes ONLY", JOptionPane.WARNING_MESSAGE);
		else
		    JOptionPane.showMessageDialog(null, "You need to click two buildings!", "Two Checkboxes Please", JOptionPane.WARNING_MESSAGE);
				      
	    
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
		    JOptionPane.showMessageDialog(null, "You clicked more than two buildings!", "Two Checkboxes ONLY", JOptionPane.WARNING_MESSAGE);
		else
		    JOptionPane.showMessageDialog(null, "You need to click two buildings!", "Two Checkboxes Please", JOptionPane.WARNING_MESSAGE);
				      
	    
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
		    JOptionPane.showMessageDialog(null, "You clicked more than two buildings!", "Two Checkboxes ONLY", JOptionPane.WARNING_MESSAGE);
		else
		    JOptionPane.showMessageDialog(null, "You need to click two buildings!", "Two Checkboxes Please", JOptionPane.WARNING_MESSAGE);


	}
	
	
    }
    
 
    //Helper Functions
    
    //function to add all building names into an string array for dropdown menu to use      
    void namesToStringList(){
	for(int i=0; i < boxes.size();i++){
	    buildingNames[i] = boxes.get(i).Name;
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

    //make building method
    public void makeBuilding(String name, int x, int y, int l, int w) {
	    BuildingCheckBox abbrev = new BuildingCheckBox();
	    abbrev.Name = name;
	    abbrev.setBounds(x,y,l,w);
	    boxes.add(abbrev);
	    transparentPanel.add(abbrev);
    }
    
}
