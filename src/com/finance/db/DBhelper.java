package com.finance.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.OpenableColumns;

public class DBhelper extends SQLiteOpenHelper {

	/**
	 * 系统默认构造方法
	 */
	public DBhelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 *  重写构造方法 
	 * @param context
	 */
	public DBhelper(Context context) {
		super(context, "Finance", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		SQLiteDatabase DB = SQLiteDatabase.openOrCreateDatabase("Finance", null);
		String Sql = "create table OutCostInfo(OutID integer primary key autoincrement,Money decimal,OutTime varchar(20),OutType varchar(10),Aaddress varchar(100),Depict varchar(200)) go"
				+ "create table InCostInfo(InID integer primary key autoincrement,Money decimal,InTime varchar(20),InType varchar(10),Source varchar(50),Depict varchar(200)) go "
				+" create table FlagInfo(FlagID integer primark key autoincrement,Content varchar(200))";
		DB.execSQL(Sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
