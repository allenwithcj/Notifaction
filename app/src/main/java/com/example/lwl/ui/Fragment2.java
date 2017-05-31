package com.example.lwl.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lwl.adapter.ArticleAdapter;
import com.example.lwl.bean.ItemArticle;
import com.example.lwl.notifaction.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwl on 2017/5/24.
 */
public class Fragment2 extends Fragment{
    private RecyclerView rcv_article_latest;
    private ArticleAdapter articleAdapter;
    private List<ItemArticle> itemArticleList = new ArrayList<ItemArticle>();

    public static Fragment2 newInstance(String str){
        Fragment2 fragment2 = new Fragment2();
        Bundle bundle = new Bundle();
        bundle.putString("str",str);
        fragment2.setArguments(bundle);
        return fragment2;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        rcv_article_latest = (RecyclerView)view.findViewById(R.id.rcv_article_latest);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rcv_article_latest.setLayoutManager(manager);
        articleAdapter = new ArticleAdapter(getActivity());
        rcv_article_latest.setAdapter(articleAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new LatestArticleTask().execute();
    }

    class LatestArticleTask extends AsyncTask<String, Void, List<ItemArticle>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<ItemArticle> doInBackground(String... params) {
            ItemArticle storeInfo1 =
                    new ItemArticle(20123, "http://d.5857.com/dfqz_170427/desk_001.jpg", "关于举办《经典音乐作品欣赏与人文审美》讲座的通知", "2015-01-09", "科学研究院", 1129,
                            "讲座主要内容：以中、西方音乐历史中经典音乐作品为基础，通过作曲家及作品创作背景、相关音乐文化史知识及音乐欣赏常识...");
            ItemArticle storeInfo2 =
                    new ItemArticle(20123, "http://img1.3lian.com/2015/a1/116/d/239.jpg", "关于举办《经典音乐作品欣赏与人文审美》讲座的通知", "2015-01-09", "科学研究院", 1129,
                            "讲座主要内容：以中、西方音乐历史中经典音乐作品为基础，通过作曲家及作品创作背景、相关音乐文化史知识及音乐欣赏常识...");
            ItemArticle storeInfo3 =
                    new ItemArticle(20123, "http://s2.sinaimg.cn/mw690/00293TWKty6SYz7pu2B61&690", "关于举办《经典音乐作品欣赏与人文审美》讲座的通知", "2015-01-09", "科学研究院", 1129,
                            "讲座主要内容：以中、西方音乐历史中经典音乐作品为基础，通过作曲家及作品创作背景、相关音乐文化史知识及音乐欣赏常识...");
            ItemArticle storeInfo4 =
                    new ItemArticle(20123, "http://i2.sinaimg.cn/ent/j/2012-05-20/U5912P28T3D3634984F328DT20120520152700.JPG", "关于举办《经典音乐作品欣赏与人文审美》讲座的通知", "2015-01-09", "科学研究院", 1129,
                            "讲座主要内容：以中、西方音乐历史中经典音乐作品为基础，通过作曲家及作品创作背景、相关音乐文化史知识及音乐欣赏常识...");
            ItemArticle storeInfo5 =
                    new ItemArticle(20123, "http://i2.sinaimg.cn/ent/j/2012-05-20/U5912P28T3D3634984F328DT20120520152700.JPG", "关于举办《经典音乐作品欣赏与人文审美》讲座的通知", "2015-01-09", "科学研究院", 1129,
                            "讲座主要内容：以中、西方音乐历史中经典音乐作品为基础，通过作曲家及作品创作背景、相关音乐文化史知识及音乐欣赏常识...");
            ItemArticle storeInfo6 =
                    new ItemArticle(20123, "http://i2.sinaimg.cn/ent/j/2012-05-20/U5912P28T3D3634984F328DT20120520152700.JPG", "关于举办《经典音乐作品欣赏与人文审美》讲座的通知", "2015-01-09", "科学研究院", 1129,
                            "讲座主要内容：以中、西方音乐历史中经典音乐作品为基础，通过作曲家及作品创作背景、相关音乐文化史知识及音乐欣赏常识...");
            itemArticleList.add(storeInfo1);
            itemArticleList.add(storeInfo2);
            itemArticleList.add(storeInfo3);
            itemArticleList.add(storeInfo4);
            itemArticleList.add(storeInfo5);
            itemArticleList.add(storeInfo6);
            return itemArticleList;
        }

        @Override
        protected void onPostExecute(List<ItemArticle> data) {
            super.onPostExecute(data);
            articleAdapter.setData(data);
        }
    }
}
