package databaseControllers;

import java.util.List;

/**
 * Parser of passed parameters to query string
 */
public class QueryCreator {

	private static String AND_DELIMITER = ",";				//logical end delimiter
	private static String OR_DELIMITER = " or ";			//logical or delimiter

	public QueryCreator() {
	}
	
	/**
	 * Build query text from column names, select parameters and order by column name
	 * @param columnNames column names of selected entity
	 * @param boundingParameters list of parameters for selecting
	 * @param orderBy order by column name
	 * @return return string with appropriate query text
	 */
	public String getQueryString(List<String> columnNames, List<String> boundingParameters, String orderBy) {
		if (columnNames == null || boundingParameters == null) {
			return "";
		}

		if (columnNames.size() != boundingParameters.size()) {
			return null;
		}

		StringBuilder outputString = new StringBuilder("");
		for (int i = 0; i < columnNames.size(); i++) {
			
			//for every column check, if there is some bounding arameter for this column
			if (boundingParameters.get(i) != null && boundingParameters.get(i).compareTo("") != 0) {
				if (outputString.toString().compareTo("") != 0) {
					outputString.append(" and ");
				}
				
				//parse parameters by and delimiter
				String[] multiAndParameter = parseMultiParameter(boundingParameters.get(i), AND_DELIMITER);
				for (int j = 0; j < multiAndParameter.length; j++) {
					if (j > 0) {
						outputString.append(" and ");
					}
					
					//parse every part of and relationship with or delimiter
					String[] orParameter = parseMultiParameter(multiAndParameter[j], OR_DELIMITER);

					for (int k = 0; k < orParameter.length; k++) {
						outputString.append(columnNames.get(i));
						outputString.append(orParameter[k]);
						if (k < orParameter.length - 1) {
							outputString.append(" or ");
						}
					}
				}
			}
		}
		
		//if output is not empty, get where before output query
		if (outputString.toString().compareTo("") != 0) {
			outputString.insert(0, " where ");
		}
		
		//add order by to query, if this parameter is not null
		if (orderBy != null) {
			outputString.append(" order by ");
			outputString.append(orderBy);
		}

		return outputString.toString();
	}

	/**
	 * Parse string by attributed delimiter and return result- String[]
	 */
	public String[] parseMultiParameter(String parameter, String delimiter) {
		String[] outputString = null;
		outputString = parameter.split(delimiter);
		return outputString;
	}
}
