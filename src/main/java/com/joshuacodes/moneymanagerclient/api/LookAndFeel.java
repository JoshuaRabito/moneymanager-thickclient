package com.joshuacodes.moneymanagerclient.api;

public enum LookAndFeel {
	ALUMINIUM("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel"),
	GRAPHITE("com.jtattoo.plaf.graphite.GraphiteLookAndFeel"),  
	HIFI("com.jtattoo.plaf.hifi.HiFiLookAndFeel"),
	LUNA("com.jtattoo.plaf.luna.LunaLookAndFeel");
	private String classPath;

	LookAndFeel(String lookAndFeel) {
		this.classPath = lookAndFeel;
	}

	public String getLookAndFeel() {
		return classPath;
	}

}
