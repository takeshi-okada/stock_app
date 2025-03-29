import { createApp } from 'vue';
import './index.css';
import App from './App.vue';
import { createRouter } from './route';
import VueToast from 'vue-toast-notification';
import 'vue-toast-notification/dist/theme-bootstrap.css';

createApp(App).use(VueToast).use(createRouter("history")).mount('#app');
