package shopping.util;

import java.io.InputStream;
import java.io.Reader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  class DummyNRowCol extends DummySimplest {
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	private class DummySimplestMetaData implements ResultSetMetaData {

		public String getCatalogName(int column) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		public String getColumnClassName(int column) throws SQLException {
			return "java.lang.String";
		}

		public int getColumnCount() throws SQLException {
			return numCols;
		}

		public int getColumnDisplaySize(int column) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		public String getColumnLabel(int column) throws SQLException {
			return String.format("%s%d", "Column", column);
		}

		public String getColumnName(int column) throws SQLException {
			return String.format("%s%d", "Column", column);
		}

		public int getColumnType(int column) throws SQLException {
			return Types.VARCHAR;
		}

		public String getColumnTypeName(int column) throws SQLException {
			return "VARCHAR";
		}

		public int getPrecision(int column) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		public int getScale(int column) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		public String getSchemaName(int column) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		public String getTableName(int column) throws SQLException {
			if (column != 1) {
				throw new SQLException("Index can only be 1 for this metadata");
			}

			return "DummyTable";
		}

		public boolean isAutoIncrement(int column) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean isCaseSensitive(int column) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean isCurrency(int column) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean isDefinitelyWritable(int column) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		public int isNullable(int column) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		public boolean isReadOnly(int column) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean isSearchable(int column) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean isSigned(int column) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean isWritable(int column) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public <T> T unwrap(Class<T> iface) throws SQLException {
			return null;
		}

		@Override
		public boolean isWrapperFor(Class<?> iface) throws SQLException {
			return false;
		}
	}

	private List<List<String>> data;

	private int numCols;

	private int numRows;

	private int rowPointer = -1;
	
	/**
	 * @param numRows
	 *            How many rows do we want?
	 * @param numCols
	 *            How many cols do we want?
	 */
	public DummyNRowCol(int numRows, int numCols) {
		super();
		this.numRows = numRows;
		this.numCols = numCols;
		data = new ArrayList<List<String>>(numRows);
		fillData(data);
	}

	private void fillData(List<List<String>> data) {
		for (int i = 0; i < numRows; i++) {
			List<String> row = new ArrayList<String>(numCols);
			data.add(row);
			for (int j = 0; j < numCols; j++) {
				String val = Integer.toString(
						(int) (Math.random() * Integer.MAX_VALUE), 36);
				row.add(val);
			}

		}

	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException {
		return new DummySimplestMetaData();
	}

	@Override
	public Object getObject(int columnIndex) throws SQLException {
		return data.get(rowPointer).get(columnIndex - 1);
	}

	@Override
	public RowId getRowId(int columnIndex) throws SQLException {
		return null;
	}

	@Override
	public RowId getRowId(String columnLabel) throws SQLException {
		return null;
	}

	@Override
	public void updateRowId(int columnIndex, RowId x) throws SQLException {

	}

	@Override
	public void updateRowId(String columnLabel, RowId x) throws SQLException {

	}

	@Override
	public int getHoldability() throws SQLException {
		return 0;
	}

	@Override
	public boolean isClosed() throws SQLException {
		return false;
	}

	@Override
	public void updateNString(int columnIndex, String nString) throws SQLException {

	}

	@Override
	public void updateNString(String columnLabel, String nString) throws SQLException {

	}

	@Override
	public void updateNClob(int columnIndex, NClob nClob) throws SQLException {

	}

	@Override
	public void updateNClob(String columnLabel, NClob nClob) throws SQLException {

	}

	@Override
	public NClob getNClob(int columnIndex) throws SQLException {
		return null;
	}

	@Override
	public NClob getNClob(String columnLabel) throws SQLException {
		return null;
	}

	@Override
	public SQLXML getSQLXML(int columnIndex) throws SQLException {
		return null;
	}

	@Override
	public SQLXML getSQLXML(String columnLabel) throws SQLException {
		return null;
	}

	@Override
	public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {

	}

	@Override
	public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {

	}

	@Override
	public String getNString(int columnIndex) throws SQLException {
		return null;
	}

	@Override
	public String getNString(String columnLabel) throws SQLException {
		return null;
	}

	@Override
	public Reader getNCharacterStream(int columnIndex) throws SQLException {
		return null;
	}

	@Override
	public Reader getNCharacterStream(String columnLabel) throws SQLException {
		return null;
	}

	@Override
	public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {

	}

	@Override
	public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {

	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {

	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {

	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {

	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException {

	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException {

	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {

	}

	@Override
	public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {

	}

	@Override
	public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {

	}

	@Override
	public void updateClob(int columnIndex, Reader reader, long length) throws SQLException {

	}

	@Override
	public void updateClob(String columnLabel, Reader reader, long length) throws SQLException {

	}

	@Override
	public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {

	}

	@Override
	public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {

	}

	@Override
	public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {

	}

	@Override
	public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {

	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {

	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {

	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x) throws SQLException {

	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException {

	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException {

	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {

	}

	@Override
	public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {

	}

	@Override
	public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {

	}

	@Override
	public void updateClob(int columnIndex, Reader reader) throws SQLException {

	}

	@Override
	public void updateClob(String columnLabel, Reader reader) throws SQLException {

	}

	@Override
	public void updateNClob(int columnIndex, Reader reader) throws SQLException {

	}

	@Override
	public void updateNClob(String columnLabel, Reader reader) throws SQLException {

	}

	@Override
	public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
		return null;
	}

	@Override
	public <T> T getObject(String columnLabel, Class<T> type) throws SQLException {
		return null;
	}

	@Override
	public String getString(int columnIndex) throws SQLException {
		return data.get(rowPointer).get(columnIndex - 1);
	}

	@Override
	public boolean next() throws SQLException {
		rowPointer++;
		return rowPointer < numRows;
	}

}
