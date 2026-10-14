<script setup lang="ts">
// 头像:从 src/assets 目录引入这张图片
import avatar from '@/assets/NiuMa.jpeg'

// ========== 个人信息 ==========
const profile = {
  name: 'Sleep8h',
  tagline: 'AI 全栈 / AI 应用开发', // 一句话方向
  avatar,
}

// ========== 联系方式 ==========
const contacts = [
  { label: 'GitHub', value: 'github.com/LetMeSleep8h', link: 'https://github.com/LetMeSleep8h' },
  { label: 'Email', value: 'dhsm20230725@163.com', link: 'mailto:dhsm20230725@163.com' },
]
</script>

<template>
  <section class="home">
    <!-- 左边:头像 -->
    <div class="avatar">
      <img v-if="profile.avatar" :src="profile.avatar" :alt="profile.name" />
      <span v-else>{{ profile.name.charAt(0) }}</span>
    </div>

    <!-- 右边:个人信息 -->
    <div class="info">
      <h1>{{ profile.name }}</h1>
      <p class="tagline">{{ profile.tagline }}</p>

      <ul class="contact-list">
        <li v-for="c in contacts" :key="c.label">
          <span>{{ c.label }}</span>
          <a :href="c.link">{{ c.value }}</a>
        </li>
      </ul>
    </div>
  </section>
</template>

<style scoped>
.home {
  min-height: 100vh; /* 撑满一屏 */
  max-width: 1100px;
  margin: 0 auto;
  display: flex;
  align-items: center;
  gap: 100px;
  padding: 96px 48px 48px; /* 顶部给导航留空间 */
}

/* ---- 左边:头像(黑白圆形) ---- */
.avatar {
  width: 280px;
  height: 280px;
  border-radius: 50%;
  overflow: hidden;
  background: #000; /* 占位头像:黑色底 */
  border: 1px solid #ddd;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-shrink: 0;
}
.avatar img {
  width: 100%;
  height: 100%;
  object-fit: cover; /* 图片不变形,裁切成圆形 */
}
.avatar span {
  color: #fff;
  font-size: 110px;
  font-weight: 700;
}

/* ---- 右边:个人信息 ---- */
.info h1 {
  font-size: 60px;
  font-weight: 700;
  margin-bottom: 16px;
}
.tagline {
  color: #666;
  font-size: 24px;
  margin-bottom: 40px;
}

.contact-list {
  list-style: none;
}
.contact-list li {
  display: flex;
  padding: 10px 0;
  font-size: 17px;
}
.contact-list span {
  width: 100px;
  color: #999;
  flex-shrink: 0;
}
.contact-list a {
  color: #000;
  text-decoration: none;
  border-bottom: 1px solid transparent;
}
.contact-list a:hover {
  border-bottom-color: #000;
}

/* ---- 窄屏时头像和文字上下排 ---- */
@media (max-width: 900px) {
  .home {
    flex-direction: column;
    justify-content: center;
    text-align: center;
    gap: 40px;
  }
  .contact-list li {
    justify-content: center;
  }
}
</style>
