<script setup lang="ts">
import { ref } from 'vue'
import axios from 'axios'

const password = ref('')
const title = ref('')
const content = ref('')
const submitting = ref(false)
const result = ref('')

// 提交到后端的隐藏接口 /admin/add(发 password、title、content)
// 口令不对,后端会拒绝(返回 401)
async function submit() {
  result.value = ''
  if (!password.value) {
    result.value = '请输入口令'
    return
  }
  if (!title.value.trim() || !content.value.trim()) {
    result.value = '标题和内容不能为空'
    return
  }
  submitting.value = true
  try {
    const res = await axios.post(
      '/admin/add',
      new URLSearchParams({
        password: password.value,
        title: title.value,
        content: content.value,
      })
    )
    result.value = res.data // 后端返回的 "成功"
    title.value = ''
    content.value = ''
  } catch (e: any) {
    // 401 时后端会返回"密码错误"
    result.value = e?.response?.data ?? '提交失败:' + (e?.message ?? '未知错误')
  } finally {
    submitting.value = false
  }
}
</script>

<template>
  <div class="page">
    <h2>发布文章</h2>

    <input v-model="password" type="password" class="field" placeholder="口令" />
    <input v-model="title" class="field" placeholder="标题" />
    <textarea v-model="content" class="field" placeholder="内容(支持换行)" rows="12"></textarea>

    <button :disabled="submitting" @click="submit">
      {{ submitting ? '提交中...' : '发布' }}
    </button>

    <p v-if="result" class="result">{{ result }}</p>
  </div>
</template>

<style scoped>
.page {
  max-width: 600px;
  margin: 0 auto;
  padding: 96px 24px 48px; /* 顶部给导航留空间 */
}

h2 {
  font-size: 28px;
  margin-bottom: 32px;
  padding-left: 12px;
  border-left: 4px solid #000;
}

.field {
  width: 100%;
  box-sizing: border-box;
  margin-bottom: 16px;
  padding: 12px 14px;
  border: 1px solid #ddd;
  border-radius: 6px;
  font-size: 15px;
  font-family: inherit;
  outline: none;
}
.field:focus {
  border-color: #000;
}

textarea.field {
  resize: vertical;
  line-height: 1.6;
}

button {
  padding: 12px 28px;
  background: #000;
  color: #fff;
  border: none;
  border-radius: 6px;
  font-size: 15px;
  cursor: pointer;
}
button:hover {
  background: #333;
}
button:disabled {
  opacity: 0.6;
  cursor: not-allowed;
}

.result {
  margin-top: 16px;
  font-size: 14px;
  color: #666;
}
</style>
