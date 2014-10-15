package com.mushroom;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class mysql {
	private String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/";
	private String dbname = "app_mocamoca";
	private String drivername = "com.mysql.jdbc.Driver";
	private String username = "moyooy1ozw";
	private String password = "23z24l11hl44mjiixzjyzkj1zj012zh53j0k3jk2";
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(drivername);
			con = DriverManager.getConnection(url + dbname, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public void closeConnection(Connection con) {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public List<book> getlistb(int authorid) {
		List<book> list = new ArrayList<book>();
		try {
			Connection mycon = this.getConnection();
			Statement st = mycon.createStatement();
			st.execute("select * from book where authorid = '"
					+ String.valueOf(authorid) + "'");
			while (true) {
				ResultSet set = st.getResultSet();
				if (set != null) {
					while (set.next()) {
						book book = new book();
						book.setAuthorid(authorid);
						book.setIsbn(set.getString("isbn"));
						book.setPrice(Double.valueOf(set.getString("price")));
						book.setPublishdate(set.getString("publishdate"));
						book.setPublisher(set.getString("publisher"));
						book.setTitle(set.getString("title"));
						list.add(book);
						continue;
					}
					st.getMoreResults();
				}
				break;
			}
			this.closeConnection(mycon);
		} catch (Exception e) {
		}
		return list;
	}

	public author geta(int authorid) {
		author author = new author();
		try {
			Connection mycon = this.getConnection();
			Statement st = mycon.createStatement();
			ResultSet set = st
					.executeQuery("select * from author where authorid = "
							+ String.valueOf(authorid) + ";");
			while (set.next()) {
				author.setAge(Integer.valueOf(set.getString("age")));
				author.setAuthorid(authorid);
				author.setCountry(set.getString("country"));
				author.setName(set.getString("name"));
			}
			this.closeConnection(mycon);
		} catch (Exception e) {
		}
		return author;
	}

	public author geta(String name) {
		author author = new author();
		try {
			Connection mycon = this.getConnection();
			Statement st = mycon.createStatement();
			ResultSet set = st
					.executeQuery("select * from author where name = '" + name
							+ "';");
			while (set.next()) {
				author.setAge(Integer.valueOf(set.getString("age")));
				author.setAuthorid(Integer.valueOf(set.getString("authorid")));
				author.setCountry(set.getString("country"));
				author.setName(name);
			}
			this.closeConnection(mycon);
		} catch (Exception e) {
		}
		return author;
	}

	public book getb(String isbn) {
		book book = new book();
		try {
			Connection mycon = this.getConnection();
			Statement st = mycon.createStatement();
			ResultSet set = st.executeQuery("select * from book where isbn = '"
					+ isbn + "';");
			while (set.next()) {
				book.setAuthorid(Integer.valueOf(set.getString("authorid")));
				book.setIsbn(isbn);
				book.setPrice(Double.valueOf(set.getString("price")));
				book.setPublishdate(set.getString("publishdate"));
				book.setPublisher(set.getString("publisher"));
				book.setTitle(set.getString("title"));
			}
			this.closeConnection(mycon);
		} catch (Exception e) {
		}
		return book;
	}

	public void deleteb(String isbn) {
		try {
			Connection mycon = this.getConnection();
			Statement st = mycon.createStatement();
			st.executeUpdate("delete from book where isbn='" + isbn + "'");
			this.closeConnection(mycon);
		} catch (Exception e) {
		}
	}

	public void initdb() {
		try {
			Class.forName(drivername);
			Connection con = DriverManager.getConnection(url, username,
					password);
			Statement st = con.createStatement();
			//st.executeUpdate("drop database if exists " + dbname);
			//st.executeUpdate("create database " + dbname);
			st.executeUpdate("use " + dbname);
			st.executeUpdate("drop table if exists author");
			st.executeUpdate("drop table if exists book");
			st.executeUpdate("create table if not exists author("
					+ "authorid int(3) not null primary key auto_increment,"
					+ "name char(20)," + "age int(3)," + "country char(20))");
			st.executeUpdate("create table if not exists book("
					+ "isbn char(20) primary key," + "title char(20),"
					+ "authorid int(3),"
					+ "foreign key(authorid) references author(authorid),"
					+ "publisher char(20)," + "publishdate char(20),"
					+ "price double(6,2))");
			PreparedStatement psa = con
					.prepareStatement("INSERT INTO author VALUES(null,?,?,?)");
			for (int i = 0; i < 3; i++) {
				psa.setString(1, "Commander" + String.valueOf(i));
				psa.setInt(2, i + 20);
				psa.setString(3, "China");
				psa.executeUpdate();
			}
			PreparedStatement psb = con
					.prepareStatement("INSERT INTO book VALUES(?,?,?,?,?,?)");
			for (int i = 0; i < 20; i++) {
				psb.setString(1, "001409-" + i / 10 + i % 10);
				psb.setString(2, i < 10 ? i+"99 Death Cups":i+"9 Ways Cook Mush");
				psb.setLong(3, i % 3 + 1);
				psb.setString(4, "high education");
				psb.setString(5, "2014-09-" + i / 10 + i % 10);
				psb.setDouble(6, 200 - (double) i * 3);
				psb.executeUpdate();
			}
			this.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initdb2() {
		try {
			Class.forName(drivername);
			Connection con = DriverManager.getConnection(url, username,
					password);
			Statement st = con.createStatement();
			st.executeUpdate("drop database if exists " + dbname);
			st.executeUpdate("create database " + dbname);
			st.executeUpdate("use " + dbname);
			st.executeUpdate("create table if not exists author("
					+ "authorid int(3) not null primary key auto_increment,"
					+ "name char(20)," + "age int(3)," + "country char(20))");
			st.executeUpdate("create table if not exists book("
					+ "isbn char(20) primary key," + "title char(20),"
					+ "authorid int(3),"
					+ "foreign key(authorid) references author(authorid),"
					+ "publisher char(20)," + "publishdate char(20),"
					+ "price double(6,2))");
			PreparedStatement psa = con
					.prepareStatement("INSERT INTO author VALUES(null,?,?,?)");
			for (int i = 0; i < 3; i++) {
				psa.setString(1, "Commander" + String.valueOf(i));
				psa.setInt(2, i + 20);
				psa.setString(3, "China");
				psa.executeUpdate();
			}
			PreparedStatement psb = con
					.prepareStatement("INSERT INTO book VALUES(?,?,?,?,?,?)");
			for (int i = 0; i < 20; i++) {
				psb.setString(1, "001409-" + i / 10 + i % 10);
				psb.setString(2, i < 10 ? i+"99 Death Cups":i+"9 Ways Cook Mush");
				psb.setLong(3, i % 3 + 1);
				psb.setString(4, "high education");
				psb.setString(5, "2014-09-" + i / 10 + i % 10);
				psb.setDouble(6, 200 - (double) i * 3);
				psb.executeUpdate();
			}
			this.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
