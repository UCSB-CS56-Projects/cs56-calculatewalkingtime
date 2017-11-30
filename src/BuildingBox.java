public class BuildingBox extends MapGui {
    public void Buildings(String name, int x, int y, int l, int w) {
	BuildingCheckBox name = new BuildingCheckBox();
	name.Name = "name";
	name.setBounds(x,y,l,w);
	boxes.add(name);
	transparentPanel.add(name);
    }
}
