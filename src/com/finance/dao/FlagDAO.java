package com.finance.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.finance.db.DBhelper;
import com.finance.model.M_Flag;;

public class FlagDAO {
	private DBhelper helper;
	private SQLiteDatabase Sdb;
	
	public FlagDAO(Context context)
	{
		helper = new DBhelper(context);
	}
	
	
	/**
	 * 定义数据库新增便签信息的方法
	 * @param mFlag  使用便签字段
	 */
	public void ADD(M_Flag mFlag)
	{
		//初始化 SQLiteDatebase对象
		Sdb = helper.getWritableDatabase();
		String Sql = "INSERT INTO FlagInfo(Content) VALUES(?)";
		Object[] values = new Object[]{mFlag.getContent()};
		Sdb.execSQL(Sql, values);
		//Sdb.close();
	}
	
	
	/**
	 * 定义修改便签信息的方法
	 * @param mOutCost
	 */
	public void Update(M_Flag mFlag)
	{
		Sdb  = helper.getWritableDatabase();
		String Sql = "UPDATE FlagInfo SET Content = ？ where FlagID = ?";
		Object values[] = new Object[]{mFlag.getContent(),mFlag.getFlagID()};
		Sdb.execSQL(Sql, values);
		
	}
	
	/**
	 * 定义删除便签信息的方法
	 * @param mOutCost
	 */
	public void Delete(M_Flag mFlag,Object[] FlagID)
	{
		if(FlagID.length > 0)
		{
			StringBuffer  sb = new StringBuffer();
			for(int i = 0;i < FlagID.length;i++)
			{
				sb.append("?").append(",");
			}
			sb.deleteCharAt(sb.length() -1);
			Sdb  = helper.getWritableDatabase();		
			Sdb.execSQL("Delete From OutCostInfo  Where OutID in("+ sb +" )",FlagID);
		}
	}
	
	
	/**
	 * 获取所有便签
	 * @return
	 */
	public List<M_Flag > ShowInfo()
	{
		List<M_Flag> m_flag = new ArrayList<M_Flag>();
		Sdb  = helper.getWritableDatabase();
		Cursor cursor = Sdb.query("FlagInfo", null, null, null, null, null, null);
		while(cursor.moveToNext())
		{
			m_flag.add(new M_Flag(cursor.getInt(cursor.getColumnIndex("FlagID")),cursor.getString(cursor.getColumnIndex("Content"))));
		}
		return m_flag;
	}
}
