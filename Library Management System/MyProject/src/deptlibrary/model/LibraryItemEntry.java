package deptlibrary.model;

import java.util.List;

public class LibraryItemEntry {

	private Integer id;
	
	private Integer sid;
	
	private String type;
	
	private String name;
	
	private String info;
	
	private String available;
	
	private int number;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String ItemId;
	
	private String cin;
	
	private String sname;
	
	private String bdate;
	
	private String rdate;
	
	private String dbb;
	
	private String username;
	
	private String password;
	
	public String getDbb() {
		return dbb;
	}

	public void setDbb(String dbb) {
		this.dbb = dbb;
	}

	public List<LibraryItemEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<LibraryItemEntry> entries) {
		this.entries = entries;
	}

	List<LibraryItemEntry> entries;
	
	public void decrementNumber(){
		number--;
	}
	
	public void incrementNumber(){
		number++;
	}
	
	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getItemId() {
		return ItemId;
	}

	public void setItemId(String itemId) {
		ItemId = itemId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public LibraryItemEntry(){}
	
	public LibraryItemEntry(Integer id, String type, String name, String info, String available, int number, String dbb){
		
		this.id = id;
		this.type = type;
		this.name = name;
		this.info = info;
		this.available = available;
		this.number = number;
		this.dbb = dbb;
		
	}
	
	public LibraryItemEntry(Integer id, String type){
		
		this.id = id;
		this.type = type;
	}
	
	public LibraryItemEntry (int number){
		
		this.number = number;
	}
	
	public LibraryItemEntry(Integer id, Integer sid,String cin, String sname, String bdate, String rdate, String dbb){
	
		this.id = id;
		this.sid=sid;
		this.cin = cin;
		this.sname = sname;
		this.bdate = bdate;
		this.rdate = rdate;
		this.dbb = dbb;
	}

	

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}
	
	
}
