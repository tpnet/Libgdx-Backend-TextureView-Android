# LibgdxTextureView

[English](README.md) | [中文](README_zh.md)

libGDX use TextureView Rendering
Modify libGDX's rendering View `SurfaceView` to `TextureView`, allowing for transparent layering with native views. The currently latest supported libGDX version is 1.14.0.

## Usage

### 1. Add Dependency

Download the corresponding jar file for your version from the `libs` folder and add it to your project dependencies.

### 2. Code Implementation

Configure the following in your `AndroidApplication` (or the Activity embedded as a View):

```kotlin
// 1. Create configuration
val cfg = AndroidApplicationConfiguration()

// 2. Core: Enable TextureView
cfg.useTextureView = true

// 3. (Optional) Set transparent channels for transparent layering with native Views
cfg.r = 8
cfg.g = 8
cfg.b = 8
cfg.a = 8

// 4. Initialize and use in layout
val mGdxAdapter = MyGdxAdapter()
val mGdxView = initializeForView(mGdxAdapter, cfg)

// Add the generated View to your layout container (e.g., FrameLayout)
binding.container.addView(mGdxView)
```

### 3. Why use TextureView?
Compared to the default `SurfaceView`, `TextureView` can be manipulated like a normal Android View:
- **Opacity control** (can be layered directly with native UI components for displaying).
- **Dynamic property modification** (such as `setAlpha()`, `setRotation()`, etc.).
- **Animation handling** (supports standard Android View property animations).

# Effects
## Original SurfaceView placed at the bottom effect:

![Original SurfaceView placed at the bottom](https://raw.githubusercontent.com/tpnet/LibgdxTextureView/master/pic/SurfaceView%E7%BD%AE%E5%BA%95%E9%83%A8.jpg)

## Original SurfaceView transparent placed at the top effect:

![Original SurfaceView transparent placed at the top](https://raw.githubusercontent.com/tpnet/LibgdxTextureView/master/pic/SurfaceView%E9%80%8F%E6%98%8E%E7%BD%AE%E9%A1%B6.jpg)
 
## Modified TextureView transparent layered with native views effect:

![Modified TextureView transparent layered](https://raw.githubusercontent.com/tpnet/LibgdxTextureView/master/pic/TextureView%E9%80%8F%E6%98%8E%E5%B1%82%E5%8F%A0.jpg)

## License

This project is licensed under the [MIT License](LICENSE).
