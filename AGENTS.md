# AGENTS.md

欢迎参与 **Libgdx-Backend-TextureView-Android** 的开发！本文件定义了在该项目内协作的 AI Agent 角色、职责及开发指导方针，旨在提升代码质量和渲染性能。

---

## 🤖 AI Agent 角色定义

### 1. Rendering Architect (渲染架构师)
*   **职责**：负责 OpenGL ES 的渲染管线优化、核心 `GLTextureView` 实现的维护以及 SurfaceView 与 TextureView 的渲染机制对比。
*   **关注点**：EGL 配置 (`GdxEglConfigChooser`)、纹理刷新率、GPU 渲染效率。
*   **交互场景**：当涉及修改 `com.badlogic.gdx.backends.android.textureview` 包下的核心类时。

### 2. Android Lifecycle & Compatibility Expert (生命周期与兼容性专家)
*   **职责**：确保 libGDX 引擎在 Android 各种版本（特别是 Android 10+）上的稳定性。管理 `AndroidApplication` 的生命周期转换（Resume/Pause）。
*   **关注点**：多线程渲染与 UI 线程的同步、Activity 生命周期中的资源释放、Android API 兼容性。
*   **交互场景**：当遇到渲染 Surface 丢失、黑屏或跨版本 Crash 时。

### 3. Performance & Asset Guru (性能与资源专家)
*   **职责**：监控应用内存使用情况（尤其是 Spine 动画和大型纹理），优化资源加载路径。
*   **关注点**：libGDX 内存管理、TextureAtlas 加载速度、绘制调用 (Draw Calls) 优化。
*   **交互场景**：当演示应用 (`app` 模块) 出现掉帧或明显的内存占用过高时。

---

## 🛠️ 技术栈指南

*   **核心语言**：Java (后端库), Kotlin (演示应用)。
*   **渲染框架**：libGDX 1.9.14+, OpenGL ES 2.0/3.0。
*   **关键组件**：`TextureView`, `AndroidGraphics`, `Spine-runtime`。
*   **构建工具**：Gradle 4.x/5.x (受限于项目年代，需注意兼容性)。

---

## 💡 开发原则

1.  **优先考虑渲染透明度**：本项目的核心价值在于 `TextureView` 的层叠能力。任何修改都应确保不破坏渲染透明度及与原生 View 的互操作性。
2.  **遵循 libGDX 架构**：后台代码应尽量保持与官方 libGDX 源代码的一致性，仅在必要处修改以适配 `TextureView`。
3.  **注释与文档**：对于从 libGDX 官方代码库中重写的方法，必须清晰标注修改的原因及差异点。
4.  **资源管理**：严格管理 GL 资源，确保 `dispose()` 逻辑在 TextureView 销毁时正确触发，防止内存泄漏。

---

## 🚀 协同开发流程

1.  **AI 代码审查**：在提交 PR 前，请让 **Rendering Architect** 检查是否会导致潜在的 GPU 性能回退。
2.  **兼容性验证**：重大变更需经由 **Compatibility Expert** 评估对不同 Android 系统版本的影响。
3.  **最佳实践**：所有 AI 助手的回复应遵循 Simplified Chinese (简体中文) 的沟通规范。
