import * as VueRouter from "vue-router";
import Login from "../pages/Login.vue";
import NewRegister from "../pages/NewRegister.vue";
import Home from "../pages/Home.vue";

import Assets from "../components/Assets.vue";
import StockSearch from "../components/StockSearch.vue";
import DividendManagement from "../components/DividendManagement.vue";

const routes: VueRouter.RouteRecordRaw[] = [
  {
    path: "/",
    name: "Login",
    component: Login,
  },
  {
    path: "/new_register",
    name: "NewRegister",
    component: NewRegister
  },
  {
    path: "/home",
    name: "home",
    component: Home,
    children: [
      {
        path: "/assets",
        name: "assets",
        component: Assets
      },
      {
        path: "/dividend-management",
        name: "dividendManagement",
        component: DividendManagement
      },
      {
        path: "/stock-search",
        name: "stockSearch",
        component: StockSearch
      },
      
    ]
  }
];

export const createRouter = (type: "memory" | "history") => {
  const history = type === "memory" ? VueRouter.createMemoryHistory() : VueRouter.createWebHistory();
  return VueRouter.createRouter({ history, routes });
};