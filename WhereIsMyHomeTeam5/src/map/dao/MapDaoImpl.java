package map.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import map.dto.MapDto;
import util.DBUtil;

public class MapDaoImpl implements MapDao{
	private static MapDao mapdao = new MapDaoImpl();
	private DBUtil dbutil;
	
	private MapDaoImpl() {
		dbutil = DBUtil.getInstance();
	}
	
	public static MapDao getMapDao() {
		return mapdao;
	}

	 
	public List<MapDto> selectmap(String sidoName, String gugunName, String dongName) throws Exception {	
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<MapDto> list = new ArrayList<MapDto>();
		
		try { 

			MapDto m = null;
			con = dbutil.getConnection();
			String q = "Select * from baseaddress where sidoName= ? , gugunName= ?, dongName= ?";// 3
			st = con.prepareStatement(q);
			st.setString(1, sidoName);
			st.setString(2, gugunName);
			st.setString(3, dongName);  
			
			st = con.prepareStatement(q);
			rs = st.executeQuery();
	 
			while (rs.next()) {
				m = new MapDto(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6));
				list.add(m);				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

	
		DBUtil.close(rs, st, con); 
		return list; 
	}

 
	
	public ArrayList<String> getsido(){
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null; 
		ArrayList<String> lst = new ArrayList<>();
		try {  
			con = dbutil.getConnection(); 
			String q = "SELECT distinct sidoName FROM dongcode"; 
			st = con.prepareStatement(q);   
			rs = st.executeQuery();
			
			while(rs.next()) {  
				lst.add(rs.getString("sidoName"));
			}
			
			dbutil.close(con,st, rs);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return lst; 
	}
	
	
	public ArrayList<String> getgugun(String sidoName){
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null; 
		ArrayList<String> lst = new ArrayList<>();
		System.out.println(sidoName);
		
		try {  
			con = dbutil.getConnection(); 
			String q = "SELECT distinct gugunName FROM dongcode where sidoName= ? ";
			st.setString(1, sidoName);
			st = con.prepareStatement(q);   
			rs = st.executeQuery();
			
			while(rs.next()) {  
				lst.add(rs.getString("gugunName"));
			}
			
			dbutil.close(con,st, rs);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return lst; 
	}
	
	
	public ArrayList<String> getdong(String gugunName){
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null; 
		ArrayList<String> lst = new ArrayList<>();
		
		try {  
			con = dbutil.getConnection(); 
			String q  = "SELECT distinct dongName FROM dongcode where gugunName=? ";
			st.setString(1, gugunName);
			st = con.prepareStatement(q);   
			rs = st.executeQuery();
			
			while(rs.next()) {  
				lst.add(rs.getString("dongName"));
			}
			
			dbutil.close(con,st, rs);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return lst; 
	}
	
  
	public HashMap<String, HashMap<String, ArrayList<String>>> sidogugunmap(){ 
		HashMap<String, HashMap<String, ArrayList<String>>>datamap = new HashMap<String, HashMap<String, ArrayList<String>>>();
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null; 
		
		try {  
			con = dbutil.getConnection(); 
			String q = "SELECT distinct sidoName FROM dongcode"; 
			st = con.prepareStatement(q);   
			rs = st.executeQuery();
			 
			
			while(rs.next()) {  //시도군 저장
				String sido = rs.getString("sidoName"); 
				
				q = "SELECT distinct gugunName FROM dongcode where sidoName= ? limit 10";
				
				PreparedStatement stgugun = con.prepareStatement(q);   
				stgugun.setString(1, sido);
				ResultSet rsgugun  = stgugun.executeQuery(); 
				
				HashMap<String, ArrayList<String>> gugundonmap = new HashMap<String, ArrayList<String>>();
				 
				while(rsgugun.next()) { 
					String gugun = rsgugun.getString("gugunName"); 
					if(gugun!=null) {
						q = "SELECT distinct dongName FROM dongcode where gugunName=? limit 10";
						
						PreparedStatement stdong = con.prepareStatement(q);   
						stdong.setString(1, gugun);
						ResultSet rsdong  = stdong.executeQuery();  
	
						ArrayList<String> values = new ArrayList<String>();
						
						while(rsdong.next()) {
							String dong = rsdong.getString("dongName");
						
							if(gugun!=null && dong !=null) values.add(dong);
						} 
						
						dbutil.close(stdong,rsdong);
						gugundonmap.put(gugun, values);  
					} 
				}
				dbutil.close(stgugun,rsgugun);
				datamap.put(sido, gugundonmap); 
			};
			
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		
		DBUtil.close(rs, st, con); 
		return datamap; 
		 
	}
 

}
