package guiComponents;

import java.util.List;

/**
 * Class for composing tables as output of the selection. 
 */
public class TableComposer {
	private final String tableCellTableHead = "<th>%s</th>";			//column names part of table template
	private final String tableCellTableInner = "<td>%s</td>";			//inner part of table template
	private final String tableOpenTag = "<table border=\"1\">";			//init part of table
	private final String tableCloseTag = "</table>";					//end part of table
	private final String rowOpenTag = "<tr>";							//new row of table
	private final String rowCloseTag = "</tr>";							//end row of table

	private String[] columnNames;
	private List<String[]> databaseData;

	/**
	 * Set data list and list with column names
	 */
	public TableComposer(List<String[]> paDatabaseData, List<String> relativeColumnNames) {
		databaseData = paDatabaseData;
		columnNames = new String[relativeColumnNames.size()];

		for (int i = 0; i < relativeColumnNames.size(); i++) {
			columnNames[i] = relativeColumnNames.get(i);
		}
	}

	/**
	 * Compose table row by row and return String with HTML code of output table
	 */
	public String composeDatabaseOutputTable() {
		StringBuilder outPutString = new StringBuilder(tableOpenTag);
		if (columnNames != null) {
			outPutString.append(composeRow(tableCellTableHead, columnNames));

			if (databaseData != null) {
				for (int i = 0; i < databaseData.size(); i++) {
					outPutString.append(composeRow(tableCellTableInner, databaseData.get(i)));
				}
			}
		}
		outPutString.append(tableCloseTag);

		return outPutString.toString();
	}

	/**
	 * Compose one row of table and return StringBuilder with this part
	 */
	private StringBuilder composeRow(String tableCellTemplate, String[] dataSet) {
		StringBuilder outPutString = new StringBuilder(rowOpenTag);
		for (String data : dataSet) {
			outPutString.append(String.format(tableCellTemplate, data));
		}
		outPutString.append(rowCloseTag);

		return outPutString;
	}
}