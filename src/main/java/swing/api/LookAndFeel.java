package swing.api;

public enum LookAndFeel {
	ALUMINIUM("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel"),
	GRAPHITE("com.jtattoo.plaf.graphite.GraphiteLookAndFeel"),  
	HIFI("com.jtattoo.plaf.hifi.HiFiLookAndFeel"),
	LUNA("com.jtattoo.plaf.luna.LunaLookAndFeel"),
	SEAGLASS("com.seaglasslookandfeel.SeaGlassLookAndFeel");

	private String lookAndFeel;

	LookAndFeel(String lookAndFeel) {
		this.lookAndFeel = lookAndFeel;
	}

	public String getLookAndFeel() {
		return lookAndFeel;
	}

}
