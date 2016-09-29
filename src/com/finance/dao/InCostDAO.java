package com.finance.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.finance.db.DBhelper;
import com.finance.model.M_InCost;
public class InCostDAO {
	
	private DBhelper helper;
	private SQLiteDatabase Sdb;
	
	public InCostDAO(Context context)
	{
		helper = new DBhelper(context);
	}

	
	
	/**
	 * 定义数据库新增收入信息的方法
	 * @param mInCost  使用收入类字段
	 */
	public void ADD(M_InCost mInCost)
	{
		//初始化 SQLiteDatebase对象
		Sdb = helper.getWritableDatabase();
		String Sql = "INSERT INTO InCostInfo(Money,InTime,InType,Source,Depict) VALUES(?,?,?,?,?)";
		Object values[] = new Object[]{mInCost.getMoney(),mInCost.getInTime(),mInCost.getInType(),mInCost.getSource(),mInCost.getDepict()};
		Sdb.execSQL(Sql, values);
		//Sdb.close();
	}
	
	
	/**
	 * 定义修改收入信息的方法
	 * @param mInCost
	 */
	public void Update(M_InCost mInCost)
	{
		Sdb  = helper.getWritableDatabase();
		String Sql = "UPDATE InCostInfo SET Money = ？，InTime = ? ,InType = ? ,Source = ? ,Depict = ? where InID = ?";
		Object values[] = new Object[]{mInCost.getMoney(),mInCost.getInTime(),mInCost.getInType(),mInCost.getSource(),mInCost.getDepict(),mInCost.getInID()};
		Sdb.execSQL(Sql, values);
		
	}
	
	/**
	 * 定义删除收入信息的方法
	 * @param mInCost
	 */
	public void Delete(M_InCost mInCost,Object[] InID)
	{
		if(InID.length > 0)
		{
			StringBuffer  sb = new StringBuffer();
			for(int i = 0;i < InID.length;i++)
			{
				sb.append("?").append(",");
			}
			sb.deleteCharAt(sb.length() -1);
			Sdb  = helper.getWritableDatabase();		
			Sdb.execSQL("Delete From OutCostInfo  Where InID in("+ sb +" )",InID);
		}
	}
	
	
	/**
	 * 获取所有收入信息
	 * @return
	 */
	public List<M_InCost > ShowInfo()
	{
		List<M_InCost> m_incost = new ArrayList<M_InCost>();
		Sdb  = helper.getWritableDatabase();
		Cursor cursor = Sdb.query("InCostInfo", null, null, null, null, null, null);
		while(cursor.moveToNext())
		{
			m_incost.add(new M_InCost(cursor.getInt(cursor.getColumnIndex("InID")), cursor.getDouble(cursor.getColumnIndex("Money")), cursor.getString(cursor.getColumnIndex("InTime")), cursor.getString(cursor.getColumnIndex("" +
					"InType")), cursor.getString(cursor.getColumnIndex("Source")), cursor.getString(cursor.getColumnIndex("Depict"))));
		}
		return m_incost;
	}
}
