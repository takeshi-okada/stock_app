import * as VueRouter from "vue-router";
import Login from "../pages/Login.vue";
import NewRegister from "../pages/NewRegister.vue";
import Home from "../pages/Home.vue";
import Dashboad from "../components/Dashboad.vue";
import Assets from "../components/Assets.vue";

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
        path: "/dashboad",
        name: "dashboad",
        component: Dashboad
      },
      {
        path: "/assets",
        name: "assets",
        component: Assets
      }
    ]
  }
];

export const createRouter = (type: "memory" | "history") => {
  const history = type === "memory" ? VueRouter.createMemoryHistory() : VueRouter.createWebHistory();
  return VueRouter.createRouter({ history, routes });
};