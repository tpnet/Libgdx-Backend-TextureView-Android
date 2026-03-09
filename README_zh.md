# LibgdxTextureView

[English](README.md) | [中文](README_zh.md)

libGDX use TextureView Rendering
修改libGDX的渲染View SurfaceView为TextureView，可以跟原生的view进行透明层叠，目前最新支持libGDX版本为1.14.0


## 使用

### 1. 添加依赖

下载libs里面对应版本jar文件，添加依赖到你的项目里面。

### 2. 代码实现

在你的 `AndroidApplication` (或者作为 View 嵌入的 Activity) 中进行如下配置：

```kotlin
// 1. 创建配置
val cfg = AndroidApplicationConfiguration()

// 2. 核心：开启 TextureView
cfg.useTextureView = true

// 3. (可选) 设置透明通道，以便与原生 View 进行透明层叠
cfg.r = 8
cfg.g = 8
cfg.b = 8
cfg.a = 8

// 4. 初始化并在布局中使用
val mGdxAdapter = MyGdxAdapter()
val mGdxView = initializeForView(mGdxAdapter, cfg)

// 将生成的 View 添加到你的布局容器中 (例如 FrameLayout)
binding.container.addView(mGdxView)
```

### 3. 为什么使用 TextureView？
相比于默认的 `SurfaceView`，`TextureView` 可以像普通 Android View 一样进行：
- **透明度控制**（可以直接与原生 UI 组件进行层叠显示）。
- **属性动态修改**（如 `setAlpha()`, `setRotation()` 等）。
- **动画处理**（支持标准的 Android 视图属性动画）。

# 效果
## 原版SurfaceView置于底部效果：

![透明置于底部效果](https://raw.githubusercontent.com/tpnet/LibgdxTextureView/master/pic/SurfaceView%E7%BD%AE%E5%BA%95%E9%83%A8.jpg)


## 原版SurfaceView透明置于顶部效果：

![置于底部效果](https://raw.githubusercontent.com/tpnet/LibgdxTextureView/master/pic/SurfaceView%E9%80%8F%E6%98%8E%E7%BD%AE%E9%A1%B6.jpg)

 
## 修改之后的TextureView与原生View进行透明层叠效果：

![透明层叠效果](https://raw.githubusercontent.com/tpnet/LibgdxTextureView/master/pic/TextureView%E9%80%8F%E6%98%8E%E5%B1%82%E5%8F%A0.jpg)


## 许可证

本项目采用 [MIT 许可证](LICENSE)。
