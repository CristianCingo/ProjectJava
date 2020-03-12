package it.univpm.Project.dataset;

public class Metadati {
private String alias, sourceF, type;
	
	public Metadati(String alias, String sourceField, String type)
	{
		this.alias = alias;
		this.sourceF = sourceField;
		this.type = type;
	}

	public String getAlias() {
		return alias;
	}

	public String getSourceField() {
		return sourceF;
	}

	public String getType() {
		return type;
	}

}
