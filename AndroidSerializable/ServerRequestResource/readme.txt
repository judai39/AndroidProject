Glide是一个快速高效的Android图片加载库，注重于平滑的滚动。Glide提供了易用的API，高性能、可扩展的图片解码管道（decode pipeline），以及自动的资源池技术。


Glide 支持拉取，解码和展示视频快照，图片，和GIF动画。Glide的Api是如此的灵活，开发者甚至可以插入和替换成自己喜爱的任何网络栈。默认情况下，Glide使用的是一个定制化的基于HttpUrlConnection的栈，但同时也提供了与Google Volley和Square OkHttp快速集成的工具库。

虽然Glide 的主要目标是让任何形式的图片列表的滚动尽可能地变得更快、更平滑，但实际上，Glide几乎能满足你对远程图片的拉取/缩放/显示的一切需求。

API
Glide 使用简明的流式语法API，这是一个非常棒的设计，因为它允许你在大部分情况下一行代码搞定需求：

Glide.with(fragment)
    .load(url)
    .into(imageView);
性能
Glide 充分考虑了Android图片加载性能的两个关键方面：

图片解码速度
解码图片带来的资源压力
为了让用户拥有良好的App使用体验，图片不仅要快速加载，而且还不能因为过多的主线程I/O或频繁的垃圾回收导致页面的闪烁和抖动现象。

Glide使用了多个步骤来确保在Android上加载图片尽可能的快速和平滑：

自动、智能地下采样(downsampling)和缓存(caching)，以最小化存储开销和解码次数；
积极的资源重用，例如字节数组和Bitmap，以最小化昂贵的垃圾回收和堆碎片影响；
深度的生命周期集成，以确保仅优先处理活跃的Fragment和Activity的请求，并有利于应用在必要时释放资源以避免在后台时被杀掉。