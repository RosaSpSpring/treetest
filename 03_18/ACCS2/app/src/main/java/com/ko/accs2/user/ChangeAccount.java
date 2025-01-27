package com.ko.accs2.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.githang.statusbar.StatusBarCompat;
import com.ko.accs2.R;
import com.ko.accs2.adapter.MyChangeAccountAdapter;
import com.ko.accs2.bean.MyEventBus;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Admin
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 * 切换账号
 */
public class ChangeAccount extends AppCompatActivity {
	private static final String TAG = ChangeAccount.class.getSimpleName();
	@BindView(R.id.backarrow_changeaccount)
	ImageView mBackarrowChangeaccount;
	private ListView mChangeAccountListView;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.change_account );
		ButterKnife.bind( this );
		StatusBarCompat.setStatusBarColor( this, getResources().getColor( R.color.colorRB ), false );
		mBackarrowChangeaccount = findViewById(R.id.backarrow_changeaccount);
//		mChangeAccountListView = findViewById( R.id.lv_change_account );
//		mChangeAccountListView.setAdapter( new MyChangeAccountAdapter() );
		initData();
		initListener();


	}

	private void initListener() {
		mBackarrowChangeaccount.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ChangeAccount.this.finish();
			}
		} );
	}

	//注册eventbus
	private void initData() {
		Log.e( TAG, "注册eventbus" );
		EventBus.getDefault().register( ChangeAccount.this );
	}

	//接收消息
	@Subscribe(threadMode = ThreadMode.MAIN)
	public void MyEventBussss(MyEventBus myEventBus) {
		Log.e( TAG, "userbeans" + myEventBus.msg );
		Log.e( TAG, "userbeans" + myEventBus.getMsg() );
	}

	//解注册
	@Override
	protected void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister( ChangeAccount.this );
	}
}
