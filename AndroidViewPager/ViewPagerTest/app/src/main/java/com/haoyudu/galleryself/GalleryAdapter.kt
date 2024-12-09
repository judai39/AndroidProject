package com.haoyudu.galleryself

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.photo_cell.view.*

class GalleryAdapter :ListAdapter<PhotoItem,MyViewHolder>(DIFFCALLBACK){
    /**实现GridLinearLayout形式的适配器需要*/
    object DIFFCALLBACK: DiffUtil.ItemCallback<PhotoItem>() {
        override fun areItemsTheSame(oldItem: PhotoItem, newItem: PhotoItem): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: PhotoItem, newItem: PhotoItem): Boolean {
            return oldItem==newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val holder=MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.photo_cell,parent,false))
        /**绑定跳转事件*/
        holder.itemView.setOnClickListener{
            Bundle().apply {
                putParcelableArrayList("photo_list", ArrayList(currentList))//将整个list的图片数据传递
                putInt("photo_index",holder.adapterPosition)//将当前图片坐标传递
                holder.itemView.findNavController().navigate(R.id.photoFragment,this)
            }
        }
        return holder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.shimmer_gallery_cell.apply {
            setShimmerColor(0x55FFFFFF)
            setShimmerAngle(0)
            startShimmerAnimation()
        }
        /**这里的itemView是layout中的缩略图*/
        Glide.with(holder.itemView).
        load(getItem(position).previewUrl).
        placeholder(R.drawable.ic_preview).listener(
            object:RequestListener<Drawable>{
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false.also { holder.itemView.shimmer_gallery_cell?.stopShimmerAnimation() }
                }
            }
        ).into(holder.itemView.imageView)
    }

}
class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)