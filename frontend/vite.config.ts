import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueDevTools from 'vite-plugin-vue-devtools'

// https://vite.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    vueDevTools(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
    },
  },
  server: {
    // 本地开发时,把前端页面发起的相对请求(/list /admin/add)转发到本机后端 8080
    proxy: {
      '/list': {
        target: 'http://localhost:8080',
        changeOrigin: true,
      },
      '/admin/add': {
        target: 'http://localhost:8080',
        changeOrigin: true,
      },
    },
  },
})
