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

        /**ʹ��volley�ӿڴӷ�������������(text)*/
//        setContentView(R.layout.volley_get_text);
//        url="https://www.jd.com";
//        textView=findViewById(R.id.textView);
//        /**StringRequest����������(1.���������ϴ�������,2.url����,3.�ص��ɹ��ļ�����,4.�ص�����ļ�����)*/
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
//        /**��Ҫǰ��AndroidManifest�ļ����������Ȩ��,����Ҫ��application�ڵ����
//         * <uses-library android:name="org.apache.http.legacy"
//         android:required="false" />*/

        /**ʹ��volley�ӷ���������ͼƬ(imageLoader.get()����)*/
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

        /**ʹ��volley�ӷ���������ͼƬ��Դ(��ImageViewת��ΪNetWorkImageView)*/
//        setContentView(R.layout.volley_get_photo_networdimageview);
//        networkImageView=findViewById(R.id.netWorkImageView);
//        url="https://pixabay.com/get/g6a6e3c7fe7fb2b63dd90774c9c581ba8dbccd16f77379266215f2b31614c90247e48978767f367203a52c3feab6655ecbad3d0a7e8df3e69d9767662ecbb47c3_1280.jpg";
//        ImageLoader imageLoader=new ImageLoader(requestQueue,
//                //����ͼƬ����
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
//        //�����ֶ�����get����
//        networkImageView.setImageUrl(url,imageLoader);


        /**ʹ��Glide��ӷ�����������ͼƬ*/
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

        /**SwipeRefreshLayout���»�ˢ���¼�*/
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
    //�����ʾͼƬ
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