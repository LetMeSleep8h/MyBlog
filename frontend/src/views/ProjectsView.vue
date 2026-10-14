<script setup lang="ts">
// 项目列表:点卡片跳到对应 GitHub 页面
// 以后加项目就往这个数组里加一条
const projects = [
  { name: 'TickGo', link: 'https://github.com/LetMeSleep8h/TickGo' },
  { name: 'Bovin', link: 'https://github.com/LetMeSleep8h/Bovin' },
]
</script>

<template>
  <div class="page">
    <h2>项目展示</h2>
    <div class="project-grid">
      <!-- target="_blank" 表示新标签打开;rel 防止安全漏洞 -->
      <a
        v-for="p in projects"
        :key="p.name"
        :href="p.link"
        target="_blank"
        rel="noopener noreferrer"
        class="project-card"
      >
        <h3>{{ p.name }}<span class="arrow">↗</span></h3>
      </a>
    </div>
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

.project-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
  gap: 16px;
}
.project-card {
  border: 1px solid #eee;
  border-radius: 8px;
  padding: 28px 24px;
  display: flex;
  align-items: center;
  text-decoration: none;
  color: #333;
  transition: all 0.2s;
}
.project-card:hover {
  border-color: #000;
  transform: translateY(-2px);
}
.project-card h3 {
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-size: 17px;
}
.arrow {
  color: #bbb;
  font-size: 14px;
  transition: color 0.2s;
}
.project-card:hover .arrow {
  color: #000;
}
</style>
