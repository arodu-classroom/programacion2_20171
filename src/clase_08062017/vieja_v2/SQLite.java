package vieja_v2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLite{
	private Connection conn;
	private Statement statement;
	private String file;
	private String lastError;
	private boolean debug = true;
	private int affectRows;
	private ResultSet lastResulset;
	
	public static int SELECT = 0;
	public static int INSERT = 1;
	public static int UPDATE = 1;
	public static int DELETE = 1;
	
	public SQLite() {
		this.file = "resources/sqlitedemo.db";
		this.connect();
	}
	
	public SQLite(String file){
		this.file = file;
		this.connect();
	}
    
    public Connection getConn(){
		return conn;
	}
    
    public String getFile(){
		return file;
	}
    
    public String getLastError() {
		return lastError;
	}
    
    public int getAffectRows() {
		return affectRows;
	}
    
    public ResultSet getLastResulset() {
		return lastResulset;
	}
    
    public void setFile(String file){
		this.file = file;
	}
    
    public void connect(){
		try{
			Class.forName("org.sqlite.JDBC");
		}catch (ClassNotFoundException e){
	            System.err.println(e.getMessage());
		}		
		try {
			this.conn = DriverManager.getConnection("jdbc:sqlite:"+this.file);
			this.statement = this.conn.createStatement();
		} catch (SQLException e) {
			this.error(e.getMessage());
		}
    }
    
    public void close(){
    	try{
    		this.statement.close();
			this.conn.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
    }
    
    public boolean query(String sql, int type){
    	boolean out;
    	try{
        	switch (type) {
				case 1:
					this.affectRows = statement.executeUpdate(sql);
				break;
				case 0:
					this.lastResulset = statement.executeQuery(sql);
				break;
			}
        	out = true;
        }catch(SQLException e){
        	this.error(e.getMessage());
        	out = false;
        }
        return out;
    }
    
    public ResultSet select(String sql){
       	this.lastResulset = null;
       	this.query(sql, SELECT);
        return this.lastResulset;
    }
    
    public int insert(String sql){
    	this.query(sql, SQLite.INSERT);
    	return this.affectRows;
    }
    
    public int update(String sql){
    	this.query(sql, SQLite.UPDATE);
    	return this.affectRows;
    }
    
    public int delete(String sql){
    	this.query(sql, SQLite.DELETE);
    	return this.affectRows;
    }
    
    private void error(String out){
    	this.lastError = out;
    	this.debug(out, true);
    }
    
    public void debug(String out, boolean error){
    	if(this.debug){
    		if(error){
    			System.err.println(out);
    		}else{
    			System.out.println(out);
    		}
    	}
    }

}
