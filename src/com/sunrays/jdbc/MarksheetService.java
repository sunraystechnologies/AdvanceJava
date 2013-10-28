package com.sunrays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sunrays.dto.MarksheetDTO;

/*
 * copyright (c) sunRays Technologies Indore
 * @author: sunRays Developer
 * @url : www.sunrays.co.in
 *
 */

public class MarksheetService {

	Connection conn = null;

	Statement stmt = null;

	public MarksheetService() {

		try {

			ResourceBundle rb = ResourceBundle
					.getBundle("com.jdbc.messages");

			String driverName = rb.getString("database.driver");

			Class.forName(driverName);

			Connection conn = DriverManager.getConnection(rb
					.getString("database.url"), rb.getString("database.user"),
					rb.getString("database.password"));

			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunrays.services.MarksheetService#getMarkSheet(java.lang.String)
	 */
	public MarksheetDTO getMarkSheet(String rollNo) throws Exception {
		ResultSet rs = null;

		rs = stmt
				.executeQuery("select rollNo,name,physics,chemistry,maths from student where rollNo= '"
						+ rollNo + "'");

		MarksheetDTO marksheetDTO = null;

		if (rs.next()) {
			marksheetDTO = new MarksheetDTO();
			marksheetDTO.setRollNo(rollNo);
			marksheetDTO.setName(rs.getString(2));
			marksheetDTO.setPhysics(rs.getInt(3));
			marksheetDTO.setChemistry(rs.getInt(4));
			marksheetDTO.setMaths(rs.getInt(5));
		}

		return marksheetDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunrays.services.MarksheetService#addMarkSheet(com.sunrays.dto.MarksheetDTO)
	 */

	public int addMarkSheet(MarksheetDTO dto) throws Exception {

		String sql = "insert into Student (rollNo,name, chemistry,physics,maths ) value ( '"
				+ dto.getRollNo()
				+ "', '"
				+ dto.getName()
				+ "' , "
				+ dto.getChemistry()
				+ ", "
				+ dto.getPhysics()
				+ " , "
				+ dto.getMaths() + ") ";

		System.out.println(sql);

		return stmt.executeUpdate(sql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunrays.services.MarksheetService#updateMarkSheet(com.sunrays.dto.MarksheetDTO)
	 */
	public int updateMarkSheet(MarksheetDTO dto) throws Exception {

		String sql = "update student set physics = " + dto.getPhysics()
				+ ", chemistry=" + dto.getChemistry() + ", maths="
				+ dto.getMaths() + ", name='" + dto.getName()
				+ "' where rollNo = '" + dto.getRollNo() + "'";

		System.out.println(sql);

		return stmt.executeUpdate(sql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunrays.services.MarksheetService#deleteMarkSheet(com.sunrays.dto.MarksheetDTO)
	 */
	public int deleteMarkSheet(MarksheetDTO dto) throws Exception {

		String sql = "delete from Student where rollNo= '" + dto.getRollNo()
				+ "'";
		int recordCount = stmt.executeUpdate(sql);

		System.out.println(sql);

		return recordCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunrays.services.MarksheetService#listMarksheet()
	 */
	public ArrayList listMarksheet() throws Exception {

		ArrayList marksheetList = new ArrayList();

		ResultSet rs = null;

		String sql = "select rollNo,name,physics,chemistry,maths from student order by rollNo";

		System.out.println(sql);

		rs = stmt.executeQuery(sql);

		MarksheetDTO marksheetDTO = null;

		while (rs.next()) {

			marksheetDTO = new MarksheetDTO();
			marksheetDTO.setRollNo(rs.getString(1));
			marksheetDTO.setName(rs.getString(2));
			marksheetDTO.setPhysics(rs.getInt(3));
			marksheetDTO.setChemistry(rs.getInt(4));
			marksheetDTO.setMaths(rs.getInt(5));

			marksheetList.add(marksheetDTO);
		}

		return marksheetList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunrays.services.MarksheetService#getMeritList()
	 */
	public ArrayList getMeritList() throws Exception {

		ArrayList marksheetList = new ArrayList();

		ResultSet rs = null;

		rs = stmt
				.executeQuery("select rollNo,name,physics,chemistry,maths, (physics+chemistry+ maths) as total  from student order by total desc");

		MarksheetDTO marksheetDTO = null;

		int count = 0;

		while (rs.next()) {

			marksheetDTO = new MarksheetDTO();
			marksheetDTO.setRollNo(rs.getString(1));
			marksheetDTO.setName(rs.getString(2));
			marksheetDTO.setPhysics(rs.getInt(3));
			marksheetDTO.setChemistry(rs.getInt(4));
			marksheetDTO.setMaths(rs.getInt(5));

			marksheetList.add(marksheetDTO);

			count++;
			if (count == 10) {
				break;
			}

		}

		return marksheetList;
	}

	@Override
	protected void finalize() throws Exception {
		// TODO Auto-generated method stub
		stmt.close();
		conn.close();
	}

}
