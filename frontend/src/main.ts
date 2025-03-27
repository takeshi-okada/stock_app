import { createApp } from 'vue';
import './index.css';
import App from './App.vue';
import { createRouter } from './route';

createApp(App).use(createRouter("history")).mount('#app');
