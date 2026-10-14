<script setup lang="ts">
import { computed, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import { posts, loadPosts } from '@/data/posts'

// 从网址里拿文章 id,例如 /blog/1 → id = 1
// 这个组件被复用:点哪篇,就显示哪篇,不用为每篇文章单独写页面
const route = useRoute()
const post = computed(() => posts.find((p) => p.id === Number(route.params.id)))

// 直接刷新详情页或从别的入口进来时,数据可能还没加载,补一次
onMounted(async () => {
  if (posts.length === 0) {
    await loadPosts()
  }
})
</script>

<template>
  <div class="page">
    <router-link to="/blog" class="back">← 返回博客列表</router-link>

    <!-- 找到文章就显示 -->
    <template v-if="post">
      <h2>{{ post.title }}</h2>
      <p class="date">{{ post.date }}</p>
      <article class="content">{{ post.content }}</article>
    </template>

    <!-- 没找到(比如 id 不存在) -->
    <template v-else>
      <h2>文章不存在或还没写完</h2>
    </template>
  </div>
</template>

<style scoped>
.page {
  max-width: 800px;
  margin: 0 auto;
  padding: 96px 24px 48px; /* 顶部给导航留空间 */
}

.back {
  display: inline-block;
  color: #666;
  font-size: 14px;
  text-decoration: none;
  margin-bottom: 24px;
}
.back:hover {
  color: #000;
}

h2 {
  font-size: 32px;
  font-weight: 700;
  margin-bottom: 8px;
}

.date {
  color: #999;
  font-size: 14px;
  padding-bottom: 24px;
  border-bottom: 1px solid #eee;
  margin-bottom: 32px;
}

.content {
  font-size: 16px;
  line-height: 1.9;
  color: #333;
  white-space: pre-wrap; /* 保留正文里的换行 */
  word-break: break-word;
}
</style>
