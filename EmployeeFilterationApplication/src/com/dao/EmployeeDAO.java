package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.EmployeeDTO;
import com.util.ConnectionFactory;

public class EmployeeDAO {

	private static String INSERT_EMP="insert into empdetails(empname,empemail,empgender,empdept,empexp) values(?,?,?,?,?)";
	
	private static String RETRIEVE_EMP="select * from empdetails where empdept=? and empgender=? and empexp=? and 1==1";
	
	public Boolean saveEmployee(EmployeeDTO dto) throws SQLException
	{
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(INSERT_EMP);
		pstmt.setString(1,dto.getEmpName());
		pstmt.setString(2,dto.getEmpEmail());
		pstmt.setString(3, dto.getEmpGender());
		pstmt.setString(4,dto.getEmpDept());
		pstmt.setInt(5,dto.getEmpExp());
		
		int result = pstmt.executeUpdate();
		return result>0;
	}
	
	public List<EmployeeDTO> getEmployee(EmployeeDTO dto) throws SQLException
	{
		List<EmployeeDTO> emplist=new ArrayList<>();
		Connection con=ConnectionFactory.getConnection();
		StringBuffer sb=new StringBuffer();
		sb.append("select * from empdetails where 1=1");
		if(dto.getEmpDept()!=null)
		{
			sb.append(" and empdept=?");
		}
		if(dto.getEmpGender()!=null)
		{
			sb.append(" and empgender=?");
		}
		if(dto.getEmpExp()!=null)
		{
			sb.append(" and empexp=?");			
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		Integer index=1;
		if(dto.getEmpDept()!=null)
		{
			pstmt.setString(index,dto.getEmpDept());
			index++;
		}
		if(dto.getEmpGender()!=null)
		{
			pstmt.setString(index,dto.getEmpGender());
			index++;
		}
		if(dto.getEmpExp()!=null)
		{
			pstmt.setInt(index,dto.getEmpExp());
		}
		/*if(dto.getEmpDept()!=null)
		{
			pstmt.setString(1, dto.getEmpDept());
		}
		if(dto.getEmpDept()==null && dto.getEmpGender()!=null)
		{
			pstmt.setString(2, dto.getEmpGender());			
		}
		else if(dto.getEmpGender()!=null)
		{
			pstmt.setString(1,dto.getEmpGender());
		}
		if(dto.getEmpDept()==null && dto.getEmpGender()==null && dto.getEmpExp()!=null)
		{
			pstmt.setInt(1, dto.getEmpExp());			
		}
		else if((dto.getEmpDept()==null && dto.getEmpGender()!=null) && (dto.getEmpDept()!=null && dto.getEmpGender()==null) && dto.getEmpExp()!=null)
		{
			pstmt.setInt(2, dto.getEmpExp());
		}
		else if(dto.getEmpDept()!=null && dto.getEmpGender()!=null && dto.getEmpExp()!=null)
		{
			pstmt.setInt(3,dto.getEmpExp());
		}*/
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
		    EmployeeDTO empdto=new EmployeeDTO();
		    empdto.setEmpId(rs.getInt(1));
		    empdto.setEmpName(rs.getString(2));
		    empdto.setEmpEmail(rs.getString(3));
		    empdto.setEmpGender(rs.getString(4));
		    empdto.setEmpDept(rs.getString(5));
		    empdto.setEmpExp(rs.getInt(6));
            emplist.add(empdto);
		}
		return emplist;
	}
	
}
