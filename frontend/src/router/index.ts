import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'

const router = createRouter({
  // hash 模式:网址形如 xxx/#/blog,部署到任何静态服务器都不用额外配置
  // 想换成好看的历史模式(无 #),改 createWebHistory 但要服务器配置 SPA 回退
  history: createWebHashHistory(import.meta.env.BASE_URL),
  routes: [
    { path: '/', name: 'home', component: HomeView },
    // 下面这些用懒加载,访问时才加载对应页面,首屏更小
    { path: '/blog', name: 'blog', component: () => import('@/views/BlogView.vue') },
    // 博客详情页:一个组件复用于所有文章,/blog/1 /blog/2 ... 都是它
    { path: '/blog/:id', name: 'blog-detail', component: () => import('@/views/BlogDetailView.vue') },
    { path: '/projects', name: 'projects', component: () => import('@/views/ProjectsView.vue') },
    // 管理端:不在导航里显示,手动访问 #/admin/add 才出现(隐藏入口)
    { path: '/admin/add', name: 'admin-add', component: () => import('@/views/AdminView.vue') },
  ],
})

export default router
