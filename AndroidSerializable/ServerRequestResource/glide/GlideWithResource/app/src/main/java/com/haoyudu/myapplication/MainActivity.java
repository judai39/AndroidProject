package com.haoyudu.myapplication;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.MediaCodec;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    private NetworkImageView networkImageView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private String url1,url2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        RequestQueue requestQueue = Volley.newRequestQueue(this);

        /**使用volley接口从服务器请求数据(text)*/
//        setContentView(R.layout.volley_get_text);
//        url="https://www.jd.com";
//        textView=findViewById(R.id.textView);
//        /**StringRequest构造器参数(1.请求类型上传或下载,2.url内容,3.回调成功的监听器,4.回调错误的监听器)*/
//        StringRequest stringRequest=new StringRequest(
//                Request.Method.GET,
//                url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        textView.setText(response);
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("my_log","error_response",error);
//                    }
//                }
//        );
//        requestQueue.add(stringRequest);
//        /**需要前往AndroidManifest文件中添加网络权限,还需要向application节点添加
//         * <uses-library android:name="org.apache.http.legacy"
//         android:required="false" />*/

        /**使用volley从服务器请求图片(imageLoader.get()请求)*/
//        setContentView(R.layout.volley_get_photo);
//        imageView=findViewById(R.id.imageView);
//        url="https://pixabay.com/get/g6a6e3c7fe7fb2b63dd90774c9c581ba8dbccd16f77379266215f2b31614c90247e48978767f367203a52c3feab6655ecbad3d0a7e8df3e69d9767662ecbb47c3_1280.jpg";
//        ImageLoader imageLoader=new ImageLoader(requestQueue,
//                new ImageLoader.ImageCache() {
//                    @Override
//                    public Bitmap getBitmap(String url) {
//                        return null;
//                    }
//
//                    @Override
//                    public void putBitmap(String url, Bitmap bitmap) {
//
//                    }
//                });
//        imageLoader.get(url, new ImageLoader.ImageListener() {
//            @Override
//            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
//                imageView.setImageBitmap(response.getBitmap());
//            }
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("my_log","ImageLoader.get() Error",error);
//            }
//        });

        /**使用volley从服务器请求图片资源(将ImageView转换为NetWorkImageView)*/
//        setContentView(R.layout.volley_get_photo_networdimageview);
//        networkImageView=findViewById(R.id.netWorkImageView);
//        url="https://pixabay.com/get/g6a6e3c7fe7fb2b63dd90774c9c581ba8dbccd16f77379266215f2b31614c90247e48978767f367203a52c3feab6655ecbad3d0a7e8df3e69d9767662ecbb47c3_1280.jpg";
//        ImageLoader imageLoader=new ImageLoader(requestQueue,
//                //创建图片缓存
//                new ImageLoader.ImageCache() {
//                    @Override
//                    public Bitmap getBitmap(String url) {
//                        return null;
//                    }
//
//                    @Override
//                    public void putBitmap(String url, Bitmap bitmap) {
//
//                    }
//                });
//        //无需手动设置get请求
//        networkImageView.setImageUrl(url,imageLoader);


        /**使用Glide库从服务器上请求图片*/
//        setContentView(R.layout.glide_with_photo);
//        imageView = findViewById(R.id.glide_imageview);
//        url = "https://pixabay.com/get/g6a6e3c7fe7fb2b63dd90774c9c581ba8dbccd16f77379266215f2b31614c90247e48978767f367203a52c3feab6655ecbad3d0a7e8df3e69d9767662ecbb47c3_1280.jpg";
//        Glide.with(this).
//                load(url).
//                placeholder(R.drawable.ic_launcher_background).
//                listener(
//                new RequestListener<Drawable>() {
//                    @Override
//                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                        return false;
//                    }
//                }
//        ).into(imageView);

        /**SwipeRefreshLayout绑定下滑刷新事件*/
        setContentView(R.layout.swiperefresh_layout);
        swipeRefreshLayout=findViewById(R.id.swipe_refresh);
        imageView = findViewById(R.id.glide_imageview);
        url1 = "https://pixabay.com/get/g6a6e3c7fe7fb2b63dd90774c9c581ba8dbccd16f77379266215f2b31614c90247e48978767f367203a52c3feab6655ecbad3d0a7e8df3e69d9767662ecbb47c3_1280.jpg";
        url2="https://pixabay.com/get/g2f89e691c0914e8095c78c8c474a6abd06fe55b7897e892b888805c851b0648588e8827d0b44a11b5245171f3a0502ae36c6d3deb2602e992e1a3a6c496fcf3d_1280.jpg";
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                GlideShowPhoto();
            }
        });
    }
    //随机显示图片
    void GlideShowPhoto(){
        Random random=new Random();
        String url=random.nextBoolean()? url1:url2;
        Glide.with(this).
                load(url).
                placeholder(R.drawable.ic_launcher_background).
                listener(
                        new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                if(swipeRefreshLayout.isRefreshing()){
                                    swipeRefreshLayout.setRefreshing(false);
                                }
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                if(swipeRefreshLayout.isRefreshing()){
                                    swipeRefreshLayout.setRefreshing(false);
                                }
                                return false;
                            }
                        }
                ).into(imageView);
    }
}