package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Mutter;

public class DocoTsubuDAO {
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;

	private void connect() throws NamingException, SQLException{
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/docotsubudb");
		this.db = ds.getConnection();
	}

	private void disconnect() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(db != null) {
				db.close();
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public List<Mutter> findAll(){
		List<Mutter> list = new ArrayList<>();
		try {
			this.connect();
			ps = db.prepareStatement("SELECT * FROM mutters ORDER BY id DESC");
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String text = rs.getString("text");
				Mutter mutter = new Mutter(name,text);
				list.add(mutter);
			}
		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return list;
	}

	public void insertOne(Mutter mutter) {
		try {
			this.connect();
			ps=db.prepareStatement("INSERT INTO mutters(name,text) VALUES(?,?)");
			ps.setString(1, mutter.getUserName());
			ps.setString(2, mutter.getText());
			ps.executeUpdate();
		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
}
