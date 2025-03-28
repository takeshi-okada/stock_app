<script setup lang="ts">
import { ref, reactive } from 'vue';
import { loginUserService } from '../services/LoginService.ts';
import { useRouter } from 'vue-router';

const router = useRouter();
const inputUserId = ref('');
const inputUserPassword = ref('');

const handleLogin = async () => {
    const param = {
        userId: inputUserId.value,
        userPassword: inputUserPassword.value,
    }
    loginUserService(param).then(result => {
        console.log(result.data);
        router.push('/home');
    }).catch(err => {
        console.log(err);
    });
}
</script>

<template>
 <div class="bg-gray-100 min-h-screen flex items-center justify-center">
    <div class="bg-white p-8 rounded-lg shadow-lg w-96">
        <h2 class="text-2xl font-bold mb-6 text-center text-gray-800">ログイン</h2>
        <form @submit.prevent="handleLogin">
            <div class="mb-4">
                <label for="id" class="block text-sm font-medium text-gray-700">ログインID</label>
                <input
                    type="text"
                    id="id"
                    v-model="inputUserId"
                    name="id"
                    required
                    class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm"
                />
            </div>
            <div class="mb-6">
                <label for="password" class="block text-sm font-medium text-gray-700">パスワード</label>
                <input
                    type="password"
                    id="password"
                    v-model="inputUserPassword"
                    name="password"
                    required
                    class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm" 
                />
            </div>
            <button type="submit" class="w-full bg-sky-500 text-white py-2 px-4 rounded-md shadow hover:bg-sky-600">
                ログイン
            </button>
        </form>
        <router-link to="/new_register" class="block text-sm text-right mt-4">
            新規ユーザ登録はこちら
        </router-link>
    </div>
 </div> 
</template>

<style scoped>

</style>
