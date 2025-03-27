import * as VueRouter from "vue-router";
import Login from "../pages/Login.vue";
import NewRegister from "../pages/NewRegister.vue";
import Home from "../pages/Home.vue";

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
    component: Home
  }
];

export const createRouter = (type: "memory" | "history") => {
  const history = type === "memory" ? VueRouter.createMemoryHistory() : VueRouter.createWebHistory();
  return VueRouter.createRouter({ history, routes });
};