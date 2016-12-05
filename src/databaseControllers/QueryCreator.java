package databaseControllers;

import java.util.List;

public class QueryCreator {
	
	private static String AND_DELIMITER = ",";
    private static String OR_DELIMITER = " or ";

    public QueryCreator() {
    }

    public String getQueryString(List<String> columnNames, List<String> boundingParameters) {
        if (columnNames.size() != boundingParameters.size()) {
            return null;
        }

        StringBuilder outputString = new StringBuilder("");
        for (int i = 0; i < columnNames.size(); i++) {
            if (boundingParameters.get(i) != null && boundingParameters.get(i).compareTo("") != 0) {
                if (outputString.toString().compareTo("") != 0) {
                    outputString.append(" and ");
                }
                String[] multiAndParameter = parseMultiParameter(boundingParameters.get(i), AND_DELIMITER);
                for (int j = 0; j < multiAndParameter.length; j++) {
                    if(j > 0){
                        outputString.append(" and ");
                    }
                    String[] orParameter = parseMultiParameter(multiAndParameter[j], OR_DELIMITER);
                    
                    for(int k = 0; k < orParameter.length; k++){
                        outputString.append(columnNames.get(i));
                        outputString.append(orParameter[k]);
                        if(k < orParameter.length-1){
                            outputString.append(" or ");
                        }
                    }
                }
            }
        }

        if(outputString.toString().compareTo("")!=0){
            outputString.insert(0, " where ");
        }
        
        return outputString.toString();
    }

    public String[] parseMultiParameter(String parameter, String delimiter) {
        String[] outputString = null;
        outputString = parameter.split(delimiter);
        return outputString;
    }
}
