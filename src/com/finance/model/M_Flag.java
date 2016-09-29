package com.finance.model;

public class M_Flag {
		private int FlagID;
		private String Content;

		/**
		 * 系统默认构造函数
		 */
		public M_Flag()
		{
			super();
		}
		
		/**
		 * 定义有参数的构造函数
		 * @param flagid
		 * @param content
		 */
		public M_Flag(int flagid,String content)
		{
			this.FlagID = flagid;
			this.Content = content;
		}

		public int getFlagID() {
			return FlagID;
		}

		public void setFlagID(int flagID) {
			FlagID = flagID;
		}

		public String getContent() {
			return Content;
		}

		public void setContent(String content) {
			Content = content;
		}
}
