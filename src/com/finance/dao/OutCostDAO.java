package com.finance.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.finance.db.DBhelper;
import com.finance.model.M_OutCost;

public class OutCostDAO {

	private DBhelper helper;
	private SQLiteDatabase Sdb;
	//private M_OutCost mOutCost;
	
	/**
	 * 定义含参数的构造函数（使用数据库连接操作数据）
	 * @param context
	 */
	public OutCostDAO(Context context)
	{
		helper = new DBhelper(context);
	}
	
	/**
	 * 定义数据库新增支出信息的方法
	 * @param mOutCost  使用支出类字段
	 */
	public void ADD(M_OutCost mOutCost)
	{
		//初始化 SQLiteDatebase对象
		Sdb = helper.getWritableDatabase();
		String Sql = "INSERT INTO OutCostInfo(Money,OutTime,OutType,Address,Depict) VALUES(?,?,?,?,?)";
		Object values[] = new Object[]{mOutCost.getMoney(),mOutCost.getOutTime(),mOutCost.getOutType(),mOutCost.getAddress(),mOutCost.getDepict()};
		Sdb.execSQL(Sql, values);
		//Sdb.close();
	}
	
	
	/**
	 * 定义修改支出信息的方法
	 * @param mOutCost
	 */
	public void Update(M_OutCost mOutCost)
	{
		Sdb  = helper.getWritableDatabase();
		String Sql = "UPDATE OutCostInfo SET Money = ？，OutTime = ? ,OutType = ? ,Address = ? ,Depict = ? where OutID = ?";
		Object values[] = new Object[]{mOutCost.getMoney(),mOutCost.getOutTime(),mOutCost.getOutType(),mOutCost.getAddress(),mOutCost.getDepict(),mOutCost.getOutID()};
		Sdb.execSQL(Sql, values);
		
	}
	
	/**
	 * 定义删除支出信息的方法
	 * @param mOutCost
	 */
	public void Delete(M_OutCost mOutCost,Object[] OutID)
	{
		if(OutID.length > 0)
		{
			StringBuffer  sb = new StringBuffer();
			for(int i = 0;i < OutID.length;i++)
			{
				sb.append("?").append(",");
			}
			sb.deleteCharAt(sb.length() -1);
			Sdb  = helper.getWritableDatabase();		
			Sdb.execSQL("Delete From OutCostInfo  Where OutID in("+ sb +" )",OutID);
		}
	}
	
	
	/**
	 * 获取所有支出信息
	 * @return
	 */
	public List<M_OutCost> ShowInfo()
	{
		List<M_OutCost> m_outcost = new ArrayList<M_OutCost>();
		Sdb  = helper.getWritableDatabase();
		Cursor cursor = Sdb.query("OutCostInfo", null, null, null, null, null, null);
		while(cursor.moveToNext())
		{
			m_outcost.add(new M_OutCost(cursor.getInt(cursor.getColumnIndex("OutID")), cursor.getDouble(cursor.getColumnIndex("Money")), cursor.getString(cursor.getColumnIndex("OutTime")), cursor.getString(cursor.getColumnIndex("" +
					"OutType")), cursor.getString(cursor.getColumnIndex("Address")), cursor.getString(cursor.getColumnIndex("Depict"))));
		}
		return m_outcost;
	}
}
