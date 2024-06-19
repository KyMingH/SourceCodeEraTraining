
import router from './router';
<template>
  <div id="app">
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link> |
      <router-link to="/student">学生管理</router-link>
    </nav>
    <router-view/>
  </div>
</template>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /* text-align: center; */
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}

/* 将#app设置为Flex容器，实现居中 */
#app {
  display: flex;
  flex-direction: column; /* 设置主轴方向为垂直 */
  align-items: center; /* 水平居中所有子元素 */
  justify-content: flex-start; /* 垂直方向上默认从上开始排列 */
  min-height: 100vh; /* 设置最小高度为视窗高度 */
  padding: 20px; /* 根据需要添加内边距 */
  box-sizing: border-box; /* 边框计算在宽度内 */
}

/* 导航栏样式 */
#app nav {
  text-align: center; /* 使链接文本居中 */
  margin-bottom: 20px; /* 导航栏和内容区域的间隔 */
}

/* 链接样式 */
#app nav a {
  margin: 0 10px; /* 链接之间的间隔 */
  text-decoration: none; /* 移除下划线 */
}

/* 确保router-view的内容也居中显示 */
#app > router-view {
  width: 100%; /* 宽度设为100% */
  max-width: 1200px; /* 可以设置最大宽度，根据需要调整 */
  padding: 0 20px; /* 内边距 */
  box-sizing: border-box; /* 边框计算在宽度内 */
}
</style>