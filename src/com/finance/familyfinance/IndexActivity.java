package com.finance.familyfinance;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;

public class IndexActivity extends TabActivity {

	
	private TabHost tabHost;  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);  
		setContentView(R.layout.index_activity);
		
		tabHost=this.getTabHost();  
        TabHost.TabSpec spec;  
        Intent intent;  
  
        intent=new Intent().setClass(this, HomeActivity.class);  
        spec=tabHost.newTabSpec("主页").setIndicator("主页").setContent(intent);  
        tabHost.addTab(spec);  
          
        intent=new Intent().setClass(this,MessageActivity.class);  
        spec=tabHost.newTabSpec("资讯").setIndicator("资讯").setContent(intent);  
        tabHost.addTab(spec);  
          
        intent=new Intent().setClass(this, FlagActivity.class);  
        spec=tabHost.newTabSpec("便签").setIndicator("便签").setContent(intent);  
        tabHost.addTab(spec);  
          
       
        intent=new Intent().setClass(this, SelfActivity.class);  
        spec=tabHost.newTabSpec("我的").setIndicator("我的").setContent(intent);  
        tabHost.addTab(spec);  
        tabHost.setCurrentTab(1);  
          
        RadioGroup radioGroup=(RadioGroup) this.findViewById(R.id.main_tab_group); 
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {  
            
            @Override  
            public void onCheckedChanged(RadioGroup group, int checkedId) {  
                // TODO Auto-generated method stub  
                switch (checkedId) {  
                case R.id.main_Home://主页
                    tabHost.setCurrentTabByTag("主页");  
                    break;  
                case R.id.main_Message://消息
                    tabHost.setCurrentTabByTag("资讯");  
                    break;  
                case R.id.main_Flag://便签
                    tabHost.setCurrentTabByTag("便签");  
                    break;  
                case R.id.main_Self://我的 
                    tabHost.setCurrentTabByTag("我的");  
                    break;  
                default:  
                    tabHost.setCurrentTabByTag("主页");  
                    break;  
                }  
            }  
        });  
	}
	
}
