import { reactive } from 'vue'
import axios from 'axios'

// 后端返回的原始结构(对应 article 表)
interface RawArticle {
  id: number
  title: string
  content: string
  articleTime?: string | null
  isDelete?: number | null
}

// 页面使用的结构
export interface Post {
  id: number
  title: string
  date: string
  summary: string // 列表页显示的一句话简介
  content: string
}

// 所有文章缓存在这里,博客列表页和详情页共用同一份数据
export const posts = reactive<Post[]>([])

// 向后端要所有文章(进入"个人博客"页面时调用一次,每次都重新扫描数据库)
export async function loadPosts(): Promise<void> {
  // 相对路径:本地开发由 Vite 代理转发到 8080,线上由 Spring Boot 同源提供
  const { data } = await axios.get<RawArticle[]>('/list')
  posts.splice(
    0,
    posts.length,
    ...data.map((a) => ({
      id: a.id,
      title: a.title,
      date: (a.articleTime ?? '').slice(0, 10), // 2026-09-03 只留日期
      summary: (a.content ?? '').replace(/\s+/g, ' ').trim().slice(0, 80),
      content: a.content ?? '',
    }))
  )
}
