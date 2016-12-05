package guiComponents;

import java.util.List;

public class TableComposer {
	private final String tableCellTableHead = "<th>%s</th>";
	private final String tableCellTableInner = "<td>%s</td>";
	private final String tableOpenTag = "<table border=\"1\">";
	private final String tableCloseTag = "</table>";
	private final String rowOpenTag = "<tr>";
	private final String rowCloseTag = "</tr>";
	
	private List<String> columnNames;
	private List<String[]> databaseData;
	
	public TableComposer(List<String> paColumnNames, List<String[]> paDatabaseData){
		columnNames = paColumnNames;
		databaseData = paDatabaseData;
	}
	
	public String composeDatabaseOutputTable(){
		StringBuilder outPutString = new StringBuilder(tableOpenTag);
		if(columnNames != null){
			outPutString.append(composeRow(tableCellTableHead, columnNames.toArray(new String[columnNames.size()])));
			
			if(databaseData != null){
				for(String[] dataRow : databaseData){
					outPutString.append(composeRow(tableCellTableInner, dataRow));
				}
			}
		}
		outPutString.append(tableCloseTag);
		
		return outPutString.toString();
	}
	
	private StringBuilder composeRow(String tableCellTemplate, String[] dataSet){
		StringBuilder outPutString = new StringBuilder(rowOpenTag);
		for(String data : dataSet){
			outPutString.append(String.format(tableCellTemplate, data));
		}
		outPutString.append(rowCloseTag);
		
		return outPutString;
	}
}