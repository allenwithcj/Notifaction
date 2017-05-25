package com.example.lwl.ui;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.example.lwl.notifaction.R;

import java.util.Arrays;

public class Main2Activity extends AppCompatActivity {
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ViewPager mViewPager;
    private NavigationView mNavigationView;
    private TabLayout mTabLayout;
    private HomeFragmentAdapter mHomeFragmentAdapter;
    private ActionBarDrawerToggle toggle;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initToolBar();
        initDrawerToggle();
        initViewPager();
        initNavigationView();
        initClick();
    }

    private void initClick() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                showOldNotification();
                Snackbar.make(mToolbar,"您有新的消息",Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mNavigationView = (NavigationView) findViewById(R.id.navigationView);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton);
    }

    private void initToolBar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void initDrawerToggle() {
        toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, 0, 0);
        mDrawerLayout.addDrawerListener(toggle);
        /*同步drawerlayout的状态*/
        toggle.syncState();
    }

    private void initViewPager() {
        String[] titles = {"科技新闻", "靓丽美女", "极客信息", "德莱联盟"};
        mHomeFragmentAdapter = new HomeFragmentAdapter(getSupportFragmentManager(), Arrays.asList(titles));
        mViewPager.setAdapter(mHomeFragmentAdapter);
        //将tabLayout和viewpager关联
        mTabLayout.setupWithViewPager(mViewPager);
        //给tabs设置适配
        mTabLayout.setTabsFromPagerAdapter(mHomeFragmentAdapter);

        mViewPager.setCurrentItem(0);

    }

    private void initNavigationView() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            private MenuItem mMenuItem;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(mMenuItem != null){
                    mMenuItem.setCheckable(false);
                }
                item.setCheckable(true);
                mDrawerLayout.closeDrawers();
                mMenuItem = item;
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            // 打开抽屉侧滑菜单
            mDrawerLayout.openDrawer(GravityCompat.START);
        }else if(item.getItemId() == R.id.more){
            Intent intent = new Intent(this,MoreActivity.class);
            startActivity(intent);

        }else if(item.getItemId() == R.id.search){

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }


    private long exitTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
                mDrawerLayout.closeDrawers();
            }else{
                // 按下的如果是BACK，同时没有重复.
                if ((System.currentTimeMillis() - exitTime) > 2000) {
                    Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    exitTime = System.currentTimeMillis();
                } else {
                    finish();
                }
            }

        }
        return true;
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void showOldNotification(){
        NotificationManager mNotificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder mNotification = new Notification.Builder(this);
        mNotification.setSmallIcon(R.drawable.navigation_view_bg);
        mNotification.setContentTitle("暴雪预警");
        mNotification.setContentText("大雪不适合外出");
        mNotification.setWhen(System.currentTimeMillis());
        mNotification.setDefaults(Notification.DEFAULT_ALL);
        mNotification.setAutoCancel(true);

        Intent intent = new Intent(this,Main2Activity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        mNotification.setContentIntent(pendingIntent);
        mNotificationManager.notify(1,mNotification.build());

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void showStandardNotification(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setLargeIcon(bitmap)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("大雪来袭")
                .setContentInfo("今晚大到暴雪")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(false);

        Intent intent = new Intent(this,Main2Activity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1,builder.build());



    }

    private void showDefinedNotification(){
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new Notification();
        notification.icon = R.mipmap.ic_launcher;
        notification.tickerText = "when i'm gone";
        notification.when = System.currentTimeMillis();

        Intent intent = new Intent(this,Main2Activity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);

        RemoteViews remoteView = new RemoteViews(getPackageName(),R.layout.notification);
        remoteView.setTextViewText(R.id.tv_song_name,"when i'm gone");
        remoteView.setTextViewText(R.id.tv_singer_name,"eminem");
        remoteView.setImageViewResource(R.id.iv_singer_photo,R.mipmap.ic_launcher);
        notification.contentIntent = pendingIntent;
        notification.contentView = remoteView;
        notificationManager.notify(1,notification);
    }
}
