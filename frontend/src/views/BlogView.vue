<script setup lang="ts">
import { onMounted, ref } from 'vue'
import { posts, loadPosts } from '@/data/posts'

const loading = ref(true)

// 每次进入"个人博客"页面,都去数据库重新扫一遍,返回所有文章
onMounted(async () => {
  loading.value = true
  try {
    await loadPosts()
  } finally {
    loading.value = false
  }
})
</script>

<template>
  <div class="page">
    <h2>个人博客</h2>

    <p v-if="loading" class="empty">加载中...</p>

    <!-- 数据库里没有文章时 -->
    <p v-else-if="posts.length === 0" class="empty">还没有文章,敬请期待。</p>

    <!-- 有文章时列表展示,点标题进入对应详情页 -->
    <ul v-else class="article-list">
      <li v-for="p in posts" :key="p.id" class="article-item">
        <div class="article-main">
          <span class="date">{{ p.date }}</span>
          <router-link class="title" :to="`/blog/${p.id}`">{{ p.title }}</router-link>
        </div>
        <p class="desc">{{ p.summary }}</p>
      </li>
    </ul>
  </div>
</template>

<style scoped>
.page {
  max-width: 800px;
  margin: 0 auto;
  padding: 96px 24px 48px; /* 顶部留出导航栏高度 */
}

h2 {
  font-size: 28px;
  margin-bottom: 40px;
  padding-left: 12px;
  border-left: 4px solid #000;
}

.empty {
  color: #999;
  font-size: 16px;
}

.article-list {
  list-style: none;
}
.article-item {
  padding: 16px 0;
  border-bottom: 1px solid #f0f0f0;
}
.article-main {
  display: flex;
  align-items: baseline;
  gap: 16px;
}
.article-item .title {
  font-size: 18px;
  color: #333;
  text-decoration: none;
}
.article-item .title:hover {
  color: #000;
}
.article-item .date {
  color: #aaa;
  font-size: 13px;
}
.article-item .desc {
  color: #888;
  font-size: 14px;
  margin-top: 6px;
}
</style>
