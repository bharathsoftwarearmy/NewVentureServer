package com.bijesh.donateblood.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bijesh.donateblood.TableConstants;
import com.bijesh.donateblood.database.DataStore;
import com.bijesh.donateblood.models.Installation;
import com.bijesh.donateblood.utils.ResponseUtil;

public class InstallationDAO extends DataStore implements TableConstants{
	
	
	public boolean isUserAlreadyInstalled(Installation installation){
		int retval = 0;
		try{
		dbConnect();
		
		String query = "select count(*) from "+ INSTALLATION_TABLE_NAME +" where "+INSTALLATION_COLUMN_UNIQUEID+" = '"
		+installation.getUniqueId()+"'";
		
		System.out.println("query : "+query);
		
//		PreparedStatement statement = getPrepStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
//		statement.setString(1, installation.getUniqueId());
		
		ResultSet rs = dbQuery(query);
		
		if(rs != null){
			while(rs.next()){
				
				retval = rs.getInt(1);
				System.out.println("after return val "+retval);
			}
		}
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		boolean retFlag = retval > 0;
		System.out.println("$$ retFlag "+retFlag);
		return retval > 0;
	}
	
    public String insertDeviceInstallation(Installation installation){
        try{
        dbConnect();
    	String query ="INSERT INTO "+INSTALLATION_TABLE_NAME+" ("+INSTALLATION_COLUMN_UNIQUEID+
    			  ","+INSTALLATION_COLUMN_TIME+","+INSTALLATION_COLUMN_TIMEZONE+") Values (?,?,?)" ;
    	
		PreparedStatement statement = getPrepStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
		statement.setString(1, installation.getUniqueId());
		statement.setString(2,installation.getTime());
		statement.setString(3,installation.getTimezone());
		
		dbExecutePrep();
		System.out.println("$$$$ Row inserted $$$$$$$");
		return ResponseUtil.getSuccessResponse();
        }catch (SQLException e){
        	e.printStackTrace();
        }
        return null;
    }
    
    

}
