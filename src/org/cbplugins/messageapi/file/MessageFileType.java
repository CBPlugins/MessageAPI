package org.cbplugins.messageapi.file;

public enum MessageFileType {

	de_DE("de_DE"),
	fr_FR("fr_FR"),
	en_US("en_US"),
	es_ES("es_ES"),
	sv_SE("sv_SE");
	
	private String id;
	
	MessageFileType(String id) {
		this.id = id;
	}
	
	public String getID() {
		return id;
	}
	
	public String getFileName() {
		return id + ".msg";
	}
	
}
