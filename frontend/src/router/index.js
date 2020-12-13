import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
//import Home from '@/components/Home'
import Login from '../components/Login'
import Register from '../components/Register'

Vue.use(VueRouter)

const routes = [{
        path: '/',
        name: 'home',
        component: Home
    },
    {
        path: '/login',
        name: 'Login',
        component: Login,
    },
    {
        path: '/register',
        name: 'Register',
        component: Register,
    },
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

// 페이지 열기 전에 항상 수행 : 로그인 필요한 페이지인가? 로그인 했는가?
router.beforeEach((to, from, next) => {
    const publicPages = ['Login', 'Register']; // 로그인이 필요 없는 페이지
    const authRequired = !publicPages.includes(to.name); // 로그인이 필요한 페이지
    const loggedIn = localStorage.getItem('user'); // 로그인 한 경우 localStorage에 유저 정보가 있음

    if (authRequired && !loggedIn) {
        router.push({ name: 'Login', query: { to: to.path } }); // 로그인 필수이며 로그인하지 않은 경우 강제 이동
    } else {
        next();
    }
});

export default router