import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.use(ElementUI);

Vue.config.productionTip = false

import axios from 'axios';
axios.defaults.baseURL = "http://localhost:8081"
Vue.prototype.axios = axios

new Vue({
  router : router,
  render: h => h(App)
}).$mount('#app')
