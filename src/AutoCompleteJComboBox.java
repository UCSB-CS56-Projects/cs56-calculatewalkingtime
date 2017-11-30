// JComboBox with an autocomplete drop down menu.
// @Author Jack Liu and Charles Gu


public class AutocompleteJComboBox extends JComboBox{
    private final Searchable<String,String> searchable;
    public AutocompleteJComboBox(Searchable<String,String> s){
	super();//superclass
	this.searchable = s;
	setEditable(true);
	Component c = getEditor().getEditorComponent();
	if ( c instanceof JTextComponent ){
	    final JTextComponent tc = (JTextComponent)c;
	    tc.getDocument().addDocumentListener(new DocumentListener(){
		    public void run() {
			    List<String> founds = new ArrayList<String>(searchable.search(tc.getText()));
			    Set<String> foundSet = new HashSet<String>();
			    for ( String s : founds ){
				foundSet.add(s.toLowerCase());
			    }
			    Collections.sort(founds);//sort alphabetically
			    setEditable(false);
			    removeAllItems();
			    //if founds contains the search text, then only add once.
			    if ( !foundSet.contains( tc.getText().toLowerCase()) ){
				addItem( tc.getText() );
			    }
			    for (String s : founds) {
				addItem(s);
			    }
			    setEditable(true);
			    setPopupVisible(true);
			}
			    });
		}
	});

}
