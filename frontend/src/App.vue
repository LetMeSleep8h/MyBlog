<script setup lang="ts">
// 顶部导航左侧显示的名字,想改这里
const siteName = 'Sleep8h'
</script>

<template>
  <div class="app">
    <!-- 顶部导航:三个页面共用,用 router-link 跳转,不会刷新页面 -->
    <nav class="nav">
      <router-link to="/" class="logo">{{ siteName }}</router-link>
      <div class="nav-links">
        <router-link to="/">首页</router-link>
        <router-link to="/blog">个人博客</router-link>
        <router-link to="/projects">项目展示</router-link>
      </div>
    </nav>

    <!-- 路由出口:当前页面的内容显示在这里(main 自动撑开,把备案压到底部) -->
    <main class="main">
      <router-view />
    </main>

    <!-- 页面底部:ICP 备案 + 公安备案(所有页面共用) -->
    <footer class="footer">
      <div class="beian-links">
        <a href="https://beian.miit.gov.cn/" target="_blank" rel="noopener noreferrer">
          滇ICP备2026015070号
        </a>
        <a
          href="https://beian.mps.gov.cn/#/query/webSearch?code=53250302000473"
          target="_blank"
          rel="noopener noreferrer"
        >
          <img src="/gongan.png" alt="公网安备图标" class="beian-icon" />
          滇公网安备53250302000473号
        </a>
      </div>
    </footer>
  </div>
</template>

<!-- 全局样式 -->
<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

html {
  scroll-behavior: smooth;
}

body {
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue',
    Arial, 'PingFang SC', 'Microsoft YaHei', sans-serif;
  color: #333;
  background: #fff;
}
</style>

<style scoped>
/* ---- 整页布局:内容区撑满,备案条固定在页面底部 ---- */
.app {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}
.main {
  flex: 1;
}

/* ---- 导航 ---- */
.nav {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 16px 48px;
  background: #fff;
  border-bottom: 1px solid #eee;
  z-index: 10;
}
.nav a {
  color: #333;
  text-decoration: none;
}
.nav a:hover {
  color: #000;
}
.logo {
  font-weight: 700;
  font-size: 18px;
}
.nav-links a {
  margin-left: 28px;
  font-size: 14px;
  color: #666;
}
/* 当前所在页面:高亮为黑色加粗 */
.nav-links a.router-link-exact-active {
  color: #000;
  font-weight: 600;
}

/* ---- 页面底部备案信息 ---- */
.footer {
  padding: 28px 16px 40px;
  text-align: center;
  border-top: 1px solid #eee;
}
/* ICP 和公安备案上下两行、居中 */
.beian-links {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 8px;
}
.footer a {
  display: inline-flex;
  align-items: center;
  gap: 6px;
  color: #999;
  font-size: 12px;
  text-decoration: none;
}
.footer a:hover {
  color: #000;
}
.beian-icon {
  height: 14px;
  width: auto;
}
</style>
