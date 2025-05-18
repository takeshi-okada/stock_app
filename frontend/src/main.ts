import { createApp } from 'vue';
import VueToast from 'vue-toast-notification';
import 'vue-toast-notification/dist/theme-bootstrap.css';
import { AllCommunityModule, ModuleRegistry } from 'ag-grid-community'; 
import { AgGridVue } from 'ag-grid-vue3';

import './index.css';
import App from './App.vue';
import { createRouter } from './route';

ModuleRegistry.registerModules([AllCommunityModule]);
const app = createApp(App);
app.component('AgGridVue', AgGridVue);
app.use(VueToast).use(createRouter("history")).mount('#app');
